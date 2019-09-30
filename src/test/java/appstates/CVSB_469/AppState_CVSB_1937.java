package appstates.CVSB_469;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.*;
import util.BaseTestClass;

@RunWith(SerenityRunner.class)
public class AppState_CVSB_1937 extends BaseTestClass {

    @Steps
    LaunchSteps launchSteps;

    @Steps
    CommonSteps commonSteps;

    @Steps
    SearchForAnATFSteps searchForAnATFSteps;


    @Ignore("[CVSB-8289] Removing test to improve overall efficiency of the mobile app Front-end automation test suite.")
    @Title("CVSB-469 - AC2 Reopen the app after it was closed - redirected to the homepage screen (ex. app closed by the user, app closed by the device, device turned off)")
    @Test
    public void testAppStateCloseAtSearchForAtfPage() {
        launchSteps.clickGetStarted();
        searchForAnATFSteps.waitForPageToLoadAndSelectAnAtf(atfService.getUniqueIdentifier(0));
        commonSteps.getPage().closeAndLaunchApp();
        launchSteps.clickGetStarted();
        searchForAnATFSteps.waitForPageToLoadAndSelectAnAtf(atfService.getUniqueIdentifier(0));

    }


}
