package atf.CVSB_165;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.LaunchSteps;
import steps.SearchForAnATFSteps;
import util.BaseTestClass;

@RunWith(SerenityRunner.class)
public class AtfSelect_CVSB_686 extends BaseTestClass {

    @Steps
    LaunchSteps launchSteps;

    @Steps
    SearchForAnATFSteps searchForAnATFSteps;

    @Ignore("CVSB-8749 - maintenance for improving test suite speed")
    @Title("CVSB-686 - Search field - Address")
    @Test
    public void testSearchFieldAddress() {
        launchSteps.clickGetStarted();
        searchForAnATFSteps.searchForValidPNumberOrAddress(atfService.getAtfByIndex(3).getAtfName());
        searchForAnATFSteps.checkAddressAndPNumberIsFiltered(atfService.getUniqueIdentifier(3), atfService.getFirstLetter(3));

    }
}
