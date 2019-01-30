package steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import pages.OdometerReadingPage;

import static org.assertj.core.api.Assertions.assertThat;

public class OdometerReadingSteps extends ScenarioSteps {

    OdometerReadingPage odometerReadingPage;

    @Step
    public void checkPageDetails(String readingValue, OdometerReadingPage.Units unit) {
        odometerReadingPage.waitUntilPageIsLoaded();
        assertThat(odometerReadingPage.isReadingTitleDisplayed()).isTrue();
        assertThat(odometerReadingPage.isUnitTitleDisplayed()).isTrue();
        assertThat(odometerReadingPage.getReadingValue().equals(readingValue)).isTrue();
        assertThat(odometerReadingPage.getActualUnit().equals(odometerReadingPage.getExpectedUnit(unit))).isTrue();

    }

    @Step
    public void typeInField(String text) {
        odometerReadingPage.typeInReadingField(text);
    }

    @Step
    public void checkReadingValue(String text) {
        assertThat(odometerReadingPage.getReadingValue().contentEquals(text)).isTrue();
    }

    @Step
    public void pressSave() {
        odometerReadingPage.clickSave();
    }

    @Step
    public void pressEditUnit() {
        odometerReadingPage.clickEditUnit();
    }

    @Step
    public void checkUnitOptions() {
        assertThat(odometerReadingPage.isKilometresOptionDisplayed()).isTrue();
        assertThat(odometerReadingPage.isMilesOptionDisplayed()).isTrue();
        assertThat(odometerReadingPage.isCancelOptionDisplayed()).isTrue();
    }

    @Step
    public void selectUnitOption(OdometerReadingPage.UnitOptions unitOptions) {
        odometerReadingPage.waitUntilPageIsLoaded();
        odometerReadingPage.clickUnitOption(unitOptions);
    }

    @Step
    public void checkSelectedUnit(OdometerReadingPage.UnitOptions unitOptions) {
        odometerReadingPage.waitUntilPageIsLoaded();
        odometerReadingPage.isUnitDisplayed(unitOptions);
    }

}

