package steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import pages.SelectReasonPage;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SelectReasonSteps extends ScenarioSteps {
    SelectReasonPage selectReasonPage;

    @Step
    public void checkSelectReasonPage() {
        selectReasonPage.waitUntilPageIsLoaded();
        assertThat(selectReasonPage.isPageTitleDisplayed() && selectReasonPage.isTextTipDisplayed()).isTrue();
    }

    @Step
    public void pressBackButton() {
        selectReasonPage.clickOnBackButton();
    }

    @Step
    public void checkListIsScrollableByFirstReason() {
        selectReasonPage.waitUntilPageIsLoaded();
        List<String> listOfExpectedReasonTexts = selectReasonPage.getListOfReasonTexts();
        String firstReasonText = listOfExpectedReasonTexts.get(0);
        assertThat(selectReasonPage.elementFromListIsDisplayed(firstReasonText)).isTrue();
        int oldYPosition = selectReasonPage.getYPositionForElement(firstReasonText);
        selectReasonPage.scrollPageDown();
        assertThat(selectReasonPage.elementFromListIsDisplayed(firstReasonText)).isFalse();
        int newYPosition = selectReasonPage.getYPositionForElement(firstReasonText);
        assertThat(oldYPosition).isNotEqualTo(newYPosition);
    }

    @Step
    public void checkReasonsList() {
        selectReasonPage.waitUntilPageIsLoaded();
        List<String> actualDataList = selectReasonPage.findAllValuesByXpath();
        List<String> expectedDataList = selectReasonPage.getListOfReasonTexts();
        for (String expectedData : expectedDataList) {
            assertThat(actualDataList).contains(expectedData);

        }
    }

}
