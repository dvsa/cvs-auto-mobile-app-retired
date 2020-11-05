package util;
import java.io.*;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileLocking
{
    private static final File file = new File("user_pool.txt");


    public String getUsernameFromQueue()
    {
        String username = null;
        do {
            synchronized (file) {
                List<String> queue = new ArrayList(readQueue());
                if (queue.size() > 0) {
                    username = queue.get(0);
                    queue.remove(0);
                    writeQueue(queue);
                }
            }
        }
        while(username == null);
        System.out.println("GET "+username);
        return username;
    }

    public void putUsernameInQueue(String username)
    {
        synchronized (file) {
            System.out.println("PUT "+username);
            List<String> queue = new ArrayList(readQueue());
            queue.add(username);
            writeQueue(queue);
        }
    }

    private List<String> readQueue()
    {
        List<String> queue = null;
        try {
            BufferedReader in = new BufferedReader(new FileReader(file));

            String[] ar = new String[0];
            String str;
            while ((str = in.readLine()) != null) {
                ar = str.split(",");
            }
            queue = Arrays.asList(ar);
            in.close();
        } catch (IOException e) {
            System.out.println("File Read Error");
        }
        return queue;
    }

    private void writeQueue(List<String> queue){

        FileOutputStream fos = null;
        FileLock lock = null;
        try {
            fos = new FileOutputStream(file);
            lock = fos.getChannel().lock();

            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
            bw.write(String.join(",", queue));
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void deleteFileToken(String username){
        File myObj = new File(username + ".txt");
        if (myObj.delete()) {
            System.out.println("Deleted the file: " + myObj.getName());
        }
    }
}