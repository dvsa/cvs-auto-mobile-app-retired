package testtype.CVSB_508;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.CancelTestSteps;
import steps.TestSteps;
import steps.composed.TestTypeCategoryComp;
import util.BaseTestClass;

@RunWith(SerenityRunner.class)
public class CancellationTest_CVSB_851 extends BaseTestClass {

    @Steps
    TestSteps testSteps;

    @Steps
    TestTypeCategoryComp testTypeCategoryComp;

    @Steps
    CancelTestSteps cancelTestSteps;

    @Title("CVSB-851 - AC1 VSA decides to cancel a test")
    @Test
    public void cancelTet() {
        testTypeCategoryComp.goToTestPage();
        testSteps.checkTestDetails("BQ91YHQ");
        testSteps.pressCancelBottomRight();
        cancelTestSteps.checkPageDetails();
        cancelTestSteps.checkTextInputField();
    }
}

