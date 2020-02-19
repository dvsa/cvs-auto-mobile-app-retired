package util.backend.activity;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import exceptions.AutomationException;
import io.restassured.response.Response;
import util.AwsUtil;
import util.EnvironmentType;
import util.TypeLoader;
import util.WriterReader;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ActivityService {

    private static final String NAME_ID = "name";
    private static String testerStaffId;
    private static ActivitiesClient activitiesClient = new ActivitiesClient();
    private static Response response;

    private void searchForTesterStaffId() {
        EnvironmentType envType = TypeLoader.getType();

        switch (envType) {
            case CI_BROWSERSTACK:
                AwsUtil.deleteActivitiesForUser(System.getProperty("MICROSOFT_USERNAME"));
                break;
            case LOCAL_REAL_DEVICE:
            case LOCAL_SIMULATOR:
            case LOCAL_BROWSERSTACK:
                if (testerStaffId == null) {
                    searchForTesterStaffId();
                }

                if (testerStaffId != null) {
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
                break;
            default:
                throw new AutomationException("Environment configuration not found");

        }
    }

    public void closeUserActivity() {

        if (testerStaffId == null) {
            searchForTesterStaffId();
        }

        if (testerStaffId != null) {
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

    }

    private static String getTesterName() {
        JWT parsedJWT = new JWT();
        DecodedJWT decodedJWT = parsedJWT.decodeJwt(WriterReader.getToken());
        return decodedJWT.getClaims().get(NAME_ID).asString();
    }

}
