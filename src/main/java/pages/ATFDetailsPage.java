package pages;


public class ATFDetailsPage extends BasePage {

    private static final String START_VISIT_ID = "Start visit";
    private static final String YES_ID = "Yes";


    public void waitUntilPageIsLoaded() {
        waitUntilPageIsLoadedById(START_VISIT_ID);
    }

    public void clickStartVisit() {
        findElementById(START_VISIT_ID).click();
    }

    public void selectYes() {
        findElementById(YES_ID).click();
    }
}
