package testresults.CVSB_495;

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
public class ReviewTestSummary_2701 extends BaseTestClass {

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

    @Steps
    TestReviewSteps testReviewSteps;

    @Steps
    TestTypeDetailsSteps testTypeDetailsSteps;

    @Steps
    SeatbeltInstallationCheckSteps seatbeltInstallationCheckSteps;

    @Title("CVSB-495 - AC1 - AC8 VSA goes to review screen (test types conducted non-mandatory fields not filled)")
    @Test
    public void goToReviewScreen() {
        testTypeCategoryComp.goToTestPage(preparerService.getPreparerByIndex(0).getPreparerId(), preparerService.getPreparerByIndex(0).getPreparerName());
        testSteps.clickCountryOfRegistrationOption();
        countryOfRegistrationSteps.selectACountry("Norway");
        testSteps.checkCountryOfRegistrationFieldIsUpdated("Norway");
        testSteps.selectVehicleCategoryOption();
        euVehicleCategorySteps.selectM1Option();
        testSteps.selectOdometerReading();
        odometerReadingSteps.typeInField("123");
        odometerReadingSteps.checkReadingValue("123");
        odometerReadingSteps.pressSave();
        testSteps.addTestType();
        testTypeCategorySteps.selectFromTestTypeList("Annual test");
        testSteps.selectTestType("Annual test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.setCarriedOutDuringTest(false);
        testTypeDetailsSteps.selectMostRecentInstallationCheck();
        testTypeDetailsSteps.setMostRecentInstallationCheckDateOneUnit();
        testTypeDetailsSteps.selectNumberOfSeatbeltsFitted();
        seatbeltInstallationCheckSteps.inputNumberOfSeatbelts("4");
        testTypeDetailsSteps.pressSave();
        testSteps.clickReview();
        testReviewSteps.checkPageTitleIsDisplayed();
        testReviewSteps.checkElementIsDisplayed("Annual test");
        testReviewSteps.checkElementIsDisplayed("PASS");
        testReviewSteps.checkElementIsDisplayed("Seatbelt installation check");
        testReviewSteps.checkElementIsDisplayed("No");
        testReviewSteps.checkElementIsDisplayed("Number of seatbelts fitted");
        testReviewSteps.checkElementIsDisplayed("4");
        testReviewSteps.checkElementIsDisplayed("Most recent seatbelt check");
       //TODO better check of none value
        testReviewSteps.checkElementIsDisplayed("Defects");
        testReviewSteps.checkElementIsDisplayed("Notes");
        testReviewSteps.checkElementIsDisplayed("None");
    }
}
