package testtype.CVSB_901;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.TestSteps;
import steps.TestTypeDetailsSteps;
import steps.composed.TestTypeCategoryComp;
import util.BaseTestClass;

@RunWith(SerenityRunner.class)
public class SeatbeltInstallationCheck_1942 extends BaseTestClass {

    @Steps
    TestTypeCategoryComp testTypeCategoryComp;

    @Steps
    TestSteps testSteps;

    @Steps
    TestTypeDetailsSteps testTypeDetailsSteps;

    @Title("CVSB-901 - AC2 - Cancel editing of whether a seat belt installation check was carried out during this inspection")
    @Test
    public void testCancelSeatbeltInstallationCheck() {
        testTypeCategoryComp.completeAddTestType();
        testSteps.selectAnnualTestReading();
        testTypeDetailsSteps.checkSetCarreidOutDuringTestOption("No");
        testTypeDetailsSteps.cancelCarriedOutDuringTest();
        testTypeDetailsSteps.checkSetCarreidOutDuringTestOption("No");
    }
}
