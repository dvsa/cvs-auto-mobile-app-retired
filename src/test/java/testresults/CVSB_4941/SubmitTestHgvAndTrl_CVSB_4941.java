package testresults.CVSB_4941;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.*;
import steps.composed.TestTypeCategoryComp;
import util.BaseTestClass;

@RunWith(SerenityRunner.class)
public class SubmitTestHgvAndTrl_CVSB_4941 extends BaseTestClass {

    @Steps
    TestSteps testSteps;

    @Steps
    TestTypeCategoryComp testTypeCategoryComp;

    @Steps
    TestTypeCategorySteps testTypeCategorySteps;

    @Steps
    CountryOfRegistrationSteps countryOfRegistrationSteps;

    @Steps
    EUVehicleCategorySteps euVehicleCategorySteps;

    @Steps
    OdometerReadingSteps odometerReadingSteps;

    @Steps
    TestReviewSteps testReviewSteps;

    @Steps
    PreparerSteps preparerSteps;

    @Steps
    SeatbeltInstallationCheckSteps seatbeltInstallationCheckSteps;

    @Steps
    SiteVisitSteps siteVisitSteps;

    @Steps
    IdentifyVehicleSteps identifyVehicleSteps;

    @Steps
    VehicleDetailsSteps vehicleDetailsSteps;

    @Steps
    TestHistorySteps testHistorySteps;

    @Steps
    TestHistoryDetailsSteps testHistoryDetailsSteps;

    @Steps
    ConfirmationPageSteps confirmationPageSteps;

    @Steps
    ATFDetailsSteps atfDetailsSteps;

    @Steps
    TrailerDetailsSteps trailerDetailsSteps;

    @Steps
    IdentifyTrailerSteps identifyTrailerSteps;

    @Title("CVSB-7313 - AC1 - VSA is presented with a confirmation to submit test results - HGV")
    @Test
    public void testConfirmationToSubmitResultsHgv() {
        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("230123");
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();
        testSteps.checkHgvTestDetails("CT70VRL", "P012301230123");
        testSteps.clickCountryOfRegistrationOption();
        countryOfRegistrationSteps.selectACountry("Norway");
        testSteps.checkCountryOfRegistrationFieldIsUpdated("Norway");
        testSteps.selectVehicleCategoryOption();
        euVehicleCategorySteps.selectOption("N1");
        testSteps.selectOdometerReading();
        odometerReadingSteps.typeInField("123");
        odometerReadingSteps.checkReadingValue("123");
        odometerReadingSteps.pressSave();
        testSteps.addTestType();
        testTypeCategorySteps.selectFromTestTypeList("Annual test");
        testSteps.clickReview();
        testReviewSteps.checkPageTitleIsDisplayed();
        testReviewSteps.scrollDown();
        testReviewSteps.pressSubmit();
        testReviewSteps.checkSubmitPopUp();
        testReviewSteps.pressSubmitInPopUp();
        confirmationPageSteps.pressDone();
        siteVisitSteps.createNewTest();
        identifyVehicleSteps.searchForVehicle("230123");
        vehicleDetailsSteps.selectVehicleTestHistory();
        testHistorySteps.clickLastTestByTestType("Annual test");
        testHistoryDetailsSteps.pressBackButton();
        testHistorySteps.checkPage();
    }

    @Title("CVSB-7424 - AC4 - Submit a test for TRL")
    @Test
    public void testConfirmationToSubmitResultsTrl() {
        testTypeCategoryComp.goToTestPageBySelectingASpecificTrailer("768594");
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();
        testSteps.checkTrailerTestDetails("0285678", "T12768594");
        testSteps.clickCountryOfRegistrationOption();
        countryOfRegistrationSteps.selectACountry("Norway");
        testSteps.checkCountryOfRegistrationFieldIsUpdated("Norway");
        testSteps.selectEuVehicleCategory();
        euVehicleCategorySteps.selectOption("O2");
        testSteps.addTestType();
        testTypeCategorySteps.selectFromTestTypeList("Annual test");
        testSteps.clickReview();
        testReviewSteps.checkPageTitleIsDisplayed();
        testReviewSteps.scrollDown();
        testReviewSteps.pressSubmit();
        testReviewSteps.checkSubmitPopUp();
        testReviewSteps.pressSubmitInPopUp();
        confirmationPageSteps.pressDone();
        siteVisitSteps.createNewTest();
        identifyVehicleSteps.searchForVehicle("768594");
        trailerDetailsSteps.selectTrailerTestHistory();
        testHistorySteps.clickLastTestByTestType("Annual test");
        testHistoryDetailsSteps.pressBackButton();
        testHistorySteps.checkPage();
    }

    @Title("CVSB-7425 - AC4 -Submit a test for a HGV and TRL")
    @Test
    public void testConfirmationToSubmitResultsHgvTrl() {
        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("230123");
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();
        testSteps.checkHgvTestDetails("CT70VRL", "P012301230123");
        testSteps.checkAddATrailerButtonVisibility();
        testSteps.clickAddATrailerButton();
        identifyTrailerSteps.searchForTrailer("768594");
        trailerDetailsSteps.selectConfirmButtonTopRight();
        trailerDetailsSteps.selectConfirmFromPopUp();
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();
        testSteps.clickCountryOfRegistrationFor("230123");
        countryOfRegistrationSteps.selectACountry("Norway");
        testSteps.checkCountryOfRegistrationFieldIsUpdatedFor("Norway", "230123");
        testSteps.clickEuVehicleCategoryFor("230123");
        euVehicleCategorySteps.selectOption("N2");
        testSteps.clickOdometerReadingFor("230123");
        odometerReadingSteps.typeInField("123");
        odometerReadingSteps.checkReadingValue("123");
        odometerReadingSteps.pressSave();
        testSteps.addTestTypeFor("230123");
        testTypeCategorySteps.selectFromTestTypeList("Annual test");
        testSteps.scrollDown();
        testSteps.clickCountryOfRegistrationFor("768594");
        countryOfRegistrationSteps.selectACountry("Norway");
        testSteps.checkCountryOfRegistrationFieldIsUpdatedFor("Norway", "768594");
        testSteps.clickEuVehicleCategoryFor("768594");
        euVehicleCategorySteps.selectOption("O2");
        testSteps.addTestTypeFor("768594");
        testTypeCategorySteps.selectFromTestTypeList("Annual test");
        testSteps.clickReview();
        testReviewSteps.scrollDown();
        testReviewSteps.pressNextVehicle();
        testReviewSteps.scrollDown();
        testReviewSteps.pressSubmitTests();
        testReviewSteps.checkSubmitPopUp();
        testReviewSteps.pressSubmitInPopUp();
        confirmationPageSteps.pressDone();
        //TODO the confirmation response comes for each of the vehicle tested, uncomment when/if it will be fixed
//        siteVisitSteps.createNewTest();
//        identifyVehicleSteps.searchForVehicle("768594");
//        trailerDetailsSteps.selectTrailerTestHistory();
//        testHistorySteps.clickLastTestByTestType("Annual test");
//        testHistoryDetailsSteps.pressBackButton();
//        testHistorySteps.checkPage();
    }

}
