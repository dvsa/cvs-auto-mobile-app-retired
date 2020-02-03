package pages;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebElement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestPage extends BasePage {

    private static final String TEST_PAGE_TITLE = "Test";
    private static final String ADD_TEST_TYPE_BUTTON_ID = "Add a test type";
    private static final String ADD_A_TRAILER_BUTTON_ID = "Add a trailer";
    private static final String PAGE_ALL_BUTTONS_CLASS_NAME = "XCUIElementTypeButton";
    private static final String ADD_LINKED_TEST_TYPE_BUTTON_ID = "Add a linked test";
    private static final String REMOVE_BUTTON_ID = "Remove";
    private static final String CANCEL_BUTTON_BOTTOM_RIGHT = "Cancel test";
    private static final String CANCEL_ID = "Cancel";
    private static final String REMOVE_ID = "Remove";
    private static final String DESCRIPTION_ID = "This action will remove this test from the vehicle.";
    private static final String TITLE_ID = "Remove test";
    private static final String ABANDON_BUTTON_ID = "Abandon";
    private static final String TEST_NOT_COMPLETE_TITLE = "Test not complete";
    private static final String TEST_NOT_COMPLETE_INFO = "You must complete all test types marked \"in progress\" before reviewing.";
    private static final String OK_BUTTON = "OK";
    private static final String VEHICLE_DETAILS_BUTTON_XPATH = "//XCUIElementTypeButton[contains(@name, 'Details')]";
    private static final String REVIEW_AND_SUBMIT = "Review and submit";
    private static final String TRAILER_ICON_IMAGE = "XCUIElementTypeImage";
    private static final String ADD_A_VEHICLE_BUTTON_ID = "Add a vehicle";
    private static final String TEST_IN_PROGRESS_TITLE = "Voluntary test In progress";
    private static final String TEST_IN_PROGRESS_INFO = "You must complete all vehicle and test type details before reviewing.";


    public boolean checkMessageIsDisplayed(String expectedErrorMessage) {
        try {
            return findElementById(expectedErrorMessage).isDisplayed();
        } catch (Exception exception) {
            return false;
        }
    }

    public boolean OdometerOptionIsDisplayed() {
        return findElementByXpath("//XCUIElementTypeButton[starts-with(@name,'Odometer reading')]").isDisplayed();
    }

    public boolean isPropertyDisplayedXTimes(String property, int times) {
        waitUntilPageIsLoaded();
        List<WebElement> buttonList = findElementsByClassName(PAGE_ALL_BUTTONS_CLASS_NAME);
        int timesFound = 0;
        for (WebElement button : buttonList) {
            if (button.getAttribute("name").contains(property)) {
                timesFound++;
            }
        }
        return (times == timesFound);
    }

    public boolean isItemDisplayedAfter(String item1, String item2) {
        List<WebElement> buttonList = findElementsByClassName(PAGE_ALL_BUTTONS_CLASS_NAME);
        return buttonList.indexOf(item1) > buttonList.indexOf(item2);
    }

    public void clickCountryOfRegistrationOf(String vehicle) {
        waitUntilPageIsLoaded();
        for (WebElement button : getButtonsOfVehicle(vehicle)) {

            if (button.getAttribute("name").contains("Country of registration")) {

                button.click();
            }
        }

    }

    public void clickEuVehicleCategoryFor(String vehicle) {
        waitUntilPageIsLoaded();
        for (WebElement button : getButtonsOfVehicle(vehicle)) {
            if (button.getAttribute("name").contains("EU vehicle category")) {
                button.click();
            }
        }
    }

    public void clickUnsetEuVehicleCategory() {
        waitUntilPageIsLoaded();
        findElementByXpath("//*[@name='EU vehicle category Select arrow forward']").click();
    }

    public void clickOdometerReadingOf(String vehicle) {
        waitUntilPageIsLoaded();
        for (WebElement button : getButtonsOfVehicle(vehicle)) {
            if (button.getAttribute("name").startsWith("Odometer reading")) {
                button.click();
            }
        }

    }

    public boolean checkCountryOfRegistrationFieldIsUpdatedFor(String country, String vehicle) {
        waitUntilPageIsLoaded();
        List<WebElement> allButtonsOfVehicle = getButtonsOfVehicle(vehicle);
        for (WebElement button : allButtonsOfVehicle) {
            if (button.getAttribute("name").contains("Country of registration")) {
                return button.getAttribute("name").contains(country);
            }
        }
        return false;
    }

    private List<WebElement> getButtonsOfVehicle(String vehicle) {
        List<WebElement> buttonList = findElementsByClassName(PAGE_ALL_BUTTONS_CLASS_NAME);
        for (WebElement button : buttonList) {
            if (button.getAttribute("name").contains(vehicle)) {
                int index = buttonList.indexOf(button) + 1;
                do {
                    System.out.println("button: " + buttonList.get(index).getAttribute("name"));
                    index++;
                }
                while (!(buttonList.get(index).getAttribute("name").contains("Add a test type")) && (index < buttonList.size()));
                for (WebElement we : buttonList.subList(buttonList.indexOf(button) + 1, index + 1)) {
                    System.out.println("element of list is: " + we.getAttribute("name"));
                }
                return buttonList.subList(buttonList.indexOf(button) + 1, index + 1);
            }
        }
        return null;
    }


    public boolean isCarRegistrationPlateDisplayed(String regPlate, String vin) {
        System.out.println("looking for: " + "//XCUIElementTypeButton[@name='" + regPlate + " (CAR) " + vin + " Details arrow forward']");
        return findElementByXpath("//XCUIElementTypeButton[@name='" + regPlate + " (CAR) " + vin + " Details arrow forward']").isDisplayed();
    }

    public boolean isMotoRegistrationPlateDisplayed(String moto, String vin) {
        System.out.println("looking for: " + "//XCUIElementTypeButton[@name='" + moto + " (MOTORCYCLE) " + vin + " Details arrow forward']");
        return findElementByXpath("//XCUIElementTypeButton[@name='" + moto + " (MOTORCYCLE) " + vin + " Details arrow forward']").isDisplayed();
    }

    public boolean isLgvRegistrationPlateDisplayed(String lgv, String vin) {
        System.out.println("looking for: " + "//XCUIElementTypeButton[@name='" + lgv + " (LGV) " + vin + " Details arrow forward']");
        return findElementByXpath("//XCUIElementTypeButton[@name='" + lgv + " (LGV) " + vin + " Details arrow forward']").isDisplayed();
    }

    public enum OdometerUnitIndicatives {
        ENTER("Enter"), KM("km"), MI("mi");

        private String value;

        OdometerUnitIndicatives(String _value) {
            this.value = _value;
        }

        public String getValue() {
            return this.value;
        }
    }

    public enum TestTypeStatuses {
        IN_PROGRESS("In progress"), EDIT("Edit"), ABANDONED("ABANDONED");

        private String value;

        TestTypeStatuses(String _value) {
            this.value = _value;
        }

        public String getValue() {
            return this.value;
        }
    }

    public void waitUntilPageIsLoaded() {
        waitUntilPageIsLoadedById(TEST_PAGE_TITLE);
    }

    public void addTestType() {
        findElementById(ADD_TEST_TYPE_BUTTON_ID).click();
    }

    public void addTestTypeFor(String vehicle) {
        waitUntilPageIsLoaded();
        List<WebElement> allButtonsOfVehicle = getButtonsOfVehicle(vehicle);
        for (WebElement button : allButtonsOfVehicle) {
            if (button.getAttribute("name").contains(ADD_TEST_TYPE_BUTTON_ID)) {
                button.click();

            }
        }
    }

    public void clickOnTestType(String testType, TestTypeStatuses testTypeStatus) {
        waitUntilPageIsLoaded();
        String id;
        switch (testTypeStatus) {
            case EDIT:
                id = testType + " " + testTypeStatus.getValue() + " checkmark";
                break;
            case ABANDONED:
                id = testType + " " + testTypeStatus.getValue();
                break;
            default:
                id = testType + " " + testTypeStatus.getValue() + " arrow forward";
                break;
        }
        System.out.println("Clicking on: " + id);
        findElementById(id).click();
        System.out.println("- Done");
    }

    public boolean isPageTitleDisplayed() {
        return findElementById(TEST_PAGE_TITLE).isDisplayed();
    }

    public boolean isCancelButtonDisplayed() {
        return findElementByAccessibilityId(CANCEL_BUTTON_BOTTOM_RIGHT).isDisplayed();
    }

    public boolean isVehicleRegistrationPlateDisplayed(String regPlate, String vin) {
        return findElementByXpath("//XCUIElementTypeButton[@name='" + regPlate + " (PSV) " + vin + " Details arrow forward']").isDisplayed();
    }

    public boolean isHgvRegistrationPlateDisplayed(String regPlate, String vin) {
        System.out.println("looking for: " + "//XCUIElementTypeButton[@name='" + regPlate + " (HGV) " + vin + " Details arrow forward']");
        return findElementByXpath("//XCUIElementTypeButton[@name='" + regPlate + " (HGV) " + vin + " Details arrow forward']").isDisplayed();
    }

    public boolean isCarRegistrationPlateDisplayed(String regPlate, String vin) {
        System.out.println("looking for: " + "//XCUIElementTypeButton[@name='" + regPlate + " (CAR) " + vin + " Details arrow forward']");
        return findElementByXpath("//XCUIElementTypeButton[@name='" + regPlate + " (CAR) " + vin + " Details arrow forward']").isDisplayed();
    }

    public boolean isLGVRegistrationPlateDisplayed(String regPlate, String vin) {
        System.out.println("looking for: " + "//XCUIElementTypeButton[@name='" + regPlate + " (LGV) " + vin + " Details arrow forward']");
        return findElementByXpath("//XCUIElementTypeButton[@name='" + regPlate + " (LGV) " + vin + " Details arrow forward']").isDisplayed();
    }

    public boolean isMotorcycleRegistrationPlateDisplayed(String regPlate, String vin) {
        System.out.println("looking for: " + "//XCUIElementTypeButton[@name='" + regPlate + " (MOTORCYCLE) " + vin + " Details arrow forward']");
        return findElementByXpath("//XCUIElementTypeButton[@name='" + regPlate + " (MOTORCYCLE) " + vin + " Details arrow forward']").isDisplayed();
    }

    public boolean isTrailerRegistrationPlateDisplayed(String trailerId, String vin) {
        return findElementByXpath("//XCUIElementTypeButton[@name='" + trailerId + " (Trailer) " + vin + " Details arrow forward']").isDisplayed();
    }

    public boolean checkIfTrailerImageIsDisplayed() {
        return findElementByClassName(TRAILER_ICON_IMAGE).isEnabled();
    }

    public boolean isAddATestTypeButtonDisplayed() {
        return findElementById(ADD_TEST_TYPE_BUTTON_ID).isDisplayed();
    }

    public boolean isTestTypeDisplayedByXpath(String testType) {
        try {
            return findElementByXpath("//XCUIElementTypeButton[contains(@name, '" + testType + "')]").isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isTestTypeStatusDisplayed(String testType, TestTypeStatuses status) {
        waitUntilPageIsLoaded();
        String id;
        boolean isDisplayed;
        switch (status) {
            case EDIT:
                id = testType + " " + status.getValue() + " checkmark";
                break;
            case ABANDONED:
                // TODO refactor after bug fix for CVSB-2065
                id = testType + " " + status.getValue();
                break;
            default:
                id = testType + " " + status.getValue() + " arrow forward";
                break;
        }

        System.out.println("Checking for presence of: " + id);
        isDisplayed = findElementById(id).isDisplayed();
        System.out.println("- " + (isDisplayed ? "True" : "False"));
        return isDisplayed;
    }

    public int checkDataByLabelValueAndName(String... values) {
        return findAllDataByComposedXpath(values).size();
    }

    public void clickVehicleDetails() {
        findElementByXpath(VEHICLE_DETAILS_BUTTON_XPATH).click();
    }

    public boolean isReviewAndSubmitButtonAvailable() {
        return findElementById(REVIEW_AND_SUBMIT).isDisplayed();
    }

    //TODO create generic swipe action in BasePage
    public void swipeLeftOnTestType(String testType) {
        WebElement testTypeToSwipe = findElementByXpath("//XCUIElementTypeButton[contains(@name, '" + testType + "')]");
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        Map<String, Object> params = new HashMap<>();
        params.put("direction", "left");
        params.put("element", ((RemoteWebElement) testTypeToSwipe).getId());
        js.executeScript("mobile: swipe", params);
    }

    public boolean isRemoveButtonDisplayed() {
        return findElementById(REMOVE_BUTTON_ID).isDisplayed();
    }

    public void clickOnRedRemoveButton() {
        findElementById(REMOVE_BUTTON_ID).click();
    }

    public boolean isRemovePopUpDisplayed() {
        boolean status = false;
        boolean isException = false;
        WebElement removeButton = null;
        try {
            removeButton = waitUntilPageIsLoadedById(REMOVE_ID);
        } catch (Exception e) {
            isException = true;
        }

        if (!isException) {
            WebElement description = findElementById(DESCRIPTION_ID);
            WebElement title = findElementById(TITLE_ID);
            WebElement cancelButton = findElementById(CANCEL_ID);
            if (removeButton.isDisplayed() && description.isDisplayed() && title.isDisplayed() && cancelButton.isDisplayed()) {
                status = true;
            }
        }
        return status;
    }

    public void clickRemoveFromPopUp() {
        findElementById(REMOVE_ID).click();
    }

    public void clickCancelFromPopUp() {
        findElementById(CANCEL_ID).click();
    }

    public void clickCancelFromBottomRight() {
        findElementByAccessibilityId(CANCEL_BUTTON_BOTTOM_RIGHT).click();
    }

    public boolean isAbandonButtonDisplayed() {
        return findElementById(ABANDON_BUTTON_ID).isDisplayed();
    }

    public void pressAbandonButton() {
        findElementById(ABANDON_BUTTON_ID).click();
    }

    public boolean isAddALinkedTestVisible() {
        return findElementById(ADD_LINKED_TEST_TYPE_BUTTON_ID).isDisplayed();
    }

    public void addALinkedTestType() {
        findElementById(ADD_LINKED_TEST_TYPE_BUTTON_ID).click();
    }

    public void clickOdometerReading() {
        waitUntilPageIsLoaded();
        List<WebElement> buttonList = findElementsByClassName(PAGE_ALL_BUTTONS_CLASS_NAME);
        for (WebElement button : buttonList) {
            if (button.getAttribute("name").contains("Odometer reading")) {
                button.click();
                break;
            }
        }
    }

    public boolean isOdometerButtonIndicativeDisplayed(OdometerUnitIndicatives odometerUnitIndicatives) {
        boolean status;
        switch (odometerUnitIndicatives) {
            case ENTER:
                status = findElementById("Odometer reading " + odometerUnitIndicatives.getValue() + " arrow forward").isDisplayed();
                break;
            default:
                status = findElementById("Odometer reading " + getOdometerValue() + " " + odometerUnitIndicatives.getValue() + " checkmark").isDisplayed();
                break;
        }
        return status;
    }

    public String getOdometerValue() {
        String value = "";
        waitUntilPageIsLoaded();
        List<WebElement> buttonList = findElementsByClassName(PAGE_ALL_BUTTONS_CLASS_NAME);
        for (WebElement button : buttonList) {
            if (button.getAttribute("name").contains("Odometer reading")) {
                String[] stringArray = button.getAttribute("name").split(" ");
                value = stringArray[2];
                break;
            }
        }
        return value;
    }

    public boolean isTestNotCompleteDisplayed() {
        // return findElementByAccessibilityId(TEST_NOT_COMPLETE_TITLE).isDisplayed() && findElementByAccessibilityId(TEST_NOT_COMPLETE_INFO).isDisplayed();
        return findElementByAccessibilityId(TEST_IN_PROGRESS_TITLE).isDisplayed() && findElementByAccessibilityId(TEST_IN_PROGRESS_INFO).isDisplayed();
    }

    public boolean buttonOkIsClickable() {
        return findElementByAccessibilityId(OK_BUTTON).isEnabled() && findElementByAccessibilityId(OK_BUTTON).isDisplayed();
    }

    public void clickOkButton() {
        findElementByAccessibilityId(OK_BUTTON).click();
    }

    public void clickEUVehicleCategoryOption() {
        findElementByXpath("//XCUIElementTypeButton[starts-with(@name,'EU vehicle category')]").click();
    }

    public boolean checkEUVehicleCategoryOptionIsDisplayed() {
        return findElementByXpath("//XCUIElementTypeButton[starts-with(@name,'EU vehicle category')]").isDisplayed();
    }

    public boolean checkMCategoryIsSelected(String category) {
        return findElementById("EU vehicle category " + category + " checkmark").isDisplayed();
    }

    public boolean checkNoEUCategoryIsSelected() {
        waitUntilPageIsLoadedById("EU vehicle category Select arrow forward");
        return findElementById("EU vehicle category Select arrow forward").isDisplayed();
    }

    public void clickCountryOfRegistrationOption() {
        findElementByXpath("//XCUIElementTypeButton[starts-with(@name,'Country of registration')]").click();
    }

    public boolean checkCountryOfRegistrationOptionIsDisplayed() {
        return findElementByXpath("//XCUIElementTypeButton[starts-with(@name,'Country of registration')]").isDisplayed();
    }

    public boolean checkCountryOfRegistrationFieldIsUpdated(String countryOfRegistration) {
        return findElementByXpath("//XCUIElementTypeButton[contains(@name,'Country of registration " + countryOfRegistration + "')]").isDisplayed();
    }

    public void clickReviewButtonAndScroll() {
        findElementById(REVIEW_AND_SUBMIT).click();
        scroll(200, 700, 200, 300);
    }

    public void clickReviewAndSubmitButton() {

        click(findElementById(REVIEW_AND_SUBMIT));
    }

    public void clickAddATrailerButton() {
        findElementById(ADD_A_TRAILER_BUTTON_ID).click();
    }

    public void clickAddAVehicleButton() {
        findElementById(ADD_A_VEHICLE_BUTTON_ID).click();
    }

    public boolean checkAddATrailerButtonIsDisplayed() {
        return findElementById(ADD_A_TRAILER_BUTTON_ID).isDisplayed();
    }

    public boolean addATrailerButtonIsPresent() {
        List<WebElementFacade> addTrailerButton = findAll(By.id(ADD_A_TRAILER_BUTTON_ID));
        if (addTrailerButton.size() == 0) {
            return false;
        }
        else {
            return true;
        }
    }

    public boolean checkAddAVehicleButtonIsDisplayed() {
        return findElementById(ADD_A_VEHICLE_BUTTON_ID).isDisplayed();
    }

    public void scrollPageDown() {
        scrollDownTo(500, -1200);
    }

    public void scrollPageUp() {
        scrollDownTo(500, 1200);
    }

    public void addATrailer() {
        clickAddATrailerButton();
    }

}
