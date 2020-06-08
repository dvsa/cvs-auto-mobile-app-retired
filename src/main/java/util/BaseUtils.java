package util;

import com.sun.tools.internal.xjc.model.CElement;
import exceptions.AutomationException;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class BaseUtils {

    private static String userName;
    private static String currentUser;
    private static Stack<String> userPool = new Stack<>();
    private static final String CI_ENV = "CI";
    private static File mainFile = new File("userPool.txt");
    private static final FileChannel fileChannel;
    private static List<String> list = new ArrayList<>(Arrays.asList(TypeLoader.getAppUsername().split(",")));

    static {

//        try {
//            System.out.println("\nDEBUG: inside BaseUtils");
//            File file = new File("userPool.txt");
//            fileChannel = new RandomAccessFile(mainFile, "rw").getChannel();
//            FileLock fileLock = fileChannel.lock();
//            if (!file.exists()) {
//                try {
//                    mainFile.createNewFile();
//                    userName = list.get(0);
//                    if (TypeLoader.getType().getEnvType().equalsIgnoreCase(CI_ENV)) {
//
//                        // TODO please remove
//                        System.out.println("\nDEBUG: list of users: ");
//                        for(String element:list){
//                            System.out.println("\nDEBUG: element of list: " + element);
//                        }
//                        System.out.println("\nDEBUG: removing userName:" + userName);
//                        list.remove(userName);
//                    }
//
//                    String string2 = String.join(",", list);
//                    System.out.println("\nDEBUG: Writing back to file: " + string2);
//                    fileChannel
//                            .write(Charset.defaultCharset().encode(CharBuffer.wrap(string2 + ",END")));
//                    fileChannel.force(true);
//                    Thread.sleep(1000);
//
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                } finally {
//                    fileLock.release();
//                }
//
//            } else {
//                while (!file.canRead() || !file.canWrite()) {
//                    try {
//                        Thread.sleep(50);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//                userName = getUser(fileLock);
//                System.out.println("\nDEBUG: userName is: " + userName);
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//            throw new AutomationException("User Pool file was not found");
//        }
//
//    }

        try {
            System.out.println("\nDEBUG: inside BaseUtils");

            File file = new File("userPool.txt");

            fileChannel = new RandomAccessFile(mainFile, "r").getChannel();

            // file does not exist
            if (!file.exists()) {
                // adding the current user to the stack
                    userPool.addAll(list);
                System.out.println("=============== ADDED LIST TO THE STACK (file doesn't exist) ================");
                printStack(userPool);
            }
            // file exists
            else {
                // wait until it's readable
                while (!file.canRead() || !file.canWrite()) {
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                // reading the file
                try {
                    ByteBuffer bytes = ByteBuffer.allocate(500);
                    int noOfBytesRead = fileChannel.read(bytes);
                    StringBuilder users = new StringBuilder();

                    Thread.sleep(2000);
                    while (noOfBytesRead != -1) {
                        bytes.flip();
                        while (bytes.hasRemaining()) {
                            users.append((char) bytes.get());
                        }
                        bytes.clear();
                        noOfBytesRead = fileChannel.read(bytes);
                    }

                    fileChannel.truncate(0);
                    // adding users from the file to the stack
                    userPool.addAll(new ArrayList<>(Arrays.asList(users.toString().split(","))));
                    System.out.println("=============== ADDED LIST TO THE STACK (file exists) ================");
                    printStack(userPool);
                }
                catch(Exception e){
                    System.out.println("Exception: " + e.getMessage());
                    e.printStackTrace();
                }
                System.out.println("\nDEBUG: userName is: " + userName);
            }

            // set current user
            userPool.removeIf(element -> element.equalsIgnoreCase("END"));
            printStack(userPool);
            while(userPool.isEmpty()){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            currentUser = userPool.pop();
            System.out.println("=============== CURRENT USER IS: " + currentUser + " ================");

        } catch (IOException e) {
            e.printStackTrace();
            throw new AutomationException("User Pool file was not found");
        }

    }

    public static String getUserName() {

        return currentUser;
    }


//    private static String getUser(FileLock lock) {
//
//        String username;
//
//        try {
//            List<String> myNewList;
//            System.out.println("\nDEBUG: Inside getUser");
//
//            //TODO please remove
//            System.out.println("\nDEBUG: myNewList: ");
//
//            for(String element:myNewList){
//                System.out.println("\nDEBUG: elementul: " + myNewList.indexOf(element) + " - " + element );
//            }
//
//            username = myNewList.get(0);
//
//            System.out.println("====================== CURRENT LIST =================================");
//            for (String s : myNewList) {
//                System.out.println(s);
//            }
//            System.out.println("====================== END OF CURRENT LIST =================================");
//
//            if (myNewList.get(0).equalsIgnoreCase("END")) {
//                System.out.println("\nDEBUG: down to the last element ");
//                lock.release();
//                fileChannel.close();
//                try {
//                    Thread.sleep(1000);
//                    recursion_counter++;
//                    System.out.println("\nDEBUG: re-trying after 1 second.. retry no: " + recursion_counter);
//                    getUser(lock);
//                } catch (Exception e) {
//                    throw new AutomationException("User pool is empty: " + e.getMessage());
//                }
//
//            } else {
//
//                if (TypeLoader.getType().getEnvType().equalsIgnoreCase(CI_ENV)) {
//                    myNewList.remove(myNewList.get(0));
//                }
//                String string2 = String.join(",", myNewList);
//                fileChannel
//                        .write(Charset.defaultCharset().encode(CharBuffer.wrap(string2)));
//                fileChannel.force(true);
//                Thread.sleep(1000);
//                lock.release();
//                if (myNewList.get(0).equalsIgnoreCase("END")) {
//                    fileChannel.close();
//                }
//            }
//
//        } catch (IOException | InterruptedException e) {
//            e.printStackTrace();
//            throw new AutomationException("Initializing users failed");
//        }
//        recursion_counter = 0;
//        return username;
//    }

//    public static void addCurrentUserBackToUserPool() {
//        System.out.println("\nDEBUG: adding users back in the pool file ");
//        if (TypeLoader.getType().getEnvType().equalsIgnoreCase(CI_ENV)) {
//
//            boolean fileExists = mainFile.exists();
//            if (!fileExists) {
//                throw new AutomationException("User pool file does not exist");
//            } else {
//                try {
//                    FileChannel fileChannel = new RandomAccessFile(mainFile, "rw").getChannel();
//                    FileLock lock = fileChannel.lock();
//                    while (!mainFile.canRead() || !mainFile.canWrite()) {
//                        try {
//                            Thread.sleep(50);
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                    ByteBuffer bytes = ByteBuffer.allocate(500);
//                    int noOfBytesRead = fileChannel.read(bytes);
//                    StringBuilder users = new StringBuilder();
//
//                    Thread.sleep(2000);
//                    while (noOfBytesRead != -1) {
//                        bytes.flip();
//                        while (bytes.hasRemaining()) {
//                            users.append((char) bytes.get());
//                        }
//                        bytes.clear();
//                        noOfBytesRead = fileChannel.read(bytes);
//                    }
//
//                    fileChannel.truncate(0);
//                    List<String> myNewList = new ArrayList<>();
//                    if (users.length() != 0) {
//                        myNewList = new ArrayList<>(Arrays.asList(users.toString().split(",")));
//                    }
//                    System.out.println("====================== Before adding LIST =================================");
//                    for (String s : myNewList) {
//                        System.out.println(s);
//                    }
//                    System.out.println("====================== END OF CURRENT LIST =================================");
//                    myNewList.add(0, userName);
//                    System.out.println("\nDEBUG: user: " + userName + " was returned to the pool file ");
//                    System.out.println("====================== After adding LIST =================================");
//                    for (String s : myNewList) {
//                        System.out.println(s);
//                    }
//                    System.out.println("====================== END OF CURRENT LIST =================================");
//
//                    String string2 = String.join(",", myNewList);
//                    fileChannel
//                            .write(Charset.defaultCharset().encode(CharBuffer.wrap(string2)));
//                    fileChannel.force(true);
//
//                    Thread.sleep(1000);
//
//                    lock.release();
//
//                } catch (IOException | InterruptedException e) {
//                    e.printStackTrace();
//                    throw new AutomationException("Adding back users in user pool failed");
//                }
//            }
//        }
//    }

    public static void addCurrentUserBackToUserPool(){
        System.out.println("=============== CURRENT USER: " + currentUser + " IS RETURNED TO THE POOL ================");
        userPool.push(currentUser);
        printStack(userPool);

    }

    public static void printStack(Stack<String> pool){
        for (String user:pool) {
            System.out.println("\n userPool is:");
            System.out.println("user no: " + pool.indexOf(user) + "is: " + user);
            System.out.println("\n end of userPool");
        }
    }

    public static void printArray(ArrayList<String> list){
        for (String user:list) {
            System.out.println("\n list of users is:");
            System.out.println("user no: " + list.indexOf(user) + "is: " + user);
            System.out.println("\n end of list");
        }
    }
}
