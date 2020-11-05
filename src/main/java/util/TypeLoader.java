package util;

import org.apache.commons.exec.environment.EnvironmentUtils;

import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

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

    public static String getAppUsername() {

        return properties.getProperty("app.username");
    }

    public static String getAppPassword() {

        return properties.getProperty("app.password");
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

    public static String getMicrosoftonlineUrl() {

        return properties.getProperty("microsoftonline.url");
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

    public static String getWaitForQuiescence() {

        return properties.getProperty("waitForQuiescence");
    }

    public static String getBsTimeZone() {

        return properties.getProperty("browserstack.timezone");
    }

    public static String getBsIdleTimeout() {

        return properties.getProperty("browserstack.idle.timeout");
    }

    public static String getBsNetworkLogsEnabled() {

        return properties.getProperty("browserstack.network.logs");
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
