package launch.CVSB_985;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.LaunchSteps;
import steps.SearchForAnATFSteps;
import util.BaseTestClass;

@RunWith(SerenityRunner.class)
public class LaunchPage_CVSB_1424 extends BaseTestClass {

    @Steps
    LaunchSteps launchSteps;

    @Steps
    SearchForAnATFSteps searchForAnATFSteps;

    @Title("CVSB-985 - AC2 - VSA clicks on 'Get started button")
    @Test
    public void testAtfListAlphabeticallyOrdered() {
        launchSteps.clickGetStarted();
        searchForAnATFSteps.checkAtfPageDisplay();

    }
}
