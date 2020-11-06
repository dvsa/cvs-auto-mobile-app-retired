package testtype.CVSB_370;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.TestSteps;
import steps.TestTypeCategorySteps;
import steps.composed.TestTypeCategoryComp;
import util.BaseTestClass;

@Ignore
@RunWith(SerenityRunner.class)
public class TestTypeAdd_CVSB_766 extends BaseTestClass {

    @Steps
    TestSteps testSteps;

    @Steps
    TestTypeCategorySteps testTypeCategorySteps;


    @Steps
    TestTypeCategoryComp testTypeCategoryComp;

    @Ignore("[CVSB-8561] Removing test to improve overall efficiency of the mobile app Front-end automation test suite.")
    @Title("CVSB-370 - AC2 Test types list")
    public void testTestTypeList() {
        testTypeCategoryComp.goToTestPage(preparerService.getPreparerByIndex(0).getPreparerId(), preparerService.getPreparerByIndex(0).getPreparerName(),super.username);
        testSteps.checkAddATestTypeButtonVisibility();
        testSteps.addTestType();
        testTypeCategorySteps.checkInTestTypeList("Annual test", "Class 6A", "Retest",
                "Prohibition clearance", "Technical test", "Voluntary test");
        testTypeCategorySteps.checkTestTypePage();

    }

}
