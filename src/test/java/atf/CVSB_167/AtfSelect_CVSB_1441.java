package atf.CVSB_167;

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
public class CVSB_1441 extends BaseTestClass {

    @Steps
    LaunchSteps launchSteps;

    @Steps
    SearchForAnATFSteps searchForAnATFSteps;


    @Title("CVSB-165 - AC1 - ATF's scrollable list")
    @Test
    public void testAtfListScrollable() {
        launchSteps.clickGetStarted();
        searchForAnATFSteps.checkListIsScrollableByElement("Abshire-Kub 09-4129632");
    }
}
