package vehicle.CVSB_365;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.IdentifyVehicleSteps;
import steps.PreparerSteps;
import steps.VehicleDetailsSteps;
import steps.composed.PreparerComp;
import utils.BaseTestClass;

@RunWith(SerenityRunner.class)
public class VehicleChange_CVSB_754 extends BaseTestClass {

    @Steps
    PreparerComp preparerComp;

    @Steps
    VehicleDetailsSteps vehicleDetailsSteps;

    @Steps
    IdentifyVehicleSteps identifyVehicleSteps;

    @Steps
    PreparerSteps preparerSteps;


    @Title("CVSB-365 - AC2 - Change a vehicle after confirming vehicle details")
    @Test()
    public void testChangeAVehicleAfterConfirmVehicleDetails() {
        preparerComp.goToSelectPreparer(super.username);
        preparerSteps.goBackToVehicleDetailsPage();
        vehicleDetailsSteps.pressBackButton();
        identifyVehicleSteps.searchForVehicle("BQ91YHQ");
        vehicleDetailsSteps.waitUntilPageIsLoaded();
    }

}
