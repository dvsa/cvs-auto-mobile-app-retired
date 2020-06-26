package steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import pages.SearchCriteriaPage;
import data.util.SearchCriteria;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchCriteriaSteps extends ScenarioSteps {

    private SearchCriteriaPage searchCriteriaPage;

    @Step
    public void checkTitleIsDisplayed() {
        assertThat(searchCriteriaPage.isPageTitleDisplayed()).isTrue();
    }

    @Step
    public void checkSearchCriteriaOptionsAreDisplayed() {
        assertThat(searchCriteriaPage.areSearchCriteriaDisplayed()).isTrue();
    }

    @Step
    public void selectSearchCriteria(SearchCriteria criteria) {
        searchCriteriaPage.selectCriteria(criteria);
        searchCriteriaPage.pressSave();
    }
}
