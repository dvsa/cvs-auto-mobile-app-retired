package steps.composed;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.steps.ScenarioSteps;
import steps.*;

public class TestTypeSubategoryComp extends ScenarioSteps {

    @Steps
    TestTypeCategoryComp testTypeCategoryComp;

    @Steps
    TestTypeCategorySteps testTypeCategorySteps;

    @Step
    public void goToTestTypeSubcategoryFromCategory(String category, String preparerId, String preparerName, String username) {
        testTypeCategoryComp.goToTestType(preparerId, preparerName, username);
        testTypeCategorySteps.checkTestTypePage();
        testTypeCategorySteps.selectFromTestTypeList(category);
    }


}
