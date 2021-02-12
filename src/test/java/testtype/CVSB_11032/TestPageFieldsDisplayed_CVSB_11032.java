package testtype.CVSB_11032;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.core.annotations.WithTag;
import org.junit.Test;
import org.junit.runner.RunWith;
import pages.TestPage;
import steps.*;
import steps.composed.TestTypeCategoryComp;
import steps.util.UtilSteps;
import utils.BaseTestClass;

@RunWith(SerenityRunner.class)
public class TestPageFieldsDisplayed_CVSB_11032 extends BaseTestClass {

    @Steps
    UtilSteps utilSteps;

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
    TestTypeSubcategorySteps testTypeSubcategorySteps;


    @Title("CVSB-11032 - AC1 - Fields displayed on test screen - LGV")
    @Test
    public void testFieldsDisplayedForLGV() {
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("951264",super.username); // LGV AS23 4TY
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();
        testSteps.checkLgvTestDetails("AS234TY", "P0123010951264");
        testSteps.checkCountryOfRegistrationOptionIsDisplayed();
        testSteps.checkCountryOfRegistrationFieldIsUpdatedFor("Great Britain and Northern Ireland","AS234TY");
        testSteps.checkEUVehicleCategoryOptionIsDisplayed();
        testSteps.checkOdometerOptionIsDisplayed();

        // AC10 - "Not Applicable" added to list of options.
        testSteps.clickCountryOfRegistrationOption();
        countryOfRegistrationSteps.selectNotApplicableOption();
        testSteps.checkCountryOfRegistrationFieldIsUpdatedFor("Not applicable", "AS234TY");

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
        testTypeCategorySteps.waitUntilPageIsLoaded();
        testTypeCategorySteps.selectFromTestTypeList("Specialist test");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("Specialist test");
        testTypeCategorySteps.selectFromTestTypeList("IVA");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("IVA");
        testTypeCategorySteps.selectFromTestTypeList("Mutual recognition/ end of series & inspection");
        testSteps.selectTestType("Specialist test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.checkTestTypeDetailsTitleIsDisplayed();
        testTypeDetailsSteps.setTestToOption("Pass");
        testTypeDetailsSteps.sendCertificateNumber("123456");
        testTypeDetailsSteps.pressSave();
        testSteps.checkPageTitleDisplayed();

        // Add a trailer to the test.
        testSteps.clickAddATrailerButton();
        identifyTrailerSteps.searchForTrailer("T12341234");
        trailerDetailsSteps.selectConfirmButtonTopRight();
        trailerDetailsSteps.selectConfirmFromPopUp();
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();
        testSteps.checkTrailerTestDetails("C000001", "T12341234");
        testSteps.scrollDown();
        testSteps.addTestType();
        testTypeCategorySteps.waitUntilPageIsLoaded();
        testTypeCategorySteps.selectFromTestTypeList("Specialist test");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("Specialist test");
        testTypeCategorySteps.selectFromTestTypeList("IVA");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("IVA");
        testTypeCategorySteps.selectFromTestTypeList("Normal inspection");

        testSteps.scrollUp();
        testSteps.clickReviewAndSubmit();
        testSteps.checkErrorMessageMandatoryFieldsDisplayed();

        // Set the trailer's test to passed as well.
        testSteps.scrollDown();
        testSteps.selectTestType("Specialist test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.checkTestTypeDetailsTitleIsDisplayed();
        testTypeDetailsSteps.setTestToOption("Pass");
        testTypeDetailsSteps.sendCertificateNumber("234567");
        testTypeDetailsSteps.pressSave();
        testSteps.checkPageTitleDisplayed();

        // Verify that EU Vehicle Category is mandatory.
        testSteps.scrollDown();
        testSteps.clickUnsetEuVehicleCategory();
        euVehicleCategorySteps.selectO1Option();
        testSteps.clickReviewAndSubmit();
        testSteps.scrollUp();
        testSteps.checkErrorMessageMandatoryFieldsDisplayed();

        // Verify that Odometer Reading is mandatory.
        testSteps.scrollUp();
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
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("911250",super.username); // CAR QW123RT
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
        testTypeCategorySteps.waitUntilPageIsLoaded();
        testTypeCategorySteps.selectFromTestTypeList("Specialist test");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("Specialist test");
        testTypeCategorySteps.selectFromTestTypeList("IVA");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("IVA");
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

    @WithTag("In_Test")
    @Title("CVSB-11032 - AC3 - Fields displayed on test screen - Motorcycle")
    @Test
    public void testFieldsDisplayedForMotorcycle() {
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("956789",super.username); // MOTORCYCLE ZX345CV
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
        testTypeCategorySteps.waitUntilPageIsLoaded();
        testTypeCategorySteps.selectFromTestTypeList("Specialist test");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("Specialist test");
        testTypeCategorySteps.selectFromTestTypeList("IVA");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("IVA");
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
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("956789",super.username); // MOTORCYCLE ZX345CV
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

    @WithTag("In_test")
    @Title("CVSB-11032 - AC6 - EU vehicle category options - Car")
    @Test
    public void testEUVehicleCategoryOptionsForCar() {
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("911250",super.username); // CAR QW123RT
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
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("951264",super.username); // LGV AS23 4TY
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();
        testSteps.checkLgvTestDetails("AS234TY", "P0123010951264");
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
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("230123",super.username); // HGV CT70 VRL
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();
        testSteps.checkHgvTestDetails("CT70VRL", "P012301230123");
        testSteps.checkCountryOfRegistrationOptionIsDisplayed();
        testSteps.checkCountryOfRegistrationFieldIsUpdatedFor("Great Britain and Northern Ireland","CT70VRL");
        testSteps.checkEUVehicleCategoryOptionIsDisplayed();
        testSteps.checkOdometerOptionIsDisplayed();
        testSteps.selectEuVehicleCategory();
        euVehicleCategorySteps.checkTitleIsDisplayed();
        euVehicleCategorySteps.checkOptionsForHGVAreDisplayed();
    }
}
