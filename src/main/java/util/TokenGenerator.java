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
                    .field("grant_type", "client_credentials")
                    .field("client_id", TypeLoader.getAppClientId())
                    .field("scope", "https://dev.vta.dvsatest-cloud.uk/.default")
                    .field("client_secret", TypeLoader.getAppClientSecret())
                    .asJson();
        } catch (UnirestException e) {
            e.printStackTrace();
        }

        String token = jsonResponse.getBody().getObject().get("access_token").toString();

        return token;
    }
}
