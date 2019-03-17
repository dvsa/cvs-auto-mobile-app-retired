package util.backend.activity;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import util.backend.BasePathFilter;

import java.time.LocalDateTime;

import static io.restassured.RestAssured.given;
import static util.WriterReader.saveUtils;

public class ActivitiesClient {

    public Response putActivities(String id) {

        Response response = callPutActivities(id);

        if (response.getStatusCode() == 401 || response.getStatusCode() == 403) {
            saveUtils();
            response = callPutActivities(id);
        }

        return response;

    }


    public Response getActivities(String testerStaffId) {

        Response response = callGetActivities(testerStaffId);

        if (response.getStatusCode() == 401 || response.getStatusCode() == 403) {
            saveUtils();
            response = callGetActivities(testerStaffId);
        }

        return response;

    }


    private Response callPutActivities(String id) {

        Response response = given().filters(new BasePathFilter())
                .contentType(ContentType.JSON)
                .pathParam("id", id)
                .put("/activities/{id}/end");

        return response;
    }


    private Response callGetActivities(String testerStaffId) {

        Response response = given().filters(new BasePathFilter())
                .contentType(ContentType.JSON)
                .queryParam("activityType", "visit")
                .queryParam("fromStartTime", LocalDateTime.now().minusDays(1).toString())
                .queryParam("testerStaffId", testerStaffId)
                .get("/activities/details");

        return response;
    }



}
