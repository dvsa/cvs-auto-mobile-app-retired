package steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.assertj.core.api.AssertionsForClassTypes;
import pages.TestHistoryDetailsPage;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import static java.time.LocalDate.now;
import static org.assertj.core.api.Assertions.assertThat;

public class TestHistoryDetailsSteps extends ScenarioSteps {

    TestHistoryDetailsPage testHistoryDetailsPage;

    @Step
    public void checkPageTitle() {
        testHistoryDetailsPage.waitUntilPageIsLoaded();
        assertThat(testHistoryDetailsPage.isPageTitleDisplayed()).isTrue();
    }

    @Step
    public void checkExpiryDateIsCorrect() {

        String expiryDate = testHistoryDetailsPage.getElementValueByLabel("Test expiry");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM uuuu");
        LocalDate expiryDateCalculated = LocalDate.parse(expiryDate, formatter);
        LocalDate expiryDateExpected = now().plusYears(1).minusDays(1);

        System.out.println("Comparing found expiry date to expected...");
        assertThat(expiryDateExpected.compareTo(expiryDateCalculated)).isEqualTo(0);
        System.out.println("- OK");
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
    public String getValueAfterLabel(String label) {
        return testHistoryDetailsPage.getElementValueByLabel(label);
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
    public void checkStatusAndExpiryDateForHistoryDisplayedElements() {
       assertThat(testHistoryDetailsPage.checkAllElementsHaveStatusAndExpiryDate()).isTrue();
    }

    @Step
    public void checkAllElementsAreNotEditable() {
        assertThat(testHistoryDetailsPage.checkAllElementsAreNotEditable()).isFalse();
    }

    @Step
    public void checkElementValueIsDisplayed(String... values) {
        for (String s : values) {
            assertThat(testHistoryDetailsPage.elementIsDisplayed(s)).isTrue();
        }
    }

    @Step
    public void checkElementValue(String element, String value){
        AssertionsForClassTypes.assertThat(testHistoryDetailsPage.checkElementValue(element,value)).isTrue();
    }

    @Step
    public void checkAutoCertificateNumberIsShown(String certificateType) {
        assertThat(testHistoryDetailsPage.getElementValueByLabel(certificateType)).isNotEmpty();
    }

    @Step
    public void scroll() {
        testHistoryDetailsPage.scroll();
    }

    @Step
    public void scrollDown() {
        testHistoryDetailsPage.scrollPageDown();
    }

    public void scrollToElement(String id) {
        testHistoryDetailsPage.scrollToElement(id);
    }
}
