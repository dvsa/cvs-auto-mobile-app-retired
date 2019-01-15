package testtype.CVSB_194;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.AbandonTestSteps;
import steps.AbandonedTestSteps;
import steps.SelectReasonSteps;
import steps.TestSteps;
import steps.composed.AbandonTestComp;
import steps.composed.TestTypeCategoryComp;
import util.BaseTestClass;

@RunWith(SerenityRunner.class)
public class TestTypeAbandon_CVSB_793 extends BaseTestClass {

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


    @Title("CVSB-194 - AC1 Reasons to abandon list")
    @Test
    public void testReasonsToAbandonList() {
        testTypeCategoryComp.completeAddTestType();
        testSteps.checkTestDetails("BQ91YHQ");
        testSteps.swipeTestType("Public Service Vehicle Annual Testing Not complete");
        testSteps.pressTestTypeAbandonButton();
        selectReasonSteps.checkSelectReasonPage();
        selectReasonSteps.checkReasonsList();
        selectReasonSteps.checkListIsScrollableByFirstReason();
    }


}
