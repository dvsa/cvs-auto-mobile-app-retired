package testresults.CVSB_17386;

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
public class TestResultCalculationInFrontEnd_CVSB_17386 extends BaseTestClass {

    @Steps
    UtilSteps utilSteps;

    @Steps
    TestTypeCategoryComp testTypeCategoryComp;

    @Steps
    TestTypeDetailsSteps testTypeDetailsSteps;

    @Steps
    TestSteps testSteps;

    @Steps
    OdometerReadingSteps odometerReadingSteps;

    @Steps
    DefectCategorySteps defectCategorySteps;

    @Steps
    DefectItemSteps defectItemSteps;

    @Steps
    DefectDescriptionSteps defectDescriptionSteps;

    @Steps
    DefectDetailsSteps defectDetailsSteps;

    @Steps
    TestReviewSteps testReviewSteps;

    @Steps
    TestTypeCategorySteps testTypeCategorySteps;

    @Title("CVSB-17386 Change test result calculation in the front end - Major Defect")
    @Test
    public void testResultsCalculationInFrontEndMajor() {
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        testTypeCategoryComp.completeAddTestType(preparerService.getPreparerByIndex(0).getPreparerId(), preparerService.getPreparerByIndex(0).getPreparerName(),super.username);
        testSteps.selectOdometerReading();
        odometerReadingSteps.typeInField("50000");
        odometerReadingSteps.checkReadingValue("50000");
        odometerReadingSteps.pressSave();
        testSteps.waitUntilPageIsLoaded();
        testSteps.selectTestType("Annual test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.pressSave();
        testSteps.clickReviewAndSubmit();
        testReviewSteps.checkPageTitleIsDisplayed();
        testReviewSteps.scrollDown();
        testReviewSteps.checkTestStatus("Annual test", "PASS");
        testReviewSteps.goToTestPage();
        testSteps.selectTestType("Annual test", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.scrollTestTypeDetailsPage();
        testTypeDetailsSteps.clickAddDefect();
        defectCategorySteps.searchForDefect("1");
        defectCategorySteps.selectDefectFromList("1. Registration Plate");
        defectItemSteps.selectDefectFromList("1. A registration plate:");
        defectDescriptionSteps.selectDefect("1.1 (a) MAJOR");
        defectDetailsSteps.tapDone();
        testTypeDetailsSteps.pressSave();
        testSteps.clickReviewAndSubmit();
        testReviewSteps.checkPageTitleIsDisplayed();
        testReviewSteps.scrollDown();
        testReviewSteps.checkTestStatus("Annual test", "FAIL");
    }

    @Title("CVSB-17386 Change test result calculation in the front end - Dangerous Defect")
    @Test
    public void testResultsCalculationInFrontEndDangerous() {
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        testTypeCategoryComp.goToTestPage(preparerService.getPreparerByIndex(0).getPreparerId(),preparerService.getPreparerByIndex(0).getPreparerName(),super.username);
        testSteps.selectOdometerReading();
        odometerReadingSteps.typeInField("50000");
        odometerReadingSteps.checkReadingValue("50000");
        odometerReadingSteps.pressSave();
        testSteps.waitUntilPageIsLoaded();
        testSteps.addTestType();
        testTypeCategorySteps.waitUntilPageIsLoaded();
        testTypeCategorySteps.selectFromTestTypeList("Annual test");
        testSteps.selectTestType("Annual test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.selectAddDefect("Annual test");
        defectCategorySteps.selectDefectFromList("3. Seat Belts & Supplementary Restraint Systems");
        defectItemSteps.selectDefectFromList("2. Anchorages");
        defectDescriptionSteps.selectDefect("3.2 (a) (ii) * DANGEROUS");
        defectDetailsSteps.scrollDefectDetailsPage();
        defectDetailsSteps.setProhibitionIssued();
        defectDetailsSteps.checkProhibitionIssuedSwitchOn();
        defectDetailsSteps.tapDone();
        testTypeDetailsSteps.pressSave();
        testSteps.clickReviewAndSubmit();
        testReviewSteps.checkPageTitleIsDisplayed();
        testReviewSteps.scrollDown();
        testReviewSteps.checkTestStatus("Annual test", "FAIL");
    }
}
