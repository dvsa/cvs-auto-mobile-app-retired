package steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.apache.commons.lang3.RandomStringUtils;
import pages.AdvisoryDetailsPage;


public class AdvisoryDetailsSteps extends ScenarioSteps {
    AdvisoryDetailsPage advisoryDetailsPage;


    @Step
    public void waitUntilPageIsLoaded() {
        advisoryDetailsPage.waitUntillPageIsLoaded();

    }
    @Step
    public void addNoteInputTapAddNote() {
        String randomData = RandomStringUtils.randomAlphanumeric(150);
        advisoryDetailsPage.sendTextOnAddNote(randomData);
        advisoryDetailsPage.tapAddNote();
    }
}
