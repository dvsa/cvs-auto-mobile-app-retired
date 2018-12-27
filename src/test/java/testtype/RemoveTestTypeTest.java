package testtype;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import steps.TestSteps;
import steps.composed.TestTypeCategoryComp;

@RunWith(SerenityRunner.class)
public class RemoveTestTypeTest {

    @Steps
    TestSteps testSteps;

    @Steps
    TestTypeCategoryComp testTypeCategoryComp;

    @Managed
    public WebDriver webDriver;


    @Title("CVSB-176 / CVSB-760 - AC1 Removing a test type")
    @Test
    public void testRemoveTestType() {
        testTypeCategoryComp.completeAddTestType();
        testSteps.checkTestDetails();
        testSteps.checkSelectedTestTypes("Public Service Vehicle Annual Testing Not complete");
        testSteps.checkTestSubmitted();
        testSteps.swipeTestType("Public Service Vehicle Annual Testing Not complete");
        testSteps.checkTestTypeRemoveButtonVisibility();

    }


    @Title("CVSB-176 / CVSB-761 - AC2 Pressing remove button")
    @Test
    public void testPressRemoveTestTypeButton() {
        testTypeCategoryComp.completeAddTestType();
        testSteps.swipeTestType("Public Service Vehicle Annual Testing Not complete");
        testSteps.checkTestTypeRemoveButtonVisibility();
        testSteps.pressTestTypeRemoveButton();
        testSteps.checkTestTypeRemovalPopUp();

    }


    @Title("CVSB-176 / CVSB-762 - AC3 Confirming removal")
    @Test
    public void testRemovalConfirmation() {
        testTypeCategoryComp.completeAddTestType();
        testSteps.swipeTestType("Public Service Vehicle Annual Testing Not complete");
        testSteps.pressTestTypeRemoveButton();
        testSteps.checkTestTypeRemovalPopUp();
        testSteps.pressRemoveInPopUp();
        testSteps.checkTestTypeDeleted("Public Service Vehicle Annual Testing Not complete");

    }


    @Title("CVSB-176 / CVSB-763 - AC4 Cancelling removal")
    @Test
    public void testRemovalCanceling() {
        testTypeCategoryComp.completeAddTestType();
        testSteps.swipeTestType("Public Service Vehicle Annual Testing Not complete");
        testSteps.pressTestTypeRemoveButton();
        testSteps.checkTestTypeRemovalPopUp();
        testSteps.pressCancelInPopUp();
        testSteps.checkTestDetails();
        testSteps.checkSelectedTestTypes("Public Service Vehicle Annual Testing Not complete");

    }

}
