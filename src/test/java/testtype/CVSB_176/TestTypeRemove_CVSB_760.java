package testtype.CVSB_176;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Ignore;
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

    @Ignore("[CVSB-8561] Removing test to improve overall efficiency of the mobile app Front-end automation test suite.")
    @Title("CVSB-176 - AC1 Removing a test type")
    public void testRemoveTestType() {
        testTypeCategoryComp.completeAddTestType(preparerService.getPreparerByIndex(0).getPreparerId(), preparerService.getPreparerByIndex(0).getPreparerName());
        testSteps.checkTestDetails("BQ91YHQ","1B7GG36N12S678410");
        testSteps.checkSelectedTestTypes("Annual test In progress arrow forward");
        testSteps.swipeTestType("Annual test In progress arrow forward");
        testSteps.checkTestTypeRemoveButtonVisibility();
    }
}
