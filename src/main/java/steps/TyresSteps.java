package steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import pages.TyresPage;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TyresSteps extends ScenarioSteps {

    TyresPage tyresPage;

    @Step
    public void checkDetails(String tyreSize, String ply, String fitment, String sdIndex, String speedCat,
                             String tyreCode) {
        tyresPage.waitUntilPageIsLoaded();
        List<String> axleData = tyresPage.getDataSetBetweenTitles("AXLE 24075", "");
        assertThat(axleData).contains(tyreSize, ply, fitment, sdIndex, speedCat, tyreCode);

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
}
