package pages;


public class ATFDetailsPage extends BasePage {

    private static final String START_VISIT_ID = "Start visit";
    private static final String POP_UP_CONFIRM_ID = "Confirm";


    public void waitUntilPageIsLoaded() {
        waitUntilPageIsLoadedById(START_VISIT_ID);
    }

    public void clickStartVisit() {
        findElementById(START_VISIT_ID).click();
    }

    public void selectConfirmInPopUp() {
        findElementById(POP_UP_CONFIRM_ID).click();
    }
}
