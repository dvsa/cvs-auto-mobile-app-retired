package launch.CVSB_985;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import steps.LaunchSteps;
import steps.SearchForAnATFSteps;
import utils.BaseTestClass;

@Ignore
@RunWith(SerenityRunner.class)
public class LaunchPage_CVSB_1427 extends BaseTestClass {

    @Steps
    LaunchSteps launchSteps;

    @Steps
    SearchForAnATFSteps searchForAnATFSteps;

    @Ignore("[CVSB-8289] Removing test to improve overall efficiency of the mobile app Front-end automation test suite.")
    @Title("CVSB-985 - AC3 - VSA goes 'Back' from 'Find an ATF' screen")
    public void testAtfListAlphabeticallyOrdered() {
        launchSteps.clickGetStarted(super.username);
        searchForAnATFSteps.checkAtfPageDisplay();
        searchForAnATFSteps.clickBackButton();
        launchSteps.clickStartButton();
        searchForAnATFSteps.checkAtfPageDisplay();
    }
}