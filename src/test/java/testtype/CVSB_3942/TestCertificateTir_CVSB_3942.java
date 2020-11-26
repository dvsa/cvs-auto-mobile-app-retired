package testtype.CVSB_3942;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import pages.SelectReasonPage;
import pages.TestPage;
import steps.*;
import steps.composed.TestTypeCategoryComp;
import steps.util.UtilSteps;
import utils.BaseTestClass;

@RunWith(SerenityRunner.class)
public class TestCertificateTir_CVSB_3942 extends BaseTestClass {

    @Steps
    UtilSteps utilSteps;

    @Steps
    TestSteps testSteps;

    @Steps
    TestTypeCategorySteps testTypeCategorySteps;

    @Steps
    TestTypeCategoryComp testTypeCategoryComp;

    @Steps
    TestTypeSubcategorySteps testTypeSubcategorySteps;

    @Steps
    EUVehicleCategorySteps euVehicleCategorySteps;

    @Steps
    CountryOfRegistrationSteps countryOfRegistrationSteps;

    @Steps
    PreparerSteps preparerSteps;

    @Steps
    TestReviewSteps testReviewSteps;

    @Steps
    TestTypeDetailsSteps testTypeDetailsSteps;

    @Steps
    OdometerReadingSteps odometerReadingSteps;

    @Steps
    AbandonTestSteps abandonTestSteps;

    @Steps
    SelectReasonSteps selectReasonSteps;

