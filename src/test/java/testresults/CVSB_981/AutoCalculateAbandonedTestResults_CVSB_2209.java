package testresults.CVSB_981;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import pages.SelectReasonPage;
import steps.*;
import steps.composed.TestTypeCategoryComp;
import util.BaseTestClass;

@RunWith(SerenityRunner.class)
public class AutoCalculateAbandonedTestResults_CVSB_2209 extends BaseTestClass {

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
    AbandonTestSteps abandonTestSteps;

    @Steps
    SelectReasonSteps selectReasonSteps;

    @Title("CVSB_981 - AC1 Auto-calculate test results upon abandoning a test type (test review screen)")
    @Test
    public void testAutoCalculateAbandonedTestInTestReview() {
        testTypeCategoryComp.goToTestPage(preparerService.getPreparerByIndex(0).getPreparerId(),preparerService.getPreparerByIndex(0).getPreparerName());
        testSteps.selectVehicleCategoryOption();
        euVehicleCategorySteps.selectM1Option();
        testSteps.selectOdometerReading();
        odometerReadingSteps.typeInField("5");
        odometerReadingSteps.pressSave();
        testSteps.addTestType();
        testTypeCategorySteps.selectFromTestTypeList("Annual test");
        testSteps.swipeTestType("Annual test");
        testSteps.pressTestTypeAbandonButton();
        selectReasonSteps.selectMultipleReasons(SelectReasonPage.Reasons.REASON_8, SelectReasonPage.Reasons.REASON_12,
                SelectReasonPage.Reasons.REASON_6, SelectReasonPage.Reasons.REASON_2);
        selectReasonSteps.pressNextButton();
        abandonTestSteps.pressDone();
        abandonTestSteps.pressAbandon();
        testSteps.clickReview();
        testReviewSteps.checkTestStatus("Annual test", "ABANDONED");
    }
}
