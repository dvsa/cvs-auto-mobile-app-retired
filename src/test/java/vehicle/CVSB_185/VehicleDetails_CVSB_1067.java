package vehicle.CVSB_185;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.IdentifyVehicleSteps;
import steps.VehicleDetailsSteps;
import steps.composed.VehicleComp;
import util.BaseTestClass;

@RunWith(SerenityRunner.class)
public class VehicleDetails_CVSB_1067 extends BaseTestClass {

    @Steps
    VehicleComp vehicleComp;

    @Steps
    IdentifyVehicleSteps identifyVehicleSteps;

    @Steps
    VehicleDetailsSteps vehicleDetailsSteps;


    @Title("CVSB-185 - AC1 - Search results")
    @Test
    public void testSearchResults() {
        vehicleComp.goToIdentifyVehicle();
        identifyVehicleSteps.searchForVehicle("BQ91YHQ");
        vehicleDetailsSteps.checkDetailPageData("1B7GG36N12S678410","Mercedes", "632,01"
                ,"Plaxton","Tourismo","single decker","2010",
                "05/01/2011","2","171202" );
        vehicleDetailsSteps.scrollTheDetailPage("Chassis make");
    }
}
