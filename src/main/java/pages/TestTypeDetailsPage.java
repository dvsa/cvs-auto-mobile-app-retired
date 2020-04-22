package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import util.*;

import java.text.DateFormatSymbols;
import java.time.Clock;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestTypeDetailsPage extends BasePage {

    private static final String TEST_TYPE_DETAILS = "Test type details";
    private static final String CARRIED_OUT_YES_OPTION_ID = "Yes";
    private static final String CARRIED_OUT_NO_OPTION_ID = "No";
    private static final String CARRIED_OUT_CANCEL_OPTION_ID = "Cancel";
    private static final String MOST_RECENT_INSTALLATION_CHECK_DONE_BUTTON_ID = "Done";
    private static final String MOST_RECENT_INSTALLATION_CHECK_CANCEL_BUTTON_ID = "Cancel";
    private static final String SEATBELT_TITLE_ID = "SEATBELT INSTALLATION CHECK";
    private static final String SAVE_BUTTON_ID = "Save";
    private static final String TEST_RESULT_XPATH = "//XCUIElementTypeButton[contains(@name, 'Test result')]";
    private static final String PASS_ID = "Pass";
    private static final String FAIL_ID = "Fail";
    private static final String PRS_ID = "PRS";
    private static final String CANCEL_LEC_TEST_ID = "Cancel";
    private static final String CERTIFICATE_NUMBER_LABEL_ID = "CERTIFICATE NUMBER";
    private static final String CERTIFICATE_NUMBER_COIFLABEL_ID = "CERTIFICATE NUMBER (COIF)";
    private static final String LP_LABEL_ID = "LP";
    private static final String CERTIFICATE_NUMBER_INPUT_FIELD_XPATH = "//XCUIElementTypeTextField";
    private static final String TECHNICAL_TEST_EDIT_ID = "Technical test Edit checkmark";
    private static final String CERTIFICATE_NUMBER_GUIDANCE_ID = "After conducting the test, complete the Low Emissions Certificate and enter the certificate number.";
    private static final String NOTES_INPUT_FIELD_CLASS_NAME = "XCUIElementTypeTextView";
    private static final String ADD_DEFECT_ID = "Add defect";
    private static final String REMOVE_BUTTON_ID = "Remove";
    private static final String POP_UP_CANCEL_ID = "Cancel";
    private static final String POP_UP_REMOVE_XPATH = "(//XCUIElementTypeButton[@name='Remove'])[2]";
    private static final String POP_UP_TEXT_ID = "This action will remove this defect.";
    private static final String POP_UP_TITLE_ID = "Remove defect";
    private static final String ABANDON_TEST_TYPE = "Abandon test type";
    private static final String REMOVE_TEST_TYPE = "Remove test type";
    private static final String POP_UP_TEST_TYPE_REMOVAL_CANCEL_ID = "Cancel";
    private static final String POP_UP_TEST_TYPE_REMOVAL_REMOVE_ID = "Remove";
    private static final String POP_UP_TEST_TYPE_REMOVAL_TEXT_ID = "This action will remove this test type from the vehicle.";
    private static final String POP_UP_TEST_TYPE_REMOVAL_TITLE_XPATH = "//XCUIElementTypeStaticText[@name=\"Remove test type\"]";
    private static final String PROHIBITION_ISSUED_SWITCH_XPATH = "//XCUIElementTypeSwitch[@name=\"Issued in Mobile Compliance\"]";
    private static final String PAGE_ALL_LABELS_CLASS_NAME = "XCUIElementTypeStaticText";
    private static final String EXPIRY_DATE_INPUT_FIELD_XPATH = "//XCUIElementTypeButton[@name='Enter']";
    private static final String DONE_ID = "Done";
    private static final String EMISSION_STANDARD_BUTTON_XPATH = "//XCUIElementTypeButton[@name='Emission standard Select arrow forward']" ;
    private static final String SMOKE_TEST_K_LIMIT_BUTTON_XPATH = "//XCUIElementTypeButton[contains(@name, 'Smoke test')]";
    private static final String SMOKE_TEST_K_LIMIT_INPUT_FIELD_XPATH = "//XCUIElementTypeTextField";
    private static final String FUEL_TYPE_XPATH = "//XCUIElementTypeButton[@name='Fuel type Select arrow forward']";
    private static final String MOD_TYPE_XPATH = "//XCUIElementTypeButton[@name='Modification type Select arrow forward']";
    private static final String PARTICULATE_TRAP_FITTED_XPATH = "//XCUIElementTypeButton[@name='Particulate trap fitted Enter']";
    private static final String PARTICULATE_TRAP_SERIAL_NUMBER_XPATH = "//XCUIElementTypeButton[@name='Particulate trap serial number Enter']";
    private static final String PARTICULATE_TRAP_FITTED_INPUT_FIELD_XPATH = "//XCUIElementTypeTextField";
    private static final String PARTICULATE_TRAP_SERIAL_NUMBER_INPUT_FIELD_XPATH = "//XCUIElementTypeTextField";
    private static final String MODIFICATION_TYPE_USED_XPATH = "//XCUIElementTypeButton[@name='Modification type used Enter']";
    private static final String MODIFICATION_TYPE_USED_INPUT_FIELD_XPATH = "//XCUIElementTypeTextField";
    private static final String FUEL_TYPE_TITLE = "Fuel type";
    private static final String EMISSION_STANDARD_TITLE = "Emission standard";
    private static final String EMISSION_DETAILS = "EMISSION DETAILS";

    public WebElement getTestTypeDetails() {
        return findElementById(TEST_TYPE_DETAILS);
    }

    public WebElement getAddDefectElement() {
        waitUntilPageIsLoadedById(ADD_DEFECT_ID);
        return findElementById(ADD_DEFECT_ID);
    }


    public void waitUntilPageIsLoadedByTestType(String testName) {
        waitUntilPageIsLoadedByXpath("//*[@name='" + testName + "']");
    }

    public WebElement checkDefectIsPresent(String defect) {
        return findElementByXpath("//*[contains(@label, '" + defect + "')]");
    }


    public List<WebElement> checkElementIsNotPresent(String item) {
        return findElementsByXpath("//*[@name='" + item + "']");
    }

    public boolean isDefectVisible(String defect) {
        waitUntilPageIsLoaded();
        try {
            return findElementById(defect).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public WebElement getElementById(String id) {
        return findElementById(id);
    }

    public WebElement getElementByLabel(String label) {
        return findElementByXpath("//*[@label='" + label + "']");
    }

    public int getPRMSLabels() {
        return findElementsByXpath("//*[@label='PRS']").size();
    }

    public void clickOnDefect(String recordDefect, String defectItem) {
        if (checkDefectIsPresent(defectItem) != null) {
            findElementByXpath("//*[contains(@label, '" + recordDefect + "')]").click();
        }
    }

    public void swipeLeftOnDefect(String defectId) {
        WebElement defectToSwipe = findElementById(defectId);
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        Map<String, Object> params = new HashMap<>();
        params.put("direction", "left");
        params.put("element", ((RemoteWebElement) defectToSwipe).getId());
        js.executeScript("mobile: swipe", params);
    }

    public void clickOnRemoveButton() {
        findElementById(REMOVE_BUTTON_ID).click();
    }

    public boolean isDefectRemovalPopUpVisible() {
        boolean status = false;
        WebElement cancelButton = findElementById(POP_UP_CANCEL_ID);
        WebElement removeButton = findElementByXpath(POP_UP_REMOVE_XPATH);
        WebElement text = findElementById(POP_UP_TEXT_ID);
        WebElement title = findElementById(POP_UP_TITLE_ID);
        if (cancelButton.isDisplayed() && removeButton.isDisplayed() && text.isDisplayed() && title.isDisplayed()) {
            status = true;
        }
        return status;
    }

    public boolean isTestTypeRemovalPopUpVisible() {
        boolean status = false;
        WebElement cancelButton = findElementById(POP_UP_TEST_TYPE_REMOVAL_CANCEL_ID);
        WebElement removeButton = findElementById(POP_UP_TEST_TYPE_REMOVAL_REMOVE_ID);
        WebElement text = findElementByXpath(POP_UP_TEST_TYPE_REMOVAL_TITLE_XPATH);
        WebElement title = findElementById(POP_UP_TEST_TYPE_REMOVAL_TEXT_ID);
        if (cancelButton.isDisplayed() && removeButton.isDisplayed() && text.isDisplayed() && title.isDisplayed()) {
            status = true;
        }
        return status;
    }

    public void clickRemoveInPopUp() {
        findElementByXpath(POP_UP_REMOVE_XPATH).click();
    }

    public void clickCancelInTestTypePopUp() {
        findElementById(POP_UP_TEST_TYPE_REMOVAL_CANCEL_ID).click();
    }

    public void clickRemoveInTestTypePopUp() {
        findElementById(POP_UP_TEST_TYPE_REMOVAL_REMOVE_ID).click();
    }

    public void clickCancelInPopUp() {
        findElementById(POP_UP_CANCEL_ID).click();
    }

    private static final String NO_SEATBELTS_ENTERED_POP_UP_TITLE_XPATH = "//XCUIElementTypeStaticText[@name=\"No seatbelts entered\"]";
    private static final String NO_SEATBELTS_ENTERED_POP_UP_MESSAGE_XPATH = "//XCUIElementTypeStaticText[@name=\"The number of seatbelts fitted must be greater than zero (0) to carry out an installation check.\"]";
    private static final String NO_SEATBELTS_ENTERED_POP_UP_OK_BUTTON_XPATH = "//XCUIElementTypeButton[@name=\"OK\"]";

    public boolean checkSeatbeltPopUpTitle() {
        return findElementByXpath(NO_SEATBELTS_ENTERED_POP_UP_TITLE_XPATH).isDisplayed();
    }

    public boolean checkSeatbeltPopUpMessage() {
        return findElementByXpath(NO_SEATBELTS_ENTERED_POP_UP_MESSAGE_XPATH).isDisplayed();
    }

    public boolean checkSeatbeltPopUpOkButton() {
        return findElementByXpath(NO_SEATBELTS_ENTERED_POP_UP_OK_BUTTON_XPATH).isDisplayed();
    }

    public void clickOkButtonForSeatbeltPopUp() {
        findElementByXpath(NO_SEATBELTS_ENTERED_POP_UP_OK_BUTTON_XPATH).click();
    }

    public void waitUntilPageIsLoaded() {
        waitUntilPageIsLoadedById(TEST_TYPE_DETAILS);
    }

    public void clickSaveButton() {
        findElementById(SAVE_BUTTON_ID).click();
    }

    public void clickTechnicalTestEdited() {
        findElementById(TECHNICAL_TEST_EDIT_ID).click();
    }

    public void selectCarriedOutOption() {
        findElementByXpath("//XCUIElementTypeButton[starts-with(@name,'Carried out during this test')]").click();
    }

    public boolean checkIsCarriedOutValue(String yesOrNo) {
        return findElementByXpath("//XCUIElementTypeButton[contains(@name,'Carried out during this test " + yesOrNo + " arrow forward')]").isDisplayed();
    }

    public boolean checkIsCarriedOutDisplayed() {
        try {
            findElementByXpath("//XCUIElementTypeButton[starts-with(@name,'Carried out during this test')]").isDisplayed();
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }



    public void selectIsCarriedOut() {
        waitUntilPageIsLoaded();
        findElementById(CARRIED_OUT_YES_OPTION_ID).click();
    }



    public void selectIsNotCarriedOut() {
        waitUntilPageIsLoaded();
        findElementById(CARRIED_OUT_NO_OPTION_ID).click();
    }

    public void cancelIsCarriedOut() {
        findElementById(CARRIED_OUT_CANCEL_OPTION_ID).click();
    }

    public boolean isCarriedOutDisplayed() {
        return findElementById(CARRIED_OUT_YES_OPTION_ID).isDisplayed();
    }

    public boolean isNotCarriedOutDisplayed() {
        return findElementById(CARRIED_OUT_NO_OPTION_ID).isDisplayed();
    }

    public boolean isCancelCarriedOutDisplayed() {
        return findElementById(CARRIED_OUT_CANCEL_OPTION_ID).isDisplayed();
    }

    public void selectSeatbeltsNumberOption() {
        waitUntilPageIsLoaded();
        findElementByXpath("//XCUIElementTypeButton[starts-with(@name,'Number of seatbelts fitted')]").click();
    }

    public boolean checkSetbealtNumber(String seatbeltNumber) {
        return findElementByXpath("//XCUIElementTypeButton[contains(@name,'Number of seatbelts fitted " + seatbeltNumber + "')]").isDisplayed();
    }

    public boolean isSeatbeltTitleDisplayed() {
        return findElementById(SEATBELT_TITLE_ID).isDisplayed();
    }

    public void selectRecentInstallationCheckOption() {
        findElementByXpath("//XCUIElementTypeButton[starts-with(@name,'Most recent installation check')]").click();
    }

    public void cancelMostRecentInstallationCheck() {
        findElementById(MOST_RECENT_INSTALLATION_CHECK_CANCEL_BUTTON_ID).click();
    }

    public void doneMostRecentInstallationCheck() {
        findElementById(MOST_RECENT_INSTALLATION_CHECK_DONE_BUTTON_ID).click();
    }

    public void setRecentInstallationDateCheckOneUnit() {
        findElementByXpath("//XCUIElementTypeOther[@name=\"web dialog\"]/XCUIElementTypeOther[3]").click();
        scrollOneDay();
        scrollOneMonth();
        scrollOneYear();
        doneMostRecentInstallationCheck();
    }

    public boolean verifyMostRecentInstallationDate() {
        EnvironmentType envType = TypeLoader.getType();
        LocalDateTime ldt;
        switch (envType) {
            case LOCAL_SIMULATOR:
                ldt = LocalDateTime.now();
                break;
            case LOCAL_REAL_DEVICE:
                ldt = LocalDateTime.now(ZoneId.of(LoaderlLocalRealDeviceImpl.getTimezone()));
                break;
            default:
                ldt = LocalDateTime.now(Clock.systemUTC());
                break;
        }

        Integer dayOfSystem = 1;
        if(ldt.getDayOfMonth() > 1) {
            dayOfSystem = ldt.getDayOfMonth() - 1;
        }
        int monthOfSystem = ldt.getMonthValue() - 2;
        Integer yearOfSystem = ldt.getYear() - 1;

        String day = dayOfSystem.toString();
        String month = new DateFormatSymbols().getMonths()[monthOfSystem].substring(0, 3);
        String year = yearOfSystem.toString();
        try {
            findElementByXpath("//XCUIElementTypeButton[starts-with(@name,'Most recent installation check " + day + " " + month + " " + year + "')]");
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean verifyThatNoRecentInstallationDateIsDisplayed() {
        return findElementById("Most recent installation check Most recent installation check Enter").isDisplayed();
    }

    public boolean isMostInstallationCheckButtonDisplayed() {
        try {
            findElementByXpath("//XCUIElementTypeButton[starts-with(@name,'Most recent installation check')]");
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isDateCalendarPickerDisplayed() {
        return findElementById("web dialog").isDisplayed();
    }

    public boolean isCancelOptionDisplayedForDatePicker() {
        return findElementById(MOST_RECENT_INSTALLATION_CHECK_CANCEL_BUTTON_ID).isDisplayed();
    }

    public boolean isDoneOptionDisplayedForDatePicker() {
        return findElementById(MOST_RECENT_INSTALLATION_CHECK_DONE_BUTTON_ID).isDisplayed();
    }

    public boolean isTestTypeDetailsTitleDisplayed() {
        return findElementById(TEST_TYPE_DETAILS).isDisplayed();
    }

    public void scrollOneDay() {
        scroll(95, 594, 95, 603);
    }

    public void scrollOneMonth() {
        scroll(178, 594, 178, 608);
    }

    public void scrollOneYear() {
        scroll(243, 594, 243, 585);
    }

    public void clickSave() {
        findElementById(SAVE_BUTTON_ID).click();
    }

    public void clickSetTestResult() {
        waitUntilPageIsLoaded();
        findElementByXpath(TEST_RESULT_XPATH).click();
    }

    public void passLecTest() {
        waitUntilPageIsLoaded();
        findElementByAccessibilityId(PASS_ID).click();
    }

    public void failLecTest() {
        waitUntilPageIsLoaded();
        findElementByAccessibilityId(FAIL_ID).click();
    }

    public void setPRSTest() {
        waitUntilPageIsLoaded();
        findElementByAccessibilityId(PRS_ID).click();
    }

    public void cancelLecTest() {
        waitUntilPageIsLoaded();
        findElementByAccessibilityId(CANCEL_LEC_TEST_ID).click();
    }

    public boolean checkPassTestOptionIsPresent() {
        return findElementById(PASS_ID).isDisplayed();
    }

    public boolean checkFailTestOptionIsPresent() {
        return findElementById(FAIL_ID).isDisplayed();
    }

    public boolean checkTestStatus(String status) {
        waitUntilPageIsLoaded();
        return findElementById("Test result " + status).isDisplayed();
    }

    public void clickPassedTest() {
        waitUntilPageIsLoaded();
        findElementById("Test result Pass").click();
    }

    public boolean checkCancelTestOptionIsPresent() {
        return findElementById(CANCEL_LEC_TEST_ID).isDisplayed();
    }

    public boolean checkLPLabelIsPresent() {
        return findElementById(LP_LABEL_ID).isDisplayed();
    }

    public boolean checkCertificateNumberInputFieIdIsPresent() {
        return findElementByXpath(CERTIFICATE_NUMBER_INPUT_FIELD_XPATH).isDisplayed();
    }

    public boolean checkCertificateNumberLabelIsPresent() {
        waitUntilPageIsLoaded();
        return findElementById(CERTIFICATE_NUMBER_LABEL_ID).isDisplayed();
    }

    public boolean checkCertificateNumberCOIFLabelIsPresent() {
        return findElementById(CERTIFICATE_NUMBER_COIFLABEL_ID).isDisplayed();
    }

    public void sendCertificateNumberAndSave(String certificateNumber) {
        sendCertificateNumber(certificateNumber);
        clickSaveButton();
    }

    public void sendCertificateNumber(String certificateNumber) {
        WebElement inputField = findElementByXpath(CERTIFICATE_NUMBER_INPUT_FIELD_XPATH);
        inputField.clear();
        inputField.sendKeys(certificateNumber);
    }

    public String getCertificateNumber() {
        clickTechnicalTestEdited();
        return findElementByXpath(CERTIFICATE_NUMBER_INPUT_FIELD_XPATH).getText();
    }

    public String cancelInputCertificateNumber() {
        findElementByXpath(CERTIFICATE_NUMBER_INPUT_FIELD_XPATH).click();
        findElementById(TEST_TYPE_DETAILS).click();
        return findElementByXpath(CERTIFICATE_NUMBER_INPUT_FIELD_XPATH).getText();
    }

    public boolean isCertificateGuidanceDisplayed() {
        return findElementById(CERTIFICATE_NUMBER_GUIDANCE_ID).isDisplayed();
    }

    public void clickNotes() {
        findElementByClassName(NOTES_INPUT_FIELD_CLASS_NAME).click();
    }

    public void typeIntoNotesField(String text) {
        WebElement inputField = findElementByClassName(NOTES_INPUT_FIELD_CLASS_NAME);
        inputField.clear();
        inputField.sendKeys(text);
    }

    public boolean isTextDisplayedInNotes(String text) {
        return findElementByClassName(NOTES_INPUT_FIELD_CLASS_NAME).getAttribute("value").contains(text);
    }

    public boolean isTestResultFieldDisplayed() {
        return findElementByXpath(TEST_RESULT_XPATH).isDisplayed();
    }

    public boolean isPassOptionDisplayed() {
        return findElementByAccessibilityId(PASS_ID).isDisplayed();
    }

    public boolean isFailOptionDisplayed() {
        return findElementByAccessibilityId(FAIL_ID).isDisplayed();
    }

    public boolean isPRSOptionDisplayed() {
        return findElementByAccessibilityId(PRS_ID).isDisplayed();
    }

    public boolean isSelectStatusDisplayed() {
        return findElementByXpath(TEST_RESULT_XPATH).getAttribute("name").contains("Select");
    }

    public void scrollDetailPage() {
        scrollDownTo(500, -100);
    }

    public void pressTestTypeAbandonButton() {
        findElementById(ABANDON_TEST_TYPE).click();
    }

    public void pressTestTypeRemoveButton() {
        findElementById(REMOVE_TEST_TYPE).click();
    }

    public boolean isAddDefectButtonDisplayed() {
        return findElementByAccessibilityId(ADD_DEFECT_ID).isDisplayed();
    }

    public void tapDefectDescription(String description) {
        List<WebElement> list = findElementsByAccessibilityId(description);
        list.get(list.size() - 1).click();
    }

    public boolean checkNumberOfSeatbeltsIsNotDisplayed() {
        return findElementById("Number of seatbelts fitted Enter").isDisplayed();
    }

    public void tapTitleTwiceToCloseIOSKeyboard() {
        findElementByAccessibilityId(TEST_TYPE_DETAILS).click();
        findElementByAccessibilityId(TEST_TYPE_DETAILS).click();
    }

    public void enableProhibition() {
        tap(findElementByXpath(PROHIBITION_ISSUED_SWITCH_XPATH));
    }

    public String getProhibitionSwitchValue() {
        return findElementByXpath(PROHIBITION_ISSUED_SWITCH_XPATH).getAttribute("value");
    }

    public void enablePRS() {
        tap(findElementByXpath("//XCUIElementTypeSwitch[@name=\"Issued in Mobile Compliance\"]"));
    }

    public boolean isAbandonButtonDisplayed() {
        return findElementById(ABANDON_TEST_TYPE).isDisplayed();
    }

    public boolean isRemoveTestButtonDisplayed() {
        return findElementById(REMOVE_TEST_TYPE).isDisplayed();
    }

    public boolean isCertificateNumberGuidance(String instruction) {
        return findElementById(instruction).isDisplayed();
    }

    public boolean isCertificateNumber(String certificateNumber) {
        return findElementById(certificateNumber).isDisplayed();
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

    public boolean isStaticTextDisplayed(String staticText) {
        return !isStaticTextNotDisplayed(staticText);
    }


    public List<WebElement> getAllLabels(){
        return findElementsByClassName(PAGE_ALL_LABELS_CLASS_NAME);
    }

    public boolean isErrorMessageDisplayed(String errorMessage) {
        List<WebElement> webElementList = getDriver().findElements(By.className("XCUIElementTypeStaticText"));
        for (WebElement webElement : webElementList) {
            if(webElement.getAttribute("name").contains(errorMessage)){
                return true;
            }
        }
        return false;
    }

    public boolean isErrorMessageNotDisplayed(String errorMessage) {
        waitUntilPageIsLoaded();
        return !isErrorMessageDisplayed(errorMessage);
    }

    public void setExpiryDateDefault() {
        waitUntilPageIsLoaded();
        findElementByXpath(EXPIRY_DATE_INPUT_FIELD_XPATH).click();
        waitUntilPageIsLoaded();
        findElementById(DONE_ID).click();
    }

    public void clickOnDefect(String defectName) {
        if (checkDefectIsPresent(defectName) != null) {
            findElementByXpath("//*[contains(@label, '" + defectName + "')]").click();
        }
    }

    public void setEmissionStandard(EmissionStandard emission) {
        waitUntilPageIsLoadedById(EMISSION_DETAILS);
        findElementByXpath(EMISSION_STANDARD_BUTTON_XPATH).click();
        waitUntilPageIsLoadedById(EMISSION_STANDARD_TITLE);
        findElementById(emission.getDescription()).click();
    }

    public void selectEmissionStandard(EmissionStandard emission) {
        waitUntilPageIsLoadedById(EMISSION_STANDARD_TITLE);
        findElementById(emission.getDescription()).click();
    }

    public void selectFuelType(FuelType fuelType) {
        waitUntilPageIsLoadedById(FUEL_TYPE_TITLE);
        findElementById(fuelType.getName()).click();
    }

    public void clickEmissionStandard() {
        findElementByXpath(EMISSION_STANDARD_BUTTON_XPATH).click();
    }

    public void clickFuelType() {
        findElementByXpath(FUEL_TYPE_XPATH).click();
    }

    public void clickFuelType(FuelType fuelType) {
        String label = FUEL_TYPE_TITLE + " " + fuelType.getName() + " arrow forward";
        findElementById(label).click();
    }

    public void clickEmissionStandard(EmissionStandard emissionStandard) {
        String label = EMISSION_STANDARD_TITLE + " " + emissionStandard.getDescription() + " arrow forward";
        findElementById(label).click();
    }

    public boolean checkEmissionStandardsArePresent() {
        waitUntilPageIsLoadedById(EMISSION_STANDARD_TITLE);
        String emissionType;
        for (EmissionStandard emissionStandard : EmissionStandard.values()) {
            emissionType = emissionStandard.getDescription();
            System.out.println("Looking for Emission Standard: " + emissionType);
            try {
                findElementById(emissionType).isDisplayed();
                System.out.println("- Found: " + emissionType);
            } catch (Exception e) {
                System.out.println("- NOT Found: " + emissionType);
                return false;
            }
        }
        return true;
    }

    public boolean checkFuelTypesArePresent() {
        waitUntilPageIsLoadedById(FUEL_TYPE_TITLE);
        String fuelTypeName;
        for (FuelType fuelType : FuelType.values()) {
            fuelTypeName = fuelType.getName();
            System.out.println("Looking for Fuel Type: " + fuelTypeName);
            try {
                findElementById(fuelTypeName).isDisplayed();
                System.out.println("- Found: " + fuelTypeName);
            } catch (Exception e) {
                System.out.println("- NOT Found: " + fuelTypeName);
                return false;
            }
        }
        return true;
    }

    public String getSelectedEmissionStandard() {
        waitUntilPageIsLoadedById(EMISSION_DETAILS);
        WebElement element = findElementByXpath("//*[contains(@name, '" + EMISSION_STANDARD_TITLE + "')]");
        String emissionLabel = element.getAttribute("name");
        String emissionText = emissionLabel.substring(EMISSION_STANDARD_TITLE.length()+1, emissionLabel.indexOf(" arrow forward"));
        return emissionText;
    }

    public String getSelectedFuelType() {
        waitUntilPageIsLoadedById(EMISSION_DETAILS);
        WebElement element = findElementByXpath("//*[contains(@name, '" + FUEL_TYPE_TITLE + "')]");
        String fuelLabel = element.getAttribute("name");
        String fuelText = fuelLabel.substring(FUEL_TYPE_TITLE.length()+1, fuelLabel.indexOf(" arrow forward"));
        return fuelText;
    }

    public void setSmokeTestKLimit(String amount) {
        waitUntilPageIsLoaded();
        findElementByXpath(SMOKE_TEST_K_LIMIT_BUTTON_XPATH).click();
        findElementByXpath(SMOKE_TEST_K_LIMIT_INPUT_FIELD_XPATH).sendKeys(amount);
        findElementById(DONE_ID).click();
    }

    public void setFuelType(FuelType fuelType) {
        waitUntilPageIsLoadedById(EMISSION_DETAILS);
        findElementByXpath(FUEL_TYPE_XPATH).click();
        waitUntilPageIsLoadedById(FUEL_TYPE_TITLE);
        findElementById(fuelType.getName()).click();
    }

    public void setModeType(ModType modType) {
        waitUntilPageIsLoaded();
        findElementByXpath(MOD_TYPE_XPATH).click();
        waitUntilPageIsLoaded();
        findElementByXpath("//XCUIElementTypeButton[@name='" + modType.getDescription() + "']").click();
    }

    public void setParticulateTrapFitted(String trapFitted) {
        waitUntilPageIsLoaded();
        findElementByXpath(PARTICULATE_TRAP_FITTED_XPATH).click();
        findElementByXpath(PARTICULATE_TRAP_FITTED_INPUT_FIELD_XPATH).sendKeys(trapFitted);
        findElementById(DONE_ID).click();
    }

    public void setParticulateTrapSerialNumber(String trapFitted) {
        waitUntilPageIsLoaded();
        findElementByXpath(PARTICULATE_TRAP_SERIAL_NUMBER_XPATH).click();
        findElementByXpath(PARTICULATE_TRAP_SERIAL_NUMBER_INPUT_FIELD_XPATH).sendKeys(trapFitted);
        findElementById(DONE_ID).click();
    }

    public void setModificationTypeUsed(String modificationType) {
        waitUntilPageIsLoaded();
        findElementByXpath(MODIFICATION_TYPE_USED_XPATH).click();
        findElementByXpath(MODIFICATION_TYPE_USED_INPUT_FIELD_XPATH).sendKeys(modificationType);
        findElementById(DONE_ID).click();
    }

}

