package pages;


import io.appium.java_client.ios.IOSDriver;
import net.thucydides.core.webdriver.WebDriverFacade;
import util.TestHandler;

public class LaunchPage extends BasePage {

    private static final String GET_STARTED_ID = "Get Started";
    private static final String LAUNCH_PAGE_IMAGE = "XCUIElementTypeImage";
    private static final String BETA_TEXT = "BETA";
    private static final String TITLE_1= "Vehicle Standards";
    private static final String TITLE_2 = "Assessment";
    private static final String SUBTITLE = "Mobile Test Capture";

    public void clickGetStarted() {
        if (!TestHandler.getInitializedStatus().get()) {
            longWaitUntilPageIsLoadedByIdAndClickable(GET_STARTED_ID).click();
            TestHandler.getInitializedStatus().set(true);

        } else {
//            ((IOSDriver)((WebDriverFacade) getDriver()).getProxiedDriver()).closeApp();
//            ((IOSDriver)((WebDriverFacade) getDriver()).getProxiedDriver()).launchApp();
            shortWaitUntilPageIsLoadedByIdAndClickable(GET_STARTED_ID).click();
        }

    }

    public void clickStartButton() {
        findElementById(GET_STARTED_ID).click();
    }

    public void waitUntilPageIsLoaded() {waitUntilPageIsLoadedById(GET_STARTED_ID);}

    public boolean checkIfGetStartedButttonIsDisplayed() {return findElementByXpath(GET_STARTED_ID).isDisplayed();}

    public boolean checkIfLaunchImageIsDisplayed() {return findElementByXpath(LAUNCH_PAGE_IMAGE).isDisplayed();}

    public boolean checkIfBetaTextIsDisplayed() {return findElementByXpath(BETA_TEXT).isDisplayed();}

    public boolean checkIfTitle1IsDisplayed() {return findElementByXpath(TITLE_1).isDisplayed();}

    public boolean checkIfTitle2IsDisplayed() {return findElementByXpath(TITLE_2).isDisplayed();}

    public boolean checkIfSubTitleIsDisplayed() {return findElementByXpath(SUBTITLE).isDisplayed();}

}
