package util;

import io.appium.java_client.ios.IOSDriver;
import net.thucydides.core.webdriver.DriverSource;
import org.openqa.selenium.WebDriver;

public class DriverSourceImpl implements DriverSource {

    @Override
    public WebDriver newDriver() {
        Loader loader = new LoaderBrowserstackLocalImpl();
        return new IOSDriver<>(loader.loadUrl(), loader.loadCapabilities());
    }

    @Override
    public boolean takesScreenshots() {
        return false;
    }
}
