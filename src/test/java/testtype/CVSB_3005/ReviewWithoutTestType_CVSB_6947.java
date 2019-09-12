package testtype.CVSB_3005;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import pages.OdometerReadingPage;
import pages.TestPage;
import steps.*;
import util.BaseTestClass;

@RunWith(SerenityRunner.class)
public class ReviewWithoutTestType_CVSB_6947 extends BaseTestClass {

    @Steps
    TestSteps testSteps;

    @Steps
    LaunchSteps launchSteps;

    @Steps
    SearchForAnATFSteps searchForAnATFSteps;

    @Steps
    ATFDetailsSteps atfDetailsSteps;

    @Steps
    SiteVisitSteps siteVisitSteps;

    @Steps
    IdentifyVehicleSteps identifyVehicleSteps;

    @Steps
    VehicleDetailsSteps vehicleDetailsSteps;

    @Steps
    PreparerSteps preparerSteps;

    @Steps
    TestTypeCategorySteps testTypeCategorySteps;

    @Steps
    EUVehicleCategorySteps euVehicleCategorySteps;

    @Steps
    OdometerReadingSteps odometerReadingSteps;

    @Steps
    TestTypeDetailsSteps testTypeDetailsSteps;

    @Title("CVSB-6947-6948 - AC1 - User taps Review without adding a test type, regardless of whether vehicle category and odometer reading fields are filled in")
    @Test
    @Ignore
    // This is being ignored for the moment, as the test is written for a change which hasn't been merged in yet.
    // TODO
    public void testReviewShowsErrorWithNoTestTypeSpecified() {
        // Set up the test data.
        launchSteps.clickGetStarted();
        searchForAnATFSteps.waitForPageToLoadAndSelectAnAtf("Abshire-Kub 09-4129632");
        atfDetailsSteps.startVisit();
        siteVisitSteps.createNewTest();
        identifyVehicleSteps.searchForVehicle("BQ91YHQ");
        vehicleDetailsSteps.selectConfirmButtonTopRight();
        vehicleDetailsSteps.selectConfirmFromPopUp();
        preparerSteps.startTest();
        preparerSteps.advanceWithoutPreaprer();
        preparerSteps.confirmInPopUp();
        testSteps.checkPageTitleDisplayed();
        testSteps.clickReview();

        // AC1 - User taps Review without adding a test type, regardless of whether vehicle category and odometer reading fields are filled in
        // Verify correct error is shown.
        testSteps.checkErrorMessageNoTestTypeAdded();
        testSteps.checkErrorMessageAddATestTypeBeforeReviewing();

        // AC2 - User taps OK on the No test type alert
        // Close the dialog using the <OK> button
        testSteps.clickOkButton();
        testSteps.checkPageTitleDisplayed();
    }

