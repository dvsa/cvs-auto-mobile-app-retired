package steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import net.thucydides.core.steps.TestSourceType;
import pages.TestTypePage;

import static org.assertj.core.api.Assertions.assertThat;

public class TestTypeSteps extends ScenarioSteps {
    TestTypePage testTypePage;

    @Step
    public void waitUntillPageIsLoaded(String testType) {
        testTypePage.waitUntilPageIsLoaded(testType);
    }

    @Step
    public void checkTestTypeResultAndVehicleDetailsOption(String testTypeName, String result) {
        testTypePage.waitUntilPageIsLoaded(testTypeName);
        assertThat(testTypePage.checkResultIsPresent(result)).isEqualTo(2);
        assertThat(testTypePage.checkVehicleDetailsIsPresent().isDisplayed()).isTrue();
    }


    @Step
    public void checkAddDefectIsPresent() {
        assertThat(testTypePage.getAddDefectElement().isDisplayed()).isTrue();
    }


    @Step
    public void selectAddDefect(String testType) {
        testTypePage.waitUntilPageIsLoaded(testType);
        testTypePage.getAddDefectElement().click();
    }


    @Step
    public void checkDefectsArePresentForTest(String testType, String recordDefect, String defectItem) {
        testTypePage.waitUntilPageIsLoaded(testType);
        assertThat(testTypePage.checkDefectIsPresent(recordDefect).isDisplayed()).isTrue();
        assertThat(testTypePage.checkDefectIsPresent(defectItem).isDisplayed()).isTrue();

    }

    @Step
    public void checkAdditionalDetails(String testType, String referenceNumber, String defectType, String defectItem, String defectItemSubcategory, String defectItemSubcategoryType, String testStatus) {
        testTypePage.waitUntilPageIsLoaded(testType);
        assertThat(testTypePage.getElementById(referenceNumber).isDisplayed()).isTrue();
        assertThat(testTypePage.getElementById(defectType).isDisplayed()).isTrue();
        assertThat(testTypePage.getElementByLabel(defectItem).isDisplayed()).isTrue();
        assertThat(testTypePage.getElementByLabel(defectItemSubcategory).isDisplayed()).isTrue();
        assertThat(testTypePage.getElementByLabel(defectItemSubcategoryType).isDisplayed()).isTrue();
        assertThat(testTypePage.getElementByLabel(testStatus).isDisplayed()).isTrue();
    }

    @Step
    public void checkAdditionalDetailsWithPRSPresent(String testType, String referenceNumber, String defectType, String defectItem, String defectItemSubcategory, String defectItemSubcategoryType, String testStatus) {
        checkAdditionalDetails(testType, referenceNumber, defectType, defectItem, defectItemSubcategory, defectItemSubcategoryType, testStatus);
        assertThat(testTypePage.getPRMSLabels()).isEqualTo(1);
    }

    @Step
    public void tapOnPresentDefect(String testType, String recordDefect, String defectItem) {
        testTypePage.waitUntilPageIsLoaded(testType);
        testTypePage.clickOnDefect(recordDefect, defectItem);
    }

}
