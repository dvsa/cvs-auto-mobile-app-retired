package atf.CVSB_165;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.core.annotations.WithTag;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.LaunchSteps;
import steps.SearchForAnATFSteps;
import steps.util.UtilSteps;
import util.BaseTestClass;


@RunWith(SerenityRunner.class)
public class AtfSelect_CVSB_769 extends BaseTestClass {

    @Steps
    UtilSteps utilSteps;

    @Steps
    LaunchSteps launchSteps;

    @Steps
    SearchForAnATFSteps searchForAnATFSteps;


    @Title("CVSB-165 - Search for ATF option and list of ATFs")
    @WithTag("Smoke_2")
    @Test
    public void testAtfListAndSearchOption() {
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        launchSteps.clickGetStarted(super.username);
        searchForAnATFSteps.checkATFSearchButtonAndList(atfService.getUniqueIdentifier(0), atfService.getUniqueIdentifier(1), atfService.getFirstLetter(2));
    }
}
