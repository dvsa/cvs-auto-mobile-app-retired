package steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import pages.IdentifyVehiclePage;
import pages.SelectVehiclePage;

import static org.assertj.core.api.Assertions.assertThat;

public class SelectVehicleSteps extends ScenarioSteps {

    SelectVehiclePage selectVehiclePage;

    @Step
    public void waitUntilPageIsLoaded() {
        selectVehiclePage.waitUntilPageIsLoaded();
    }

    @Step
    public void multipleVehicleDisplayed(){
        selectVehiclePage.isMultipleVehiclesDisplayed();
    }

    @Step
    public void checkPageTitle() {
        selectVehiclePage.waitUntilPageIsLoaded();
        assertThat(selectVehiclePage.isPageTitleDisplayed()).isTrue();
    }

    @Step
    public void checkBackCta(String text) {
        assertThat(selectVehiclePage.isBackCtaDisplayed()).isTrue();
        assertThat(selectVehiclePage.getBackCtaText()).contains(text);
    }

    @Step
    public void pressBackCta(){
        selectVehiclePage.clickBackCta();
    }

    @Step
    public void checkVehicleDetails(){
        assertThat(selectVehiclePage.isVehicleDetailsPresent("Isuzu" , "2018" , "F06"));
        assertThat(selectVehiclePage.isVehicleDetailsPresent("Isuzu" , "2018" , "FM"));
        assertThat(selectVehiclePage.isVehicleDetailsPresent("Mercedes" , "2010" , "632,01"));

    }

    @Step
    public void selectTrailer(){
        selectVehiclePage.clickOnVehicle("Isuzu" , "2018" , "F06");
    }

    @Step
    public void selectPsv(){
        selectVehiclePage.clickOnVehicle("Mercedes" , "2010" , "632,01");
    }

    /*@Step
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
    }*/

}

