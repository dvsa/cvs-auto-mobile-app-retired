package util;

import exceptions.AutomationException;

import java.io.File;
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

public class AfterClassUtils {

    private static String userName = BaseUtils.getUserName();;
    private static final String CI_ENV = "CI";
    private static File mainFile = new File("userPool.txt");

    public static void addUserBackToUserPool() {
        if (TypeLoader.getType().getEnvType().equalsIgnoreCase(CI_ENV)) {

            boolean fileExists = mainFile.exists();
            if (!fileExists) {
                throw new AutomationException("User pool file does not exist");
            } else {
                try {
                    FileChannel fileChannel = new RandomAccessFile(mainFile, "rw").getChannel();
                    FileLock lock = fileChannel.lock();
                    while (!mainFile.canRead() && !mainFile.canWrite()) {
                        try {
                            Thread.sleep(250);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
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
                    List<String> myNewList = new ArrayList<>();
                    if (users.length() != 0) {
                        myNewList = new ArrayList<>(Arrays.asList(users.toString().split(",")));
                    }
                    myNewList.add(userName);
                    String string2 = String.join(",", myNewList);
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
}
