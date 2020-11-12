package launch.CVSB_985;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.LaunchSteps;
import steps.SearchForAnATFSteps;
import util.BaseTestClass;

@Ignore
@RunWith(SerenityRunner.class)
public class LaunchPage_CVSB_1424 extends BaseTestClass {

    @Steps
    LaunchSteps launchSteps;

    @Steps
    SearchForAnATFSteps searchForAnATFSteps;

    @Ignore("[CVSB-8289] Removing test to improve overall efficiency of the mobile app Front-end automation test suite.")
    @Title("CVSB-985 - AC2 - VSA clicks on 'Get started button")
    public void testAtfListAlphabeticallyOrdered() {
        launchSteps.clickGetStarted(super.username);
        searchForAnATFSteps.checkAtfPageDisplay();

    }
}
