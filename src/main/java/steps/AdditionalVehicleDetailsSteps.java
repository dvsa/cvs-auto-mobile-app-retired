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
}

