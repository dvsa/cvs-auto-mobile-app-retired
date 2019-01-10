package pages;


import io.appium.java_client.ios.IOSDriver;
import net.thucydides.core.webdriver.WebDriverFacade;
import util.TestHandler;

public class LaunchPage extends BasePage {

    private static final String GET_STARTED_ID = "Get Started";

    public void clickGetStarted() {
        if (!TestHandler.getInitializedStatus().get()) {
            longWaitUntilPageIsLoadedById(GET_STARTED_ID).click();
            TestHandler.getInitializedStatus().set(true);

        } else {
            ((IOSDriver)((WebDriverFacade) getDriver()).getProxiedDriver()).closeApp();
            ((IOSDriver)((WebDriverFacade) getDriver()).getProxiedDriver()).launchApp();
            longWaitUntilPageIsLoadedById(GET_STARTED_ID).click();
        }

    }

}
