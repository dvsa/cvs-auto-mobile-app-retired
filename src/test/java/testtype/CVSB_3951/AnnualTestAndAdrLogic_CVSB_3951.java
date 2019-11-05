package testtype.CVSB_3951;

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
public class AnnualTestAndAdrLogic_CVSB_3951 extends BaseTestClass {

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

    @Title("CVSB-3951 - TCD - AC1 - Annual test has failed")
    @Test
    public void testListFromAddLinkedTestTypeAnnualPlusTechnical() {
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
        testTypeCategorySteps.selectFromTestTypeList("Annual test");
        testSteps.checkTestTypeStatus("Annual test", TestPage.TestTypeStatuses.EDIT);
        testSteps.addLinkedTestType();
        testTypeCategorySteps.selectFromTestTypeList("Technical test");
        testTypeCategorySteps.selectFromTestTypeList("ADR");
        testSteps.checkTestTypeStatus("Technical test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testSteps.selectTestType("Technical test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.checkTestStatusIsNotSet();
        testTypeDetailsSteps.pressSave();
        testSteps.selectTestType("Annual test", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.clickAddDefect();
        defectCategorySteps.searchForDefect("6");
        defectCategorySteps.selectDefectFromList("6. Road Wheels and Hubs");
        defectCategorySteps.selectDefectFromList("2. A wheel:");
        defectDescriptionSteps.selectDefect("6.2 (a) (ii) DANGEROUS");
        defectDetailsSteps.setProhibitionIssued();
        defectDetailsSteps.tapDone();
        testTypeDetailsSteps.pressSave();
        testSteps.selectTestType("Technical test", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.checkTestIsFailed();
        testTypeDetailsSteps.pressSave();
        testSteps.selectTestType("Annual test", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.clickOnDefect("6.2 (a) (ii) DANGEROUS");
        defectDetailsSteps.pressRemove();
        defectDetailsSteps.pressRemoveInPopUp();
        testTypeDetailsSteps.pressSave();
        testSteps.selectTestType("Technical test", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.setTestToOption("pass");
        testTypeDetailsSteps.sendCertificateNumber("123456");
        testTypeDetailsSteps.setExpiryDateDefault();
        testTypeDetailsSteps.setProhibitionIssued();
        testTypeDetailsSteps.pressSave();
        testSteps.checkTestTypeStatus("Technical test", TestPage.TestTypeStatuses.EDIT);
        testSteps.checkTestTypeStatus("Annual test", TestPage.TestTypeStatuses.EDIT);
        testSteps.selectTestType("Annual test", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.clickAddDefect();
        defectCategorySteps.searchForDefect("6");
        defectCategorySteps.selectDefectFromList("6. Road Wheels and Hubs");
        defectCategorySteps.selectDefectFromList("2. A wheel:");
        defectDescriptionSteps.selectDefect("6.2 (a) (ii) DANGEROUS");
        defectDetailsSteps.setProhibitionIssued();
        defectDetailsSteps.tapDone();
        testTypeDetailsSteps.pressSave();
        testSteps.clickReviewAndSubmit();
        testReviewSteps.checkPageTitleIsDisplayed();
        testReviewSteps.checkTestStatus("Annual test", "FAIL");
        testReviewSteps.scrollDown();
        testReviewSteps.checkTestStatus("ADR test", "FAIL");
    }
}
