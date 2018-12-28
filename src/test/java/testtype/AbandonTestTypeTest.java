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
public class AbandonTestTypeTest {

    @Steps
    TestSteps testSteps;

    @Steps
    TestTypeCategoryComp testTypeCategoryComp;

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

}
