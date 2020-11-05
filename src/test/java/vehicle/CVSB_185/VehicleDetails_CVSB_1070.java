package vehicle.CVSB_185;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.IdentifyVehicleSteps;
import steps.VehicleDetailsSteps;
import steps.composed.VehicleComp;
import util.BaseTestClass;

@Ignore
@RunWith(SerenityRunner.class)
public class VehicleDetails_CVSB_1070 extends BaseTestClass {

    @Steps
    VehicleComp vehicleComp;

    @Steps
    IdentifyVehicleSteps identifyVehicleSteps;

    @Steps
    VehicleDetailsSteps vehicleDetailsSteps;


    @Ignore("[CVSB-8561] Removing test to improve overall efficiency of the mobile app Front-end automation test suite.")
    @Title("CVSB-185 - AC1 - No search results")
    public void testNoSearchResults() {
        vehicleComp.goToIdentifyVehicle(super.username);
        identifyVehicleSteps.searchForVehicle("No results");
        identifyVehicleSteps.checkVehicleNotFoundPopUp();
        identifyVehicleSteps.pressOkInPopUp();
        identifyVehicleSteps.searchForVehicle("BQ91YHQ");
        vehicleDetailsSteps.checkDetailPageData("1B7GG36N12S678410","Mercedes", "632,01"
                ,"Plaxton","Tourismo","single decker","2010",
                "05/01/2011","2","171202" );
    }
}
