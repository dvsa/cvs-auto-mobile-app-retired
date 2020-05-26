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
    private static ActivitiesClient activitiesClient = new ActivitiesClient();
    private static Response response;

    private void searchForTesterStaffId() {
        response = activitiesClient.getAllActivities();
        String testerName = getTesterName();
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
    }

    public void closeUserActivity() {
        EnvironmentType envType = TypeLoader.getType();
        System.out.println("=========================ENV TYPE================================");
        System.out.println(envType);
        switch (envType) {
            case CI_BROWSERSTACK:
                System.out.println(envType);
                System.out.println("======================= CURRENT USERNAME ==================================");
                System.out.println(BaseUtils.getUserName());
                switch(BaseUtils.getUserName()) {
                    case "cvs.automation2@dvsagov.onmicrosoft.com":
                        AwsUtil.deleteActivitiesForUser("a53ae740-eac4-4eb6-99ef-42afb63ce819");
                        break;
                    case "cvs.automation3@dvsagov.onmicrosoft.com":
                        AwsUtil.deleteActivitiesForUser("d463f9f3-1ce7-4944-930a-ce9fd51e506b");
                        break;
                     case "cvs.automation4@dvsagov.onmicrosoft.com":
                         AwsUtil.deleteActivitiesForUser("c26d6b02-49b2-456a-ac20-7435e9397bac");
                        break;
                     case "cvs.automation5@dvsagov.onmicrosoft.com":
                         AwsUtil.deleteActivitiesForUser("4dd9756b-8a94-4cef-b58a-804a28ffbb68");
                        break;
                     case "cvs.automation6@dvsagov.onmicrosoft.com":
                         AwsUtil.deleteActivitiesForUser("b358e472-007d-438c-9d0d-75f243a8cce6");
                        break;
                     case "cvs.automation7@dvsagov.onmicrosoft.com":
                         AwsUtil.deleteActivitiesForUser("6719600b-3aaf-49ee-9efd-38031d49a167");
                        break;
                     case "cvs.automation8@dvsagov.onmicrosoft.com":
                         AwsUtil.deleteActivitiesForUser("09bafb1b-9871-4848-a755-037755eb3d74");
                        break;
                     case "cvs.automation9@dvsagov.onmicrosoft.com":
                         AwsUtil.deleteActivitiesForUser("5c4ed163-e54b-400f-ab9a-9d75c658c131");
                        break;
                    case "cvs.automation10@dvsagov.onmicrosoft.com":
                        AwsUtil.deleteActivitiesForUser("8272a386-098b-4dc9-ab1d-c2ea561aa4a0");
                        break;
                    default:
                        throw new AutomationException("The provided user is incorrect");
                }
            case LOCAL_REAL_DEVICE:
            case LOCAL_SIMULATOR:
            case LOCAL_BROWSERSTACK:
                System.out.println("======================= NOT CI===================================");
                System.out.println(envType);
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

    private static String getTesterName() {
        JWT parsedJWT = new JWT();
        DecodedJWT decodedJWT = parsedJWT.decodeJwt(WriterReader.getToken());
        return decodedJWT.getClaims().get(NAME_ID).asString();
    }

    public void closeCurrentUserActivity() {
        EnvironmentType envType = TypeLoader.getType();
        System.out.println("=========================ENV TYPE================================");
        System.out.println(envType);
        switch (envType) {
            case CI_BROWSERSTACK:
                System.out.println(envType);
                System.out.println("======================= CURRENT USERNAME ==================================");
                System.out.println(BaseUtils.getUserName());
                AwsUtil.deleteActivitiesForUserName(BaseUtils.getUserName());
                break;
            case LOCAL_REAL_DEVICE:
            case LOCAL_SIMULATOR:
            case LOCAL_BROWSERSTACK:
                System.out.println("======================= NOT CI===================================");
                System.out.println(envType);
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

}
