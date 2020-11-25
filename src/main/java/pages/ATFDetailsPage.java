package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ATFDetailsPage extends BasePage {

    private static final String START_VISIT_ID = "Start visit";
    private static final String TEST_FACILITY_DETAILS_ID = "Test facility details";
    private static final String PAGE_ALL_TEXT_XPATH = "//XCUIElementTypeStaticText";
    private static final String POP_UP_CANCEL_BUTTON_ID = "Cancel";
    private static final String POP_UP_CALL_BUTTON_ID = "Call";
    private static final String BACK_BUTTON_ID = "arrow back Find test facility";
    private static final String POP_UP_START_VISIT_TITLE = "Confirm ATF and safety";
    private static final String POP_UP_START_VISIT_CANCEL_BUTTON_ID = "Cancel";
    private static final String POP_UP_START_VISIT_CONFIRM_BUTTON_ID = "Confirm";
    private static final String POP_UP_START_VISIT_REPORT_ISSUE_BUTTON_ID = "Report issue";
    private static final String POP_UP_CONFIRM_ID = "Confirm";
    private static final String REPORT_ISSUE_POP_UP_TITLE = "Report test facility issue";
    private static final String REPORT_ISSUE_POP_UP_DESCRIPTION = "Speak to your Technical Team Leader (TTL) if the issue cannot be resolved on site.";
    private static final String REPORT_ISSUE_POP_UP_OK_BUTTON = "OK";


    public void waitUntilPageIsLoaded() {
        waitUntilPageIsLoadedById(START_VISIT_ID);
    }

    public void clickStartVisit() {
        findElementById(START_VISIT_ID).click();
    }

    public void waitUntilPageIsLoadedById(){
        waitUntilPageIsLoadedById(TEST_FACILITY_DETAILS_ID);
    }

    public void isPageTitleDisplayed(){
        findElementById(TEST_FACILITY_DETAILS_ID).isDisplayed();
    }

    public void selectConfirmInPopUp() {
        waitUntilPageIsLoadedByElementAndClickable(By.id(POP_UP_CONFIRM_ID), 20, 200);
        findElementById(POP_UP_CONFIRM_ID).click();
    }

    public List<String> findAllValuesByXpath() {
        List<WebElement> webElementList = findElementsByXpath(PAGE_ALL_TEXT_XPATH);
        List<String> listOfData = new ArrayList<>();
        for (WebElement webElement : webElementList) {
            listOfData.add(webElement.getAttribute("value"));
        }

        return listOfData;
    }

    public void clickPhoneNumber(String number) {
        findElementById(number).click();
    }

    public boolean isCallPopUpDisplayedByNumber(String number) {
        boolean status = true;
        try {
            findElementById(number).isDisplayed();
            findElementById(POP_UP_CANCEL_BUTTON_ID).isDisplayed();
            findElementById(POP_UP_CALL_BUTTON_ID).isDisplayed();
        } catch (Exception e) {
            status = false;
        }

        return status;
    }

    public void clickCancelInPopUp() {
        findElementById(POP_UP_CANCEL_BUTTON_ID).click();
    }

    public void clickOnBackToSearchForAnAtf() {
        findElementById(BACK_BUTTON_ID).click();
    }

    public boolean isStartVisitPopUpDisplayed() {
        boolean status = true;
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        try {
                findElementById(POP_UP_START_VISIT_TITLE).isDisplayed();
                findElementById(POP_UP_START_VISIT_CANCEL_BUTTON_ID).isDisplayed();
                findElementById(POP_UP_START_VISIT_CONFIRM_BUTTON_ID).isDisplayed();
                findElementById(POP_UP_START_VISIT_REPORT_ISSUE_BUTTON_ID).isDisplayed();
        } catch (Exception e) {
            status = false;
        }
        return status;
    }

    public void clickReportIssueInPopUp() {
        findElementById(POP_UP_START_VISIT_REPORT_ISSUE_BUTTON_ID).click();
    }

    public boolean isReportIssuePopUpDisplayed() {
        boolean status = true;
        try {
            findElementById(REPORT_ISSUE_POP_UP_TITLE).isDisplayed();
            findElementById(REPORT_ISSUE_POP_UP_DESCRIPTION).isDisplayed();
            findElementById(REPORT_ISSUE_POP_UP_OK_BUTTON).isDisplayed();
        } catch (Exception e) {
            status = false;
        }
        return status;
    }

    public void clickOkInReportIssuePopUp() {
        findElementById(REPORT_ISSUE_POP_UP_OK_BUTTON).click();
    }
}
