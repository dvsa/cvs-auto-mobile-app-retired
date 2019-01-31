package steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import pages.BrakesPage;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BreaksSteps extends ScenarioSteps {

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

}

