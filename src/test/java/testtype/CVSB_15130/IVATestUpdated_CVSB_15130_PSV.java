package testtype.CVSB_15130;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.core.annotations.WithTag;
import org.junit.Test;
import org.junit.runner.RunWith;
import pages.TestPage;
import steps.*;
import steps.composed.TestTypeCategoryComp;
import steps.util.UtilSteps;
import utils.BaseTestClass;

@RunWith(SerenityRunner.class)
public class IVATestUpdated_CVSB_15130_PSV extends BaseTestClass {

    @Steps
    UtilSteps utilSteps;

    @Steps
    PreparerSteps preparerSteps;

    @Steps
    TestSteps testSteps;

    @Steps
    TestPage testPage;

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

    @Title("CVSB-15130 - AC1 - Certificate number for Failures - PSV - YAS, YDS, YBS, YCS")
    @Test
    public void testIVACertificateNumber_Failures_PSV_YAS_YDS_YBS_YCS() {
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("1B7GG36N12S678410", super.username);
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();

        // Add a Specialist Test to the test - YAS
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

        // Remove the test type to add next set of code for YDS.
        testSteps.checkErrorMessageMandatoryFieldsNotDisplayed();
        testSteps.selectTestType("Specialist test", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.pressTestTypeRemoveButton();
        testTypeDetailsSteps.checkTestTypeRemovalPopUp();
        testPage.clickRemoveFromPopUp();

        //test case for Certificate number for Failures - PSV - YDS
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

        // Remove the test type to add next set of code for YBS.
        testSteps.checkErrorMessageMandatoryFieldsNotDisplayed();
        testSteps.selectTestType("Specialist test", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.pressTestTypeRemoveButton();
        testTypeDetailsSteps.checkTestTypeRemovalPopUp();
        testPage.clickRemoveFromPopUp();

        //test case for Certificate number for Failures - PSV - YBS
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

        // Remove the test type to add next set of code for YCS.
        testSteps.checkErrorMessageMandatoryFieldsNotDisplayed();
        testSteps.selectTestType("Specialist test", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.pressTestTypeRemoveButton();
        testTypeDetailsSteps.checkTestTypeRemovalPopUp();
        testPage.clickRemoveFromPopUp();

        // Add a Specialist Test to the test for YCS.
        testSteps.addTestType();
        testTypeCategorySteps.waitUntilPageIsLoaded();
        testTypeCategorySteps.selectFromTestTypeList("Specialist test");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("Specialist test");
        testTypeCategorySteps.selectFromTestTypeList("Retest");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("Retest");
        testTypeCategorySteps.selectFromTestTypeList("IVA");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("IVA");
        testTypeCategorySteps.selectFromTestTypeList("Normal inspection");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("Normal inspection");
        testTypeCategorySteps.selectFromTestTypeList("Free");

        testSteps.selectOdometerReading();
        odometerReadingSteps.typeInField("12345");
        odometerReadingSteps.pressSave();

        testSteps.selectTestType("Specialist test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.setTestToOption("fail");
        testTypeDetailsSteps.checkCertificateNumberIsDisplayed();

        //Checking AC1 and AC3 - field is only 20 alphanumeric character (by removing characters)
        testTypeDetailsSteps.sendCertificateNumber("1234567890ABCDEFGHIJ123");
        testTypeDetailsSteps.checkCertificateNumberIs("1234567890ABCDEFGHIJ");
        testTypeDetailsSteps.pressSave();
    }

    @Title("CVSB-15130 - AC1 - Certificate number for Failures - PSV - YEL, YHL, YFL,YGL")
    @Test
    public void testIVACertificateNumber_Failures_PSV_YEL_YHL_YFL_YGL() {
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("YV31MEC18GA678413", super.username);
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();

        // Add a Specialist Test to the test - YEL
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

        // Remove the test type to add next set of code for YHL.
        testSteps.checkErrorMessageMandatoryFieldsNotDisplayed();
        testSteps.selectTestType("Specialist test", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.pressTestTypeRemoveButton();
        testTypeDetailsSteps.checkTestTypeRemovalPopUp();
        testPage.clickRemoveFromPopUp();

        // Add a Specialist Test to the test - YHL
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

        // Remove the test type to add next set of code for YFL.
        testSteps.checkErrorMessageMandatoryFieldsNotDisplayed();
        testSteps.selectTestType("Specialist test", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.pressTestTypeRemoveButton();
        testTypeDetailsSteps.checkTestTypeRemovalPopUp();
        testPage.clickRemoveFromPopUp();

        // Add a Specialist Test to the test - YFL
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

        // Remove the test type to add next set of code for YGL.
        testSteps.checkErrorMessageMandatoryFieldsNotDisplayed();
        testSteps.selectTestType("Specialist test", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.pressTestTypeRemoveButton();
        testTypeDetailsSteps.checkTestTypeRemovalPopUp();
        testPage.clickRemoveFromPopUp();

        // Add a Specialist Test to the test-YGL
        testSteps.addTestType();
        testTypeCategorySteps.waitUntilPageIsLoaded();
        testTypeCategorySteps.selectFromTestTypeList("Specialist test");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("Specialist test");
        testTypeCategorySteps.selectFromTestTypeList("Retest");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("Retest");
        testTypeCategorySteps.selectFromTestTypeList("IVA");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("IVA");
        testTypeCategorySteps.selectFromTestTypeList("Normal inspection");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("Normal inspection");
        testTypeCategorySteps.selectFromTestTypeList("Free");
        testSteps.selectEuVehicleCategory();
        euVehicleCategorySteps.selectM2Option();
        testSteps.selectOdometerReading();
        odometerReadingSteps.typeInField("12345");
        odometerReadingSteps.pressSave();

        testSteps.selectTestType("Specialist test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.setTestToOption("fail");
        testTypeDetailsSteps.checkCertificateNumberIsDisplayed();

        //Checking AC1 and AC3 - field is only 20 alphanumeric character (by removing characters)
        testTypeDetailsSteps.sendCertificateNumber("1234567890ABCDEFGHIJ123");
        testTypeDetailsSteps.checkCertificateNumberIs("1234567890ABCDEFGHIJ");
        testTypeDetailsSteps.pressSave();

    }

    @Title("CVSB-15130 - AC1 - Certificate number for Failures - PSV - YJL, YML, YKL, YLL, YUZ")
    @Test
    public void testIVACertificateNumber_Failures_PSV_YJL_YML_YKL_YLL_YUZ() {
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("XMGDE02FS0H012356", super.username);
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();

        // Add a Specialist Test to the test - YJL
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

        // Remove the test type to add next set of code for YML.
        testSteps.checkErrorMessageMandatoryFieldsNotDisplayed();
        testSteps.selectTestType("Specialist test", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.pressTestTypeRemoveButton();
        testTypeDetailsSteps.checkTestTypeRemovalPopUp();
        testPage.clickRemoveFromPopUp();

        // Add a Specialist Test to the test - YML
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

        // Remove the test type to add next set of code for YKL.
        testSteps.checkErrorMessageMandatoryFieldsNotDisplayed();
        testSteps.selectTestType("Specialist test", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.pressTestTypeRemoveButton();
        testTypeDetailsSteps.checkTestTypeRemovalPopUp();
        testPage.clickRemoveFromPopUp();

        // Add a Specialist Test to the test - YKL
        testSteps.addTestType();
        testTypeCategorySteps.waitUntilPageIsLoaded();
        testTypeCategorySteps.selectFromTestTypeList("Specialist test");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("Specialist test");
        testTypeCategorySteps.selectFromTestTypeList("Retest");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("Retest");
        testTypeCategorySteps.selectFromTestTypeList("IVA");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("IVA");
        testTypeCategorySteps.selectFromTestTypeList("Normal inspection");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("Normal inspection");
        testTypeCategorySteps.selectFromTestTypeList("Paid");
        testSteps.selectEuVehicleCategory();
        euVehicleCategorySteps.selectM2Option();
        testSteps.selectOdometerReading();
        odometerReadingSteps.typeInField("12345");
        odometerReadingSteps.pressSave();

        testSteps.selectTestType("Specialist test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.setTestToOption("fail");
        testTypeDetailsSteps.checkCertificateNumberIsDisplayed();

        //Checking AC1 and AC3 - field is only 20 alphanumeric character (by removing characters)
        testTypeDetailsSteps.sendCertificateNumber("1234567890ABCDEFGHIJ123");
        testTypeDetailsSteps.checkCertificateNumberIs("1234567890ABCDEFGHIJ");
        testTypeDetailsSteps.pressSave();

        // Remove the test type to add next set of code for YLL.
        testSteps.checkErrorMessageMandatoryFieldsNotDisplayed();
        testSteps.selectTestType("Specialist test", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.pressTestTypeRemoveButton();
        testTypeDetailsSteps.checkTestTypeRemovalPopUp();
        testPage.clickRemoveFromPopUp();

        // Add a Specialist Test to the test - YLL
        testSteps.addTestType();
        testTypeCategorySteps.waitUntilPageIsLoaded();
        testTypeCategorySteps.selectFromTestTypeList("Specialist test");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("Specialist test");
        testTypeCategorySteps.selectFromTestTypeList("Retest");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("Retest");
        testTypeCategorySteps.selectFromTestTypeList("IVA");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("IVA");
        testTypeCategorySteps.selectFromTestTypeList("Normal inspection");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("Normal inspection");
        testTypeCategorySteps.selectFromTestTypeList("Free");
        testSteps.selectEuVehicleCategory();
        euVehicleCategorySteps.selectM2Option();
        testSteps.selectOdometerReading();
        odometerReadingSteps.typeInField("12345");
        odometerReadingSteps.pressSave();

        testSteps.selectTestType("Specialist test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.setTestToOption("fail");
        testTypeDetailsSteps.checkCertificateNumberIsDisplayed();

        //Checking AC1 and AC3 - field is only 20 alphanumeric character (by removing characters)
        testTypeDetailsSteps.sendCertificateNumber("1234567890ABCDEFGHIJ123");
        testTypeDetailsSteps.checkCertificateNumberIs("1234567890ABCDEFGHIJ");
        testTypeDetailsSteps.pressSave();

        // Remove the test type to add next set of code for YUZ.
        testSteps.checkErrorMessageMandatoryFieldsNotDisplayed();
        testSteps.selectTestType("Specialist test", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.pressTestTypeRemoveButton();
        testTypeDetailsSteps.checkTestTypeRemovalPopUp();
        testPage.clickRemoveFromPopUp();

        // Add a Specialist Test to the test - YUZ
        testSteps.addTestType();
        testTypeCategorySteps.waitUntilPageIsLoaded();
        testTypeCategorySteps.selectFromTestTypeList("Specialist test");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("Specialist test");
        testTypeCategorySteps.selectFromTestTypeList("Retest");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("Retest");
        testTypeCategorySteps.selectFromTestTypeList("IVA");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("IVA");
        testTypeCategorySteps.selectFromTestTypeList("Mutual recognition/ end of series");
        testSteps.selectEuVehicleCategory();
        euVehicleCategorySteps.selectM2Option();
        testSteps.selectOdometerReading();
        odometerReadingSteps.typeInField("12345");
        odometerReadingSteps.pressSave();

        testSteps.selectTestType("Specialist test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.setTestToOption("fail");
        testTypeDetailsSteps.checkCertificateNumberIsDisplayed();

        //Checking AC1 and AC3 - field is only 20 alphanumeric character (by removing characters)
        testTypeDetailsSteps.sendCertificateNumber("1234567890ABCDEFGHIJ123");
        testTypeDetailsSteps.checkCertificateNumberIs("1234567890ABCDEFGHIJ");
        testTypeDetailsSteps.pressSave();
    }

}
