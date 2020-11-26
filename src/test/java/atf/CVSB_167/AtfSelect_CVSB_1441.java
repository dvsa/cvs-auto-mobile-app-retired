package atf.CVSB_167;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.ATFDetailsSteps;
import steps.LaunchSteps;
import steps.SearchForAnATFSteps;
import steps.util.UtilSteps;
import utils.BaseTestClass;

@RunWith(SerenityRunner.class)
public class AtfSelect_CVSB_1441 extends BaseTestClass {

    @Steps
    UtilSteps utilSteps;

    @Steps
    LaunchSteps launchSteps;

    @Steps
    SearchForAnATFSteps searchForAnATFSteps;

    @Steps
    ATFDetailsSteps atfDetailsSteps;


    @Title("CVSB-167 - AC1 - VSA is able to view ATF details screen")
    @Test
    public void testAtfDetailScreen() {
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        launchSteps.clickGetStarted(super.username);
        searchForAnATFSteps.waitForPageToLoadAndSelectAnAtf(atfService.getUniqueIdentifier(0));
        atfDetailsSteps.checkAtfDetails(atfService.getAtfByIndex(0).getAtfName(), atfService.getAtfByIndex(0).getAtfNumber(),
                atfService.getAtfByIndex(0).getAtfAddress(), atfService.getAtfByIndex(0).getAtfContactNumber());
    }
}
