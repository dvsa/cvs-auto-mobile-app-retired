package pages;

public class AdvisoryDetailsPage extends BasePage {

    public static final String ADVISORY_DETAILS_PAGE_ID = "Advisory details";
    public static final String ADD_NOTES_TEXT_FIELD_XPATH = "//*[@type='XCUIElementTypeTextView']";
    public static final String ADD_NOTES_CONFIRM_ID = "Add Note";
    public static final String DONE_BUTTON_ID = "Done";


    public void waitUntilPageIsLoaded() {
        waitUntilPageIsLoadedById(ADVISORY_DETAILS_PAGE_ID);
    }

    public void sendTextOnAddNote(String data) {
        findElementByXpath(ADD_NOTES_TEXT_FIELD_XPATH).sendKeys(data);
    }

    public void tapAddNote() {
        findElementById(ADD_NOTES_CONFIRM_ID).click();
    }

    public void tapDone() {
        findElementById(DONE_BUTTON_ID).click();
    }

    public String getCurrentNote() {
        return findElementByXpath(ADD_NOTES_TEXT_FIELD_XPATH).getAttribute("value");
    }
}
