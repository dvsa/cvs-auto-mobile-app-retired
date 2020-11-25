package testresults.CVSB_980;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import pages.TestPage;
import steps.*;
import steps.composed.TestTypeCategoryComp;
import steps.util.UtilSteps;
import util.BaseTestClass;

@RunWith(SerenityRunner.class)
public class AutoCalculatedTestResults_2695 extends BaseTestClass {

    @Steps
    UtilSteps utilSteps;

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

    @Steps
    AdvisoryDetailsSteps advisoryDetailsSteps;

    @Title("CVSB_980 - AC1 - Pass criteria (Minor + Advisory defects)")
    @Test
    public void passCriteriaMinorPlusAdvisoryDefects() {
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        testTypeCategoryComp.goToTestPage(preparerService.getPreparerByIndex(0).getPreparerId(),preparerService.getPreparerByIndex(0).getPreparerName(),super.username);
        testSteps.selectVehicleCategoryOption();
        euVehicleCategorySteps.selectOption("M2");
        testSteps.selectOdometerReading();
        odometerReadingSteps.typeInField("8");
        odometerReadingSteps.pressSave();
        testSteps.addTestType();
        testTypeCategorySteps.waitUntilPageIsLoaded();
        testTypeCategorySteps.selectFromTestTypeList("Annual test");
        testSteps.selectTestType("Annual test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.setCarriedOutDuringTest(true);
        testTypeDetailsSteps.selectNumberOfSeatbeltsFitted();
        seatbeltInstallationCheckSteps.inputNumberOfSeatbelts("8");
        testTypeDetailsSteps.pressSave();
        testSteps.clickReviewAndSubmit();
        testReviewSteps.checkTestStatus("Annual test", "PASS");
        testReviewSteps.scrollDown();
        testReviewSteps.changeTestDetails();
        testTypeDetailsSteps.clickAddDefect();
        defectCategorySteps.searchForDefect("59");
        defectCategorySteps.selectDefectFromList("59. Brake Systems and Components");
        defectItemSteps.selectDefectFromList("4. Reservoir:");
        defectDescriptionSteps.tapAddAnAdvisoryNote();
        advisoryDetailsSteps.addCustomNoteAndTapAddNote("Test");

        testTypeDetailsSteps.clickAddDefect();
        defectCategorySteps.searchForDefect("59");
        defectCategorySteps.selectDefectFromList("59. Brake Systems and Components");
        defectItemSteps.selectDefectFromList("4. Reservoir:");
        defectDescriptionSteps.selectDefect("59.4 (a) (i) MINOR");
        defectDetailsSteps.selectVerticalLateralLongitudinalAxle("Upper", "Nearside", "Front", "8");
        testTypeDetailsSteps.pressSave();
        testReviewSteps.checkTestStatus("Annual test", "PASS");
    }
}
