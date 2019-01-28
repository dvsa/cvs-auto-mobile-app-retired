package testtype.CVSB_370;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.TestSteps;
import steps.TestTypeCategorySteps;
import steps.TestTypeSubcategorySteps;
import steps.composed.TestTypeCategoryComp;
import util.BaseTestClass;

@RunWith(SerenityRunner.class)
public class TestTypeAdd_CVSB_768 extends BaseTestClass {

    @Steps
    TestSteps testSteps;

    @Steps
    TestTypeCategorySteps testTypeCategorySteps;

    @Steps
    TestTypeSubcategorySteps testTypeSubcategorySteps;

    @Steps
    TestTypeCategoryComp testTypeCategoryComp;

    @Title("CVSB-370 - Add a test type from the test types list")
    @Test
    public void testAddTestTypeFromList() {
        testTypeCategoryComp.goToTestPage();
        testSteps.addTestType();
        testTypeCategorySteps.selectFromTestTypeList("annual test");
        testSteps.checkTestDetails("BQ91YHQ");
        testSteps.checkSelectedTestTypes("annual test In progress arrow forward");
    }


}
