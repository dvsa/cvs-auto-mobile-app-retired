package pages;

public class ConfirmationPage extends BasePage {

    private static String DONE_BUTTON_ID = "Done";


    public void clickDoneButton() {
        System.out.println(" DONE:  " + getDriver().getPageSource());
        findElementById(DONE_BUTTON_ID).click();
    }

    public void waitUntilPageIsLoaded() {
        waitUntilPageIsLoadedById(DONE_BUTTON_ID);
    }
}
