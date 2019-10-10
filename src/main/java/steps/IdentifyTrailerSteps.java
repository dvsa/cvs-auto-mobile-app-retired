package steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import pages.IdentifyTrailerPage;

import static org.assertj.core.api.Assertions.assertThat;

public class IdentifyTrailerSteps extends ScenarioSteps {

    IdentifyTrailerPage identifyTrailerPage;

    @Step
    public void searchForTrailer(String registrationOrVIM) {
        identifyTrailerPage.waitUntilPageIsLoaded();
        identifyTrailerPage.searchForVehicle(registrationOrVIM);
        identifyTrailerPage.clickSearch();
    }

    @Step
    public void typeInSearchField(String registrationOrVIM) {
        identifyTrailerPage.waitUntilPageIsLoaded();
        identifyTrailerPage.searchForVehicle(registrationOrVIM);
    }

    @Step
    public void clickCancel() {
        identifyTrailerPage.waitUntilPageIsLoaded();
        identifyTrailerPage.tapCancel();
    }

    @Step
    public void checkSearchBoxAndText(String text) {
        assertThat(identifyTrailerPage.isSearchFieldDisplayed()).isTrue();
        assertThat(identifyTrailerPage.getSearchFieldText()).contains(text);
    }

    @Step
    public void checkSearchBoxDoesNotContainText(String text) {
        assertThat(identifyTrailerPage.isSearchFieldDisplayed()).isTrue();
        assertThat(identifyTrailerPage.getSearchFieldText()).doesNotContain(text);
    }

    @Step
    public void pressSearch() {
        identifyTrailerPage.clickSearch();
    }

    @Step
    public void checkVehicleNotFoundPopUp() {
        identifyTrailerPage.waitUntilPageIsLoaded();
        assertThat(identifyTrailerPage.isVehicleNotFoundPopUpDisplayed()).isTrue();
    }

    @Step
    public void pressOkInPopUp() {
        identifyTrailerPage.clickOkInPopUp();
        identifyTrailerPage.waitUntilPageIsLoaded();
    }

    @Step
    public void checkSearchBoxIsUnique() {
        assertThat(identifyTrailerPage.isSearchFieldUnique()).isTrue();
    }

    @Step
    public void checkSearchBoxIsDisplayed() {
        assertThat(identifyTrailerPage.isSearchFieldDisplayed()).isTrue();
    }

    @Step
    public void checkLoadingScreen() {
        assertThat(identifyTrailerPage.isLoadingScreenDisplayed()).isTrue();
    }

    @Step
    public void checkVehicleNotFoundPopUpDismissed() {
        assertThat(identifyTrailerPage.isVehicleNotFoundPopUpDisplayed()).isFalse();
    }

    @Step
    public void checkSearchBoxIsEmpty(){
        assertThat(identifyTrailerPage.isSearchFieldEmpty()).isTrue();
    }

    @Step
    public void checkIdentifyVehicleTitleIsDisplayed(){
        assertThat(identifyTrailerPage.isIdentifyVehicleTitleDisplayed()).isTrue();
    }

}

