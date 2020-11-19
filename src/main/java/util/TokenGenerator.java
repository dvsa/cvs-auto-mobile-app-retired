package util;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;


public class TokenGenerator {

    public TokenGenerator(){
    }

    public String getToken(String username) throws Exception {

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
