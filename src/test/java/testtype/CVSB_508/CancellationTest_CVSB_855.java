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
public class CancellationTest_CVSB_855 extends BaseTestClass {

    @Steps
    TestSteps testSteps;

    @Steps
    TestTypeCategoryComp testTypeCategoryComp;

    @Steps
    CancelTestSteps cancelTestSteps;

    @Steps
    SiteVisitSteps siteVisitSteps;

    @Title("CVSB-855 - AC2 Submit test cancellation when the test does not contain test types")
    @Test
    public void submitCancellationWitoutTestType() {
        testTypeCategoryComp.goToTestPage();
        testSteps.pressCancelBottomRight();
        cancelTestSteps.checkPageDetails();
        cancelTestSteps.addReasonForCancellation("CANCEL Reason test Text 1234");
        cancelTestSteps.pressSubmit();
        cancelTestSteps.pressSubmitInPopUp();
        siteVisitSteps.checkSiteVisitPage();
        //TODO continue and refactor after bug fix 1393
    }
}

