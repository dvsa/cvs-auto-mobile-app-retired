package vehicle.CVSB_365;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.IdentifyVehicleSteps;
import steps.SelectPreparerSteps;
import steps.VehicleDetailsSteps;
import steps.composed.PreparerComp;
import util.BaseTestClass;

@RunWith(SerenityRunner.class)
public class VehicleChange_CVSB_754 extends BaseTestClass {

    @Steps
    PreparerComp preparerComp;

    @Steps
    VehicleDetailsSteps vehicleDetailsSteps;

    @Steps
    IdentifyVehicleSteps identifyVehicleSteps;

    @Steps
    SelectPreparerSteps selectPreparerSteps;


    @Title("CVSB-365 - AC2 - Change a vehicle after confirming vehicle details")
    @Test()
    public void testChangeAVehicleAfterConfirmVehicleDetails() {
        preparerComp.goToSelectPreparer();
        selectPreparerSteps.tapVehicleDetails();
        vehicleDetailsSteps.tapIdentifyVehicle();
        identifyVehicleSteps.searchForVehicle("BQ91YHQ");
        vehicleDetailsSteps.waitUntilPageIsLoaded();
    }

}
