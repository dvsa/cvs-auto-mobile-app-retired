package sitevisit.CVSB_163;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.*;
import util.BaseTestClass;

@RunWith(SerenityRunner.class)
public class EndASiteVisit_CVSB_2879 extends BaseTestClass {

    @Steps
    SiteVisitSteps siteVisitSteps;

    @Steps
    LaunchSteps launchSteps;

    @Steps
    SearchForAnATFSteps searchForAnATFSteps;

    @Steps
    ATFDetailsSteps atfDetailsSteps;

    @Title("CVSB-163 - AC5 Wait for data to be loaded")
    @Test
    public void testWaitForDataToBeLoaded() {
        launchSteps.clickGetStarted();
        searchForAnATFSteps.waitForPageToLoadAndSelectAnAtf("Abshire-Kub 09-4129632");
        atfDetailsSteps.startVisit();
        siteVisitSteps.checkCreateTestButton();
        siteVisitSteps.selectEndVisit();
        siteVisitSteps.checkEndVisitPopUp();
        siteVisitSteps.clickOkInEndVisitPopUp();
        siteVisitSteps.checkLoading();

    }
}
