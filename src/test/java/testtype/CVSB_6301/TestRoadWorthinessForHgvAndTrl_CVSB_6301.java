package testtype.CVSB_6301;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.core.annotations.WithTag;
import net.thucydides.core.annotations.WithTagValuesOf;
import org.junit.Test;
import org.junit.runner.RunWith;
import pages.TestPage;
import steps.*;
import steps.composed.TestTypeCategoryComp;
import util.BaseTestClass;

@RunWith(SerenityRunner.class)
public class TestRoadWorthinessForHgvAndTrl_CVSB_6301 extends BaseTestClass {

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
    TestReviewSteps testReviewSteps;

    @Steps
    TestTypeDetailsSteps testTypeDetailsSteps;

    @Steps
    DefectCategorySteps defectCategorySteps;

    @Steps
    DefectItemSteps defectItemSteps;

    @Steps
    DefectDescriptionSteps defectDescriptionSteps;

    @Steps
    DefectDetailsSteps defectDetailsSteps;

    @Steps
    OdometerReadingSteps odometerReadingSteps;

    @WithTagValuesOf({"Smoke_1", "Smoke_2"})
    @Title("CVSB-7442 - CVSB-7443 - CVSB-7446 - AC1 - Perform a full roadworthiness test to completion (Retest) (Record Certificate Number) (Reminder Note) (Certificate Number Compulsory)")
    @Test
    public void testFullRoadWorthinessRetestRecordCertificateNumberCompulsatory() {
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
        testTypeCategorySteps.selectFromTestTypeList("Retest");
        testTypeCategorySteps.selectFromTestTypeList("Roadworthiness");
        testTypeCategorySteps.selectFromTestTypeList("Paid");
        testSteps.checkTestTypeStatus("Retest", TestPage.TestTypeStatuses.EDIT);
        testSteps.selectTestType("Retest", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.clickAddDefect();
        defectCategorySteps.searchForDefect("8");
        defectCategorySteps.selectDefectFromList("8. Condition of Tyres");
        defectItemSteps.selectDefectFromList("1. A tyre:");
        defectDescriptionSteps.selectDefect("8.1 (d) (i) MINOR");
        defectDetailsSteps.tapDone();
        testTypeDetailsSteps.pressSave();
        testSteps.checkTestTypeStatus("Retest", TestPage.TestTypeStatuses.EDIT);
        testSteps.clickReviewAndSubmit();
        testReviewSteps.checkPageTitleIsDisplayed();
        testReviewSteps.checkTestStatus("Paid roadworthiness retest", "PASS");
    }

    @Title("CVSB-7436 - CVSB-7444 - CVSB-7445 - AC1 - Perform a full roadworthiness test to completion (Voluntary) (Record Certificate Number) (Reminder Note) (Certificate Number Compulsary)")
    @WithTag("Smoke_2")
    @Test
    public void testFullRoadWorthinessVoluntaryRecordCertificateNumberCompulsatory() {
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
        testTypeCategorySteps.selectFromTestTypeList("Voluntary test");
        testTypeCategorySteps.selectFromTestTypeList("Roadworthiness test");
        testSteps.checkTestTypeStatus("Voluntary test", TestPage.TestTypeStatuses.EDIT);
        testSteps.selectTestType("Voluntary test", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.clickAddDefect();
        defectCategorySteps.searchForDefect("8");
        defectCategorySteps.selectDefectFromList("8. Condition of Tyres");
        defectItemSteps.selectDefectFromList("1. A tyre:");
        defectDescriptionSteps.selectDefect("8.1 (d) (i) MINOR");
        defectDetailsSteps.tapDone();
        testTypeDetailsSteps.pressSave();
        testSteps.checkTestTypeStatus("Voluntary test", TestPage.TestTypeStatuses.EDIT);
        testSteps.clickReviewAndSubmit();
        testReviewSteps.checkPageTitleIsDisplayed();
        testReviewSteps.checkTestStatus("Voluntary roadworthiness test", "PASS");
    }

    @Title("CVSB-7437 - AC2 - Adding a Failure item to the Roadworthiness test (Voluntary)")
    @Test
    public void testFullRoadWorthinessVoluntaryAddingAFailure() {
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
        testTypeCategorySteps.selectFromTestTypeList("Voluntary test");
        testTypeCategorySteps.selectFromTestTypeList("Roadworthiness test");
        testSteps.checkTestTypeStatus("Voluntary test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testSteps.selectTestType("Voluntary test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.checkCertificateNumberIsDisplayed();
        testTypeDetailsSteps.checkCertificateGuidanceDisplays("After conducting the test, call central support to obtain a certificate number and complete the Roadworthiness Inspection Document.");
        testTypeDetailsSteps.sendCertificateNumberAndSave("CV26&£");
        testSteps.selectTestType("Voluntary test", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.checkCertificateNumberIs("CV26&£");
        testTypeDetailsSteps.clickAddDefect();
        defectCategorySteps.searchForDefect("6");
        defectCategorySteps.selectDefectFromList("6. Road Wheels and Hubs");
        defectItemSteps.selectDefectFromList("2. A wheel:");
        defectDescriptionSteps.selectDefect("6.2 (a) (i) MAJOR");
        defectDetailsSteps.tapDone();
        testTypeDetailsSteps.pressSave();
        testSteps.checkTestTypeStatus("Voluntary test", TestPage.TestTypeStatuses.EDIT);
        testSteps.selectTestType("Voluntary test", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.checkCertificateNumberIsNotDisplayed();
    }

    @Title("CVSB-7457 - AC2 - Adding a Failure item to the Roadworthiness test (Retest)")
    @Test
    public void testFullRoadWorthinessRetestAddingAFailure() {
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
        testTypeCategorySteps.selectFromTestTypeList("Retest");
        testTypeCategorySteps.selectFromTestTypeList("Roadworthiness");
        testTypeCategorySteps.selectFromTestTypeList("Paid");
        testSteps.checkTestTypeStatus("Retest", TestPage.TestTypeStatuses.IN_PROGRESS);
        testSteps.selectTestType("Retest", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.checkCertificateNumberIsDisplayed();
        testTypeDetailsSteps.checkCertificateGuidanceDisplays("After conducting the test, call central support to obtain a certificate number and complete the Roadworthiness Inspection Document.");
        testTypeDetailsSteps.sendCertificateNumberAndSave("HDK87&@£");
        testSteps.selectTestType("Retest", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.checkCertificateNumberIs("HDK87&@£");
        testTypeDetailsSteps.clickAddDefect();
        defectCategorySteps.searchForDefect("6");
        defectCategorySteps.selectDefectFromList("6. Road Wheels and Hubs");
        defectItemSteps.selectDefectFromList("1. A tyre retaining ring:");
        defectDescriptionSteps.selectDefect("6.1 (a) * DANGEROUS");
        defectDetailsSteps.tapDone();
        testTypeDetailsSteps.pressSave();
        testSteps.checkTestTypeStatus("Retest", TestPage.TestTypeStatuses.EDIT);
        testSteps.selectTestType("Retest", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.checkCertificateNumberIsNotDisplayed();
    }
}
