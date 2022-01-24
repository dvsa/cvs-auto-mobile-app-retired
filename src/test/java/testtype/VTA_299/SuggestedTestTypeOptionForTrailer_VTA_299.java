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
public class SuggestedTestTypeOptionForTrailer_VTA_299 extends BaseTestClass {

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
    ConfirmationPageSteps confirmationPageSteps;

    @Steps
    TestReviewPage testReviewPage;

    @Steps
    TrailerDetailsSteps trailerDetailsSteps;

    @Steps
    EUVehicleCategorySteps euVehicleCategorySteps;

    @Title("VTA-299 - AC1 - Trailer - Annual Test Failed in the last 20 calendar days")
    @Test
    public void SuggestedTestTypePopUpTrailerAnnualTest() {
        //Put in 1st TRL Failed Annual test
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("765432", super.username);
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();
        testSteps.selectVehicleCategoryOption();
        euVehicleCategorySteps.selectO2Option();
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

        //Start 2nd TRL Annual test
        siteVisitSteps.createNewTest();
        identifyVehicleSteps.searchForVehicle("765432");
        trailerDetailsSteps.selectConfirmButtonTopRight();
        trailerDetailsSteps.selectConfirmFromPopUp();
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();
        testSteps.selectVehicleCategoryOption();
        euVehicleCategorySteps.selectO2Option();
        testSteps.addTestType();

        //New method created to check the popup is having the suggested test types in it
        testTypeCategorySteps.checkSuggestedTestTypeList("Paid annual retest", "Part paid annual retest", "Annual test");

        //New method created to check the order of the suggested test types on the popup
        testTypeCategorySteps.checkSuggestedTestTypeOrder("Paid annual retest", "Part paid annual retest", "Annual test");

        //AC2 - Check TRL Paid annual retest on suggested test type popup
        testTypeCategorySteps.selectFromSelectedTestTypeList("Paid annual retest");
        testSteps.selectTestType("Retest", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.pressTestTypeRemoveButton();
        testTypeDetailsSteps.pressRemoveTestTypeInPopUp();
        testSteps.addTestType();

        //AC3 Check TRL Part paid annual retest on suggested test type popup
        testTypeCategorySteps.selectFromSelectedTestTypeList("Part paid annual retest");
        testSteps.selectTestType("Retest", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.pressTestTypeRemoveButton();
        testTypeDetailsSteps.pressRemoveTestTypeInPopUp();
        testSteps.addTestType();

        //AC4 Check TRL annual test on suggested test type popup
        testTypeCategorySteps.selectFromSelectedTestTypeList("Annual test");
        testSteps.selectTestType("Annual test", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.pressTestTypeRemoveButton();
        testTypeDetailsSteps.pressRemoveTestTypeInPopUp();

    }

    @Title("VTA-299 - AC5 - Trailer - First Test Failed in the last 20 calendar days")
    @Test
    public void SuggestedTestTypePopUpTrailerFirstTest() {
        //Put in 1st TRL Failed First test
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("765432", super.username);
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();
        testSteps.selectVehicleCategoryOption();
        euVehicleCategorySteps.selectO3Option();
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

        //Start 2nd TRL First Test
        siteVisitSteps.createNewTest();
        identifyVehicleSteps.searchForVehicle("765432");
        trailerDetailsSteps.selectConfirmButtonTopRight();
        trailerDetailsSteps.selectConfirmFromPopUp();
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();
        testSteps.selectVehicleCategoryOption();
        euVehicleCategorySteps.selectO3Option();
        testSteps.addTestType();

        //New method created to check the popup is having the suggested test types in it
        testTypeCategorySteps.checkSuggestedTestTypeList("Paid first test retest", "Part paid first test retest", "First test");

        //New method created to check the order of the suggested test types on the popup
        testTypeCategorySteps.checkSuggestedTestTypeOrder("Paid first test retest", "Part paid first test retest", "First test");

        //AC5 - Check TRL First test on suggested test type popup
        testTypeCategorySteps.selectFromSelectedTestTypeList("First test");
        testSteps.selectTestType("First test", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.pressTestTypeRemoveButton();
        testTypeDetailsSteps.pressRemoveTestTypeInPopUp();
        testSteps.addTestType();

        //AC6 Check TRL Paid first test retest on suggested test type popup
        testTypeCategorySteps.selectFromSelectedTestTypeList("Paid first test retest");
        testSteps.selectTestType("Retest", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.pressTestTypeRemoveButton();
        testTypeDetailsSteps.pressRemoveTestTypeInPopUp();
        testSteps.addTestType();

        //AC7 Check TRL Part paid first test retest on suggested test type popup
        testTypeCategorySteps.selectFromSelectedTestTypeList("Part paid first test retest");
        testSteps.selectTestType("Retest", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.pressTestTypeRemoveButton();
        testTypeDetailsSteps.pressRemoveTestTypeInPopUp();
        testSteps.addTestType();
    }
}