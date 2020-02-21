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
}

