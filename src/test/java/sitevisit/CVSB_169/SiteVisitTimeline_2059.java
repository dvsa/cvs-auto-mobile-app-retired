package sitevisit.CVSB_169;

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
public class SiteVisitTimeline_2059 extends BaseTestClass {

    @Steps
    TestTypeCategoryComp testTypeCategoryComp;

    @Steps
    TestSteps testSteps;

    @Steps
    TestTypeDetailsSteps testTypeDetailsSteps;

    @Steps
    SeatbeltInstallationCheckSteps seatbeltInstallationCheckSteps;

    @Steps
    TestTypeCategorySteps testTypeCategorySteps;

    @Steps
    TestTypeSubcategorySteps testTypeSubcategorySteps;

    @Steps
    SelectReasonSteps selectReasonSteps;

    @Steps
    AbandonTestSteps abandonTestSteps;

    @Steps
    TestReviewSteps testReviewSteps;

    @Steps
    SiteVisitSteps siteVisitSteps;

    @Steps
    OdometerReadingSteps odometerReadingSteps;

    @Steps
    EUVehicleCategorySteps euVehicleCategorySteps;

    @Title("CVSB-169 - AC2 - VSA is presented with the Site Visit timeline after submitting test results")
    @Test
    public void testSiteVisitTimelineAfterTestResults() {
        testTypeCategoryComp.completeAddTestType(preparerService.getPreparerByIndex(0).getPreparerId(), preparerService.getPreparerByIndex(0).getPreparerName());
        testSteps.selectOdometerReading();
        odometerReadingSteps.typeInField("2000");
        odometerReadingSteps.pressSave();
        testSteps.selectVehicleCategoryOption();
        euVehicleCategorySteps.selectM1Option();
        testSteps.selectTestType("Annual test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.setCarriedOutDuringTest(true);
        testTypeDetailsSteps.selectNumberOfSeatbeltsFitted();
        seatbeltInstallationCheckSteps.inputNumberOfSeatbelts("2");
        testTypeDetailsSteps.pressSave();
        testSteps.addLinkedTestType();
        testTypeCategorySteps.selectFromTestTypeList("Technical test");
        testTypeSubcategorySteps.selectFromTestTypeList("LEC");
        testSteps.swipeTestType("Technical test");
        testSteps.pressTestTypeAbandonButton();
        selectReasonSteps.selectAReason(SelectReasonPage.Reasons.REASON_1);
        selectReasonSteps.pressNextButton();
        abandonTestSteps.pressDone();
        abandonTestSteps.pressAbandon();
        testSteps.reviewAndSubmitAction();
        testReviewSteps.scrollDown();
        testReviewSteps.pressSubmit();
        testReviewSteps.pressSubmitInPopUp();
        siteVisitSteps.waitUntilPageIsLoaded();
        siteVisitSteps.checkVisitResults("BQ91 YHQ", "Annual test", "PASS", "Technical test", "ABANDONED");
    }
}
