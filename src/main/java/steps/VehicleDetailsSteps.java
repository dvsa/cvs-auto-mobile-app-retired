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
    public void checkPageTitle() {
        vehicleDetailsPage.waitUntilPageIsLoaded();
        assertThat(vehicleDetailsPage.isPageTitleDisplayed()).isTrue();
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

    // TODO make this step receive less parameters
    @Step
    public void checkDetailPageData(String VIN, String chassisMake, String chassisModel, String bodyMake,
                                    String bodyModel, String bodyType, String yearOfManufacture,
                                    String dateOfFirstReg, String axles, String brakeCode ) {

        // VIN should ONLY have uppercase characters in it.
        VIN = VIN.toUpperCase();

        vehicleDetailsPage.waitUntilPageIsLoaded();
        List<String> actualData = vehicleDetailsPage.findAllValuesByXpath();

        // If any fields are blank, ensure it's handled by matching the empty search values to a "found" value.
        actualData.add("");

        assertThat(actualData).contains(VIN, chassisMake, chassisModel, bodyMake, bodyModel, bodyType
                , yearOfManufacture, dateOfFirstReg, axles, brakeCode);
    }

    @Step
    public void verifySectionHeadingIsDisplayed(String heading) {
        assertThat(vehicleDetailsPage.isSectionHeadingDisplayed(heading)).isTrue();
    }

    @Step
    public void checkConfirmationPopUp() {
        assertThat(vehicleDetailsPage.isConfirmationPopUpVisible()).isTrue();
    }

    @Step
    public void selectConfirmFromPopUp() {
        vehicleDetailsPage.clickConfirmPopUp();
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
    public void selectBrakes() {
        vehicleDetailsPage.clickExpandableInformation("Brakes");
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
        vehicleDetailsPage.scrollToElement("Additional vehicle details");
        vehicleDetailsPage.clickExpandableInformation("Additional vehicle details");
    }

    @Step
    public void checkDetailPageNoNullData() {
        vehicleDetailsPage.waitUntilPageIsLoaded();
        List<String> actualData = vehicleDetailsPage.findAllValuesByXpath();
        for (String value : actualData) {
            assertThat(vehicleDetailsPage.isFieldValueNull(value)).isFalse();
        }
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
    public void checkVehicleTestHistory() {
        vehicleDetailsPage.waitUntilPageIsLoaded();
        vehicleDetailsPage.scrollDetailPage();
        assertThat(vehicleDetailsPage.isTestHistoryButtonDisplayed()).isTrue();
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
    public void checkNumberOfWheelsIs(String wheels) {
        assertThat(vehicleDetailsPage.isAttribute("Number of wheels", wheels)).isTrue();
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
    public void checkCountryOfRegistrationIs(String country) {
        assertThat(vehicleDetailsPage.isAttribute("Country of registration", country)).isTrue();
    }
    @Step
    public void checkVinChassisNumber(String vin) {
        assertThat(vehicleDetailsPage.isVinDisplayed(vin)).isTrue();
    }

    @Step
    public void checkRegistrationNumber(String vrm) {
        assertThat(vehicleDetailsPage.isRegistrationPlateDisplayed(vrm)).isTrue();
    }

    @Step
    public void scrollTheDetailPage() {
        vehicleDetailsPage.scrollDetailPage();
    }
}
