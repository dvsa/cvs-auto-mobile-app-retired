package testresults.CVSB_10219;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import pages.ConfirmationPage;
import pages.TestPage;
import steps.*;
import steps.composed.TestTypeCategoryComp;
import util.BaseTestClass;

@RunWith(SerenityRunner.class)
public class SpecialistTestReview_CVSB_10219 extends BaseTestClass {

    @Steps
    TestTypeCategoryComp testTypeCategoryComp;

    @Steps
    TestSteps testSteps;

    @Steps
    PreparerSteps preparerSteps;

    @Steps
    TestHistorySteps testHistorySteps;

    @Steps
    TestTypeCategorySteps testTypeCategorySteps;

    @Steps
    TestTypeDetailsSteps testTypeDetailsSteps;

    @Steps
    VehicleDetailsSteps vehicleDetailsSteps;

    @Steps
    IdentifyTrailerSteps identifyTrailerSteps;

    @Steps
    TrailerDetailsSteps trailerDetailsSteps;

    @Steps
    EUVehicleCategorySteps euVehicleCategorySteps;

    @Steps
    OdometerReadingSteps odometerReadingSteps;

    @Steps
    CountryOfRegistrationSteps countryOfRegistrationSteps;

    @Steps
    DefectDetailsSteps defectDetailsSteps;

    @Steps
    TestReviewSteps testReviewSteps;

    @Steps
    ConfirmationPage confirmationPage;

    @Steps
    SiteVisitSteps siteVisit;

    @Steps
    IdentifyVehicleSteps identifyVehicleSteps;

    @Steps
    TestHistoryDetailsSteps testHistoryDetailsSteps;

