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
public class AtfSelect_CVSB_686 extends BaseTestClass {

    @Steps
    LaunchSteps launchSteps;

    @Steps
    FindAnATFSteps findAnATFSteps;

    @Title("CVSB-686 - Search field - Address")
    @Test
    public void testSearchFieldAddress() {
        launchSteps.clickGetStarted();
        findAnATFSteps.searchForValidPNumberOrAddress(atfService.getAtfByIndex(3).getAtfName());
        findAnATFSteps.checkAddressAndPNumberIsFiltered(atfService.getUniqueIdentifier(3), atfService.getFirstLetter(3));

    }
}
