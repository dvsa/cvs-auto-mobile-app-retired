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
public class AtfSelect_CVSB_685 extends BaseTestClass {

    @Steps
    LaunchSteps launchSteps;

    @Steps
    FindAnATFSteps findAnATFSteps;


    @Title("CVSB-165 - Search field -pNumber")
    @Test
    public void testSearchFieldpNumber() {
        launchSteps.clickGetStarted();
        findAnATFSteps.searchForValidPNumberOrAddress(atfService.getAtfByIndex(3).getAtfNumber());
        findAnATFSteps.checkAddressAndPNumberIsFiltered(atfService.getUniqueIdentifier(3), atfService.getFirstLetter(3));
    }

}