    @Title("CVSB-10219 - AC1 - Specialist test details, CVSB-10219 - AC2 - Site visit timeline, CVSB-10219 - AC3 - Test history")
    @Test
    public void testSpecialistTestDetails() {

        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("951264"); // LGV AS23 4TY
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();
        testSteps.checkLGVTestDetails("AS234TY", "P0123010951264");
        testSteps.checkCountryOfRegistrationOptionIsDisplayed();
        testSteps.checkCountryOfRegistrationFieldIsUpdatedFor("Great Britain and Northern Ireland","AS234TY");

        // Add a test type.
        testSteps.addTestType();
        testTypeCategorySteps.selectFromTestTypeList("Specialist test");
        testTypeCategorySteps.selectFromTestTypeList("IVA");
        testTypeCategorySteps.selectFromTestTypeList("Normal inspection");
        testSteps.selectTestType("Specialist test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.checkTestTypeDetailsTitleIsDisplayed();
        testTypeDetailsSteps.setTestToOption("Pass");
        testTypeDetailsSteps.sendCertificateNumber("123456");

        testTypeDetailsSteps.clickAddDefect();
        defectDetailsSteps.checkPageTitleIsDisplayed();

        String defectRefNumber = "12345678";
        String defectName = "MyDefectName";
        String defectNotes = "MyDefectNotes";
        defectDetailsSteps.setReferenceNumber(defectRefNumber);
        defectDetailsSteps.setDefectName(defectName);
        defectDetailsSteps.setDefectNotes(defectNotes);
        defectDetailsSteps.tapDone();
        testTypeDetailsSteps.addNotes("Overall notes");
        testTypeDetailsSteps.pressSave();
        testSteps.checkPageTitleDisplayed();
        testSteps.selectOdometerReading();
        odometerReadingSteps.typeInField("22222");
        odometerReadingSteps.pressSave();
        testSteps.waitUntilPageIsLoaded();
        testSteps.selectEuVehicleCategory();
        euVehicleCategorySteps.checkTitleIsDisplayed();
        euVehicleCategorySteps.selectOption("N1");

        // AC1 - Specialist test details
        // Progress to the Review screen.  Verify all fields are present / have correct values.
        testSteps.clickReviewAndSubmit();

        testReviewSteps.checkPageTitleIsDisplayed();
        testReviewSteps.checkElementValue("Country of registration", "Great Britain and Northern Ireland");
        testReviewSteps.checkElementValue("EU vehicle category", "N1");
        testReviewSteps.checkElementValue("Odometer reading", "22,222 km");
        testReviewSteps.checkElementValue("Normal IVA inspection", "PASS");
        testReviewSteps.checkElementValue("Certificate number", "123456");

        // Basically the 3 defect fields are in serially, so can chain one field value onto the next.
        testReviewSteps.checkElementValue("Defects", defectRefNumber);
        testReviewSteps.checkElementValue(defectRefNumber, defectName);
        testReviewSteps.checkElementValue(defectName, defectNotes);

        testReviewSteps.checkElementValue("Notes", "Overall notes");

        // AC2 - Site visit timeline
        testReviewSteps.scrollDown();
        testReviewSteps.pressSubmit();
        testReviewSteps.pressSubmitInPopUp();
        confirmationPage.waitUntilPageIsLoaded();
        confirmationPage.clickDoneButton();
        siteVisit.waitUntilPageIsLoaded();
        siteVisit.checkVehiclePosition("AS234TY", 0);
        siteVisit.checkVisitResults("AS23 4TY", "Specialist test", "PASS");

        // AC3 - Test history
        // Having added a test record to the vehicle, now verify that this is shown against the vehicle's test history.
        siteVisit.createNewTest();
        identifyVehicleSteps.searchForVehicle("AS234TY");
        vehicleDetailsSteps.selectVehicleTestHistory();
        testHistorySteps.selectTestTypeRecord("Specialist test");
        testHistoryDetailsSteps.checkPageTitle();
        testHistoryDetailsSteps.checkElementValue("TEST TYPE", "Normal IVA Inspection");
        testHistoryDetailsSteps.checkElementValue("Test result", "PASS");
        testHistoryDetailsSteps.checkElementValue("Certificate number", "123456");

        testHistoryDetailsSteps.checkElementValue("DEFECTS", defectRefNumber);
        testHistoryDetailsSteps.checkElementValue(defectRefNumber, defectName);
        testHistoryDetailsSteps.checkElementValue(defectName, defectNotes);

        testHistoryDetailsSteps.checkElementValue("Country of registration", "Great Britain and Northern Ireland");
        testHistoryDetailsSteps.checkElementValue("EU vehicle category", "N1");
        testHistoryDetailsSteps.checkElementValue("Odometer reading", "22,222 km");

        testHistoryDetailsSteps.scrollDown();
        testHistoryDetailsSteps.checkElementValue("NOTES", "Overall Notes");
    }

    @Title("CVSB-11032 - AC2 - Fields displayed on test screen - CAR")
    @Test
    public void testFieldsDisplayedForCar() {

        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("911250"); // CAR QW123RT
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();
        testSteps.checkCarTestDetails("QW123RT", "P0123010911250");
        testSteps.checkCountryOfRegistrationOptionIsDisplayed();
        testSteps.checkCountryOfRegistrationFieldIsUpdatedFor("Great Britain and Northern Ireland","QW123RT");
        testSteps.checkEUVehicleCategoryOptionIsDisplayed();
        testSteps.checkOdometerOptionIsDisplayed();

        // AC10 - "Not Applicable" added to list of options.
        testSteps.clickCountryOfRegistrationOption();
        countryOfRegistrationSteps.selectNotApplicableOption();
        testSteps.checkCountryOfRegistrationFieldIsUpdatedFor("Not applicable", "QW123RT");

        // AC4 - Pre-populated EU vehicle category.  NOTE: Can't "edit" this as only one option for Car.
        testSteps.checkEUVehicleCategoryOptionIs("M1");
        testSteps.selectEuVehicleCategory();
        euVehicleCategorySteps.checkTitleIsDisplayed();
        euVehicleCategorySteps.clickSaveOptionButton();

        // Verify can access the Vehicle Details
        testSteps.selectVehicleDetails();
        vehicleDetailsSteps.checkPageTitle();

        // Verify can access the Test History
        vehicleDetailsSteps.selectVehicleTestHistory();
        testHistorySteps.checkPage();

        testHistorySteps.pressBackButton();
        vehicleDetailsSteps.pressBackButton();
        testSteps.checkPageTitleDisplayed();

        // Add a test type.
        testSteps.addTestType();
        testTypeCategorySteps.selectFromTestTypeList("Specialist test");
        testTypeCategorySteps.selectFromTestTypeList("IVA");
        testTypeCategorySteps.selectFromTestTypeList("Mutual recognition/ end of series & inspection");
        testSteps.selectTestType("Specialist test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.checkTestTypeDetailsTitleIsDisplayed();
        testTypeDetailsSteps.setTestToOption("Pass");
        testTypeDetailsSteps.sendCertificateNumber("1234321");
        testTypeDetailsSteps.pressSave();
        testSteps.checkPageTitleDisplayed();

        // Verify that I am unable to add another vehicle to the test.
        testSteps.checkAddATrailerButtonIsNotPresent();

        // Verify that EU Vehicle Category is mandatory.
        // (Difficult to test - the value is set to something already, and can't be "unset").

        // Verify that Odometer Reading is mandatory.
        testSteps.clickReviewAndSubmit();
        testSteps.checkErrorMessageMandatoryFieldsDisplayed();

        testSteps.selectOdometerReading();
        odometerReadingSteps.typeInField("22222");
        odometerReadingSteps.pressSave();

        testSteps.waitUntilPageIsLoaded();
        testSteps.checkErrorMessageMandatoryFieldsNotDisplayed();
    }

    @Title("CVSB-11032 - AC3 - Fields displayed on test screen - Motorcycle")
    @Test
    public void testFieldsDisplayedForMotorcycle() {

        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("956789"); // MOTORCYCLE ZX345CV
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();
        testSteps.checkMotorcycleTestDetails("ZX345CV", "P0123010956789");
        testSteps.checkCountryOfRegistrationOptionIsDisplayed();
        testSteps.checkCountryOfRegistrationFieldIsUpdatedFor("Great Britain and Northern Ireland","ZX345CV");
        testSteps.checkEUVehicleCategoryOptionIsDisplayed();
        testSteps.checkOdometerOptionIsDisplayed();

        // AC10 - "Not Applicable" added to list of options.
        testSteps.clickCountryOfRegistrationOption();
        countryOfRegistrationSteps.selectNotApplicableOption();
        testSteps.checkCountryOfRegistrationFieldIsUpdatedFor("Not applicable", "ZX345CV");

        // AC4 - Pre-populated EU vehicle category / editable.
        testSteps.checkEUVehicleCategoryOptionIs("L1e-A");
        testSteps.selectEuVehicleCategory();
        euVehicleCategorySteps.checkTitleIsDisplayed();
        euVehicleCategorySteps.selectOption("L2e");
        testSteps.checkEUVehicleCategoryOptionIs("L2e");

        // Verify can access the Vehicle Details
        testSteps.selectVehicleDetails();
        vehicleDetailsSteps.checkPageTitle();

        // Verify can access the Test History
        vehicleDetailsSteps.selectVehicleTestHistory();
        testHistorySteps.checkPage();

        testHistorySteps.pressBackButton();
        vehicleDetailsSteps.pressBackButton();
        testSteps.checkPageTitleDisplayed();

        // Add a test type.
        testSteps.addTestType();
        testTypeCategorySteps.selectFromTestTypeList("Specialist test");
        testTypeCategorySteps.selectFromTestTypeList("IVA");
        testTypeCategorySteps.selectFromTestTypeList("Mutual recognition/ end of series & inspection");
        testSteps.selectTestType("Specialist test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.checkTestTypeDetailsTitleIsDisplayed();
        testTypeDetailsSteps.setTestToOption("Pass");
        testTypeDetailsSteps.sendCertificateNumber("34567");
        testTypeDetailsSteps.pressSave();
        testSteps.checkPageTitleDisplayed();

        // Verify that I am unable to add another vehicle to the test.
        testSteps.checkAddATrailerButtonIsNotPresent();

        // Verify that EU Vehicle Category is mandatory.
        // (Difficult to test - the value is set to something already, and can't be "unset").

        // Verify that Odometer Reading is mandatory.
        testSteps.clickReviewAndSubmit();
        testSteps.checkErrorMessageMandatoryFieldsDisplayed();

        testSteps.selectOdometerReading();
        odometerReadingSteps.typeInField("22222");
        odometerReadingSteps.pressSave();

        testSteps.waitUntilPageIsLoaded();
        testSteps.checkErrorMessageMandatoryFieldsNotDisplayed();
    }

    @Title("CVSB-11032 - AC5 - EU vehicle category options - Motorcycle")
    @Test
    public void testEUVehicleCategoryOptionsForMotorcycle() {

        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("956789"); // MOTORCYCLE ZX345CV
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();
        testSteps.checkMotorcycleTestDetails("ZX345CV", "P0123010956789");
        testSteps.checkCountryOfRegistrationOptionIsDisplayed();
        testSteps.checkCountryOfRegistrationFieldIsUpdatedFor("Great Britain and Northern Ireland","ZX345CV");
        testSteps.checkEUVehicleCategoryOptionIsDisplayed();
        testSteps.checkOdometerOptionIsDisplayed();
        testSteps.checkEUVehicleCategoryOptionIs("L1e-A");

        testSteps.selectEuVehicleCategory();
        euVehicleCategorySteps.checkTitleIsDisplayed();
        euVehicleCategorySteps.checkOptionsForMotorcycleAreDisplayed();
    }

    @Title("CVSB-11032 - AC6 - EU vehicle category options - Car")
    @Test
    public void testEUVehicleCategoryOptionsForCar() {

        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("911250"); // CAR QW123RT
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();
        testSteps.checkCarTestDetails("QW123RT", "P0123010911250");
        testSteps.checkCountryOfRegistrationOptionIsDisplayed();
        testSteps.checkCountryOfRegistrationFieldIsUpdatedFor("Great Britain and Northern Ireland","QW123RT");
        testSteps.checkEUVehicleCategoryOptionIsDisplayed();
        testSteps.checkOdometerOptionIsDisplayed();
        testSteps.checkEUVehicleCategoryOptionIs("M1");

        testSteps.selectEuVehicleCategory();
        euVehicleCategorySteps.checkTitleIsDisplayed();
        euVehicleCategorySteps.checkOptionsForCarAreDisplayed();
    }

    @Title("CVSB-11032 - AC7 - EU vehicle category options - LGV")
    @Test
    public void testEUVehicleCategoryOptionsForLGV() {

        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("951264"); // LGV AS23 4TY
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();
        testSteps.checkLGVTestDetails("AS234TY", "P0123010951264");
        testSteps.checkCountryOfRegistrationOptionIsDisplayed();
        testSteps.checkCountryOfRegistrationFieldIsUpdatedFor("Great Britain and Northern Ireland","AS234TY");
        testSteps.checkEUVehicleCategoryOptionIsDisplayed();
        testSteps.checkOdometerOptionIsDisplayed();
        testSteps.checkEUVehicleCategoryOptionIs("N1");

        testSteps.selectEuVehicleCategory();
        euVehicleCategorySteps.checkTitleIsDisplayed();
        euVehicleCategorySteps.checkOptionsForLGVAreDisplayed();
    }

    @Title("CVSB-11032 - AC9 - EU vehicle category options - HGV")
    @Test
    public void testEUVehicleCategoryOptionsForHGV() {

        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("230123"); // HGV CT70 VRL
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();
        testSteps.checkHgvTestDetails("CT70VRL", "P012301230123");
        testSteps.checkCountryOfRegistrationOptionIsDisplayed();
        testSteps.checkCountryOfRegistrationFieldIsUpdatedFor("Great Britain and Northern Ireland","CT70VRL");
        testSteps.checkEUVehicleCategoryOptionIsDisplayed();
        testSteps.checkOdometerOptionIsDisplayed();
        testSteps.checkEUVehicleCategoryOptionIs("N2");

        testSteps.selectEuVehicleCategory();
        euVehicleCategorySteps.checkTitleIsDisplayed();
        euVehicleCategorySteps.checkOptionsForHGVAreDisplayed();
    }
}
