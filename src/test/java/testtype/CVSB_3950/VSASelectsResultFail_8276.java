package testtype.CVSB_3950;

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
public class VSASelectsResultFail_8276 extends BaseTestClass {

    @Steps
    TestSteps testSteps;

    @Steps
    TestTypeCategorySteps testTypeCategorySteps;

    @Steps
    TestTypeCategoryComp testTypeCategoryComp;

    @Steps
    TestTypeDetailsSteps testTypeDetailsSteps;

    @Steps
    PreparerSteps preparerSteps;

    @Steps
    CountryOfRegistrationSteps countryOfRegistrationSteps;

    @Steps
    EUVehicleCategorySteps euVehicleCategorySteps;

    @Steps
    OdometerReadingSteps odometerReadingSteps;

    @Steps
    TestReviewSteps testReviewSteps;

    @Steps
    ConfirmationPageSteps confirmationPageSteps;

    @Title("CVSB-8276 - ADR test Failed, not needing specific data on submission (HGV)")
    @Test
    public void submitADRTestHGV_Failed_NotRequiringInfo() {

        // Start a test for an HGV.
        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("230123",super.username);
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();

        // Select an HGV and set basic test info.
        testSteps.checkHgvTestDetails("CT70VRL", "P012301230123");
        testSteps.clickCountryOfRegistrationOption();
        countryOfRegistrationSteps.selectACountry("Norway");
        testSteps.checkCountryOfRegistrationFieldIsUpdated("Norway");
        testSteps.selectVehicleCategoryOption();
        euVehicleCategorySteps.selectOption("N2");
        testSteps.selectOdometerReading();
        odometerReadingSteps.typeInField("123");
        odometerReadingSteps.checkReadingValue("123");
        odometerReadingSteps.pressSave();

        // Add an ADR test.
        testSteps.addTestType();
        testTypeCategorySteps.selectFromTestTypeList("Technical test");
        testTypeCategorySteps.selectFromTestTypeList("ADR");

        // CVSB-8276: TC - AC3 - VSA selects result - FAIL
        // Set test to Failed, and submit it.
        // This ensures that fields (certificate number, expiry date) are not required in the failure scenario.
        testSteps.selectTestType("Technical test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.setTestToOption("Fail");
        testTypeDetailsSteps.checkTestIsFailed();
        testTypeDetailsSteps.pressSave();
        testSteps.clickReviewAndSubmit();
        testReviewSteps.pressSubmit();
        testReviewSteps.checkSubmitPopUp();
        testReviewSteps.pressSubmitInPopUp();
        confirmationPageSteps.checkElementContainingStringIsDisplayed("The tests have been submitted");
    }

    @Title("CVSB-8276 - ADR test Failed, not needing specific data on submission (TRL)")
    @Test
    public void submitADRTestTRL_Failed_NotRequiringInfo() {

        // Start a test for a TRL.
        testTypeCategoryComp.goToTestPageBySelectingASpecificTrailer("768594",super.username);
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();

        // Select a TRL and set basic test info.
        testSteps.checkTrailerTestDetails("0285678", "T12768594");
        testSteps.clickCountryOfRegistrationOption();
        countryOfRegistrationSteps.selectACountry("Norway");
        testSteps.checkCountryOfRegistrationFieldIsUpdated("Norway");
        testSteps.selectVehicleCategoryOption();
        euVehicleCategorySteps.selectOption("O1");

        // Add an ADR test.
        testSteps.addTestType();
        testTypeCategorySteps.selectFromTestTypeList("Technical test");
        testTypeCategorySteps.selectFromTestTypeList("ADR");

        // CVSB-8276: TC - AC3 - VSA selects result - FAIL
        // Set test to Failed, and submit it.
        // This ensures that fields (certificate number, expiry date) are not required in the failure scenario.
        testSteps.selectTestType("Technical test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.setTestToOption("Fail");
        testTypeDetailsSteps.checkTestIsFailed();
        testTypeDetailsSteps.pressSave();
        testSteps.clickReviewAndSubmit();
        testReviewSteps.pressSubmit();
        testReviewSteps.checkSubmitPopUp();
        testReviewSteps.pressSubmitInPopUp();
        confirmationPageSteps.checkElementContainingStringIsDisplayed("The tests have been submitted");
    }

    @Title("CVSB-3950 - ADR test Passed, needing specific data on submission (HGV)")
    @Test
    public void submitADRTestHGV_Passed_RequiringInfo() {

        // Start a test for an HGV.
        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("230123",super.username);
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();

        // Select an HGV and set basic test info.
        testSteps.checkHgvTestDetails("CT70VRL", "P012301230123");
        testSteps.clickCountryOfRegistrationOption();
        countryOfRegistrationSteps.selectACountry("Norway");
        testSteps.checkCountryOfRegistrationFieldIsUpdated("Norway");
        testSteps.selectVehicleCategoryOption();
        euVehicleCategorySteps.selectOption("N2");
        testSteps.selectOdometerReading();
        odometerReadingSteps.typeInField("123");
        odometerReadingSteps.checkReadingValue("123");
        odometerReadingSteps.pressSave();

        // Add an ADR test.
        testSteps.addTestType();
        testTypeCategorySteps.selectFromTestTypeList("Technical test");
        testTypeCategorySteps.selectFromTestTypeList("ADR");

        // CVSB-8275: TC - AC2 - VSA selects result
        // CVSB-8277: TC - AC4 - VSA selects result - PASS
        // Set test to Passed, and attempt to submit it.
        // This ensures that fields (certificate number, expiry date) are required in the passing scenario.
        testSteps.selectTestType("Technical test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.setTestToOption("Pass");
        testTypeDetailsSteps.checkTestIsPassed();
        testTypeDetailsSteps.pressSave();

        // CVSB-8281: TC - AC8 - Entering no certificate number
        // CVSB-8283: TC - AC10 - Expiry date field is mandatory
        // Attempt to submit with missing mandatory info.
        testSteps.clickReviewAndSubmit();
        testSteps.checkErrorMessageMandatoryFieldsDisplayed();

        // CVSB-8278: TC - AC5 - VSA inputs certificate number
        // CVSB-8280: TC - AC7 - 6 digit certificate number validation
        // Verify (certificate number, no expiry date).
        testSteps.selectTestType("Technical test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.sendCertificateNumber("1234567");
        testTypeDetailsSteps.checkCertificateNumberIs("123456");
        testTypeDetailsSteps.pressSave();
        testSteps.clickReviewAndSubmit();
        testSteps.checkErrorMessageMandatoryFieldsDisplayed();

        // CVSB-8279: TC - AC6 - VSA inputs expiry date
        // Verify (certificate number, expiry date).  This should remove the validation error onscreen.
        testSteps.selectTestType("Technical test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.setExpiryDateToToday();
        testTypeDetailsSteps.pressSave();
        testSteps.checkErrorMessageMandatoryFieldsNotDisplayed();

        // Provide Disclaimer text for this test (optional).
        testSteps.selectTestType("Technical test", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.verifyNotesFieldsArePresent();
        testTypeDetailsSteps.addNotes("This is an ADR test.");
        testTypeDetailsSteps.pressSave();

        // Now the mandatory fields have been provided, submit the test results.
        testSteps.clickReviewAndSubmit();
        testReviewSteps.checkTestStatus("ADR test", "PASS");
        testReviewSteps.checkCertificateNumberIs("123456");
        testReviewSteps.checkNotesAre("This is an ADR test.");
        testReviewSteps.scrollDown();
        testReviewSteps.pressSubmit();
        testReviewSteps.checkSubmitPopUp();
        testReviewSteps.pressSubmitInPopUp();
        confirmationPageSteps.checkElementContainingStringIsDisplayed("The tests have been submitted");
    }

    @Title("CVSB-3950 - ADR test Passed, needing specific data on submission (TRL)")
    @Test
    public void submitADRTestTRL_Passed_RequiringInfo() {

        // Start a test for a TRL.
        testTypeCategoryComp.goToTestPageBySelectingASpecificTrailer("768594",super.username);
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();

        // Select a TRL and set basic test info.
        testSteps.checkTrailerTestDetails("0285678", "T12768594");
        testSteps.clickCountryOfRegistrationOption();
        countryOfRegistrationSteps.selectACountry("Norway");
        testSteps.checkCountryOfRegistrationFieldIsUpdated("Norway");
        testSteps.selectVehicleCategoryOption();
        euVehicleCategorySteps.selectOption("O1");

        // Add an ADR test.
        testSteps.addTestType();
        testTypeCategorySteps.selectFromTestTypeList("Technical test");
        testTypeCategorySteps.selectFromTestTypeList("ADR");

        // CVSB-8275: TC - AC2 - VSA selects result
        // CVSB-8277: TC - AC4 - VSA selects result - PASS
        // Set test to Passed, and attempt to submit it.
        // This ensures that fields (certificate number, expiry date) are required in the passing scenario.
        testSteps.selectTestType("Technical test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.setTestToOption("Pass");
        testTypeDetailsSteps.checkTestIsPassed();
        testTypeDetailsSteps.pressSave();

        // CVSB-8281: TC - AC8 - Entering no certificate number
        // CVSB-8283: TC - AC10 - Expiry date field is mandatory
        // Attempt to submit with missing mandatory info.
        testSteps.clickReviewAndSubmit();
        testSteps.checkErrorMessageMandatoryFieldsDisplayed();

        // CVSB-8278: TC - AC5 - VSA inputs certificate number
        // CVSB-8280: TC - AC7 - 6 digit certificate number validation
        // Verify (certificate number, no expiry date).
        testSteps.selectTestType("Technical test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.sendCertificateNumber("1234567");
        testTypeDetailsSteps.checkCertificateNumberIs("123456");
        testTypeDetailsSteps.pressSave();
        testSteps.clickReviewAndSubmit();
        testSteps.checkErrorMessageMandatoryFieldsDisplayed();

        // CVSB-8279: TC - AC6 - VSA inputs expiry date
        // Verify (certificate number, expiry date).  This should remove the validation error onscreen.
        testSteps.selectTestType("Technical test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.setExpiryDateToToday();
        testTypeDetailsSteps.pressSave();
        testSteps.checkErrorMessageMandatoryFieldsNotDisplayed();

        // Provide Disclaimer text for this test (optional).
        testSteps.selectTestType("Technical test", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.verifyNotesFieldsArePresent();
        testTypeDetailsSteps.addNotes("This is an ADR test.");
        testTypeDetailsSteps.pressSave();

        // Now the mandatory fields have been provided, submit the test results.
        testSteps.clickReviewAndSubmit();
        testReviewSteps.checkTestStatus("ADR test", "PASS");
        testReviewSteps.checkCertificateNumberIs("123456");
        testReviewSteps.checkNotesAre("This is an ADR test.");
        testReviewSteps.scrollDown();
        testReviewSteps.pressSubmit();
        testReviewSteps.checkSubmitPopUp();
        testReviewSteps.pressSubmitInPopUp();
        confirmationPageSteps.checkElementContainingStringIsDisplayed("The tests have been submitted");
    }
}
