package util;

import exceptions.AutomationException;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class LoaderBrowserstackCIImpl implements Loader {

    private final static String username = System.getenv("BROWSERSTACK_USERNAME");
    private final static String accessKey = System.getenv("BROWSERSTACK_ACCESS_KEY");
    private final static String browserstackLocal = System.getenv("BROWSERSTACK_LOCAL");
    private final static String browserstackLocalIdentifier = System.getenv("BROWSERSTACK_LOCAL_IDENTIFIER");
    private final static String app = System.getProperty("BROWSERSTACK_APP_ID");


    public static String getUsername() {
        return username;
    }

    public static String getAccessKey() {
        return accessKey;
    }


    @Override
    public DesiredCapabilities loadCapabilities() {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("os_version", "11.0");
        caps.setCapability("device", "iPhone 8 Plus");
        caps.setCapability("name", System.getProperty("environment") + "- ");
        caps.setCapability("real_mobile", "true");
        caps.setCapability("browserstack.appium_version", "1.9.1");
        caps.setCapability("app", app);
        caps.setCapability("browserstack.local", browserstackLocal);
        caps.setCapability("browserstack.localIdentifier", browserstackLocalIdentifier);
        caps.setCapability("browserstack.video", "false");
        caps.setCapability("waitForQuiescence", "false");


        caps.setCapability("automationName", "XCUITest");

        return caps;
    }


    @Override
    public URL loadUrl() throws MalformedURLException {
        return new URL("http://" + username + ":" + accessKey + "@hub-cloud.browserstack.com/wd/hub");
    }



}
