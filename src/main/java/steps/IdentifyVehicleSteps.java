package steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import pages.IdentifyVehiclePage;

public class IdentifyVehicleSteps extends ScenarioSteps {

    IdentifyVehiclePage identifyVehiclePage;

    @Step
    public void searchForVehicle(String registrationOrVIM) {
        identifyVehiclePage.waitUntilPageIsLoaded();
        identifyVehiclePage.searchForVehicle(registrationOrVIM);
        identifyVehiclePage.clickSearch();
    }

    @Step
    public void clickCancel() {
        identifyVehiclePage.waitUntilPageIsLoaded();
        identifyVehiclePage.tapCancel();
    }

}
