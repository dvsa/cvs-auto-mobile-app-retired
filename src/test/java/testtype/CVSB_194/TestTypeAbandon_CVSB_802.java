package testtype.CVSB_194;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import pages.SelectReasonPage;
import steps.AbandonTestSteps;
import steps.AbandonedTestSteps;
import steps.SelectReasonSteps;
import steps.TestSteps;
import steps.composed.AbandonTestComp;
import steps.composed.TestTypeCategoryComp;
import util.BaseTestClass;

@RunWith(SerenityRunner.class)
public class TestTypeAbandon_CVSB_802 extends BaseTestClass {

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

    @Title("CVSB-194 - AC3 Edit additional comments after abandon")
    @Test
    public void testEditAdditionalCommentAfterAbandon() {
        abandonTestComp.goToAbandonTestScreen(SelectReasonPage.Reasons.REASON_1, SelectReasonPage.Reasons.REASON_10);
        abandonTestSteps.checkAbandonTestPage();
        abandonTestSteps.addAdditionalComments("Additional Comment Test 123");
        abandonTestSteps.pressDone();
        abandonTestSteps.pressAbandon();
        testSteps.selectAbandonedTest("annual test Abandoned In progress arrow forward");
        abandonedTestSteps.checkAbandonedTestPage();
        abandonedTestSteps.checkSelectedReasons(SelectReasonPage.Reasons.REASON_1, SelectReasonPage.Reasons.REASON_10);
        abandonedTestSteps.checkAddedComment("Additional Comment Test 123");
    }

}
