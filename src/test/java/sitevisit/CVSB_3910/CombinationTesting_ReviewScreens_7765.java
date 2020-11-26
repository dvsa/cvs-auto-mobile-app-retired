package sitevisit.CVSB_3910;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import pages.TestPage;
import steps.*;
import steps.composed.TestTypeCategoryComp;
import utils.BaseTestClass;

@RunWith(SerenityRunner.class)
public class CombinationTesting_ReviewScreens_7765 extends BaseTestClass{

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

    @Title("CVSB-3910 - AC7 Changes to the submit button for PSV's/singular vehicle tests" +
            "AC8 Change to confirmation message on PSV/singular vehicle tests" +
            "AC9 Review screen title for singular tests")
    @Test
    public void testChangesSingularVehicleTests() {
        //add psv
        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("YV31MEC18GA011900",super.username);
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();
        testSteps.selectVehicleCategoryOption();
        euVehicleCategorySteps.selectOption("M2");
        testSteps.selectOdometerReading();
        odometerReadingSteps.typeInField("123");
        odometerReadingSteps.checkReadingValue("123");
        odometerReadingSteps.pressSave();
        testSteps.waitUntilPageIsLoaded();
        testSteps.addTestTypeFor("YV31MEC18GA011900");
        testTypeCategorySteps.selectFromTestTypeList("Annual test");
        testSteps.selectTestType("Annual test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.pressSave();
        //submit and review tests
        testSteps.checkReviewAndSubmitButton();
        testSteps.clickReviewAndSubmit();
        //check psv test
        testReviewSteps.checkElementIsDisplayed("Test review");
        testReviewSteps.checkElementIsDisplayed("YV31MEC18GA011900");
        testReviewSteps.scrollDown();
        testReviewSteps.checkElementIsDisplayed("Submit test");
        //submit test
        testReviewSteps.pressSubmit();
        testReviewSteps.pressSubmitInPopUp();
        confirmationPageSteps.waitUntilPageIsLoaded();
        confirmationPageSteps.checkElementContainingStringIsDisplayed("The tests have been submitted and will be emailed to");
        confirmationPageSteps.pressDone();
        siteVisitSteps.waitUntilPageIsLoaded();
        //validate site visit timeline
        siteVisitSteps.checkVehiclePosition("C47WLL",0);
    }

}
