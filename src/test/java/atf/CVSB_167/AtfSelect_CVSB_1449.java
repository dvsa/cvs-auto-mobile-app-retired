package atf.CVSB_167;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.ATFDetailsSteps;
import steps.LaunchSteps;
import steps.FindAnATFSteps;
import util.BaseTestClass;

@RunWith(SerenityRunner.class)
public class AtfSelect_CVSB_1449 extends BaseTestClass {

    @Steps
    LaunchSteps launchSteps;

    @Steps
    FindAnATFSteps findAnATFSteps;

    @Steps
    ATFDetailsSteps atfDetailsSteps;


    @Title("CVSB-167 - AC3 - VSA is able to return to the ATF search results")
    @Test
    public void testReturnToAtfSearch() {
        launchSteps.clickGetStarted();
        findAnATFSteps.waitForPageToLoadAndSelectAnAtf(atfService.getUniqueIdentifier(0));
        atfDetailsSteps.pressBackButton();
        findAnATFSteps.checkListIsAlphabeticallyOrdered();
    }
}
