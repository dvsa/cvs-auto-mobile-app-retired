package util;

import com.amazonaws.auth.*;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.document.*;
import com.amazonaws.services.dynamodbv2.document.spec.DeleteItemSpec;
import com.amazonaws.services.dynamodbv2.document.spec.QuerySpec;
import com.amazonaws.services.dynamodbv2.document.utils.ValueMap;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ResourceNotFoundException;
import com.amazonaws.services.dynamodbv2.model.ScanRequest;
import com.amazonaws.services.dynamodbv2.model.ScanResult;
import com.amazonaws.services.securitytoken.AWSSecurityTokenService;
import com.amazonaws.services.securitytoken.AWSSecurityTokenServiceClientBuilder;
import com.amazonaws.services.securitytoken.model.AssumeRoleRequest;
import com.amazonaws.services.securitytoken.model.AssumeRoleResult;
import com.jayway.jsonpath.JsonPath;

import java.util.*;

public class AwsUtil {

    public static void deleteActivitiesForUser(String testerName) {
        Regions clientRegion = Regions.EU_WEST_1;
        AWSSecurityTokenService stsClient =
                AWSSecurityTokenServiceClientBuilder.standard().withRegion(clientRegion).build();
        String uuid = String.valueOf(UUID.randomUUID());
        AssumeRoleRequest assumeRequest = new AssumeRoleRequest()
                .withRoleArn(System.getProperty("AWS_ROLE"))
                .withDurationSeconds(3600)
                .withRoleSessionName(uuid);
        AssumeRoleResult assumeResult =
                stsClient.assumeRole(assumeRequest);

        BasicSessionCredentials temporaryCredentials =
                new BasicSessionCredentials(
                        assumeResult.getCredentials().getAccessKeyId(),
                        assumeResult.getCredentials().getSecretAccessKey(),
                        assumeResult.getCredentials().getSessionToken());
        AmazonDynamoDBClient client = new AmazonDynamoDBClient(temporaryCredentials);
        client.setRegion(Region.getRegion(clientRegion));
        DynamoDB dynamoDB = new DynamoDB(client);
        String tableName = "cvs-" + System.getProperty("BRANCH") + "-activities";

        Table table = dynamoDB.getTable(tableName);

        Index index = table.getIndex("StaffIndex");
        QuerySpec spec = new QuerySpec()
                .withKeyConditionExpression("testerStaffId = :staff_id")
                .withValueMap(new ValueMap()
                        .withString(":staff_id",testerName));

        try {
            ItemCollection<QueryOutcome> items = index.query(spec);
            for (Item item : items) {
                String id = JsonPath.read(item.toJSON(), "$.id");
                System.out.println("Delete item:\n" + item.toJSONPretty());
                DeleteItemOutcome outcome = table.deleteItem("id", id);
            }
        } catch (ResourceNotFoundException e) {
            System.out.println("No activities to delete");
        }
    }

    public static void deleteActivitiesForUserName(String userName) {
        Regions clientRegion = Regions.EU_WEST_1;
        AWSSecurityTokenService stsClient =
                AWSSecurityTokenServiceClientBuilder.standard().withRegion(clientRegion).build();
        String uuid = String.valueOf(UUID.randomUUID());
        AssumeRoleRequest assumeRequest = new AssumeRoleRequest()
                .withRoleArn(System.getProperty("AWS_ROLE"))
                .withDurationSeconds(3600)
                .withRoleSessionName(uuid);
        AssumeRoleResult assumeResult =
                stsClient.assumeRole(assumeRequest);

        BasicSessionCredentials temporaryCredentials =
                new BasicSessionCredentials(
                        assumeResult.getCredentials().getAccessKeyId(),
                        assumeResult.getCredentials().getSecretAccessKey(),
                        assumeResult.getCredentials().getSessionToken());
        AmazonDynamoDBClient client = new AmazonDynamoDBClient(temporaryCredentials);
        client.setRegion(Region.getRegion(clientRegion));
        DynamoDB dynamoDB = new DynamoDB(client);
        String tableName = "cvs-" + System.getProperty("BRANCH") + "-activities";

        Map<String, AttributeValue> expressionAttributeValues = new HashMap<String, AttributeValue>();
        expressionAttributeValues.put(":user", new AttributeValue().withS(userName));

        ScanRequest scanRequest = new ScanRequest()
                .withTableName(tableName)
                .withFilterExpression("testerName = :user")
                .withProjectionExpression("id, testerName")
                .withExpressionAttributeValues(expressionAttributeValues);
        ScanResult result = client.scan(scanRequest);
        System.out.println("result.toString: " + result.toString());
        System.out.println("result.getCount: " + result.getCount());
        System.out.println("result.getItems:" + result.getItems());

        Table table = dynamoDB.getTable(tableName);

        for (Map<String, AttributeValue> item : result.getItems()) {
            System.out.println("item.size: " + item.size());
            System.out.println("item.values: " + item.values());
            System.out.println("item.get(id).getS(): " + item.get("testerName").getS());
            DeleteItemSpec deleteItemSpec = new DeleteItemSpec()
                    .withPrimaryKey("id", item.get("id").getS(), "testerName", userName);
            DeleteItemOutcome outcome = table.deleteItem(deleteItemSpec);
        }
    }
}