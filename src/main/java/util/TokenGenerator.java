package util;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import exceptions.AutomationException;

import java.io.*;

public class TokenGenerator {

    public TokenGenerator(){
    }

    public String getToken(String username) throws Exception {

        new FileLocking().deleteFileToken(username);

        FileUtils fileUtils;
        File file = new File(username + ".txt");

        FileUtils p1 = new FileUtils(getNewToken(username));

        try (FileOutputStream f = new FileOutputStream(new File(username + ".txt")); ObjectOutputStream o = new ObjectOutputStream(f)) {

            o.writeObject(p1);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new AutomationException("File Utils not found");
        } catch (IOException e) {
            e.printStackTrace();
            throw new AutomationException("Error initializing stream");
        }

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

    public String getNewToken(String username) throws Exception {

        Unirest.setTimeouts(0, 0);
        HttpResponse<JsonNode> jsonResponse  = Unirest.post(TypeLoader.getAppTokenUrl())
                    .field("grant_type", "password")
                    .field("client_id", TypeLoader.getAppClientId())
                    .field("userName", username)
                    .field("password", TypeLoader.getAppPassword())
                    .field("resource", TypeLoader.getAppClientId())
                    .asJson();

        String token = jsonResponse.getBody().getObject().get("access_token").toString();

        return token;
    }
}
