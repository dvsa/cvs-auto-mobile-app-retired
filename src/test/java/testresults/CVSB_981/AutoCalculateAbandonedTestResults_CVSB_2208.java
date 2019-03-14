package testresults.CVSB_981;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import pages.SelectReasonPage;
import pages.TestPage;
import steps.*;
import steps.composed.TestTypeCategoryComp;
import util.BaseTestClass;

@RunWith(SerenityRunner.class)
public class AutoCalculateAbandonedTestResults_CVSB_2208 extends BaseTestClass {

    @Steps
    TestSteps testSteps;

    @Steps
    TestTypeCategorySteps testTypeCategorySteps;

    @Steps
    TestTypeCategoryComp testTypeCategoryComp;

    @Steps
    AbandonTestSteps abandonTestSteps;

    @Steps
    SelectReasonSteps selectReasonSteps;


    @Title("CVSB_981 - AC1 Auto-calculate test results upon abandoning a test type (test overview screen)")
    @Test
    public void testAbandonTestTypeInTestOverview() {
        testTypeCategoryComp.goToTestPage("TC7524","Avello Edinburgh Ltd");
        testSteps.addTestType();
        testTypeCategorySteps.selectFromTestTypeList("Annual test");
        testSteps.swipeTestType("Annual test");
        testSteps.pressTestTypeAbandonButton();
        selectReasonSteps.selectAReason(SelectReasonPage.Reasons.REASON_1);
        selectReasonSteps.pressNextButton();
        abandonTestSteps.pressDone();
        abandonTestSteps.pressAbandon();
        testSteps.checkTestTypeStatus("Annual test", TestPage.TestTypeStatuses.ABANDONED);
    }
}
