package testtype.VTA_299;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import pages.*;
import steps.*;
import steps.composed.TestTypeCategoryComp;
import steps.util.UtilSteps;
import utils.BaseTestClass;

@RunWith(SerenityRunner.class)
public class SuggestedTestTypeOptionForHGV_VTA_299 extends BaseTestClass {

    @Steps
    UtilSteps utilSteps;

    @Steps
    SiteVisitSteps siteVisitSteps;

    @Steps
    IdentifyVehicleSteps identifyVehicleSteps;

    @Steps
    TestTypeCategoryComp testTypeCategoryComp;

    @Steps
    PreparerSteps preparerSteps;

    @Steps
    TestSteps testSteps;

    @Steps
    TestTypeCategorySteps testTypeCategorySteps;

    @Steps
    TestTypeDetailsSteps testTypeDetailsSteps;

    @Steps
    DefectDetailsSteps defectDetailsSteps;

    @Steps
    DefectCategorySteps defectCategorySteps;

    @Steps
    DefectItemSteps defectItemSteps;

    @Steps
    DefectDescriptionSteps defectDescriptionSteps;

    @Steps
    OdometerReadingSteps odometerReadingSteps;

    @Steps
    ConfirmationPageSteps confirmationPageSteps;

    @Steps
    TestReviewPage testReviewPage;

    @Steps
    TestTypeSubcategorySteps testTypeSubcategorySteps;

    @Steps
    VehicleDetailsSteps vehicleDetailsSteps;

    @Steps
    EUVehicleCategorySteps euVehicleCategorySteps;

