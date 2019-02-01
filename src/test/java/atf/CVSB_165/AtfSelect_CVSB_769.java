package atf.CVSB_165;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.LaunchSteps;
import steps.SearchForAnATFSteps;
import util.BaseTestClass;

@RunWith(SerenityRunner.class)
public class AtfSelect_CVSB_769 extends BaseTestClass {

    @Steps
    LaunchSteps launchSteps;

    @Steps
    SearchForAnATFSteps searchForAnATFSteps;


    @Title("CVSB-165 - Search for ATF option and list of ATFs")
    @Test
    public void testAtfListAndSearchOption() {
        launchSteps.clickGetStarted();
        searchForAnATFSteps.checkATFSearchButtonAndList(atfService.getUniqueIdentifier(0), atfService.getUniqueIdentifier(1), atfService.getFirstLetter(2));
    }
}
