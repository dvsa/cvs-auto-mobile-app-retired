package steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import pages.CarDetailsPage;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarDetailsSteps extends ScenarioSteps {

    CarDetailsPage carDetailsPage;

    @Step
    public void selectConfirmButtonTopRight() {
        carDetailsPage.waitUntilPageIsLoaded();
        carDetailsPage.clickConfirm();
    }

    @Step
    public void checkPageTitle() {
        carDetailsPage.waitUntilPageIsLoaded();
        assertThat(carDetailsPage.isPageTitleDisplayed()).isTrue();
    }

    @Step
    public void scrollTheDetailPage(String element) {
        carDetailsPage.waitUntilPageIsLoaded();
        assertThat(carDetailsPage.elementFromListIsDisplayed(element)).isTrue();
        int oldYPosition = carDetailsPage.getYPositionForElement(element);
        carDetailsPage.scrollDetailPage();
        assertThat(carDetailsPage.elementFromListIsDisplayed(element)).isFalse();
        int newYPosition = carDetailsPage.getYPositionForElement(element);
        assertThat(oldYPosition).isNotEqualTo(newYPosition);

    }

    // TODO make this step receive less parameters
    @Step
    public void checkDetailPageData(String VIN, String chassisMake, String chassisModel, String bodyMake,
                                    String bodyModel, String bodyType, String yearOfManufacture,
                                    String dateOfFirstReg, String axles, String brakeCode ) {
        carDetailsPage.waitUntilPageIsLoaded();
        List<String> actualData = carDetailsPage.findAllValuesByXpath();
        assertThat(actualData).contains(VIN, chassisMake, chassisModel, bodyMake, bodyModel, bodyType
                , yearOfManufacture, dateOfFirstReg, axles, brakeCode);
    }

    @Step
    public void checkConfirmationPopUp() {
        assertThat(carDetailsPage.isConfirmationPopUpVisible()).isTrue();
    }

    @Step
    public void selectConfirmFromPopUp() {
        carDetailsPage.clickConfirmPopUp();
    }

    @Step
    public void selectCancelFromPopUp() {
        carDetailsPage.clickCancel();
    }

    // TODO find a better way to check this
    @Step
    public void checkIfStillInDetailPageByPlate(String plate) {
        assertThat(carDetailsPage.isPageTitleDisplayed()).isTrue();
        assertThat(carDetailsPage.isRegistrationPlateDisplayed(plate)).isTrue();
    }

    @Step
    public void checkIfInDetailPageByPlate(String plate) {
        carDetailsPage.waitUntilPageIsLoaded();
        assertThat(carDetailsPage.isPageTitleDisplayed()).isTrue();
        assertThat(carDetailsPage.isRegistrationPlateDisplayed(plate)).isTrue();
    }

    @Step
    public void waitUntilPageIsLoaded() {
        carDetailsPage.waitUntilPageIsLoaded();
    }

    @Step
    public void selectBrakes() {
        carDetailsPage.clickExpandableInformation("Brakes");
    }

    @Step
    public void selectWeights() {
        carDetailsPage.clickExpandableInformation("Weights");
    }

    @Step
    public void selectTyres() {
        carDetailsPage.clickExpandableInformation("Tyres");
    }

    @Step
    public void selectAdditionalVehicleDetails() {
        carDetailsPage.clickExpandableInformation("Additional vehicle details");
    }

    @Step
    public void checkDetailPageNoNullData() {
        carDetailsPage.waitUntilPageIsLoaded();
        List<String> actualData = carDetailsPage.findAllValuesByXpath();
        for (String value : actualData) {
            assertThat(carDetailsPage.isFieldValueNull(value)).isFalse();
        }
    }

    @Step
    public void selectVehicleTestHistory() {
        carDetailsPage.waitUntilPageIsLoaded();
        carDetailsPage.scrollDetailPage();
        carDetailsPage.clickVehicleTestHistory();
    }

    @Step
    public void pressBackButton() {
        carDetailsPage.waitUntilPageIsLoaded();
        carDetailsPage.clickBackButton();
    }

    @Step
    public void checkVehicleTestHistory() {
        carDetailsPage.waitUntilPageIsLoaded();
        carDetailsPage.scrollDetailPage();
        assertThat(carDetailsPage.isTestHistoryButtonDisplayed()).isTrue();
    }

    @Step
    public void checkMakeIs(String make) {
        assertThat(carDetailsPage.isAttribute("Make", make)).isTrue();
    }

    @Step
    public void checkModelIs(String model) {
        assertThat(carDetailsPage.isAttribute("Model", model)).isTrue();
    }

    @Step
    public void checkBodyTypeIs(String bodyType) {
        assertThat(carDetailsPage.isAttribute("Body type", bodyType)).isTrue();
    }

    @Step
    public void checkFunctionCodeIs(String functionCode) {
        assertThat(carDetailsPage.isAttribute("Function code", functionCode)).isTrue();
    }

    @Step
    public void checkYearOfManufactureIs(String year) {
        assertThat(carDetailsPage.isAttribute("Year of manufacture", year)).isTrue();
    }

    @Step
    public void checkDateOfFirstRegistrationIs(String date) {
        assertThat(carDetailsPage.isAttribute("Date of first registration", date)).isTrue();
    }

    @Step
    public void checkAxleIs(String axles) {
        assertThat(carDetailsPage.isAttribute("Axles", axles)).isTrue();
    }

    @Step
    public void checkDtpIs(String dtp) {
        assertThat(carDetailsPage.isAttribute("DTP", dtp)).isTrue();
    }


}
