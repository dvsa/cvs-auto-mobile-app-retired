package sitevisit.CVSB_3908;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.core.annotations.WithTagValuesOf;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.Description;
import steps.*;
import steps.composed.TestTypeCategoryComp;
import util.BaseTestClass;

@RunWith(SerenityRunner.class)
public class CombinationTesting_SiteVisitTimeline_7502 extends BaseTestClass {

    @Steps
    TestTypeCategoryComp testTypeCategoryComp;

    @Steps
    TestSteps testSteps;

    @Steps
    TestTypeDetailsSteps testTypeDetailsSteps;

    @Steps
    TestTypeCategorySteps testTypeCategorySteps;

    @Steps
    TestReviewSteps testReviewSteps;

    @Steps
    SiteVisitSteps siteVisitSteps;

    @Steps
    OdometerReadingSteps odometerReadingSteps;

    @Steps
    EUVehicleCategorySteps euVehicleCategorySteps;

    @Steps
    PreparerSteps preparerSteps;

    @Steps
    IdentifyTrailerSteps identifyTrailerSteps;

    @Steps
    TrailerDetailsSteps trailerDetailsSteps;

    @Steps
    ConfirmationPageSteps confirmationPageSteps;

    @WithTagValuesOf({"Smoke_1", "Smoke_2"})
    @Title("CVSB-3908 - CVSB-3910 - Accept max 4 vehicles ")
    @Description(
            "CVSB-3908: \n" +
                "AC1 + AC2 Accept max 4 vehicles (1 HGV + 3 TRL) in one test and vehicles in proper order on the site visit timeline page \n" +
            "CVSB-3910: \n" +
                "AC1 Successfully navigating to 'Review' & review screens displaying in the correct order \n" +
                "AC2 Vehicle cards & field iterations \n" +
                "AC3 Navigating back to the test screen after triggering the 'Change details' call to action for vehicle \n" +
                "AC4 Navigating back to the test screen after triggering the 'Change details' call to action for test \n" +
                "AC5 Successful navigation to the previous vehicle \n" +
                "AC6 Successful submission \n"
    )
    @Test
    public void testSiteVisitTimelineHGVPlus3TRL() {
        //add hgv
        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("P012301230123");
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();
        testSteps.selectVehicleCategoryOption();
        euVehicleCategorySteps.selectOption("N2");
        testSteps.selectOdometerReading();
        odometerReadingSteps.typeInField("123");
        odometerReadingSteps.checkReadingValue("123");
        odometerReadingSteps.pressSave();
        testSteps.waitUntilPageIsLoaded();
        testSteps.addTestTypeFor("P012301230123");
        testTypeCategorySteps.selectFromTestTypeList("Annual test");
        //add first trailer
        testSteps.scrollDown();
        testSteps.clickAddATrailerButton();
        identifyTrailerSteps.searchForTrailer("T72741234");
        trailerDetailsSteps.selectConfirmButtonTopRight();
        trailerDetailsSteps.selectConfirmFromPopUp();
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();
        testSteps.waitUntilPageIsLoaded();
        testSteps.scrollDown();
        testSteps.clickEuVehicleCategoryFor("T72741234");
        euVehicleCategorySteps.selectOption("O1");
        testSteps.waitUntilPageIsLoaded();
        testSteps.addTestTypeFor("T72741234");
        testTypeCategorySteps.selectFromTestTypeList("Annual test");
        //add second trailer
        testSteps.scrollDown();
        testSteps.clickAddATrailerButton();
        identifyTrailerSteps.searchForTrailer("T12341234");
        trailerDetailsSteps.selectConfirmButtonTopRight();
        trailerDetailsSteps.selectConfirmFromPopUp();
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();
        testSteps.waitUntilPageIsLoaded();
        testSteps.scrollDown();
        testSteps.clickEuVehicleCategoryFor("T12341234");
        euVehicleCategorySteps.selectOption("O2");
        testSteps.waitUntilPageIsLoaded();
        testSteps.addTestTypeFor("T12341234");
        testTypeCategorySteps.selectFromTestTypeList("Annual test");
        //add third trailer
        testSteps.scrollDown();
        testSteps.clickAddATrailerButton();
        identifyTrailerSteps.searchForTrailer("T12341237");
        trailerDetailsSteps.selectConfirmButtonTopRight();
        trailerDetailsSteps.selectConfirmFromPopUp();
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();
        testSteps.waitUntilPageIsLoaded();
        testSteps.scrollDown();
        testSteps.clickEuVehicleCategoryFor("T12341237");
        euVehicleCategorySteps.selectOption("O3");
        testSteps.waitUntilPageIsLoaded();
        testSteps.addTestTypeFor("T12341237");
        testTypeCategorySteps.selectFromTestTypeList("Annual test");
        testSteps.checkAddATrailerButtonIsNotPresent();
        //submit and review tests
        testSteps.checkReviewAndSubmitButton();
        testSteps.clickReviewAndSubmit();
        //check hgv test
        testReviewSteps.checkElementIsDisplayed("Test review (1 of 4)");
        testReviewSteps.checkElementIsDisplayed("P012301230123");
        testReviewSteps.scrollDown();
        testReviewSteps.pressNextVehicle();
        //check first trailer test
        testReviewSteps.checkElementIsDisplayed("Test review (2 of 4)");
        testReviewSteps.checkElementIsDisplayed("T72741234");
        //go back to hgv test
        testReviewSteps.goToPreviousVehicle();
        testReviewSteps.checkElementIsDisplayed("Test review (1 of 4)");
        testReviewSteps.checkElementIsDisplayed("P012301230123");
        //change vehicle category for hgv
        testReviewSteps.changeVehicleDetails();
        testSteps.selectEuVehicleCategory();
        euVehicleCategorySteps.selectOption("N2");
        testSteps.checkReviewAndSubmitButton();
        testSteps.clickReviewAndSubmit();
        //check hgv test
        testReviewSteps.checkElementIsDisplayed("Test review (1 of 4)");
        testReviewSteps.checkElementIsDisplayed("P012301230123");
        testReviewSteps.checkElementIsDisplayed("N2");
        //change notes on hgv test
        testReviewSteps.changeTestDetails();
        testTypeDetailsSteps.addNotes("Automation");
        testTypeDetailsSteps.pressSave();
        testReviewSteps.checkElementIsDisplayed("Automation");
        testReviewSteps.scrollDown();
        testReviewSteps.pressNextVehicle();
        //check first trailer test
        testReviewSteps.checkElementIsDisplayed("Test review (2 of 4)");
        testReviewSteps.checkElementIsDisplayed("T72741234");
        testReviewSteps.scrollDown();
        testReviewSteps.pressNextVehicle();
        //check second trailer test
        testReviewSteps.checkElementIsDisplayed("Test review (3 of 4)");
        testReviewSteps.checkElementIsDisplayed("T12341234");
        testReviewSteps.scrollDown();
        testReviewSteps.pressNextVehicle();
        //check third trailer test
        testReviewSteps.checkElementIsDisplayed("Test review (4 of 4)");
        testReviewSteps.checkElementIsDisplayed("T12341237");
        testReviewSteps.scrollDown();
        //submit combined test
        testReviewSteps.pressSubmitTests();
        testReviewSteps.pressSubmitInPopUp();
        confirmationPageSteps.pressDone();
        siteVisitSteps.waitUntilPageIsLoaded();
        //validate order in site visit timeline
        siteVisitSteps.checkVehiclePosition("CT70VRL",0);
        siteVisitSteps.checkVehiclePosition("C100001",1);
        siteVisitSteps.checkVehiclePosition("C000001",2);
        siteVisitSteps.checkVehiclePosition("C000002",3);
    }
}
