package steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.openqa.selenium.WebElement;
import pages.TestTypeCategoryPage;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TestTypeCategorySteps extends ScenarioSteps {

    TestTypeCategoryPage testTypeCategoryPage;

    @Step
    public void seeInTestTypeList(String... testTypes) {
        testTypeCategoryPage.waitUntilPageIsLoaded();
        List<String> actualData = testTypeCategoryPage.findAllTestTypesFromListByXpath();
        for (String test_type : testTypes) {
            assertThat(actualData).contains(test_type);

        }
    }

    @Step
    public void seeTestTypePage() {
        assertThat(testTypeCategoryPage.isPageTitleDisplayed()).isTrue();
    }

    @Step
    public void selectFromTestTypeList(String testType) {
        testTypeCategoryPage.waitUntilPageIsLoaded();
        testTypeCategoryPage.selectTestTypeFromListByXpath(testType);

    }
}