    @Title("CVSB-3942 - As a VSA I can capture test details for a TIR test type so that I can conduct a TIR test")
    @Test
    public void testTestTypeTirDetailsHgv() {
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("230123",super.username);
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();
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
        testSteps.addTestType();
        testTypeCategorySteps.waitUntilPageIsLoaded();
        testTypeCategorySteps.selectFromTestTypeList("Technical test");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("Technical test");
        testTypeSubcategorySteps.selectFromTestTypeList("TIR");
        testSteps.waitUntilPageIsLoaded();
        testSteps.checkTestTypeStatus("Technical test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testSteps.selectTestType("Technical test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.setTestToOption("PASS");
        testTypeDetailsSteps.checkCertificateNumberIsDisplayed();
        testTypeDetailsSteps.sendCertificateNumber("1234");
        testTypeDetailsSteps.pressSave();
        testSteps.waitUntilPageIsLoaded();
        testSteps.checkTestTypeStatus("Technical test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testSteps.clickReviewAndSubmit();
        testSteps.checkErrorMessageMandatoryFieldsDisplayed();
        testSteps.waitUntilPageIsLoaded();
        testSteps.selectTestType("Technical test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.checkCertificateNumberIs("1234");
        testTypeDetailsSteps.checkCertificateErrorIsDisplayed();
        testTypeDetailsSteps.sendCertificateNumber("12345");
        testTypeDetailsSteps.checkCertificateErrorIsNotDisplayed();
        testTypeDetailsSteps.pressSave();
        testSteps.waitUntilPageIsLoaded();
        testSteps.checkTestTypeStatus("Technical test", TestPage.TestTypeStatuses.EDIT);
        testSteps.clickReviewAndSubmit();
        testReviewSteps.checkTestStatus("TIR test", "PASS");
        testReviewSteps.checkElementIsDisplayed("Certificate number");
        testReviewSteps.checkElementValue("Certificate number", "GB/V12345");
        testReviewSteps.goToTestPage();
        testSteps.waitUntilPageIsLoaded();
        testSteps.selectTestType("Technical test", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.scrollTestTypeDetailsPage();
        testTypeDetailsSteps.pressTestTypeAbandonButton();
        selectReasonSteps.checkReasonsTirList();
        selectReasonSteps.selectTheReason(SelectReasonPage.ReasonsTir.REASON_4);
        selectReasonSteps.pressNextButton();
        abandonTestSteps.addAdditionalComments("testing purposes");
        abandonTestSteps.pressDone();
        abandonTestSteps.pressAbandon();
        testSteps.waitUntilPageIsLoaded();
        testSteps.checkTestTypeStatus("Technical test", TestPage.TestTypeStatuses.ABANDONED);
        testSteps.addLinkedTestType();
        testTypeCategorySteps.waitUntilPageIsLoaded();
        testTypeCategorySteps.selectFromTestTypeList("Retest");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("Retest");
        testTypeSubcategorySteps.selectFromTestTypeList("TIR retest");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("TIR retest");
        testTypeSubcategorySteps.selectFromTestTypeList("Paid retest");
        testSteps.waitUntilPageIsLoaded();
        testSteps.checkTestTypeStatus("Retest", TestPage.TestTypeStatuses.IN_PROGRESS);
        testSteps.selectTestType("Retest", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.setTestToOption("Pass");
        testTypeDetailsSteps.checkCertificateNumberIsDisplayed();
        testTypeDetailsSteps.sendCertificateNumber("54321");
        testTypeDetailsSteps.pressSave();
        testSteps.waitUntilPageIsLoaded();
        testSteps.checkTestTypeStatus("Retest", TestPage.TestTypeStatuses.EDIT);
        testSteps.clickReviewAndSubmit();
        testReviewSteps.checkTestStatus("TIR test", "ABANDONED");
        testReviewSteps.checkElementValue("Reason(s) for abandoning", selectReasonSteps.getReasonTexts(SelectReasonPage.ReasonsTir.REASON_4));
        testReviewSteps.checkElementValue("Notes", "testing purposes");
        testReviewSteps.scrollDown();
        testReviewSteps.checkTestStatus("Paid TIR retest", "PASS");
        testReviewSteps.checkElementValue("Certificate number", "CB/V54321");
    }

    @Title("CVSB-3942 - As a VSA I can capture test details for a TIR test type so that I can conduct a TIR test")
    @Test
    public void testTestTypeTirDetailsTrl() {
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        testTypeCategoryComp.goToTestPageBySelectingASpecificTrailer("777777",super.username);
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();
        testSteps.checkTrailerTestDetails("C108802", "ABCDEFGH777777");
        testSteps.clickCountryOfRegistrationOption();
        countryOfRegistrationSteps.selectACountry("Norway");
        testSteps.checkCountryOfRegistrationFieldIsUpdated("Norway");
        testSteps.selectVehicleCategoryOption();
        euVehicleCategorySteps.selectOption("O2");
        testSteps.addTestType();
        testTypeCategorySteps.waitUntilPageIsLoaded();
        testTypeCategorySteps.selectFromTestTypeList("Technical test");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("Technical test");
        testTypeSubcategorySteps.selectFromTestTypeList("TIR");
        testSteps.waitUntilPageIsLoaded();
        testSteps.checkTestTypeStatus("Technical test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testSteps.selectTestType("Technical test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.setTestToOption("PASS");
        testTypeDetailsSteps.checkCertificateNumberIsDisplayed();
        testTypeDetailsSteps.sendCertificateNumber("1234");
        testTypeDetailsSteps.pressSave();
        testSteps.waitUntilPageIsLoaded();
        testSteps.checkTestTypeStatus("Technical test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testSteps.clickReviewAndSubmit();
        testSteps.checkErrorMessageMandatoryFieldsDisplayed();
        testSteps.waitUntilPageIsLoaded();
        testSteps.selectTestType("Technical test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.checkCertificateNumberIs("1234");
        testTypeDetailsSteps.checkCertificateErrorIsDisplayed();
        testTypeDetailsSteps.sendCertificateNumber("12345");
        testTypeDetailsSteps.checkCertificateErrorIsNotDisplayed();
        testTypeDetailsSteps.pressSave();
        testSteps.waitUntilPageIsLoaded();
        testSteps.checkTestTypeStatus("Technical test", TestPage.TestTypeStatuses.EDIT);
        testSteps.clickReviewAndSubmit();
        testReviewSteps.checkTestStatus("TIR test", "PASS");
        testReviewSteps.checkElementIsDisplayed("Certificate number");
        testReviewSteps.checkElementValue("Certificate number", "GB/T12345");
        testReviewSteps.goToTestPage();
        testSteps.waitUntilPageIsLoaded();
        testSteps.selectTestType("Technical test", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.scrollTestTypeDetailsPage();
        testTypeDetailsSteps.pressTestTypeAbandonButton();
        selectReasonSteps.checkReasonsTirList();
        selectReasonSteps.selectTheReason(SelectReasonPage.ReasonsTir.REASON_5);
        selectReasonSteps.pressNextButton();
        abandonTestSteps.addAdditionalComments("testing purposes");
        abandonTestSteps.pressDone();
        abandonTestSteps.pressAbandon();
        testSteps.waitUntilPageIsLoaded();
        testSteps.checkTestTypeStatus("Technical test", TestPage.TestTypeStatuses.ABANDONED);
        testSteps.addLinkedTestType();
        testTypeCategorySteps.waitUntilPageIsLoaded();
        testTypeCategorySteps.selectFromTestTypeList("Retest");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("Retest");
        testTypeSubcategorySteps.selectFromTestTypeList("TIR retest");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("TIR retest");
        testTypeSubcategorySteps.selectFromTestTypeList("Paid retest");
        testSteps.waitUntilPageIsLoaded();
        testSteps.checkTestTypeStatus("Retest", TestPage.TestTypeStatuses.IN_PROGRESS);
        testSteps.selectTestType("Retest", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.setTestToOption("Pass");
        testTypeDetailsSteps.checkCertificateNumberIsDisplayed();
        testTypeDetailsSteps.sendCertificateNumber("54321");
        testTypeDetailsSteps.pressSave();
        testSteps.waitUntilPageIsLoaded();
        testSteps.checkTestTypeStatus("Retest", TestPage.TestTypeStatuses.EDIT);
        testSteps.clickReviewAndSubmit();
        testReviewSteps.checkTestStatus("TIR test", "ABANDONED");
        testReviewSteps.checkElementValue("Reason(s) for abandoning", selectReasonSteps.getReasonTexts(SelectReasonPage.ReasonsTir.REASON_5));
        testReviewSteps.checkElementValue("Notes", "testing purposes");
        testReviewSteps.scrollDown();
        testReviewSteps.checkTestStatus("Paid TIR retest", "PASS");
        testReviewSteps.checkElementValue("Certificate number", "CB/T54321");
    }
}
