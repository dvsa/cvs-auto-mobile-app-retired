package steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import pages.SelectPreparerPage;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SelectPreparerSteps extends ScenarioSteps {
    SelectPreparerPage selectPreparerPage;

    @Step
    public void selectPreparerAndConfirm(String id, String name) {
        selectPreparerPage.waitUntilPageIsLoaded();
        selectPreparerPage.selectPreparer(id, name);
        selectPreparerPage.confirm();
    }

    @Step
    public void selectPreparerAndCancel(String id, String name) {
        selectPreparerPage.waitUntilPageIsLoaded();
        selectPreparerPage.selectPreparer(id, name);
        selectPreparerPage.cancel();
        assertThat(selectPreparerPage.isTitleDisplayed()).isTrue();
    }

    @Step
    public void checkPreparerPopUp(String id, String name){
        selectPreparerPage.waitUntilPageIsLoaded();
        selectPreparerPage.selectPreparer(id, name);
        assertThat(selectPreparerPage.isConfirmOptionDisplayed()).isTrue();
        assertThat(selectPreparerPage.isCancelOptionDisplayed()).isTrue();
    }

    @Step
    public void checkPageTitle() {
        selectPreparerPage.waitUntilPageIsLoaded();
        assertThat(selectPreparerPage.isTitleDisplayed()).isTrue();
    }

    @Step
    public void tapVehicleDetails() {
        selectPreparerPage.waitUntilPageIsLoaded();
        selectPreparerPage.clickBackButton();
    }

    @Step
    public void checkPreparerPageIsScrollable(String id, String name) {
        selectPreparerPage.waitUntilPageIsLoaded();
        int oldYPosition = selectPreparerPage.getYPositionForPreparer(id, name);
        selectPreparerPage.swipeDownPreparerPage();
        int newYPosition = selectPreparerPage.getYPositionForPreparer(id, name);
        assertThat(oldYPosition).isNotEqualTo(newYPosition);
    }

    @Step
    public void searchForPreparerIdAndConfirm(String input, String id, String name) {
        selectPreparerPage.searchForPreparerId(input);
        List idListDisplayed = selectPreparerPage.retrievePreparerIdList();
        assertThat(idListDisplayed).contains(id + " " + name);
        selectPreparerPage.confirm();
    }

    @Step
    public void searchForPreparerIdAndCancel(String input, String id, String name) {
        selectPreparerPage.searchForPreparerId(input);
        List idListDisplayed = selectPreparerPage.retrievePreparerIdList();
        assertThat(idListDisplayed).contains(id + " " + name);
        selectPreparerPage.cancel();
    }

    @Step
    public void searchForInvalidPreparerId(String input, String id, String name) {
        selectPreparerPage.searchForPreparerId(input);
        List idListDisplayed = selectPreparerPage.retrievePreparerIdList();
        assertThat(idListDisplayed).doesNotContain(id + " " + name);
        assertThat(selectPreparerPage.isNoResultsFoundDisplayed()).isTrue();
        assertThat(selectPreparerPage.withoutPreparerIdLinkIsDisplayed()).isTrue();
        assertThat(selectPreparerPage.isSearchBarDisplayed()).isTrue();
    }

    @Step
    public void advanceUsingWithoutPreparerLink() {
        selectPreparerPage.clickWithoutPreparerIdLink();
        selectPreparerPage.confirm();
    }

    @Step
    public void cancelAdvanceUsingWithoutPreparerLink() {
        selectPreparerPage.clickWithoutPreparerIdLink();
        selectPreparerPage.cancel();
        selectPreparerPage.clickSearchBar();
        selectPreparerPage.cancel();
        assertThat(selectPreparerPage.isTitleDisplayed()).isTrue();
    }

    @Step
    public void checkPopUPOptionsArePresent() {
        selectPreparerPage.clickWithoutPreparerIdLink();
        assertThat(selectPreparerPage.isConfirmOptionDisplayed()).isTrue();
        assertThat(selectPreparerPage.isCancelOptionDisplayed()).isTrue();
    }

    @Step
    public void advanceWithNoPreparerInformation() {
        selectPreparerPage.clickNoPreparerIdOption();
        assertThat(selectPreparerPage.isCancelOptionDisplayed());
        selectPreparerPage.confirm();
    }

    @Step
    public void cancelAdvanceWithoutPreparerInformation() {
        selectPreparerPage.clickNoPreparerIdOption();
        assertThat(selectPreparerPage.isConfirmOptionDisplayed());
        selectPreparerPage.cancel();
        assertThat(selectPreparerPage.isTitleDisplayed()).isTrue();
    }

    @Step
    public void noPreparerInformationGiven() {
        selectPreparerPage.clickNoPreparerIdOption();
        selectPreparerPage.isWarningForMissingPreparerDisplayed();
        selectPreparerPage.isConfirmOptionDisplayed();
        selectPreparerPage.isCancelOptionDisplayed();
    }
}
