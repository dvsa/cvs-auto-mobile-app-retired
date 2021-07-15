package util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static java.lang.Math.min;
import static java.lang.Thread.sleep;

public class FileLocking
{
    private static final File file = new File("user_pool.txt");
    Logger logger = LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);

    static {
        FileOutputStream fos = null;
        if (!file.exists()) {
            try {
                file.createNewFile();
                fos = new FileOutputStream(file);
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
                List<String> items = new ArrayList<>(TypeLoader.getUsers().keySet());
                bw.write(String.join(",", items.subList(0, min(items.size(),TypeLoader.getNumberConcurrentJob()))));
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
    }

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
            try {
                sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        while(username == null);
        logger.info("GET " + username);
        return username;
    }

    public void putUsernameInQueue(String username)
    {
        synchronized (file) {
            logger.info("PUT "+username);
            List<String> queue = new ArrayList(readQueue());
            logger.info("ARRAY BEFORE PUT: " + Arrays.toString(queue.toArray()));
            if(!queue.contains(username)){queue.add(username);}
            logger.info("ARRAY AFTER PUT: " + Arrays.toString(queue.toArray()));
            writeQueue(queue);
        }
    }

    public List<String> readQueue()
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
            logger.error("File Read Error");
        }
        return queue;
    }

    public void writeQueue(List<String> queue){

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
}