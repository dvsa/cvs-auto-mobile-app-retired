package util;

import org.apache.commons.exec.environment.EnvironmentUtils;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.*;

public class TypeLoader {

    private static Properties properties;
    private static final String FILE_PATH = "conf/environment.properties";

    static {
        try {

            properties = new Properties();
            InputStream fileInput = EnvironmentUtils.class.getClassLoader().getResourceAsStream(FILE_PATH);

            if (fileInput != null) {
                properties.load(fileInput);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static HashMap<String,AutomationUser> getUsers() {
        Gson gson = new Gson();
        String json = properties.getProperty("app.users");
        AutomationUser[] automationUsers = gson.fromJson(json, AutomationUser[].class);
        HashMap<String, AutomationUser> automationUsersMap = new HashMap<>();
        for (AutomationUser au: automationUsers){
            automationUsersMap.put(au.getEmail(),au);
        }
        return automationUsersMap;
    }


    public static String getAppTokenUrl() {

        return properties.getProperty("app.token.url.v2");
    }

    public static String getAppClientId() {

        return properties.getProperty("app.client.id.v2");
    }

    public static String getAppClientSecret() {

        return properties.getProperty("app.client.secret.v2");
    }

    public static String getBasePathUrl() {

        return properties.getProperty("base.path.url");
    }

    public static String getBsUsername() {

        return properties.getProperty("browserstack.username");
    }

    public static String getBsPass() {

        return properties.getProperty("browserstack.password");
    }

    public static String getBsOSVersion() {

        return properties.getProperty("browserstack.os.version");
    }

    public static String getBsDevice() {

        return properties.getProperty("browserstack.device");
    }

    public static String getLocalName() {

        return properties.getProperty("local.name");
    }

    public static String getRealMobile() {

        return properties.getProperty("browserstack.real.mobile");
    }

    public static String getBsLocal() {

        return properties.getProperty("browserstack.local");
    }

    public static String getBsAppiumVersion(){

        return properties.getProperty("browserstack.appium.version");
    }

    public static String getBsVideoEnabled() {

        return properties.getProperty("browserstack.video.enabled");
    }

    public static String getBsProjectName() {

        return properties.getProperty("browserstack.project.name");
    }

    public static String getBsBuildName() {

        return properties.getProperty("browserstack.build.name");
    }

    public static String getWaitForQuiescence() {

        return properties.getProperty("waitForQuiescence");
    }

    public static String getBsTimeZone() {

        return properties.getProperty("browserstack.timezone");
    }

    public static String getBsDeviceTimezone() {

        return properties.getProperty("browserstack.device.timezone");
    }

    public static String getBsIdleTimeout() {

        return properties.getProperty("browserstack.idle.timeout");
    }

    public static String getBsNetworkLogsEnabled() {

        return properties.getProperty("browserstack.network.logs");
    }

    public static String getBsGpsLocation() {

        return properties.getProperty("browserstack.gpsLocation");
    }

    public static String getBsAppId() {

        return properties.getProperty("browserstack.app");
    }

    public static String getAutomationName() {

        return properties.getProperty("automationName");
    }

    public static String getBsHostname(){

        return properties.getProperty("browserstack.hostname");
    }

    public static int getNumberConcurrentJob() {

        return Integer.parseInt(properties.getProperty("parallel.consumers"));
    }


}
