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
public class SuggestedTestTypeOptionForTrailer_CVSB_11706 extends BaseTestClass {

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
    TestTypeSubcategorySteps testTypeSubcategorySteps;

    @Steps
    TrailerDetailsSteps trailerDetailsSteps;

    @Title("CVSB-11706 - AC1 - Trailer - Annual Test Failed in the last 20 calendar days")
    @Test
    public void SuggestedTestTypePopUpTrailerAnnualTest() {
        //AC1 - Trailer Annual Test
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("765432", super.username);
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();
        testSteps.addTestType();
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

        //HGV AC2 - Trailer Paid Retest
        siteVisitSteps.createNewTest();
        identifyVehicleSteps.searchForVehicle("765432");
        trailerDetailsSteps.selectConfirmButtonTopRight();
        trailerDetailsSteps.selectConfirmFromPopUp();
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();
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

    @Title("CVSB-11706 - AC5 - Trailer - First Test Failed in the last 20 calendar days")
    @Test
    public void SuggestedTestTypePopUpTrailerFirstTest() {
        //AC5 First Test
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("765432", super.username);
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();
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

        //AC6 First Test Retest
        siteVisitSteps.createNewTest();
        identifyVehicleSteps.searchForVehicle("765432");
        trailerDetailsSteps.selectConfirmButtonTopRight();
        trailerDetailsSteps.selectConfirmFromPopUp();
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();
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

        //AC8 Free Loaded Retest
        testTypeCategorySteps.waitUntilPageIsLoaded();
        testTypeCategorySteps.selectFromTestTypeList("Retest");
        testTypeSubcategorySteps.selectFromTestTypeList("Annual test retest");
        testTypeSubcategorySteps.selectFromTestTypeList("Free loaded retest");
        testSteps.selectTestType("Retest", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.pressTestTypeRemoveButton();
        testTypeDetailsSteps.pressRemoveTestTypeInPopUp();
        testSteps.addTestType();

        //AC9 Free First Test Retest
        testTypeCategorySteps.waitUntilPageIsLoaded();
        testTypeCategorySteps.selectFromTestTypeList("Retest");
        testTypeSubcategorySteps.selectFromTestTypeList("First test retest");
        testTypeSubcategorySteps.selectFromTestTypeList("Free retest");
        testSteps.selectTestType("Retest", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.pressTestTypeRemoveButton();
        testTypeDetailsSteps.pressRemoveTestTypeInPopUp();
        testSteps.addTestType();
    }
}
