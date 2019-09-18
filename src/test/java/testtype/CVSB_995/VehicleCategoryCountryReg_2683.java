package testtype.CVSB_995;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.*;
import steps.composed.TestTypeCategoryComp;
import util.BaseTestClass;

@RunWith(SerenityRunner.class)
public class VehicleCategoryCountryReg_2683 extends BaseTestClass {

    @Steps
    TestSteps testSteps;

    @Steps
    TestTypeCategorySteps testTypeCategorySteps;

    @Steps
    TestTypeCategoryComp testTypeCategoryComp;

    @Steps
    EUVehicleCategorySteps euVehicleCategorySteps;

    @Steps
    CountryOfRegistrationSteps countryOfRegistrationSteps;

    @Steps
    OdometerReadingSteps odometerReadingSteps;

    @Title("CVSB-995 - AC9 - Fields that are mandatory")
    @Test
    @Ignore
    // TODO
    // Temporarily disabled.  This is checking for the new updated error message format, before the functionality has been merged into the app.
    public void checkFieldsThatAreMandatory() {
        testTypeCategoryComp.goToTestPage(preparerService.getPreparerByIndex(0).getPreparerId(), preparerService.getPreparerByIndex(0).getPreparerName());
        testSteps.clickCountryOfRegistrationOption();
        countryOfRegistrationSteps.selectACountry("Norway");
        testSteps.checkCountryOfRegistrationFieldIsUpdated("Norway");
        testSteps.selectVehicleCategoryOption();
        euVehicleCategorySteps.selectM1Option();
        testSteps.selectOdometerReading();
        odometerReadingSteps.typeInField("12345678");
        odometerReadingSteps.checkReadingValue("1234567");
        odometerReadingSteps.pressSave();
        testSteps.checkOdometerReadingValueFormatted("1,234,567");
        testSteps.addTestType();
        testTypeCategorySteps.selectFromTestTypeList("annual test");
        testSteps.clickReview();
        testSteps.checkErrorMessageMandatoryFieldsDisplayed();
        testSteps.checkTestNotCompleteDisplayedAndOkButton();
    }
}
