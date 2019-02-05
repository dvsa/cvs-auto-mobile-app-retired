package testtype.CVSB_984;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.TestSteps;
import steps.TestTypeCategorySteps;
import steps.TestTypeSteps;
import steps.composed.TestTypeCategoryComp;
import util.BaseTestClass;

@RunWith(SerenityRunner.class)
public class TestReview_CVSB_1955 extends BaseTestClass {

    @Steps
    TestSteps testSteps;

    @Steps
    TestTypeCategoryComp testTypeCategoryComp;

    @Steps
    TestTypeCategorySteps testTypeCategorySteps;

    @Steps
    TestTypeSteps testTypeSteps;

    @Title("CVSB-984 - AC2 - VSA presses 'OK' in the modal window")
    @Test
    public void testPressOkInModalWindow() {
        testTypeCategoryComp.goToTestPage();
        testSteps.addTestType();
        testTypeCategorySteps.selectFromTestTypeList("Annual test");
        testSteps.clickConfirm();
        testSteps.chickOnButton();
        testSteps.selectNotCompleteTest("Annual test");
        testTypeSteps.checkTestTypesPageIsLoadedByTitle();
    }
}
