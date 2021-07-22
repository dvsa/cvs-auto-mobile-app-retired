package sitevisit.CVSB_13044;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import util.TypeLoader;
import org.junit.runner.RunWith;
import pages.TestPage;
import steps.*;
import steps.composed.TestTypeCategoryComp;
import steps.util.UtilSteps;
import utils.BaseTestClass;

@RunWith(SerenityRunner.class)
public class Confirmation_Page_Review_CVSB_13044 extends BaseTestClass{

    @Steps
    UtilSteps utilSteps;

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
    OdometerReadingSteps odometerReadingSteps;

    @Steps
    EUVehicleCategorySteps euVehicleCategorySteps;

    @Steps
    PreparerSteps preparerSteps;

    @Steps
    SiteVisitSteps siteVisitSteps;


    @Steps
    ConfirmationPageSteps confirmationPageSteps;

    @Title("As a VSA I want the end test screen to be updated with copy changes so that the correct team name is used")
    @Test
    public void testCorrectTeamNameIsDisplayed() {
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
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
        testTypeCategorySteps.waitUntilPageIsLoaded();
        testTypeCategorySteps.selectFromTestTypeList("Annual test");
        testSteps.waitUntilPageIsLoaded();
        testSteps.selectTestType("Annual test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.pressSave();
        testSteps.checkReviewAndSubmitButton();
        testSteps.clickReviewAndSubmit();
        testReviewSteps.checkElementIsDisplayed("Test review");
        testReviewSteps.checkElementIsDisplayed("YV31MEC18GA011900");
        testReviewSteps.scrollDown();
        testReviewSteps.checkElementIsDisplayed("Submit test");
        testReviewSteps.pressSubmit();
        testReviewSteps.pressSubmitInPopUp();
        confirmationPageSteps.waitUntilPageIsLoaded();
        confirmationPageSteps.checkElementContainingStringIsDisplayed("The tests have been submitted and will be emailed to");
        confirmationPageSteps.checkElementContainingStringIsDisplayed("contact the Help Desk");
        String userEmailId = TypeLoader.getUsers().get(username).getEmail();
        String emailId = userEmailId.substring(0,4)+userEmailId.substring(4,5).toUpperCase()+userEmailId.substring(5,33);
        confirmationPageSteps.checkElementContainingStringIsDisplayed(emailId);
        confirmationPageSteps.pressDone();
        siteVisitSteps.checkSiteVisitPage();
    }
}
