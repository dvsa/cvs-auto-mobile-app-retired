package testtype.CVSB_3069;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import pages.TestPage;
import steps.*;
import steps.composed.TestTypeCategoryComp;
import util.BaseTestClass;

@RunWith(SerenityRunner.class)
public class TestCodes_WBS_FoundInTestTypes_CVSB_6937 extends BaseTestClass {

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



    @Ignore("CVSB-8749 - maintenance for improving test suite speed")
    @Title("CVSB-6937,CVSB-6939 and CVSB-6941- AC1,AC2 and AC3 - Codes added are reflected in the selection of test types, recorded against the test and reviewed")
    public void testTestCodeWBS() {
        testTypeCategoryComp.goToTestTypeUsingSpecificVin(preparerService.getPreparerByIndex(0).getPreparerId(), preparerService.getPreparerByIndex(0).getPreparerName(),"012345");
        testTypeCategorySteps.selectFromTestTypeList("Class 6A");
        testTypeCategorySteps.selectFromTestTypeList("First Test");
        testSteps.checkSelectedTestTypes("Class 6A In progress arrow forward");
        testSteps.checkTestTypeStatus("Class 6A", TestPage.TestTypeStatuses.IN_PROGRESS);
        testSteps.selectVehicleCategoryOption();
        euVehicleCategorySteps.selectM1Option();
        testSteps.selectOdometerReading();
        odometerReadingSteps.typeInField("123");
        odometerReadingSteps.checkReadingValue("123");
        odometerReadingSteps.pressSave();
        testSteps.selectTestType("Class 6A", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.checkTestTypesPageIsLoadedByTitle();
        testTypeDetailsSteps.selectNumberOfSeatbeltsFitted();
        seatbeltInstallationCheckSteps.inputNumberOfSeatbelts("2");
        testTypeDetailsSteps.pressSave();
        testSteps.checkSelectedTestTypes("Class 6A Edit checkmark");
        testSteps.checkTestTypeStatus("Class 6A", TestPage.TestTypeStatuses.EDIT);
        testSteps.selectTestType("Class 6A", TestPage.TestTypeStatuses.EDIT);

        testTypeDetailsSteps.selectAddDefect("Class 6A seatbelt installation check (first test)");
        defectCategorySteps.selectDefectFromList("1. Registration Plate");
        defectItemSteps.checkItemsArePresent("1. A registration plate:", "2. A registration mark:");
        defectItemSteps.selectDefectFromList("1. A registration plate:");
        defectDescriptionSteps.checkItemsArePresent("missing.", "insecure.");
        defectDescriptionSteps.selectDefect("1.1 (b) MAJOR");
        defectDetailsSteps.checkPageIsLoaded();
        defectDetailsSteps.clickLongitudinal();
        defectDetailsSteps.clickLongitudinalFront();
        defectDetailsSteps.setPRS();
        defectDetailsSteps.tapDone();
        testTypeDetailsSteps.addNotes("Hello");
        testTypeDetailsSteps.pressSave();

        testSteps.clickReviewAndSubmit();
        testReviewSteps.checkPageTitleIsDisplayed();
        testReviewSteps.checkElementIsDisplayed("JY58FPP (PSV)");
        testReviewSteps.checkElementIsDisplayed("XMGDE02FS0H012345");
        testReviewSteps.checkElementValue("Odometer reading","123");
        testReviewSteps.checkElementValue("Class 6A seatbelt installation check (first test)","PRS");
        testReviewSteps.checkElementValue("Seatbelt installation check","Yes");
        testReviewSteps.checkElementValue("Number of seatbelts fitted","2");
        testReviewSteps.scrollDown();
        testReviewSteps.checkElementIsDisplayed("Defects");
        testReviewSteps.checkElementIsDisplayed("1.1 (b) MAJOR PRS");
        testReviewSteps.checkElementIsDisplayed("1. Registration Plate");
        testReviewSteps.checkElementIsDisplayed("1. A registration plate:");
        testReviewSteps.checkElementIsDisplayed("(b) insecure.");
        testReviewSteps.checkElementIsDisplayed("Front");
        testReviewSteps.checkElementValue("Notes","Hello");
    }
}
