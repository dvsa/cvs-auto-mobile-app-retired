package util.backend.activity;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import exceptions.AutomationException;
import io.restassured.response.Response;
import util.WriterReader;

import java.util.List;

public class ActivityService {

    private static final String ID = "oid";
    private ActivitiesClient activitiesClient = new ActivitiesClient();
    private Response response;

    public void closeUserActivity() {
        String testerStaffId = getTesterStaffId();
        response = activitiesClient.getActivities(testerStaffId);
        if (!response.getBody().asString().contains("No resources match the search criteria")) {
            if (response.getStatusCode() != 200) {
                throw new AutomationException("Response for get activities failed - Backend API Issue failed with status code "
                        + response.getStatusCode() + " and body message " + response.getBody().asString());
            }
            List<String> activityIds = response.jsonPath().getList("findAll { it.endTime == null}.id");
            if (activityIds != null) {
                for (String activityId : activityIds) {
                    response = activitiesClient.putActivities(activityId);
                    if (response.getStatusCode() != 204) {
                        throw new AutomationException("Response for put activities failed - Backend API Issue failed with status code "
                                + response.getStatusCode() + " and body message " + response.getBody().asString());
                    }
                }
            }
        }

    }

    private String getTesterStaffId() {
        JWT parsedJWT = new JWT();
        DecodedJWT decodedJWT = parsedJWT.decodeJwt(WriterReader.getToken());
        return decodedJWT.getClaims().get(ID).asString();
    }

}
