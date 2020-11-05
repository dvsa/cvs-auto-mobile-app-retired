package appstates.CVSB_469;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.*;
import util.BaseTestClass;
import util.TestHandler;

@Ignore
@RunWith(SerenityRunner.class)
public class AppState_CVSB_1938 extends BaseTestClass {

    @Steps
    LaunchSteps launchSteps;

    @Steps
    CommonSteps commonSteps;

    @Steps
    SearchForAnATFSteps searchForAnATFSteps;

    @Steps
    ATFDetailsSteps atfDetailsSteps;

    @Steps
    SiteVisitSteps siteVisitSteps;

    @Before
    public void goEnable() {
        TestHandler.testTypeEnabledCached().set(true);
    }

    @After
    public void tearDown() {
        TestHandler.testTypeEnabledCached().set(false);
    }

    @Ignore("[CVSB-8289] Removing test to improve overall efficiency of the mobile app Front-end automation test suite.")
    @Title("CVSB-469 - AC3 Reopen the app after it was closed - redirected to visit timeline screen (ex. app closed by the user, app closed by the device, device turned off)")
    public void testAppStateCloseAfterStartVisit() {

        launchSteps.clickGetStarted(super.username);
        searchForAnATFSteps.waitForPageToLoadAndSelectAnAtf(atfService.getUniqueIdentifier(0));
        atfDetailsSteps.startVisit();
        siteVisitSteps.waitUntilPageIsLoaded();
        commonSteps.getPage().closeAndLaunchApp();
        siteVisitSteps.waitUntilPageIsLoaded();

        siteVisitSteps.completeEndVisit();

    }

}
