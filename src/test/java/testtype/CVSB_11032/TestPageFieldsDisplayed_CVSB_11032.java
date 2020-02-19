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

        // AC4 - Pre-populated EU vehicle category.  NOTE: Can't "edit" this as only one option for LGV.
        testSteps.checkEUVehicleCategoryOptionIs("N1");
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
        testSteps.waitUntilPageIsLoaded();
        testSteps.scrollUp();
        testSteps.checkErrorMessageMandatoryFieldsNotDisplayed();
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
        testSteps.selectTestType("Specialist test", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.checkTestTypeDetailsTitleIsDisplayed();
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
        testSteps.selectTestType("Specialist test", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.checkTestTypeDetailsTitleIsDisplayed();
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

}
