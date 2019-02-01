package vehicle.CVSB_185;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.*;
import steps.composed.VehicleComp;
import util.BaseTestClass;

@RunWith(SerenityRunner.class)
public class VehicleDetails_CVSB_1076 extends BaseTestClass {

    @Steps
    VehicleComp vehicleComp;

    @Steps
    VehicleDetailsSteps vehicleDetailsSteps;

    @Title("CVSB-185 - AC4 - Fields displayed in the app (e.g Axle details)")
    @Test
    public void testFieldsDisplayedInApp() {
        vehicleComp.goToVehicleDetails();
        vehicleDetailsSteps.checkDetailPageNoNullData();
    }
}
