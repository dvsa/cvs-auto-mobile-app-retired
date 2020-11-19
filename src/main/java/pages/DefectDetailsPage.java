package pages;

import exceptions.AutomationException;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Iterator;
import java.util.List;
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
    private static final String LONGITUDINAL = "//XCUIElementTypeOther[contains(@name, 'Longitudinal')]";
    private static final String LONGITUDINAL_POP_UP_FRONT_XPATH = "//XCUIElementTypeButton[@name=\"Front\"]";
    private static final String LONGITUDINAL_POP_UP_REAR_XPATH = "//XCUIElementTypeButton[@name=\"Rear\"]";
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
    private static final String PAGE_ALL_LABELS_CLASS_NAME = "XCUIElementTypeStaticText";
    private static final String ISSUED_IN_MOBILE_COMPLIANCE_ID = "Issued in Mobile Compliance";
    private static final String PROHIBITION = "PROHIBITION";

    private static final String REFERENCE_NUMBER_FIELD = "//XCUIElementTypeTextField[1]";
    private static final String DEFECT_NAME_FIELD = "//XCUIElementTypeTextField[2]";
    private static final String DEFECT_NOTES_FIELD = "//XCUIElementTypeTextField[2]";

    private static final String DEFECT_REFERENCE_NUMBER = "//XCUIElementTypeStaticText[@value='REFERENCE NUMBER']/ancestor::XCUIElementTypeOther/following-sibling::XCUIElementTypeOther/XCUIElementTypeTextField";
    private static final String DEFECT_NAME = "//XCUIElementTypeStaticText[@value='DEFECT NAME']/ancestor::XCUIElementTypeOther/following-sibling::XCUIElementTypeOther/XCUIElementTypeTextField";
    private static final String DEFECT_NOTES = "//XCUIElementTypeStaticText[@value='DEFECT NAME']/ancestor::XCUIElementTypeOther/following-sibling::XCUIElementTypeTextView";

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

    public void selectVerticalValue(String label) {
        getVertical().click();
        findElementByXpath("//XCUIElementTypeButton[@label='" + label + "']").click();
    }

    public void selectLateralValue(String label) {
        getLateral().click();
        findElementByXpath("//XCUIElementTypeButton[@label='" + label + "']").click();
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
        logger.info("Clicking on button: " + DONE_BUTTON_ID);
        findElementById(DONE_BUTTON_ID).click();
        logger.info("Found");
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

    public String getPRSSwitchValue() {
        return findElementByXpath("//XCUIElementTypeSwitch[@name=\"Defect repaired during test\"]").getAttribute("value");
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
        waitUntilPageIsLoadedByAccessibilityId(REMOVE_BUTTON_ID);
        findElementById(REMOVE_BUTTON_ID).click();
    }

    public void waitElementToDisappear(String locator){
        waitElementToDisappear(MobileBy.AccessibilityId(locator), 90, 200);
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

    public void clickLongitudinal() {
        findElementByXpath(LONGITUDINAL).click();
    }

    public void clickLogitudinalFront() {
        findElementByXpath(LONGITUDINAL_POP_UP_FRONT_XPATH).click();
    }


    public void clickLogitudinalRear() {
        findElementByXpath(LONGITUDINAL_POP_UP_REAR_XPATH).click();
    }

    public void scrollDetailPage() {
        scrollDownTo(500, -100);
    }

    public boolean checkPageTitleIsDisplayed() {
        waitUntilPageIsLoaded();
        try {
            return findElementById(DEFECT_DETAILS_PAGE_ID).isDisplayed();
        } catch (NullPointerException ex) {
            return false;
        }
    }

    public void selectOption(String option) {
        try {
            String locator = "//*[@label='" + option + "']";
            findElementsByXpath(locator).get(1).click();
            waitElementToDisappear(locator);

        } catch (NoSuchElementException e) {
            throw new AutomationException("The option chosen is not available!");
        }
    }

    public void selectValue(String value) {
        try {
            String locator = "//XCUIElementTypeButton[@name='" + value + "']";
            findElementByXpath(locator).click();

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
        // return findElementsByXpath("//XCUIElementTypeStaticText[@value=\"" + PRS_ENABLE + "\"]").size()>0;
        try {
            return findElementById(PRS_ENABLE).isDisplayed();
        } catch (NullPointerException ex) {
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

    public boolean isProhibitionLabelDisplayed() {
        // return findElementsByXpath("//XCUIElementTypeStaticText[@name=\""+ PROHIBITION + "\"]").size() > 0;
        try {
            return findElementById(PROHIBITION).isDisplayed();
        } catch (NullPointerException ex) {
            return false;
        }
    }

    public boolean isIssuedInMobileCompliancePresent() {
        try {
            WebElement element = findElementById(ISSUED_IN_MOBILE_COMPLIANCE_ID);
            return (element != null ? element.isDisplayed() : false);
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public boolean isStaticTextDisplayed(String staticText) {
        return !isStaticTextNotDisplayed(staticText);
    }

    public boolean isStaticTextNotDisplayed(String staticText) {
        waitUntilPageIsLoaded();
        for(WebElement button : getAllLabels()){
            if(button.getAttribute("name").equals(staticText)){
                return false;
            }
        }
        return true;
    }

    public List<WebElement> getAllLabels(){
        return findElementsByClassName(PAGE_ALL_LABELS_CLASS_NAME);
    }

    public void scroll() {
        scroll(200, 700, 200, 300);
    }

    public void setReferenceNumber(String referenceNumber) {

        waitUntilPageIsLoadedByXpath(DEFECT_REFERENCE_NUMBER);
        WebElement referenceNumberField = findElementByXpath(DEFECT_REFERENCE_NUMBER);
        referenceNumberField.click();
        referenceNumberField.sendKeys(referenceNumber);
    }

    public String getReferenceNumber() {

        WebElement referenceNumberField = findElementByXpath(DEFECT_REFERENCE_NUMBER);
        return referenceNumberField.getText();
    }

    public void setDefectName(String defectName) {
        WebElement defectNameField = findElementByXpath(DEFECT_NAME);
        defectNameField.click();
        defectNameField.sendKeys(defectName);
    }

    public String getDefectName() {
        WebElement defectNameField = findElementByXpath(DEFECT_NAME);
        return defectNameField.getText();
    }

    public void setDefectNotes(String defectNotes) {
        WebElement defectNotesField = findElementByXpath(DEFECT_NOTES);
        defectNotesField.click();
        defectNotesField.sendKeys(defectNotes);
    }

    public String getDefectNotes() {
        WebElement defectNotesField = findElementByXpath(DEFECT_NOTES);
        return defectNotesField.getText();
    }


}
