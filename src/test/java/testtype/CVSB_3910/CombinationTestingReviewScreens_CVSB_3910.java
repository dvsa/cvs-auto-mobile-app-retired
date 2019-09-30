package testtype.CVSB_3910;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.*;
import steps.composed.TestTypeCategoryComp;
import util.BaseTestClass;

@RunWith(SerenityRunner.class)
public class CombinationTestingReviewScreens_CVSB_3910 extends BaseTestClass {

    @Steps
    TestTypeCategoryComp testTypeCategoryComp;

    @Steps
    PreparerSteps preparerSteps;

    @Steps
    TestSteps testSteps;

    @Steps
    IdentifyTrailerSteps identifyTrailerSteps;

    @Steps
    TrailerDetailsSteps trailerDetailsSteps;

    @Steps
    CountryOfRegistrationSteps countryOfRegistrationSteps;

    @Steps
    EUVehicleCategorySteps euVehicleCategorySteps;

    @Steps
    OdometerReadingSteps odometerReadingSteps;

    @Steps
    TestTypeCategorySteps testTypeCategorySteps;

    @Steps
    TestReviewSteps testReviewSteps;

    @Steps
    ConfirmationPageSteps confirmationPageSteps;

    @Steps
    SiteVisitSteps siteVisitSteps;

    @Steps
    IdentifyVehicleSteps identifyVehicleSteps;

    @Steps
    TestHistorySteps testHistorySteps;

    @Steps
    TestHistoryDetailsSteps testHistoryDetailsSteps;

    @Title("CVSB-7506 - AC1 - Successfully navigating to 'Review' & review screens displaying in the correct order")
    @Test
    public void testConfirmationToSubmitResultsHgvTrl() {
        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("230123");
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();
        testSteps.checkHgvTestDetails("CT70VRL", "P012301230123");

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

        testSteps.checkAddATrailerButtonVisibility();
        testSteps.clickAddATrailerButton();
        identifyTrailerSteps.searchForTrailer("341234");
        trailerDetailsSteps.selectConfirmButtonTopRight();
        trailerDetailsSteps.selectConfirmFromPopUp();
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();

        testSteps.scrollDown();

        testSteps.clickCountryOfRegistrationFor("341234");
        countryOfRegistrationSteps.selectACountry("Norway");
        testSteps.checkCountryOfRegistrationFieldIsUpdatedFor("Norway", "341234");
        testSteps.clickEuVehicleCategoryFor("341234");
        euVehicleCategorySteps.selectOption("O2");
        testSteps.addTestTypeFor("341234");
        testTypeCategorySteps.selectFromTestTypeList("Annual test");

        testSteps.scrollDown();

        testSteps.checkAddATrailerButtonVisibility();
        testSteps.clickAddATrailerButton();
        identifyTrailerSteps.searchForTrailer("341237");
        trailerDetailsSteps.selectConfirmButtonTopRight();
        trailerDetailsSteps.selectConfirmFromPopUp();
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();

        testSteps.scrollDown();

//        testSteps.scrollThePageDownTo("EU vehicle category", 200);
//        testSteps.scrollThePageDownTo("C000002");

        testSteps.clickCountryOfRegistrationFor("341237");
        countryOfRegistrationSteps.selectACountry("Norway");
        testSteps.checkCountryOfRegistrationFieldIsUpdatedFor("Norway", "341237");
        testSteps.clickEuVehicleCategoryFor("341237");
        euVehicleCategorySteps.selectOption("O2");
        testSteps.addTestTypeFor("341237");
        testTypeCategorySteps.selectFromTestTypeList("Annual test");

        testSteps.reviewAction();
        testReviewSteps.scrollDown();
        testReviewSteps.checkElementIsDisplayed("Test review (1 of 3)");
        testReviewSteps.scrollDown();
        testReviewSteps.pressNextVehicle();
        testReviewSteps.checkElementIsDisplayed("Test review (2 of 3)");
        testReviewSteps.scrollDown();
        testReviewSteps.pressNextVehicle();
        testReviewSteps.checkElementIsDisplayed("Test review (3 of 3)");
        testReviewSteps.scrollDown();
        testReviewSteps.pressSubmitTests();
//        testReviewSteps.scrollDown();
//        testReviewSteps.pressSubmitTests();
        testReviewSteps.checkSubmitPopUp();
        testReviewSteps.pressSubmitInPopUp();
        confirmationPageSteps.pressDone();
//        siteVisitSteps.createNewTest();
//        identifyVehicleSteps.searchForVehicle("768594");
//        trailerDetailsSteps.selectTrailerTestHistory();
//        testHistorySteps.clickLastTestByTestType("Annual test");
//        testHistoryDetailsSteps.pressBackButton();
//        testHistorySteps.checkPage();
    }

}
