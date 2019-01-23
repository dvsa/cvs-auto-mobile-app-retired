package util;

import exceptions.AutomationException;
import io.appium.java_client.remote.MobileCapabilityType;
import org.apache.commons.exec.environment.EnvironmentUtils;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

public class LoaderlLocalRealDeviceImpl implements Loader {

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

    @Override
    public DesiredCapabilities loadCapabilities() {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("platformVersion", getPlatformVersion());
        cap.setCapability("deviceName", getDeviceName());
        cap.setCapability("platformName", getPlatformName());
        cap.setCapability("bundleId", getBundleId());
        cap.setCapability("udid", getUdid());
        cap.setCapability("noReset", "true");
        cap.setCapability("fullReset", "false");
//        cap.setCapability(MobileCapabilityType.FULL_RESET, true);

//        cap.setCapability("waitForQuiescence", "true");


        cap.setCapability("automationName", "XCUITest");

        return cap;
    }

    @Override
    public URL loadUrl() throws MalformedURLException {
        return new URL(getHubUrl());
    }
}
