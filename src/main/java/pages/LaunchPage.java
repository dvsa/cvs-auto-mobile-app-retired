package pages;


import io.appium.java_client.ios.IOSDriver;
import net.thucydides.core.webdriver.WebDriverFacade;
import org.openqa.selenium.TimeoutException;
import util.TestHandler;
import util.TypeLoader;


public class LaunchPage extends BasePage {

    private static final String GET_STARTED_ID = "Get started";
    private static final String LAUNCH_PAGE_IMAGE = "XCUIElementTypeImage";
    private static final String BETA_TEXT = "BETA";
    private static final String TITLE_1 = "Vehicle Standards";
    private static final String TITLE_2 = "Assessment";
    private static final String SUBTITLE = "Mobile Test Capture";

    public void clickGetStarted(LoginPage loginPage, SignaturePage signaturePage) {

        if (!TestHandler.getInitializedStatus().get()) {
            try {
                loginPage.waitUsernamePageToLoad();
                loginPage.insertUserName(TypeLoader.getAppUsername());
                loginPage.clickNext();
                loginPage.waitPasswordPageToLoad();
                loginPage.insertPassword(TypeLoader.getAppPassword());
                loginPage.clickSignIn();
                signaturePage.waitPageToLoad();
                signaturePage.createSignature();
                signaturePage.clickSaveButton();
                signaturePage.confirmSignature();
                shortWaitUntilPageIsLoadedByIdAndClickable(GET_STARTED_ID);
            } catch (TimeoutException e) {
                try {
                    signaturePage.shortestWaitPageToLoad();
                    signaturePage.createSignature();
                    signaturePage.clickSaveButton();
                    signaturePage.confirmSignature();
                    shortWaitUntilPageIsLoadedByIdAndClickable(GET_STARTED_ID);
                } catch (TimeoutException ex) {

                    shortestWaitUntilPageIsLoadedByIdAndClickable(GET_STARTED_ID);
                }
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
                    loginPage.insertUserName(TypeLoader.getAppUsername());
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

                    signaturePage.shortestWaitPageToLoad();
                    signaturePage.createSignature();
                    signaturePage.clickSaveButton();
                    signaturePage.confirmSignature();
                    shortWaitUntilPageIsLoadedByIdAndClickable(GET_STARTED_ID);

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


        public void clickToEnableOrDisable () {
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


        public void clickStartButton () {
            findElementById(GET_STARTED_ID).click();
        }

        public void waitUntilPageIsLoaded () {
            waitUntilPageIsLoadedById(GET_STARTED_ID);
        }

        public boolean checkIfGetStartedButtonIsDisplayed () {
            return findElementByXpath(GET_STARTED_ID).isDisplayed();
        }

        public boolean checkIfLaunchImageIsDisplayed () {
            return findElementByXpath(LAUNCH_PAGE_IMAGE).isDisplayed();
        }

        public boolean checkIfBetaTextIsDisplayed () {
            return findElementByXpath(BETA_TEXT).isDisplayed();
        }

        public boolean checkIfTitle1IsDisplayed () {
            return findElementByXpath(TITLE_1).isDisplayed();
        }

        public boolean checkIfTitle2IsDisplayed () {
            return findElementByXpath(TITLE_2).isDisplayed();
        }

        public boolean checkIfSubTitleIsDisplayed () {
            return findElementByXpath(SUBTITLE).isDisplayed();
        }

    }
