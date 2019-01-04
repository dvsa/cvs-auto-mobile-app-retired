package pages;

public class AdvisoryDetailsPage extends BasePage {

    public static final String ADVISORY_DETAILS_PAGE_ID = "Advisory details";
    public static final String ADD_NOTES_TEXT_FIELD = "Add Notes";
    public static final String ADD_NOTES_CONFIRM_ID= "Add Note";


    public void waitUntilPageIsLoaded() {
        waitUntilPageIsLoadedById(ADVISORY_DETAILS_PAGE_ID);
    }

    public void sendTextOnAddNote(String data) {
        findElementByXpath("//*[@value='" + ADD_NOTES_TEXT_FIELD + "']").sendKeys(data);
    }

    public void tapAddNote() {
        findElementById(ADD_NOTES_CONFIRM_ID).click();
    }
}
