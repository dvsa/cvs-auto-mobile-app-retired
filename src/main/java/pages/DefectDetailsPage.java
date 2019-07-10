package pages;

import exceptions.AutomationException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.util.Iterator;
import java.util.Map;

public class DefectDetailsPage extends BasePage {

    private static final String DEFECT_DETAILS_PAGE_ID = "Defect details";
    private static final String DEFECT_ITEM_LABEL_ID = "DEFECT ITEM";
    private static final String LOCATION_LABEL_ID = "LOCATION";
    private static final String NOTES_LABEL_ID = "NOTES";
    private static final String PASSED_AFTER_RECTIFICATION_AT_STATION_LABEL_ID = "PRS";
    private static final String SELECT_OPTION = "Select";
    private static final String ADDITIONAL_INFORMATION_VERTICAL = "Vertical";
    private static final String ADDITIONAL_INFORMATION_LATERAL = "Lateral";
    private static final String ADDITIONAL_INFORMATION_ROW_NUMBER = "Row Number";
    private static final String ADDITIONAL_INFORMATION_SEAT_NUMBER = "Seat Number";
    private static final String DONE_BUTTON_ID = "Done";
    private static final String PRS_ENABLE = "Defect repaired during test";
    private static final String ADD_NOTES = "Add notes";
    private static final String BACK_BUTTON_XPATH = "//XCUIElementTypeButton[contains(@name, 'arrow back')]";
    private static final String REMOVE_BUTTON_ID = "Remove defect";
    private static final String POP_UP_CANCEL_XPATH = "//XCUIElementTypeButton[@name=\"Cancel\"]";
    private static final String POP_UP_REMOVE_XPATH = "//XCUIElementTypeButton[@name=\"Remove\"]";
    private static final String POP_UP_TEXT_ID = "This action will remove this defect.";
    private static final String POP_UP_TITLE_ID = "//XCUIElementTypeStaticText[@name=\"Remove defect\"]";
    private static final String PROHIBITION_ISSUED_SWITCH_XPATH = "//XCUIElementTypeSwitch[@name=\"Issued in Mobile Compliance\"]";
    private static final String PROHIBITION_POP_UP_OK_ID = "OK";
    private static final String PROHIBITION_POP_UP_TITLE_ID = "Prohibition alert";
    private static final String PROHIBITION_POP_UP_DESCRIPTION_ID = "Explain why you haven't issued a prohibition for this defect in the Notes section.";
    private static final String PROHIBITION_POP_UP_DESCRIPTION_2_ID = "This defect requires you to issue a prohibition in Mobile Compliance. Confirm you’ve done this in the Prohibition section.";

    private static final String ISSUED_IN_MOBILE_COMPLIANCE_ID = "Issued in Mobile Compliance";
    private static final String PROHIBITION = "PROHIBITION";

    public WebElement getDefectLabel() {
        return findElementById(DEFECT_ITEM_LABEL_ID);
    }

    public WebElement getLocationLabel() {
        return findElementById(LOCATION_LABEL_ID);
    }

    public WebElement getNotesLabel() {
        return findElementById(NOTES_LABEL_ID);
    }

    public WebElement getPRSLabel() {
        return findElementById(PASSED_AFTER_RECTIFICATION_AT_STATION_LABEL_ID);
    }

    public WebElement getVertical() {
        return findElementsByXpath("//*[@label='" + ADDITIONAL_INFORMATION_VERTICAL + "']").get(1);
    }

    public WebElement getLateral() {
        return findElementsByXpath("//*[@label='" + ADDITIONAL_INFORMATION_LATERAL + "']").get(1);
    }

    public WebElement getRowNumber() {
        return findElementsByXpath("//*[@label='" + ADDITIONAL_INFORMATION_ROW_NUMBER + "']").get(1);
    }

    public WebElement getSeatNumber() {
        return findElementsByXpath("//*[@label='" + ADDITIONAL_INFORMATION_SEAT_NUMBER + "']").get(1);
    }

    public int getSelectOptionElementNumber() {
        return findElementsByXpath("//*[@label='" + SELECT_OPTION + "']").size();
    }

    public WebElement getElementById(String id) {
        return findElementById(id);
    }

    public WebElement getElementByLabel(String label) {
        return findElementByXpath("//*[@label='" + label + "']");
    }

    public void selectVerticalValue(String id) {
        getVertical().click();
        findElementById(id).click();
    }

    public void selectLateralValue(String id) {
        getLateral().click();
        findElementById(id).click();
    }

    public void selectRowNumberValue(String id) {
        getRowNumber().click();
        findElementByXpath("//XCUIElementTypeButton[@name='" + id + "']").click();
    }

    public void selectSeatNumberValue(String id) {
        getSeatNumber().click();
        findElementByXpath("//XCUIElementTypeButton[@name='" + id + "']").click();
    }

    public void waitUntilPageIsLoaded() {
        waitUntilPageIsLoadedById(DEFECT_DETAILS_PAGE_ID);
    }

