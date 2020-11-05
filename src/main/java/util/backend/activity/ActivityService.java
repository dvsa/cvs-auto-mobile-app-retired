package util.backend.activity;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import exceptions.AutomationException;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import util.backend.BasePathFilter;

import java.time.LocalDateTime;
import java.util.*;

import static io.restassured.RestAssured.given;

public class ActivityService {

    private static String getTesterStaffId(String token) {
        JWT parsedJWT = new JWT();
        DecodedJWT decodedJWT = parsedJWT.decodeJwt(token);
        return decodedJWT.getClaims().get("oid").asString();
    }

    public void closeCurrentUserActivity(String token) {

        String getStaffId = getTesterStaffId(token);

        List<String> openActivitiesIdforUser = getAllOpenActivitiesForTesterStaffId(getStaffId,token);

        if(openActivitiesIdforUser != null){
            for(String activityIdToClose: openActivitiesIdforUser){
                closeOpenActivityById(activityIdToClose,token);
            }
        }else{
            System.out.println("No open activity to close for StaffId: " + getStaffId);
        }
    }

    private List<String> getAllOpenActivitiesForTesterStaffId(String testerStaffId, String token) {
        List<String> activityIds = null;
        Response response = given().filters(new BasePathFilter(token))
                .contentType(ContentType.JSON)
                .queryParam("activityType", "visit")
                .queryParam("fromStartTime", LocalDateTime.now().minusDays(90).toString())
                .queryParam("testerStaffId", testerStaffId)
                .log().method().log().uri().log().body()
                .get("/activities/details");

        if (!response.getBody().asString().contains("No resources match the search criteria")) {
            activityIds = response.jsonPath().getList("findAll { it.endTime == null}.id");
        }

        return activityIds;
    }

    private void closeOpenActivityById(String id, String token) {

        given().filters(new BasePathFilter(token))
                .contentType(ContentType.JSON)
                .pathParam("id", id)
                .log().method().log().uri().log().body()
                .put("/activities/{id}/end");
    }
}
