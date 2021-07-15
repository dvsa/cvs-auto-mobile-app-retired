package pages;

import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    private static final String EMAIL_PHONE_OR_SKYPE_FIELD_ID = "Email, phone, or Skype";
    private static final String NEXT_BUTTON_XPATH= "//XCUIElementTypeButton[@name='Next']";
    private static final String PASSWORD_FIELD_ID = "Password";
    private static final String SIGN_ID_BUTTON_ID = "Sign in";
    private static final String CONTINUE_BUTTON_ID = "Continue";

    public void insertUserName(String username) {
        WebElement inputField = findElementById(EMAIL_PHONE_OR_SKYPE_FIELD_ID);
        inputField.click();
        inputField.clear();
        inputField.sendKeys(username);
    }

    public void insertPassword(String password) {
        WebElement inputField = findElementById(PASSWORD_FIELD_ID);
        inputField.click();
        inputField.clear();
        inputField.sendKeys(password);
    }

    public void clickNext() {
        findElementByXpath(NEXT_BUTTON_XPATH).click();
    }

    public void clickSignIn() {
        findElementByAccessibilityId(SIGN_ID_BUTTON_ID).click();
    }

    public void waitUntilPageIsLoaded() {
        waitUntilPageIsLoadedById(SIGN_ID_BUTTON_ID);
    }

    public void clickContinueButton() {
        findElementById(CONTINUE_BUTTON_ID).click();
    }

    public void waitUsernamePageToLoad() {
        longWaitUntilPageIsLoadedByIdAndClickable(EMAIL_PHONE_OR_SKYPE_FIELD_ID);
    }

    public void shortestWaitUsernamePageToLoad() {
        shortestWaitUntilPageIsLoadedByIdAndClickable(EMAIL_PHONE_OR_SKYPE_FIELD_ID);
    }

    public void waitPasswordPageToLoad() {
        waitUntilPageIsLoadedById(PASSWORD_FIELD_ID);
    }

    public void waitContinueButtonToLoad() {
        waitUntilPageIsLoadedById(CONTINUE_BUTTON_ID);
    }
}
