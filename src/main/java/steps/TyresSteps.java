package steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.openqa.selenium.WebElement;
import pages.TyresPage;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class TyresSteps extends ScenarioSteps {

    TyresPage tyresPage;

    @Step
    public void checkDetails(String... details) {
        tyresPage.waitUntilPageIsLoaded();
        List<String> axleData = tyresPage.getDataSetBetweenTitles("AXLE 1", "");
        assertThat(axleData).contains(details);
    }

    @Step
    public void checkDetailsOfAxle(String axle, String... details) {
        tyresPage.waitUntilPageIsLoaded();
        List<WebElement> axleData = tyresPage.getAxleData(axle);
        List<WebElement> extractedValues = axleData.stream().filter(detail -> axleData.indexOf(detail)%2==0).collect(Collectors.toList());
//        System.out.println("AXLE: " + axle);
//        System.out.println("List of axleData: " + axleData);
//        System.out.println("details: " + Arrays.asList(details));
        List<String> valuesToString = extractedValues.stream().map(value -> value.getAttribute("name")).collect(Collectors.toList());
//        System.out.println("extracted values: " + valuesToString);
            assertThat(Arrays.asList(details).equals(valuesToString)).isTrue();
    }

    @Step
    public void pressBackButton() {
        tyresPage.clickOnBack();
    }

    @Step
    public void checkIfFieldIsNotEditable(String field) {
        tyresPage.waitUntilPageIsLoaded();
        assertThat(tyresPage.isFieldEditableById(field)).isFalse();
    }

    @Step
    public void checkTyreUseCode(String tyreUseCode) {
        assertThat(tyresPage.getTyreUseCodeValue().getAttribute("name")).isEqualTo(tyreUseCode);
    }
}
