package steps;

import exceptions.AutomationException;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.steps.ScenarioSteps;
import org.junit.Assert;
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
    public void checkTestTypeListOnlyContainsTestTypes(String... testTypes) {
        List<String> actualData = testTypeCategoryPage.findAllTestTypesFromListByXpath();
        Assert.assertEquals(actualData.size(), testTypes.length);
        for (String test_type : testTypes) {
            assertThat(actualData).contains(test_type);
        }
    }

    @Step
    public void checkTestTypesInListAreSelectable(String... testTypes) {
        List<WebElement> actualData = testTypeCategoryPage.findAllTestTypesWebElements();
        ArrayList<String> expectedTestTypes = new ArrayList<>(Arrays.asList(testTypes));
        for (String expectedTestType: expectedTestTypes) {
            int i = 0;
            for (WebElement testType : actualData) {
                if (testType.getAttribute("name").contains(expectedTestType)) {
                    assertThat(testType.isEnabled()).isTrue();
                    break;
                }
                else {
                    i++;
                }
            }
            if (i == actualData.size()) {
                throw new AutomationException("Test type " + expectedTestType + "was not present");
            }
        }
    }

    @Step
    public void checkThatTestTypeListIsEmpty(){
        Assert.assertEquals(0, testTypeCategoryPage.findAllTestTypesWebElements().size());
    }

    @Step
    public void checkTestTypePage() {
        assertThat(testTypeCategoryPage.isPageTitleDisplayed()).isTrue();
    }

    @Step
    public void selectFromTestTypeList(String testType) {
        testTypeCategoryPage.waitUntilPageIsLoaded(testType);
        testTypeCategoryPage.selectTestTypeFromListByXpath(testType);
    }

    @Step
    public void goBackToTestOverview() {
        testTypeCategoryPage.selectCancel();
    }

    @Step
    public void waitUntilPageIsLoaded() {
        testTypeCategoryPage.waitUntilPageIsLoaded();
    }

    @Step
    public void waitUntilPageIsLoaded(String subCategory) {
        testTypeCategoryPage.waitUntilPageIsLoaded(subCategory);
    }
}
