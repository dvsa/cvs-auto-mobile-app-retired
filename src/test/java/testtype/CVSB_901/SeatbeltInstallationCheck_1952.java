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
public class SeatbeltInstallationCheck_1952 extends BaseTestClass {

    @Steps
    TestTypeCategoryComp testTypeCategoryComp;

    @Steps
    TestSteps testSteps;

    @Steps
    TestTypeDetailsSteps testTypeDetailsSteps;

    @Title("CVSB-901 - AC10 - Record most recent installation check")
    @Test
    public void testRecordMostInstallationCheck() {
        testTypeCategoryComp.completeAddTestType();
        testSteps.selectAnnualTestReading();
        testTypeDetailsSteps.selectMostRecentInstallationCheck();
        testTypeDetailsSteps.setMostRecentInstallationCheckDate();
        testTypeDetailsSteps.verifyMostRecentInstallationCheckDate();
    }
}
