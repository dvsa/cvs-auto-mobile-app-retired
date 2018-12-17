package pages;

public class SelectPreparerPage extends BasePage {

    private static final String SELECT_PREPARER_PAGE_TITLE = "Select preparer";
    private static final String CONFIRM_BUTTON_ID = "Confirm";
    private static final String PAGE_TITLE_ID = "Select preparer";

    public void waitUntilPageIsLoaded() {
        waitUntilPageIsLoadedById(SELECT_PREPARER_PAGE_TITLE);
    }

    public void selectPreparer(String id, String name) {
        findElementById(id + " " + name).click();
    }

    public void confirm() {
        findElementById(CONFIRM_BUTTON_ID).click();
    }

    public boolean isTitleDisplayed() {
        boolean status = false;
        if(findElementById(PAGE_TITLE_ID).isDisplayed()){
            status = true;
        }
        return status;
    }
}
