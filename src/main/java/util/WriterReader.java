package util;

import exceptions.AutomationException;

import java.io.*;

public class WriterReader {


    private static String username = new FileLocking().getUsernameFromQueue();

    private static final String FILE_NAME = username + ".txt";

    public static void saveUtils() {

        FileUtils p1 = new FileUtils(WebDriverBrowsertack.getToken(username));
        try (FileOutputStream f = new FileOutputStream(new File(FILE_NAME)); ObjectOutputStream o = new ObjectOutputStream(f)) {

            o.writeObject(p1);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new AutomationException("File Utils not found");
        } catch (IOException e) {
            e.printStackTrace();
            throw new AutomationException("Error initializing stream");
        }
    }

    public static String getToken() {

        new FileLocking().deleteFileToken(username);

        FileUtils fileUtils;
        File file = new File(FILE_NAME);
        saveUtils();

        try (FileInputStream fi = new FileInputStream(file); ObjectInputStream oi = new ObjectInputStream(fi)) {
            fileUtils = (FileUtils) oi.readObject();

        } catch (IOException e) {
            e.printStackTrace();
            throw new AutomationException("File Utils not found");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new AutomationException("Error initializing stream");
        }
        return fileUtils.getToken();
    }

    public static void main(String[] args) {
        getToken();
    }

}
