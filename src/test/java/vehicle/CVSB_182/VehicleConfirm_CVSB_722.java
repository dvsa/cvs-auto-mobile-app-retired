package vehicle.CVSB_182;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import steps.PreparerSteps;
import steps.VehicleDetailsSteps;
import steps.composed.VehicleComp;
import utils.BaseTestClass;

@Ignore
@RunWith(SerenityRunner.class)
public class VehicleConfirm_CVSB_722 extends BaseTestClass {

    @Steps
    VehicleComp vehicleComp;

    @Steps
    VehicleDetailsSteps vehicleDetailsSteps;

    @Steps
    PreparerSteps preparerSteps;


    @Ignore("CVSB-8749 - maintenance for improving test suite speed")
    @Title("CVSB-182 - AC2 VSA further confirms")
    public void testVehicleDetailsFurtherConfirmation() {
        vehicleComp.goToVehicleDetails(super.username);
        vehicleDetailsSteps.selectConfirmButtonTopRight();
        vehicleDetailsSteps.checkConfirmationPopUp();
        vehicleDetailsSteps.selectConfirmFromPopUp();
        preparerSteps.checkPageTitleIsDisplayed();
    }
}
