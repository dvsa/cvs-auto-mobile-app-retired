package pages;

public class SelectReasonPage extends BasePage {

    private static final String SELECT_REASON_PAGE_TITLE = "Select reason";
    private static final String SELECT_REASON_BACK_BUTTON = "arrow back Test";
    private static final String SELECT_REASON_TEXT_TIP = "You can select multiple reasons for abandoning this test";

    public void waitUntilPageIsLoaded() {
        waitUntilPageIsLoadedById(SELECT_REASON_PAGE_TITLE);
    }

    public boolean isPageTitleDisplayed() {
        boolean status = false;
        if(findElementById(SELECT_REASON_PAGE_TITLE).isDisplayed()) {
            status = true;
        }
        return status;
    }

    public boolean isTextTipDisplayed() {
        boolean status = false;
        if(findElementById(SELECT_REASON_TEXT_TIP).isDisplayed()) {
            status = true;
        }
        return status;
    }

    public void clickOnBackButton() {
        findElementById(SELECT_REASON_BACK_BUTTON).click();
    }
}
