package steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.openqa.selenium.By;
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
    public void checkSearchBoxDoesNotContainText(String text) {
        assertThat(identifyVehiclePage.isSearchFieldDisplayed()).isTrue();
        assertThat(identifyVehiclePage.getSearchFieldText()).doesNotContain(text);
    }

    @Step
    public void pressSearch() {
        identifyVehiclePage.waitUntilPageIsLoaded();
        identifyVehiclePage.clickSearch();
    }

    @Step
    public void waitUntilPopUpShown() {
        // After clicking on the <Search> button, the Loading message is shown for a while, and then the popup search result.
        identifyVehiclePage.waitForErrorPopUpToDisplay();
    }

    @Step
    public void checkVehicleNotFoundPopUp() {
        identifyVehiclePage.waitForLoadingToEnd();
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
    public void checkSearchBoxIsDisplayed() {
        assertThat(identifyVehiclePage.isSearchFieldDisplayed()).isTrue();
    }

    @Step
    public void checkLoadingScreen() {
        assertThat(identifyVehiclePage.isLoadingScreenDisplayed()).isTrue();
    }

    @Step
    public void checkVehicleNotFoundPopUpDismissed() {
        assertThat(identifyVehiclePage.isVehicleNotFoundPopUpDisplayed()).isFalse();
    }

    @Step
    public void checkSearchBoxIsEmpty(){
        assertThat(identifyVehiclePage.isSearchFieldEmpty()).isTrue();
    }

    @Step
    public void checkIdentifyVehicleTitleIsDisplayed(){
        assertThat(identifyVehiclePage.isIdentifyVehicleTitleDisplayed()).isTrue();
    }

}

