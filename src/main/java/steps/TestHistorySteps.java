package steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.steps.ScenarioSteps;
import pages.TestHistoryPage;

import static org.assertj.core.api.Assertions.assertThat;

public class TestHistorySteps extends ScenarioSteps {

    TestHistoryPage testHistoryPage;

    @Step
    public void checkPage() {
        testHistoryPage.waitUntilPageIsLoaded();
        assertThat(testHistoryPage.isPageTitleDisplayed()).isTrue();
    }

    @Step
    public void pressBackButton() {
        testHistoryPage.clickBackButton();
    }

    @Step
    public void checkRegPlate(String regPlate) {
        assertThat(testHistoryPage.isRegPlateDisplayed(regPlate)).isTrue();
    }

    @Step
    public void checkTestTypeRecordInListByStatus(String status) {
        assertThat(testHistoryPage.isTestTypeRecordPresentInListByStatus(status)).isTrue();
    }

    @Step
    public void selectTestTypeRecord(String testTypeRecord) {
        testHistoryPage.clickOnTestTypeRecord(testTypeRecord);
    }

    @Step
    public void clickLastTestByTestResult(String testResult) {
        testHistoryPage.clickLastTestByTestResult(testResult);
    }

    @Step
    public void clickLastTestByTestType(String testResult) {
        testHistoryPage.clickLastTestByTestType(testResult);
    }

    @Step
    public void checkNoTestHistoryIsDisplayed() {
        assertThat(testHistoryPage.isNoTestHistoryDisplayed()).isTrue();
    }
}
