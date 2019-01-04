package testtype;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import pages.SelectReasonPage;
import steps.AbandonTestSteps;
import steps.AbandonedTestSteps;
import steps.SelectReasonSteps;
import steps.TestSteps;
import steps.composed.AbandonTestComp;
import steps.composed.TestTypeCategoryComp;

@RunWith(SerenityRunner.class)
public class AbandonTestTypeTest {

    @Steps
    TestSteps testSteps;

    @Steps
    TestTypeCategoryComp testTypeCategoryComp;

    @Steps
    SelectReasonSteps selectReasonSteps;

    @Steps
    AbandonTestSteps abandonTestSteps;

    @Steps
    AbandonTestComp abandonTestComp;

    @Steps
    AbandonedTestSteps abandonedTestSteps;

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

    @Title("CVSB-194 / CVSB-794 - AC1 Select reasons to abandon a test type")
    @Test
    public void testReasonSelectionToAbandonList() {
        testTypeCategoryComp.completeAddTestType();
        testSteps.checkTestDetails();
        testSteps.swipeTestType("Public Service Vehicle Annual Testing Not complete");
        testSteps.pressTestTypeAbandonButton();
        selectReasonSteps.checkSelectReasonPage();
        selectReasonSteps.checkOneOrMoreReasonsAreSelectable();
    }

    @Title("CVSB-194 / CVSB-795 - AC1 Text box for additional comments")
    @Test
    public void testTextBoxForAdditionalComments() {
        testTypeCategoryComp.completeAddTestType();
        testSteps.checkTestDetails();
        testSteps.swipeTestType("Public Service Vehicle Annual Testing Not complete");
        testSteps.pressTestTypeAbandonButton();
        selectReasonSteps.selectMultipleReasons(SelectReasonPage.Reasons.REASON_8, SelectReasonPage.Reasons.REASON_12,
                SelectReasonPage.Reasons.REASON_6, SelectReasonPage.Reasons.REASON_2);
        selectReasonSteps.pressNextButton();
        abandonTestSteps.checkAbandonTestPage();
        abandonTestSteps.checkSelectedReasons(SelectReasonPage.Reasons.REASON_8, SelectReasonPage.Reasons.REASON_12,
                SelectReasonPage.Reasons.REASON_6, SelectReasonPage.Reasons.REASON_2);
        abandonTestSteps.checkCommentSection();
    }

    @Title("CVSB-194 / CVSB-796 - AC1 Add additional comments")
    @Test
    public void testAddAdditionalComments() {
        abandonTestComp.goToAbandonTestScreen(SelectReasonPage.Reasons.REASON_1, SelectReasonPage.Reasons.REASON_10);
        abandonTestSteps.checkAbandonTestPage();
        abandonTestSteps.checkSelectedReasons(SelectReasonPage.Reasons.REASON_1, SelectReasonPage.Reasons.REASON_10);
        abandonTestSteps.checkCommentSection();
        abandonTestSteps.addAdditionalComments("Additional comment test123");
        abandonTestSteps.checkAddedComment("Additional comment test123");
    }

    @Title("CVSB-194 / CVSB-797 - AC2 Warning message options for abandoning a test type")
    @Test
    public void testWarningMessage() {
        abandonTestComp.goToAbandonTestScreen(SelectReasonPage.Reasons.REASON_1, SelectReasonPage.Reasons.REASON_10);
        abandonTestSteps.checkAbandonTestPage();
        abandonTestSteps.checkSelectedReasons(SelectReasonPage.Reasons.REASON_1, SelectReasonPage.Reasons.REASON_10);
        abandonTestSteps.pressDone();
        abandonTestSteps.checkWarningPopUp();
    }

    @Title("CVSB-194 / CVSB-798 - AC2 Select Cancel option for the warning message")
    @Test
    public void testWarningMessageCancel() {
        abandonTestComp.goToAbandonTestScreen(SelectReasonPage.Reasons.REASON_1, SelectReasonPage.Reasons.REASON_10);
        abandonTestSteps.checkAbandonTestPage();
        abandonTestSteps.checkSelectedReasons(SelectReasonPage.Reasons.REASON_1, SelectReasonPage.Reasons.REASON_10);
        abandonTestSteps.pressDone();
        abandonTestSteps.checkWarningPopUp();
        abandonTestSteps.pressCancel();
        abandonTestSteps.checkAbandonTestPage();
        abandonTestSteps.goBackToSelectReason();
        selectReasonSteps.checkSelectReasonPage();
    }

    @Title("CVSB-194 / CVSB-799 - AC2 Confirm abandon for a test type")
    @Test
    public void testWarningMessageConfirm() {
        abandonTestComp.goToAbandonTestScreen(SelectReasonPage.Reasons.REASON_1, SelectReasonPage.Reasons.REASON_10);
        abandonTestSteps.checkAbandonTestPage();
        abandonTestSteps.checkSelectedReasons(SelectReasonPage.Reasons.REASON_1, SelectReasonPage.Reasons.REASON_10);
        abandonTestSteps.pressDone();
        abandonTestSteps.pressAbandon();
        testSteps.checkTestDetails();
    }

    @Title("CVSB-194 / CVSB-800 - AC2 Abandoned test type shown in Test overview screen")
    @Test
    public void testAbandonedTestTypeInOverview() {
        abandonTestComp.goToAbandonTestScreen(SelectReasonPage.Reasons.REASON_1, SelectReasonPage.Reasons.REASON_10);
        abandonTestSteps.checkAbandonTestPage();
        abandonTestSteps.checkSelectedReasons(SelectReasonPage.Reasons.REASON_1, SelectReasonPage.Reasons.REASON_10);
        abandonTestSteps.pressDone();
        abandonTestSteps.pressAbandon();
        testSteps.checkSelectedTestTypes("Public Service Vehicle Annual Testing Abandoned");
    }

    @Title("CVSB-194 / CVSB-800 - AC3 Edit reasons after abandon")
    @Test
    public void testEditReasonAfterAbandon() {
        abandonTestComp.goToAbandonTestScreen(SelectReasonPage.Reasons.REASON_1, SelectReasonPage.Reasons.REASON_10);
        abandonTestSteps.checkAbandonTestPage();
        abandonTestSteps.checkSelectedReasons(SelectReasonPage.Reasons.REASON_1, SelectReasonPage.Reasons.REASON_10);
        abandonTestSteps.pressDone();
        abandonTestSteps.pressAbandon();
        testSteps.selectAbandonedTest("Public Service Vehicle Annual Testing");
        abandonedTestSteps.checkAbandonedTestPage();
        abandonedTestSteps.checkSelectedReasons(SelectReasonPage.Reasons.REASON_1, SelectReasonPage.Reasons.REASON_10);
    }

}
