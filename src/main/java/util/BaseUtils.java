package util;

import exceptions.AutomationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;

public class BaseUtils {

    private static Logger logger = LoggerFactory.getLogger(BaseUtils.class);
    private static String userName;
    private static final String CI_ENV = "CI";
    private static File userPoolFile = new File("userPool.txt");
    private static final FileChannel fileChannel;
    private static final ArrayList<String> list = new ArrayList<String>(Arrays.asList(TypeLoader.getAppUsername().split(",")));


    static {
        logger.debug("Initializing BaseUtils class");
        try {

            File file = new File("userPool.txt");
            boolean fileExists = file.exists();
            fileChannel = new RandomAccessFile(userPoolFile, "rw").getChannel();
            FileLock fileLock = fileChannel.lock();
            if (!fileExists) {
                try {
                    userPoolFile.createNewFile();
                    userName = list.get(0);
                    logger.debug("the userName was set to: {}", userName);
                    if (TypeLoader.getType().getEnvType().equalsIgnoreCase(CI_ENV)) {

                        // TODO for debugging purposes - please remove
                        printUserList(list);

                        logger.debug("removing userName: {} from the user list", userName);
                        list.remove(userName);
                    }

                    // TODO for debugging purposes - please remove
                    printUserList(list);

                    String string2 = String.join("," , list);
                    logger.debug("writing the list back into the file: {}", string2);
                    fileChannel
                            .write(Charset.defaultCharset().encode(CharBuffer.wrap(string2)));
                    fileChannel.force(true);
                    Thread.sleep(1000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    fileLock.release();
                }

            } else {
                while (!file.canRead() || !file.canWrite()) {
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                logger.info("getting a user name from the pool file");
                userName = getUser(fileLock);
                logger.debug("userName is: {}", userName);
            }

        } catch (IOException e) {
            e.printStackTrace();
            throw new AutomationException("User Pool file was not found");
        }

    }


    public static String getUserName() {
        logger.debug("retrieving the current user name: {}", userName);
        return userName;
    }


    private static String getUser(FileLock lock) {
        String userName;
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

            ArrayList<String> userList = new ArrayList<>(Arrays.asList(users.toString().split(",")));

            printUserList(userList);

            userName = userList.get(0);

            if (userList.isEmpty()) {
                lock.release();
                fileChannel.close();
                try {
                    Thread.sleep(1000);
                    getUser(lock);
                } catch (Exception e) {
                    throw new AutomationException("User pool is empty: " + e.getMessage());
                }

            } else {

                if (TypeLoader.getType().getEnvType().equalsIgnoreCase(CI_ENV)) {
                    userList.remove(userList.get(0));
                }
                String string2 = String.join(",", userList);
                fileChannel
                        .write(Charset.defaultCharset().encode(CharBuffer.wrap(string2)));
                fileChannel.force(true);
                Thread.sleep(1000);

                lock.release();
                if (userList.isEmpty()) {
                    fileChannel.close();
                }
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            throw new AutomationException("Initializing users failed");
        }

        return userName;
    }

    static void addCurrentUserBackToUserPool() {
        logger.info ("adding users back in the pool file");
        if (TypeLoader.getType().getEnvType().equalsIgnoreCase(CI_ENV)) {

            boolean fileExists = userPoolFile.exists();
            if (!fileExists) {
                throw new AutomationException("User pool file does not exist");
            } else {
                try {
                    FileChannel fileChannel = new RandomAccessFile(userPoolFile, "rw").getChannel();
                    FileLock lock = fileChannel.lock();
                    while (!userPoolFile.canRead() || !userPoolFile.canWrite()) {
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
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
                    ArrayList<String> userList = new ArrayList<>();
                    if (users.length() != 0) {
                        userList = new ArrayList<>(Arrays.asList(users.toString().split(",")));
                    }
                    logger.debug("====================== Before adding LIST =================================");
                    // TODO for debugging purposes - please remove
                    printUserList(userList);
                    logger.debug("====================== END OF CURRENT LIST =================================");
                    if(!userList.contains(userName)) {
                        userList.add(0, userName);
                        logger.debug("user {} was added back to the userPool", userName);
                    }
                    else{
                        logger.debug("user name {} already exists in the userPool !", userName);
                    }

                    logger.debug("====================== After adding LIST =================================");
                    // TODO for debugging purposes - please remove
                    printUserList(userList);
                    logger.debug("====================== END OF CURRENT LIST =================================");

                    String string2 = String.join(",", userList);
                    fileChannel
                            .write(Charset.defaultCharset().encode(CharBuffer.wrap(string2)));
                    fileChannel.force(true);

                    Thread.sleep(1000);

                    lock.release();

                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                    throw new AutomationException("Adding back users in user pool failed");
                }
            }
        }
    }

    // used for debugging purposes
    private static void printUserList(ArrayList<String> list){
        logger.debug("printing user list: ");
        for(String element : list){
            logger.debug("elementul: " + list.indexOf(element) + " - " + element );
        }
        logger.debug("end list ");
    }

}
