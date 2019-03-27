package testtype.CVSB_756;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import pages.TestPage;
import steps.TestSteps;
import steps.composed.TestTypeCategoryComp;
import util.BaseTestClass;

@RunWith(SerenityRunner.class)
public class CaptureTestInformation_CVSB_1567 extends BaseTestClass {

    @Steps
    TestTypeCategoryComp testTypeCategoryComp;

    @Steps
    TestSteps testSteps;


    @Title("CVSB-756 - AC1 - Record fields on test overview screen")
    @Test
    public void testRecordFieldsOnTestOverviewScreen() {
        testTypeCategoryComp.goToTestPage(preparerService.getPreparerByIndex(0).getPreparerId(), preparerService.getPreparerByIndex(0).getPreparerName());
        testSteps.checkTestDetails("BQ91YHQ", vehicleService.getVehicle().getVim());
        testSteps.checkOdometerReadingButton(TestPage.OdometerUnitIndicatives.ENTER);
        testSteps.checkAddATestTypeButtonVisibility();
        testSteps.checkCancelButton();
    }
}
