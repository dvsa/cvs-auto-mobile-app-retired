package testtype.CVSB_695;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.OdometerReadingSteps;
import steps.TestSteps;
import steps.composed.TestTypeCategoryComp;
import util.BaseTestClass;

@RunWith(SerenityRunner.class)
public class OdometerReading_CVSB_1178 extends BaseTestClass {

    @Steps
    TestTypeCategoryComp testTypeCategoryComp;

    @Steps
    TestSteps testSteps;

    @Steps
    OdometerReadingSteps odometerReadingSteps;

    @Title("CVSB-1178 - AC3 - Edit the Reading value within the Odometer reading screen")
    @Test
    public void testEditReadingValueWithinTheOdometerReadingScreen() {
        testTypeCategoryComp.goToTestPage();
        testSteps.checkTestDetails("BQ91YHQ");
        testSteps.selectOdometerReading();
        odometerReadingSteps.typeInField("12345678");
        odometerReadingSteps.pressSave();
        testSteps.checkOdometerReadingValue("1,234,567");
        testSteps.selectOdometerReading();
        odometerReadingSteps.typeInField("87654321");
        odometerReadingSteps.checkReadingValue("8765432");
    }

}
