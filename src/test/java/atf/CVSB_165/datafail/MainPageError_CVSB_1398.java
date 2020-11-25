package atf.CVSB_165.datafail;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.ErrorSteps;
import steps.LaunchSteps;
import steps.util.UtilSteps;
import util.BaseTestClass;

@RunWith(SerenityRunner.class)
public class MainPageError_CVSB_1398 extends BaseTestClass {
    @Steps
    UtilSteps utilSteps;

    @Steps
    LaunchSteps launchSteps;

    @Steps
    ErrorSteps errorSteps;


    @Title("CVSB-165 - Loading icon and error prompt")
    @Test
    public void testNoSearchResults() {
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        launchSteps.waitUntilPageIsLoaded();
        errorSteps.checkAllGenericErrorMessageElementsAreDisplayed();
        errorSteps.clickTryAgain();
        errorSteps.checkLoadingIsDisplayed();
        errorSteps.checkAllGenericErrorMessageElementsAreDisplayed();
    }
}
