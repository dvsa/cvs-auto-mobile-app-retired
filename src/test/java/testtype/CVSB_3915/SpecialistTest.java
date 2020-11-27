package testtype.CVSB_3915;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import pages.SelectReasonPage;
import pages.TestPage;
import steps.*;
import steps.composed.VehicleComp;
import steps.util.UtilSteps;
import utils.BaseTestClass;

@RunWith(SerenityRunner.class)
public class SpecialistTest extends BaseTestClass {

    @Steps
    UtilSteps utilSteps;

    @Steps
    VehicleComp vehicleComp;

    @Steps
    VehicleDetailsSteps vehicleDetailsSteps;

    @Steps
    PreparerSteps preparerSteps;

    @Steps
    TestSteps testSteps;

    @Steps
    TestTypeCategorySteps testTypeCategorySteps;

    @Steps
    TestTypeDetailsSteps testTypeDetailsSteps;

    @Steps
    SelectReasonSteps selectReasonSteps;

    @Steps
    AbandonTestSteps abandonTestSteps;

    @Steps
    EUVehicleCategorySteps euVehicleCategorySteps;

    @Steps
    OdometerReadingSteps odometerReadingSteps;

    @Steps
    TestReviewSteps testReviewSteps;

    @Steps
    DefectDetailsSteps defectDetailsSteps;

    @Steps
    TestTypeSubcategorySteps testTypeSubcategorySteps;

    @Steps
    IdentifyVehicleSteps identifyVehicleSteps;

