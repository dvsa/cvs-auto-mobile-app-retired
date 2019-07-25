package testtype.CVSB_3912;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import pages.TestPage;
import steps.*;
import steps.composed.TestTypeCategoryComp;
import util.BaseTestClass;

@RunWith(SerenityRunner.class)
public class TrailerTest_CVSB3912 extends BaseTestClass {

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
    PreparerSteps preparerSteps;

    @Steps
    TrailerDetailsSteps trailerDetailsSteps;

    @Steps
    TestHistorySteps testHistorySteps;



    @Title("CVSB-3912 - Ability to access the test screen to complete a test for trailers")
    @Test
    public void testConfirmationToSubmitTestResults() {
        testTypeCategoryComp.goToTestPageBySelectingASpecificTrailer("768594");
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();
        testSteps.checkTrailerTestDetails("0285678", "T12768594");
        //TODO: Check that trailer icon is automatically updated.
        //testSteps.checkIfTrailerImageIsDisplayed();
        testSteps.checkEUVehicleCategoryOptionIsDisplayed();
        testSteps.selectVehicleCategoryOption();
        euVehicleCategorySteps.checkTitleIsDisplayed();
        euVehicleCategorySteps.checkOptionsForTrailerAreDisplayed();
        euVehicleCategorySteps.selectO1Option();
        testSteps.checkEUVehicleCategoryOptionIs("O1");

        testSteps.clickCountryOfRegistrationOption();
        countryOfRegistrationSteps.selectACountry("Norway");
        testSteps.checkCountryOfRegistrationFieldIsUpdated("Norway");

        testSteps.addTestType();
        testTypeCategorySteps.selectFromTestTypeList("Annual test");
        testSteps.selectTestType("Annual test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testSteps.checkTestTypeStatus("Annual test",TestPage.TestTypeStatuses.IN_PROGRESS );

        testSteps.selectVehicleDetails();
        trailerDetailsSteps.checkTrailerTestHistoryIsDisplayed();
        trailerDetailsSteps.selectTrailerTestHistory();
        testHistorySteps.checkPage();

    }
}
