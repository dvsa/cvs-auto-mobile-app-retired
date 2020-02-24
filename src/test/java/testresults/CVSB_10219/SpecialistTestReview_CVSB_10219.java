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

    @Title("CVSB-10219 - AC4 - Test history - two certificate numbers (Annual + COIF), CVSB-10219 - AC5 - Annual test expiry date")
    @Test
    public void testSpecialistTest_TwoCertificateNumbers_COIF() {

        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("678410"); // PSV BQ91 YHQ
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();
        testSteps.checkTestDetails("BQ91YHQ", "1B7GG36N12S678410");

        // Add a test type (Specialist Test -> COIF -> With annual test).
        testSteps.addTestType();
        testTypeCategorySteps.selectFromTestTypeList("Specialist test");
        testTypeCategorySteps.selectFromTestTypeList("COIF");
        testTypeCategorySteps.selectFromTestTypeList("With annual test");
        testSteps.selectTestType("Specialist test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.checkTestTypeDetailsTitleIsDisplayed();
        testTypeDetailsSteps.setTestToOption("Pass");
        testTypeDetailsSteps.sendCertificateNumber("123456");
        testTypeDetailsSteps.pressSave();
        testSteps.checkPageTitleDisplayed();
        testSteps.selectOdometerReading();
        odometerReadingSteps.typeInField("11111");
        odometerReadingSteps.pressSave();
        testSteps.waitUntilPageIsLoaded();
        testSteps.selectEuVehicleCategory();
        euVehicleCategorySteps.checkTitleIsDisplayed();
        euVehicleCategorySteps.selectOption("M2");
        testSteps.clickReviewAndSubmit();
        testReviewSteps.checkPageTitleIsDisplayed();
        testReviewSteps.scrollDown();
        testReviewSteps.pressSubmit();
        testReviewSteps.pressSubmitInPopUp();
        confirmationPage.waitUntilPageIsLoaded();
        confirmationPage.clickDoneButton();
        siteVisit.waitUntilPageIsLoaded();

        // Add another test (Specialist Test -> COIF -> With annual test retest).
        siteVisit.createNewTest();
        identifyVehicleSteps.searchForVehicle("BQ91YHQ");
        vehicleDetailsSteps.selectConfirmButtonTopRight();
        vehicleDetailsSteps.selectConfirmFromPopUp();
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();
        testSteps.checkPageTitleDisplayed();
        testSteps.selectEuVehicleCategory();
        euVehicleCategorySteps.checkTitleIsDisplayed();
        euVehicleCategorySteps.selectOption("M2");
        testSteps.selectOdometerReading();
        odometerReadingSteps.typeInField("22222");
        odometerReadingSteps.pressSave();
        testSteps.addTestType();
        testTypeCategorySteps.selectFromTestTypeList("Specialist test");
        testTypeCategorySteps.selectFromTestTypeList("Retest");
        testTypeCategorySteps.selectFromTestTypeList("COIF");
        testTypeCategorySteps.selectFromTestTypeList("With annual test");
        testSteps.selectTestType("Specialist test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.checkTestTypeDetailsTitleIsDisplayed();
        testTypeDetailsSteps.setTestToOption("Pass");
        testTypeDetailsSteps.sendCertificateNumber("234567");
        testTypeDetailsSteps.pressSave();
        testSteps.checkPageTitleDisplayed();
        testSteps.clickReviewAndSubmit();
        testReviewSteps.checkPageTitleIsDisplayed();
        testReviewSteps.scrollDown();
        testReviewSteps.pressSubmit();
        testReviewSteps.pressSubmitInPopUp();
        confirmationPage.waitUntilPageIsLoaded();
        confirmationPage.clickDoneButton();
        siteVisit.waitUntilPageIsLoaded();

        // Now go and verify the certificate numbers.  Manually-set and auto-generated values should be shown for each test.
        siteVisit.createNewTest();
        identifyVehicleSteps.searchForVehicle("BQ91YHQ");
        vehicleDetailsSteps.selectVehicleTestHistory();

        testHistorySteps.selectTestAtPosition("Specialist test", 1); // Pos 1 = previous test.
        testHistoryDetailsSteps.checkPageTitle();
        testHistoryDetailsSteps.checkElementValue("TEST TYPE", "COIF With Annual Test");
        testHistoryDetailsSteps.checkElementValue("Certificate number (COIF)", "123456");
        testHistoryDetailsSteps.checkAutoCertificateNumberIsShown("(Annual test)");
        testHistoryDetailsSteps.pressBackButton();

        testHistorySteps.selectTestAtPosition("Specialist test", 0); // Pos 0 = current / most recent test.
        testHistoryDetailsSteps.checkPageTitle();
        testHistoryDetailsSteps.checkElementValue("TEST TYPE", "COIF Retest With Annual Test");
        testHistoryDetailsSteps.checkElementValue("Certificate number (COIF)", "234567");
        testHistoryDetailsSteps.checkAutoCertificateNumberIsShown("(Annual test)");
        testHistoryDetailsSteps.pressBackButton();

        // AC5 - Annual test expiry date
        testHistorySteps.selectTestAtPosition("Specialist test", 0); // Pos 0 = current / most recent test.
        testHistoryDetailsSteps.checkPageTitle();
        testHistoryDetailsSteps.checkExpiryDateIsCorrect();
    }
}