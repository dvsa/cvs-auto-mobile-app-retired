package testtype.CVSB_178;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.TestSteps;
import steps.TestTypeCategorySteps;
import steps.TestTypeSubcategorySteps;
import steps.composed.TestTypeSubategoryComp;
import util.BaseTestClass;

@RunWith(SerenityRunner.class)
public class TestTypeSearch_CVSB_819 extends BaseTestClass {


    @Steps
    TestTypeSubategoryComp testTypeSubategoryComp;

    @Steps
    TestSteps testSteps;

    @Steps
    TestTypeCategorySteps testTypeCategorySteps;

    @Steps
    TestTypeSubcategorySteps testTypeSubcategorySteps;



    @Title("CVSB-178 - Return back to the Test overview screen")
    @Test
    public void testReturnToTestOverviewScreen() {
        testTypeSubategoryComp.goToTestTypeSubcategoryFromCategory("class 6a (seatbelt installation check)");
        testTypeSubcategorySteps.seeInTestTypeList("annual");
        testTypeSubcategorySteps.goBackToCategory();
        testTypeCategorySteps.checkInTestTypeList("class 6a (seatbelt installation check)", "annual test", "retest",
                "prohibition clearence", "technical test", "voluntary test");
        testTypeCategorySteps.goBackToTestOverview();
        testSteps.checkTestDetails("BQ91YHQ");


    }


}
