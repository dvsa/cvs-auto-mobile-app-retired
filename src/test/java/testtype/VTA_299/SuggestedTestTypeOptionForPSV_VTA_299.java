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
public class SuggestedTestTypeOptionForPSV_VTA_299 extends BaseTestClass {

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
    SeatbeltInstallationCheckSteps seatbeltInstallationCheckSteps;

    @Steps
    TestReviewSteps testReviewSteps;

    @Steps
    VehicleDetailsSteps vehicleDetailsSteps;

    @Steps
    EUVehicleCategorySteps euVehicleCategorySteps;

    @Title("VTA-299 - AC1 - PSV - Suggested test type pop up after PSV Annual Test Fail within 20 days")
    @Test
    public void SuggestedTestTypePopUpPSVAnnualTest() {
        //Put in 1st PSV Failed Annual test
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("678410",super.username);
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();
        testSteps.addTestType();
        testTypeCategorySteps.waitUntilPageIsLoaded();
        testTypeCategorySteps.selectFromTestTypeList("Annual test");
        testSteps.selectTestType("Annual test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.waitUntilPageIsLoaded();
        testTypeDetailsSteps.setCarriedOutDuringTest(true);
        testTypeDetailsSteps.selectNumberOfSeatbeltsFitted();
        seatbeltInstallationCheckSteps.inputNumberOfSeatbelts("3");
        testTypeDetailsSteps.scrollTestTypeDetailsPage();
        testTypeDetailsSteps.clickAddDefect();
        defectCategorySteps.waitUntilPageIsLoaded();
        defectCategorySteps.selectDefectFromList("3. Seat Belts & Supplementary Restraint Systems");
        defectItemSteps.selectDefectFromList("1. Obligatory Seat Belt");
        defectDescriptionSteps.selectDefect("3.1 (b) MAJOR");
        defectDetailsSteps.selectVerticalLateralRowNumberSeatNumber("Upper","Nearside","4", "4");
        testTypeDetailsSteps.pressSave();
        testSteps.selectOdometerReading();
        odometerReadingSteps.typeInField("5");
        odometerReadingSteps.pressSave();
        testSteps.clickReviewAndSubmit();
        testReviewSteps.scrollDown();
        testReviewPage.clickSubmitButton();
        testReviewPage.clickSubmitInPopUp();
        confirmationPageSteps.pressDone();

        //Start 2nd Annual test
        siteVisitSteps.createNewTest();
        identifyVehicleSteps.searchForVehicle("678410");
        vehicleDetailsSteps.selectConfirmButtonTopRight();
        vehicleDetailsSteps.selectConfirmFromPopUp();
        preparerSteps.selectAndConfirmPreparerId(preparerService.getPreparerByIndex(0).getPreparerId());
        testSteps.addTestType();

        //New method created to check the popup is having the suggested test types in it
        testTypeCategorySteps.checkSuggestedTestTypeList("Paid annual retest", "Part paid annual retest", "Annual test");

        //New method created to check the order of the suggested test types on the popup
        testTypeCategorySteps.checkSuggestedTestTypeOrder("Paid annual retest", "Part paid annual retest", "Annual test");

        //AC2 - Check PSV Paid annual retest on suggested test type popup
        testTypeCategorySteps.selectFromSelectedTestTypeList("Paid annual retest");
        testSteps.selectTestType("Retest", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.pressTestTypeRemoveButton();
        testTypeDetailsSteps.pressRemoveTestTypeInPopUp();
        testSteps.addTestType();

        //AC3 Check PSV Part paid annual retest on suggested test type popup
        testTypeCategorySteps.selectFromSelectedTestTypeList("Part paid annual retest");
        testSteps.selectTestType("Retest", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.pressTestTypeRemoveButton();
        testTypeDetailsSteps.pressRemoveTestTypeInPopUp();
        testSteps.addTestType();

        //AC4 Check PSV annual test on suggested test type popup
        testTypeCategorySteps.selectFromSelectedTestTypeList("Annual test");
        testSteps.selectTestType("Annual test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.pressTestTypeRemoveButton();
        testTypeDetailsSteps.pressRemoveTestTypeInPopUp();
    }

    @Title("VTA-448 - AC1 and AC2 - PSV - Suggested test type pop up after PSV Class 6A annual and first test Fail within 20 days")
    @Test
    public void SuggestedTestTypePopUpPSVClass6ATest() {
        //AC1 - Put in 1st PSV Failed Class 6A first test
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("012356",super.username);
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();
        testSteps.selectOdometerReading();
        odometerReadingSteps.typeInField("123");
        odometerReadingSteps.pressSave();
        testSteps.selectVehicleCategoryOption();
        euVehicleCategorySteps.selectOption("M2");
        testSteps.addTestType();
        testTypeCategorySteps.waitUntilPageIsLoaded();
        testTypeCategorySteps.selectFromTestTypeList("Class 6A");
        testTypeCategorySteps.selectFromTestTypeList("Annual test");
        testSteps.selectTestType("Class 6A", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.selectNumberOfSeatbeltsFitted();
        seatbeltInstallationCheckSteps.inputNumberOfSeatbelts("3");
        testTypeDetailsSteps.scrollTestTypeDetailsPage();
        testTypeDetailsSteps.clickAddDefect();
        defectCategorySteps.waitUntilPageIsLoaded();
        defectCategorySteps.selectDefectFromList("3. Seat Belts & Supplementary Restraint Systems");
        defectItemSteps.selectDefectFromList("1. Obligatory Seat Belt");
        defectDescriptionSteps.selectDefect("3.1 (b) MAJOR");
        defectDetailsSteps.selectVerticalLateralRowNumberSeatNumber("Upper","Nearside","4", "4");
        testTypeDetailsSteps.pressSave();
        testSteps.clickReviewAndSubmit();
        testReviewSteps.scrollDown();
        testReviewPage.clickSubmitButton();
        testReviewPage.clickSubmitInPopUp();
        confirmationPageSteps.pressDone();

        //Start 2nd PSV Class 6A annual test
        siteVisitSteps.createNewTest();
        identifyVehicleSteps.searchForVehicle("012356");
        vehicleDetailsSteps.selectConfirmButtonTopRight();
        vehicleDetailsSteps.selectConfirmFromPopUp();
        preparerSteps.selectAndConfirmPreparerId(preparerService.getPreparerByIndex(0).getPreparerId());
        testSteps.selectOdometerReading();
        odometerReadingSteps.typeInField("123");
        odometerReadingSteps.pressSave();
        testSteps.addTestType();

        //New method created to check the popup is having the suggested test types in it
        testTypeCategorySteps.checkSuggestedTestTypeList("Paid class 6A retest", "Class 6A first test", "Class 6A annual test");

        //New method created to check the order of the suggested test types on the popup
        testTypeCategorySteps.checkSuggestedTestTypeOrder("Paid class 6A retest", "Class 6A first test", "Class 6A annual test");

        //Check PSV Paid class 6A retest on suggested test type popup
        testTypeCategorySteps.selectFromSelectedTestTypeList("Paid class 6A retest");
        testSteps.selectTestType("Retest", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.pressTestTypeRemoveButton();
        testTypeDetailsSteps.pressRemoveTestTypeInPopUp();
        testSteps.addTestType();

        //Check PSV Class 6A first test on suggested test type popup
        testTypeCategorySteps.selectFromSelectedTestTypeList("Class 6A first test");
        testSteps.selectTestType("First test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.pressTestTypeRemoveButton();
        testTypeDetailsSteps.pressRemoveTestTypeInPopUp();
        testSteps.addTestType();

        //Check PSV Class 6A annual test on suggested test type popup
        testTypeCategorySteps.selectFromSelectedTestTypeList("Class 6A annual test");
        testSteps.selectTestType("Annual test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.pressTestTypeRemoveButton();
        testTypeDetailsSteps.pressRemoveTestTypeInPopUp();
        testSteps.addTestType();

        //AC2 - Put in 1st PSV Failed Class 6A first test
        testTypeCategorySteps.selectFromSelectedTestTypeList("Select a different test type");
        testTypeCategorySteps.waitUntilPageIsLoaded();
        testTypeCategorySteps.selectFromTestTypeList("Class 6A");
        testTypeCategorySteps.selectFromTestTypeList("First test");
        testSteps.selectTestType("Class 6A", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.selectNumberOfSeatbeltsFitted();
        seatbeltInstallationCheckSteps.inputNumberOfSeatbelts("3");
        testTypeDetailsSteps.scrollTestTypeDetailsPage();
        testTypeDetailsSteps.clickAddDefect();
        defectCategorySteps.waitUntilPageIsLoaded();
        defectCategorySteps.selectDefectFromList("3. Seat Belts & Supplementary Restraint Systems");
        defectItemSteps.selectDefectFromList("1. Obligatory Seat Belt");
        defectDescriptionSteps.selectDefect("3.1 (b) MAJOR");
        defectDetailsSteps.selectVerticalLateralRowNumberSeatNumber("Upper","Nearside","4", "4");
        testTypeDetailsSteps.pressSave();
        testSteps.clickReviewAndSubmit();
        testReviewSteps.scrollDown();
        testReviewPage.clickSubmitButton();
        testReviewPage.clickSubmitInPopUp();
        confirmationPageSteps.pressDone();

        //Start 2nd PSV Class 6A first test
        siteVisitSteps.createNewTest();
        identifyVehicleSteps.searchForVehicle("012356");
        vehicleDetailsSteps.selectConfirmButtonTopRight();
        vehicleDetailsSteps.selectConfirmFromPopUp();
        preparerSteps.selectAndConfirmPreparerId(preparerService.getPreparerByIndex(0).getPreparerId());
        testSteps.addTestType();

        //New method created to check the popup is having the suggested test types in it
        testTypeCategorySteps.checkSuggestedTestTypeList("Paid class 6A retest", "Class 6A first test", "Class 6A annual test");

        //New method created to check the order of the suggested test types on the popup
        testTypeCategorySteps.checkSuggestedTestTypeOrder("Paid class 6A retest", "Class 6A first test", "Class 6A annual test");

        //Check PSV Paid class 6A retest on suggested test type popup
        testTypeCategorySteps.selectFromSelectedTestTypeList("Paid class 6A retest");
        testSteps.selectTestType("Retest", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.pressTestTypeRemoveButton();
        testTypeDetailsSteps.pressRemoveTestTypeInPopUp();
        testSteps.addTestType();

        //Check PSV Class 6A first test on suggested test type popup
        testTypeCategorySteps.selectFromSelectedTestTypeList("Class 6A first test");
        testSteps.selectTestType("First test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.pressTestTypeRemoveButton();
        testTypeDetailsSteps.pressRemoveTestTypeInPopUp();
        testSteps.addTestType();

        //Check PSV Class 6A annual test on suggested test type popup
        testTypeCategorySteps.selectFromSelectedTestTypeList("Class 6A annual test");
        testSteps.selectTestType("Annual test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.pressTestTypeRemoveButton();
        testTypeDetailsSteps.pressRemoveTestTypeInPopUp();
        testSteps.addTestType();
    }
}