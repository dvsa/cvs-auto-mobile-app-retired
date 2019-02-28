package sitevisit.CVSB_169;

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
public class SiteVisitTimeline_2060 extends BaseTestClass {

    @Steps
    TestTypeCategoryComp testTypeCategoryComp;

    @Steps
    TestSteps testSteps;

    @Steps
    CancelTestSteps cancelTestSteps;

    @Steps
    SiteVisitSteps siteVisitSteps;

    @Title("CVSB-169 - AC3 - VSA is presented with the Site Visit timeline after cancelling a test")
    @Test
    public void testSiteVisitTimelineAfterTestCancel() {
        testTypeCategoryComp.goToTestPage(preparerService.getPreparerByIndex(0).getPreparerId(), preparerService.getPreparerByIndex(0).getPreparerName());
        testSteps.pressCancelBottomRight();
        cancelTestSteps.addReasonForCancellation("Test Reason");
        cancelTestSteps.pressSubmit();
        cancelTestSteps.pressSubmitInPopUp();
        siteVisitSteps.checkSiteVisitPage();
        siteVisitSteps.checkCancelledTestStatus("BQ91YHQ");

    }
}
