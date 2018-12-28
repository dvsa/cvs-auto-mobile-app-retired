package steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import pages.VehicleDetailsPage;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class VehicleDetailsSteps extends ScenarioSteps {

    VehicleDetailsPage vehicleDetailsPage;

    @Step
    public void selectConfirmButtonTopRight() {
        vehicleDetailsPage.waitUntilPageIsLoaded();
        vehicleDetailsPage.clickConfirm();
    }

    @Step
    public void scrollTheDetailPage(String element) {
        vehicleDetailsPage.scrollDetailPage();
        assertThat(vehicleDetailsPage.elementFromListIsDisplayed(element)).isTrue();
        int oldYPosition = vehicleDetailsPage.getYPositionForElement(element);
        vehicleDetailsPage.scrollDetailPage();
        assertThat(vehicleDetailsPage.elementFromListIsDisplayed(element)).isFalse();
        int newYPosition = vehicleDetailsPage.getYPositionForElement(element);
        assertThat(oldYPosition).isNotEqualTo(newYPosition);

    }

    // TODO make this step receive less parameters
    @Step
    public void checkDetailPageData(String VIN, String chassisMake, String chassisModel, String bodyMake,
                                    String bodyModel, String bodyType, String yearOfManufacture,
                                    String dateOfFirstReg, String axles, String brakeCode ) {
        vehicleDetailsPage.waitUntilPageIsLoaded();
        List<String> actualData = vehicleDetailsPage.findAllValuesByXpath();
        assertThat(actualData).contains(VIN, chassisMake, chassisModel, bodyMake, bodyModel, bodyType
                , yearOfManufacture, dateOfFirstReg, axles, brakeCode);
    }

    @Step
    public void checkConfirmationPopUp() {
        assertThat(vehicleDetailsPage.isConfirmationPopUpVisible()).isTrue();
    }

    @Step
    public void selectConfirmFromPopUp() {
        vehicleDetailsPage.clickConfirm();
    }

    @Step
    public void selectCancelFromPopUp() {
        vehicleDetailsPage.clickCancel();
    }

    // TODO find a better way to check this
    @Step
    public void checkIfStillInDetailPageByPlate(String plate) {
        assertThat(vehicleDetailsPage.isPageTitleDisplayed()).isTrue();
        assertThat(vehicleDetailsPage.isRegistrationPlateDisplayed(plate)).isTrue();
    }

    @Step
    public void tapIdentifyVehicle(){
        vehicleDetailsPage.waitUntilPageIsLoaded();
        vehicleDetailsPage.clickIdentifyVehicle();
    }

    @Step
    public void waitUntilPageIsLoaded() {
        vehicleDetailsPage.waitUntilPageIsLoaded();
    }
}
