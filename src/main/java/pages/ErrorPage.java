package pages;

import org.openqa.selenium.WebElement;

public class ErrorPage extends BasePage {

    private static final String ERROR_TITLE_NAME = "Unable to load data";
    private static final String ERROR_SUB_TITLE_ID = "Make sure you are connected to the internet and try again";
    private static final String SETTINGS_ID = "Settings";
    private static final String CALL_TECH_SUPPORT_ID = "Call Technical Support";
    private static final String TRY_AGAIN_ID = "Try again";
    private static final String SETTINGS_GENERAL_OPTION = "General";
    private static final String LOADING_NAME = "Loading...";


    public WebElement getTitleName() {
        return findElementByAccessibilityIdId(ERROR_TITLE_NAME);
    }


    public WebElement getSubTitle() {
        return findElementByAccessibilityIdId(ERROR_SUB_TITLE_ID);
    }

    public WebElement getSettings() {
        return findElementByAccessibilityIdId(SETTINGS_ID);
    }

    public WebElement getCallTechSupport() {
        return findElementByAccessibilityIdId(CALL_TECH_SUPPORT_ID);
    }


    public WebElement getTryAgain() {
        return findElementByAccessibilityIdId(TRY_AGAIN_ID);
    }


    public void waitUntilPageIsLoaded() {
        waitUntilPageIsLoadedById(ERROR_SUB_TITLE_ID);
    }

    public void clickCallTechSupport() {
        getCallTechSupport().click();
    }

    public void clickTryAgain() {
        getTryAgain().click();
    }

    public void clickSettings() {
        getSettings().click();
    }

    public void waitUntilSettingsAppIsDisplayed() {
        waitUntilPageIsLoadedByAccessibilityId(SETTINGS_GENERAL_OPTION);
    }

    public boolean waitUntilLoadingIsDisplayed() {
        return waitUntilPageIsLoadedByAccessibilityId(LOADING_NAME).isDisplayed();
    }

}
