package testtype.CVSB_695;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import steps.OdometerReadingSteps;
import steps.TestSteps;
import steps.composed.TestTypeCategoryComp;
import steps.util.UtilSteps;
import util.BaseTestClass;

@Ignore
@RunWith(SerenityRunner.class)
public class OdometerReading_CVSB_1177 extends BaseTestClass {
    @Steps
    UtilSteps utilSteps;

    @Steps
    TestTypeCategoryComp testTypeCategoryComp;

    @Steps
    TestSteps testSteps;

    @Steps
    OdometerReadingSteps odometerReadingSteps;

    @Ignore("[CVSB-8289] Removing test to improve overall efficiency of the mobile app Front-end automation test suite.")
    @Title("CVSB-695 - AC5 - Cancel type in odometer reading value")
    public void testCancelTypeInOdometerReadingValue() {
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        testTypeCategoryComp.goToTestPage(preparerService.getPreparerByIndex(0).getPreparerId(), preparerService.getPreparerByIndex(0).getPreparerName(),super.username);
        testSteps.checkTestDetails("BQ91YHQ", "1B7GG36N12S678410");
        testSteps.selectOdometerReading();
        odometerReadingSteps.typeInField("12345678");
        // TODO refactor/continue after ios keyboard fix (CVSB-2630 bug)
    }
}
