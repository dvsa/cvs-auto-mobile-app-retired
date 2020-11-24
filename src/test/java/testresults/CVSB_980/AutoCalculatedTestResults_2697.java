package testresults.CVSB_980;

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

@Ignore
@RunWith(SerenityRunner.class)
public class AutoCalculatedTestResults_2697 extends BaseTestClass {

    @Steps
    TestSteps testSteps;

    @Steps
    TestTypeCategorySteps testTypeCategorySteps;

    @Steps
    TestTypeCategoryComp testTypeCategoryComp;

    @Steps
    EUVehicleCategorySteps euVehicleCategorySteps;

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

    @Ignore("[CVSB-8289] Removing test to improve overall efficiency of the mobile app Front-end automation test suite.")
    @Title("CVSB_980 - AC1 - Fail criteria (At least 1 Major + 1 PRS)")
    public void failCriteriaWithOneMajorAndPRS() {
        testTypeCategoryComp.goToTestPage(preparerService.getPreparerByIndex(0).getPreparerId(),preparerService.getPreparerByIndex(0).getPreparerName(),super.username);
        testSteps.selectVehicleCategoryOption();
        euVehicleCategorySteps.selectM1Option();
        testSteps.selectOdometerReading();
        odometerReadingSteps.typeInField("5");
        odometerReadingSteps.pressSave();
        testSteps.addTestType();
        testTypeCategorySteps.waitUntilPageIsLoaded();
        testTypeCategorySteps.selectFromTestTypeList("Annual test");
        testSteps.selectTestType("Annual test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.setCarriedOutDuringTest(true);
        testTypeDetailsSteps.selectNumberOfSeatbeltsFitted();
        seatbeltInstallationCheckSteps.inputNumberOfSeatbelts("3");
        testTypeDetailsSteps.pressSave();
        testSteps.clickReviewAndSubmit();
        testReviewSteps.checkTestStatus("Annual test", "PASS");
        testReviewSteps.changeDetails();

        //Adding first PRS defect
        testTypeDetailsSteps.clickAddDefect();
        defectCategorySteps.selectDefectFromList("3. Seat Belts & Supplementary Restraint Systems");
        defectItemSteps.selectDefectFromList("1. Obligatory Seat Belt");
        defectDescriptionSteps.selectDefect("3.1 (a) MAJOR");

        defectDetailsSteps.selectVerticalLateralRowNumberSeatNumber("Upper","Nearside","4", "4");

        //Adding second PRS defect and check that the test has PRS status
        testTypeDetailsSteps.clickAddDefect();
        defectCategorySteps.selectDefectFromList("3. Seat Belts & Supplementary Restraint Systems");
        defectItemSteps.selectDefectFromList("1. Obligatory Seat Belt");
        defectDescriptionSteps.selectDefect("3.1 (b) MAJOR");
        defectDetailsSteps.selectVerticalLateralRowNumberSeatNumber("Upper","Nearside","4", "4");
        testTypeDetailsSteps.pressSave();
        testReviewSteps.checkTestStatus("Annual test", "PRS");

        //changing one PRS into non PRS defect and check that the test has fail status
        testReviewSteps.scrollDown();
        testReviewSteps.changeDetails();
        testTypeDetailsSteps.selectDefectBasedOnDefectDescription("(a) missing.");
        defectDetailsSteps.setPRS();
        defectDetailsSteps.tapDone();
        testTypeDetailsSteps.pressSave();
        testReviewSteps.scrollUp();
        testReviewSteps.checkTestStatus("Annual test", "FAIL");
    }
}
