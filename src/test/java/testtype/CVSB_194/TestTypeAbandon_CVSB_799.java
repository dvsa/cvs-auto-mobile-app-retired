package testtype.CVSB_194;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import pages.SelectReasonPage;
import steps.AbandonTestSteps;
import steps.AbandonedTestSteps;
import steps.SelectReasonSteps;
import steps.TestSteps;
import steps.composed.AbandonTestComp;
import steps.composed.TestTypeCategoryComp;
import steps.util.UtilSteps;
import utils.BaseTestClass;

@Ignore
@RunWith(SerenityRunner.class)
public class TestTypeAbandon_CVSB_799 extends BaseTestClass {
    @Steps
    UtilSteps utilSteps;

    @Steps
    TestSteps testSteps;

    @Steps
    TestTypeCategoryComp testTypeCategoryComp;

    @Steps
    SelectReasonSteps selectReasonSteps;

    @Steps
    AbandonTestSteps abandonTestSteps;

    @Steps
    AbandonTestComp abandonTestComp;

    @Steps
    AbandonedTestSteps abandonedTestSteps;

    @Title("CVSB-194 - AC2 Confirm abandon for a test type")
    // De-scoped due to: CVSB-12952: VTA FE Maintenance - increasing suite efficiency
    public void testWarningMessageConfirm() {
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        testTypeCategoryComp.completeAddTestType(preparerService.getPreparerByIndex(0).getPreparerId(), preparerService.getPreparerByIndex(0).getPreparerName(),super.username);
        abandonTestComp.goToAbandonTestScreen(SelectReasonPage.Reasons.REASON_1, SelectReasonPage.Reasons.REASON_10);
        abandonTestSteps.checkAbandonTestPage();
        abandonTestSteps.checkSelectedReasons(SelectReasonPage.Reasons.REASON_1, SelectReasonPage.Reasons.REASON_10);
        abandonTestSteps.pressDone();
        abandonTestSteps.pressAbandon();
        testSteps.checkTestDetails("BQ91YHQ","1B7GG36N12S678410");
    }

}
