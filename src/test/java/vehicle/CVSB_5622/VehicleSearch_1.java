package vehicle.CVSB_5622;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.Qualifier;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.IdentifyVehicleSteps;
import steps.VehicleDetailsSteps;
import steps.composed.VehicleComp;
import util.BaseTestClass;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value = "test-data/vin.csv")
public class VehicleSearch_1 extends BaseTestClass {

    private String searchVin;

    public void setSearchVin(String searchVin) {
        this.searchVin = searchVin;
    }

    @Qualifier
    public String qualifier() {
        return searchVin;
    }

    @Steps
    VehicleComp vehicleComp;

    @Steps
    IdentifyVehicleSteps identifyVehicleSteps;

    @Steps
    VehicleDetailsSteps vehicleDetailsSteps;

    @Test
    public void searchForASpecificVehicle() {
        vehicleComp.goToIdentifyVehicle(super.username);
        identifyVehicleSteps.searchForVehicle(searchVin);
        vehicleDetailsSteps.checkPageTitle();
    }
}