    public void clickDone() {
        findElementById(DONE_BUTTON_ID).click();
    }

    public void enablePRS() {
        tap(findElementByXpath("//XCUIElementTypeSwitch[@name=\"Defect repaired during test\"]"));
    }

    public void enableProhibition() {
        tap(findElementByXpath(PROHIBITION_ISSUED_SWITCH_XPATH));
    }

    public String getProhibitionSwitchValue() {
        return findElementByXpath(PROHIBITION_ISSUED_SWITCH_XPATH).getAttribute("value");
    }

    public int getPRSElementNumber() {
        return findElementsByXpath("//*[@label='Issued in Mobile Compliance']").size();
    }

    public void sendNotes(String data) {
        findElementByXpath("//*[@value='" + ADD_NOTES + "']").sendKeys(data);
    }

    public int checkIfTextIsPresent(String data) {
        return findElementsByXpath("//*[@value='" + data + "']").size();
    }

    public void clickBack() {
        findElementByXpath(BACK_BUTTON_XPATH).click();
    }

    public void clickOnRemoveButton() {
        findElementById(REMOVE_BUTTON_ID).click();
    }

    public boolean isDefectRemovalPopUpVisible() {
        boolean status = false;
        WebElement cancelButton = findElementByXpath(POP_UP_CANCEL_XPATH);
        WebElement removeButton = findElementByXpath(POP_UP_REMOVE_XPATH);
        WebElement text = findElementById(POP_UP_TEXT_ID);
        WebElement title = findElementByXpath(POP_UP_TITLE_ID);
        if (cancelButton.isDisplayed() && removeButton.isDisplayed() && text.isDisplayed() && title.isDisplayed()) {
            status = true;
        }
        return status;
    }

    public void clickRemoveInPopUp() {
        findElementByXpath(POP_UP_REMOVE_XPATH).click();
    }

    public void clickCancelInPopUp() {
        findElementByXpath(POP_UP_CANCEL_XPATH).click();
    }

    public void scrollDetailPage() {
        scrollDownTo(500, -100);
    }

    public boolean checkPageTitleIsDisplayed() {
        return findElementById(DEFECT_DETAILS_PAGE_ID).isDisplayed();
    }

    public void selectOption(String option) {
        try {
            findElementsByXpath("//*[@label='" + option + "']").get(1).click();
        } catch (NoSuchElementException e) {
            throw new AutomationException("The option chosen is not available!");
        }
    }

    public void selectValue(String value) {
        try {
            findElementByXpath("//XCUIElementTypeButton[@name='" + value + "']").click();
        } catch (NoSuchElementException e) {
            throw new AutomationException("The option chosen is not available!");
        }
    }

    public void selectOptionAndItsValue(Map<String, String> map) {
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            selectOption(pair.getKey().toString());
            selectValue(pair.getValue().toString());
            it.remove();
        }
    }

    public boolean checkPRSOptionIsDisplayed() {
        try {
            return findElementById(PRS_ENABLE).isDisplayed();
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public boolean isProhibitionPopUpDisplayed() {
        boolean status = false;
        boolean isException = false;
        WebElement okButton = null;
        try {
            okButton = findElementById(PROHIBITION_POP_UP_OK_ID);
        } catch (Exception e) {
            isException = true;
        }

        if (!isException) {
            WebElement description = findElementById(PROHIBITION_POP_UP_DESCRIPTION_ID);
            WebElement title = findElementById(PROHIBITION_POP_UP_TITLE_ID);
            if (okButton.isDisplayed() && description.isDisplayed() && title.isDisplayed()) {
                status = true;
            }
        }
        return status;
    }

    public boolean isProhibitionPopUpNoAsteriskDefectDisplayed() {
        boolean status = false;
        boolean isException = false;
        WebElement okButton = null;
        try {
            okButton = findElementById(PROHIBITION_POP_UP_OK_ID);
        } catch (Exception e) {
            isException = true;
        }

        if (!isException) {
            WebElement description = findElementById(PROHIBITION_POP_UP_DESCRIPTION_2_ID);
            WebElement title = findElementById(PROHIBITION_POP_UP_TITLE_ID);
            if (okButton.isDisplayed() && description.isDisplayed() && title.isDisplayed()) {
                status = true;
            }
        }
        return status;
    }

    public void clickOkInProhibitionPopUp() {
        waitUntilPageIsLoadedById(PROHIBITION_POP_UP_OK_ID);
        findElementById(PROHIBITION_POP_UP_OK_ID).click();
    }

    public boolean checkProhibitionLabelIsNotDisplayed() {
        try {
            return findElementById(PROHIBITION).isDisplayed();
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public boolean checkIssuedInMobileComplianceIsNotPresent() {
        try {
            return findElementById(ISSUED_IN_MOBILE_COMPLIANCE_ID).isDisplayed();
        } catch (NoSuchElementException ex) {
            return false;
        }
    }
}
