package steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import pages.VehicleDetailsPage;

public class VehicleDetailsSteps extends ScenarioSteps {

    VehicleDetailsPage vehicleDetailsPage;

    @Step
    public void confirmDetails() {
        vehicleDetailsPage.waitUntilPageIsLoaded();
        vehicleDetailsPage.clickConfirm();
    }
}
