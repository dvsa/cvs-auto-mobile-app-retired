package testtype.CVSB_440;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import steps.VehicleDetailsSteps;
import steps.composed.VehicleComp;
import steps.util.UtilSteps;
import utils.BaseTestClass;

@Ignore
@RunWith(SerenityRunner.class)
public class CaptureTestInformation_CVSB_1550 extends BaseTestClass {
    @Steps
    UtilSteps utilSteps;

    @Steps
    VehicleComp vehicleComp;

    @Steps
    VehicleDetailsSteps vehicleDetailsSteps;

    @Ignore("CVSB-12952: VTA FE Maintenance - increasing suite efficiency")
    @Title("CVSB-440 - AC2 - VSA views the test history section from vehicle search")
    public void testVsaViewsTheTestHistorySectionFromVehicleSearch() {
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        vehicleComp.goToVehicleDetails(super.username);
        vehicleDetailsSteps.checkVehicleTestHistory();
    }
}
