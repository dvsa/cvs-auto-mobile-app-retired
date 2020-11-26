package pages;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class SiteVisitPage extends BasePage {

    private static final String PAGE_TITLE = "Site visit";
    private static final String CREATE_TEST_ID = "Start visit";
    private static final String START_TEST = "Start test";
    private static final String END_VISIT_ID = "End visit";
    private static final String END_VISIT_POP_UP_CONFIRM_ID = "End visit";
    private static final String END_VISIT_POP_UP_CANCEL_ID = "Cancel";
    private static final String BUTTONS_CLASS_NAME = "XCUIElementTypeButton";
    private static final String END_VISIT_POP_UP_TITLE = "//XCUIElementTypeStaticText[@name='End visit']";
    private static final String LOADING_ID = "Submitting site visit";
    private static final String TOAST_MESSAGE_AFTER_SUBMIT = "The test has been submitted and emailed.";
    private static final String ENTER_REASON_POP_UP_TITLE = "Enter reason";
    private static final String ENTER_REASON_POP_UP_TEXT_ID = "Before ending your visit, enter details about your time spent not testing.";
    private static final String ENTER_REASON_POP_UP_OK_ID = "OK";

    public void waitUntilPageIsLoaded() {
        waitUntilPageIsLoadedByAccessibilityId(START_TEST);
    }

    public void clickCreateNewTest() {
        findElementById(START_TEST).click();
    }

    public boolean isPageTitleDisplayed() {
        try {
            return findElementById(PAGE_TITLE).isDisplayed();
        } catch (NullPointerException ex) {
            return false;
        }
    }

    public boolean isPageTitleWithRetryDisplayed() {
        return waitUntilPageIsLoadedById(PAGE_TITLE).isDisplayed();
    }

    public boolean isCanceledTestDisplayed(String registrationPlate) {
        return findElementByXpath("//XCUIElementTypeButton[contains(@name,'" + registrationPlate + " CANCELLED')]").isDisplayed();
    }


    public void clickEndVisit() {
        findElementByAccessibilityId(END_VISIT_ID).click();
    }

    public void clickOk() {
        waitUntilNumberOfElementsToBe(MobileBy.AccessibilityId(END_VISIT_POP_UP_CONFIRM_ID), 4);
        findElementsByAccessibilityId(END_VISIT_POP_UP_CONFIRM_ID).get(2).click();
    }

    public void clickOkInReasonPopUp() {
        findElementByAccessibilityId(ENTER_REASON_POP_UP_OK_ID).click();
    }

    public boolean isBackButtonAvailable() {
        boolean status = false;
        List<WebElement> listOfButtons = findElementsByClassName(BUTTONS_CLASS_NAME);
        for (WebElement button : listOfButtons) {
            if (button.getText().contains("arrow back")) {
                status = true;
                break;
            }
        }
        return status;
    }

    public boolean isCreateTestButtonDisplayed() {
        try {
            return findElementById(START_TEST).isDisplayed();
        } catch (NullPointerException ex) {
            return false;
        }
    }

    public boolean isEndVisitButtonDisplayed() {
        try {
            return findElementById(END_VISIT_ID).isDisplayed();
        } catch (NullPointerException ex) {
            return false;
        }
    }

    public boolean isAtfRowDisplayed(String atfName, String atfNumber) {
        return findElementByXpath("//XCUIElementTypeButton[contains(@name,'" + atfName + " (" + atfNumber + ") Started site visit')]").isDisplayed();
    }

    public boolean isEndVisitPopUpDisplayed() {
        boolean status;
        try {
            status = findElementByXpath(END_VISIT_POP_UP_TITLE).isDisplayed() && findElementsByAccessibilityId(END_VISIT_POP_UP_CONFIRM_ID).get(2).isDisplayed();
        } catch (NoSuchElementException e) {
            status = false;
        }
        return status;
    }

    public void clickCancelInEndVisitPop() {
        findElementById(END_VISIT_POP_UP_CANCEL_ID).click();
    }

    public boolean isLoadingScreenDisplayed() {
        return findElementByAccessibilityId(LOADING_ID).isDisplayed();
    }

    public boolean isToastMessageDisplayed() {
        boolean status;
        try {
            status = waitUntilPageIsLoadedByAccessibilityId(TOAST_MESSAGE_AFTER_SUBMIT).isDisplayed();
        } catch (TimeoutException e) {
            status = false;
        }
        return status;
    }

    public boolean isVisitEditableByPlate(String regPlate) {
        boolean status = false;
        try {
            findElementByXpath("//*[contains(@name,'" + regPlate + "')]").click();
            waitUntilPageIsLoaded();
        } catch (TimeoutException e) {
            status = true;
        }
        return status;
    }

    public boolean isTimeNotTestingDisplayed() {
           return findElementByXpath("//XCUIElementTypeButton[contains(@name,'Time not testing')]").isDisplayed();
    }

    public void clickTimeNotTesting() {
        findElementByXpath("//XCUIElementTypeButton[contains(@name,'Time not testing')]").click();
    }

    public boolean isEnterReasonPopUDisplayed() {
        boolean status;
        try {
            status = findElementByAccessibilityId(ENTER_REASON_POP_UP_TITLE).isDisplayed() && findElementByAccessibilityId(ENTER_REASON_POP_UP_TEXT_ID).isDisplayed();
        } catch (NoSuchElementException e) {
            status = false;
        }
        return status;
    }

    public boolean areAllReasonsDisplayed(String text) {
        boolean status;
        try {
            status = findElementByXpath("//XCUIElementTypeButton[contains(@name,'Waiting for vehicle Admin Break Site issue Other " + text + "')]").isDisplayed();
        } catch (NoSuchElementException e) {
            status = false;
        }
        return status;
    }

    public int getVehiclePosition(String mrn) {
        WebElement siteVisitTestList = findElementByXpath("//XCUIElementTypeButton[contains(@name,'Started site visit')]/following-sibling::XCUIElementTypeButton");
        String testList = siteVisitTestList.getAttribute("label");
        String[] tests = testList.split(" • ");
        for (int i = 0 ; i < tests.length; i++) {
            if (tests[i].contains(mrn)) {
                return i;
            }
        }
        return 0;
    }

    public Date retrieveTimeFromTimeline() {
        String siteVisitTestList = findElementByXpath("//XCUIElementTypeOther/XCUIElementTypeButton").getAttribute("name");
        DateFormat format = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);
        Date date = null;
        try {
            date = format.parse(siteVisitTestList);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