    @Title("VTA-299 - AC1 - HGV - Suggested test type pop up after HGV Annual Test Fail within 20 days")
    @Test
    public void SuggestedTestTypePopUpHGVAnnualTest() {
        //Put in 1st HGV Failed Annual test
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("230123", super.username);
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();
        testSteps.selectOdometerReading();
        odometerReadingSteps.typeInField("123");
        odometerReadingSteps.pressSave();
        testSteps.selectVehicleCategoryOption();
        euVehicleCategorySteps.selectOption("N2");
        testSteps.addTestType();
        testTypeCategorySteps.waitUntilPageIsLoaded();
        testTypeCategorySteps.selectFromTestTypeList("Annual test");
        testSteps.selectTestType("Annual test", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.selectAddDefect("Annual test");
        defectCategorySteps.selectDefectFromList("8. Condition of Tyres");
        defectItemSteps.selectDefectFromList("1. A tyre");
        defectDescriptionSteps.selectDefect("8.1 (c) * DANGEROUS");
        defectDetailsSteps.selectHorizontalLateralAxle("Inner", "Offside", "3");
        testTypeDetailsSteps.pressSave();
        testSteps.clickReviewAndSubmit();
        testReviewPage.scrollPageDown();
        testReviewPage.clickSubmitButton();
        testReviewPage.clickSubmitInPopUp();
        confirmationPageSteps.pressDone();

        //Start 2nd HGV Annual test
        siteVisitSteps.createNewTest();
        identifyVehicleSteps.searchForVehicle("230123");
        vehicleDetailsSteps.selectConfirmButtonTopRight();
        vehicleDetailsSteps.selectConfirmFromPopUp();
        preparerSteps.selectAndConfirmPreparerId(preparerService.getPreparerByIndex(0).getPreparerId());
        testSteps.selectOdometerReading();
        odometerReadingSteps.typeInField("123");
        odometerReadingSteps.pressSave();
        testSteps.selectVehicleCategoryOption();
        euVehicleCategorySteps.selectOption("N2");
        testSteps.addTestType();

        //New method created to check the popup is having the suggested test types in it
        testTypeCategorySteps.checkSuggestedTestTypeList("Paid annual retest", "Part paid annual retest", "Annual test");

        //New method created to check the order of the suggested test types on the popup
        testTypeCategorySteps.checkSuggestedTestTypeOrderStepHGVAndPSV("Paid annual retest", "Part paid annual retest", "Annual test");

        //AC2 - Check HGV Paid annual retest on suggested test type popup
        testTypeCategorySteps.selectFromSelectedTestTypeList("Paid annual retest");
        testSteps.selectTestType("Retest", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.pressTestTypeRemoveButton();
        testTypeDetailsSteps.pressRemoveTestTypeInPopUp();
        testSteps.addTestType();

        //AC3 Check HGV Part paid annual retest on suggested test type popup
        testTypeCategorySteps.selectFromSelectedTestTypeList("Part paid annual retest");
        testSteps.selectTestType("Retest", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.pressTestTypeRemoveButton();
        testTypeDetailsSteps.pressRemoveTestTypeInPopUp();
        testSteps.addTestType();

        //AC4 Check HGV annual test on suggested test type popup
        testTypeCategorySteps.selectFromSelectedTestTypeList("Annual test");
        testSteps.selectTestType("Annual test", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.pressTestTypeRemoveButton();
        testTypeDetailsSteps.pressRemoveTestTypeInPopUp();
    }

    @Title("VTA-299 - AC5 - HGV - Suggested test type pop up after HGV First Test Fail within 20 days")
    @Test
    public void SuggestedTestTypePopUpHGVFirstTest() {
        //Put in 1st HGV Failed First test
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("230123", super.username);
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();
        testSteps.selectOdometerReading();
        odometerReadingSteps.typeInField("123");
        odometerReadingSteps.pressSave();
        testSteps.selectVehicleCategoryOption();
        euVehicleCategorySteps.selectOption("N2");
        testSteps.addTestType();
        testTypeCategorySteps.waitUntilPageIsLoaded();
        testTypeCategorySteps.selectFromTestTypeList("First test");
        testSteps.selectTestType("First test", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.selectAddDefect("First test");
        defectCategorySteps.selectDefectFromList("8. Condition of Tyres");
        defectItemSteps.selectDefectFromList("1. A tyre");
        defectDescriptionSteps.selectDefect("8.1 (c) * DANGEROUS");
        defectDetailsSteps.selectHorizontalLateralAxle("Inner", "Offside", "3");
        testTypeDetailsSteps.pressSave();
        testSteps.clickReviewAndSubmit();
        testReviewPage.scrollPageDown();
        testReviewPage.clickSubmitButton();
        testReviewPage.clickSubmitInPopUp();
        confirmationPageSteps.pressDone();

        //Start 2nd HGV First Test
        siteVisitSteps.createNewTest();
        identifyVehicleSteps.searchForVehicle("230123");
        vehicleDetailsSteps.selectConfirmButtonTopRight();
        vehicleDetailsSteps.selectConfirmFromPopUp();
        preparerSteps.selectAndConfirmPreparerId(preparerService.getPreparerByIndex(0).getPreparerId());
        testSteps.selectOdometerReading();
        odometerReadingSteps.typeInField("123");
        odometerReadingSteps.pressSave();
        testSteps.selectVehicleCategoryOption();
        euVehicleCategorySteps.selectOption("N2");
        testSteps.addTestType();

        //New method created to check the popup is having the suggested test types in it
        testTypeCategorySteps.checkSuggestedTestTypeList("Paid first test retest", "Part paid first test retest", "First test");

        //New method created to check the order of the suggested test types on the popup
        testTypeCategorySteps.checkSuggestedTestTypeOrderStepHGVAndPSV("Paid first test retest", "Part paid first test retest", "First test");

        //AC5 - Check HGV First test on suggested test type popup
        testTypeCategorySteps.selectFromSelectedTestTypeList("First test");
        testSteps.clickReviewAndSubmit();
        testReviewPage.scrollPageDown();
        testReviewPage.clickSubmitButton();
        testReviewPage.clickSubmitInPopUp();
        confirmationPageSteps.pressDone();

        //AC6 Check HGV Paid first test retest on suggested test type popup
        siteVisitSteps.createNewTest();
        identifyVehicleSteps.searchForVehicle("230123");
        vehicleDetailsSteps.selectConfirmButtonTopRight();
        vehicleDetailsSteps.selectConfirmFromPopUp();
        preparerSteps.selectAndConfirmPreparerId(preparerService.getPreparerByIndex(0).getPreparerId());
        testSteps.selectOdometerReading();
        odometerReadingSteps.typeInField("123");
        odometerReadingSteps.pressSave();
        testSteps.selectVehicleCategoryOption();
        euVehicleCategorySteps.selectOption("N2");
        testSteps.addTestType();
        testTypeCategorySteps.selectFromSelectedTestTypeList("Paid first test retest");
        testSteps.selectTestType("Retest", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.pressTestTypeRemoveButton();
        testTypeDetailsSteps.pressRemoveTestTypeInPopUp();
        testSteps.addTestType();

        //AC7 Check HGV Part paid first test retest on suggested test type popup
        testTypeCategorySteps.selectFromSelectedTestTypeList("Part paid first test retest");
        testSteps.selectTestType("Retest", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.pressTestTypeRemoveButton();
        testTypeDetailsSteps.pressRemoveTestTypeInPopUp();
        testSteps.addTestType();

        //AC13 Check Adding a different test type on suggested test type popup
        testTypeCategorySteps.selectFromSelectedTestTypeList("Select a different test type");
        testTypeCategorySteps.selectFromTestTypeList("Technical test");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("Technical test");
        testTypeCategorySteps.selectFromTestTypeList("ADR");
        testSteps.selectTestType("Technical test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.pressTestTypeRemoveButton();
        testTypeDetailsSteps.pressRemoveTestTypeInPopUp();
    }
}