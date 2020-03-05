package steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import pages.SelectVehiclePage;

import static org.assertj.core.api.Assertions.assertThat;

public class SelectVehicleSteps extends ScenarioSteps {

    SelectVehiclePage selectVehiclePage;

    @Step
    public void waitUntilPageIsLoaded() {
        selectVehiclePage.waitUntilPageIsLoaded();
    }

    @Step
    public void pressOkInPopUp() {
        selectVehiclePage.clickOkInPopUp();
        selectVehiclePage.waitUntilPageIsLoaded();
    }

    @Step
    public void checkSkeletonRecordWarningIsShown() {
        assertThat(selectVehiclePage.isSkeletonRecordWarningShown()).isTrue();
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
    public void checkIncompleteRecordShown() {
        assertThat(selectVehiclePage.isIncompleteVehiclePresent()).isTrue();
    }

    @Step
    public void checkVehicleIsShown(String make, String year, String model) {
        assertThat(selectVehiclePage.isVehicleDetailsPresent(make, year, model)).isTrue();
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
    public void selectIncompleteRecord(){
        selectVehiclePage.clickOnIncompleteVehicle();
    }

    @Step
    public void waitUntilPopUpShown() {
        // After clicking on the <Search> button, the Loading message is shown for a while, and then the popup search result.
        selectVehiclePage.waitForErrorPopUpToDisplay();
    }

    @Step
    public void selectPsv(){
        selectVehiclePage.clickOnVehicle("Mercedes" , "2010" , "632,01");
    }

    @Step
    public void checkIncompleteRecordPopupIsShown() {
        assertThat(selectVehiclePage.isIncompleteRecordPopupShown()).isTrue();
    }

    @Step
    public void checkIncompleteRecordPopupIsNotShown() {
        selectVehiclePage.waitUntilPageIsLoaded();
        assertThat(selectVehiclePage.isIncompleteRecordPopupShown()).isFalse();
    }
}

