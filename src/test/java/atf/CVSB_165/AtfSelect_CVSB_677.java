package atf.CVSB_165;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.LaunchSteps;
import steps.FindAnATFSteps;
import util.BaseTestClass;

@RunWith(SerenityRunner.class)
public class AtfSelect_CVSB_677 extends BaseTestClass {

    @Steps
    LaunchSteps launchSteps;

    @Steps
    FindAnATFSteps findAnATFSteps;


    @Title("CVSB-165 - AC1 - ATF's scrollable list")
    @Test
    public void testAtfListScrollable() {
        launchSteps.clickGetStarted();
        findAnATFSteps.checkListIsScrollableByElement(atfService.getUniqueIdentifier(0));
    }
}
