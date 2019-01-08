package pages;



public class LaunchPage extends BasePage {

    private static final String GET_STARTED_ID = "Get Started";

    public void clickGetStarted() {
        longWaitUntilPageIsLoadedById(GET_STARTED_ID).click();
    }

}
