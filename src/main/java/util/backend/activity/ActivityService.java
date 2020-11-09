package util.backend.activity;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import exceptions.AutomationException;
import io.restassured.response.Response;
import org.springframework.beans.factory.annotation.Value;
import util.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class ActivityService {

    private static Response response;

    private static String getTesterStaffId(String token) {
        JWT parsedJWT = new JWT();
        DecodedJWT decodedJWT = parsedJWT.decodeJwt(token);
        return decodedJWT.getClaims().get("oid").asString();
    }

    public String closeCurrentUserActivity(String token) {

        String getStaffId=getTesterStaffId(token);

        List<String> activityIds = response.jsonPath().getList("findAll { it.endTime == null && it.getstaffid = "+getStaffId+"}.id");
        if (activityIds != null) {
            for (String activityId : activityIds) {
                response = activitiesClient.closeActivity(activityId);
                if (response.getStatusCode() != 204) {
                    throw new AutomationException("Response for put activities failed - Backend API Issue failed with status code "
                            + response.getStatusCode() + " and body message " + response.getBody().asString());
                }
            }
        }

//        if (testerStaffId == null) {
//            System.out.print("CIAO");
//            username=searchForTesterStaffId();
//        }else {
//
//            System.out.print("YEAHH");
//            response = activitiesClient.getActivities(testerStaffId);
//            if (!response.getBody().asString().contains("No resources match the search criteria")) {
//                if (response.getStatusCode() != 200) {
//                    throw new AutomationException("Response for get activities failed - Backend API Issue failed with status code "
//                            + response.getStatusCode() + " and body message " + response.getBody().asString());
//                }
//
//            }
//        }
//        return username;
//
//        response = activitiesClient.getAllActivities();
//        String testerName = getTesterName(token);
//        testerStaffId = null;
//        if (!response.getBody().asString().contains("No resources match the search criteria")) {
//            while (testerStaffId == null && !response.getBody().asString().contains("No resources match the search criteria")) {
//                testerStaffId = response.jsonPath().getString("find { it.testerName == '" + testerName + "'}.testerStaffId");
//                if (testerStaffId == null) {
//                    List<String> activityIds = response.jsonPath().getList("startTime");
//                    List<LocalDateTime> activityDateId = new ArrayList<>();
//                    for (String activityId : activityIds) {
//                        activityDateId.add(LocalDateTime.parse(activityId, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")));
//                    }
//                    Collections.sort(activityDateId);
//                    String toStartTimeData = activityDateId.get(0).minusSeconds(1).toString();
//                    response = activitiesClient.getActivitiesToStartTime(toStartTimeData);
//                }
//            }
//        }
//        return testerName;
    }

}
