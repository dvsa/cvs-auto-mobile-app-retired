package util;

import exceptions.AutomationException;
import org.apache.commons.exec.environment.EnvironmentUtils;

import java.util.Properties;

class MobileDeviceLoader {

    private static Properties properties;
    private static final String FILE_PATH = "conf/environment.properties";

    static {
        try {

            properties = new Properties();
            properties.load(EnvironmentUtils.class.getClassLoader().getResourceAsStream(FILE_PATH));
        } catch (Exception e) {
            e.printStackTrace();
            throw new AutomationException("Could not load environment setup");
        }
    }

    public static String getHubUrl() {
        return properties.getProperty("hub.url");
    }

    public static String getPlatformVersion() {
        return properties.getProperty("platform.version");
    }

    public static String getDeviceName() {
        return properties.getProperty("device.name");
    }

    public static String getPlatformName() {
        return properties.getProperty("platform.name");
    }

    public static String getBundleId() {
        return properties.getProperty("bundle.id");
    }

    public static String getUdid() {
        return properties.getProperty("udid");
    }

}
