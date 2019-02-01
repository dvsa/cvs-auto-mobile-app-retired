package pages;


import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ATFDetailsPage extends BasePage {

    private static final String START_VISIT_ID = "Start visit";
    private static final String YES_ID = "Yes";
    private static final String PAGE_ALL_TEXT_XPATH = "//XCUIElementTypeStaticText";
    private static final String POP_UP_CANCEL_BUTTON_ID = "Cancel";
    private static final String POP_UP_CALL_BUTTON_ID = "Call";
    private static final String BACK_BUTTON_ID = "arrow back Search for an ATF";
    private static final String POP_UP_START_VISIT_TITLE = "Confirm ATF and safety";
    private static final String POP_UP_START_VISIT_CANCEL_BUTTON_ID = "Cancel";
    private static final String POP_UP_START_VISIT_CONFIRM_BUTTON_ID = "Confirm";
    private static final String POP_UP_START_VISIT_REPORT_ISSUE_BUTTON_ID = "Report issue";
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
        boolean status = false;
        if (findElementById(number).isDisplayed() && findElementById(POP_UP_CANCEL_BUTTON_ID).isDisplayed() &&
                findElementById(POP_UP_CALL_BUTTON_ID).isDisplayed()) {
            status = true;
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
        boolean status = false;
        if (findElementById(POP_UP_START_VISIT_TITLE).isDisplayed() &&
                findElementById(POP_UP_START_VISIT_CANCEL_BUTTON_ID).isDisplayed() &&
                findElementById(POP_UP_START_VISIT_CONFIRM_BUTTON_ID).isDisplayed() &&
                findElementById(POP_UP_START_VISIT_REPORT_ISSUE_BUTTON_ID).isDisplayed() ) {
            status = true;
        }
        return status;
    }
}
