package testtype.CVSB_3069;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import pages.TestPage;
import steps.*;
import steps.composed.TestTypeCategoryComp;
import util.BaseTestClass;

@RunWith(SerenityRunner.class)
public class TestCodes_WES_FoundInTestTypes_CVSB_6937 extends BaseTestClass {

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
    @Test
    public void testTestCodeWES() {
        testTypeCategoryComp.goToTestTypeUsingSpecificVin(preparerService.getPreparerByIndex(0).getPreparerId(), preparerService.getPreparerByIndex(0).getPreparerName(),"012345");
        testTypeCategorySteps.selectFromTestTypeList("Prohibition Clearance");
        testTypeCategorySteps.selectFromTestTypeList("Class 6A (No seatbelt installation check)");
        testTypeCategorySteps.selectFromTestTypeList("PG9 Retest");
        testSteps.checkSelectedTestTypes("Prohibition clearance Edit checkmark");
        testSteps.checkTestTypeStatus("Prohibition clearance", TestPage.TestTypeStatuses.EDIT);
        testSteps.selectVehicleCategoryOption();
        euVehicleCategorySteps.selectM1Option();
        testSteps.selectOdometerReading();
        odometerReadingSteps.typeInField("888");
        odometerReadingSteps.checkReadingValue("888");
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

        testSteps.clickReview();
        testReviewSteps.checkPageTitleIsDisplayed();
        testReviewSteps.changeDetails();
        testTypeDetailsSteps.addNotes("Hello");
        testTypeDetailsSteps.pressSave();

        testReviewSteps.checkElementIsDisplayed("JY58FPP (PSV)");
        testReviewSteps.checkElementIsDisplayed("XMGDE02FS0H012345");
        testReviewSteps.checkElementValue("Odometer reading","888");
        testReviewSteps.checkElementValue("Prohibition clearance (retest without Class 6A seatbelt installation check)","FAIL");
        testReviewSteps.checkElementIsDisplayed("Defects");
        testReviewSteps.checkElementIsDisplayed("1.1 (a) MAJOR");
        testReviewSteps.checkElementIsDisplayed("1. Registration Plate");
        testReviewSteps.checkElementIsDisplayed("1. A registration plate:");
        testReviewSteps.checkElementIsDisplayed("(a) missing.");
        testReviewSteps.checkElementIsDisplayed("Rear");
        testReviewSteps.checkElementValue("Notes","Hello");
    }

}
