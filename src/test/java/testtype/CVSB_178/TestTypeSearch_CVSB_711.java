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
public class TestTypeSearch_CVSB_711 extends BaseTestClass {


    @Steps
    TestSteps testSteps;

    @Steps
    TestTypeCategorySteps testTypeCategorySteps;

    @Steps
    TestTypeCategoryComp testTypeCategoryComp;


    @Title("CVSB-178 - AC1 Test test type drilldown")
    @Test
    public void testTestTypeDrillDown() {
        testTypeCategoryComp.goToTestPage();
        testSteps.seeAddATestType();
        testSteps.addTestType();
        testTypeCategorySteps.checkInTestTypeList("class 6a (seatbelt installation check)", "annual test", "retest",
                "prohibition clearence", "technical test", "voluntary test");
        testTypeCategorySteps.checkTestTypePage();

    }
}
