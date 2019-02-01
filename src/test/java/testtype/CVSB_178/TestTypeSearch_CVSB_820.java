package testtype.CVSB_178;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.TestSteps;
import steps.TestTypeSubcategorySteps;
import steps.composed.TestTypeSubategoryComp;
import util.BaseTestClass;

@RunWith(SerenityRunner.class)
public class TestTypeSearch_CVSB_820 extends BaseTestClass {

    @Steps
    TestTypeSubategoryComp testTypeSubategoryComp;

    @Steps
    TestSteps testSteps;

    @Steps
    TestTypeSubcategorySteps testTypeSubcategorySteps;


    @Title("CVSB-178 - Add test type from the latest level of test type drilldown")
    @Test
    public void testAddTestTypeFromLatestLevel() {
        testTypeSubategoryComp.goToTestTypeSubcategoryFromCategory("retest");
        testTypeSubcategorySteps.seeInTestTypeList("paid", "part paid");
        testTypeSubcategorySteps.selectFromTestTypeList("paid");
        testTypeSubcategorySteps.seeInTestTypeList("any psv", "class 6a (seatbelt installation check)");
        testTypeSubcategorySteps.selectFromTestTypeList("class 6a (seatbelt installation check)");
        testSteps.checkTestDetails("BQ91YHQ", "1B7GG36N12S678410");
        testSteps.checkSelectedTestTypes("class 6a (seatbelt installation check) In progress arrow forward");

    }

}
