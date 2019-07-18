package steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import pages.TrailerDetailsPage;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TrailerDetailsSteps extends ScenarioSteps {

    TrailerDetailsPage trailerDetailsPage;

    @Step
    public void selectConfirmButtonTopRight() {
        trailerDetailsPage.waitUntilPageIsLoaded();
        trailerDetailsPage.clickConfirm();
    }

    @Step
    public void checkPageTitle() {
        trailerDetailsPage.waitUntilPageIsLoaded();
        assertThat(trailerDetailsPage.isPageTitleDisplayed()).isTrue();
    }

    @Step
    public void scrollTheDetailPage(String element) {
        trailerDetailsPage.waitUntilPageIsLoaded();
        assertThat(trailerDetailsPage.elementFromListIsDisplayed(element)).isTrue();
        int oldYPosition = trailerDetailsPage.getYPositionForElement(element);
        trailerDetailsPage.scrollDetailPage();
        assertThat(trailerDetailsPage.elementFromListIsDisplayed(element)).isFalse();
        int newYPosition = trailerDetailsPage.getYPositionForElement(element);
        assertThat(oldYPosition).isNotEqualTo(newYPosition);

    }

    // TODO make this step receive less parameters
    @Step
    public void checkDetailPageData(String VIN, String chassisMake, String chassisModel, String bodyMake,
                                    String bodyModel, String bodyType, String yearOfManufacture,
                                    String dateOfFirstReg, String axles, String brakeCode ) {
        trailerDetailsPage.waitUntilPageIsLoaded();
        List<String> actualData = trailerDetailsPage.findAllValuesByXpath();
        assertThat(actualData).contains(VIN, chassisMake, chassisModel, bodyMake, bodyModel, bodyType
                , yearOfManufacture, dateOfFirstReg, axles, brakeCode);
    }

    @Step
    public void checkConfirmationPopUp() {
        assertThat(trailerDetailsPage.isConfirmationPopUpVisible()).isTrue();
    }

    @Step
    public void selectConfirmFromPopUp() {
        trailerDetailsPage.clickConfirmPopUp();
    }

    @Step
    public void selectCancelFromPopUp() {
        trailerDetailsPage.clickCancel();
    }

    // TODO find a better way to check this
    @Step
    public void checkIfStillInDetailPageByPlate(String plate) {
        assertThat(trailerDetailsPage.isPageTitleDisplayed()).isTrue();
        assertThat(trailerDetailsPage.isRegistrationPlateDisplayed(plate)).isTrue();
    }

    @Step
    public void checkIfInDetailPageByPlate(String plate) {
        trailerDetailsPage.waitUntilPageIsLoaded();
        assertThat(trailerDetailsPage.isPageTitleDisplayed()).isTrue();
        assertThat(trailerDetailsPage.isRegistrationPlateDisplayed(plate)).isTrue();
    }

    @Step
    public void waitUntilPageIsLoaded() {
        trailerDetailsPage.waitUntilPageIsLoaded();
    }

    @Step
    public void selectBrakes() {
        trailerDetailsPage.waitUntilPageIsLoaded();
        trailerDetailsPage.clickExpandableInformation("Brakes");
    }

    @Step
    public void selectWeights() {
        trailerDetailsPage.clickExpandableInformation("Weights");
    }

    @Step
    public void selectTyres() {
        trailerDetailsPage.clickExpandableInformation("Tyres");
    }

    @Step
    public void selectAdditionalVehicleDetails() {
        trailerDetailsPage.clickExpandableInformation("Additional vehicle details");
    }

    @Step
    public void checkDetailPageNoNullData() {
        trailerDetailsPage.waitUntilPageIsLoaded();
        List<String> actualData = trailerDetailsPage.findAllValuesByXpath();
        for (String value : actualData) {
            assertThat(trailerDetailsPage.isFieldValueNull(value)).isFalse();
        }
    }

    @Step
    public void selectTrailerTestHistory() {
        trailerDetailsPage.waitUntilPageIsLoaded();
        trailerDetailsPage.scrollDetailPage();
        trailerDetailsPage.clickVehicleTestHistory();
    }

    @Step
    public void pressBackButton() {
        trailerDetailsPage.waitUntilPageIsLoaded();
        trailerDetailsPage.clickBackButton();
    }

    @Step
    public void checkTrailerTestHistoryIsDisplayed() {
        trailerDetailsPage.waitUntilPageIsLoaded();
        trailerDetailsPage.scrollDetailPage();
        assertThat(trailerDetailsPage.isTestHistoryButtonDisplayed()).isTrue();
    }

    @Step
    public void checkVinChassisNumberIs(String vin) {
        assertThat(trailerDetailsPage.isAttribute("VIN / Chassis number", vin)).isTrue();
    }

    @Step
    public void checkMakeIs(String make) {
        assertThat(trailerDetailsPage.isAttribute("Make", make)).isTrue();
    }

    @Step
    public void checkModelIs(String model) {
        assertThat(trailerDetailsPage.isAttribute("Model", model)).isTrue();
    }

    @Step
    public void checkBodyTypeIs(String bodyType) {
        assertThat(trailerDetailsPage.isAttribute("Body type", bodyType)).isTrue();
    }

    @Step
    public void checkYearOfManufactureIs(String year) {
        assertThat(trailerDetailsPage.isAttribute("Year of manufacture", year)).isTrue();
    }

    @Step
    public void checkDateOfFirstUseIs(String date) {
        assertThat(trailerDetailsPage.isAttribute("Date of first use", date)).isTrue();
    }

    @Step
    public void checkAxleIs(String axles) {
        assertThat(trailerDetailsPage.isAttribute("Axles", axles)).isTrue();
    }

    @Step
    public void checkDtpIs(String dtp) {
        assertThat(trailerDetailsPage.isAttribute("DTP", dtp)).isTrue();
    }

    @Step
    public void selectAdditionalDetails() {
        trailerDetailsPage.waitUntilPageIsLoaded();
        trailerDetailsPage.scrollDetailPage();
        trailerDetailsPage.clickAdditionalDetails();
    }

    @Step
    public void checkWeightsIsDisplayed() {
        trailerDetailsPage.waitUntilPageIsLoaded();
        trailerDetailsPage.scrollDetailPage();
        assertThat(trailerDetailsPage.isWeightsButtonDisplayed()).isTrue();
    }

    @Step
    public void checkTyresIsDisplayed() {
        trailerDetailsPage.waitUntilPageIsLoaded();
        trailerDetailsPage.scrollDetailPage();
        assertThat(trailerDetailsPage.isTyresButtonDisplayed()).isTrue();
    }

    @Step
    public void checkAdditionalVehicleDetailsIsDisplayed() {
        trailerDetailsPage.waitUntilPageIsLoaded();
        trailerDetailsPage.scrollDetailPage();
        assertThat(trailerDetailsPage.isAdditionalVehicleDetailsButtonDisplayed()).isTrue();
    }

    @Step
    public void checkBrakesIsDisplayed() {
        trailerDetailsPage.waitUntilPageIsLoaded();
        trailerDetailsPage.scrollDetailPage();
        assertThat(trailerDetailsPage.isBrakesButtonDisplayed()).isTrue();
    }

}
