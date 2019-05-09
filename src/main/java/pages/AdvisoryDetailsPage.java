package pages;

import org.openqa.selenium.WebElement;

public class AdvisoryDetailsPage extends BasePage {

    public static final String ADVISORY_DETAILS_PAGE_ID = "Advisory details";
    public static final String ADD_NOTES_TEXT_FIELD_ID = "Add Notes";
    public static final String ADD_NOTES_CONFIRM_ID = "Add Note";
    public static final String DONE_BUTTON_ID = "Done";


    public void waitUntilPageIsLoaded() {
        waitUntilPageIsLoadedById(ADVISORY_DETAILS_PAGE_ID);
    }

    public void sendTextOnAddNote(String data) {
        WebElement element = findElementByAccessibilityId(ADD_NOTES_TEXT_FIELD_ID);
        element.clear();
        element.sendKeys(data);
    }

    public void tapAddNote() {
        findElementById(ADD_NOTES_CONFIRM_ID).click();
    }

    public void tapDone() {
        findElementById(DONE_BUTTON_ID).click();
    }

    public String getCurrentNote() {
        return findElementByAccessibilityId(ADD_NOTES_TEXT_FIELD_ID).getAttribute("value");
    }
}
