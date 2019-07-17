package launch.CVSB_985;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.LaunchSteps;
import steps.FindAnATFSteps;
import util.BaseTestClass;

@RunWith(SerenityRunner.class)
public class LaunchPage_CVSB_1427 extends BaseTestClass {

    @Steps
    LaunchSteps launchSteps;

    @Steps
    FindAnATFSteps findAnATFSteps;

    @Title("CVSB-985 - AC3 - VSA goes 'Back' from 'Find an ATF' screen")
    @Test
    public void testAtfListAlphabeticallyOrdered() {
        launchSteps.clickGetStarted();
        findAnATFSteps.checkAtfPageDisplay();
        findAnATFSteps.clickBackButton();
        launchSteps.clickStartButton();
        findAnATFSteps.checkAtfPageDisplay();
    }
}