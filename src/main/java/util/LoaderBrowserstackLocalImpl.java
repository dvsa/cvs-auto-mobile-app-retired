package util;


import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class LoaderBrowserstackLocalImpl implements Loader {


    @Override
    public DesiredCapabilities loadCapabilities() {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("os_version", TypeLoader.getBsOSVersion());
        caps.setCapability("device", TypeLoader.getBsDevice());
        caps.setCapability("name", TypeLoader.getLocalName());
        caps.setCapability("real_mobile", TypeLoader.getRealMobile());
        caps.setCapability("browserstack.local", TypeLoader.getBsLocal());
        caps.setCapability("browserstack.appium_version", TypeLoader.getBsAppiumVersion());
        caps.setCapability("browserstack.video", TypeLoader.getBsVideoEnabled());
        caps.setCapability("waitForQuiescence", TypeLoader.getWaitForQuiescence());
        caps.setCapability("browserstack.timezone", TypeLoader.getBsTimeZone());
        caps.setCapability("browserstack.idleTimeout", TypeLoader.getBsIdleTimeout());
        caps.setCapability("browserstack.networkLogs", TypeLoader.getBsNetworkLogsEnabled());
        caps.setCapability("app", TypeLoader.getBsAppId());
        caps.setCapability("automationName", TypeLoader.getAutomationName());

        return caps;

    }

    @Override
    public URL loadUrl() throws MalformedURLException {
        return new URL("https://" + TypeLoader.getBsUsername() + ":" + TypeLoader.getBsPass() + "@" + TypeLoader.getBsHostname() + "/wd/hub");
    }
}
