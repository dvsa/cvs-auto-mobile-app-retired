package steps;

import exceptions.AutomationException;
import io.cucumber.java.BeforeStep;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import pages.TestTypeSubcategoryPage;

import java.util.ArrayList;
import java.util.Arrays;
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
    public void checkTestTypeListOnlyContainsTestTypes(String... testTypes) {
        List<String> actualData = testTypeSubcategoryPage.findAllTestTypesFromListByXpath();
        Assert.assertEquals(actualData.size(), testTypes.length);
        for (String test_type : testTypes) {
            assertThat(actualData).contains(test_type);
        }
    }

    @Step
    public void checkTestTypesInListAreSelectable(String... testTypes) {
        List<WebElement> actualData = testTypeSubcategoryPage.findAllTestTypesWebElements();
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
                throw new AutomationException("Test type " + expectedTestType + " was not present");
            }
        }

    }

    @Step
    public void waitForPageToLoadBySubcategory(String subcategory) {
        testTypeSubcategoryPage.waitUntilPageIsLoaded(subcategory);
    }

    @Step
    public void selectFromTestTypeList(String testType) {
        testTypeSubcategoryPage.selectTestTypeFromListByXpath(testType);
        testTypeSubcategoryPage.waitUntilPageIsLoaded(testType);
    }

    @Step
    public void checkTestTypeListIsEmpty() {
        Assert.assertTrue(testTypeSubcategoryPage.findAllTestTypesWebElements().isEmpty());
    }

    @Step
    public void goBackToCategory() {
        testTypeSubcategoryPage.selectBack();
    }
}
