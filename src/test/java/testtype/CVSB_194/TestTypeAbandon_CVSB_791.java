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
public class TestTypeAbandon_CVSB_791 extends BaseTestClass {

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

    @Title("CVSB-194 - AC1 Abandon option")
    @Test
    public void testRemoveTestType() {
        testTypeCategoryComp.completeAddTestType(preparerService.getPreparerByIndex(0).getPreparerId(), preparerService.getPreparerByIndex(0).getPreparerName());
        testSteps.checkTestDetails("BQ91YHQ","1B7GG36N12S678410");
        testSteps.swipeTestType("Annual test In progress arrow forward");
        testSteps.checkTestTypeAbandonButtonVisibility();
    }

}
