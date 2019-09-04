package testtype.CVSB_176;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.TestSteps;
import steps.composed.TestTypeCategoryComp;
import util.BaseTestClass;

@RunWith(SerenityRunner.class)
public class TestTypeRemove_CVSB_760 extends BaseTestClass {

    @Steps
    TestSteps testSteps;

    @Steps
    TestTypeCategoryComp testTypeCategoryComp;


    @Title("CVSB-176 - AC1 Removing a test type")
    @Test
    public void testRemoveTestType() {
        testTypeCategoryComp.completeAddTestType(preparerService.getPreparerByIndex(0).getPreparerId(), preparerService.getPreparerByIndex(0).getPreparerName());
        testSteps.checkTestDetails("BQ91YHQ","1B7GG36N12S678410");
        testSteps.checkSelectedTestTypes("Annual test In progress arrow forward");
        testSteps.clickReview();
        testSteps.swipeTestType("Annual test In progress arrow forward");
        testSteps.checkTestTypeRemoveButtonVisibility();
    }
}
