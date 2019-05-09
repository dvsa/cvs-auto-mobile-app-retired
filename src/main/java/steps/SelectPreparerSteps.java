package steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import pages.SelectPreparerPage;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SelectPreparerSteps extends ScenarioSteps {
    SelectPreparerPage selectPreparerPage;

    @Step
    @Deprecated
    public void selectPreparerAndConfirm(String id, String name) {
        selectPreparerPage.waitUntilPageIsLoaded();
        selectPreparerPage.selectPreparer(id, name);
        selectPreparerPage.confirm();
    }

    @Step
    @Deprecated
    public void selectPreparerAndCancel(String id, String name) {
        selectPreparerPage.waitUntilPageIsLoaded();
        selectPreparerPage.selectPreparer(id, name);
        selectPreparerPage.cancel();
        assertThat(selectPreparerPage.isTitleDisplayed()).isTrue();
    }

    @Step
    @Deprecated
    public void checkPreparerPopUp(String id, String name){
        selectPreparerPage.waitUntilPageIsLoaded();
        selectPreparerPage.selectPreparer(id, name);
        assertThat(selectPreparerPage.isConfirmOptionDisplayed()).isTrue();
        assertThat(selectPreparerPage.isCancelOptionDisplayed()).isTrue();
    }

    @Step
    @Deprecated
    public void checkPageTitle() {
        selectPreparerPage.waitUntilPageIsLoaded();
        assertThat(selectPreparerPage.isTitleDisplayed()).isTrue();
    }

    @Step
    @Deprecated
    public void tapVehicleDetails() {
        selectPreparerPage.waitUntilPageIsLoaded();
        selectPreparerPage.clickBackButton();
    }

    @Step
    @Deprecated
    public void checkPreparerPageIsScrollable(String id, String name) {
        selectPreparerPage.waitUntilPageIsLoaded();
        int oldYPosition = selectPreparerPage.getYPositionForPreparer(id, name);
        selectPreparerPage.swipeDownPreparerPage();
        int newYPosition = selectPreparerPage.getYPositionForPreparer(id, name);
        assertThat(oldYPosition).isNotEqualTo(newYPosition);
    }

    @Step
    @Deprecated
    public void searchForPreparerIdAndCancel(String input, String id, String name) {
        selectPreparerPage.searchForPreparerId(input);
        List idListDisplayed = selectPreparerPage.retrievePreparerIdList();
        assertThat(idListDisplayed).contains(id + " " + name);
        selectPreparerPage.cancel();
    }

    @Step
    @Deprecated
    public void searchForInvalidPreparerId(String input, String id, String name) {
        selectPreparerPage.searchForPreparerId(input);
        List idListDisplayed = selectPreparerPage.retrievePreparerIdList();
        assertThat(idListDisplayed).doesNotContain(id + " " + name);
        assertThat(selectPreparerPage.isNoResultsFoundDisplayed()).isTrue();
        assertThat(selectPreparerPage.withoutPreparerIdLinkIsDisplayed()).isTrue();
        assertThat(selectPreparerPage.isSearchBarDisplayed()).isTrue();
    }

    @Step
    @Deprecated
    public void advanceUsingWithoutPreparerLink() {
        selectPreparerPage.clickWithoutPreparerIdLink();
        selectPreparerPage.confirm();
    }

    @Step
    @Deprecated
    public void cancelAdvanceUsingWithoutPreparerLink() {
        selectPreparerPage.clickWithoutPreparerIdLink();
        selectPreparerPage.cancel();
        selectPreparerPage.clickSearchBar();
        selectPreparerPage.clickCancelInPopUp();
        assertThat(selectPreparerPage.isTitleDisplayed()).isTrue();
    }

    @Step
    @Deprecated
    public void checkPopUPOptionsArePresent() {
        selectPreparerPage.clickWithoutPreparerIdLink();
        assertThat(selectPreparerPage.isConfirmOptionDisplayed()).isTrue();
        assertThat(selectPreparerPage.isCancelOptionDisplayed()).isTrue();
    }

    @Step
    @Deprecated
    public void advanceWithNoPreparerInformation() {
        selectPreparerPage.clickNoPreparerIdOption();
        assertThat(selectPreparerPage.isCancelOptionDisplayedAfterNoPreparerIsSelected()).isTrue();
        selectPreparerPage.confirm();
    }

    @Step
    @Deprecated
    public void cancelAdvanceWithoutPreparerInformation() {
        selectPreparerPage.clickNoPreparerIdOption();
        assertThat(selectPreparerPage.isConfirmOptionDisplayed()).isTrue();
        selectPreparerPage.cancel();
        assertThat(selectPreparerPage.isTitleDisplayed()).isTrue();
    }

    @Step
    @Deprecated
    public void noPreparerInformationGiven() {
        selectPreparerPage.clickNoPreparerIdOption();
        selectPreparerPage.isWarningForMissingPreparerDisplayed();
        selectPreparerPage.isConfirmOptionDisplayed();
        selectPreparerPage.isCancelOptionDisplayedAfterNoPreparerIsSelected();
    }
}
