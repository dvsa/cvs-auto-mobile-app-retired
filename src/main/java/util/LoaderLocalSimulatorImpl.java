package util;


import exceptions.AutomationException;
import io.appium.java_client.remote.MobileCapabilityType;
import org.apache.commons.exec.environment.EnvironmentUtils;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

public class LoaderLocalSimulatorImpl implements Loader {

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

    @Override
    public DesiredCapabilities loadCapabilities() {

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, properties.getProperty("simulator.platform.name"));
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, properties.getProperty("simulator.platform.version"));
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, properties.getProperty("simulator.device.name"));
        caps.setCapability("bundleId", properties.getProperty("simulator.bundle.id"));

        caps.setCapability("automationName", "XCUITest");

        return caps;
    }

    @Override
    public URL loadUrl() throws MalformedURLException {
        return new URL(LoaderlLocalRealDeviceImpl.getHubUrl());
    }
}
