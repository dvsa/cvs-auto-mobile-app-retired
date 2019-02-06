package steps;

import net.thucydides.core.annotations.Step;
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
}
