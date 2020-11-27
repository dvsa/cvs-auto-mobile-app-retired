package vehicle.CVSB_184;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.IdentifyVehicleSteps;
import steps.VehicleDetailsSteps;
import steps.composed.VehicleComp;
import steps.util.UtilSteps;
import utils.BaseTestClass;

@RunWith(SerenityRunner.class)
public class Search_CVSB_1897 extends BaseTestClass {
    @Steps
    UtilSteps utilSteps;

    @Steps
    VehicleComp vehicleComp;

    @Steps
    IdentifyVehicleSteps identifyVehicleSteps;

    @Steps
    VehicleDetailsSteps vehicleDetailsSteps;

    @Title("CVSB-184 - AC2 - VSA exits erroneous search in order to search again")
    @Test
    public void researchAfterErrorDisplayed() {
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        vehicleComp.goToIdentifyVehicle(super.username);
        identifyVehicleSteps.searchForVehicle("BQ91YHQ");
        vehicleDetailsSteps.pressBackButton();
        identifyVehicleSteps.checkIdentifyVehicleTitleIsDisplayed();
        identifyVehicleSteps.checkSearchBoxDoesNotContainText("BQ91YHQ");
    }
}
