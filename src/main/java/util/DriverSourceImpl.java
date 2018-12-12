package util;

import io.appium.java_client.ios.IOSDriver;
import net.thucydides.core.webdriver.DriverSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverSourceImpl implements DriverSource {


    @Override
    public WebDriver newDriver() {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("platformVersion", MobileDeviceLoader.getPlatformVersion());
        cap.setCapability("deviceName", MobileDeviceLoader.getDeviceName());
        cap.setCapability("platformName", MobileDeviceLoader.getPlatformName());
        cap.setCapability("bundleId", MobileDeviceLoader.getBundleId());
        cap.setCapability("udid", MobileDeviceLoader.getUdid());


        cap.setCapability("automationName", "XCUITest");

        WebDriver driver = null;
        try {
            driver = new IOSDriver<>(new URL(MobileDeviceLoader.getHubUrl()), cap);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return driver;
    }

    @Override
    public boolean takesScreenshots() {
        return false;
    }

}
