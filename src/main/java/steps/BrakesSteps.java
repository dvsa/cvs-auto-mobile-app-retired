package steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.steps.ScenarioSteps;
import pages.BrakesPage;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BrakesSteps extends ScenarioSteps {

    BrakesPage brakesPage;

    @Step
    public void checkDetails(String brakeCode, String service, String secondary, String parking, String retarder_1,
                             String retarder_2) {
        brakesPage.waitUntilPageIsLoaded();
        List<String> actualData = brakesPage.getDataSetBetweenTitles("Brake code", "BRAKE FORCE");
        assertThat(actualData).contains(brakeCode, service, secondary, parking, retarder_1, retarder_2);
        // TODO check rest of data after bug fix
    }

    @Step
    public void pressBackButton() {
        brakesPage.clickOnBack();
    }

    @Step
    public void checkIfFieldIsNotEditable(String field) {
        brakesPage.waitUntilPageIsLoaded();
        assertThat(brakesPage.isFieldEditableById(field)).isFalse();
    }

    @Step
    public void checkBrakeActuatorIsDisplayedForAxle(String axle) {
        brakesPage.waitUntilPageIsLoaded();
        assertThat(brakesPage.getBrakeActuatorForAxle(axle).isDisplayed()).isTrue();
    }

    @Step
    public void checkLeverLengthIsDisplayedForAxle(String axle) {
        brakesPage.waitUntilPageIsLoaded();
        assertThat(brakesPage.getLeverLengthForAxle(axle).isDisplayed()).isTrue();
    }

    @Step
    public void checkSpringBrakeParkingIsDisplayedForAxle(String axle) {
        brakesPage.waitUntilPageIsLoaded();
        assertThat(brakesPage.getSpringBrakeParkingForAxle(axle).isDisplayed()).isTrue();
    }


    @Step
    public void checkLoadSensingValveIsDisplayed() {
        brakesPage.waitUntilPageIsLoaded();
        assertThat(brakesPage.getLoadSensingValve().isDisplayed()).isTrue();
    }

    public void checkAntilockBrakingSystemIsDisplayed() {
        brakesPage.waitUntilPageIsLoaded();
        assertThat(brakesPage.getAntilockBrakingSystem().isDisplayed()).isTrue();
    }
}

