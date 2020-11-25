package testtype.CVSB_695;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import pages.OdometerReadingPage;
import pages.TestPage;
import steps.OdometerReadingSteps;
import steps.TestSteps;
import steps.composed.TestTypeCategoryComp;
import steps.util.UtilSteps;
import util.BaseTestClass;

@Ignore
@RunWith(SerenityRunner.class)
public class OdometerReading_CVSB_1184 extends BaseTestClass {

    @Steps
    UtilSteps utilSteps;

    @Steps
    TestTypeCategoryComp testTypeCategoryComp;

    @Steps
    TestSteps testSteps;

    @Steps
    OdometerReadingSteps odometerReadingSteps;

    @Ignore("CVSB-8749 - maintenance for improving test suite speed")
    @Title("CVSB-695 - AC11 - Save odometer reading - all fields completed")
    public void testSaveOdometerAllFieldsCompleted() {
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        testTypeCategoryComp.goToTestPage(preparerService.getPreparerByIndex(0).getPreparerId(), preparerService.getPreparerByIndex(0).getPreparerName(),super.username);
        testSteps.selectOdometerReading();
        odometerReadingSteps.typeInField("97000");
        odometerReadingSteps.pressEditUnit();
        odometerReadingSteps.selectUnitOption(OdometerReadingPage.UnitOptions.MILES);
        odometerReadingSteps.pressSave();
        testSteps.checkOdometerReadingValueFormatted("97,000");
        testSteps.checkOdometerReadingButton(TestPage.OdometerUnitIndicatives.MI);
    }
}
