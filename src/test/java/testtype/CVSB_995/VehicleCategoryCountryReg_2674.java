package testtype.CVSB_995;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.CountryOfRegistrationSteps;
import steps.TestSteps;
import steps.composed.TestTypeCategoryComp;
import util.BaseTestClass;

@RunWith(SerenityRunner.class)
public class VehicleCategoryCountryReg_2674 extends BaseTestClass {

    @Steps
    TestSteps testSteps;

    @Steps
    TestTypeCategoryComp testTypeCategoryComp;

    @Steps
    CountryOfRegistrationSteps countryOfRegistrationSteps;

    @Ignore("CVSB-8749 - maintenance for improving test suite speed")
    @Title("CVSB-995 - AC3 - Adding Country of Registration - the list is scrollable")
    @Test
    public void listOfCountriesIsScrollable() {
        testTypeCategoryComp.goToTestPage(preparerService.getPreparerByIndex(0).getPreparerId(), preparerService.getPreparerByIndex(0).getPreparerName());
        testSteps.clickCountryOfRegistrationOption();
        countryOfRegistrationSteps.scrollThroughList();
        countryOfRegistrationSteps.optionsAreDisplayedAtTopAndBottomAfterSearch("Romania");
    }
}
