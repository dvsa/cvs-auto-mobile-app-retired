package steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import pages.WeightsPage;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WeightsSteps extends ScenarioSteps {

    WeightsPage weightsPage;

    @Step
    public void checkDetails(String axleKerb, String axleLaden, String axleGb, String axleDesign, String grossKerb,
                             String grossLaden, String grossGb, String grossDesign, String uniladenKerb) {
        weightsPage.waitUntilPageIsLoaded();
        List<String> axleData = weightsPage.getDataSetBetweenTitles("AXLE 24075", "GROSS");
        assertThat(axleData).contains(axleKerb, axleLaden, axleGb, axleDesign);

        List<String> grossData = weightsPage.getDataSetBetweenTitles("GROSS", "UNLADEN");
        assertThat(grossData).contains(grossKerb, grossLaden, grossGb, grossDesign);

        List<String> unladenData = weightsPage.getDataSetBetweenTitles("UNLADEN", "");
        assertThat(unladenData).contains(uniladenKerb);

    }

    @Step
    public void pressBackButton() {
        weightsPage.clickOnBack();
    }
}
