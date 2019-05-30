package steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import pages.TestTypeCategoryPage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TestTypeCategorySteps extends ScenarioSteps {

    TestTypeCategoryPage testTypeCategoryPage;

    @Step
    public void checkInTestTypeList(String... testTypes) {
        testTypeCategoryPage.waitUntilPageIsLoaded();
        List<String> actualData = testTypeCategoryPage.findAllTestTypesFromListByXpath();
        for (String test_type : testTypes) {
            assertThat(actualData).contains(test_type);
        }
    }

    @Step
    public void checkTestTypeListHasOnlySomeTestTypes(String...testTypes) {
        testTypeCategoryPage.waitUntilPageIsLoaded();
        List<String> actualData = testTypeCategoryPage.findAllTestTypesFromListByXpath();
        assertThat(actualData.size() == testTypes.length);
        for (String test_type : testTypes) {
            assertThat(actualData).contains(test_type);
        }
    }

    @Step
    public void checkTestTypePage() {
        assertThat(testTypeCategoryPage.isPageTitleDisplayed()).isTrue();
    }

    @Step
    public void selectFromTestTypeList(String testType) {
        testTypeCategoryPage.selectTestTypeFromListByXpath(testType);
    }

    @Step
    public void goBackToTestOverview() {
        testTypeCategoryPage.selectCancel();
    }
}
