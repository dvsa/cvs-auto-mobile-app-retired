package testtype;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import steps.SelectReasonSteps;
import steps.TestSteps;
import steps.composed.TestTypeCategoryComp;

@RunWith(SerenityRunner.class)
public class AbandonTestTypeTest {

    @Steps
    TestSteps testSteps;

    @Steps
    TestTypeCategoryComp testTypeCategoryComp;

    @Steps
    SelectReasonSteps selectReasonSteps;

    @Managed
    public WebDriver webDriver;


    @Title("CVSB-194 / CVSB-791 - AC1 Abandon option")
    @Test
    public void testRemoveTestType() {
        testTypeCategoryComp.completeAddTestType();
        testSteps.checkTestDetails();
        testSteps.swipeTestType("Public Service Vehicle Annual Testing Not complete");
        testSteps.checkTestTypeAbandonButtonVisibility();
    }

    @Title("CVSB-194 / CVSB-792 - AC1 Return back from the “Select reason” screen")
    @Test
    public void testReturnBackFromSelectReason() {
        testTypeCategoryComp.completeAddTestType();
        testSteps.swipeTestType("Public Service Vehicle Annual Testing Not complete");
        testSteps.pressTestTypeAbandonButton();
        selectReasonSteps.checkSelectReasonPage();
        selectReasonSteps.pressBackButton();
        testSteps.checkTestDetails();
    }

    @Title("CVSB-194 / CVSB-793 - AC1 Reasons to abandon list")
    @Test
    public void testReasonsToAbandonList() {
        testTypeCategoryComp.completeAddTestType();
        testSteps.checkTestDetails();
        testSteps.swipeTestType("Public Service Vehicle Annual Testing Not complete");
        testSteps.pressTestTypeAbandonButton();
        selectReasonSteps.checkSelectReasonPage();
        selectReasonSteps.checkReasonsList();
        selectReasonSteps.checkListIsScrollableByFirstReason();
    }

}
