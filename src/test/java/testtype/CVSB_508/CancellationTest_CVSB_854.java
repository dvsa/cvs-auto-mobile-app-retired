package testtype.CVSB_508;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.core.annotations.WithTag;
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
    @WithTag("Smoke_2")
    @Test
    public void submitCancellationWithAtLeastOneTestType() {
        testTypeCategoryComp.completeAddTestType(preparerService.getPreparerByIndex(0).getPreparerId(), preparerService.getPreparerByIndex(0).getPreparerName());
        testSteps.pressCancelBottomRight();
        cancelTestSteps.checkPageDetails();
        cancelTestSteps.addReasonForCancellation("Automation Test");
        cancelTestSteps.pressSubmit();
        cancelTestSteps.pressSubmitInPopUp();
        siteVisitSteps.waitUntilPageIsLoaded();
        siteVisitSteps.checkSiteVisitPage();
        siteVisitSteps.checkCancelledTestStatus("BQ91 YHQ");
    }
}
