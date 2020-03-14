package util;

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

public class BaseUtils {

    private static String userName;
    private static final String CI_ENV = "CI";
    private static File mainFile = new File("userPool.txt");
    private static final FileChannel fileChannel;
    private static List<String> list = new ArrayList<>(Arrays.asList(TypeLoader.getAppUsername().split(",")));


    static {

        try {

            File file = new File("userPool.txt");
            boolean fileExists = file.exists();
            fileChannel = new RandomAccessFile(mainFile, "rw").getChannel();
            FileLock fileLock = fileChannel.lock();
            if (!fileExists) {

                try {
                    mainFile.createNewFile();
                    userName = list.get(0);
                    if (TypeLoader.getType().getEnvType().equalsIgnoreCase(CI_ENV)) {
                        list.remove(userName);
                    }

                    String string2 = String.join(",", list);
                    fileChannel
                            .write(Charset.defaultCharset().encode(CharBuffer.wrap(string2)));
                    fileChannel.force(true);
                    Thread.sleep(1000);


                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    fileLock.release();
                }

            }
            else {
                while (!file.canRead() && !file.canWrite()) {
                    try {
                        Thread.sleep(250);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                userName = getUser(fileLock);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new AutomationException("User Pool file was not found");
        } catch (IOException e) {
            e.printStackTrace();
            throw new AutomationException("User Pool file cannot be read");
        }

    }


    public static String getUserName() {
        return userName;
    }


    private static String getUser(FileLock lock) {

        String username;

        try {
            List<String> myNewList;


            ByteBuffer bytes = ByteBuffer.allocate(500);
            int noOfBytesRead = fileChannel.read(bytes);
            StringBuilder users = new StringBuilder();

            Thread.sleep(1000);
            while (noOfBytesRead != -1) {
                bytes.flip();
                while (bytes.hasRemaining()) {
                    users.append((char) bytes.get());
                }
                bytes.clear();
                noOfBytesRead = fileChannel.read(bytes);
            }

            fileChannel.truncate(0);

            myNewList = new ArrayList<>(Arrays.asList(users.toString().split(",")));
            for (String s : myNewList) {
                System.out.println("=======================================================");
                System.out.println(s);
            }


            if (myNewList.isEmpty()) {
                lock.release();
                fileChannel.close();
                throw new AutomationException("User pool is empty");
            }
            else {
                username = myNewList.get(0);
                if (TypeLoader.getType().getEnvType().equalsIgnoreCase(CI_ENV)) {
                    myNewList.remove(myNewList.get(0));
                }
                String string2 = String.join(",", myNewList);
                fileChannel
                        .write(Charset.defaultCharset().encode(CharBuffer.wrap(string2)));
                fileChannel.force(true);

                Thread.sleep(1000);

                lock.release();
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            throw new AutomationException("Initializing users failed");
        }

        return username;
    }

}
