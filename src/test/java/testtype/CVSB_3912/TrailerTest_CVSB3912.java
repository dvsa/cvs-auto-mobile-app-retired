package testtype.CVSB_3912;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import pages.TestPage;
import steps.*;
import steps.composed.TestTypeCategoryComp;
import steps.util.UtilSteps;
import util.BaseTestClass;

@Ignore
@RunWith(SerenityRunner.class)
public class TrailerTest_CVSB3912 extends BaseTestClass {

    @Steps
    UtilSteps utilSteps;

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


    @Ignore("CVSB-8749 - maintenance for improving test suite speed")
    @Title("CVSB-3912 - Ability to access the test screen to complete a test for trailers")
    public void testConfirmationToSubmitTestResults() {
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        testTypeCategoryComp.goToTestPageBySelectingASpecificTrailer("768594",super.username);
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
        testSteps.checkTestTypeStatus("Annual test",TestPage.TestTypeStatuses.EDIT );
        testSteps.selectVehicleDetails();
        trailerDetailsSteps.checkTrailerTestHistoryIsDisplayed();
        trailerDetailsSteps.selectTrailerTestHistory();
        testHistorySteps.checkPage();

    }
}
