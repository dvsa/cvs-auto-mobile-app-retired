package testtype.CVSB_11706;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import pages.TestPage;
import steps.*;
import steps.composed.TestTypeCategoryComp;
import steps.util.UtilSteps;
import utils.BaseTestClass;

@RunWith(SerenityRunner.class)
public class RetestPopUp_11706 extends BaseTestClass {

    @Steps
    UtilSteps utilSteps;

    @Steps
    TestSteps testSteps;

    @Steps
    TestTypeCategorySteps testTypeCategorySteps;

    @Steps
    TestTypeCategoryComp testTypeCategoryComp;

    @Steps
    ConfirmationPageSteps confirmationPageSteps;

    @Steps
    OdometerReadingSteps odometerReadingSteps;

    @Steps
    TestReviewSteps testReviewSteps;

    @Steps
    TestTypeDetailsSteps testTypeDetailsSteps;

    @Steps
    DefectCategorySteps defectCategorySteps;

    @Steps
    DefectItemSteps defectItemSteps;

    @Steps
    DefectDescriptionSteps defectDescriptionSteps;

    @Steps
    DefectDetailsSteps defectDetailsSteps;

    @Steps
    SeatbeltInstallationCheckSteps seatbeltInstallationCheckSteps;

    @Steps
    SiteVisitSteps siteVisitSteps;

    @Steps
    PreparerSteps preparerSteps;

    @Steps
    IdentifyVehicleSteps identifyVehicleSteps;

    @Steps
    VehicleDetailsSteps vehicleDetailsSteps;

    @Steps
    TestTypeSubcategorySteps testTypeSubcategorySteps;

    @Title("CVSB_11706 - AC-1 (for HGV) submitting a failed test and pop up test-type - hgv)")
    @Test
    public void testTypePopUpHGV() {
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("230123",super.username);
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();
        testSteps.selectOdometerReading();
        odometerReadingSteps.typeInField("8");
        odometerReadingSteps.pressSave();
        testSteps.addTestType();
        testTypeCategorySteps.waitUntilPageIsLoaded();
        testTypeCategorySteps.selectFromTestTypeList("Annual test");
        testSteps.selectTestType("Annual test", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.checkTestTypeName("Annual test");
        testTypeDetailsSteps.clickAddDefect();
        defectCategorySteps.selectDefectFromList("3. Seat Belts & Supplementary Restraint Systems");
        defectItemSteps.selectDefectFromList("1. Obligatory Seat Belt");
        defectDescriptionSteps.selectDefect("3.1 (b) MAJOR");

        //PS: I have added this new method - selectVerticalLateral
        defectDetailsSteps.selectVerticalLateral("Upper", "Nearside");
        testTypeDetailsSteps.pressSave();
        testSteps.clickReviewAndSubmit();
        testReviewSteps.scrollDown();
        testReviewSteps.pressSubmit();
        testReviewSteps.checkSubmitPopUp();
        testReviewSteps.pressSubmitInPopUp();
        confirmationPageSteps.pressDone();
        siteVisitSteps.createNewTest();
        identifyVehicleSteps.searchForVehicle("230123");
        vehicleDetailsSteps.selectConfirmButtonTopRight();
        vehicleDetailsSteps.selectConfirmFromPopUp();
        preparerSteps.selectAndConfirmPreparerId(preparerService.getPreparerByIndex(0).getPreparerId());
        testSteps.selectOdometerReading();
        odometerReadingSteps.typeInField("8");
        odometerReadingSteps.pressSave();
        testSteps.addTestType();

        // New method created to check the popup is having the suggested test types in it
        testTypeCategorySteps.checkSuggestedTestTypeList("Paid annual test retest", "Part paid annual test retest", "Annual test");

        //AC-2 checking on clicking suggested testtype its taking to inner page
        // this last step change according to the vehicle type please
        testTypeCategorySteps.selectFromTestTypeList("Paid annual test restest");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("Class 6A");
    }

    @Title("CVSB_11706 - AC-1 (for PSV) submitting a failed test and pop up test-type - hgv)")
    @Test
    public void testTypePopUpPSV() {

    }
}

