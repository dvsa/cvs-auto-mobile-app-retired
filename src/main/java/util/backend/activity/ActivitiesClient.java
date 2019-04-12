package util.backend.activity;

import exceptions.AutomationException;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
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

            if (response.getStatusCode() == 401 || response.getStatusCode() == 403) {
                saveUtils();
                response = callPutActivities(id);
            }
            if (response.getStatusCode() == 401 || response.getStatusCode() == 403) {
                throw new AutomationException("User is not configured properly and has invalid bearer token - PUT");
            }
        }

        return response;

    }


    public Response getActivitiesToStartTime(String toStartTime) {

        Response response = callGetActivities(null, LocalDateTime.now().minusYears(1).toString() , toStartTime);

        if (response.getStatusCode() == 401 || response.getStatusCode() == 403) {
            saveUtils();
            response = callGetActivities(null, LocalDateTime.now().minusYears(1).toString() , toStartTime);

            if (response.getStatusCode() == 401 || response.getStatusCode() == 403) {
                throw new AutomationException("User is not configured properly and has invalid bearer token - GET");
            }
        }

        return response;

    }

    public Response getAllActivities() {

        Response response = callGetActivities(null, LocalDateTime.now().minusYears(1).toString() , null);

        if (response.getStatusCode() == 401 || response.getStatusCode() == 403) {
            saveUtils();
            response = callGetActivities(null, LocalDateTime.now().minusYears(1).toString() , null);

            if (response.getStatusCode() == 401 || response.getStatusCode() == 403) {
                throw new AutomationException("User is not configured properly has invalid bearer token - GET");
            }
        }



        return response;

    }



    public Response getActivities(String testerStaffId) {

        Response response = callGetActivities(testerStaffId, LocalDateTime.now().minusYears(1).toString() , null);

        if (response.getStatusCode() == 401 || response.getStatusCode() == 403) {
            saveUtils();
            response = callGetActivities(testerStaffId, LocalDateTime.now().minusYears(1).toString() , null);

            if (response.getStatusCode() == 401 || response.getStatusCode() == 403) {
                throw new AutomationException("User is not configured properly has invalid bearer token - GET");
            }
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

    private Response callGetActivities(String testerStaffId, String fromStartTime, String toStartTime) {

        RequestSpecification requestSpecification = given().filters(new BasePathFilter())
                .contentType(ContentType.JSON);

        if (testerStaffId != null) {
            requestSpecification.queryParam("testerStaffId", testerStaffId);
        }

        if (fromStartTime != null) {
            requestSpecification.queryParam("fromStartTime", fromStartTime);
        }

        if (toStartTime != null) {
            requestSpecification.queryParam("toStartTime", toStartTime);
        }

        Response response = requestSpecification
                .queryParam("activityType", "visit")
                .get("/activities/details");


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
