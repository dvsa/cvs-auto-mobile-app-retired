package util.backend.activity;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import io.restassured.response.Response;
import util.WriterReader;

import java.util.List;

public class ActvityService {

    private static final String ID = "oid";
    private ActivitiesClient activitiesClient = new ActivitiesClient();
    private Response response;

    public void closeUserActivity() {
        String testerStaffId = getTesterStaffId();
        response = activitiesClient.getActivities(testerStaffId);
        if (!response.getBody().asString().contains("No resources match the search criteria")) {
            List<String> activityIds = response.jsonPath().getList("findAll { it.endTime == null}.id");
            for (String activityId : activityIds) {
                activitiesClient.putActivities(activityId);
            }
        }

    }

    private String getTesterStaffId() {
        JWT parsedJWT = new JWT();
        DecodedJWT decodedJWT = parsedJWT.decodeJwt(WriterReader.getToken());
        return decodedJWT.getClaims().get(ID).asString();
    }

}
