package util.backend.activity;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import exceptions.AutomationException;
import io.restassured.response.Response;
import util.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ActivityService {

    private static final String NAME_ID = "name";
    private static String testerStaffId;
    private ActivitiesClient activitiesClient;
    private static Response response;
    private static String token;
    public ActivityService(String token){
        this.token = token;
        this.activitiesClient = new ActivitiesClient(token);
    }

    private String searchForTesterStaffId() {
        response = activitiesClient.getAllActivities();
        String testerName = getTesterName(token);
        testerStaffId = null;
        if (!response.getBody().asString().contains("No resources match the search criteria")) {
            while (testerStaffId == null && !response.getBody().asString().contains("No resources match the search criteria")) {
                testerStaffId = response.jsonPath().getString("find { it.testerName == '" + testerName + "'}.testerStaffId");
                if (testerStaffId == null) {
                    List<String> activityIds = response.jsonPath().getList("startTime");
                    List<LocalDateTime> activityDateId = new ArrayList<>();
                    for (String activityId : activityIds) {
                        activityDateId.add(LocalDateTime.parse(activityId, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")));
                    }
                    Collections.sort(activityDateId);
                    String toStartTimeData = activityDateId.get(0).minusSeconds(1).toString();
                    response = activitiesClient.getActivitiesToStartTime(toStartTimeData);
                }
            }
        }
        return testerName;
    }

    private static String getTesterName(String token) {
        JWT parsedJWT = new JWT();
        DecodedJWT decodedJWT = parsedJWT.decodeJwt(token);
        return decodedJWT.getClaims().get(NAME_ID).asString();
    }

    public String closeCurrentUserActivity() {

        String username="";
        if (testerStaffId == null) {
            username=searchForTesterStaffId();
        }else {

            System.out.println("YYYYYYYYYYYYYYYYYYYYY");
            System.out.println("YYYYYYYYYYYYYYYYYYYYY");

            System.out.println("YYYYYYYYYYYYYYYYYYYYY");

            System.out.println("YYYYYYYYYYYYYYYYYYYYY");

            System.out.println("YYYYYYYYYYYYYYYYYYYYY");

            System.out.println("YYYYYYYYYYYYYYYYYYYYY");
            response = activitiesClient.getActivities(testerStaffId);
            if (!response.getBody().asString().contains("No resources match the search criteria")) {
                if (response.getStatusCode() != 200) {
                    throw new AutomationException("Response for get activities failed - Backend API Issue failed with status code "
                            + response.getStatusCode() + " and body message " + response.getBody().asString());
                }
                List<String> activityIds = response.jsonPath().getList("findAll { it.endTime == null}.id");
                if (activityIds != null) {
                    for (String activityId : activityIds) {
                        response = activitiesClient.closeActivity(activityId);
                        if (response.getStatusCode() != 204) {
                            throw new AutomationException("Response for put activities failed - Backend API Issue failed with status code "
                                    + response.getStatusCode() + " and body message " + response.getBody().asString());
                        }
                    }
                }
            }
        }
        return username;
    }

}
