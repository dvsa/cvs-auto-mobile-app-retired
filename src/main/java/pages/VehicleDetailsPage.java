package pages;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class VehicleDetailsPage extends BasePage {

    private static final String VEHICLE_DETAILS_PAGE_TITLE = "Vehicle details";
    private static final String CONFIRM_BUTTON_ID = "Confirm";
    private static final String ADDITIONAL_VEHICLE_DETAILS_BUTTON_ID = "Additional vehicle details";
    private static final String PAGE_ALL_TEXT_XPATH = "//XCUIElementTypeStaticText";

    private static final String CANCEL_ID = "Cancel";
    private static final String CONFIRM_ID = "Confirm";
    private static final String CONFIRM_VEHICLE_ID = "Confirm vehicle";
    private static final String CONFIRMATION_TEXT_ID = "This action will confirm the vehicle for testing.";

    public void waitUntilPageIsLoaded() {
        waitUntilPageIsLoadedById(VEHICLE_DETAILS_PAGE_TITLE);
    }

    public boolean isDetailPageScrollable() {
        this.scrollDetailPage();

        return findElementById(ADDITIONAL_VEHICLE_DETAILS_BUTTON_ID).isDisplayed();
    }

    // TODO extend functionality, you should pass the element as a parameter
    public void scrollDetailPage() {
        // method 1
//        try {
//            findElementById(ADDITIONAL_VEHICLE_DETAILS_BUTTON_ID);
//        }catch (NullPointerException e){
//            System.out.println("NU IL VEDE!!!!");
//        }
        //method 2
//        TouchActions action = new TouchActions(getDriver());
//        action.scroll(findElementById(ADDITIONAL_VEHICLE_DETAILS_BUTTON_ID), 10, 100);
//        action.build().perform();
        //method 3
//        JavascriptExecutor js = (JavascriptExecutor) getDriver();
//        Map<String, Object> params = new HashMap<>();
//        params.put("direction", "down");
//        params.put("element", ((RemoteWebElement) findElementById(ADDITIONAL_VEHICLE_DETAILS_BUTTON_ID)).getId());
//        js.executeScript("mobile: swipe", params);
        //method 4
//        TouchAction touchAction = new TouchAction((PerformsTouchActions) getDriver());
//        touchAction.longPress(a).moveTo(100, 800).release().perform();

    }

    /**
     * Creates a list of the vehicle summary values using xpath
     * @return
     * the list of data containing both Keys and Values of the details page
     */
    public List<String> findAllValuesByXpath() {
        List<WebElement> webElementList = findElementsByXpath(PAGE_ALL_TEXT_XPATH);
        List<String> listOfData = new ArrayList<>();
        for (WebElement webElement : webElementList) {
            listOfData.add(webElement.getAttribute("value"));
        }

        return listOfData;
    }



    public void clickConfirm() {
        findElementById(CONFIRM_BUTTON_ID).click();
    }

    public void clickCancel() {
        findElementById(CANCEL_ID).click();
    }

    public boolean isConfirmationPopUpVisible() {
        boolean status = false;
        WebElement cancelButton = findElementById(CANCEL_ID);
        WebElement confirmButton = findElementById(CONFIRM_ID);
        WebElement text = findElementById(CONFIRMATION_TEXT_ID);
        WebElement title = findElementById(CONFIRM_VEHICLE_ID);
        if(cancelButton.isDisplayed() && confirmButton.isDisplayed() && text.isDisplayed() && title.isDisplayed()) {
            status = true;
        }
        return status;
    }

    public boolean isPageTitleDisplayed() {
        boolean status = false;
        if(findElementById(VEHICLE_DETAILS_PAGE_TITLE).isDisplayed()) {
            status = true;
        }
        return status;
    }

    public boolean isRegistrationPlateDisplayed(String registrationPlate) {
        boolean status = false;
        if(findElementById(registrationPlate).isDisplayed()){
            status = true;
        }
        return status;
    }
}
