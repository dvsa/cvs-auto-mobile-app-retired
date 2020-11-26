package testtype.CVSB_3069;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import pages.TestPage;
import steps.*;
import steps.composed.TestTypeCategoryComp;
import steps.util.UtilSteps;
import utils.BaseTestClass;

@Ignore
@RunWith(SerenityRunner.class)
public class TestCodes_WEL_FoundInTestTypes_CVSB_6937 extends BaseTestClass {

    @Steps
    UtilSteps utilSteps;

    @Steps
    TestTypeCategoryComp testTypeCategoryComp;

    @Steps
    TestSteps testSteps;

    @Steps
    TestTypeCategorySteps testTypeCategorySteps;

    @Steps
    TestTypeDetailsSteps testTypeDetailsSteps;

    @Steps
    SeatbeltInstallationCheckSteps seatbeltInstallationCheckSteps;

    @Steps
    EUVehicleCategorySteps euVehicleCategorySteps;

    @Steps
    OdometerReadingSteps odometerReadingSteps;

    @Steps
    DefectCategorySteps defectCategorySteps;

    @Steps
    DefectItemSteps defectItemSteps;

    @Steps
    DefectDescriptionSteps defectDescriptionSteps;

    @Steps
    DefectDetailsSteps defectDetailsSteps;

    @Steps
    TestReviewSteps testReviewSteps;

    @Title("CVSB-6937,CVSB-6939 and CVSB-6941- AC1,AC2 and AC3 - Codes added are reflected in the selection of test types, recorded against the test and reviewed")
    @Ignore
    // TODO
    // This is being disabled temporarily.  The Prohibition Clearance check has been updated, but the new functionality hasn't been merged in to the app yet.
    // Disabling until the new functionality has been merged.
    public void testTestCodeWEL() {
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        testTypeCategoryComp.goToTestTypeUsingSpecificVin(preparerService.getPreparerByIndex(0).getPreparerId(), preparerService.getPreparerByIndex(0).getPreparerName(),"012356",super.username);
        testTypeCategorySteps.selectFromTestTypeList("Prohibition Clearance");
        testTypeCategorySteps.selectFromTestTypeList("Class 6A (No seatbelt installation check)");
        testTypeCategorySteps.selectFromTestTypeList("PG9 Retest");
        testSteps.checkSelectedTestTypes("Prohibition clearance Edit checkmark");
        testSteps.checkTestTypeStatus("Prohibition clearance", TestPage.TestTypeStatuses.EDIT);
        testSteps.selectVehicleCategoryOption();
        euVehicleCategorySteps.selectM1Option();
        testSteps.selectOdometerReading();
        odometerReadingSteps.typeInField("44");
        odometerReadingSteps.checkReadingValue("44");
        odometerReadingSteps.pressSave();
        testSteps.selectTestType("Prohibition clearance", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.selectAddDefect("Prohibition clearance (retest without Class 6A seatbelt installation check)");
        defectCategorySteps.selectDefectFromList("1. Registration Plate");
        defectItemSteps.checkItemsArePresent("1. A registration plate:", "2. A registration mark:");
        defectItemSteps.selectDefectFromList("1. A registration plate:");
        defectDescriptionSteps.checkItemsArePresent("missing.", "insecure.");
        defectDescriptionSteps.selectDefect("1.1 (a) MAJOR");
        defectDetailsSteps.checkPageIsLoaded();
        defectDetailsSteps.clickLongitudinal();
        defectDetailsSteps.clickLongitudinalRear();
        defectDetailsSteps.tapDone();
        testTypeDetailsSteps.pressSave();

        testSteps.clickReviewAndSubmit();
        testReviewSteps.checkPageTitleIsDisplayed();
        testReviewSteps.checkElementIsDisplayed("X71LTA (PSV)");
        testReviewSteps.checkElementIsDisplayed("XMGDE02FS0H012356");
        testReviewSteps.checkElementValue("Odometer reading","44");
        testReviewSteps.checkElementValue("Prohibition clearance (retest without Class 6A seatbelt installation check)","FAIL");
        testReviewSteps.checkElementIsDisplayed("Defects");
        testReviewSteps.checkElementIsDisplayed("1.1 (a) MAJOR");
        testReviewSteps.checkElementIsDisplayed("1. Registration Plate");
        testReviewSteps.checkElementIsDisplayed("1. A registration plate:");
        testReviewSteps.checkElementIsDisplayed("(a) missing.");
        testReviewSteps.checkElementIsDisplayed("Rear");
    }
}
