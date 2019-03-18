package pages;

public class SiteVisitSubmittedPage extends BasePage {

    private static final String DONE_BUTTON_ID = "Done";
    private static final String TEXT_XPATH = "//*[contains(@name,'Site visit has been submitted and sent to DVSA and ')]";

    public void waitUntilPageIsLoaded() {
        waitUntilPageIsLoadedByXpath(TEXT_XPATH);
    }
    
    public void clickDone() {
        findElementByAccessibilityId(DONE_BUTTON_ID).click();
    }

    public boolean isElementDisplayed(String atfName) {
        return findElementByXpath("//*[contains(@name,'Site visit has been submitted and sent to DVSA and "+ atfName + "')]").isDisplayed();
    }
}
