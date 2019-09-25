package steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import pages.EUVehicleCategoryPage;

import static org.assertj.core.api.Assertions.assertThat;

public class EUVehicleCategorySteps extends ScenarioSteps {

    EUVehicleCategoryPage euVehicleCategoryPage;

    @Step
    public void clickSaveOptionButton() {
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
    public void checkTitleIsDisplayed() {
        euVehicleCategoryPage.waitUntilPageIsLoaded();
        assertThat(euVehicleCategoryPage.isPageTitleDisplayed()).isTrue();
    }

    @Step
    public void checkOptionsAreDisplayed() {
        euVehicleCategoryPage.waitUntilPageIsLoaded();
        assertThat(euVehicleCategoryPage.isM1Displayed()).isTrue();
        assertThat(euVehicleCategoryPage.isM2Displayed()).isTrue();
        assertThat(euVehicleCategoryPage.isM3Displayed()).isTrue();
    }
}
