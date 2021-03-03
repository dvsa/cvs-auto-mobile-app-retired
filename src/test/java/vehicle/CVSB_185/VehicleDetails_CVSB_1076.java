package vehicle.CVSB_185;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import steps.*;
import steps.composed.VehicleComp;
import utils.BaseTestClass;

@Ignore
@RunWith(SerenityRunner.class)
public class VehicleDetails_CVSB_1076 extends BaseTestClass {

    @Steps
    VehicleComp vehicleComp;

    @Steps
    VehicleDetailsSteps vehicleDetailsSteps;

    @Ignore("CVSB-12952: VTA FE Maintenance - increasing suite efficiency")
    @Title("CVSB-185 - AC4 - Fields displayed in the app (e.g Axle details)")
    public void testFieldsDisplayedInAppNoNullData() {
        vehicleComp.goToVehicleDetails(super.username);
        vehicleDetailsSteps.checkDetailPageNoNullData();
    }
}
