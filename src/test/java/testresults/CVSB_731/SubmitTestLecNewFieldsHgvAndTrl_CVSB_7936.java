package testresults.CVSB_731;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import pages.TestPage;
import steps.*;
import steps.composed.TestTypeCategoryComp;
import util.BaseTestClass;
import util.EmissionStandard;
import util.FuelType;
import util.ModType;

@RunWith(SerenityRunner.class)
public class SubmitTestLecNewFieldsHgvAndTrl_CVSB_7936 extends BaseTestClass {

    @Steps
    TestSteps testSteps;

    @Steps
    TestTypeCategoryComp testTypeCategoryComp;

    @Steps
    TestTypeDetailsSteps testTypeDetailsSteps;

    @Steps
    TestTypeSubcategorySteps testTypeSubcategorySteps;

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
    TrailerDetailsSteps trailerDetailsSteps;

    @Steps
    IdentifyTrailerSteps identifyTrailerSteps;

    @Title("CVSB-9897 - CVSB-7936 - As a VSA I want to be able to capture all LEC fields so that the certificate generated digitally is complete - HGV - Mod Type = P")
    @Test
    public void testLecFieldsHgvModTypeP() {
        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("230123");
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();
        testSteps.checkHgvTestDetails("CT70VRL", "P012301230123");
        testSteps.selectVehicleCategoryOption();
        euVehicleCategorySteps.selectOption("N1");
        testSteps.selectOdometerReading();
        odometerReadingSteps.typeInField("35000");
        odometerReadingSteps.checkReadingValue("35000");
        odometerReadingSteps.pressSave();
        testSteps.addTestType();
        testTypeCategorySteps.selectFromTestTypeList("Technical test");
        testTypeSubcategorySteps.selectFromTestTypeList("LEC");
        testTypeSubcategorySteps.selectFromTestTypeList("With linked test");
        testSteps.checkTestTypeStatus("Technical test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testSteps.selectTestType("Technical test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.checkTestTypeName("Low Emissions Certificate (LEC) with annual test");
        testTypeDetailsSteps.setTestToOption("Pass");
        testTypeDetailsSteps.setExpiryDateDefault();
        testTypeDetailsSteps.setEmissionStandard(EmissionStandard.OPTION_1);
        testTypeDetailsSteps.setSmokeTestKLimitApplied("5000");
        testTypeDetailsSteps.setFuelType(FuelType.GAS);
        testTypeDetailsSteps.setModeType(ModType.P);
        testTypeDetailsSteps.scrollTestTypeDetailsPage();
        testTypeDetailsSteps.setParticulateTrapFitted("some text");
        testTypeDetailsSteps.setParticulateTrapSerialNumber("23456");
        testTypeDetailsSteps.pressSave();
        testSteps.clickReviewAndSubmit();
        testReviewSteps.scrollDown();
        testReviewSteps.checkElementValue("Particulate type fitted", "some text");
        testReviewSteps.checkElementValue("Particulate type serial number", "23456");
        testReviewSteps.pressSubmit();
        testReviewSteps.pressSubmitInPopUp();
    }

    @Title("CVSB-9897 - CVSB-7936 - As a VSA I want to be able to capture all LEC fields so that the certificate generated digitally is complete - HGV - Mod Type = G")
    @Test
    public void testLecFieldsHgvModTypeG() {
        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("230123");
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();
        testSteps.checkHgvTestDetails("CT70VRL", "P012301230123");
        testSteps.selectVehicleCategoryOption();
        euVehicleCategorySteps.selectOption("N1");
        testSteps.selectOdometerReading();
        odometerReadingSteps.typeInField("35000");
        odometerReadingSteps.checkReadingValue("35000");
        odometerReadingSteps.pressSave();
        testSteps.addTestType();
        testTypeCategorySteps.selectFromTestTypeList("Technical test");
        testTypeSubcategorySteps.selectFromTestTypeList("LEC");
        testTypeSubcategorySteps.selectFromTestTypeList("With linked test");
        testSteps.checkTestTypeStatus("Technical test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testSteps.selectTestType("Technical test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.checkTestTypeName("Low Emissions Certificate (LEC) with annual test");
        testTypeDetailsSteps.setTestToOption("Pass");
        testTypeDetailsSteps.setExpiryDateDefault();
        testTypeDetailsSteps.setEmissionStandard(EmissionStandard.OPTION_1);
        testTypeDetailsSteps.setSmokeTestKLimitApplied("5000");
        testTypeDetailsSteps.setFuelType(FuelType.DIESEL);
        testTypeDetailsSteps.setModeType(ModType.G);
        testTypeDetailsSteps.scrollTestTypeDetailsPage();
        testTypeDetailsSteps.setModificationTypeUsed("some text");
        testTypeDetailsSteps.pressSave();
        testSteps.clickReviewAndSubmit();
        testReviewSteps.scrollDown();
        testReviewSteps.checkElementValue("Modification type used", "some text");
        testReviewSteps.checkElementValue("Emission Standard", EmissionStandard.OPTION_1.getDescription());
        testReviewSteps.pressSubmit();
        testReviewSteps.pressSubmitInPopUp();

    }

    @Title("CVSB-9897 - CVSB-7936 - As a VSA I want to be able to capture all LEC fields so that the certificate generated digitally is complete - PSV - Mod Type = M")
    @Test
    public void testLecFieldsPsvModTypeM() {
        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("012356");
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();
        testSteps.checkTestDetails("X71LTA", "XMGDE02FS0H012356");
        testSteps.selectVehicleCategoryOption();
        euVehicleCategorySteps.selectOption("M1");
        testSteps.selectOdometerReading();
        odometerReadingSteps.typeInField("35000");
        odometerReadingSteps.checkReadingValue("35000");
        odometerReadingSteps.pressSave();
        testSteps.addTestType();
        testTypeCategorySteps.selectFromTestTypeList("Technical test");
        testTypeSubcategorySteps.selectFromTestTypeList("LEC");
        testTypeSubcategorySteps.selectFromTestTypeList("With linked test");
        testSteps.checkTestTypeStatus("Technical test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testSteps.selectTestType("Technical test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.checkTestTypeName("Low Emissions Certificate (LEC) with annual test");
        testTypeDetailsSteps.setTestToOption("Pass");
        testTypeDetailsSteps.setExpiryDateDefault();
        testTypeDetailsSteps.setEmissionStandard(EmissionStandard.OPTION_1);
        testTypeDetailsSteps.setSmokeTestKLimitApplied("5000");
        testTypeDetailsSteps.setFuelType(FuelType.PETROL);
        testTypeDetailsSteps.setModeType(ModType.M);
        testTypeDetailsSteps.scrollTestTypeDetailsPage();
        testTypeDetailsSteps.setModificationTypeUsed("some text");
        testTypeDetailsSteps.pressSave();
        testSteps.clickReviewAndSubmit();
        testReviewSteps.scrollDown();
        testReviewSteps.checkElementValue("Modification type used", "some text");
        testReviewSteps.checkElementValue("Emission Standard", EmissionStandard.OPTION_1.getDescription());
        testReviewSteps.pressSubmit();
        testReviewSteps.pressSubmitInPopUp();

    }


    @Title("CVSB-9897 - CVSB-7936 - As a VSA I want to be able to capture all LEC fields so that the certificate generated digitally is complete - Error MEssage for incomplete data")
    @Test
    public void testLecFieldsHgvErrorMessage() {
        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("230123");
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();
        testSteps.checkHgvTestDetails("CT70VRL", "P012301230123");
        testSteps.selectVehicleCategoryOption();
        euVehicleCategorySteps.selectOption("N1");
        testSteps.selectOdometerReading();
        odometerReadingSteps.typeInField("35000");
        odometerReadingSteps.checkReadingValue("35000");
        odometerReadingSteps.pressSave();
        testSteps.addTestType();
        testTypeCategorySteps.selectFromTestTypeList("Technical test");
        testTypeSubcategorySteps.selectFromTestTypeList("LEC");
        testTypeSubcategorySteps.selectFromTestTypeList("With linked test");
        testSteps.checkTestTypeStatus("Technical test", TestPage.TestTypeStatuses.IN_PROGRESS);

        testSteps.selectTestType("Technical test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.checkTestTypeName("Low Emissions Certificate (LEC) with annual test");
        testTypeDetailsSteps.setTestToOption("Pass");
        testTypeDetailsSteps.pressSave();
        testSteps.clickReviewAndSubmit();
        testSteps.checkErrorMessageMandatoryFieldsDisplayed();

        testSteps.selectTestType("Technical test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.setExpiryDateDefault();
        testTypeDetailsSteps.pressSave();
        testSteps.clickReviewAndSubmit();
        testSteps.checkErrorMessageMandatoryFieldsDisplayed();

        testSteps.selectTestType("Technical test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.setEmissionStandard(EmissionStandard.OPTION_1);
        testTypeDetailsSteps.pressSave();
        testSteps.clickReviewAndSubmit();
        testSteps.checkErrorMessageMandatoryFieldsDisplayed();

        testSteps.selectTestType("Technical test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.setSmokeTestKLimitApplied("5000");
        testTypeDetailsSteps.pressSave();
        testSteps.clickReviewAndSubmit();
        testSteps.checkErrorMessageMandatoryFieldsDisplayed();

        testSteps.selectTestType("Technical test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.setFuelType(FuelType.DIESEL);
        testTypeDetailsSteps.pressSave();
        testSteps.clickReviewAndSubmit();
        testSteps.checkErrorMessageMandatoryFieldsDisplayed();

        testSteps.selectTestType("Technical test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.setModeType(ModType.G);
        testTypeDetailsSteps.pressSave();
        testSteps.clickReviewAndSubmit();
        testSteps.checkErrorMessageMandatoryFieldsDisplayed();

        testSteps.selectTestType("Technical test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.scrollTestTypeDetailsPage();
        testTypeDetailsSteps.setModificationTypeUsed("some text");
        testTypeDetailsSteps.pressSave();
        testSteps.checkTestTypeStatus("Technical test", TestPage.TestTypeStatuses.EDIT);

        testSteps.clickReviewAndSubmit();

        testReviewSteps.checkPageTitleIsDisplayed();

    }

}