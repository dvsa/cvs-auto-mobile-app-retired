package steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.openqa.selenium.WebElement;
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
    public void checkNotInTestTypeList(String... testTypes) {
        testTypeCategoryPage.waitUntilPageIsLoaded();
        List<String> actualData = testTypeCategoryPage.findAllTestTypesFromListByXpath();
        for (String test_type : testTypes) {
            assertThat(actualData).doesNotContain(test_type);
        }
    }

    @Step
    public void checkTestTypeListOnlyContainsTestTypes(String...testTypes) {
        List<String> actualData = testTypeCategoryPage.findAllTestTypesFromListByXpath();
        assertThat(actualData.size() == testTypes.length);
        for (String test_type : testTypes) {
            assertThat(actualData).contains(test_type);
        }
    }

    @Step
    public void checkTestTypesInListAreSelectable(String... testTypes) {
        List<WebElement> actualData = testTypeCategoryPage.findAllTestTypesWebElements();
        for (WebElement testType: actualData ){
            assertThat(testType.isEnabled()).isTrue();
        }
    }

    @Step
    public void checkThatTestTypeListIsEmpty(){
        assertThat(testTypeCategoryPage.findAllTestTypesWebElements().size() == 0);
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
