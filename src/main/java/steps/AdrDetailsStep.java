package steps;

import net.thucydides.core.annotations.Step;
import pages.AdrDetailsPage;

import static org.assertj.core.api.Assertions.assertThat;

public class AdrDetailsStep {

    AdrDetailsPage adrDetailsPage;

    @Step
    public void waitUntilPageIsLoaded() {
        adrDetailsPage.waitUntilPageIsLoaded();
    }

    @Step
    public void checkVinChassisNumberIs(String vinChassisNumber) {
        assertThat(adrDetailsPage.isAttribute("VIN / Chassis number", vinChassisNumber)).isTrue();
    }

    @Step
    public void checkAdrDetailSectionIsDisplayed(String adrDetail) {
        assertThat(adrDetailsPage.elementIsDisplayed(adrDetail)).isTrue();
    }

    @Step
    public void scrollTheAdrDetailPage() {
        adrDetailsPage.scrollDetailPage();
    }

    @Step
    public void checkAdrDetailSectionContains(String adrSection, String adrDetail) {
        assertThat(adrDetailsPage.elementIsDisplayedAfter(adrDetail, adrSection)).isTrue();
    }

    @Step
    public void checkAdrDetailHasValue(String detail, String value) {
        assertThat(adrDetailsPage.elementIsDisplayedRightAfter(detail,value)).isTrue();
    }

    @Step
    public void checkAdrDetailSectionIsNotDisplayed(String section) {
        assertThat((adrDetailsPage.elementIsDisplayed(section))).isFalse();
    }

    @Step
    public void checkAdrDetailSectionNotContains(String adrSection, String adrDetail) {
        assertThat(adrDetailsPage.elementIsDisplayedAfter(adrDetail, adrSection)).isFalse();
    }

    @Step
    public void checkThePageTitleIs(String pageTitle) {
        assertThat(adrDetailsPage.isPageTitleDisplayed(pageTitle)).isTrue();
    }
}
