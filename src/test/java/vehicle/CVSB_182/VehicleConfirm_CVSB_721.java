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
        vehicleDetailsSteps.checkDetailPageData("ABCDE1234FGHIJ5678","Volvo", "B12M"
                ,"Van Hool","Astrobel","D","2018",
                "1/10/2018","2","100A01" );
        vehicleDetailsSteps.selectConfirmButtonTopRight();
        vehicleDetailsSteps.checkConfirmationPopUp();

    }


}
