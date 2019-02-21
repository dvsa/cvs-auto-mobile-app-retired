package steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import pages.TestTypeSubcategoryPage;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TestTypeSubcategorySteps extends ScenarioSteps {

    TestTypeSubcategoryPage testTypeSubcategoryPage;

    @Step
    public void seeInTestTypeList(String... testTypes) {
        List<String> actualData = testTypeSubcategoryPage.findAllTestTypesFromListByXpath();
        for (String test_type : testTypes) {
            assertThat(actualData).contains(test_type);

        }
    }

    @Step
    public void waitForPageToLoadBySubcategory(String subcategory) {
        testTypeSubcategoryPage.waitUntilPageIsLoaded(subcategory);
    }

    @Step
    public void selectFromTestTypeList(String testType) {
        testTypeSubcategoryPage.selectTestTypeFromListByXpath(testType);

    }

    @Step
    public void goBackToCategory() {
        testTypeSubcategoryPage.selectBack();
    }
}
