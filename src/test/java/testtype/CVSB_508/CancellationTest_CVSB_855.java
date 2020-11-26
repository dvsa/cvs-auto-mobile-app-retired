package testtype.CVSB_508;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import steps.CancelTestSteps;
import steps.SiteVisitSteps;
import steps.TestSteps;
import steps.composed.TestTypeCategoryComp;
import steps.util.UtilSteps;
import utils.BaseTestClass;

@Ignore
@RunWith(SerenityRunner.class)
public class CancellationTest_CVSB_855 extends BaseTestClass {
    @Steps
    UtilSteps utilSteps;

    @Steps
    TestSteps testSteps;

    @Steps
    TestTypeCategoryComp testTypeCategoryComp;

    @Steps
    CancelTestSteps cancelTestSteps;

    @Steps
    SiteVisitSteps siteVisitSteps;

    @Ignore("CVSB-8749 - maintenance for improving test suite speed")
    @Title("CVSB-855 - AC2 Submit test cancellation when the test does not contain test types")
    public void submitCancellationWitoutTestType() {
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        testTypeCategoryComp.goToTestPage(preparerService.getPreparerByIndex(0).getPreparerId(), preparerService.getPreparerByIndex(0).getPreparerName(),super.username);
        testSteps.pressCancelBottomRight();
        cancelTestSteps.checkPageDetails();
        cancelTestSteps.addReasonForCancellation("CANCEL Reason test Text 1234");
        cancelTestSteps.pressSubmit();
        cancelTestSteps.pressSubmitInPopUp();
        siteVisitSteps.checkSiteVisitPage();
        siteVisitSteps.checkCancelledTestStatus("BQ91 YHQ");
    }
}
