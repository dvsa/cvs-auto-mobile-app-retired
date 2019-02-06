package steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import pages.TestTypeDetailsPage;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TestTypeDetailsSteps extends ScenarioSteps {

    TestTypeDetailsPage testTypeDetailsPage;

    @Step
    public void checkTestTypeDetailsPage() {
        assertThat(testTypeDetailsPage.isPageTitleDisplayed()).isTrue();
    }

}
