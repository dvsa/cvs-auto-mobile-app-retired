package steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import pages.SeatbeltInstallationCheckPage;

import static org.assertj.core.api.Assertions.assertThat;


public class SeatbeltInstallationCheckSteps extends ScenarioSteps {

    SeatbeltInstallationCheckPage seatbeltInstallationCheckPage;

    @Step
    public void inputNumberOfSeatbelts(String number) {
        seatbeltInstallationCheckPage.setSetbealtNumber(number);
        seatbeltInstallationCheckPage.clickDone();
    }

    @Step
    public void pressCancel() {
        seatbeltInstallationCheckPage.clickCancel();
    }

    @Step
    public void doneInputNumberOfSeatbelt() {
        seatbeltInstallationCheckPage.clickDone();
    }

    @Step
    public void checkDoneAndCancelOptionsForSeatbeltNumber() {
        assertThat(seatbeltInstallationCheckPage.isCancelDisplayed()).isTrue();
        assertThat(seatbeltInstallationCheckPage.isDoneDisplayed()).isTrue();
    }

    @Step
    public void checktSeabeltDetailsPage() {
        assertThat(seatbeltInstallationCheckPage.isPageTitleDisplayed()).isTrue();
        assertThat(seatbeltInstallationCheckPage.isInputFieldDisplayed()).isTrue();
        assertThat(seatbeltInstallationCheckPage.isFieldTitleDisplayed()).isTrue();
        assertThat(seatbeltInstallationCheckPage.isFieldTextDisplayed()).isTrue();
    }

}