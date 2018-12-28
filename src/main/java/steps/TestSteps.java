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

    @Step
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

    @Step
    public void checkTestSubmitted() {
        assertThat(testPage.isSubmitButtonAvailable()).isTrue();
    }

    public void swipeTestType(String testType) {
        int initialXPosition = testPage.getXPositionForElement(testType);
        testPage.swipeLeftOnTestType(testType);
        int newXPosition = testPage.getXPositionForElement(testType);
        assertThat(initialXPosition).isNotEqualTo(newXPosition);

    }

    @Step
    public void checkTestTypeRemoveButtonVisibility() {
        assertThat(testPage.isRemoveButtonDisplayed()).isTrue();
    }

    @Step
    public void pressTestTypeRemoveButton() {
        testPage.clickOnRedRemoveButton();
    }

    @Step
    public void checkTestTypeRemovalPopUp() {
        assertThat(testPage.isRemovePopUpDisplayed()).isTrue();
    }

    @Step
    public void pressRemoveInPopUp() {
        testPage.clickRemoveFromPopUp();
    }

    @Step
    public void checkTestTypeDeleted(String selectedTestType) {
        List<String> actualData = testPage.findAllTestTypesFromListByXpath();
        for (String testType : actualData) {
            assertThat(testType.contains(selectedTestType)).isFalse();
        }
    }

    @Step
    public void pressCancelInPopUp() {
        testPage.clickCancelFromPopUp();
    }

    @Step
    public void checkTestTypeAbandonButtonVisibility() {
        assertThat(testPage.isAbandonButtonDisplayed()).isTrue();
    }

}
