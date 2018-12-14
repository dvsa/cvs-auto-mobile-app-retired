package pages;

public class SelectPreparerPage extends BasePage {

    private static final String SELECT_PREPARER_PAGE_TITLE = "Select preparer";
    private static final String CONFIRM_BUTTON_ID = "Confirm";

    public void waitUntilPageIsLoaded() {
        waitUntilPageIsLoadedById(SELECT_PREPARER_PAGE_TITLE);
    }

    public void selectPreparer(String id, String name) {
        findElementById(id + " " + name).click();
    }

    public void confirm() {
        findElementById(CONFIRM_BUTTON_ID).click();
    }
}
