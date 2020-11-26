package testtype.CVSB_756;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import pages.TestPage;
import steps.TestSteps;
import steps.composed.TestTypeCategoryComp;
import steps.util.UtilSteps;
import utils.BaseTestClass;

@Ignore
@RunWith(SerenityRunner.class)
public class CaptureTestInformation_CVSB_1567 extends BaseTestClass {

    @Steps
    UtilSteps utilSteps;

    @Steps
    TestTypeCategoryComp testTypeCategoryComp;

    @Steps
    TestSteps testSteps;


    @Ignore("CVSB-8749 - maintenance for improving test suite speed")
    @Title("CVSB-756 - AC1 - Record fields on test overview screen")
    public void testRecordFieldsOnTestOverviewScreen() {
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        testTypeCategoryComp.goToTestPage(preparerService.getPreparerByIndex(0).getPreparerId(), preparerService.getPreparerByIndex(0).getPreparerName(),super.username);
        testSteps.checkTestDetails("BQ91YHQ", vehicleService.getVehicle().getVim());
        testSteps.checkOdometerReadingButton(TestPage.OdometerUnitIndicatives.ENTER);
        testSteps.checkAddATestTypeButtonVisibility();
        testSteps.checkCancelButton();
    }
}
