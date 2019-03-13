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
public class MainPageError_CVSB_681_CVSB_684 extends BaseTestClass {
    @Steps
    LaunchSteps launchSteps;

    @Steps
    ErrorSteps errorSteps;


    @Title("CVSB-165 - AC5 - Process to retrieve relevant reference data fail")
    @Test
    public void testNoSearchResults() {
        launchSteps.waitUntilPageIsLoaded();
        errorSteps.checkAllGenericErrorMessageElementsAreDisplayed();
        launchSteps.resetAppAndWaitUntilPageIsLoaded();
        errorSteps.checkAllGenericErrorMessageElementsAreDisplayed();
    }
}
