package testtype.CVSB_3019;

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
public class VoluntaryFailedBreakTest_3019 extends BaseTestClass {

    @Steps
    TestTypeCategoryComp testTypeCategoryComp;

    @Steps
    TestSteps testSteps;

    @Steps
    TestTypeCategorySteps testTypeCategorySteps;

    @Steps
    TestTypeDetailsSteps testTypeDetailsSteps;

    @Steps
    EUVehicleCategorySteps euVehicleCategorySteps;

    @Steps
    OdometerReadingSteps odometerReadingSteps;

    @Steps
    TestReviewSteps testReviewSteps;

    @Steps
    SiteVisitSteps siteVisitSteps;

    @Title("CVSB-3019 - Defect - Failed Voluntary break test submission")
    @Test
    public void submitFailedVoluntaryBreakTestTest() {
        testTypeCategoryComp.goToTestType(preparerService.getPreparerByIndex(0).getPreparerId(), preparerService.getPreparerByIndex(0).getPreparerName());
        testTypeCategorySteps.selectFromTestTypeList("Voluntary test");
        testTypeCategorySteps.selectFromTestTypeList("Brake test");
        testSteps.selectTestType("Voluntary test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.setTestToOption("Fail");
        testTypeDetailsSteps.pressSave();
        testSteps.selectVehicleCategoryOption();
        euVehicleCategorySteps.selectM2Option();
        testSteps.selectOdometerReading();
        odometerReadingSteps.typeInField("45");
        odometerReadingSteps.pressSave();
        testSteps.reviewAction();
        testReviewSteps.pressSubmit();
        testReviewSteps.pressSubmitInPopUp();
        siteVisitSteps.checkSiteVisitPageAfterSubmit();
    }
}