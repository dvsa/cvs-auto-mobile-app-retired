package testtype.CVSB_440;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.VehicleDetailsSteps;
import steps.composed.VehicleComp;
import util.BaseTestClass;

@RunWith(SerenityRunner.class)
public class CaptureTestInformation_CVSB_1550 extends BaseTestClass {

    @Steps
    VehicleComp vehicleComp;

    @Steps
    VehicleDetailsSteps vehicleDetailsSteps;


    @Title("CVSB-440 - AC2 - VSA views the test history section from vehicle search")
    @Test
    public void testVsaViewsTheTestHistorySectionFromVehicleSearch() {
        vehicleComp.goToVehicleDetails();
        vehicleDetailsSteps.checkVehicleTestHistory();

    }

}
