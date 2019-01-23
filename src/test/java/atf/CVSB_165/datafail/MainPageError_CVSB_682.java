package atf.CVSB_165.datafail;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.ErrorSteps;
import steps.LaunchSteps;
import util.BaseTestClass;

@RunWith(SerenityRunner.class)
public class MainPageError_CVSB_682 extends BaseTestClass {

    @Steps
    LaunchSteps launchSteps;

    @Steps
    ErrorSteps errorSteps;


    @Title("CVSB-165 - TCA - AC6 - Technical support call")
    @Test
    public void testNoSearchResults() {
        launchSteps.waitUntilPageIsLoaded();
        errorSteps.clickCallTechSupport();
        //TODO: continue once aws deployed services are stopped and tested on real device
    }
}
