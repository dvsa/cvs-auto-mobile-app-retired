package testtype.CVSB_695;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import pages.OdometerReadingPage;
import steps.OdometerReadingSteps;
import steps.TestSteps;
import steps.composed.TestTypeCategoryComp;
import util.BaseTestClass;

@RunWith(SerenityRunner.class)
public class OdometerReading_CVSB_1175 extends BaseTestClass {

    @Steps
    TestTypeCategoryComp testTypeCategoryComp;

    @Steps
    TestSteps testSteps;

    @Steps
    OdometerReadingSteps odometerReadingSteps;

    @Title("CVSB-1175 - AC3 - Enter odometer reading value")
    @Test
    public void testEnterOdometerReadingValue() {
        testTypeCategoryComp.goToTestPage();
        testSteps.checkTestDetails("BQ91YHQ");
        testSteps.selectOdometerReading();
        odometerReadingSteps.typeInField("12345678");
        odometerReadingSteps.checkReadingValue("1234567");
        odometerReadingSteps.typeInField("numeric only supported");
        // TODO uncomment and use after bug fix
//        odometerReadingSteps.checkReadingValue("");

    }

}
