package testtype.CVSB_5139;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.core.annotations.WithTag;
import org.junit.Test;
import org.junit.runner.RunWith;
import pages.TestPage;
import pages.TestTypeDetailsPage;
import steps.*;
import steps.composed.TestTypeCategoryComp;
import util.BaseTestClass;

@RunWith(SerenityRunner.class)
public class TestResultIsDisplayedAsPRS_CVSB_6352 extends BaseTestClass {

    @Steps
    TestSteps testSteps;

    @Steps
    TestTypeCategorySteps testTypeCategorySteps;

    @Steps
    TestTypeCategoryComp testTypeCategoryComp;

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
    TestTypeDetailsPage testTypeDetailsPage;

    @Steps
    EUVehicleCategorySteps euVehicleCategorySteps;

    @Steps
    OdometerReadingSteps odometerReadingSteps;

    @Steps
    TestReviewSteps testReviewSteps;

    @Steps
    SeatbeltInstallationCheckSteps seatbeltInstallationCheckSteps;

    @Title("CVSB-5139 - TCD - AC2 - VSA saves test details")
    @WithTag("Smoke_2")
    @Test
    public void prohibitionFieldNotDisplayedAtADefectLevelRestes() {
        testTypeCategoryComp.completeAddTestType(preparerService.getPreparerByIndex(0).getPreparerId(), preparerService.getPreparerByIndex(0).getPreparerName(), "Prohibition Clearance");
        testTypeCategorySteps.selectFromTestTypeList("Any PSV");
        testTypeCategorySteps.selectFromTestTypeList("Part inspection/ part fee");
        testSteps.selectVehicleCategoryOption();
        euVehicleCategorySteps.selectM1Option();
        testSteps.selectOdometerReading();
        odometerReadingSteps.typeInField("1");
        odometerReadingSteps.pressSave();
        testSteps.selectTestType("Prohibition clearance", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.setCarriedOutDuringTest(true);
        testTypeDetailsSteps.selectNumberOfSeatbeltsFitted();
        seatbeltInstallationCheckSteps.inputNumberOfSeatbelts("1");
        testTypeDetailsSteps.clickAddDefect();
        defectCategorySteps.selectDefectFromList("8. Condition of Tyres");
        defectItemSteps.selectDefectFromList("1. A tyre");
        defectDescriptionSteps.selectDefect("8.1 (b) DANGEROUS");
        defectDetailsSteps.selectOptionsWithPRSCheckAndTapAddDefect(defectDetailsSteps.inputDangerousTyreDefect());
        testTypeDetailsSteps.pressSave();
        testSteps.clickReview();
        testReviewSteps.checkTestStatus("Part-paid prohibition clearance (partial inspection)", "PRS");
    }
}
