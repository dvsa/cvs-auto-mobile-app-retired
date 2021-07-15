package pages;

import exceptions.AutomationException;
import org.openqa.selenium.TimeoutException;
import util.TypeLoader;

public class LaunchPage extends BasePage {

    private static final String GET_STARTED_ID = "Get started";
    private static final String LAUNCH_PAGE_IMAGE = "XCUIElementTypeImage";
    private static final String BETA_TEXT = "BETA";
    private static final String TITLE = "Vehicle Testing";
    private static final String SUBTITLE_1 = "Use this app to record PSV tests at";
    private static final String SUBTITLE_2 = "Authorised Testing Facilities (ATFs).";

    public void clickGetStarted(LoginPage loginPage, SignaturePage signaturePage, String username) {

        String password = TypeLoader.getUsers().get(username).getPassword();

        loginPage.waitUsernamePageToLoad();
        loginPage.insertUserName(username);
        loginPage.clickNext();
        loginPage.waitPasswordPageToLoad();
        loginPage.insertPassword(password);
        loginPage.clickSignIn();
        loginPage.waitContinueButtonToLoad();
        loginPage.clickContinueButton();
        try {
            signaturePage.waitPageToLoad();
        } catch (TimeoutException ex) {
            throw new AutomationException("Could not get to get started page 2 ");
        } catch (Exception e2) {
            throw new AutomationException("Unable to start Signature service / access reference data. #2");
        }
        signaturePage.createSignature();
        signaturePage.clickSaveButton();
        signaturePage.confirmSignature();
        shortWaitUntilPageIsLoadedByIdAndClickable(GET_STARTED_ID);
        findElementById(GET_STARTED_ID).click();
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
