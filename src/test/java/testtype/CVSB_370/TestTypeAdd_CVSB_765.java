package testtype.CVSB_370;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.SelectPreparerSteps;
import steps.TestSteps;
import steps.composed.PreparerComp;
import util.BaseTestClass;

@RunWith(SerenityRunner.class)
public class TestTypeAdd_CVSB_765 extends BaseTestClass {

    @Steps
    PreparerComp preparerComp;

    @Steps
    SelectPreparerSteps selectPreparerSteps;

    @Steps
    TestSteps testSteps;


    @Title("CVSB-370 - AC1 'Add a test type' option")
    @Test
    public void testTestTypeOption() {
        preparerComp.goToSelectPreparer();
        selectPreparerSteps.selectPreparerAndConfirm(preparerService.getPreparerByIndex(0).getPreparerId(), preparerService.getPreparerByIndex(0).getPreparerName());
        testSteps.checkTestDetails("BQ91YHQ","1B7GG36N12S678410");
        testSteps.checkAddATestTypeButtonVisibility();

    }

}
