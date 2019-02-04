package atf.CVSB_167;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.ATFDetailsSteps;
import steps.LaunchSteps;
import steps.SearchForAnATFSteps;
import steps.SiteVisitSteps;
import util.BaseTestClass;

@RunWith(SerenityRunner.class)
public class AtfSelect_CVSB_1460 extends BaseTestClass {

    @Steps
    LaunchSteps launchSteps;

    @Steps
    SearchForAnATFSteps searchForAnATFSteps;

    @Steps
    ATFDetailsSteps atfDetailsSteps;

    @Steps
    SiteVisitSteps siteVisitSteps;


    @Title("CVSB-167 - AC8 - VSA is unable to return to ATF search once they have added a site to the visit")
    @Test
    public void testInabilityToReturnToPreviousScreen() {
        launchSteps.clickGetStarted();
        searchForAnATFSteps.waitForPageToLoadAndSelectAnAtf("Abshire-Kub 09-4129632");
        atfDetailsSteps.pressStartVisit();
        atfDetailsSteps.checkStartVisitPopUp();
        atfDetailsSteps.pressConfirmInSiteVisitPopUp();
        siteVisitSteps.checkThatThereIsNoBackButton();

    }
}
