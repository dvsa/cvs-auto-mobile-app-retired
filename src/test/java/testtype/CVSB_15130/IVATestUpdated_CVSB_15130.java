package testtype.CVSB_15130;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import pages.TestPage;
import steps.*;
import steps.composed.TestTypeCategoryComp;
import steps.util.UtilSteps;
import utils.BaseTestClass;

@RunWith(SerenityRunner.class)
public class IVATestUpdated_CVSB_15130 extends BaseTestClass {

    @Steps
    UtilSteps utilSteps;

    @Steps
    PreparerSteps preparerSteps;

    @Steps
    TestSteps testSteps;

    @Steps
    TestTypeCategoryComp testTypeCategoryComp;

    @Steps
    TestTypeCategorySteps testTypeCategorySteps;

    @Steps
    TestTypeDetailsSteps testTypeDetailsSteps;

    @Steps
    EUVehicleCategorySteps euVehicleCategorySteps;

    @Steps
    OdometerReadingSteps odometerReadingSteps;

    @Steps
    TestTypeSubcategorySteps testTypeSubcategorySteps;


    @Title("CVSB-15130 - AC1 - Certificate number for Failures - PSV - YAS")
    @Test
    public void testIVACertificateNumber_Failures_PSV_YAS() {
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("1B7GG36N12S678410", super.username);
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();

        // Add a Specialist Test to the test.
        testSteps.addTestType();
        testTypeCategorySteps.waitUntilPageIsLoaded();
        testTypeCategorySteps.selectFromTestTypeList("Specialist test");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("Specialist test");
        testTypeCategorySteps.selectFromTestTypeList("IVA");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("IVA");
        testTypeCategorySteps.selectFromTestTypeList("Normal inspection");

        // View the Specialist Test details.
        // In order to verify that the test result is mandatory, fill all other test fields first.
        testSteps.selectEuVehicleCategory();
        euVehicleCategorySteps.selectM2Option();
        testSteps.selectOdometerReading();
        odometerReadingSteps.typeInField("12345");
        odometerReadingSteps.pressSave();

        //setting test result to fail
        testSteps.selectTestType("Specialist test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.setTestToOption("fail");
        testTypeDetailsSteps.checkCertificateNumberIsDisplayed();
        testTypeDetailsSteps.pressSave();

        // AC4's - Entering no Certificate
        testSteps.clickReviewAndSubmit();
        testSteps.checkErrorMessageMandatoryFieldsDisplayed();

        //Checking AC1 and AC3 - field is only 20 alphanumeric character (by removing characters)
        testSteps.selectTestType("Specialist test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.sendCertificateNumber("1234567890ABCDEFGHIJ123");
        testTypeDetailsSteps.checkCertificateNumberIs("1234567890ABCDEFGHIJ");
        testTypeDetailsSteps.pressSave();

        // AC2 - checking the certificate field is editable
        testSteps.waitUntilPageIsLoaded();
        testSteps.selectTestType("Specialist test", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.sendCertificateNumber("1111111111ABCDEFGHIJ");
        testTypeDetailsSteps.checkCertificateNumberIs("1111111111ABCDEFGHIJ");
        testTypeDetailsSteps.pressSave();

        // Also, as the last field (certificate number) has been populated, validation error should be removed.
        testSteps.checkErrorMessageMandatoryFieldsNotDisplayed();
        testSteps.selectTestType("Specialist test", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.checkCertificateNumberIs("1111111111ABCDEFGHIJ");
    }

    @Title("CVSB-15130 - AC1 - Certificate number for Failures - CAR - YA4")
    @Test
    public void testIVACertificateNumber_Failures_CAR_YA4() {
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("D0853010911255", super.username);
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();

        // Add a Specialist Test to the test.
        testSteps.addTestType();
        testTypeCategorySteps.waitUntilPageIsLoaded();
        testTypeCategorySteps.selectFromTestTypeList("Specialist test");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("Specialist test");
        testTypeCategorySteps.selectFromTestTypeList("IVA");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("IVA");
        testTypeCategorySteps.selectFromTestTypeList("Normal inspection");

        //Giving Odometer readings
        testSteps.selectOdometerReading();
        odometerReadingSteps.typeInField("12345");
        odometerReadingSteps.pressSave();

        //setting test result to fail
        testSteps.selectTestType("Specialist test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.setTestToOption("fail");
        testTypeDetailsSteps.checkCertificateNumberIsDisplayed();
        testTypeDetailsSteps.pressSave();

        // AC4's - Entering no Certificate
        testSteps.clickReviewAndSubmit();
        testSteps.checkErrorMessageMandatoryFieldsDisplayed();

        //Checking AC1 and AC3 - field is only 20 alphanumeric character (by removing characters)
        testSteps.selectTestType("Specialist test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.sendCertificateNumber("1234567890ABCDEFGHIJ123");
        testTypeDetailsSteps.checkCertificateNumberIs("1234567890ABCDEFGHIJ");
        testTypeDetailsSteps.pressSave();

        // AC2 - checking the certificate field is editable
        testSteps.waitUntilPageIsLoaded();
        testSteps.selectTestType("Specialist test", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.sendCertificateNumber("1111111111ABCDEFGHIJ");
        testTypeDetailsSteps.checkCertificateNumberIs("1111111111ABCDEFGHIJ");
        testTypeDetailsSteps.pressSave();

        // Also, as the last field (certificate number) has been populated, validation error should be removed.
        testSteps.checkErrorMessageMandatoryFieldsNotDisplayed();
        testSteps.selectTestType("Specialist test", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.checkCertificateNumberIs("1111111111ABCDEFGHIJ");
    }

    @Title("CVSB-15130 - AC1 - Certificate number for Failures - PSV - YEL")
    @Test
    public void testIVACertificateNumber_Failures_PSV_YEL() {
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("YV31MEC18GA678413", super.username);
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();

        // Add a Specialist Test to the test.
        testSteps.addTestType();
        testTypeCategorySteps.waitUntilPageIsLoaded();
        testTypeCategorySteps.selectFromTestTypeList("Specialist test");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("Specialist test");
        testTypeCategorySteps.selectFromTestTypeList("IVA");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("IVA");
        testTypeCategorySteps.selectFromTestTypeList("Normal inspection");

        // View the Specialist Test details.
        // In order to verify that the test result is mandatory, fill all other test fields first.
        testSteps.selectEuVehicleCategory();
        euVehicleCategorySteps.selectM2Option();
        testSteps.selectOdometerReading();
        odometerReadingSteps.typeInField("12345");
        odometerReadingSteps.pressSave();

        //setting test result to fail
        testSteps.selectTestType("Specialist test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.setTestToOption("fail");
        testTypeDetailsSteps.checkCertificateNumberIsDisplayed();

        //Checking AC1 and AC3 - field is only 20 alphanumeric character (by removing characters)
        testTypeDetailsSteps.sendCertificateNumber("1234567890ABCDEFGHIJ123");
        testTypeDetailsSteps.checkCertificateNumberIs("1234567890ABCDEFGHIJ");
        testTypeDetailsSteps.pressSave();

        // Also, as the last field (certificate number) has been populated, validation error should be removed.
        testSteps.checkErrorMessageMandatoryFieldsNotDisplayed();
        testSteps.selectTestType("Specialist test", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.checkCertificateNumberIs("1234567890ABCDEFGHIJ");
    }

    @Title("CVSB-15130 - AC1 - Certificate number for Failures - PSV - YJL")
    @Test
    public void testIVACertificateNumber_Failures_PSV_YJL() {
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("XMGDE02FS0H012356", super.username);
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();

        // Add a Specialist Test to the test.
        testSteps.addTestType();
        testTypeCategorySteps.waitUntilPageIsLoaded();
        testTypeCategorySteps.selectFromTestTypeList("Specialist test");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("Specialist test");
        testTypeCategorySteps.selectFromTestTypeList("IVA");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("IVA");
        testTypeCategorySteps.selectFromTestTypeList("Normal inspection");

        // View the Specialist Test details.
        // In order to verify that the test result is mandatory, fill all other test fields first.
        testSteps.selectEuVehicleCategory();
        euVehicleCategorySteps.selectM2Option();
        testSteps.selectOdometerReading();
        odometerReadingSteps.typeInField("12345");
        odometerReadingSteps.pressSave();

        //setting test result to fail
        testSteps.selectTestType("Specialist test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.setTestToOption("fail");
        testTypeDetailsSteps.checkCertificateNumberIsDisplayed();

        //Checking AC1 and AC3 - field is only 20 alphanumeric character (by removing characters)
        testTypeDetailsSteps.sendCertificateNumber("1234567890ABCDEFGHIJ123");
        testTypeDetailsSteps.checkCertificateNumberIs("1234567890ABCDEFGHIJ");
        testTypeDetailsSteps.pressSave();

        // Also, as the last field (certificate number) has been populated, validation error should be removed.
        testSteps.checkErrorMessageMandatoryFieldsNotDisplayed();
        testSteps.selectTestType("Specialist test", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.checkCertificateNumberIs("1234567890ABCDEFGHIJ");
    }

    @Title("CVSB-15130 - AC1 - Certificate number for Failures - LGV - YA7")
    @Test
    public void testIVACertificateNumber_Failures_LGV_YA7() {
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("K0853010911284", super.username);
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();

        // Add a Specialist Test to the test.
        testSteps.addTestType();
        testTypeCategorySteps.waitUntilPageIsLoaded();
        testTypeCategorySteps.selectFromTestTypeList("Specialist test");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("Specialist test");
        testTypeCategorySteps.selectFromTestTypeList("IVA");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("IVA");
        testTypeCategorySteps.selectFromTestTypeList("Normal inspection");

        // View the Specialist Test details.
        // In order to verify that the test result is mandatory, fill all other test fields first.
        testSteps.selectOdometerReading();
        odometerReadingSteps.typeInField("12345");
        odometerReadingSteps.pressSave();

        //setting test result to fail
        testSteps.selectTestType("Specialist test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.setTestToOption("fail");
        testTypeDetailsSteps.checkCertificateNumberIsDisplayed();

        //Checking AC1 and AC3 - field is only 20 alphanumeric character (by removing characters)
        testTypeDetailsSteps.sendCertificateNumber("1234567890ABCDEFGHIJ123");
        testTypeDetailsSteps.checkCertificateNumberIs("1234567890ABCDEFGHIJ");
        testTypeDetailsSteps.pressSave();

        // Also, as the last field (certificate number) has been populated, validation error should be removed.
        testSteps.checkErrorMessageMandatoryFieldsNotDisplayed();
        testSteps.selectTestType("Specialist test", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.checkCertificateNumberIs("1234567890ABCDEFGHIJ");
    }

    @Title("CVSB-15130 - AC1 - Certificate number for Failures - HGV - YAV")
    @Test
    public void testIVACertificateNumber_Failures_HGV_YAV() {
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("P012301091180", super.username);
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();

        // Add a Specialist Test to the test.
        testSteps.addTestType();
        testTypeCategorySteps.waitUntilPageIsLoaded();
        testTypeCategorySteps.selectFromTestTypeList("Specialist test");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("Specialist test");
        testTypeCategorySteps.selectFromTestTypeList("IVA");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("IVA");
        testTypeCategorySteps.selectFromTestTypeList("Normal inspection");

        // View the Specialist Test details.
        // In order to verify that the test result is mandatory, fill all other test fields first.
        testSteps.selectOdometerReading();
        odometerReadingSteps.typeInField("12345");
        odometerReadingSteps.pressSave();

        //setting test result to fail
        testSteps.selectTestType("Specialist test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.setTestToOption("fail");
        testTypeDetailsSteps.checkCertificateNumberIsDisplayed();

        //Checking AC1 and AC3 - field is only 20 alphanumeric character (by removing characters)
        testTypeDetailsSteps.sendCertificateNumber("1234567890ABCDEFGHIJ123");
        testTypeDetailsSteps.checkCertificateNumberIs("1234567890ABCDEFGHIJ");
        testTypeDetailsSteps.pressSave();

        // Also, as the last field (certificate number) has been populated, validation error should be removed.
        testSteps.checkErrorMessageMandatoryFieldsNotDisplayed();
        testSteps.selectTestType("Specialist test", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.checkCertificateNumberIs("1234567890ABCDEFGHIJ");
    }

    @Title("CVSB-15130 - AC1 - Certificate number for Failures - HGV - YEV")
    @Test
    public void testIVACertificateNumber_Failures_HGV_YEV() {
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("H000375332", super.username);
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();

        // Add a Specialist Test to the test.
        testSteps.addTestType();
        testTypeCategorySteps.waitUntilPageIsLoaded();
        testTypeCategorySteps.selectFromTestTypeList("Specialist test");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("Specialist test");
        testTypeCategorySteps.selectFromTestTypeList("IVA");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("IVA");
        testTypeCategorySteps.selectFromTestTypeList("Normal inspection");

        // View the Specialist Test details.
        // In order to verify that the test result is mandatory, fill all other test fields first.
        testSteps.selectOdometerReading();
        odometerReadingSteps.typeInField("12345");
        odometerReadingSteps.pressSave();

        //setting test result to fail
        testSteps.selectTestType("Specialist test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.setTestToOption("fail");
        testTypeDetailsSteps.checkCertificateNumberIsDisplayed();

        //Checking AC1 and AC3 - field is only 20 alphanumeric character (by removing characters)
        testTypeDetailsSteps.sendCertificateNumber("1234567890ABCDEFGHIJ123");
        testTypeDetailsSteps.checkCertificateNumberIs("1234567890ABCDEFGHIJ");
        testTypeDetailsSteps.pressSave();

        // Also, as the last field (certificate number) has been populated, validation error should be removed.
        testSteps.checkErrorMessageMandatoryFieldsNotDisplayed();
        testSteps.selectTestType("Specialist test", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.checkCertificateNumberIs("1234567890ABCDEFGHIJ");
    }

    @Title("CVSB-15130 - AC1 - Certificate number for Failures - TRL - YET")
    @Test
    public void testIVACertificateNumber_Failures_TRL_YET() {
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("DP76UMK4DQLTOT400009", super.username);
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();

        // Add a Specialist Test to the test.
        testSteps.addTestType();
        testTypeCategorySteps.waitUntilPageIsLoaded();
        testTypeCategorySteps.selectFromTestTypeList("Specialist test");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("Specialist test");
        testTypeCategorySteps.selectFromTestTypeList("IVA");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("IVA");
        testTypeCategorySteps.selectFromTestTypeList("Normal inspection");

        //setting test result to fail
        testSteps.selectTestType("Specialist test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.setTestToOption("fail");
        testTypeDetailsSteps.checkCertificateNumberIsDisplayed();

        //Checking AC1 and AC3 - field is only 20 alphanumeric character (by removing characters)
        testTypeDetailsSteps.sendCertificateNumber("1234567890ABCDEFGHIJ123");
        testTypeDetailsSteps.checkCertificateNumberIs("1234567890ABCDEFGHIJ");
        testTypeDetailsSteps.pressSave();

        // Also, as the last field (certificate number) has been populated, validation error should be removed.
        testSteps.checkErrorMessageMandatoryFieldsNotDisplayed();
        testSteps.selectTestType("Specialist test", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.checkCertificateNumberIs("1234567890ABCDEFGHIJ");
    }

    @Title("CVSB-15130 - AC1 - Certificate number for Failures - TRL - YJT")
    @Test
    public void testIVACertificateNumber_Failures_TRL_YJT() {
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("T72741213", super.username);
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();

        // Add a Specialist Test to the test.
        testSteps.addTestType();
        testTypeCategorySteps.waitUntilPageIsLoaded();
        testTypeCategorySteps.selectFromTestTypeList("Specialist test");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("Specialist test");
        testTypeCategorySteps.selectFromTestTypeList("IVA");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("IVA");
        testTypeCategorySteps.selectFromTestTypeList("Normal inspection");

        //setting test result to fail
        testSteps.selectTestType("Specialist test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.setTestToOption("fail");
        testTypeDetailsSteps.checkCertificateNumberIsDisplayed();

        //Checking AC1 and AC3 - field is only 20 alphanumeric character (by removing characters)
        testTypeDetailsSteps.sendCertificateNumber("1234567890ABCDEFGHIJ123");
        testTypeDetailsSteps.checkCertificateNumberIs("1234567890ABCDEFGHIJ");
        testTypeDetailsSteps.pressSave();

        // Also, as the last field (certificate number) has been populated, validation error should be removed.
        testSteps.checkErrorMessageMandatoryFieldsNotDisplayed();
        testSteps.selectTestType("Specialist test", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.checkCertificateNumberIs("1234567890ABCDEFGHIJ");
    }

    @Title("CVSB-15130 - AC1 - Certificate number for Failures - TRL - YNT")
    @Test
    public void testIVACertificateNumber_Failures_TRL_YNT() {
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("T72741214", super.username);
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();

        // Add a Specialist Test to the test.
        testSteps.addTestType();
        testTypeCategorySteps.waitUntilPageIsLoaded();
        testTypeCategorySteps.selectFromTestTypeList("Specialist test");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("Specialist test");
        testTypeCategorySteps.selectFromTestTypeList("IVA");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("IVA");
        testTypeCategorySteps.selectFromTestTypeList("Normal inspection");

        //setting test result to fail
        testSteps.selectTestType("Specialist test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.setTestToOption("fail");
        testTypeDetailsSteps.checkCertificateNumberIsDisplayed();

        //Checking AC1 and AC3 - field is only 20 alphanumeric character (by removing characters)
        testTypeDetailsSteps.sendCertificateNumber("1234567890ABCDEFGHIJ123");
        testTypeDetailsSteps.checkCertificateNumberIs("1234567890ABCDEFGHIJ");
        testTypeDetailsSteps.pressSave();

        // Also, as the last field (certificate number) has been populated, validation error should be removed.
        testSteps.checkErrorMessageMandatoryFieldsNotDisplayed();
        testSteps.selectTestType("Specialist test", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.checkCertificateNumberIs("1234567890ABCDEFGHIJ");
    }

    @Title("CVSB-15130 - AC1 - Certificate number for Failures - CAR - YE4")
    @Test
    public void testIVACertificateNumber_Failures_CAR_YE4() {
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("P0123010911250", super.username);
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();

        // Add a Specialist Test to the test.
        testSteps.addTestType();
        testTypeCategorySteps.waitUntilPageIsLoaded();
        testTypeCategorySteps.selectFromTestTypeList("Specialist test");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("Specialist test");
        testTypeCategorySteps.selectFromTestTypeList("IVA");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("IVA");
        testTypeCategorySteps.selectFromTestTypeList("Appeal");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("Appeal");
        testTypeSubcategorySteps.selectFromTestTypeList("Basic inspection");
//        //setting test result to fail
//        testSteps.selectTestType("Specialist test", TestPage.TestTypeStatuses.IN_PROGRESS);
//        testTypeDetailsSteps.setTestToOption("fail");
//        testTypeDetailsSteps.checkCertificateNumberIsDisplayed();
//
//        //Checking AC1 and AC3 - field is only 20 alphanumeric character (by removing characters)
//        testTypeDetailsSteps.sendCertificateNumber("1234567890ABCDEFGHIJ123");
//        testTypeDetailsSteps.checkCertificateNumberIs("1234567890ABCDEFGHIJ");
//        testTypeDetailsSteps.pressSave();
//
//        // Also, as the last field (certificate number) has been populated, validation error should be removed.
//        testSteps.checkErrorMessageMandatoryFieldsNotDisplayed();
//        testSteps.selectTestType("Specialist test", TestPage.TestTypeStatuses.EDIT);
//        testTypeDetailsSteps.checkCertificateNumberIs("1234567890ABCDEFGHIJ");
    }

    @Title("CVSB-15130 - AC1 - Certificate number for Failures - PSV - YDS")
    @Test
    public void testIVACertificateNumber_Failures_PSV_YDS() {
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("1B7GG36N12S678410", super.username);
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();

        // Add a Specialist Test to the test.
        testSteps.addTestType();
        testTypeCategorySteps.waitUntilPageIsLoaded();
        testTypeCategorySteps.selectFromTestTypeList("Specialist test");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("Specialist test");
        testTypeCategorySteps.selectFromTestTypeList("IVA");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("IVA");
        testTypeCategorySteps.selectFromTestTypeList("Appeal");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("Appeal");
        testTypeSubcategorySteps.selectFromTestTypeList("Normal inspection");
        //setting test result to fail
        testSteps.selectTestType("Specialist test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.setTestToOption("fail");
        testTypeDetailsSteps.checkCertificateNumberIsDisplayed();

        //Checking AC1 and AC3 - field is only 20 alphanumeric character (by removing characters)
        testTypeDetailsSteps.sendCertificateNumber("1234567890ABCDEFGHIJ123");
        testTypeDetailsSteps.checkCertificateNumberIs("1234567890ABCDEFGHIJ");
        testTypeDetailsSteps.pressSave();

        // Also, as the last field (certificate number) has been populated, validation error should be removed.
        testSteps.checkErrorMessageMandatoryFieldsNotDisplayed();
        testSteps.selectTestType("Specialist test", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.checkCertificateNumberIs("1234567890ABCDEFGHIJ");
    }

    @Title("CVSB-15130 - AC1 - Certificate number for Failures - PSV - YHL")
    @Test
    public void testIVACertificateNumber_Failures_PSV_YHL() {
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("YV31MEC18GA678413", super.username);
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();

        // Add a Specialist Test to the test.
        testSteps.addTestType();
        testTypeCategorySteps.waitUntilPageIsLoaded();
        testTypeCategorySteps.selectFromTestTypeList("Specialist test");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("Specialist test");
        testTypeCategorySteps.selectFromTestTypeList("IVA");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("IVA");
        testTypeCategorySteps.selectFromTestTypeList("Appeal");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("Appeal");
        testTypeSubcategorySteps.selectFromTestTypeList("Normal inspection");
        //setting test result to fail
        testSteps.selectTestType("Specialist test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.setTestToOption("fail");
        testTypeDetailsSteps.checkCertificateNumberIsDisplayed();

        //Checking AC1 and AC3 - field is only 20 alphanumeric character (by removing characters)
        testTypeDetailsSteps.sendCertificateNumber("1234567890ABCDEFGHIJ123");
        testTypeDetailsSteps.checkCertificateNumberIs("1234567890ABCDEFGHIJ");
        testTypeDetailsSteps.pressSave();

        // Also, as the last field (certificate number) has been populated, validation error should be removed.
        testSteps.checkErrorMessageMandatoryFieldsNotDisplayed();
        testSteps.selectTestType("Specialist test", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.checkCertificateNumberIs("1234567890ABCDEFGHIJ");
    }

    @Title("CVSB-15130 - AC1 - Certificate number for Failures - PSV - YML")
    @Test
    public void testIVACertificateNumber_Failures_PSV_YML() {
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("XMGDE02FS0H012356", super.username);
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();

        // Add a Specialist Test to the test.
        testSteps.addTestType();
        testTypeCategorySteps.waitUntilPageIsLoaded();
        testTypeCategorySteps.selectFromTestTypeList("Specialist test");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("Specialist test");
        testTypeCategorySteps.selectFromTestTypeList("IVA");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("IVA");
        testTypeCategorySteps.selectFromTestTypeList("Appeal");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("Appeal");
        testTypeSubcategorySteps.selectFromTestTypeList("Normal inspection");
        //setting test result to fail
        testSteps.selectTestType("Specialist test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.setTestToOption("fail");
        testTypeDetailsSteps.checkCertificateNumberIsDisplayed();

        //Checking AC1 and AC3 - field is only 20 alphanumeric character (by removing characters)
        testTypeDetailsSteps.sendCertificateNumber("1234567890ABCDEFGHIJ123");
        testTypeDetailsSteps.checkCertificateNumberIs("1234567890ABCDEFGHIJ");
        testTypeDetailsSteps.pressSave();

        // AC2 - checking the certificate field is editable
        testSteps.waitUntilPageIsLoaded();
        testSteps.selectTestType("Specialist test", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.sendCertificateNumber("1111111111ABCDEFGHIJ");
        testTypeDetailsSteps.checkCertificateNumberIs("1111111111ABCDEFGHIJ");
        testTypeDetailsSteps.pressSave();

        // Also, as the last field (certificate number) has been populated, validation error should be removed.
        testSteps.checkErrorMessageMandatoryFieldsNotDisplayed();
        testSteps.selectTestType("Specialist test", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.checkCertificateNumberIs("1111111111ABCDEFGHIJ");
    }

    @Title("CVSB-15130 - AC1 - Certificate number for Failures - LGV - YE7")
    @Test
    public void testIVACertificateNumber_Failures_LGV_YE7() {
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("K0853010911284", super.username);
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();

        // Add a Specialist Test to the test.
        testSteps.addTestType();
        testTypeCategorySteps.waitUntilPageIsLoaded();
        testTypeCategorySteps.selectFromTestTypeList("Specialist test");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("Specialist test");
        testTypeCategorySteps.selectFromTestTypeList("IVA");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("IVA");
        testTypeCategorySteps.selectFromTestTypeList("Appeal");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("Appeal");
        testTypeSubcategorySteps.selectFromTestTypeList("Normal inspection");
        //setting test result to fail
        testSteps.selectTestType("Specialist test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.setTestToOption("fail");
        testTypeDetailsSteps.checkCertificateNumberIsDisplayed();

        //Checking AC1 and AC3 - field is only 20 alphanumeric character (by removing characters)
        testTypeDetailsSteps.sendCertificateNumber("1234567890ABCDEFGHIJ123");
        testTypeDetailsSteps.checkCertificateNumberIs("1234567890ABCDEFGHIJ");
        testTypeDetailsSteps.pressSave();

        // AC2 - checking the certificate field is editable
        testSteps.waitUntilPageIsLoaded();
        testSteps.selectTestType("Specialist test", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.sendCertificateNumber("1111111111ABCDEFGHIJ");
        testTypeDetailsSteps.checkCertificateNumberIs("1111111111ABCDEFGHIJ");
        testTypeDetailsSteps.pressSave();

        // Also, as the last field (certificate number) has been populated, validation error should be removed.
        testSteps.checkErrorMessageMandatoryFieldsNotDisplayed();
        testSteps.selectTestType("Specialist test", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.checkCertificateNumberIs("1111111111ABCDEFGHIJ");
    }

    @Title("CVSB-15130 - AC1 - Certificate number for Failures - HGV - YDV")
    @Test
    public void testIVACertificateNumber_Failures_HGV_YDV() {
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("A00004801", super.username);
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();

        // Add a Specialist Test to the test.
        testSteps.addTestType();
        testTypeCategorySteps.waitUntilPageIsLoaded();
        testTypeCategorySteps.selectFromTestTypeList("Specialist test");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("Specialist test");
        testTypeCategorySteps.selectFromTestTypeList("IVA");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("IVA");
        testTypeCategorySteps.selectFromTestTypeList("Appeal");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("Appeal");
        testTypeSubcategorySteps.selectFromTestTypeList("Normal inspection");
        //setting test result to fail
        testSteps.selectTestType("Specialist test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.setTestToOption("fail");
        testTypeDetailsSteps.checkCertificateNumberIsDisplayed();

        //Checking AC1 and AC3 - field is only 20 alphanumeric character (by removing characters)
        testTypeDetailsSteps.sendCertificateNumber("1234567890ABCDEFGHIJ123");
        testTypeDetailsSteps.checkCertificateNumberIs("1234567890ABCDEFGHIJ");
        testTypeDetailsSteps.pressSave();

        // AC2 - checking the certificate field is editable
        testSteps.waitUntilPageIsLoaded();
        testSteps.selectTestType("Specialist test", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.sendCertificateNumber("1111111111ABCDEFGHIJ");
        testTypeDetailsSteps.checkCertificateNumberIs("1111111111ABCDEFGHIJ");
        testTypeDetailsSteps.pressSave();

        // Also, as the last field (certificate number) has been populated, validation error should be removed.
        testSteps.checkErrorMessageMandatoryFieldsNotDisplayed();
        testSteps.selectTestType("Specialist test", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.checkCertificateNumberIs("1111111111ABCDEFGHIJ");
    }

    @Title("CVSB-15130 - AC1 - Certificate number for Failures - HGV - YHV")
    @Test
    public void testIVACertificateNumber_Failures_HGV_YHV() {
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("H000375332", super.username);
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();

        // Add a Specialist Test to the test.
        testSteps.addTestType();
        testTypeCategorySteps.waitUntilPageIsLoaded();
        testTypeCategorySteps.selectFromTestTypeList("Specialist test");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("Specialist test");
        testTypeCategorySteps.selectFromTestTypeList("IVA");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("IVA");
        testTypeCategorySteps.selectFromTestTypeList("Appeal");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("Appeal");
        testTypeSubcategorySteps.selectFromTestTypeList("Normal inspection");
        //setting test result to fail
        testSteps.selectTestType("Specialist test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.setTestToOption("fail");
        testTypeDetailsSteps.checkCertificateNumberIsDisplayed();

        //Checking AC1 and AC3 - field is only 20 alphanumeric character (by removing characters)
        testTypeDetailsSteps.sendCertificateNumber("1234567890ABCDEFGHIJ123");
        testTypeDetailsSteps.checkCertificateNumberIs("1234567890ABCDEFGHIJ");
        testTypeDetailsSteps.pressSave();

        // AC2 - checking the certificate field is editable
        testSteps.waitUntilPageIsLoaded();
        testSteps.selectTestType("Specialist test", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.sendCertificateNumber("1111111111ABCDEFGHIJ");
        testTypeDetailsSteps.checkCertificateNumberIs("1111111111ABCDEFGHIJ");
        testTypeDetailsSteps.pressSave();

        // Also, as the last field (certificate number) has been populated, validation error should be removed.
        testSteps.checkErrorMessageMandatoryFieldsNotDisplayed();
        testSteps.selectTestType("Specialist test", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.checkCertificateNumberIs("1111111111ABCDEFGHIJ");
    }

    @Title("CVSB-15130 - AC1 - Certificate number for Failures - TRL - YDT")
    @Test
    public void testIVACertificateNumber_Failures_TRL_YDT() {
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("PDY3222222203", super.username);
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();

        // Add a Specialist Test to the test.
        testSteps.addTestType();
        testTypeCategorySteps.waitUntilPageIsLoaded();
        testTypeCategorySteps.selectFromTestTypeList("Specialist test");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("Specialist test");
        testTypeCategorySteps.selectFromTestTypeList("IVA");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("IVA");
        testTypeCategorySteps.selectFromTestTypeList("Appeal");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("Appeal");
        testTypeSubcategorySteps.selectFromTestTypeList("Normal inspection");
        //setting test result to fail
        testSteps.selectTestType("Specialist test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.setTestToOption("fail");
        testTypeDetailsSteps.checkCertificateNumberIsDisplayed();

        //Checking AC1 and AC3 - field is only 20 alphanumeric character (by removing characters)
        testTypeDetailsSteps.sendCertificateNumber("1234567890ABCDEFGHIJ123");
        testTypeDetailsSteps.checkCertificateNumberIs("1234567890ABCDEFGHIJ");
        testTypeDetailsSteps.pressSave();

        // AC2 - checking the certificate field is editable
        testSteps.waitUntilPageIsLoaded();
        testSteps.selectTestType("Specialist test", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.sendCertificateNumber("1111111111ABCDEFGHIJ");
        testTypeDetailsSteps.checkCertificateNumberIs("1111111111ABCDEFGHIJ");
        testTypeDetailsSteps.pressSave();

        // Also, as the last field (certificate number) has been populated, validation error should be removed.
        testSteps.checkErrorMessageMandatoryFieldsNotDisplayed();
        testSteps.selectTestType("Specialist test", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.checkCertificateNumberIs("1111111111ABCDEFGHIJ");
    }

    @Title("CVSB-15130 - AC1 - Certificate number for Failures - TRL - YHT")
    @Test
    public void testIVACertificateNumber_Failures_TRL_YHT() {
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("T72741999", super.username);
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();

        // Add a Specialist Test to the test.
        testSteps.addTestType();
        testTypeCategorySteps.waitUntilPageIsLoaded();
        testTypeCategorySteps.selectFromTestTypeList("Specialist test");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("Specialist test");
        testTypeCategorySteps.selectFromTestTypeList("IVA");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("IVA");
        testTypeCategorySteps.selectFromTestTypeList("Appeal");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("Appeal");
        testTypeSubcategorySteps.selectFromTestTypeList("Normal inspection");
        //setting test result to fail
        testSteps.selectTestType("Specialist test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.setTestToOption("fail");
        testTypeDetailsSteps.checkCertificateNumberIsDisplayed();

        //Checking AC1 and AC3 - field is only 20 alphanumeric character (by removing characters)
        testTypeDetailsSteps.sendCertificateNumber("1234567890ABCDEFGHIJ123");
        testTypeDetailsSteps.checkCertificateNumberIs("1234567890ABCDEFGHIJ");
        testTypeDetailsSteps.pressSave();

        // AC2 - checking the certificate field is editable
        testSteps.waitUntilPageIsLoaded();
        testSteps.selectTestType("Specialist test", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.sendCertificateNumber("1111111111ABCDEFGHIJ");
        testTypeDetailsSteps.checkCertificateNumberIs("1111111111ABCDEFGHIJ");
        testTypeDetailsSteps.pressSave();

        // Also, as the last field (certificate number) has been populated, validation error should be removed.
        testSteps.checkErrorMessageMandatoryFieldsNotDisplayed();
        testSteps.selectTestType("Specialist test", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.checkCertificateNumberIs("1111111111ABCDEFGHIJ");
    }

    @Title("CVSB-15130 - AC1 - Certificate number for Failures - TRL - YMT")
    @Test
    public void testIVACertificateNumber_Failures_TRL_YMT() {
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("T72741213", super.username);
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();

        // Add a Specialist Test to the test.
        testSteps.addTestType();
        testTypeCategorySteps.waitUntilPageIsLoaded();
        testTypeCategorySteps.selectFromTestTypeList("Specialist test");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("Specialist test");
        testTypeCategorySteps.selectFromTestTypeList("IVA");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("IVA");
        testTypeCategorySteps.selectFromTestTypeList("Appeal");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("Appeal");
        testTypeSubcategorySteps.selectFromTestTypeList("Normal inspection");
        //setting test result to fail
        testSteps.selectTestType("Specialist test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.setTestToOption("fail");
        testTypeDetailsSteps.checkCertificateNumberIsDisplayed();

        //Checking AC1 and AC3 - field is only 20 alphanumeric character (by removing characters)
        testTypeDetailsSteps.sendCertificateNumber("1234567890ABCDEFGHIJ123");
        testTypeDetailsSteps.checkCertificateNumberIs("1234567890ABCDEFGHIJ");
        testTypeDetailsSteps.pressSave();

        // AC2 - checking the certificate field is editable
        testSteps.waitUntilPageIsLoaded();
        testSteps.selectTestType("Specialist test", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.sendCertificateNumber("1111111111ABCDEFGHIJ");
        testTypeDetailsSteps.checkCertificateNumberIs("1111111111ABCDEFGHIJ");
        testTypeDetailsSteps.pressSave();

        // Also, as the last field (certificate number) has been populated, validation error should be removed.
        testSteps.checkErrorMessageMandatoryFieldsNotDisplayed();
        testSteps.selectTestType("Specialist test", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.checkCertificateNumberIs("1111111111ABCDEFGHIJ");
    }

    @Title("CVSB-15130 - AC1 - Certificate number for Failures - TRL - YRT")
    @Test
    public void testIVACertificateNumber_Failures_TRL_YRT() {
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("T72741214", super.username);
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();

        // Add a Specialist Test to the test.
        testSteps.addTestType();
        testTypeCategorySteps.waitUntilPageIsLoaded();
        testTypeCategorySteps.selectFromTestTypeList("Specialist test");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("Specialist test");
        testTypeCategorySteps.selectFromTestTypeList("IVA");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("IVA");
        testTypeCategorySteps.selectFromTestTypeList("Appeal");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("Appeal");
        testTypeSubcategorySteps.selectFromTestTypeList("Normal inspection");
        //setting test result to fail
        testSteps.selectTestType("Specialist test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.setTestToOption("fail");
        testTypeDetailsSteps.checkCertificateNumberIsDisplayed();

        //Checking AC1 and AC3 - field is only 20 alphanumeric character (by removing characters)
        testTypeDetailsSteps.sendCertificateNumber("1234567890ABCDEFGHIJ123");
        testTypeDetailsSteps.checkCertificateNumberIs("1234567890ABCDEFGHIJ");
        testTypeDetailsSteps.pressSave();

        // AC2 - checking the certificate field is editable
        testSteps.waitUntilPageIsLoaded();
        testSteps.selectTestType("Specialist test", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.sendCertificateNumber("1111111111ABCDEFGHIJ");
        testTypeDetailsSteps.checkCertificateNumberIs("1111111111ABCDEFGHIJ");
        testTypeDetailsSteps.pressSave();

        // Also, as the last field (certificate number) has been populated, validation error should be removed.
        testSteps.checkErrorMessageMandatoryFieldsNotDisplayed();
        testSteps.selectTestType("Specialist test", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.checkCertificateNumberIs("1111111111ABCDEFGHIJ");
    }

    @Title("CVSB-15130 - AC1 - Certificate number for Failures - LGV - YK7")
    @Test
    public void testIVACertificateNumber_Failures_LGV_YK7() {
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("BBBBBBB555666", super.username);
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();

        // Add a Specialist Test to the test.
        testSteps.addTestType();
        testTypeCategorySteps.waitUntilPageIsLoaded();
        testTypeCategorySteps.selectFromTestTypeList("Specialist test");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("Specialist test");
        testTypeCategorySteps.selectFromTestTypeList("IVA");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("IVA");
        testTypeCategorySteps.selectFromTestTypeList("Appeal");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("Appeal");
        testTypeSubcategorySteps.selectFromTestTypeList("Basic inspection");
        //setting test result to fail
        testSteps.selectTestType("Specialist test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.setTestToOption("fail");
        testTypeDetailsSteps.checkCertificateNumberIsDisplayed();

        //Checking AC1 and AC3 - field is only 20 alphanumeric character (by removing characters)
        testTypeDetailsSteps.sendCertificateNumber("1234567890ABCDEFGHIJ123");
        testTypeDetailsSteps.checkCertificateNumberIs("1234567890ABCDEFGHIJ");
        testTypeDetailsSteps.pressSave();

        // AC2 - checking the certificate field is editable
        testSteps.waitUntilPageIsLoaded();
        testSteps.selectTestType("Specialist test", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.sendCertificateNumber("1111111111ABCDEFGHIJ");
        testTypeDetailsSteps.checkCertificateNumberIs("1111111111ABCDEFGHIJ");
        testTypeDetailsSteps.pressSave();

        // Also, as the last field (certificate number) has been populated, validation error should be removed.
        testSteps.checkErrorMessageMandatoryFieldsNotDisplayed();
        testSteps.selectTestType("Specialist test", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.checkCertificateNumberIs("1111111111ABCDEFGHIJ");
    }

    @Title("CVSB-15130 - AC1 - Certificate number for Failures - LGV - YQ7")
    @Test
    public void testIVACertificateNumber_Failures_LGV_YQ7() {
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("L0853010911254", super.username);
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();

        // Add a Specialist Test to the test.
        testSteps.addTestType();
        testTypeCategorySteps.waitUntilPageIsLoaded();
        testTypeCategorySteps.selectFromTestTypeList("Specialist test");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("Specialist test");
        testTypeCategorySteps.selectFromTestTypeList("IVA");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("IVA");
        testTypeCategorySteps.selectFromTestTypeList("Appeal");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("Appeal");
        testTypeSubcategorySteps.selectFromTestTypeList("Basic inspection");
        //setting test result to fail
        testSteps.selectTestType("Specialist test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.setTestToOption("fail");
        testTypeDetailsSteps.checkCertificateNumberIsDisplayed();

        //Checking AC1 and AC3 - field is only 20 alphanumeric character (by removing characters)
        testTypeDetailsSteps.sendCertificateNumber("1234567890ABCDEFGHIJ123");
        testTypeDetailsSteps.checkCertificateNumberIs("1234567890ABCDEFGHIJ");
        testTypeDetailsSteps.pressSave();

        // AC2 - checking the certificate field is editable
        testSteps.waitUntilPageIsLoaded();
        testSteps.selectTestType("Specialist test", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.sendCertificateNumber("1111111111ABCDEFGHIJ");
        testTypeDetailsSteps.checkCertificateNumberIs("1111111111ABCDEFGHIJ");
        testTypeDetailsSteps.pressSave();

        // Also, as the last field (certificate number) has been populated, validation error should be removed.
        testSteps.checkErrorMessageMandatoryFieldsNotDisplayed();
        testSteps.selectTestType("Specialist test", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.checkCertificateNumberIs("1111111111ABCDEFGHIJ");
    }

    @Title("CVSB-15130 - AC1 - Certificate number for Failures - CAR - YK4")
    @Test
    public void testIVACertificateNumber_Failures_CAR_YK4() {
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("DP76UMK4DQLTOT400005", super.username);
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();

        // Add a Specialist Test to the test.
        testSteps.addTestType();
        testTypeCategorySteps.waitUntilPageIsLoaded();
        testTypeCategorySteps.selectFromTestTypeList("Specialist test");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("Specialist test");
        testTypeCategorySteps.selectFromTestTypeList("IVA");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("IVA");
        testTypeCategorySteps.selectFromTestTypeList("Appeal");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("Appeal");
        testTypeSubcategorySteps.selectFromTestTypeList("Basic inspection");
        //setting test result to fail
        testSteps.selectTestType("Specialist test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.setTestToOption("fail");
        testTypeDetailsSteps.checkCertificateNumberIsDisplayed();

        //Checking AC1 and AC3 - field is only 20 alphanumeric character (by removing characters)
        testTypeDetailsSteps.sendCertificateNumber("1234567890ABCDEFGHIJ123");
        testTypeDetailsSteps.checkCertificateNumberIs("1234567890ABCDEFGHIJ");
        testTypeDetailsSteps.pressSave();

        // AC2 - checking the certificate field is editable
        testSteps.waitUntilPageIsLoaded();
        testSteps.selectTestType("Specialist test", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.sendCertificateNumber("1111111111ABCDEFGHIJ");
        testTypeDetailsSteps.checkCertificateNumberIs("1111111111ABCDEFGHIJ");
        testTypeDetailsSteps.pressSave();

        // Also, as the last field (certificate number) has been populated, validation error should be removed.
        testSteps.checkErrorMessageMandatoryFieldsNotDisplayed();
        testSteps.selectTestType("Specialist test", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.checkCertificateNumberIs("1111111111ABCDEFGHIJ");
    }

    @Title("CVSB-15130 - AC1 - Certificate number for Failures - CAR - YQ4")
    @Test
    public void testIVACertificateNumber_Failures_CAR_YQ4() {
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("C0853010911253", super.username);
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();

        // Add a Specialist Test to the test.
        testSteps.addTestType();
        testTypeCategorySteps.waitUntilPageIsLoaded();
        testTypeCategorySteps.selectFromTestTypeList("Specialist test");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("Specialist test");
        testTypeCategorySteps.selectFromTestTypeList("IVA");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("IVA");
        testTypeCategorySteps.selectFromTestTypeList("Appeal");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("Appeal");
        testTypeSubcategorySteps.selectFromTestTypeList("Basic inspection");
        //setting test result to fail
        testSteps.selectTestType("Specialist test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.setTestToOption("fail");
        testTypeDetailsSteps.checkCertificateNumberIsDisplayed();

        //Checking AC1 and AC3 - field is only 20 alphanumeric character (by removing characters)
        testTypeDetailsSteps.sendCertificateNumber("1234567890ABCDEFGHIJ123");
        testTypeDetailsSteps.checkCertificateNumberIs("1234567890ABCDEFGHIJ");
        testTypeDetailsSteps.pressSave();

        // AC2 - checking the certificate field is editable
        testSteps.waitUntilPageIsLoaded();
        testSteps.selectTestType("Specialist test", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.sendCertificateNumber("1111111111ABCDEFGHIJ");
        testTypeDetailsSteps.checkCertificateNumberIs("1111111111ABCDEFGHIJ");
        testTypeDetailsSteps.pressSave();

        // Also, as the last field (certificate number) has been populated, validation error should be removed.
        testSteps.checkErrorMessageMandatoryFieldsNotDisplayed();
        testSteps.selectTestType("Specialist test", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.checkCertificateNumberIs("1111111111ABCDEFGHIJ");
    }

    @Title("CVSB-15130 - AC1 - Certificate number for Failures - MOTORCYCLE - YXZ")
    @Test
    public void testIVACertificateNumber_Failures_MOTORCYCLE_YXZ() {
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("DP76UMK4DQLTOT400012", super.username);
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();

        // Add a Specialist Test to the test.
        testSteps.addTestType();
        testTypeCategorySteps.waitUntilPageIsLoaded();
        testTypeCategorySteps.selectFromTestTypeList("Specialist test");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("Specialist test");
        testTypeCategorySteps.selectFromTestTypeList("IVA");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("IVA");
        testTypeCategorySteps.selectFromTestTypeList("Appeal");
        testTypeSubcategorySteps.selectFromTestTypeList("Mutual recognition/ end of series & inspection");
        //setting test result to fail
        testSteps.selectTestType("Specialist test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.setTestToOption("fail");
        testTypeDetailsSteps.checkCertificateNumberIsDisplayed();

        //Checking AC1 and AC3 - field is only 20 alphanumeric character (by removing characters)
        testTypeDetailsSteps.sendCertificateNumber("1234567890ABCDEFGHIJ123");
        testTypeDetailsSteps.checkCertificateNumberIs("1234567890ABCDEFGHIJ");
        testTypeDetailsSteps.pressSave();

        // AC2 - checking the certificate field is editable
        testSteps.waitUntilPageIsLoaded();
        testSteps.selectTestType("Specialist test", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.sendCertificateNumber("1111111111ABCDEFGHIJ");
        testTypeDetailsSteps.checkCertificateNumberIs("1111111111ABCDEFGHIJ");
        testTypeDetailsSteps.pressSave();

        // Also, as the last field (certificate number) has been populated, validation error should be removed.
        testSteps.checkErrorMessageMandatoryFieldsNotDisplayed();
        testSteps.selectTestType("Specialist test", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.checkCertificateNumberIs("1111111111ABCDEFGHIJ");
    }

    @Title("CVSB-15130 - AC1 - Certificate number for Failures - CAR - YM4")
    @Test
    public void testIVACertificateNumber_Failures_CAR_YM4() {
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("C0853010911253", super.username);
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();

        // Add a Specialist Test to the test.
        testSteps.addTestType();
        testTypeCategorySteps.waitUntilPageIsLoaded();
        testTypeCategorySteps.selectFromTestTypeList("Specialist test");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("Specialist test");
        testTypeCategorySteps.selectFromTestTypeList("Retest");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("Retest");
        testTypeCategorySteps.selectFromTestTypeList("IVA");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("IVA");
        testTypeSubcategorySteps.selectFromTestTypeList("Basic inspection");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("Basic inspection");
        testTypeCategorySteps.selectFromTestTypeList("Paid");

        //setting test result to fail
        testSteps.selectTestType("Specialist test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.setTestToOption("fail");
        testTypeDetailsSteps.checkCertificateNumberIsDisplayed();

        //Checking AC1 and AC3 - field is only 20 alphanumeric character (by removing characters)
        testTypeDetailsSteps.sendCertificateNumber("1234567890ABCDEFGHIJ123");
        testTypeDetailsSteps.checkCertificateNumberIs("1234567890ABCDEFGHIJ");
        testTypeDetailsSteps.pressSave();

        // AC2 - checking the certificate field is editable
        testSteps.waitUntilPageIsLoaded();
        testSteps.selectTestType("Specialist test", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.sendCertificateNumber("1111111111ABCDEFGHIJ");
        testTypeDetailsSteps.checkCertificateNumberIs("1111111111ABCDEFGHIJ");
        testTypeDetailsSteps.pressSave();

        // Also, as the last field (certificate number) has been populated, validation error should be removed.
        testSteps.checkErrorMessageMandatoryFieldsNotDisplayed();
        testSteps.selectTestType("Specialist test", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.checkCertificateNumberIs("1111111111ABCDEFGHIJ");
    }

    @Title("CVSB-15130 - AC1 - Certificate number for Failures - LGV - YG7")
    @Test
    public void testIVACertificateNumber_Failures_LGV_YG7() {
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("BBBBBBB555666", super.username);
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();

        // Add a Specialist Test to the test.
        testSteps.addTestType();
        testTypeCategorySteps.waitUntilPageIsLoaded();
        testTypeCategorySteps.selectFromTestTypeList("Specialist test");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("Specialist test");
        testTypeCategorySteps.selectFromTestTypeList("Retest");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("Retest");
        testTypeCategorySteps.selectFromTestTypeList("IVA");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("IVA");
        testTypeSubcategorySteps.selectFromTestTypeList("Basic inspection");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("Basic inspection");
        testTypeCategorySteps.selectFromTestTypeList("Paid");

        //setting test result to fail
        testSteps.selectTestType("Specialist test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.setTestToOption("fail");
        testTypeDetailsSteps.checkCertificateNumberIsDisplayed();

        //Checking AC1 and AC3 - field is only 20 alphanumeric character (by removing characters)
        testTypeDetailsSteps.sendCertificateNumber("1234567890ABCDEFGHIJ123");
        testTypeDetailsSteps.checkCertificateNumberIs("1234567890ABCDEFGHIJ");
        testTypeDetailsSteps.pressSave();

        // AC2 - checking the certificate field is editable
        testSteps.waitUntilPageIsLoaded();
        testSteps.selectTestType("Specialist test", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.sendCertificateNumber("1111111111ABCDEFGHIJ");
        testTypeDetailsSteps.checkCertificateNumberIs("1111111111ABCDEFGHIJ");
        testTypeDetailsSteps.pressSave();

        // Also, as the last field (certificate number) has been populated, validation error should be removed.
        testSteps.checkErrorMessageMandatoryFieldsNotDisplayed();
        testSteps.selectTestType("Specialist test", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.checkCertificateNumberIs("1111111111ABCDEFGHIJ");
    }

    @Title("CVSB-15130 - AC1 - Certificate number for Failures - LGV - YM7")
    @Test
    public void testIVACertificateNumber_Failures_LGV_YM7() {
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("L0853010911254", super.username);
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();

        // Add a Specialist Test to the test.
        testSteps.addTestType();
        testTypeCategorySteps.waitUntilPageIsLoaded();
        testTypeCategorySteps.selectFromTestTypeList("Specialist test");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("Specialist test");
        testTypeCategorySteps.selectFromTestTypeList("Retest");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("Retest");
        testTypeCategorySteps.selectFromTestTypeList("IVA");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("IVA");
        testTypeSubcategorySteps.selectFromTestTypeList("Basic inspection");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("Basic inspection");
        testTypeCategorySteps.selectFromTestTypeList("Paid");

        //setting test result to fail
        testSteps.selectTestType("Specialist test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.setTestToOption("fail");
        testTypeDetailsSteps.checkCertificateNumberIsDisplayed();

        //Checking AC1 and AC3 - field is only 20 alphanumeric character (by removing characters)
        testTypeDetailsSteps.sendCertificateNumber("1234567890ABCDEFGHIJ123");
        testTypeDetailsSteps.checkCertificateNumberIs("1234567890ABCDEFGHIJ");
        testTypeDetailsSteps.pressSave();

        // AC2 - checking the certificate field is editable
        testSteps.waitUntilPageIsLoaded();
        testSteps.selectTestType("Specialist test", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.sendCertificateNumber("1111111111ABCDEFGHIJ");
        testTypeDetailsSteps.checkCertificateNumberIs("1111111111ABCDEFGHIJ");
        testTypeDetailsSteps.pressSave();

        // Also, as the last field (certificate number) has been populated, validation error should be removed.
        testSteps.checkErrorMessageMandatoryFieldsNotDisplayed();
        testSteps.selectTestType("Specialist test", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.checkCertificateNumberIs("1111111111ABCDEFGHIJ");
    }

    @Title("CVSB-15130 - AC1 - Certificate number for Failures - CAR - YH4")
    @Test
    public void testIVACertificateNumber_Failures_CAR_YH4() {
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("BBBBBBB333444", super.username);
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();

        // Add a Specialist Test to the test.
        testSteps.addTestType();
        testTypeCategorySteps.waitUntilPageIsLoaded();
        testTypeCategorySteps.selectFromTestTypeList("Specialist test");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("Specialist test");
        testTypeCategorySteps.selectFromTestTypeList("Retest");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("Retest");
        testTypeCategorySteps.selectFromTestTypeList("IVA");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("IVA");
        testTypeSubcategorySteps.selectFromTestTypeList("Basic inspection");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("Basic inspection");
        testTypeCategorySteps.selectFromTestTypeList("Free");

        //setting test result to fail
        testSteps.selectTestType("Specialist test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.setTestToOption("fail");
        testTypeDetailsSteps.checkCertificateNumberIsDisplayed();

        //Checking AC1 and AC3 - field is only 20 alphanumeric character (by removing characters)
        testTypeDetailsSteps.sendCertificateNumber("1234567890ABCDEFGHIJ123");
        testTypeDetailsSteps.checkCertificateNumberIs("1234567890ABCDEFGHIJ");
        testTypeDetailsSteps.pressSave();

        // AC2 - checking the certificate field is editable
        testSteps.waitUntilPageIsLoaded();
        testSteps.selectTestType("Specialist test", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.sendCertificateNumber("1111111111ABCDEFGHIJ");
        testTypeDetailsSteps.checkCertificateNumberIs("1111111111ABCDEFGHIJ");
        testTypeDetailsSteps.pressSave();

        // Also, as the last field (certificate number) has been populated, validation error should be removed.
        testSteps.checkErrorMessageMandatoryFieldsNotDisplayed();
        testSteps.selectTestType("Specialist test", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.checkCertificateNumberIs("1111111111ABCDEFGHIJ");
    }

    @Title("CVSB-15130 - AC1 - Certificate number for Failures - CAR - YN4")
    @Test
    public void testIVACertificateNumber_Failures_CAR_YN4() {
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("C0853010911253", super.username);
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();

        // Add a Specialist Test to the test.
        testSteps.addTestType();
        testTypeCategorySteps.waitUntilPageIsLoaded();
        testTypeCategorySteps.selectFromTestTypeList("Specialist test");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("Specialist test");
        testTypeCategorySteps.selectFromTestTypeList("Retest");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("Retest");
        testTypeCategorySteps.selectFromTestTypeList("IVA");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("IVA");
        testTypeSubcategorySteps.selectFromTestTypeList("Basic inspection");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("Basic inspection");
        testTypeCategorySteps.selectFromTestTypeList("Free");

        //setting test result to fail
        testSteps.selectTestType("Specialist test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.setTestToOption("fail");
        testTypeDetailsSteps.checkCertificateNumberIsDisplayed();

        //Checking AC1 and AC3 - field is only 20 alphanumeric character (by removing characters)
        testTypeDetailsSteps.sendCertificateNumber("1234567890ABCDEFGHIJ123");
        testTypeDetailsSteps.checkCertificateNumberIs("1234567890ABCDEFGHIJ");
        testTypeDetailsSteps.pressSave();

        // AC2 - checking the certificate field is editable
        testSteps.waitUntilPageIsLoaded();
        testSteps.selectTestType("Specialist test", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.sendCertificateNumber("1111111111ABCDEFGHIJ");
        testTypeDetailsSteps.checkCertificateNumberIs("1111111111ABCDEFGHIJ");
        testTypeDetailsSteps.pressSave();

        // Also, as the last field (certificate number) has been populated, validation error should be removed.
        testSteps.checkErrorMessageMandatoryFieldsNotDisplayed();
        testSteps.selectTestType("Specialist test", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.checkCertificateNumberIs("1111111111ABCDEFGHIJ");
    }

    @Title("CVSB-15130 - AC1 - Certificate number for Failures - LGV - YN7")
    @Test
    public void testIVACertificateNumber_Failures_LGV_YN7() {
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("C0853010911253", super.username);
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();

        // Add a Specialist Test to the test.
        testSteps.addTestType();
        testTypeCategorySteps.waitUntilPageIsLoaded();
        testTypeCategorySteps.selectFromTestTypeList("Specialist test");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("Specialist test");
        testTypeCategorySteps.selectFromTestTypeList("Retest");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("Retest");
        testTypeCategorySteps.selectFromTestTypeList("IVA");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("IVA");
        testTypeSubcategorySteps.selectFromTestTypeList("Basic inspection");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("Basic inspection");
        testTypeCategorySteps.selectFromTestTypeList("Free");

        //setting test result to fail
        testSteps.selectTestType("Specialist test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.setTestToOption("fail");
        testTypeDetailsSteps.checkCertificateNumberIsDisplayed();

        //Checking AC1 and AC3 - field is only 20 alphanumeric character (by removing characters)
        testTypeDetailsSteps.sendCertificateNumber("1234567890ABCDEFGHIJ123");
        testTypeDetailsSteps.checkCertificateNumberIs("1234567890ABCDEFGHIJ");
        testTypeDetailsSteps.pressSave();

        // AC2 - checking the certificate field is editable
        testSteps.waitUntilPageIsLoaded();
        testSteps.selectTestType("Specialist test", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.sendCertificateNumber("1111111111ABCDEFGHIJ");
        testTypeDetailsSteps.checkCertificateNumberIs("1111111111ABCDEFGHIJ");
        testTypeDetailsSteps.pressSave();

        // Also, as the last field (certificate number) has been populated, validation error should be removed.
        testSteps.checkErrorMessageMandatoryFieldsNotDisplayed();
        testSteps.selectTestType("Specialist test", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.checkCertificateNumberIs("1111111111ABCDEFGHIJ");
    }

    @Title("CVSB-15130 - AC1 - Certificate number for Failures - LGV - YH7")
    @Test
    public void testIVACertificateNumber_Failures_LGV_YH7() {
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("BBBBBBB555666", super.username);
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();

        // Add a Specialist Test to the test.
        testSteps.addTestType();
        testTypeCategorySteps.waitUntilPageIsLoaded();
        testTypeCategorySteps.selectFromTestTypeList("Specialist test");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("Specialist test");
        testTypeCategorySteps.selectFromTestTypeList("Retest");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("Retest");
        testTypeCategorySteps.selectFromTestTypeList("IVA");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("IVA");
        testTypeSubcategorySteps.selectFromTestTypeList("Basic inspection");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("Basic inspection");
        testTypeCategorySteps.selectFromTestTypeList("Free");

        //setting test result to fail
        testSteps.selectTestType("Specialist test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.setTestToOption("fail");
        testTypeDetailsSteps.checkCertificateNumberIsDisplayed();

        //Checking AC1 and AC3 - field is only 20 alphanumeric character (by removing characters)
        testTypeDetailsSteps.sendCertificateNumber("1234567890ABCDEFGHIJ123");
        testTypeDetailsSteps.checkCertificateNumberIs("1234567890ABCDEFGHIJ");
        testTypeDetailsSteps.pressSave();

        // AC2 - checking the certificate field is editable
        testSteps.waitUntilPageIsLoaded();
        testSteps.selectTestType("Specialist test", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.sendCertificateNumber("1111111111ABCDEFGHIJ");
        testTypeDetailsSteps.checkCertificateNumberIs("1111111111ABCDEFGHIJ");
        testTypeDetailsSteps.pressSave();

        // Also, as the last field (certificate number) has been populated, validation error should be removed.
        testSteps.checkErrorMessageMandatoryFieldsNotDisplayed();
        testSteps.selectTestType("Specialist test", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.checkCertificateNumberIs("1111111111ABCDEFGHIJ");
    }

    @Title("CVSB-15130 - AC1 - Certificate number for Failures - CAR - YB4")
    @Test
    public void testIVACertificateNumber_Failures_CAR_YB4() {
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("D0853010911255", super.username);
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();

        // Add a Specialist Test to the test.
        testSteps.addTestType();
        testTypeCategorySteps.waitUntilPageIsLoaded();
        testTypeCategorySteps.selectFromTestTypeList("Specialist test");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("Specialist test");
        testTypeCategorySteps.selectFromTestTypeList("Retest");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("Retest");
        testTypeCategorySteps.selectFromTestTypeList("IVA");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("IVA");
        testTypeSubcategorySteps.selectFromTestTypeList("Normal inspection");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("Normal inspection");
        testTypeCategorySteps.selectFromTestTypeList("Paid");

        //setting test result to fail
        testSteps.selectTestType("Specialist test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.setTestToOption("fail");
        testTypeDetailsSteps.checkCertificateNumberIsDisplayed();

        //Checking AC1 and AC3 - field is only 20 alphanumeric character (by removing characters)
        testTypeDetailsSteps.sendCertificateNumber("1234567890ABCDEFGHIJ123");
        testTypeDetailsSteps.checkCertificateNumberIs("1234567890ABCDEFGHIJ");
        testTypeDetailsSteps.pressSave();

        // AC2 - checking the certificate field is editable
        testSteps.waitUntilPageIsLoaded();
        testSteps.selectTestType("Specialist test", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.sendCertificateNumber("1111111111ABCDEFGHIJ");
        testTypeDetailsSteps.checkCertificateNumberIs("1111111111ABCDEFGHIJ");
        testTypeDetailsSteps.pressSave();

        // Also, as the last field (certificate number) has been populated, validation error should be removed.
        testSteps.checkErrorMessageMandatoryFieldsNotDisplayed();
        testSteps.selectTestType("Specialist test", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.checkCertificateNumberIs("1111111111ABCDEFGHIJ");
    }

    @Title("CVSB-15130 - AC1 - Certificate number for Failures - PSV - YBS")
    @Test
    public void testIVACertificateNumber_Failures_PSV_YBS() {
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("1B7GG36N12S678410", super.username);
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();

        // Add a Specialist Test to the test.
        testSteps.addTestType();
        testTypeCategorySteps.waitUntilPageIsLoaded();
        testTypeCategorySteps.selectFromTestTypeList("Specialist test");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("Specialist test");
        testTypeCategorySteps.selectFromTestTypeList("Retest");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("Retest");
        testTypeCategorySteps.selectFromTestTypeList("IVA");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("IVA");
        testTypeSubcategorySteps.selectFromTestTypeList("Normal inspection");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("Normal inspection");
        testTypeCategorySteps.selectFromTestTypeList("Paid");

        //setting test result to fail
        testSteps.selectTestType("Specialist test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.setTestToOption("fail");
        testTypeDetailsSteps.checkCertificateNumberIsDisplayed();

        //Checking AC1 and AC3 - field is only 20 alphanumeric character (by removing characters)
        testTypeDetailsSteps.sendCertificateNumber("1234567890ABCDEFGHIJ123");
        testTypeDetailsSteps.checkCertificateNumberIs("1234567890ABCDEFGHIJ");
        testTypeDetailsSteps.pressSave();

        // AC2 - checking the certificate field is editable
        testSteps.waitUntilPageIsLoaded();
        testSteps.selectTestType("Specialist test", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.sendCertificateNumber("1111111111ABCDEFGHIJ");
        testTypeDetailsSteps.checkCertificateNumberIs("1111111111ABCDEFGHIJ");
        testTypeDetailsSteps.pressSave();

        // Also, as the last field (certificate number) has been populated, validation error should be removed.
        testSteps.checkErrorMessageMandatoryFieldsNotDisplayed();
        testSteps.selectTestType("Specialist test", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.checkCertificateNumberIs("1111111111ABCDEFGHIJ");
    }

    @Title("CVSB-15130 - AC1 - Certificate number for Failures - PSV - YFL")
    @Test
    public void testIVACertificateNumber_Failures_PSV_YFL() {
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("YV31MEC18GA678413", super.username);
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();

        // Add a Specialist Test to the test.
        testSteps.addTestType();
        testTypeCategorySteps.waitUntilPageIsLoaded();
        testTypeCategorySteps.selectFromTestTypeList("Specialist test");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("Specialist test");
        testTypeCategorySteps.selectFromTestTypeList("Retest");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("Retest");
        testTypeCategorySteps.selectFromTestTypeList("IVA");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("IVA");
        testTypeSubcategorySteps.selectFromTestTypeList("Normal inspection");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("Normal inspection");
        testTypeCategorySteps.selectFromTestTypeList("Paid");

        //setting test result to fail
        testSteps.selectTestType("Specialist test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.setTestToOption("fail");
        testTypeDetailsSteps.checkCertificateNumberIsDisplayed();

        //Checking AC1 and AC3 - field is only 20 alphanumeric character (by removing characters)
        testTypeDetailsSteps.sendCertificateNumber("1234567890ABCDEFGHIJ123");
        testTypeDetailsSteps.checkCertificateNumberIs("1234567890ABCDEFGHIJ");
        testTypeDetailsSteps.pressSave();

        // AC2 - checking the certificate field is editable
        testSteps.waitUntilPageIsLoaded();
        testSteps.selectTestType("Specialist test", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.sendCertificateNumber("1111111111ABCDEFGHIJ");
        testTypeDetailsSteps.checkCertificateNumberIs("1111111111ABCDEFGHIJ");
        testTypeDetailsSteps.pressSave();

        // Also, as the last field (certificate number) has been populated, validation error should be removed.
        testSteps.checkErrorMessageMandatoryFieldsNotDisplayed();
        testSteps.selectTestType("Specialist test", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.checkCertificateNumberIs("1111111111ABCDEFGHIJ");
    }

    @Title("CVSB-15130 - AC1 - Certificate number for Failures - CAR - YF4")
    @Test
    public void testIVACertificateNumber_Failures_CAR_YF4() {
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("DP76UMK4DQLTOT400005", super.username);
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();

        // Add a Specialist Test to the test.
        testSteps.addTestType();
        testTypeCategorySteps.waitUntilPageIsLoaded();
        testTypeCategorySteps.selectFromTestTypeList("Specialist test");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("Specialist test");
        testTypeCategorySteps.selectFromTestTypeList("IVA");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("IVA");
        testTypeCategorySteps.selectFromTestTypeList("Basic inspection");

        testSteps.selectOdometerReading();
        odometerReadingSteps.typeInField("12345");
        odometerReadingSteps.pressSave();

        //setting test result to fail
        testSteps.selectTestType("Specialist test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.setTestToOption("fail");
        testTypeDetailsSteps.checkCertificateNumberIsDisplayed();

        //Checking AC1 and AC3 - field is only 20 alphanumeric character (by removing characters)
        testTypeDetailsSteps.sendCertificateNumber("1234567890ABCDEFGHIJ123");
        testTypeDetailsSteps.checkCertificateNumberIs("1234567890ABCDEFGHIJ");
        testTypeDetailsSteps.pressSave();

        // Also, as the last field (certificate number) has been populated, validation error should be removed.
        testSteps.checkErrorMessageMandatoryFieldsNotDisplayed();
        testSteps.selectTestType("Specialist test", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.checkCertificateNumberIs("1234567890ABCDEFGHIJ");
    }

    @Title("CVSB-15130 - AC1 - Certificate number for Failures - CAR - YL4")
    @Test
    public void testIVACertificateNumber_Failures_CAR_YL4() {
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("C0853010911253", super.username);
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();

        // Add a Specialist Test to the test.
        testSteps.addTestType();
        testTypeCategorySteps.waitUntilPageIsLoaded();
        testTypeCategorySteps.selectFromTestTypeList("Specialist test");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("Specialist test");
        testTypeCategorySteps.selectFromTestTypeList("IVA");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("IVA");
        testTypeCategorySteps.selectFromTestTypeList("Basic inspection");

        testSteps.selectOdometerReading();
        odometerReadingSteps.typeInField("12345");
        odometerReadingSteps.pressSave();

        //setting test result to fail
        testSteps.selectTestType("Specialist test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.setTestToOption("fail");
        testTypeDetailsSteps.checkCertificateNumberIsDisplayed();

        //Checking AC1 and AC3 - field is only 20 alphanumeric character (by removing characters)
        testTypeDetailsSteps.sendCertificateNumber("1234567890ABCDEFGHIJ123");
        testTypeDetailsSteps.checkCertificateNumberIs("1234567890ABCDEFGHIJ");
        testTypeDetailsSteps.pressSave();

        // Also, as the last field (certificate number) has been populated, validation error should be removed.
        testSteps.checkErrorMessageMandatoryFieldsNotDisplayed();
        testSteps.selectTestType("Specialist test", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.checkCertificateNumberIs("1234567890ABCDEFGHIJ");
    }

    @Title("CVSB-15130 - AC1 - Certificate number for Failures - LGV - YF7")
    @Test
    public void testIVACertificateNumber_Failures_LGV_YF7() {
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("P0123010951264", super.username);
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();

        // Add a Specialist Test to the test.
        testSteps.addTestType();
        testTypeCategorySteps.waitUntilPageIsLoaded();
        testTypeCategorySteps.selectFromTestTypeList("Specialist test");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("Specialist test");
        testTypeCategorySteps.selectFromTestTypeList("IVA");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("IVA");
        testTypeCategorySteps.selectFromTestTypeList("Basic inspection");

        testSteps.selectOdometerReading();
        odometerReadingSteps.typeInField("12345");
        odometerReadingSteps.pressSave();

        //setting test result to fail
        testSteps.selectTestType("Specialist test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.setTestToOption("fail");
        testTypeDetailsSteps.checkCertificateNumberIsDisplayed();

        //Checking AC1 and AC3 - field is only 20 alphanumeric character (by removing characters)
        testTypeDetailsSteps.sendCertificateNumber("1234567890ABCDEFGHIJ123");
        testTypeDetailsSteps.checkCertificateNumberIs("1234567890ABCDEFGHIJ");
        testTypeDetailsSteps.pressSave();

        // Also, as the last field (certificate number) has been populated, validation error should be removed.
        testSteps.checkErrorMessageMandatoryFieldsNotDisplayed();
        testSteps.selectTestType("Specialist test", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.checkCertificateNumberIs("1234567890ABCDEFGHIJ");
    }

    @Title("CVSB-15130 - AC1 - Certificate number for Failures - LGV - YL7")
    @Test
    public void testIVACertificateNumber_Failures_LGV_YL7() {
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("L0853010911254", super.username);
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();

        // Add a Specialist Test to the test.
        testSteps.addTestType();
        testTypeCategorySteps.waitUntilPageIsLoaded();
        testTypeCategorySteps.selectFromTestTypeList("Specialist test");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("Specialist test");
        testTypeCategorySteps.selectFromTestTypeList("IVA");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("IVA");
        testTypeCategorySteps.selectFromTestTypeList("Basic inspection");

        testSteps.selectOdometerReading();
        odometerReadingSteps.typeInField("12345");
        odometerReadingSteps.pressSave();

        //setting test result to fail
        testSteps.selectTestType("Specialist test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.setTestToOption("fail");
        testTypeDetailsSteps.checkCertificateNumberIsDisplayed();

        //Checking AC1 and AC3 - field is only 20 alphanumeric character (by removing characters)
        testTypeDetailsSteps.sendCertificateNumber("1234567890ABCDEFGHIJ123");
        testTypeDetailsSteps.checkCertificateNumberIs("1234567890ABCDEFGHIJ");
        testTypeDetailsSteps.pressSave();

        // Also, as the last field (certificate number) has been populated, validation error should be removed.
        testSteps.checkErrorMessageMandatoryFieldsNotDisplayed();
        testSteps.selectTestType("Specialist test", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.checkCertificateNumberIs("1234567890ABCDEFGHIJ");
    }
    //test 1

}