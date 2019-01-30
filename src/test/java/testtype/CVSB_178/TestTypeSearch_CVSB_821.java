package testtype.CVSB_178;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.TestSteps;
import steps.TestTypeCategorySteps;
import steps.composed.TestTypeCategoryComp;
import util.BaseTestClass;

@RunWith(SerenityRunner.class)
public class TestTypeSearch_CVSB_821 extends BaseTestClass {

    @Steps
    TestSteps testSteps;

    @Steps
    TestTypeCategorySteps testTypeCategorySteps;

    @Steps
    TestTypeCategoryComp testTypeCategoryComp;


    @Title("CVSB-178 - Select a test type category that does not contain other test type categories")
    @Test
    public void testSelectTestTypeCategoryWithNoSubcategories() {
        testTypeCategoryComp.addTestType();
        testTypeCategorySteps.selectFromTestTypeList("annual test");
        testSteps.checkTestDetails("BQ91YHQ");
        testSteps.checkSelectedTestTypes("annual test In progress arrow forward");

    }
}