    @Title("CVSB-6949 AC3 - User taps Review and there is at least one mandatory field that has not been completed for the test")
    @Test
    @Ignore
    // TODO
    // This is temporarily disabled until the correct updated functionality has been merge in to the app.
    public void testReviewShowsErrorForMissingMandatoryFields() {
        // Set up the test data.
        launchSteps.clickGetStarted();
        searchForAnATFSteps.waitForPageToLoadAndSelectAnAtf("Abshire-Kub 09-4129632");
        atfDetailsSteps.startVisit();
        siteVisitSteps.createNewTest();
        identifyVehicleSteps.searchForVehicle("BQ91YHQ");
        vehicleDetailsSteps.selectConfirmButtonTopRight();
        vehicleDetailsSteps.selectConfirmFromPopUp();
        preparerSteps.startTest();
        preparerSteps.advanceWithoutPreaprer();
        preparerSteps.confirmInPopUp();
        testSteps.checkPageTitleDisplayed();

        // Add a test type.
        testSteps.addTestType();
        testTypeCategorySteps.selectFromTestTypeList("Annual test");

        // AC3 - User taps Review and there is at least one mandatory field that has not been completed for the test
        testSteps.checkTestTypeStatus("Annual test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testSteps.clickReview();

        // Verify that the page remains, and that the correct error message is shown.
        testSteps.checkErrorMessageMandatoryFieldsDisplayed();
        testSteps.checkPageTitleDisplayed();
    }

    @Title("CVSB-6951 AC5 - User selects EU vehicle category")
    @Test
    public void testUserSelectsEUVehicleCategory() {
        // Set up the test data.
        launchSteps.clickGetStarted();
        searchForAnATFSteps.waitForPageToLoadAndSelectAnAtf("Abshire-Kub 09-4129632");
        atfDetailsSteps.startVisit();
        siteVisitSteps.createNewTest();
        identifyVehicleSteps.searchForVehicle("BQ91YHQ");
        vehicleDetailsSteps.selectConfirmButtonTopRight();
        vehicleDetailsSteps.selectConfirmFromPopUp();
        preparerSteps.startTest();
        preparerSteps.advanceWithoutPreaprer();
        preparerSteps.confirmInPopUp();
        testSteps.checkPageTitleDisplayed();

        testSteps.addTestType();
        testTypeCategorySteps.selectFromTestTypeList("Annual test");
        testSteps.checkTestTypeStatus("Annual test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testSteps.clickReview();
        testSteps.checkErrorMessageMandatoryFieldsDisplayed();

        // AC5 - User selects EU vehicle category
        testSteps.checkNoEUCategoryIsSelected();
        testSteps.selectVehicleCategoryOption();

        // Select the M1 category and save.
        euVehicleCategorySteps.selectVehicleCategory("M1");
        euVehicleCategorySteps.clickSaveOptionButton();

        // Verify that the selected option is now shown, and that the checkbox is displayed next to it.
        testSteps.checkEUVehicleCategoryOptionIs("M1");
        testSteps.checkEUVehicleCategoryOptionIsSelected("M1");
    }

    @Title("CVSB-6952 AC6 - Field error bar on user input fields")
    @Test
    public void testUserSelectsOdometerReading() {
        // Set up the test data.
        launchSteps.clickGetStarted();
        searchForAnATFSteps.waitForPageToLoadAndSelectAnAtf("Abshire-Kub 09-4129632");
        atfDetailsSteps.startVisit();
        siteVisitSteps.createNewTest();
        identifyVehicleSteps.searchForVehicle("BQ91YHQ");
        vehicleDetailsSteps.selectConfirmButtonTopRight();
        vehicleDetailsSteps.selectConfirmFromPopUp();
        preparerSteps.startTest();
        preparerSteps.advanceWithoutPreaprer();
        preparerSteps.confirmInPopUp();
        testSteps.checkPageTitleDisplayed();

        testSteps.addTestType();
        testTypeCategorySteps.selectFromTestTypeList("Annual test");
        testSteps.checkTestTypeStatus("Annual test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testSteps.clickReview();
        testSteps.checkErrorMessageMandatoryFieldsDisplayed();

        // AC6 - Field error bar on user input fields
        String mileage = "12345";
        testSteps.selectOdometerReading();
        odometerReadingSteps.typeInField(mileage);
        odometerReadingSteps.pressEditUnit();
        odometerReadingSteps.selectUnitOption(OdometerReadingPage.UnitOptions.MILES);
        odometerReadingSteps.pressSave();

        // Verify that the selected option is now shown, and that the checkbox is displayed next to it.
        testSteps.checkOdometerReadingValue(mileage);
        testSteps.checkOdometerReadingButton(TestPage.OdometerUnitIndicatives.MI);
        testSteps.checkOdometerReadingIsSelected(TestPage.OdometerUnitIndicatives.MI);
    }

    @Title("CVSB-6954 AC8 - Errors on the Test screen corrected")
    @Test
    public void testErrorsOnTheTestScreenCorrected() {
        // Set up the test data.
        launchSteps.clickGetStarted();
        searchForAnATFSteps.waitForPageToLoadAndSelectAnAtf("Abshire-Kub 09-4129632");
        atfDetailsSteps.startVisit();
        siteVisitSteps.createNewTest();
        identifyVehicleSteps.searchForVehicle("BQ91YHQ");
        vehicleDetailsSteps.selectConfirmButtonTopRight();
        vehicleDetailsSteps.selectConfirmFromPopUp();
        preparerSteps.startTest();
        preparerSteps.advanceWithoutPreaprer();
        preparerSteps.confirmInPopUp();
        testSteps.checkPageTitleDisplayed();

        testSteps.addTestType();
        testTypeCategorySteps.selectFromTestTypeList("Annual test");
        testSteps.checkTestTypeStatus("Annual test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testSteps.clickReview();

        // Verify that the error message is present on the screen.
        testSteps.checkErrorMessageMandatoryFieldsDisplayed();

        // AC5 - User selects EU vehicle category and provides category info.
        testSteps.checkNoEUCategoryIsSelected();
        testSteps.selectVehicleCategoryOption();
        euVehicleCategorySteps.selectVehicleCategory("M1");
        euVehicleCategorySteps.clickSaveOptionButton();

        // AC6 - Provide an odometer reading.
        String mileage = "12345";
        testSteps.selectOdometerReading();
        odometerReadingSteps.typeInField(mileage);
        odometerReadingSteps.pressEditUnit();
        odometerReadingSteps.selectUnitOption(OdometerReadingPage.UnitOptions.MILES);
        odometerReadingSteps.pressSave();

        // Complete the Annual Test that is in progress.
        testSteps.selectTestType("Annual test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.pressSave();
        testSteps.checkTestTypeStatus("Annual test", TestPage.TestTypeStatuses.EDIT);

        // AC8 - Errors on the Test screen corrected
        testSteps.checkErrorMessageMandatoryFieldsNotDisplayed();
    }
}
