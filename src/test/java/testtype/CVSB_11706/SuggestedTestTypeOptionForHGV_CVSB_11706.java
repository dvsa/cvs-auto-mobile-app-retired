package testtype.CVSB_11706;

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
public class SuggestedTestTypeOptionForHGV_CVSB_11706 extends BaseTestClass {

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

    @Title("CVSB-11706 - AC1 - HGV - Annual Test Failed in the last 20 calendar days")
    @Test
    public void SuggestedTestTypePopUpHGVAnnualTest() {
        //AC1 - HGV Annual Test
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("230123", super.username);
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();
        testSteps.selectOdometerReading();
        odometerReadingSteps.typeInField("123");
        odometerReadingSteps.pressSave();
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

        //HGV AC2 - HGV Paid Retest, part paid retest and annual test
        siteVisitSteps.createNewTest();
        identifyVehicleSteps.searchForVehicle("230123");
        vehicleDetailsSteps.selectConfirmButtonTopRight();
        vehicleDetailsSteps.selectConfirmFromPopUp();
        preparerSteps.selectAndConfirmPreparerId(preparerService.getPreparerByIndex(0).getPreparerId());
        testSteps.selectOdometerReading();
        odometerReadingSteps.typeInField("123");
        odometerReadingSteps.pressSave();
        testSteps.addTestType();

        //New method created to check the popup is having the suggested test types in it
        testTypeCategorySteps.checkSuggestedTestTypeList("Paid annual test retest", "Part paid annual test retest", "Annual test");

        //AC2 Checking that picking the relevant option on suggested test type pop up takes you to inner page
        testTypeCategorySteps.selectFromSelectedTestTypeList("Paid annual test retest");
        testSteps.selectTestType("Retest", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.pressTestTypeRemoveButton();
        testTypeDetailsSteps.pressRemoveTestTypeInPopUp();
        testSteps.addTestType();

        //AC3 Checking that picking the relevant option on suggested test type pop up takes you to inner page
        testTypeCategorySteps.selectFromSelectedTestTypeList("Part paid annual test retest");
        testSteps.selectTestType("Retest", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.pressTestTypeRemoveButton();
        testTypeDetailsSteps.pressRemoveTestTypeInPopUp();
        testSteps.addTestType();

        //AC4 Checking that picking the relevant option on suggested test type pop up takes you to inner page
        testTypeCategorySteps.selectFromSelectedTestTypeList("Annual test");
        testSteps.selectTestType("Annual test", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.pressTestTypeRemoveButton();
        testTypeDetailsSteps.pressRemoveTestTypeInPopUp();
    }

    @Title("CVSB-11706 - AC5 - HGV - First Test Failed in the last 20 calendar days")
    @Test
    public void SuggestedTestTypePopUpHGVFirstTest() {
        //AC5 First Test
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("230123", super.username);
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();
        testSteps.selectOdometerReading();
        odometerReadingSteps.typeInField("123");
        odometerReadingSteps.pressSave();
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

        //Creating 2nd test to check annual test
        siteVisitSteps.createNewTest();
        identifyVehicleSteps.searchForVehicle("230123");
        vehicleDetailsSteps.selectConfirmButtonTopRight();
        vehicleDetailsSteps.selectConfirmFromPopUp();
        preparerSteps.selectAndConfirmPreparerId(preparerService.getPreparerByIndex(0).getPreparerId());
        testSteps.selectOdometerReading();
        odometerReadingSteps.typeInField("123");
        odometerReadingSteps.pressSave();
        testSteps.addTestType();
        testTypeCategorySteps.selectFromSelectedTestTypeList("First test");
        testSteps.clickReviewAndSubmit();
        testReviewPage.scrollPageDown();
        testReviewPage.clickSubmitButton();
        testReviewPage.clickSubmitInPopUp();
        confirmationPageSteps.pressDone();


        //AC6 First Test Retest
        siteVisitSteps.createNewTest();
        identifyVehicleSteps.searchForVehicle("230123");
        vehicleDetailsSteps.selectConfirmButtonTopRight();
        vehicleDetailsSteps.selectConfirmFromPopUp();
        preparerSteps.selectAndConfirmPreparerId(preparerService.getPreparerByIndex(0).getPreparerId());
        testSteps.selectOdometerReading();
        odometerReadingSteps.typeInField("123");
        odometerReadingSteps.pressSave();
        testSteps.addTestType();
        testTypeCategorySteps.selectFromSelectedTestTypeList("Paid first test retest");
        testSteps.selectTestType("Retest", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.pressTestTypeRemoveButton();
        testTypeDetailsSteps.pressRemoveTestTypeInPopUp();
        testSteps.addTestType();

        //AC7 Part Paid First Test Retest
        testTypeCategorySteps.selectFromSelectedTestTypeList("Part paid first test retest");
        testSteps.selectTestType("Retest", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.pressTestTypeRemoveButton();
        testTypeDetailsSteps.pressRemoveTestTypeInPopUp();
        testSteps.addTestType();

        //AC13 Add A different Test Type
        testTypeCategorySteps.selectFromSelectedTestTypeList("Select a different test type");
        testTypeCategorySteps.selectFromTestTypeList("Technical test");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("Technical test");
        testTypeCategorySteps.selectFromTestTypeList("ADR");
        testSteps.selectTestType("Technical test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.pressTestTypeRemoveButton();
        testTypeDetailsSteps.pressRemoveTestTypeInPopUp();
    }
}