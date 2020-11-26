package atf.CVSB_167;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import steps.ATFDetailsSteps;
import steps.LaunchSteps;
import steps.SearchForAnATFSteps;
import steps.util.UtilSteps;
import utils.BaseTestClass;

@Ignore
@RunWith(SerenityRunner.class)
public class AtfSelect_CVSB_1456 extends BaseTestClass {

    @Steps
    UtilSteps utilSteps;

    @Steps
    LaunchSteps launchSteps;

    @Steps
    SearchForAnATFSteps searchForAnATFSteps;

    @Steps
    ATFDetailsSteps atfDetailsSteps;


    @Ignore("CVSB-8749 - maintenance for improving test suite speed")
    @Title("CVSB-167 - AC6 - VSA is able to confirm that the site is not suitable for testing")
    public void testConfirmSiteNotSuitableForTesting() {
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        launchSteps.clickGetStarted(super.username);
        searchForAnATFSteps.waitForPageToLoadAndSelectAnAtf(atfService.getUniqueIdentifier(0));
        atfDetailsSteps.pressStartVisit();
        atfDetailsSteps.checkStartVisitPopUp();
        atfDetailsSteps.pressReportIssueInStartVisitPopUp();
        atfDetailsSteps.checkReportIssuePopUp();
        atfDetailsSteps.pressOkInReportIssuePopUp();
        atfDetailsSteps.checkReportIssuePopUpIsNotDisplayed();
    }
}
