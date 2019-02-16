package testtype.CVSB_995;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.CountryOfRegisdtrationSteps;
import steps.EUVehicleCategorySteps;
import steps.TestSteps;
import steps.composed.TestTypeCategoryComp;
import util.BaseTestClass;

@RunWith(SerenityRunner.class)
public class VehicleCategoryCountryReg_2672 extends BaseTestClass {

    @Steps
    TestSteps testSteps;

    @Steps
    TestTypeCategoryComp testTypeCategoryComp;

    @Steps
    EUVehicleCategorySteps euVehicleCategorySteps;

    @Steps
    CountryOfRegisdtrationSteps countryOfRegisdtrationSteps;

    @Title("CVSB-995 - AC1 - Record fields on test overview screen")
    @Test
    public void recordFieldsOnTestOverviewScreen() {
        testTypeCategoryComp.goToTestPage();
        testSteps.checkCountryOfregistrationOptionIsDisplayed();
        testSteps.checkEUVehicleCategoryOptionIsDisplayed();
        testSteps.selectVehicleCategoryOption();
        euVehicleCategorySteps.clickSaveOptionButton();
        testSteps.clickCountryOfRegistrationOption();
        countryOfRegisdtrationSteps.saveRegistrationCountry();
    }
}
