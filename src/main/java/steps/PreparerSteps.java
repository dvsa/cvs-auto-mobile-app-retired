package steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.steps.ScenarioSteps;
import pages.PreparerPage;

import static org.assertj.core.api.Assertions.assertThat;

public class PreparerSteps extends ScenarioSteps {

    PreparerPage preparerPage;

    @Step
    public void checkPageTitleIsDisplayed(){
       assertThat(preparerPage.isTitleDisplayed()).isTrue();
    }

    @Step
    public void goBackToVehicleDetailsPage(){
        preparerPage.clickBackButton();
    }

    @Step
    public void searchForPreparerId(String preparerId) {
        preparerPage.searchForPreparerId(preparerId);
    }

    @Step
    public void startTest() {
        preparerPage.clickStartTest();
    }

    @Step
    public void searchAgainForPreparer() {
        preparerPage.searchAgainPopUpOption();
    }

    @Step
    public void cancelInPopUp() {
        preparerPage.cancelPopUpOption();
    }

    @Step
    public void confirmInPopUp() {
        preparerPage.confirmPopUpOption();
    }

    @Step
    public void continueInPopUp() {
        preparerPage.continuePopUpOption();
    }

    @Step
    public void preparerIsFound(String preparerId) {
        assertThat(preparerPage.isPreparerFoundPopUpDisplayed(preparerId)).isTrue();
    }

    @Step
    public void noPreparerFound(){
        assertThat(preparerPage.isPreparerNotFoundPopUpDisplayed()).isTrue();
    }

    @Step
    public void advanceWithoutPreaprer() {
        assertThat(preparerPage.isWithoutPreparerPopUpDisplayed()).isTrue();
    }

    @Step
    public void selectAndConfirmPreparerId(String preparerId) {
        searchForPreparerId(preparerId);
        preparerPage.continuePopUpOption();
    }
}
