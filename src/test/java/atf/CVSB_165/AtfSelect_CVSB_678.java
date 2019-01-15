package atf.CVSB_165;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.ATFDetailsSteps;
import steps.LaunchSteps;
import steps.SearchForAnATFSteps;
import util.BaseTestClass;

@RunWith(SerenityRunner.class)
public class AtfSelect_CVSB_678 extends BaseTestClass {

    @Steps
    LaunchSteps launchSteps;

    @Steps
    SearchForAnATFSteps searchForAnATFSteps;

    @Steps
    ATFDetailsSteps atfDetailsSteps;


    @Title("CVSB-165 - AC2 - Select an ATF from the list in alphabetical order")
    @Test
    public void testAtfListAlphabeticallyOrdered() {
        launchSteps.clickGetStarted();
        searchForAnATFSteps.checkListIsAlphabeticallyOrdered();
        searchForAnATFSteps.waitForPageToLoadAndSelectAnAtf("Abshire-Kub 09-4129632");
        atfDetailsSteps.waitUntilPageIsLoaded();
    }
}
