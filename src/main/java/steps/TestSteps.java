package steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import pages.TestPage;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TestSteps extends ScenarioSteps {

    TestPage testPage;

    @Step
    public void addTestType() {
        testPage.waitUntilPageIsLoaded();
        testPage.addTestType();
    }

    @Step
    public void checkTestDetails() {
        testPage.waitUntilPageIsLoaded();
        assertThat(testPage.isPageTitleDisplayed() && testPage.isVehicleRegistrationPlateDisplayed("AA12 BCD")).isTrue();
    }

    @Step
    public void seeAddATestType() {
        assertThat(testPage.isAddATestTypeButtonDisplayed()).isTrue();
    }

    public void checkSelectedTestTypes(String... selectedTestTypes) {
        List<String> actualData = testPage.findAllTestTypesFromListByXpath();
        for (String expectedTestType : selectedTestTypes) {
            assertThat(actualData.contains(expectedTestType)).isTrue();
        }
    }

    @Step
    public void checkNoIdentifyVehicleOptionAvailable() {
        testPage.waitUntilPageIsLoaded();
        int numberOfElementsFound = testPage.checkDataByLabelValueAndName("Identify", "Vehicle");
        assertThat(numberOfElementsFound).isEqualTo(0);
    }

    @Step
    public void selectTest(String testName) {
        testPage.clickOnTest(testName);
    }
}
