package vehicle.CVSB_182;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.VehicleDetailsSteps;
import steps.composed.VehicleComp;
import util.BaseTestClass;

@RunWith(SerenityRunner.class)
public class VehicleConfirm_CVSB_723 extends BaseTestClass {

    @Steps
    VehicleComp vehicleComp;

    @Steps
    VehicleDetailsSteps vehicleDetailsSteps;


    @Title("CVSB-182 - AC3 VSA cancels confirmation")
    @Test
    public void testVehicleDetailsCancelConfirmation() {
        vehicleComp.goToVehicleDetails();
        vehicleDetailsSteps.selectConfirmButtonTopRight();
        vehicleDetailsSteps.checkConfirmationPopUp();
        vehicleDetailsSteps.selectCancelFromPopUp();
        vehicleDetailsSteps.checkIfStillInDetailPageByPlate("BQ91YHQ");

    }


}
