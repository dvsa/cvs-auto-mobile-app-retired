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
public class AtfSelect_CVSB_1452 extends BaseTestClass {

    @Steps
    LaunchSteps launchSteps;

    @Steps
    SearchForAnATFSteps searchForAnATFSteps;

    @Steps
    ATFDetailsSteps atfDetailsSteps;

    @Steps
    SiteVisitSteps siteVisitSteps;


    @Title("CVSB-167 - AC5 - VSA is able to confirm that the selected ATF site is suitable for testing")
    @Test
    public void testConfirmAtfSite() {
        launchSteps.clickGetStarted();
        searchForAnATFSteps.waitForPageToLoadAndSelectAnAtf("Abshire-Kub 09-4129632");
        atfDetailsSteps.pressStartVisit();
        atfDetailsSteps.pressConfirmInSiteVisitPopUp();
        siteVisitSteps.checkSiteVisitPage();

    }
}
