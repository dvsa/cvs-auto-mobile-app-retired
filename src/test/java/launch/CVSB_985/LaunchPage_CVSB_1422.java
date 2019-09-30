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

@RunWith(SerenityRunner.class)
public class LaunchPage_CVSB_1422 extends BaseTestClass {

        @Steps
        LaunchSteps launchSteps;

        @Steps
        SearchForAnATFSteps searchForAnATFSteps;

        @Ignore("[CVSB-8289] Removing test to improve overall efficiency of the mobile app Front-end automation test suite.")
        @Title("CVSB-985 - AC1 - VSA is taken to the first screen of the app")
        @Test
        public void testAtfListAlphabeticallyOrdered() {
            launchSteps.clickGetStarted();
            searchForAnATFSteps.checkATFSearchButtonAndList(atfService.getUniqueIdentifier(0),atfService.getUniqueIdentifier(1), atfService.getFirstLetter(0));
            searchForAnATFSteps.checkListIsAlphabeticallyOrdered();
        }
}
