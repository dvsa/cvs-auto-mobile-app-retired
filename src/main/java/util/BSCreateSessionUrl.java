package util;


import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.apache.commons.codec.binary.Base64;
import org.json.JSONArray;
import org.json.JSONObject;

import java.nio.charset.StandardCharsets;

public class BSCreateSessionUrl {

    private static String bsUrl;

    public String getBsUrl() {
        return bsUrl;
    }

    public static void createUrl(String session){

        Unirest.setTimeouts(0, 0);

        String auth = TypeLoader.getBsUsername() + ":" + TypeLoader.getBsPass();
        byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(StandardCharsets.UTF_8));
        String authHeaderValue = "Basic " + new String(encodedAuth);

        HttpResponse<JsonNode> response = null;
        try {
            response = Unirest.get("https://api-cloud.browserstack.com/app-automate/builds.json")
                    .header("Authorization", authHeaderValue)
                    .asJson();
        } catch (UnirestException e) {
            e.printStackTrace();
        }

        JSONArray resources = response.getBody().getArray();
        for (int j = 0; j < resources.length(); j++) {
            JSONObject resource = resources.getJSONObject(j);
            JSONObject fields = resource.getJSONObject("automation_build");
            if(fields.getString("name").equals(TypeLoader.getBsBuildName())){
                String buildId = fields.getString("hashed_id");
                bsUrl = "https://app-automate.browserstack.com/dashboard/v2/builds/"+ buildId +"/sessions/" + session;
                break;
            }
        }
    }
}
