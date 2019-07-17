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
public class AtfSelect_CVSB_679 extends BaseTestClass {

    @Steps
    LaunchSteps launchSteps;

    @Steps
    FindAnATFSteps findAnATFSteps;


    @Title("CVSB-165 - AC3 - No search results")
    @Test
    public void testNoSearchResults() {
        launchSteps.clickGetStarted();
        findAnATFSteps.searchForInvalidAtf();
        findAnATFSteps.checkNoResultsFoundAndSuggestion();
    }
}
