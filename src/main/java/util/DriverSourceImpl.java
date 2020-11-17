package util;

import io.appium.java_client.ios.IOSDriver;
import net.thucydides.core.webdriver.DriverSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class DriverSourceImpl implements DriverSource {

    @Override
    public WebDriver newDriver() {
        return setupWebDriver(new LoaderBrowserstackLocalImpl());
    }

    @Override
    public boolean takesScreenshots() {
        return false;
    }

    private WebDriver setupWebDriver(Loader loader) {
        return new IOSDriver<>(getUrl(loader), getDesireCapByImpl(loader));
    }


    private DesiredCapabilities getDesireCapByImpl(Loader loader) {
        return loader.loadCapabilities();
    }

    private URL getUrl(Loader loader) {
        return loader.loadUrl();
    }
}