    @Title("CVSB-3915 - AC1 - Specialist Test Details")
    @Test
    public void testFieldsDisplayedInApp() {
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        vehicleComp.goToIdentifyVehicle(super.username);
        identifyVehicleSteps.searchForVehicle("P0123010911250");// // Car
        identifyVehicleSteps.waitUntilPageIsLoaded();
        identifyVehicleSteps.clickSearchCriteriaButton();
        vehicleDetailsSteps.waitUntilPageIsLoaded();
        vehicleDetailsSteps.selectConfirmButtonTopRight();
        vehicleDetailsSteps.selectConfirmFromPopUp();
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();

        // Add a Specialist Test to the test.
        testSteps.addTestType();
        testTypeCategorySteps.waitUntilPageIsLoaded();
        testTypeCategorySteps.selectFromTestTypeList("Specialist test");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("Specialist test");
        testTypeSubcategorySteps.selectFromTestTypeList("IVA");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("IVA");
        testTypeCategorySteps.selectFromTestTypeList("Mutual recognition/ end of series & inspection");

        // View the Specialist Test details.
        testSteps.waitUntilPageIsLoaded();
        testSteps.selectTestType("Specialist test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.checkTestTypeDetailsTitleIsDisplayed();
        testTypeDetailsSteps.checkSectionHeadingIsShown("RESULT");
        testTypeDetailsSteps.checkResultIsNotSet();
        testTypeDetailsSteps.checkSectionHeadingIsShown("DEFECTS");
        testTypeDetailsSteps.checkAddDefectIsPresent();
        testTypeDetailsSteps.checkSectionHeadingIsShown("NOTES");
        testTypeDetailsSteps.checkNotesText("Add notes");
        testTypeDetailsSteps.checkSectionHeadingIsShown("PROHIBITION");
        testTypeDetailsSteps.checkProhibitionIssuedSwitchOff();

        // Verify that we can remove the Specialist test type.
        testTypeDetailsSteps.pressTestTypeRemoveButton();
        testTypeDetailsSteps.pressRemoveTestTypeInPopUp();
        testSteps.checkTestTypeDeleted("Specialist test");

        // Verify that we can abandon the Specialist test type.
        // Add a Specialist Test to the test.
        testSteps.addTestType();
        testTypeCategorySteps.waitUntilPageIsLoaded();
        testTypeCategorySteps.selectFromTestTypeList("Specialist test");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("Specialist test");
        testTypeSubcategorySteps.selectFromTestTypeList("IVA");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("IVA");
        testTypeCategorySteps.selectFromTestTypeList("Mutual recognition/ end of series & inspection");
        testSteps.waitUntilPageIsLoaded();
        testSteps.selectTestType("Specialist test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.pressTestTypeAbandonButton();
        selectReasonSteps.selectASpecialistReason(SelectReasonPage.ReasonsSpecialist.REASON_SPECIALIST_1);
        selectReasonSteps.pressNextButton();
        abandonTestSteps.pressDone();
        abandonTestSteps.pressAbandon();
        testSteps.checkTestTypeStatus("Specialist test", TestPage.TestTypeStatuses.ABANDONED);
    }

    @Title("CVSB-3915 - AC2 - VSA selects result (Non-IVA)")
    @Test
    public void testVSASelectsResult_NonIVA() {
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        vehicleComp.goToIdentifyVehicle(super.username);
        identifyVehicleSteps.searchForVehicle("1B7GG36N12S678410");// PSV
        identifyVehicleSteps.waitUntilPageIsLoaded();
        identifyVehicleSteps.clickSearchCriteriaButton();
        vehicleDetailsSteps.waitUntilPageIsLoaded();
        vehicleDetailsSteps.selectConfirmButtonTopRight();
        vehicleDetailsSteps.selectConfirmFromPopUp();
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();

        // Add a Specialist Test to the test.
        testSteps.addTestType();
        testTypeCategorySteps.waitUntilPageIsLoaded();
        testTypeCategorySteps.selectFromTestTypeList("Specialist test");
        testTypeSubcategorySteps.selectFromTestTypeList("Specialist test");
        testTypeSubcategorySteps.selectFromTestTypeList("COIF");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("COIF");
        testTypeCategorySteps.selectFromTestTypeList("Annex 7");
        testSteps.waitUntilPageIsLoaded();

        // In order to verify that the test result is mandatory, fill all other test fields first.
        testSteps.selectEuVehicleCategory();
        euVehicleCategorySteps.selectM2Option();

        testSteps.selectOdometerReading();
        odometerReadingSteps.typeInField("12345");
        odometerReadingSteps.pressSave();

        // Verify that the Specialist Test pass/fail result is mandatory.
        testSteps.clickReviewAndSubmit();
        testSteps.checkErrorMessageMandatoryFieldsDisplayed();

        // View the Specialist Test details - verify that Pass/Fail options exist.
        testSteps.selectTestType("Specialist test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.pressTestResultsOption();
        testTypeDetailsSteps.checkFailAndPassOptions();
        testTypeDetailsSteps.pressCancelInPopUp();
        testTypeDetailsSteps.setTestToOption("pass");
        testTypeDetailsSteps.pressSave();

        // Verify that selecting a test result removes the "mandatory field missing" message.
        testSteps.checkErrorMessageMandatoryFieldsNotDisplayed();
    }

    @Title("CVSB-3915 - AC3 - VSA selects result (IVA)")
    @Test
    public void testVSASelectsResultIVA() {
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        vehicleComp.goToIdentifyVehicle(super.username);
        identifyVehicleSteps.searchForVehicle("1B7GG36N12S678410");// PSV
        identifyVehicleSteps.waitUntilPageIsLoaded();
        identifyVehicleSteps.clickSearchCriteriaButton();
        vehicleDetailsSteps.waitUntilPageIsLoaded();
        vehicleDetailsSteps.selectConfirmButtonTopRight();
        vehicleDetailsSteps.selectConfirmFromPopUp();
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();

        // Add a Specialist Test to the test.
        testSteps.addTestType();
        testTypeCategorySteps.waitUntilPageIsLoaded();
        testTypeCategorySteps.selectFromTestTypeList("Specialist test");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("Specialist test");
        testTypeCategorySteps.selectFromTestTypeList("IVA");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("IVA");
        testTypeCategorySteps.selectFromTestTypeList("Normal inspection");
        testSteps.waitUntilPageIsLoaded();

        // View the Specialist Test details.
        // In order to verify that the test result is mandatory, fill all other test fields first.
        testSteps.selectEuVehicleCategory();
        euVehicleCategorySteps.selectM2Option();

        testSteps.selectOdometerReading();
        odometerReadingSteps.typeInField("12345");
        odometerReadingSteps.pressSave();

        // Verify that the Specialist Test pass/fail result is mandatory.
        testSteps.clickReviewAndSubmit();
        testSteps.checkErrorMessageMandatoryFieldsDisplayed();

        // View the Specialist Test details - verify that Pass/Fail/PRS options exist.
        testSteps.selectTestType("Specialist test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.pressTestResultsOption();
        testTypeDetailsSteps.checkFailPassPRSOptions();
        testTypeDetailsSteps.pressCancelInPopUp();
        testTypeDetailsSteps.setTestToOption("pass");
        testTypeDetailsSteps.sendCertificateNumberAndSave("12345");

        // Verify that selecting a test result removes the "mandatory field missing" message.
        testSteps.checkErrorMessageMandatoryFieldsNotDisplayed();
    }

    @Title("CVSB-3915 - AC4 - VSA selects result (Pass, Non-COIF), certificate number attributes")
    @Test
    public void testVSASelectsResultPass_NonCOIF_CertificateAttributes() {
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        vehicleComp.goToIdentifyVehicle(super.username);
        identifyVehicleSteps.searchForVehicle("1B7GG36N12S678410");// PSV
        identifyVehicleSteps.waitUntilPageIsLoaded();
        identifyVehicleSteps.clickSearchCriteriaButton();
        vehicleDetailsSteps.waitUntilPageIsLoaded();
        vehicleDetailsSteps.selectConfirmButtonTopRight();
        vehicleDetailsSteps.selectConfirmFromPopUp();
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();

        // Add a Specialist Test to the test.
        testSteps.addTestType();
        testTypeCategorySteps.waitUntilPageIsLoaded();
        testTypeCategorySteps.selectFromTestTypeList("Specialist test");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("Specialist test");
        testTypeCategorySteps.selectFromTestTypeList("IVA");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("IVA");
        testTypeCategorySteps.selectFromTestTypeList("Normal inspection");

        // View the Specialist Test details.
        // In order to verify that the test result is mandatory, fill all other test fields first.
        testSteps.selectEuVehicleCategory();
        euVehicleCategorySteps.selectM2Option();

        testSteps.selectOdometerReading();
        odometerReadingSteps.typeInField("12345");
        odometerReadingSteps.pressSave();

        // Verify that the Specialist Test pass/fail result is mandatory.
        testSteps.clickReviewAndSubmit();
        testSteps.checkErrorMessageMandatoryFieldsDisplayed();

        // View the Specialist Test details - and verify certificate field status.
        testSteps.selectTestType("Specialist test", TestPage.TestTypeStatuses.IN_PROGRESS);

        // Certificate field not displayed until a Pass or PRS option is selected.
        testTypeDetailsSteps.checkCertificateNumberIsNotDisplayed();

        testTypeDetailsSteps.setTestToOption("PRS");
        testTypeDetailsSteps.checkCertificateNumberIsDisplayed();
        testTypeDetailsSteps.pressSave();

        // Certificate should be mandatory - so should now see a validation error.
        testSteps.checkErrorMessageMandatoryFieldsDisplayed();

        testSteps.selectTestType("Specialist test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.setTestToOption("fail");
        testTypeDetailsSteps.checkCertificateNumberIsNotDisplayed();

        testTypeDetailsSteps.setTestToOption("pass");
        testTypeDetailsSteps.checkCertificateNumberIsDisplayed();
        testTypeDetailsSteps.pressSave();

        // AC10 - Entering no certificate number.
        testSteps.clickReviewAndSubmit();
        testSteps.checkErrorMessageMandatoryFieldsDisplayed();

        // AC9 - Digit certificate number validation
        // Verify certificate field is 20 alphanumeric characters (by removing character 21).
        testSteps.waitUntilPageIsLoaded();
        testSteps.selectTestType("Specialist test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.sendCertificateNumber("1234567890ABCDEFGHIJ1");
        testTypeDetailsSteps.checkCertificateNumberIs("1234567890ABCDEFGHIJ");
        testTypeDetailsSteps.pressSave();

        // Also, as the last field (certificate number) has been populated, validation error should be removed.
        testSteps.checkErrorMessageMandatoryFieldsNotDisplayed();

        testSteps.selectTestType("Specialist test", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.checkCertificateNumberIs("1234567890ABCDEFGHIJ");
    }

    @Title("CVSB-3915 - AC5 - VSA selects result (Pass, COIF), certificate number attributes")
    @Test
    public void testVSASelectsResultPass_COIF_CertificateAttributes() {
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        vehicleComp.goToVehicleDetails("1B7GG36N12S678410", super.username); // PSV
        vehicleDetailsSteps.waitUntilPageIsLoaded();
        vehicleDetailsSteps.selectConfirmButtonTopRight();
        vehicleDetailsSteps.selectConfirmFromPopUp();
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();

        // Add a Specialist Test to the test.
        testSteps.addTestType();
        testTypeCategorySteps.waitUntilPageIsLoaded();
        testTypeCategorySteps.selectFromTestTypeList("Specialist test");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("Specialist test");
        testTypeCategorySteps.selectFromTestTypeList("COIF");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("COIF");
        testTypeCategorySteps.selectFromTestTypeList("With annual test");
        testSteps.waitUntilPageIsLoaded();
        // View the Specialist Test details.
        // In order to verify that the test result is mandatory, fill all other test fields first.
        testSteps.selectEuVehicleCategory();
        euVehicleCategorySteps.selectM2Option();

        testSteps.selectOdometerReading();
        odometerReadingSteps.typeInField("12345");
        odometerReadingSteps.pressSave();

        // Verify that the Specialist Test pass/fail result is mandatory.
        testSteps.clickReviewAndSubmit();
        testSteps.checkErrorMessageMandatoryFieldsDisplayed();

        // View the Specialist Test details - and verify certificate field status.
        testSteps.selectTestType("Specialist test", TestPage.TestTypeStatuses.IN_PROGRESS);

        // Certificate field not displayed until a Pass or PRS option is selected.
        testTypeDetailsSteps.checkCertificateNumberIsNotDisplayed();

        // AC7 - VSA selects result = FAIL
        testTypeDetailsSteps.setTestToOption("fail");
        testTypeDetailsSteps.checkCertificateNumberCOIFIsNotDisplayed();

        testTypeDetailsSteps.setTestToOption("pass");
        testTypeDetailsSteps.checkCertificateNumberCOIFIsDisplayed();
        testTypeDetailsSteps.pressSave();

        // AC10 - Entering no certificate number.
        // Only field missing now is the certificate number - should be a validation error.
        testSteps.clickReviewAndSubmit();
        testSteps.checkErrorMessageMandatoryFieldsDisplayed();

        // AC9 - Digit certificate number validation
        // Verify certificate field is 20 alphanumeric characters (by removing character 21).
        testSteps.selectTestType("Specialist test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.sendCertificateNumber("1234567890ABCDEFGHIJ1");
        testTypeDetailsSteps.checkCertificateNumberIs("1234567890ABCDEFGHIJ");
        testTypeDetailsSteps.pressSave();
        testSteps.selectTestType("Specialist test", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.checkCertificateNumberIs("1234567890ABCDEFGHIJ");
        testTypeDetailsSteps.pressSave();

        // Verify certificate number is mandatory - now provided, so no validation error.
        testSteps.checkErrorMessageMandatoryFieldsNotDisplayed();
    }

    @Title("CVSB-3915 - AC6 - Certificate number for Notifiable Alteration (PSV)")
    @Test
    public void testCertificateNumberForNotifiableAlteration_PSV() {
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        vehicleComp.goToIdentifyVehicle(super.username);
        identifyVehicleSteps.searchForVehicle("XMGDE02FS0H012356");// PSV X71LTA
        identifyVehicleSteps.waitUntilPageIsLoaded();
        identifyVehicleSteps.clickSearchCriteriaButton();
        vehicleDetailsSteps.selectConfirmButtonTopRight();
        vehicleDetailsSteps.selectConfirmFromPopUp();
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();

        // Add a Specialist Test to the test.
        testSteps.addTestType();
        testTypeCategorySteps.waitUntilPageIsLoaded();
        testTypeCategorySteps.selectFromTestTypeList("Technical test");
        testTypeCategorySteps.selectFromTestTypeList("Notifiable alteration");

        testSteps.selectEuVehicleCategory();
        euVehicleCategorySteps.selectM2Option();

        testSteps.selectOdometerReading();
        odometerReadingSteps.typeInField("12345");
        odometerReadingSteps.pressSave();

        // View the test details - and verify certificate field status.
        testSteps.selectTestType("Technical test", TestPage.TestTypeStatuses.IN_PROGRESS);

        // Certificate field not displayed until a Pass or PRS option is selected.
        testTypeDetailsSteps.checkCertificateNumberIsNotDisplayed();

        // AC7 - VSA selects result = FAIL
        testTypeDetailsSteps.setTestToOption("fail");
        testTypeDetailsSteps.checkCertificateNumberIsNotDisplayed();

        testTypeDetailsSteps.setTestToOption("pass");
        testTypeDetailsSteps.checkCertificateNumberIsDisplayed();
        testTypeDetailsSteps.pressSave();

        // Only field missing now is the certificate number - as this is optional, should not cause a validation error.
        testSteps.checkErrorMessageMandatoryFieldsNotDisplayed();

        // AC9 - Digit certificate number validation
        // Verify certificate field is 20 alphanumeric characters (by removing character 21).
        testSteps.selectTestType("Technical test", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.sendCertificateNumber("1234567890ABCDEFGHIJ1");
        testTypeDetailsSteps.checkCertificateNumberIs("1234567890ABCDEFGHIJ");
        testTypeDetailsSteps.pressSave();
        testSteps.selectTestType("Technical test", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.checkCertificateNumberIs("1234567890ABCDEFGHIJ");
        testTypeDetailsSteps.pressSave();

        // Verify certificate number is optional - should progress to Test Review screen.
        testSteps.clickReviewAndSubmit();
        testReviewSteps.checkPageTitleIsDisplayed();
    }

    @Title("CVSB-3915 - AC11 - Defects")
    @Test
    public void testDefects() {
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        vehicleComp.goToVehicleDetails("1B7GG36N12S678410", super.username); // PSV
        vehicleDetailsSteps.selectConfirmButtonTopRight();
        vehicleDetailsSteps.selectConfirmFromPopUp();
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();

        // Add a Specialist Test to the test.
        testSteps.addTestType();
        testTypeCategorySteps.waitUntilPageIsLoaded();
        testTypeCategorySteps.selectFromTestTypeList("Specialist test");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("Specialist test");
        testTypeCategorySteps.selectFromTestTypeList("IVA");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("IVA");
        testTypeCategorySteps.selectFromTestTypeList("Mutual recognition/ end of series & inspection");

        // View the Specialist Test details.
        // In order to verify that the test result is mandatory, fill all other test fields first.
        testSteps.selectEuVehicleCategory();
        euVehicleCategorySteps.selectM2Option();

        testSteps.selectOdometerReading();
        odometerReadingSteps.typeInField("12345");
        odometerReadingSteps.pressSave();

        // View the Specialist Test details - and add a defect.
        testSteps.waitUntilPageIsLoaded();
        testSteps.selectTestType("Specialist test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.clickAddDefect();
        defectDetailsSteps.checkPageTitleIsDisplayed();
        defectDetailsSteps.checkSectionHeadingIsShown("REFERENCE NUMBER");
        defectDetailsSteps.checkSectionHeadingIsShown("DEFECT NAME");
        defectDetailsSteps.checkSectionHeadingIsShown("DEFECT NOTES");

        // Add a defect.
        String defect1 = "12345 My defect 1 My defect 1 notes.";
        defectDetailsSteps.setReferenceNumber("12345");
        defectDetailsSteps.setDefectName("My defect 1");
        defectDetailsSteps.setDefectNotes("My defect 1 notes.");
        defectDetailsSteps.tapDone();

        // Verify can add more than 1 defect.
        testTypeDetailsSteps.clickAddDefect();
        String defect2 = "23456 My defect 2 My defect 2 notes.";
        defectDetailsSteps.setReferenceNumber("23456");
        defectDetailsSteps.setDefectName("My defect 2");
        defectDetailsSteps.setDefectNotes("My defect 2 notes.");
        defectDetailsSteps.tapDone();

        // Verify that the defects are listed.
        testTypeDetailsSteps.checkDefectIsPresent(defect1);
        testTypeDetailsSteps.checkDefectIsPresent(defect2);

        // Remove a defect.
        testTypeDetailsSteps.selectDefectBasedOnDefectDescription(defect1);
        defectDetailsSteps.pressRemove();
        defectDetailsSteps.pressRemoveInPopUp();
        testTypeDetailsSteps.checkDefectRemoved(defect1);
    }

    @Title("CVSB-3915 - AC12 - Reference Number, AC13 - Defect Name, AC14 - Defect Notes")
    @Test
    public void testDefectAttributes() {
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        vehicleComp.goToVehicleDetails("1B7GG36N12S678410", super.username); // PSV
        vehicleDetailsSteps.selectConfirmButtonTopRight();
        vehicleDetailsSteps.selectConfirmFromPopUp();
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();

        // Add a Specialist Test to the test.
        testSteps.addTestType();
        testTypeCategorySteps.waitUntilPageIsLoaded();
        testTypeCategorySteps.selectFromTestTypeList("Specialist test");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("Specialist test");
        testTypeCategorySteps.selectFromTestTypeList("IVA");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("IVA");
        testTypeCategorySteps.selectFromTestTypeList("Normal inspection");

        // View the Specialist Test details.
        // In order to verify that the test result is mandatory, fill all other test fields first.
        testSteps.selectEuVehicleCategory();
        euVehicleCategorySteps.selectM2Option();

        testSteps.selectOdometerReading();
        odometerReadingSteps.typeInField("12345");
        odometerReadingSteps.pressSave();

        // View the Specialist Test details - and add a defect.
        testSteps.waitUntilPageIsLoaded();
        testSteps.selectTestType("Specialist test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.clickAddDefect();
        defectDetailsSteps.checkPageTitleIsDisplayed();

        // AC12 - Reference Number (Maximum 10 characters).
        String longReferenceNumber = "12345ABCDE";
        defectDetailsSteps.setReferenceNumber(longReferenceNumber + "X");
        defectDetailsSteps.checkReferenceNumberIs(longReferenceNumber);

        // AC13 - Defect Name (Maximum 200 characters)
        String longText200 = "12345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890";
        defectDetailsSteps.setDefectName(longText200 + "X");
        defectDetailsSteps.checkDefectNameIs(longText200);

        // AC14 - Defect Notes (Maximum 200 characters)
       defectDetailsSteps.setDefectNotes(longText200 + "X");
       defectDetailsSteps.checkDefectNotesIs(longText200);
    }
}
