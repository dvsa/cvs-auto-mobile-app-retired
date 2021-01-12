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
    private static final String DEFECT_ITEM_DESCRIPTION_IM5_1 = "//XCUIElementTypeStaticText[contains(@name, 'After a total of six accelerations have been completed, the average smoke opacity recorded for accelerations 4, 5 and 6 is more than: For vehicles first used before 1 July 2008: The level specified on the manufacturer’s plate or 2.5m-1 for non-turbocharged engines, where the plate value is not available.')]";
    private static final String DEFECT_ITEM_DESCRIPTION_IM5_2 = "//XCUIElementTypeStaticText[contains(@name, 'After a total of six accelerations have been completed, the average smoke opacity recorded for accelerations 4, 5 and 6 is more than: For vehicles first used before 1 July 2008: The level specified on the manufacturer’s plate or 3.0m-1 for turbocharged engines, where the plate value is not available.')]";
    private static final String DEFECT_ITEM_DESCRIPTION_IM5_3 = "//XCUIElementTypeStaticText[contains(@name, 'After a total of six accelerations have been completed, the average smoke opacity recorded for accelerations 4, 5 and 6 is more than: For vehicles first used from 1 July 2008: The level specified on the manufacturer’s plate or 1.5m-1 for all CI engines, where the plate value is not available.')]";
    private static final String DEFECT_ITEM_DESCRIPTION_IM5_4 = "//XCUIElementTypeStaticText[contains(@name, 'After a total of six accelerations have been completed, the average smoke opacity recorded for accelerations 4, 5 and 6 is more than: For vehicles first used from 1 January 2014: The level specified on the manufacturer’s plate or 0.7m-1 for all CI engines, where the plate value is not available.')]";
    private static final String DEFECT_ITEM_DESCRIPTION_IM59_1 = "//XCUIElementTypeStaticText[contains(@name, 'a brake disc or drum excessively worn, or a brake disc cracked.')]";
    private static final String DEFECT_ITEM_DESCRIPTION_IM59_2 = "//XCUIElementTypeStaticText[contains(@name, 'a brake back plate, disc or drum in such a condition that it is seriously weakened, fractured or insecure.')]";
    private static final String DEFECT_ITEM_DESCRIPTION_IM59_3 = "//XCUIElementTypeStaticText[contains(@name, 'a brake back plate or calliper securing bolt loose or missing.')]";
    private static final String DEFECT_ITEM_DESCRIPTION_IM59_4 = "//XCUIElementTypeStaticText[contains(@name, 'a brake back plate or calliper securing bolt loose or missing to such an extent the back plate or calliper is insecure.')]";
    private static final String DEFECT_ITEM_DESCRIPTION_IM8_1 = "//XCUIElementTypeStaticText[contains(@name, 'in excess of ten years of age fitted to any front steered axle of a vehicle.')]";
    private static final String DEFECT_ITEM_DESCRIPTION_IM8_2 = "//XCUIElementTypeStaticText[contains(@name, 'with a date of manufacture code illegible or not displayed on any axle (excluding a front steered axle).')]";
    private static final String DEFECT_ITEM_DESCRIPTION_IM8_3 = "//XCUIElementTypeStaticText[contains(@name, 'with a date of manufacture code illegible or not displayed to any front steered axle of a vehicle.')]";
    private static final String DEFECT_ITEM_DESCRIPTION_IM8_4 = "//XCUIElementTypeStaticText[contains(@name, 'in excess of ten years of age fitted to the front steered axle or any axle on a minibus with a single wheel fitment.')]";
    private static final String DEFECT_ITEM_DESCRIPTION_IM8_5 = "//XCUIElementTypeStaticText[contains(@name, 'with a date of manufacture code illegible or not displayed (excluding a front steered axle or any axle on a minibus with single wheel fitment).')]";
    private static final String DEFECT_ITEM_DESCRIPTION_IM8_6 = "//XCUIElementTypeStaticText[contains(@name, 'with a date of manufacture code illegible or not displayed to any front steered axle or any axle on a minibus with single wheel fitment.')]";

    private static final String LOCATION_LABEL_ID = "LOCATION";
    private static final String NOTES_LABEL_ID = "NOTES";
    private static final String PASSED_AFTER_RECTIFICATION_AT_STATION_LABEL_ID = "PRS";
    private static final String SELECT_OPTION = "Select";
    private static final String ADDITIONAL_INFORMATION_VERTICAL = "//XCUIElementTypeOther[contains(@name, 'Vertical')]";
    private static final String ADDITIONAL_INFORMATION_LATERAL = "//XCUIElementTypeOther[contains(@name, 'Lateral')]";
    private static final String ADDITIONAL_INFORMATION_ROW_NUMBER = "//XCUIElementTypeOther[contains(@name, 'Row Number')]";
    private static final String ADDITIONAL_INFORMATION_SEAT_NUMBER = "//XCUIElementTypeOther[contains(@name, 'Seat Number')]";
    private static final String ADDITIONAL_INFORMATION_LONGITUDINAL = "//XCUIElementTypeOther[@name='Longitudinal']";
    private static final String ADDITIONAL_INFORMATION_AXLE_NUMBER = "//XCUIElementTypeOther[@name='Axle Number']";
    private static final String ADDITIONAL_INFORMATION_HORIZONTAL = "//XCUIElementTypeOther[@name='Horizontal']";


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
       return findElementByXpath(ADDITIONAL_INFORMATION_VERTICAL);
    }

    public WebElement getLateral() {
        return findElementByXpath(ADDITIONAL_INFORMATION_LATERAL);
    }

    public WebElement getRowNumber() {
        return findElementByXpath(ADDITIONAL_INFORMATION_ROW_NUMBER);
    }

    public WebElement getLongitudinal() {
        return findElementByXpath(ADDITIONAL_INFORMATION_LONGITUDINAL); }

    public WebElement getHorizontal() {
        return findElementByXpath(ADDITIONAL_INFORMATION_HORIZONTAL);
    }

    public WebElement getAxleNumber() {
        return findElementByXpath(ADDITIONAL_INFORMATION_AXLE_NUMBER);
    }

    public WebElement getSeatNumber() {
        return findElementByXpath(ADDITIONAL_INFORMATION_SEAT_NUMBER); }

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

    public void selectLongitudinal(String longitudinal) {
        getLongitudinal().click();
        findElementByXpath("//XCUIElementTypeButton[@name='" + longitudinal + "']").click();
    }

    public void selectAxleNumber(String axleNumber) {
        getAxleNumber().click();
        findElementByXpath("//XCUIElementTypeButton[@name='" + axleNumber + "']").click();
    }

    public void selectHorizontalValue(String horizontalValue) {
        getHorizontal().click();
        findElementByXpath("//XCUIElementTypeButton[@name='" + horizontalValue + "']").click();
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

    public boolean checkIfDefectDescriptionForFirstIm5IsDisplayed(){
        return findElementByXpath(DEFECT_ITEM_DESCRIPTION_IM5_1).isDisplayed();
    }

    public boolean checkIfDefectDescriptionForSecIm5IsDisplayed(){
        return findElementByXpath(DEFECT_ITEM_DESCRIPTION_IM5_2).isDisplayed();
    }

    public boolean checkIfDefectDescriptionForThirdIm5IsDisplayed(){
        return findElementByXpath(DEFECT_ITEM_DESCRIPTION_IM5_3).isDisplayed();
    }

    public boolean checkIfDefectDescriptionForFourthIm5IsDisplayed(){
        return findElementByXpath(DEFECT_ITEM_DESCRIPTION_IM5_4).isDisplayed();
    }

    public boolean checkIfDefectDescriptionForFirstIm59IsDisplayed(){
        return findElementByXpath(DEFECT_ITEM_DESCRIPTION_IM59_1).isDisplayed();
    }

    public boolean checkIfDefectDescriptionForSecIm59IsDisplayed(){
        return findElementByXpath(DEFECT_ITEM_DESCRIPTION_IM59_2).isDisplayed();
    }

    public boolean checkIfDefectDescriptionForThirdIm59IsDisplayed(){
        return findElementByXpath(DEFECT_ITEM_DESCRIPTION_IM59_3).isDisplayed();
    }

    public boolean checkIfDefectDescriptionForFourthIm59IsDisplayed(){
        return findElementByXpath(DEFECT_ITEM_DESCRIPTION_IM59_4).isDisplayed();
    }

    public boolean checkIfDefectDescriptionForFirstIm8IsDisplayed(){
        return findElementByXpath(DEFECT_ITEM_DESCRIPTION_IM8_1).isDisplayed();
    }

    public boolean checkIfDefectDescriptionForSecIm8IsDisplayed(){
        return findElementByXpath(DEFECT_ITEM_DESCRIPTION_IM8_2).isDisplayed();
    }

    public boolean checkIfDefectDescriptionForThirdIm8IsDisplayed(){
        return findElementByXpath(DEFECT_ITEM_DESCRIPTION_IM8_3).isDisplayed();
    }

    public boolean checkIfDefectDescriptionForFourthIm8IsDisplayed(){
        return findElementByXpath(DEFECT_ITEM_DESCRIPTION_IM8_4).isDisplayed();
    }

    public boolean checkIfDefectDescriptionForFifthIm8IsDisplayed(){
        return findElementByXpath(DEFECT_ITEM_DESCRIPTION_IM8_5).isDisplayed();
    }

    public boolean checkIfDefectDescriptionForSixthIm8IsDisplayed(){
        return findElementByXpath(DEFECT_ITEM_DESCRIPTION_IM8_6).isDisplayed();
    }

    public WebElement findItemInList(String itemName) {
        return findElementByAccessibilityId(itemName);
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

    public void clickLongitudinalFront() {
        findElementByXpath(LONGITUDINAL_POP_UP_FRONT_XPATH).click();
    }

    public void clickLongitudinalRear() {
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

    public boolean isLongitudinalDisplayed() {
        boolean status;
        logger.info("Checking if element is displayed: " + ADDITIONAL_INFORMATION_LONGITUDINAL);
        try {
            status = findElementByXpath(ADDITIONAL_INFORMATION_LONGITUDINAL).isDisplayed();
            logger.info("Found");
        } catch (NoSuchElementException e) {
            status = false;
            logger.info("- NOT found");
        }
        return status;
    }

    public boolean isVerticalDisplayed() {
        boolean status;
        logger.info("Checking if element is displayed: " + ADDITIONAL_INFORMATION_VERTICAL);
        try {
            status = findElementByXpath(ADDITIONAL_INFORMATION_VERTICAL).isDisplayed();
            logger.info("Found");
        } catch (NoSuchElementException e) {
            status = false;
            logger.info("- NOT found");
        }
        return status;
    }

    public boolean isHorizontalDisplayed() {
        boolean status;
        logger.info("Checking if element is displayed: " + ADDITIONAL_INFORMATION_HORIZONTAL);
        try {
            status = findElementByXpath(ADDITIONAL_INFORMATION_HORIZONTAL).isDisplayed();
            logger.info("Found");
        } catch (NoSuchElementException e) {
            status = false;
            logger.info("- NOT found");
        }
        return status;
    }

    public boolean isLateralDisplayed() {
        boolean status;
        logger.info("Checking if element is displayed: " + ADDITIONAL_INFORMATION_LATERAL);
        try {
            status = findElementByXpath(ADDITIONAL_INFORMATION_LATERAL).isDisplayed();
            logger.info("Found");
        } catch (NoSuchElementException e) {
            status = false;
            logger.info("- NOT found");
        }
        return status;
    }

    public boolean isAxleNumberDisplayed() {
        boolean status;
        logger.info("Checking if element is displayed: " + ADDITIONAL_INFORMATION_AXLE_NUMBER);
        try {
            status = findElementByXpath(ADDITIONAL_INFORMATION_AXLE_NUMBER).isDisplayed();
            logger.info("Found");
        } catch (NoSuchElementException e) {
            status = false;
            logger.info("- NOT found");
        }
        return status;
    }

    public boolean isNotesDisplayed() {
        boolean status;
        logger.info("Checking if element is displayed: " + NOTES_LABEL_ID);
        try {
            status = findElementById(NOTES_LABEL_ID).isDisplayed();
            logger.info("Found");
        } catch (NullPointerException e) {
            status = false;
            logger.info("- NOT found");
        }
        return status;
    }

}
