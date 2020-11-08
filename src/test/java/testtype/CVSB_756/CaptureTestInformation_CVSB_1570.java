package testtype.CVSB_756;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import steps.TestHistorySteps;
import steps.TestSteps;
import steps.VehicleDetailsSteps;
import steps.composed.TestTypeCategoryComp;
import util.BaseTestClass;

@Ignore
@RunWith(SerenityRunner.class)
public class CaptureTestInformation_CVSB_1570 extends BaseTestClass {

    @Steps
    TestTypeCategoryComp testTypeCategoryComp;

    @Steps
    TestSteps testSteps;

    @Steps
    VehicleDetailsSteps vehicleDetailsSteps;

    @Steps
    TestHistorySteps testHistorySteps;

    @Ignore("[CVSB-8561] Removing test to improve overall efficiency of the mobile app Front-end automation test suite.")
    @Title("CVSB-756 - AC6 - Go back to vehicle details")
    public void testGoBackToVehicleDetails() {
        testTypeCategoryComp.goToTestPage(preparerService.getPreparerByIndex(0).getPreparerId(), preparerService.getPreparerByIndex(0).getPreparerName(),super.username);
        testSteps.checkTestDetails("BQ91YHQ", vehicleService.getVehicle().getVim());
        testSteps.selectVehicleDetails();
        vehicleDetailsSteps.selectVehicleTestHistory();
        testHistorySteps.checkPage();
        testHistorySteps.pressBackButton();
        vehicleDetailsSteps.checkPageTitle();
    }
}
