package testresults.CVSB_981;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import pages.SelectReasonPage;
import pages.TestPage;
import steps.*;
import steps.composed.TestTypeCategoryComp;
import util.BaseTestClass;

@RunWith(SerenityRunner.class)
public class AutoCalculateAbandonedTestResults_CVSB_2212 extends BaseTestClass {

    @Steps
    TestSteps testSteps;

    @Steps
    TestTypeCategorySteps testTypeCategorySteps;

    @Steps
    TestTypeCategoryComp testTypeCategoryComp;

    @Steps
    AbandonTestSteps abandonTestSteps;

    @Steps
    SelectReasonSteps selectReasonSteps;

    @Steps
    TestReviewSteps testReviewSteps;

    @Steps
    EUVehicleCategorySteps euVehicleCategorySteps;

    @Steps
    OdometerReadingSteps odometerReadingSteps;

    @Steps
    CountryOfRegistrationSteps countryOfRegistrationSteps;

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
    AdvisoryDetailsSteps advisoryDetailsSteps;

    @Title("CVSB_981 - AC1 Auto-calculate test results upon abandoning a test type")
    @Test
    public void testAbandonTestTypeTestResultCalculation() {
        testTypeCategoryComp.goToTestPage(preparerService.getPreparerByIndex(0).getPreparerId(),preparerService.getPreparerByIndex(0).getPreparerName());
        // complete test overview fields
        testSteps.clickCountryOfRegistrationOption();
        countryOfRegistrationSteps.selectACountry("Norway");
        testSteps.checkCountryOfRegistrationFieldIsUpdated("Norway");
        testSteps.selectVehicleCategoryOption();
        euVehicleCategorySteps.selectM1Option();
        testSteps.selectOdometerReading();
        odometerReadingSteps.typeInField("123");
        odometerReadingSteps.checkReadingValue("123");
        odometerReadingSteps.pressSave();
        testSteps.addTestType();
        testTypeCategorySteps.selectFromTestTypeList("Annual test");
        testSteps.selectTestType("Annual test", TestPage.TestTypeStatuses.IN_PROGRESS);
        // add variety of defects
        testTypeDetailsSteps.selectAddDefect("Annual test");
        defectCategorySteps.selectDefectFromList("8. Condition of Tyres");
        defectItemSteps.selectDefectFromList("1. A tyre");
        defectDescriptionSteps.selectDefect("8.1 (d) (i) MINOR");
        defectDetailsSteps.tapDone();
        testTypeDetailsSteps.selectAddDefect("Annual test");
        defectCategorySteps.selectDefectFromList("1. Registration Plate");
        defectItemSteps.selectDefectFromList("2. A registration mark");
        defectDescriptionSteps.tapAddAnAdvisoryNote();
        advisoryDetailsSteps.addCustomNoteAndTapAddNote("Test 1234");
        testTypeDetailsSteps.selectAddDefect("Annual test");
        defectCategorySteps.selectDefectFromList("8. Condition of Tyres");
        defectItemSteps.selectDefectFromList("1. A tyre");
        defectDescriptionSteps.selectDefect("8.1 (b) DANGEROUS");
        defectDetailsSteps.scrollDefectDetailsPage();
        defectDetailsSteps.setProhibitionIssued();
        defectDetailsSteps.tapDone();
        testTypeDetailsSteps.selectAddDefect("Annual test");
        defectCategorySteps.selectDefectFromList("8. Condition of Tyres");
        defectItemSteps.selectDefectFromList("1. A tyre");
        defectDescriptionSteps.selectDefect("8.1 (a) MAJOR");
        defectDetailsSteps.setPRS();
        defectDetailsSteps.tapDone();
        testTypeDetailsSteps.pressSave();
        // abandon test type
        testSteps.swipeTestType("Annual test");
        testSteps.pressTestTypeAbandonButton();
        selectReasonSteps.selectAReason(SelectReasonPage.Reasons.REASON_1);
        selectReasonSteps.pressNextButton();
        abandonTestSteps.pressDone();
        abandonTestSteps.pressAbandon();
        testSteps.checkTestTypeStatus("Annual test", TestPage.TestTypeStatuses.ABANDONED);
        testSteps.reviewAction();
        testReviewSteps.checkTestStatus("Annual test", "ABANDONED");
        testReviewSteps.changeDetailsIsNotDisplayed();
    }
}
