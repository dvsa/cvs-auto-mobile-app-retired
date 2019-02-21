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
        testTypeSubategoryComp.goToTestTypeSubcategoryFromCategory("Class 6A");
        testTypeSubcategorySteps.seeInTestTypeList("Annual test");
        testTypeSubcategorySteps.goBackToCategory();
        testTypeCategorySteps.checkInTestTypeList("Annual test", "Class 6A", "Retest",
                "Prohibition clearence", "Technical test", "Voluntary test");
        testTypeCategorySteps.goBackToTestOverview();
        testSteps.checkTestDetails("BQ91YHQ", "1B7GG36N12S678410");

    }

}
