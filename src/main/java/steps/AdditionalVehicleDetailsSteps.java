package steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import pages.AdditionalVehicleDetailsPage;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AdditionalVehicleDetailsSteps extends ScenarioSteps {

    AdditionalVehicleDetailsPage additionalVehicleDetailsPage;

    @Step
    public void checkDetails(String coifDate, String ntaNumber, String conversionNumber, String seatsOnUpperDeck,
                             String seatsOnLowerDeck, String standingCapacity, String speedRestriction,
                             String speedLimiter, String tachoExempt, String dispensations, String remarks) {
        additionalVehicleDetailsPage.waitUntilPageIsLoaded();
        List<String> axleData = additionalVehicleDetailsPage.getDataSetBetweenTitles("COIF date", "");
        assertThat(axleData).contains(coifDate, ntaNumber, conversionNumber, seatsOnUpperDeck,seatsOnLowerDeck, standingCapacity,
                speedRestriction, speedLimiter, tachoExempt, dispensations, remarks);

    }

    @Step
    public void pressBackButton() {
        additionalVehicleDetailsPage.clickOnBack();
    }

    @Step
    public void checkIfFieldIsNotEditable(String field) {
        additionalVehicleDetailsPage.waitUntilPageIsLoaded();
        assertThat(additionalVehicleDetailsPage.isFieldEditableById(field)).isFalse();
    }

    @Step
    public void checkNtaNumberIs(String ntaNumber) {
        additionalVehicleDetailsPage.waitUntilPageIsLoaded();
        assertThat(additionalVehicleDetailsPage.getDetailValue("NTA number").getAttribute("name").equals(ntaNumber)).isTrue();
    }

    @Step
    public void checkConversionNumberIs(String conversionNumber) {
        additionalVehicleDetailsPage.waitUntilPageIsLoaded();
        assertThat(additionalVehicleDetailsPage.getDetailValue("Conversion number").getAttribute("name").equals(conversionNumber)).isTrue();
    }

    @Step
    public void checkSpeedLimiterIs(String speedLimiter) {
        additionalVehicleDetailsPage.waitUntilPageIsLoaded();
        assertThat(additionalVehicleDetailsPage.getDetailValue("Speed limiter").getAttribute("name").equals(speedLimiter)).isTrue();
    }

    @Step
    public void checkTachoExemptIs(String tachoExempt) {
        additionalVehicleDetailsPage.waitUntilPageIsLoaded();
        assertThat(additionalVehicleDetailsPage.getDetailValue("Tacho exempt").getAttribute("name").equals(tachoExempt)).isTrue();
    }

    @Step
    public void checkRoadFriendlyIs(String roadFriendly) {
        additionalVehicleDetailsPage.waitUntilPageIsLoaded();
        assertThat(additionalVehicleDetailsPage.getDetailValue("Road friendly").getAttribute("name").equals(roadFriendly)).isTrue();
    }

    @Step
    public void checkDrawbarCouplingFittedIs(String drawbarCouplingFitted) {
        additionalVehicleDetailsPage.waitUntilPageIsLoaded();
        assertThat(additionalVehicleDetailsPage.getDetailValue("Drawbar coupling fitted").getAttribute("name").equals(drawbarCouplingFitted)).isTrue();
    }

    @Step
    public void checkEuroStandardIs(String euroStandard) {
        additionalVehicleDetailsPage.waitUntilPageIsLoaded();
        assertThat(additionalVehicleDetailsPage.getDetailValue("Euro standard").getAttribute("name").equals(euroStandard)).isTrue();
    }

    @Step
    public void checkDimensionLengthIs(String dimensionsLength) {
        additionalVehicleDetailsPage.waitUntilPageIsLoaded();
        assertThat(additionalVehicleDetailsPage.getDetailValue("Length").getAttribute("name").equals(dimensionsLength)).isTrue();
    }

    @Step
    public void checkDimensionWidthIs(String dimensionsWidth) {
        additionalVehicleDetailsPage.waitUntilPageIsLoaded();
        assertThat(additionalVehicleDetailsPage.getDetailValue("Width").getAttribute("name").equals(dimensionsWidth)).isTrue();
    }

    @Step
    public void scrollTheDetailPage(String element) {
        additionalVehicleDetailsPage.waitUntilPageIsLoaded();
        assertThat(additionalVehicleDetailsPage.elementFromListIsDisplayed(element)).isTrue();
        int oldYPosition = additionalVehicleDetailsPage.getYPositionForElement(element);
        additionalVehicleDetailsPage.scrollDetailPage();
        // assertThat(additionalVehicleDetailsPage.elementFromListIsDisplayed(element)).isFalse();
        int newYPosition = additionalVehicleDetailsPage.getYPositionForElement(element);
        assertThat(oldYPosition).isNotEqualTo(newYPosition);
    }

    @Step
    public void checkAxleMinIs(String axle, String minValue) {
        additionalVehicleDetailsPage.waitUntilPageIsLoaded();
        assertThat(additionalVehicleDetailsPage.getDetailAxleMinValue(axle).getAttribute("name").equals(minValue)).isTrue();
    }

    @Step
    public void checkAxleMaxIs(String axle, String maxValue) {
        additionalVehicleDetailsPage.waitUntilPageIsLoaded();
        assertThat(additionalVehicleDetailsPage.getDetailAxleMaxValue(axle).getAttribute("name").equals(maxValue)).isTrue();
    }

    @Step
    public void checkNotesAre(String notes) {
        additionalVehicleDetailsPage.waitUntilPageIsLoaded();
        assertThat(additionalVehicleDetailsPage.getNotes().getAttribute("name").equals(notes)).isTrue();
    }

    @Step
    public void checkVehicleTypeIs(String vehicleType) {
        additionalVehicleDetailsPage.waitUntilPageIsLoaded();
        assertThat(additionalVehicleDetailsPage.getVehicleType().getAttribute("name").equals(vehicleType)).isTrue();
    }

    @Step
    public void checkCountryOfRegistration(String country) {
        additionalVehicleDetailsPage.waitUntilPageIsLoaded();
        assertThat(additionalVehicleDetailsPage.getCountryOfRegistration().getAttribute("name").equals(country)).isTrue();
    }

    @Step
    public void checkEuVehicleCategoryIsDisplayed() {
        additionalVehicleDetailsPage.waitUntilPageIsLoaded();
        assertThat(additionalVehicleDetailsPage.isEuVehicleCategory()).isTrue();
    }

    @Step
    public void checkSuspensionTypeIs(String suspensionType) {
        additionalVehicleDetailsPage.waitUntilPageIsLoaded();
        assertThat(additionalVehicleDetailsPage.getDetailValue("Suspension type").getAttribute("name").equals(suspensionType)).isTrue();
    }

    @Step
    public void checkCouplingTypeIs(String couplingType) {
        additionalVehicleDetailsPage.waitUntilPageIsLoaded();
        assertThat(additionalVehicleDetailsPage.getDetailValue("Coupling type").getAttribute("name").equals(couplingType)).isTrue();
    }

    @Step
    public void checkOneTwoIs(String oneTwoValue) {
        additionalVehicleDetailsPage.waitUntilPageIsLoaded();
        assertThat(additionalVehicleDetailsPage.getDetailValue("Axle spacing 1-2").getAttribute("name").equals(oneTwoValue)).isTrue();
    }

    @Step
    public void checkFrontAxleCentreToRearIs(String frontAxleCentreValue) {
        additionalVehicleDetailsPage.waitUntilPageIsLoaded();
        assertThat(additionalVehicleDetailsPage.getDetailValue("Front axle centre to rear axle centre (Drawbars)").getAttribute("name").equals(frontAxleCentreValue)).isTrue();
    }

    @Step
    public void checkRearAxleCentreToRearIs(String rearAxleCentreValue) {
        additionalVehicleDetailsPage.waitUntilPageIsLoaded();
        assertThat(additionalVehicleDetailsPage.getDetailValue("Rear axle centre to rear of the trailer").getAttribute("name").equals(rearAxleCentreValue)).isTrue();
    }


    @Step
    public void checkCouplingCentreToRearAxleMinIs(String couplingCentreToRearAxleMinValue) {
        additionalVehicleDetailsPage.waitUntilPageIsLoaded();
        assertThat(additionalVehicleDetailsPage.getMinOfElement("COUPLING CENTRE TO THE REAR AXLE CENTRE (MM)").getAttribute("name").equals(couplingCentreToRearAxleMinValue)).isTrue();
    }

    @Step
    public void checkCouplingCentreToRearAxleMaxIs(String couplingCentreToRearAxleMinValue) {
        additionalVehicleDetailsPage.waitUntilPageIsLoaded();
        assertThat(additionalVehicleDetailsPage.getMaxOfElement("COUPLING CENTRE TO THE REAR AXLE CENTRE (MM)").getAttribute("name").equals(couplingCentreToRearAxleMinValue)).isTrue();
    }

   @Step
    public void checkCouplingCentreToRearMinIs(String couplingCentreToRearAxleMinValue) {
        additionalVehicleDetailsPage.waitUntilPageIsLoaded();
        assertThat(additionalVehicleDetailsPage.getMinOfElement("COUPLING CENTRE TO THE REAR OF THE TRAILER (MM)").getAttribute("name").equals(couplingCentreToRearAxleMinValue)).isTrue();
    }

    @Step
    public void checkCouplingCentreToRearMaxIs(String couplingCentreToRearAxleMinValue) {
        additionalVehicleDetailsPage.waitUntilPageIsLoaded();
        assertThat(additionalVehicleDetailsPage.getMaxOfElement("COUPLING CENTRE TO THE REAR OF THE TRAILER (MM)").getAttribute("name").equals(couplingCentreToRearAxleMinValue)).isTrue();
    }

    @Step
    public void checkNotesIsDisplayed() {
        additionalVehicleDetailsPage.waitUntilPageIsLoaded();
        assertThat(additionalVehicleDetailsPage.isDetailDisplayed("NOTES")).isTrue();
    }

    @Step
    public void checkNotesIsEmpty() {
        assertThat(additionalVehicleDetailsPage.getNotes().getText().contentEquals("Not entered")).isTrue();
    }
}

