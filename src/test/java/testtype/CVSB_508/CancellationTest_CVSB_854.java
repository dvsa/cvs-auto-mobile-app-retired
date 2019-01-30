package testtype.CVSB_508;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.CancelTestSteps;
import steps.SiteVisitSteps;
import steps.TestSteps;
import steps.composed.TestTypeCategoryComp;
import util.BaseTestClass;

@RunWith(SerenityRunner.class)
public class CancellationTest_CVSB_854 extends BaseTestClass {
    @Steps
    TestSteps testSteps;

    @Steps
    TestTypeCategoryComp testTypeCategoryComp;

    @Steps
    CancelTestSteps cancelTestSteps;

    @Steps
    SiteVisitSteps siteVisitSteps;

    @Title("CVSB-854 - AC3 Submit test cancellation when the test contains at least one test type")
    @Test
    public void submitCancellationWithAtLeastOneTestType() {
        testTypeCategoryComp.completeAddTestType();
        testSteps.pressCancelBottomRight();
        cancelTestSteps.checkPageDetails();
        cancelTestSteps.addReasonForCancellation("Automation Test");
        cancelTestSteps.pressSubmit();
        cancelTestSteps.pressSubmitInPopUp();
        siteVisitSteps.checkSiteVisitPage();
        //TODO to refactor after bug fixes 1393
        siteVisitSteps.checkCancelledTestStatus("BQ91YHQ");
    }
}

