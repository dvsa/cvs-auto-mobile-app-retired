package util;

import exceptions.AutomationException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

                    String string2 = list.stream()
                            .map(n -> n.toString())
                            .collect(Collectors.joining(","));
                    fileChannel
                            .write(Charset.defaultCharset().encode(CharBuffer.wrap(string2 + ",END")));
                    fileChannel.force(true);
                    Thread.sleep(1000);


                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    fileLock.release();
                }

            } else {
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

        String username = null;



        try {
            List<String> myNewList = null;


            ByteBuffer bytes = ByteBuffer.allocate(500);
            int noOfBytesRead = fileChannel.read(bytes);
            StringBuilder users = new StringBuilder();

            Thread.sleep(5000);
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

            username = myNewList.get(0);

            if (TypeLoader.getType().getEnvType().equalsIgnoreCase(CI_ENV)) {
                myNewList.remove(myNewList.get(0));
            }

            String string2 = myNewList.stream()
                    .map(n -> n.toString())
                    .collect(Collectors.joining(","));

            fileChannel
                    .write(Charset.defaultCharset().encode(CharBuffer.wrap(string2)));
            fileChannel.force(true);

            Thread.sleep(1000);

            lock.release();
            if (myNewList.get(0).equalsIgnoreCase("END")) {
                fileChannel.close();
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            throw new AutomationException("Initializing users failed");
        }

        return username;
    }

}
