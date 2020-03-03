package testtype.CVSB_695;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Ignore;
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

    @Ignore("CVSB-8749 - maintenance for improving test suite speed")
    @Title("CVSB-695 - AC3 - Enter odometer reading value")
    public void testEnterOdometerReadingValue() {
        testTypeCategoryComp.goToTestPage(preparerService.getPreparerByIndex(0).getPreparerId(), preparerService.getPreparerByIndex(0).getPreparerName());
        testSteps.checkTestDetails("BQ91YHQ", "1B7GG36N12S678410");
        testSteps.selectOdometerReading();
        odometerReadingSteps.typeInField("12345678");
        odometerReadingSteps.checkReadingValue("1234567");
        odometerReadingSteps.typeInField("numeric only supported");
        // TODO uncomment and use after bug fix
//        odometerReadingSteps.checkReadingValue("");
    }
}
