package util;

import exceptions.AutomationException;
import org.apache.commons.exec.environment.EnvironmentUtils;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

public class LoaderBrowserstackLocalImpl implements Loader {

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

    public static String getUsername() {
        return properties.getProperty("browserstack.username");
    }

    public static String getPassword() {
        return properties.getProperty("browserstack.password");
    }

    public static String getAppUsername() {
        return properties.getProperty("app.username");
    }

    public static String getAppPassword() {
        return properties.getProperty("app.password");
    }

    public static String getLocalName() {
        return properties.getProperty("local.name");
    }


    @Override
    public DesiredCapabilities loadCapabilities() {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("os_version", properties.getProperty("browserstack.os.version"));
        caps.setCapability("device", properties.getProperty("browserstack.device"));
        caps.setCapability("name", "Local - " + getLocalName());
        caps.setCapability("real_mobile", "true");
        caps.setCapability("realMobile", "true");
        caps.setCapability("browserstack.local", "false");
        caps.setCapability("browserstack.appium_version", "1.9.1");
        caps.setCapability("browserstack.video", "true");
        caps.setCapability("waitForQuiescence", "false");
        caps.setCapability("browserstack.timezone", "UTC");


        caps.setCapability("app", properties.getProperty("browserstack.app"));


        caps.setCapability("automationName", "XCUITest");

        return caps;

    }

    @Override
    public URL loadUrl() throws MalformedURLException {
        return new URL("http://" + getUsername() + ":" + getPassword() + "@" + properties.getProperty("browserstack.hostname") + "/wd/hub");
    }
}
