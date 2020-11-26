package testtype.CVSB_508;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.CancelTestSteps;
import steps.TestSteps;
import steps.composed.TestTypeCategoryComp;
import steps.util.UtilSteps;
import utils.BaseTestClass;

@RunWith(SerenityRunner.class)
public class CancellationTest_CVSB_853 extends BaseTestClass {
    @Steps
    TestSteps testSteps;

    @Steps
    TestTypeCategoryComp testTypeCategoryComp;

    @Steps
    CancelTestSteps cancelTestSteps;

    @Steps
    UtilSteps utilSteps;

    @Title("CVSB-853 - AC1 Submit cancellation without completing the mandatory fields")
    @Test
    public void submitCancellationWithoutMandatoryInfo() {
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        testTypeCategoryComp.goToTestPage(preparerService.getPreparerByIndex(0).getPreparerId(), preparerService.getPreparerByIndex(0).getPreparerName(),super.username);
        testSteps.pressCancelBottomRight();
        cancelTestSteps.checkPageDetails();
        cancelTestSteps.pressSubmit();
        cancelTestSteps.checkNoReasonPopUp();
        cancelTestSteps.pressOKNoReasonPopUp();
    }
}
