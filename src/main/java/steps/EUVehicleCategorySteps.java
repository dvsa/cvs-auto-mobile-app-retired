package steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import pages.EUVehicleCategoryPage;

import static org.assertj.core.api.Assertions.assertThat;

public class EUVehicleCategorySteps extends ScenarioSteps {

    EUVehicleCategoryPage euVehicleCategoryPage;

    @Step
    public void clickSaveOptionButton() {
        euVehicleCategoryPage.waitUntilPageIsLoaded();
        euVehicleCategoryPage.clickSaveButton();
    }

    @Step
    public void selectVehicleCategory(String category) {
        euVehicleCategoryPage.clickVehicleCategory(category);
    }


    @Step
    @Deprecated
    public void selectM1Option() {
        euVehicleCategoryPage.clickM1Option();
        clickSaveOptionButton();
    }

    @Step
    public void selectOption(String option){
        euVehicleCategoryPage.waitUntilPageIsLoaded();
        euVehicleCategoryPage.clickOption(option);
        clickSaveOptionButton();
    }

    @Step
    @Deprecated
    public void selectM2Option() {
        euVehicleCategoryPage.clickM2Option();
        clickSaveOptionButton();
    }

    @Step
    @Deprecated
    public void selectM3Option() {
        euVehicleCategoryPage.clickM3Option();
        clickSaveOptionButton();
    }

    @Step
    public void selectO1Option() {
        euVehicleCategoryPage.clickO1Option();
        clickSaveOptionButton();
    }
    @Step
    public void selectO2Option() {
        euVehicleCategoryPage.clickO2Option();
        clickSaveOptionButton();
    }

    @Step
    public void selectO3Option() {
        euVehicleCategoryPage.clickO3Option();
        clickSaveOptionButton();
    }

    @Step
    public void selectO4Option() {
        euVehicleCategoryPage.clickO4Option();
        clickSaveOptionButton();
    }

    @Step
    public void checkTitleIsDisplayed() {
        euVehicleCategoryPage.waitUntilPageIsLoaded();
        assertThat(euVehicleCategoryPage.isPageTitleDisplayed()).isTrue();
    }

    @Step
    public void checkOptionsAreDisplayed() {
        euVehicleCategoryPage.waitUntilPageIsLoaded();
        assertThat(euVehicleCategoryPage.isM1Displayed()).isFalse();
        assertThat(euVehicleCategoryPage.isM2Displayed()).isTrue();
        assertThat(euVehicleCategoryPage.isM3Displayed()).isTrue();
    }

    @Step
    public void checkOptionsForTrailerAreDisplayed() {
        euVehicleCategoryPage.waitUntilPageIsLoaded();
        assertThat(euVehicleCategoryPage.isO1Displayed()).isTrue();
        assertThat(euVehicleCategoryPage.isO2Displayed()).isTrue();
        assertThat(euVehicleCategoryPage.isO3Displayed()).isTrue();
        assertThat(euVehicleCategoryPage.isO4Displayed()).isTrue();
    }

    @Step
    public void checkOptionsForMotorcycleAreDisplayed() {
        euVehicleCategoryPage.waitUntilPageIsLoaded();
        assertThat(euVehicleCategoryPage.isLDescriptionLabelDisplayed());
        assertThat(euVehicleCategoryPage.isL1eADisplayed()).isTrue();
        assertThat(euVehicleCategoryPage.isL1eDisplayed()).isTrue();
        assertThat(euVehicleCategoryPage.isL2eDisplayed()).isTrue();
        assertThat(euVehicleCategoryPage.isL3eDisplayed()).isTrue();
        euVehicleCategoryPage.scrollToElement("L4e");
        assertThat(euVehicleCategoryPage.isL4eDisplayed()).isTrue();
        euVehicleCategoryPage.scrollToElement("L5e");
        assertThat(euVehicleCategoryPage.isL5eDisplayed()).isTrue();
        euVehicleCategoryPage.scrollToElement("L6e");
        assertThat(euVehicleCategoryPage.isL6eDisplayed()).isTrue();
        euVehicleCategoryPage.scrollToElement("L7e");
        assertThat(euVehicleCategoryPage.isL7eDisplayed()).isTrue();
    }

    @Step
    public void checkOptionsForCarAreDisplayed() {
        euVehicleCategoryPage.waitUntilPageIsLoaded();
        assertThat(euVehicleCategoryPage.isMDescriptionLabelDisplayed());
        assertThat(euVehicleCategoryPage.isM1CheckedDisplayed()).isTrue();
    }

    @Step
    public void checkOptionsForLGVAreDisplayed() {
        euVehicleCategoryPage.waitUntilPageIsLoaded();
        assertThat(euVehicleCategoryPage.isNDescriptionLabelDisplayed());
        assertThat(euVehicleCategoryPage.isN1CheckedDisplayed()).isTrue();
    }

    @Step
    public void checkOptionsForHGVAreDisplayed() {
        euVehicleCategoryPage.waitUntilPageIsLoaded();
        assertThat(euVehicleCategoryPage.isNDescriptionLabelDisplayed());
        assertThat(euVehicleCategoryPage.isN1Displayed()).isFalse();
        assertThat(euVehicleCategoryPage.isN2CheckedDisplayed()).isTrue();
        assertThat(euVehicleCategoryPage.isN3Displayed()).isTrue();
    }
}
