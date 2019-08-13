package steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import pages.VehicleDetailsPage;


import static org.assertj.core.api.Assertions.assertThat;

public class HgvDetailsSteps extends ScenarioSteps {

    VehicleDetailsPage vehicleDetailsPage;

    @Step
    public void selectConfirmButtonTopRight() {
        vehicleDetailsPage.waitUntilPageIsLoaded();
        vehicleDetailsPage.clickConfirm();
    }

    @Step
    public void scrollTheDetailPage(String element) {
        vehicleDetailsPage.waitUntilPageIsLoaded();
        assertThat(vehicleDetailsPage.elementFromListIsDisplayed(element)).isTrue();
        int oldYPosition = vehicleDetailsPage.getYPositionForElement(element);
        vehicleDetailsPage.scrollDetailPage();
        assertThat(vehicleDetailsPage.elementFromListIsDisplayed(element)).isFalse();
        int newYPosition = vehicleDetailsPage.getYPositionForElement(element);
        assertThat(oldYPosition).isNotEqualTo(newYPosition);

    }

    @Step
    public void checkIfInDetailPageByPlate(String plate) {
        vehicleDetailsPage.waitUntilPageIsLoaded();
        assertThat(vehicleDetailsPage.isPageTitleDisplayed()).isTrue();
        assertThat(vehicleDetailsPage.isRegistrationPlateDisplayed(plate)).isTrue();
    }

    @Step
    public void waitUntilPageIsLoaded() {
        vehicleDetailsPage.waitUntilPageIsLoaded();
    }

    @Step
    public void selectWeights() {
        vehicleDetailsPage.clickExpandableInformation("Weights");
    }

    @Step
    public void selectTyres() {
        vehicleDetailsPage.clickExpandableInformation("Tyres");
    }

    @Step
    public void selectAdditionalVehicleDetails() {
        vehicleDetailsPage.clickExpandableInformation("Additional vehicle details");
    }

    @Step
    public void selectVehicleTestHistory() {
        vehicleDetailsPage.waitUntilPageIsLoaded();
        vehicleDetailsPage.scrollDetailPage();
        vehicleDetailsPage.clickVehicleTestHistory();
    }

    @Step
    public void pressBackButton() {
        vehicleDetailsPage.waitUntilPageIsLoaded();
        vehicleDetailsPage.clickBackButton();
    }

    @Step
    public void checkMakeIs(String make) {
        assertThat(vehicleDetailsPage.isAttribute("Make", make)).isTrue();
    }

    @Step
    public void checkModelIs(String model) {
        assertThat(vehicleDetailsPage.isAttribute("Model", model)).isTrue();
    }

    @Step
    public void checkBodyTypeIs(String bodyType) {
        assertThat(vehicleDetailsPage.isAttribute("Body type", bodyType)).isTrue();
    }

    @Step
    public void checkFunctionCodeIs(String functionCode) {
        assertThat(vehicleDetailsPage.isAttribute("Function code", functionCode)).isTrue();
    }

    @Step
    public void checkYearOfManufactureIs(String year) {
        assertThat(vehicleDetailsPage.isAttribute("Year of manufacture", year)).isTrue();
    }

    @Step
    public void checkDateOfFirstRegistrationIs(String date) {
        assertThat(vehicleDetailsPage.isAttribute("Date of first registration", date)).isTrue();
    }

    @Step
    public void checkAxleIs(String axles) {
        assertThat(vehicleDetailsPage.isAttribute("Axles", axles)).isTrue();
    }

    @Step
    public void checkDtpIs(String dtp) {
        assertThat(vehicleDetailsPage.isAttribute("DTP", dtp)).isTrue();
    }


    @Step
    public void checkVinChassisNumberIs(String vinChassisNumber) {
        assertThat(vehicleDetailsPage.isAttribute("VIN / Chassis number", vinChassisNumber)).isTrue();
    }

    @Step
    public void checkVehicleTestHistoryIsDisplayed() {
        assertThat(vehicleDetailsPage.isButtonDisplayed("Vehicle test history")).isTrue();
    }

    @Step
    public void checkWeightsIsDisplayed() {
        assertThat(vehicleDetailsPage.isButtonDisplayed("Weights")).isTrue();
    }

    @Step
    public void checkTyresIsDisplayed() {
        assertThat(vehicleDetailsPage.isButtonDisplayed("Tyres")).isTrue();
    }

    @Step
    public void checkAdditionalVehicleDetailsIsDisplayed() {
        assertThat(vehicleDetailsPage.isButtonDisplayed("Additional vehicle details")).isTrue();
    }

}
