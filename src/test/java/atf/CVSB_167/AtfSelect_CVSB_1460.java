package atf.CVSB_167;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import steps.ATFDetailsSteps;
import steps.LaunchSteps;
import steps.SearchForAnATFSteps;
import steps.SiteVisitSteps;
import steps.util.UtilSteps;
import utils.BaseTestClass;

@Ignore
@RunWith(SerenityRunner.class)
public class AtfSelect_CVSB_1460 extends BaseTestClass {

    @Steps
    UtilSteps utilSteps;

    @Steps
    LaunchSteps launchSteps;

    @Steps
    SearchForAnATFSteps searchForAnATFSteps;

    @Steps
    ATFDetailsSteps atfDetailsSteps;

    @Steps
    SiteVisitSteps siteVisitSteps;

    @Ignore("CVSB-12952: VTA FE Maintenance - increasing suite efficiency")
    @Title("CVSB-167 - AC8 - VSA is unable to return to ATF search once they have added a site to the visit")
    public void testInabilityToReturnToPreviousScreen() {
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        launchSteps.clickGetStarted(super.username);
        searchForAnATFSteps.waitForPageToLoadAndSelectAnAtf(atfService.getUniqueIdentifier(0));
        atfDetailsSteps.pressStartVisit();
        atfDetailsSteps.checkStartVisitPopUp();
        atfDetailsSteps.pressConfirmInSiteVisitPopUp();
        siteVisitSteps.checkThatThereIsNoBackButton();

    }
}
