package steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import pages.TestHistoryDetailsPage;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TestHistoryDetailsSteps extends ScenarioSteps {

    TestHistoryDetailsPage testHistoryDetailsPage;

    @Step
    public void checkPageTitle() {
        testHistoryDetailsPage.waitUntilPageIsLoaded();
        assertThat(testHistoryDetailsPage.isPageTitleDisplayed()).isTrue();
    }

    @Step
    public void waitUntilPageIsLoaded() {
        testHistoryDetailsPage.waitUntilPageIsLoaded();
    }

    @Step
    public void pressBackButton() {
        testHistoryDetailsPage.clickBackButton();
    }

    @Step
    public void checkDetails(String startTitle, String endTitle, String... values) {
        testHistoryDetailsPage.waitUntilPageIsLoaded();
        List<String> actualData = testHistoryDetailsPage.getDataSetBetweenTitles(startTitle, endTitle);
        for (String value : values) {
            assertThat(actualData.contains(value)).isTrue();
        }
    }

    @Step
    public void checkElementIsPresent(String element) {
        assertThat(testHistoryDetailsPage.checkElementIsPresent(element)).isTrue();
    }

    @Step
    public void checkDate() {
        assertThat(testHistoryDetailsPage.checkIsValidDateFormat()).isTrue();
    }

    @Step
    public void checkTime() {
        assertThat(testHistoryDetailsPage.checkIsValidTimeFormat()).isTrue();
    }

    @Step
    public void checkStatusAndExpireyDateForHistoryDisplayedElements() {
        assertThat(testHistoryDetailsPage.checkAllElementsHaveStatusAndExpiryDate()).isTrue();
    }

    @Step
    public void checkAllElementsAreNotEditable() {
        assertThat(testHistoryDetailsPage.checkAllElementsAreNoteditable()).isFalse();
    }

    @Step
    public void checkElementValueIsDisplayed(String... values) {
        for (String s : values) {
            assertThat(testHistoryDetailsPage.elementIsDisplayed(s)).isTrue();
        }
    }

    @Step
    public void scroll() {
        testHistoryDetailsPage.scroll();
    }

}
