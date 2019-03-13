package pages;

import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    private static final String EMAIL_PHONE_OR_SKYPE_FIELD_ID = "Enter your email, phone, or Skype.";
    private static final String NEXT_BUTTON_ID = "Next";
    private static final String PASSWORD_FIELD_ID = "Password";
    private static final String SIGN_ID_BUTTON_ID = "Sign in";

    public void insertUserName(String username) {
        WebElement inputField = findElementById(EMAIL_PHONE_OR_SKYPE_FIELD_ID);
        inputField.click();
        inputField.clear();
        inputField.sendKeys(username);
    }

    public void insertPassword(String password) {
        WebElement inputField = findElementById(PASSWORD_FIELD_ID);
        inputField.clear();
        inputField.sendKeys(password);
    }

    public void clickNext() {
        findElementById(NEXT_BUTTON_ID).click();
    }

    public void clickSignIn() {
        findElementById(SIGN_ID_BUTTON_ID).click();
    }

    public void waitUsernamePageToLoad() {
        waitUntilPageIsLoadedById(EMAIL_PHONE_OR_SKYPE_FIELD_ID);
    }

    public void waitPasswordPageToLoad() {
        waitUntilPageIsLoadedById(PASSWORD_FIELD_ID);
    }
}
