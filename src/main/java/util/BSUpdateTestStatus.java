package util;


import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.apache.commons.codec.binary.Base64;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.HttpClients;

import java.nio.charset.StandardCharsets;

public class BSUpdateTestStatus {

    public BSUpdateTestStatus() {
    }

    public static void updateStatus(SessionDetails sessionDetails) {

        Unirest.setTimeouts(0, 0);
        String auth = TypeLoader.getBsUsername() + ":" + TypeLoader.getBsPass();
        byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(StandardCharsets.UTF_8));
        String authHeaderValue = "Basic " + new String(encodedAuth);

        HttpResponse<String> response = null;
        try {
            response = Unirest.put("https://api-cloud.browserstack.com/app-automate/sessions/"+ sessionDetails.getSession() +".json")
                    .header("Content-Type", "application/json")
                    .header("Authorization", authHeaderValue)
                    .body("{\"name\": \"" + sessionDetails.getName() + "\", \"status\":\"" + sessionDetails.getStatus() + "\", \"reason\":\"" + sessionDetails.getReason() + "\"}")
                    .asString();
        } catch (UnirestException e) {
            e.printStackTrace();
        }
    }
}

