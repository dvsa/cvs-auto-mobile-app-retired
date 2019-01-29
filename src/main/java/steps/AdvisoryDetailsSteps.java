package steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.apache.commons.lang3.RandomStringUtils;
import pages.AdvisoryDetailsPage;

import static org.assertj.core.api.Assertions.assertThat;


public class AdvisoryDetailsSteps extends ScenarioSteps {
    AdvisoryDetailsPage advisoryDetailsPage;


    @Step
    public void waitUntilPageIsLoaded() {
        advisoryDetailsPage.waitUntilPageIsLoaded();

    }
    @Step
    public void addRandomNoteInputAndTapAddNote() {
        String randomData = RandomStringUtils.randomAlphanumeric(150);
        advisoryDetailsPage.sendTextOnAddNote(randomData);
        advisoryDetailsPage.tapAddNote();
    }

    @Step
    public void addCustomNoteAndTapAddNote(String text) {
        advisoryDetailsPage.sendTextOnAddNote(text);
        advisoryDetailsPage.tapAddNote();
    }

    @Step
    public void checkExistingNote(String expectedText) {
        assertThat(advisoryDetailsPage.getCurrentNote().equals(expectedText)).isTrue();
    }

    @Step
    public void addRandomNoteInputAndTapDone() {
        String randomData = RandomStringUtils.randomAlphanumeric(150);
        advisoryDetailsPage.sendTextOnAddNote(randomData);
        advisoryDetailsPage.tapDone();
    }
}
