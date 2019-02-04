package pages;

import org.openqa.selenium.WebElement;

import java.util.List;

public class SiteVisitPage extends BasePage {

    private static final String PAGE_TITLE = "Site Visit";
    private static final String CREATE_TEST_ID = "Create test";
    private static final String BUTTONS_CLASS_NAME = "XCUIElementTypeButton";

    public void waitUntilPageIsLoaded() {
        waitUntilPageIsLoadedById(CREATE_TEST_ID);
    }

    public void clickCreateNewTest() {
        findElementById(CREATE_TEST_ID).click();
    }

    public boolean isPageTitleDisplayed() {
        return findElementById(PAGE_TITLE).isDisplayed();
    }

    public boolean isCancelledlStatusDisplayed(String registrationPlate) {
        return findElementByXpath("//XCUIElementTypeButton[contains(@name,'Test (" + registrationPlate + ") CANCELLED')]").isDisplayed();
    }

    public boolean isBackButtonAvailable() {
        boolean status = false;
        List<WebElement> listOfButtons = findElementsByClassName(BUTTONS_CLASS_NAME);
        for (WebElement button : listOfButtons) {
            if (button.getText().contains("arrow back")) {
                status = true;
                break;
            }
        }
        return status;
    }
}
