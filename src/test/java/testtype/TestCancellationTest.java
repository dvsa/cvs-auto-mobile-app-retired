package testtype;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import steps.CancelTestSteps;
import steps.SiteVisitSteps;
import steps.TestSteps;
import steps.composed.TestTypeCategoryComp;

@RunWith(SerenityRunner.class)
public class TestCancellationTest {

    @Steps
    TestSteps testSteps;

    @Steps
    TestTypeCategoryComp testTypeCategoryComp;

    @Steps
    CancelTestSteps cancelTestSteps;

    @Steps
    SiteVisitSteps siteVisitSteps;

    @Managed
    public WebDriver webDriver;


    @Title("CVSB-508 / CVSB-851 - AC1 VSA decides to cancel a test")
    @Test
    public void testCancel() {
        testTypeCategoryComp.goToTestPage();
        testSteps.checkTestDetails();
        testSteps.pressCancelBottomRight();
        cancelTestSteps.checkPageDetails();
        cancelTestSteps.checkTextInputField();
    }

    @Title("CVSB-508 / CVSB-852 - AC4 Return back to the Test overview screen")
    @Test
    public void testReturnToTest() {
        testTypeCategoryComp.goToTestPage();
        testSteps.pressCancelBottomRight();
        cancelTestSteps.checkPageDetails();
        cancelTestSteps.pressBackButton();
        testSteps.checkTestDetails();
    }

    @Title("CVSB-508 / CVSB-853 - AC1 Submit cancellation without completing the mandatory fields")
    @Test
    public void testSubmitWithoutCompletingField() {
        testTypeCategoryComp.goToTestPage();
        testSteps.pressCancelBottomRight();
        cancelTestSteps.checkPageDetails();
        cancelTestSteps.pressSubmit();
        cancelTestSteps.checkNoReasonPopUp();
        cancelTestSteps.pressOKNoReasonPopUp();
    }

    @Title("CVSB-508 / CVSB-854 - AC3 Submit test cancellation when the test contains at least one test type")
    @Test
    public void testSubmitWithAtLeastOneTestType() {
        testTypeCategoryComp.completeAddTestType();
        testSteps.pressCancelBottomRight();
        cancelTestSteps.checkPageDetails();
        cancelTestSteps.addReasonForCancellation("CANCEL Reason test Text 1234");
        cancelTestSteps.pressSubmit();
        cancelTestSteps.pressSubmitInPopUp();
        siteVisitSteps.checkSiteVisitPage();
        //TODO to refactor after bug fixes
        siteVisitSteps.checkTestStatus();
    }

    @Title("CVSB-508 / CVSB-855 - AC2 Submit test cancellation when the test does not contain test types")
    @Test
    public void testSubmitWithNoTestType() {
        testTypeCategoryComp.goToTestPage();
        testSteps.pressCancelBottomRight();
        cancelTestSteps.checkPageDetails();
        cancelTestSteps.addReasonForCancellation("CANCEL Reason test Text 1234");
        cancelTestSteps.pressSubmit();
        cancelTestSteps.pressSubmitInPopUp();
        siteVisitSteps.checkSiteVisitPage();
        //TODO continue and refactor after bug fix

    }

}
