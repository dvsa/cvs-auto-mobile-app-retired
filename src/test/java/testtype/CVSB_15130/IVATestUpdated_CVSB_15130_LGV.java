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
public class IVATestUpdated_CVSB_15130_LGV extends BaseTestClass {

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

    @Title("CVSB-15130 - AC1 - Certificate number for Failures - LGV - YA7, YE7")
    @Test
    public void testIVACertificateNumber_Failures_LGV_YA7_YE7() {
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

        // Remove the test type to add next set of code for YE7.
        testSteps.checkErrorMessageMandatoryFieldsNotDisplayed();
        testSteps.selectTestType("Specialist test", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.pressTestTypeRemoveButton();
        testTypeDetailsSteps.checkTestTypeRemovalPopUp();
        testPage.clickRemoveFromPopUp();

        // Add a Specialist Test to the test - YE7
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
    }

    @WithTag("In-test")
    @Title("CVSB-15130 - AC1 - Certificate number for Failures - LGV - YK7, YH7, YG7")
    @Test
    public void testIVACertificateNumber_Failures_LGV_YK7_YH7_YG7() {
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

        // Remove the test type to add next set of code for YG7.
        testSteps.checkErrorMessageMandatoryFieldsNotDisplayed();
        testSteps.selectTestType("Specialist test", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.pressTestTypeRemoveButton();
        testTypeDetailsSteps.checkTestTypeRemovalPopUp();
        testPage.clickRemoveFromPopUp();

        // Add a Specialist Test to the test - YG7
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

        // Remove the test type to add next set of code for YH7.
        testSteps.checkErrorMessageMandatoryFieldsNotDisplayed();
        testSteps.selectTestType("Specialist test", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.pressTestTypeRemoveButton();
        testTypeDetailsSteps.checkTestTypeRemovalPopUp();
        testPage.clickRemoveFromPopUp();

        // Add a Specialist Test to the test - YH7
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
    }

    @Title("CVSB-15130 - AC1 - Certificate number for Failures - LGV - YQ7")
    @Test
    public void testIVACertificateNumber_Failures_LGV_YQ7() {
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("L0853010911254", super.username);
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();

        // Add a Specialist Test to the test - YQ7
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

        // Remove the test type to add next set of code for YM7.
        testSteps.checkErrorMessageMandatoryFieldsNotDisplayed();
        testSteps.selectTestType("Specialist test", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.pressTestTypeRemoveButton();
        testTypeDetailsSteps.checkTestTypeRemovalPopUp();
        testPage.clickRemoveFromPopUp();

        // Add a Specialist Test to the test - YM7
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

        // Remove the test type to add next set of code for YL7.
        testSteps.checkErrorMessageMandatoryFieldsNotDisplayed();
        testSteps.selectTestType("Specialist test", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.pressTestTypeRemoveButton();
        testTypeDetailsSteps.checkTestTypeRemovalPopUp();
        testPage.clickRemoveFromPopUp();

        // Add a Specialist Test to the test - YL7
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

    }

    @Title("CVSB-15130 AC1-AC4 - certificate number failures for IVA retest - LGV - YB7")
    @Test
    public void testIVACertificateNumber_Failures_LGV_YB7() {
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("H0853010911212", super.username);
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
        testTypeCategorySteps.selectFromTestTypeList("Normal inspection");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("Normal inspection");
        testTypeCategorySteps.selectFromTestTypeList("Paid");

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

        // Remove the test type to add next set of code for YC7.
        testSteps.checkErrorMessageMandatoryFieldsNotDisplayed();
        testSteps.selectTestType("Specialist test", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.pressTestTypeRemoveButton();
        testTypeDetailsSteps.checkTestTypeRemovalPopUp();
        testPage.clickRemoveFromPopUp();

        // Add a Specialist Test to the test - YC7
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

}
