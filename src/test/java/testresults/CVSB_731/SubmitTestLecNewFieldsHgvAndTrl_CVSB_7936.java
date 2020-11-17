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
import data.util.EmissionStandard;
import data.util.FuelType;
import data.util.ModType;

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
    EUVehicleCategorySteps euVehicleCategorySteps;

    @Steps
    OdometerReadingSteps odometerReadingSteps;

    @Steps
    TestReviewSteps testReviewSteps;

    @Steps
    PreparerSteps preparerSteps;

    @Title("CVSB-9897 - CVSB-7936 - As a VSA I want to be able to capture all LEC fields so that the certificate generated digitally is complete - HGV - Mod Type = P")
    @Test
    public void testLecFieldsHgvModTypeP() {
        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("230123",super.username);
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();
        testSteps.checkHgvTestDetails("CT70VRL", "P012301230123");
        testSteps.selectVehicleCategoryOption();
        euVehicleCategorySteps.selectOption("N2");
        testSteps.selectOdometerReading();
        odometerReadingSteps.typeInField("35000");
        odometerReadingSteps.checkReadingValue("35000");
        odometerReadingSteps.pressSave();
        testSteps.addTestType();
        testTypeCategorySteps.waitUntilPageIsLoaded();
        testTypeCategorySteps.selectFromTestTypeList("Technical test");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("Technical test");
        testTypeSubcategorySteps.selectFromTestTypeList("LEC");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("LEC");
        testTypeSubcategorySteps.selectFromTestTypeList("With linked test");
        testSteps.waitUntilPageIsLoaded();
        testSteps.checkTestTypeStatus("Technical test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testSteps.selectTestType("Technical test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.checkTestTypeName("Low Emissions Certificate (LEC) with annual test");
        testTypeDetailsSteps.setTestToOption("pass");
        testTypeDetailsSteps.setExpiryDateDefault();
        testTypeDetailsSteps.setEmissionStandard(EmissionStandard.OPTION_1);
        testTypeDetailsSteps.setSmokeTestKLimitApplied("5000");
        testTypeDetailsSteps.setFuelType(FuelType.GAS_CNG);
        testTypeDetailsSteps.setModeType(ModType.P);
        testTypeDetailsSteps.scrollTestTypeDetailsPage();
        testTypeDetailsSteps.setParticulateTrapFitted("some text");
        testTypeDetailsSteps.scrollTestTypeDetailsPage();
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
        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("230123",super.username);
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();
        testSteps.checkHgvTestDetails("CT70VRL", "P012301230123");
        testSteps.selectVehicleCategoryOption();
        euVehicleCategorySteps.selectOption("N2");
        testSteps.selectOdometerReading();
        odometerReadingSteps.typeInField("35000");
        odometerReadingSteps.checkReadingValue("35000");
        odometerReadingSteps.pressSave();
        testSteps.addTestType();
        testTypeCategorySteps.selectFromTestTypeList("Technical test");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("Technical test");
        testTypeSubcategorySteps.selectFromTestTypeList("LEC");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("LEC");
        testTypeSubcategorySteps.selectFromTestTypeList("With linked test");
        testSteps.waitUntilPageIsLoaded();
        testSteps.checkTestTypeStatus("Technical test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testSteps.selectTestType("Technical test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.checkTestTypeName("Low Emissions Certificate (LEC) with annual test");
        testTypeDetailsSteps.setTestToOption("pass");
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
        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("012356",super.username);
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();
        testSteps.checkTestDetails("X71LTA", "XMGDE02FS0H012356");
        testSteps.selectVehicleCategoryOption();
        euVehicleCategorySteps.selectOption("M2");
        testSteps.selectOdometerReading();
        odometerReadingSteps.typeInField("35000");
        odometerReadingSteps.checkReadingValue("35000");
        odometerReadingSteps.pressSave();
        testSteps.addTestType();
        testTypeCategorySteps.selectFromTestTypeList("Technical test");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("Technical test");
        testTypeSubcategorySteps.selectFromTestTypeList("LEC");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("LEC");
        testTypeSubcategorySteps.selectFromTestTypeList("With linked test");
        testSteps.waitUntilPageIsLoaded();
        testSteps.checkTestTypeStatus("Technical test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testSteps.selectTestType("Technical test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.checkTestTypeName("Low Emissions Certificate (LEC) with annual test");
        testTypeDetailsSteps.setTestToOption("pass");
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
        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("230123",super.username);
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();
        testSteps.checkHgvTestDetails("CT70VRL", "P012301230123");
        testSteps.selectVehicleCategoryOption();
        euVehicleCategorySteps.selectOption("N2");
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

    @Title("CVSB-11099 - AC1 - VSA selects Emission standard")
    @Test
    public void testLecFieldsEmissionStandard() {
        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("230123",super.username);
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();
        testSteps.checkHgvTestDetails("CT70VRL", "P012301230123");
        testSteps.addTestType();
        testTypeCategorySteps.selectFromTestTypeList("Technical test");
        testTypeSubcategorySteps.selectFromTestTypeList("LEC");
        testTypeSubcategorySteps.selectFromTestTypeList("With linked test");
        testSteps.checkTestTypeStatus("Technical test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testSteps.selectTestType("Technical test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.checkTestTypeName("Low Emissions Certificate (LEC) with annual test");
        testTypeDetailsSteps.setTestToOption("Pass");

        // Check the options are present and correct.
        testTypeDetailsSteps.clickEmissionStandard();
        testTypeDetailsSteps.checkEmissionStandardsArePresent();
        testTypeDetailsSteps.selectEmissionStandard(EmissionStandard.OPTION_2);
        testTypeDetailsSteps.checkEmissionStandardIsShown(EmissionStandard.OPTION_2);

        // Verify the selection is editable.
        testTypeDetailsSteps.clickEmissionStandard(EmissionStandard.OPTION_2);
        testTypeDetailsSteps.selectEmissionStandard(EmissionStandard.OPTION_3);
        testTypeDetailsSteps.checkEmissionStandardIsShown(EmissionStandard.OPTION_3);
    }

    @Title("CVSB-11099 - AC2 - VSA selects Fuel type")
    @Test
    public void testLecFieldsFuelType() {
        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("230123",super.username);
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();
        testSteps.checkHgvTestDetails("CT70VRL", "P012301230123");
        testSteps.addTestType();
        testTypeCategorySteps.selectFromTestTypeList("Technical test");
        testTypeSubcategorySteps.selectFromTestTypeList("LEC");
        testTypeSubcategorySteps.selectFromTestTypeList("With linked test");
        testSteps.checkTestTypeStatus("Technical test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testSteps.selectTestType("Technical test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.checkTestTypeName("Low Emissions Certificate (LEC) with annual test");
        testTypeDetailsSteps.setTestToOption("Pass");

        // Check the options are present and correct.
        testTypeDetailsSteps.clickFuelType();
        testTypeDetailsSteps.checkFuelTypesArePresent();
        testTypeDetailsSteps.selectFuelType(FuelType.GAS_CNG);
        testTypeDetailsSteps.checkFuelTypeIsShown(FuelType.GAS_CNG);

        // Verify the selection is editable.
        testTypeDetailsSteps.clickFuelType(FuelType.GAS_CNG);
        testTypeDetailsSteps.selectFuelType(FuelType.FULL_ELECTRIC);
        testTypeDetailsSteps.checkFuelTypeIsShown(FuelType.FULL_ELECTRIC);
    }
}
