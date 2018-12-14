package pages;

public class VehicleDetailsPage extends BasePage {

    private static final String VEHICLE_DETAILS_PAGE_TITLE = "Vehicle details";
    private static final String CONFIRM_BUTTON_ID = "Confirm";

    public void waitUntilPageIsLoaded() {
        waitUntilPageIsLoadedById(VEHICLE_DETAILS_PAGE_TITLE);
    }

    public void clickConfirm() {
        findElementById(CONFIRM_BUTTON_ID).click();
    }


}
