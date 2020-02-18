package testtype.CVSB_11032;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.core.annotations.WithTag;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import pages.TestPage;
import steps.*;
import steps.composed.TestTypeCategoryComp;
import util.BaseTestClass;

@RunWith(SerenityRunner.class)
public class TestPageFieldsDisplayed_CVSB_11032 extends BaseTestClass {

    @Steps
    TestTypeCategoryComp testTypeCategoryComp;

    @Steps
    TestSteps testSteps;

    @Steps
    PreparerSteps preparerSteps;

    @Steps
    HgvDetailsSteps hgvDetailsSteps;

    @Steps
    TestHistorySteps testHistorySteps;

    @Steps
    WeightsSteps weightsSteps;

    @Steps
    TestTypeCategorySteps testTypeCategorySteps;

    @Steps
    TestTypeSubcategorySteps testTypeSubcategorySteps;

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

    @Title("CVSB-11032 - AC1 - Fields displayed on test screen - LGV")
    @WithTag("Smoke_2")
    @Test
    public void testFieldsDisplayedForLGV() {

        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("951264"); // LGV AS23 4TY
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();
        testSteps.checkLGVTestDetails("AS234TY", "P0123010951264");
        testSteps.checkCountryOfRegistrationOptionIsDisplayed();
        testSteps.checkCountryOfRegistrationFieldIsUpdatedFor("Great Britain and Northern Ireland","AS234TY");
        testSteps.checkEUVehicleCategoryOptionIsDisplayed();
        testSteps.checkOdometerOptionIsDisplayed();

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
        testTypeCategorySteps.selectFromTestTypeList("Normal inspection");
        testSteps.selectTestType("Specialist test", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.checkTestTypeDetailsTitleIsDisplayed();
        testTypeDetailsSteps.pressSave();
        testSteps.checkPageTitleDisplayed();

        // Add a trailer to the test.
        testSteps.clickAddATrailerButton();
        identifyTrailerSteps.searchForTrailer("T12111111");
        trailerDetailsSteps.selectConfirmButtonTopRight();
        trailerDetailsSteps.selectConfirmFromPopUp();
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();
        testSteps.checkTrailerTestDetails("C234567", "T12111111");
        testSteps.scrollDown();
        testSteps.addTestType();
        testTypeCategorySteps.selectFromTestTypeList("Specialist test");
        testTypeCategorySteps.selectFromTestTypeList("IVA");
        testTypeCategorySteps.selectFromTestTypeList("Normal inspection");

        testSteps.scrollUp();
        testSteps.clickReviewAndSubmit();
        testSteps.checkErrorMessageMandatoryFieldsDisplayed();

        // Verify that EU Vehicle Category is mandatory.
        testSteps.scrollDown();
        testSteps.clickUnsetEuVehicleCategory();
        euVehicleCategorySteps.selectO1Option();
        testSteps.clickReviewAndSubmit();
        testSteps.scrollUp();
        testSteps.checkErrorMessageMandatoryFieldsDisplayed();

        // Verify that Odometer Reading is mandatory.
        testSteps.selectOdometerReading();
        odometerReadingSteps.typeInField("22222");
        odometerReadingSteps.pressSave();
        testSteps.scrollUp();
        testSteps.checkErrorMessageMandatoryFieldsNotDisplayed();
    }

    @Ignore("CVSB-8749 - maintenance for improving test suite speed")
    @Title("CVSB-6771 - AC1 - Fields displayed on test screen - HGV (test history)")
    @Test
    public void testFieldsDisplayedTestHistoryForHgv() {

        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("230123");
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();
        testSteps.checkHgvTestDetails("CT70VRL", "P012301230123");
        testSteps.selectVehicleDetails();
        hgvDetailsSteps.selectVehicleTestHistory();
        testHistorySteps.checkPage();
        testHistorySteps.checkRegPlate("CT70 VRL");
        testHistorySteps.checkNoTestHistoryIsDisplayed();
        testHistorySteps.pressBackButton();
        hgvDetailsSteps.selectWeights();
        weightsSteps.checkFieldIsListed("AXLE 1");
        weightsSteps.checkFieldIsListed("AXLE 2");
        weightsSteps.checkFieldIsListed("TRAIN");
        weightsSteps.checkFieldIsListed("GROSS");
        weightsSteps.checkContentCategories("AXLE 1", "1400", "1800");
        weightsSteps.checkContentCategories("AXLE 2", "1600", "1900");
        weightsSteps.checkContentCategories("TRAIN", "1500", "2000");
        weightsSteps.checkContentCategories("GROSS", "0", "0");
        weightsSteps.pressBackButton();
    }

    @Title("CVSB-6776 - AC1 - Fields displayed on test screen - HGV (select a test type)")
    @Test
    public void testFieldsDisplayedAddTestsForHgv() {

        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("230123");
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();
        testSteps.checkHgvTestDetails("CT70VRL", "P012301230123");
        testSteps.addTestType();
        testTypeCategorySteps.selectFromTestTypeList("First test");
        testSteps.addLinkedTestType();
        testTypeCategorySteps.selectFromTestTypeList("Prohibition clearance");
        testTypeSubcategorySteps.selectFromTestTypeList("Full inspection/ Fee");
        testTypeSubcategorySteps.selectFromTestTypeList("With certification");
        testSteps.checkTestTypeStatus("First test", TestPage.TestTypeStatuses.EDIT);
        testSteps.checkTestTypeStatus("Prohibition clearance", TestPage.TestTypeStatuses.EDIT);
        testSteps.selectTestType("Prohibition clearance", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.checkTestTypeName("Paid prohibition clearance (full inspection with certification)");
        testTypeDetailsSteps.checkNotesText("Add notes");
        testTypeDetailsSteps.checkAddDefectIsPresent();
        testTypeDetailsSteps.checkTestTypeAbandonButton();
        testTypeDetailsSteps.checkTestTypeRemoveButton();
    }

}
