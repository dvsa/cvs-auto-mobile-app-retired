package testtype.CVSB_995;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.CountryOfRegistrationSteps;
import steps.TestSteps;
import steps.composed.TestTypeCategoryComp;
import util.BaseTestClass;

@RunWith(SerenityRunner.class)
public class VehicleCategoryCountryReg_2734 extends BaseTestClass {

    @Steps
    TestSteps testSteps;

    @Steps
    TestTypeCategoryComp testTypeCategoryComp;

    @Steps
    CountryOfRegistrationSteps countryOfRegistrationSteps;

    @Title("CVSB-995 - AC3 - Adding Country of Registration - search field cancel action")
    @Test
    public void addingCountryOfRegistrationCancelSearchAction() {
        testTypeCategoryComp.goToTestPage();
        testSteps.clickCountryOfRegistrationOption();
        countryOfRegistrationSteps.searchForCountry("Norway");
        countryOfRegistrationSteps.cancelSearchAction();
    }
}
