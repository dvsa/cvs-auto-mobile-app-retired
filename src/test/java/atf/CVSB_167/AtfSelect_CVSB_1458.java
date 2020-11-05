package atf.CVSB_167;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.ATFDetailsSteps;
import steps.LaunchSteps;
import steps.SearchForAnATFSteps;
import util.BaseTestClass;

@Ignore
@RunWith(SerenityRunner.class)
public class AtfSelect_CVSB_1458 extends BaseTestClass {

    @Steps
    LaunchSteps launchSteps;

    @Steps
    SearchForAnATFSteps searchForAnATFSteps;

    @Steps
    ATFDetailsSteps atfDetailsSteps;


    @Ignore("CVSB-8749 - maintenance for improving test suite speed")
    @Title("CVSB-167 - AC7 - VSA presses 'Cancel' on confirmation message")
    public void testCancelConfirmation() {
        launchSteps.clickGetStarted(super.username);
        searchForAnATFSteps.waitForPageToLoadAndSelectAnAtf(atfService.getUniqueIdentifier(0));
        atfDetailsSteps.pressStartVisit();
        atfDetailsSteps.checkStartVisitPopUp();
        atfDetailsSteps.pressCancelInStartVisitPopUp();
        atfDetailsSteps.checkStartVisitPopUpIsNotDisplayed();
    }
}
