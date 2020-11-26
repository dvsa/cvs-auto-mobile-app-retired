package testtype.CVSB_695;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import steps.OdometerReadingSteps;
import steps.TestSteps;
import steps.composed.TestTypeCategoryComp;
import steps.util.UtilSteps;
import utils.BaseTestClass;

@Ignore
@RunWith(SerenityRunner.class)
public class OdometerReading_CVSB_1176 extends BaseTestClass {
    @Steps
    UtilSteps utilSteps;

    @Steps
    TestTypeCategoryComp testTypeCategoryComp;

    @Steps
    TestSteps testSteps;

    @Steps
    OdometerReadingSteps odometerReadingSteps;

    @Ignore("[CVSB-8561] Removing test to improve overall efficiency of the mobile app Front-end automation test suite.")
    @Title("CVSB-695 - AC4 - Record odometer reading value")
    public void testRecordOdometerReadingValue() {
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());

        String enteredOdometerReading = "12345678";
        String expectedOdometerReading = "1234567";

        testTypeCategoryComp.goToTestPage(preparerService.getPreparerByIndex(0).getPreparerId(), preparerService.getPreparerByIndex(0).getPreparerName(),super.username);
        testSteps.selectOdometerReading();
        odometerReadingSteps.typeInField(enteredOdometerReading);
        odometerReadingSteps.checkReadingValue(expectedOdometerReading);
        odometerReadingSteps.pressSave();
        testSteps.checkOdometerReadingValue(expectedOdometerReading);
    }
}
