package pages;


import exceptions.AutomationException;
import io.appium.java_client.ios.IOSDriver;
import net.thucydides.core.webdriver.UnsupportedDriverException;
import net.thucydides.core.webdriver.WebDriverFacade;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.remote.RemoteWebDriver;
import util.BaseUtils;
import util.TestHandler;
import util.TypeLoader;


public class LaunchPage extends BasePage {

    private static final String GET_STARTED_ID = "Get started";
    private static final String LAUNCH_PAGE_IMAGE = "XCUIElementTypeImage";
    private static final String BETA_TEXT = "BETA";
    private static final String TITLE = "Vehicle Testing";
    private static final String SUBTITLE_1 = "Use this app to record PSV tests at";
    private static final String SUBTITLE_2 = "Authorised Testing Facilities (ATFs).";

    public void clickGetStarted(LoginPage loginPage, SignaturePage signaturePage) {

        // Extra debug info to assist with tracking down issues.
        // This seems to be the area of highest incidental failure at present.
        WebDriverFacade driverFacade = (WebDriverFacade)getDriver();
        RemoteWebDriver driver = (RemoteWebDriver)driverFacade.getProxiedDriver();
        String sessionId = driver.getSessionId().toString();
        System.out.println("Session ID: " + sessionId);

        if (!TestHandler.getInitializedStatus().get()) {
            try {
                try {
                    loginPage.waitUsernamePageToLoad();
                } catch (UnsupportedDriverException e) {
                    loginPage.waitUsernamePageToLoad();
                }
                loginPage.insertUserName(BaseUtils.getUserName());
                loginPage.clickNext();
                loginPage.waitPasswordPageToLoad();
                loginPage.insertPassword(TypeLoader.getAppPassword());
                loginPage.clickSignIn();
                try {
                    signaturePage.waitPageToLoad();
                    signaturePage.createSignature();
                    signaturePage.clickSaveButton();
                    signaturePage.confirmSignature();
                    shortWaitUntilPageIsLoadedByIdAndClickable(GET_STARTED_ID);

                } catch (TimeoutException e) {
                    shortWaitUntilPageIsLoadedByIdAndClickable(GET_STARTED_ID);
                } catch (Exception e) {
                    throw new AutomationException("Unable to start Signature service / access reference data. #1");
                }
            } catch (TimeoutException e) {
                throw new AutomationException("Could not get to get started page (Session: " + sessionId + ")");
            }


            if (!TestHandler.testTypeEnabledCached().get()) {
                clickToEnableOrDisable();
                TestHandler.currentCacheDisabled().set(true);
            }


            findElementById(GET_STARTED_ID).click();
            TestHandler.getInitializedStatus().set(true);

        } else {

            ((IOSDriver) ((WebDriverFacade) getDriver()).getProxiedDriver()).closeApp();
            ((IOSDriver) ((WebDriverFacade) getDriver()).getProxiedDriver()).launchApp();
            try {
                shortWaitUntilPageIsLoadedByIdAndClickable(GET_STARTED_ID);
            } catch (TimeoutException e) {
                try {
                    loginPage.shortestWaitUsernamePageToLoad();
                    loginPage.insertUserName(BaseUtils.getUserName());
                    loginPage.clickNext();
                    loginPage.waitPasswordPageToLoad();
                    loginPage.insertPassword(TypeLoader.getAppPassword());
                    loginPage.clickSignIn();
                    signaturePage.waitPageToLoad();
                    signaturePage.createSignature();
                    signaturePage.clickSaveButton();
                    signaturePage.confirmSignature();
                    shortWaitUntilPageIsLoadedByIdAndClickable(GET_STARTED_ID);
                } catch (TimeoutException ex) {
                    throw new AutomationException("Could not get to get started page 2 ");
//                    signaturePage.shortestWaitPageToLoad();
//                    signaturePage.createSignature();
//                    signaturePage.clickSaveButton();
//                    signaturePage.confirmSignature();
//                    shortWaitUntilPageIsLoadedByIdAndClickable(GET_STARTED_ID);

                } catch (Exception e2) {
                    throw new AutomationException("Unable to start Signature service / access reference data. #2");
                }
            }

            if (TestHandler.testTypeEnabledCached().get() && TestHandler.currentCacheDisabled().get()) {
                clickToEnableOrDisable();
                TestHandler.currentCacheDisabled().set(false);
            } else if (!TestHandler.testTypeEnabledCached().get() && !TestHandler.currentCacheDisabled().get()) {
                clickToEnableOrDisable();
                TestHandler.currentCacheDisabled().set(true);
            }

            findElementById(GET_STARTED_ID).click();
        }

    }


    public void clickToEnableOrDisable() {
        try {
            Thread.sleep(700);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int initial = 0;
        while (initial != 5) {


            try {
                Thread.sleep(300);
                initial++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            tapByCoordinates(70, 140);
        }
    }


    public void clickStartButton() {
        findElementById(GET_STARTED_ID).click();
    }

    public void waitUntilPageIsLoaded() {
        waitUntilPageIsLoadedById(GET_STARTED_ID);
    }

    public boolean checkIfGetStartedButtonIsDisplayed() {
        return findElementByAccessibilityId(GET_STARTED_ID).isDisplayed();
    }

    public boolean checkIfLaunchImageIsDisplayed() {
        return findElementByClassName(LAUNCH_PAGE_IMAGE).isEnabled();
    }

    public boolean checkIfBetaTextIsDisplayed() {
        return findElementByAccessibilityId(BETA_TEXT).isDisplayed();
    }

    public boolean checkIfTitleIsDisplayed() {
        return findElementByAccessibilityId(TITLE).isDisplayed();
    }

    public boolean checkIfSubTitle1IsDisplayed() {
        return findElementByAccessibilityId(SUBTITLE_1).isDisplayed();
    }

    public boolean checkIfSubTitle2IsDisplayed() {
        return findElementByAccessibilityId(SUBTITLE_2).isDisplayed();
    }

}
