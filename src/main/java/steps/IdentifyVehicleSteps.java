package steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import pages.IdentifyVehiclePage;
import static org.assertj.core.api.Assertions.assertThat;

public class IdentifyVehicleSteps extends ScenarioSteps {

    IdentifyVehiclePage identifyVehiclePage;

    @Step
    public void searchForVehicle(String registrationOrVIM) {
        identifyVehiclePage.waitUntilPageIsLoaded();
        identifyVehiclePage.searchForVehicle(registrationOrVIM);
        identifyVehiclePage.clickSearch();
    }

    @Step
    public void typeInSearchField(String registrationOrVIM) {
        identifyVehiclePage.waitUntilPageIsLoaded();
        identifyVehiclePage.searchForVehicle(registrationOrVIM);
    }

    @Step
    public void clickCancel() {
        identifyVehiclePage.waitUntilPageIsLoaded();
        identifyVehiclePage.tapCancel();
    }

    @Step
    public void checkSearchBoxAndText(String text) {
        assertThat(identifyVehiclePage.isSearchFieldDisplayed()).isTrue();
        assertThat(identifyVehiclePage.getSearchFieldText()).contains(text);
    }

    @Step
    public void pressSearch() {
        identifyVehiclePage.clickSearch();
    }

    @Step
    public void checkVehicleNotFoundPopUp() {
        identifyVehiclePage.waitUntilPageIsLoaded();
        assertThat(identifyVehiclePage.isVehicleNotFoundPopUpDisplayed()).isTrue();
    }

    @Step
    public void pressOkInPopUp() {
        identifyVehiclePage.clickOkInPopUp();
        identifyVehiclePage.waitUntilPageIsLoaded();
    }

    @Step
    public void checkSearchBoxIsUnique() {
        assertThat(identifyVehiclePage.isSearchFieldUnique()).isTrue();
    }

    @Step
    public void checkLoadingScreen() {
        assertThat(identifyVehiclePage.isLoadingScreenDisplayed()).isTrue();
    }

    @Step
    public void checkVehicleNotFoundPopUpDismissed() {
        assertThat(identifyVehiclePage.isVehicleNotFoundPopUpDisplayed()).isFalse();
    }
}
