package pages;

import org.openqa.selenium.NoSuchElementException;

public class SiteVisitSelectReasonPage extends BasePage {

    private static final String SAVE_BUTTON_ID = "Save";
    private static final String POP_UP_TITLE = "Add notes";
    private static final String POP_UP_TEXT_ID = "You've selected 'Site issue', give more details in notes section.";
    private static final String POP_UP_CONFIRM_ID = "OK";
    private static final String ADD_NOTES_BOX_CLASS_NAME = "XCUIElementTypeTextView";

    public void waitUntilPageIsLoaded() {
        waitUntilPageIsLoadedById(SAVE_BUTTON_ID);
    }


    private static final String REASON_TEXT_1 = "Waiting for vehicle";
    private static final String REASON_TEXT_2 = "Admin";
    private static final String REASON_TEXT_3 = "Break";
    private static final String REASON_TEXT_4 = "Site issue (notes required)";
    private static final String REASON_TEXT_5 = "Other (notes required)";

    public void clickSave() {
        findElementByAccessibilityId(SAVE_BUTTON_ID).click();
    }

    public boolean isPopUpDisplayed() {
        boolean status;
        try {
            status = findElementByAccessibilityId(POP_UP_TITLE).isDisplayed() && findElementByAccessibilityId(POP_UP_TEXT_ID).isDisplayed();
        } catch (NoSuchElementException e) {
            status = false;
        }
        return status;
    }

    public void clickOk() {
        findElementByAccessibilityId(POP_UP_CONFIRM_ID).click();
    }

    public void clickOnNotes() {
        findElementByClassName(ADD_NOTES_BOX_CLASS_NAME).click();
    }

    public void typeText(String text) {
        findElementByClassName(ADD_NOTES_BOX_CLASS_NAME).sendKeys(text);
    }


    public enum Reasons {WAITING_FOR_VEHICLE, ADMIN, BREAK, SITE_ISSUE, OTHER}



    public boolean isReasonSelected(Reasons reason) {
        switch (reason) {
            case WAITING_FOR_VEHICLE:
                return findElementByXpath("//XCUIElementTypeSwitch[@name=\"" + REASON_TEXT_1 + "\"]").getAttribute("value").equals("1");
            case ADMIN:
                return findElementByXpath("//XCUIElementTypeSwitch[@name=\"" + REASON_TEXT_2 + "\"]").getAttribute("value").equals("1");
            case BREAK:
                return findElementByXpath("//XCUIElementTypeSwitch[@name=\"" + REASON_TEXT_3 + "\"]").getAttribute("value").equals("1");
            case SITE_ISSUE:
                return findElementByXpath("//XCUIElementTypeSwitch[@name=\"" + REASON_TEXT_4 + "\"]").getAttribute("value").equals("1");
            case OTHER:
                return findElementByXpath("//XCUIElementTypeSwitch[@name=\"" + REASON_TEXT_5 + "\"]").getAttribute("value").equals("1");
            default:
                return false;
        }
    }

    public void selectReason(Reasons reason) {
        switch(reason) {
            case WAITING_FOR_VEHICLE:
                findElementByXpath("//XCUIElementTypeSwitch[@name=\"" + REASON_TEXT_1 + "\"]").click();
                break;
            case ADMIN:
                findElementByXpath("//XCUIElementTypeSwitch[@name=\"" + REASON_TEXT_2 + "\"]").click();
                break;
            case BREAK:
                findElementByXpath("//XCUIElementTypeSwitch[@name=\"" + REASON_TEXT_3 + "\"]").click();
                break;
            case SITE_ISSUE:
                findElementByXpath("//XCUIElementTypeSwitch[@name=\"" + REASON_TEXT_4 + "\"]").click();
                break;
            case OTHER:
                findElementByXpath("//XCUIElementTypeSwitch[@name=\"" + REASON_TEXT_5 + "\"]").click();
                break;
        }

    }
}
