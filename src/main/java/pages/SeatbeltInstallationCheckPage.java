package pages;

import org.openqa.selenium.WebElement;


public class SeatbeltInstallationCheckPage extends BasePage {

    private static final String INPUT_FIELD = "XCUIElementTypeTextField";
    private static final String DONE_BUTTON_ID = "Done";
    private static final String CANCEL_BUTTON_ID = "Cancel";
    private static final String PAGE_TITLE_ID = "Seatbelt installation check";
    private static final String INPUT_FIELD_TITLE = "NUMBER OF SEATBELTS FITTED";
    private static final String BELOW_INPUT_FIELD_TEXT = "If there are no seatbelts fitted, enter zero (0).";


    public void waitUntilPageIsLoaded() {
        waitUntilPageIsLoadedById(PAGE_TITLE_ID);
    }

    public void setSetbealtNumber(String seatbeltNumber) {
        WebElement input = findElementByClassName(INPUT_FIELD);
        input.clear();
        input.sendKeys(seatbeltNumber);
    }

    public void clickDone() {
        findElementById(DONE_BUTTON_ID).click();
    }

    public void clickCancel() {
        waitUntilPageIsLoaded();
        findElementById(CANCEL_BUTTON_ID).click();
    }

    public boolean isCancelDisplayed() {
        return findElementById(CANCEL_BUTTON_ID).isDisplayed();
    }

    public boolean isDoneDisplayed() {
        return findElementById(DONE_BUTTON_ID).isDisplayed();
    }

    public boolean isPageTitleDisplayed() {
        return findElementByAccessibilityId(PAGE_TITLE_ID).isDisplayed();
    }

    public boolean isInputFieldDisplayed() {
        return findElementByClassName(INPUT_FIELD).isDisplayed();
    }

    public boolean isFieldTitleDisplayed() {
        return findElementByAccessibilityId(INPUT_FIELD_TITLE).isDisplayed();
    }

    public boolean isFieldTextDisplayed() {
        return findElementByAccessibilityId(BELOW_INPUT_FIELD_TEXT).isDisplayed();
    }
}
