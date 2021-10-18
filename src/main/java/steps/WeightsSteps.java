package steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.WeightsPage;

import java.util.HashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WeightsSteps extends ScenarioSteps {

    public static final Logger logger = LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);

    WeightsPage weightsPage;

    @Step
    public void checkDetails(String axleKerb, String axleLaden, String axleGb, String axleDesign, String grossKerb,
                             String grossLaden, String grossGb, String grossDesign, String uniladenKerb) {
        weightsPage.waitUntilPageIsLoaded();
        List<String> axleData = weightsPage.getDataSetBetweenTitles("AXLE 1", "AXLE 2");
        assertThat(axleData).contains(axleKerb, axleLaden, axleGb, axleDesign);

        List<String> grossData = weightsPage.getDataSetBetweenTitles("GROSS", "UNLADEN");
        assertThat(grossData).contains(grossKerb, grossLaden, grossGb, grossDesign);

        List<String> unladenData = weightsPage.getDataSetBetweenTitles("UNLADEN", "");
        assertThat(unladenData).contains(uniladenKerb);

    }

    @Step
    public void checkContentCategories(String categoryItem, String gbValue, String designValue) {
        weightsPage.waitUntilPageIsLoaded();
        HashMap<String, String> data = weightsPage.getDataSetCategory(categoryItem);
        logger.info("GB: " + data.get("GB") + " compared to: " + gbValue);
        logger.info("GB: " + data.get("Design" + " compared to: " + designValue));
        assertThat(data.get("GB").equals(gbValue) && data.get("Design").equals(designValue)).isTrue();
    }

    @Step
    public void pressBackButton() {
        weightsPage.clickOnBack();
    }

    @Step
    public void checkIfFieldIsNotEditable(String field) {
        weightsPage.waitUntilPageIsLoaded();
        assertThat(weightsPage.isFieldEditableById(field)).isFalse();
    }

    @Step
    public void checkFieldIsListed(String fieldName) {
        weightsPage.waitUntilPageIsLoaded();
        assertThat(weightsPage.isFieldListed(fieldName)).isTrue();
    }

    @Step
    public void checkFieldHasValue(String fieldName, String value) {
        weightsPage.waitUntilPageIsLoaded();
        assertThat(weightsPage.getFieldValue(fieldName)).isEqualTo(value);
    }
    @Step
    public void checkAxleOrderStep(String fieldName1, String fieldName2) {
        weightsPage.waitUntilPageIsLoaded();
        assertThat(weightsPage.checkAxleOrder(fieldName2)).isGreaterThan(weightsPage.checkAxleOrder(fieldName1));
    }

    @Step
    public void checkGrossIsDisplayed() {
        weightsPage.waitUntilPageIsLoaded();
        assertThat(weightsPage.getGrossGb().equals("GB")).isTrue();
        assertThat(weightsPage.getGrossDesign().equals("Design")).isTrue();
    }

}
