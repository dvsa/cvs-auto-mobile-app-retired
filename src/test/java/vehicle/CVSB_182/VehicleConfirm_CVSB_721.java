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
public class VehicleConfirm_CVSB_721 extends BaseTestClass {

    @Steps
    VehicleComp vehicleComp;

    @Steps
    VehicleDetailsSteps vehicleDetailsSteps;


    @Title("CVSB-182 - AC1 Vehicle details presented are correct, VSA confirms")
    @Test
    public void testVehicleDetailsConfirmationPopUp() {
        vehicleComp.goToVehicleDetails();
        vehicleDetailsSteps.scrollTheDetailPage("Chassis make");
        vehicleDetailsSteps.checkDetailPageData("1B7GG36N12S678410","Zentix", "non"
                ,"Unisure","do","other","3225",
                "01/07/2006","43","o" );
        vehicleDetailsSteps.selectConfirmButtonTopRight();
        vehicleDetailsSteps.checkConfirmationPopUp();

    }


}
