package pages;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.List;

public class SiteVisitPage extends BasePage {

    private static final String PAGE_TITLE = "Site visit";
    private static final String CREATE_TEST_ID = "Create test";
    private static final String END_VISIT_ID = "End visit";
    private static final String END_VISIT_POP_UP_CONFIRM_ID = "End visit";
    private static final String END_VISIT_POP_UP_CANCEL_ID = "Cancel";
    private static final String BUTTONS_CLASS_NAME = "XCUIElementTypeButton";
    private static final String END_VISIT_POP_UP_TITLE = "//XCUIElementTypeStaticText[@name='End visit']";
    private static final String LOADING_ID = "Submitting site visit";
    private static final String TOAST_MESSAGE_AFTER_SUBMIT = "The test have been submitted and emailed to andy@dvsa.gov.uk";

    private static String startVisitTime;
    private static String createTestTime;
    private static String submitTestTime;

    public void waitUntilPageIsLoaded() {
        waitUntilPageIsLoadedByAccessibilityId(CREATE_TEST_ID);
    }

    public void clickCreateNewTest() {
        findElementById(CREATE_TEST_ID).click();
    }

    public boolean isPageTitleDisplayed() {
        return findElementById(PAGE_TITLE).isDisplayed();
    }

    public boolean isPageTitleWithRetryDisplayed() {
        return waitUntilPageIsLoadedById(PAGE_TITLE).isDisplayed();
    }

    public boolean isCanceledTestDisplayed(String registrationPlate) {
        return findElementByXpath("//XCUIElementTypeButton[contains(@name,'Test (" + registrationPlate + ") CANCELLED')]").isDisplayed();
    }


    public void clickEndVisit() {
        findElementByAccessibilityId(END_VISIT_ID).click();
    }

    public void clickOk() {
        waitUntilNumberOfElementsToBe(MobileBy.AccessibilityId(END_VISIT_POP_UP_CONFIRM_ID), 4);
        findElementsByAccessibilityId(END_VISIT_POP_UP_CONFIRM_ID).get(2).click();
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
        return findElementById(CREATE_TEST_ID).isDisplayed();
    }

    public boolean isEndVisitButtonDisplayed() {
        return findElementById(END_VISIT_ID).isDisplayed();
    }

    public boolean isAtfRowDisplayed(String atfName, String atfNumber) {
        return findElementByXpath("//XCUIElementTypeButton[contains(@name,'" + atfName + " (" + atfNumber + ") Started site visit')]").isDisplayed();
    }

    public boolean isCurrentDateDisplayed() {
        boolean status;
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd MMMM yyyy");
        TemporalAccessor date = LocalDateTime.now();
        String clientSystemDate = dateTimeFormatter.format(date);
        String clientSystemDatePlusOneDay = dateTimeFormatter.format(((LocalDateTime) date).plusDays(1));
        String clientSystemDateMinusOneDay = dateTimeFormatter.format(((LocalDateTime) date).minusDays(1));
        try {
            status = findElementByAccessibilityId(clientSystemDate).isDisplayed();
        } catch (NoSuchElementException e) {
            try {
                status = findElementByAccessibilityId(clientSystemDatePlusOneDay).isDisplayed();
            } catch (NoSuchElementException e1) {
                try {
                    status = findElementByAccessibilityId(clientSystemDateMinusOneDay).isDisplayed();
                } catch (NoSuchElementException e2) {
                    status = false;
                }
            }
        }
        return status;
    }

    private String getTime() {
        String timeString = getStatusBarTime();
        TemporalAccessor temporalAccessor;
        String time;

        LocalDateTime localDateTime = LocalDateTime.now();
        if (localDateTime.getSecond() >= 55) {
            try {
                Thread.sleep(7000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        DateTimeFormatter dateTimeFormatterAmPm = DateTimeFormatter.ofPattern("h:mm a");
        DateTimeFormatter dateTimeFormatter24 = DateTimeFormatter.ofPattern("HH:mm");

        if (timeString.contains("AM") || timeString.contains("PM")) {
            temporalAccessor = dateTimeFormatterAmPm.parse(timeString);
            time = dateTimeFormatter24.format(temporalAccessor);
        } else {
            temporalAccessor = dateTimeFormatter24.parse(timeString);
            time = dateTimeFormatter24.format(temporalAccessor);
        }
        return time;
    }

    public void setStartVisitTime() {
        startVisitTime = getTime();
    }

    public void setCreateTestTime() {
        createTestTime = getTime();
    }

    public void setSubmitTestTime() {
        submitTestTime = getTime();
    }

    public boolean isCurrentTimeDisplayed() {
        return findElementByXpath("//XCUIElementTypeButton[contains(@name,'" + startVisitTime + "')]").isDisplayed();
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

    public boolean isSubmittedSiteVisitDisplayed(String regPlate, String... testTypesWithResults) {
        boolean status = false;
        String visitString = findElementByXpath("//XCUIElementTypeButton[contains(@name,'Test (" + regPlate + ")')]").getAttribute("name");
        if (visitString.contains(createTestTime + " - " + submitTestTime))
            for (String value : testTypesWithResults) {
                status = visitString.contains(value);
                if (!status) {
                    break;
                }
            }

        return status;
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
}
