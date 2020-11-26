package util;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class TokenGenerator {

    Logger logger = LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);

    public TokenGenerator(){
    }

    public String getToken(String username) {

        logger.info("generate user token");
        Unirest.setTimeouts(0, 0);
        HttpResponse<JsonNode> jsonResponse  = null;
        try {
            jsonResponse = Unirest.post(TypeLoader.getAppTokenUrl())
                        .field("grant_type", "password")
                        .field("client_id", TypeLoader.getAppClientId())
                        .field("userName", username)
                        .field("password", TypeLoader.getAppPassword())
                        .field("resource", TypeLoader.getAppClientId())
                        .asJson();
        } catch (UnirestException e) {
            e.printStackTrace();
        }

        String token = jsonResponse.getBody().getObject().get("access_token").toString();

        return token;
    }
}
