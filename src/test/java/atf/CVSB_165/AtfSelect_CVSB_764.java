package atf.CVSB_165;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.core.annotations.WithTag;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.LaunchSteps;
import steps.SearchForAnATFSteps;
import util.BaseTestClass;

@Ignore
@RunWith(SerenityRunner.class)
public class AtfSelect_CVSB_764 extends BaseTestClass {

    @Steps
    LaunchSteps launchSteps;

    @Steps
    SearchForAnATFSteps searchForAnATFSteps;

    @Title("CVSB-165 - Search field - properties")
    // De-scoped due to: CVSB-12952: VTA FE Maintenance - increasing suite efficiency
    public void searchFieldProperties() {
        launchSteps.clickGetStarted(super.username);
        searchForAnATFSteps.searchAndVerifyForLongAlphanumericNumber();
    }
}
