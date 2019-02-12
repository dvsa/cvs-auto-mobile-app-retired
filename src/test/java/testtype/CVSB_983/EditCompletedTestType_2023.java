package testtype.CVSB_983;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import pages.TestPage;
import steps.TestSteps;
import steps.TestTypeDetailsSteps;
import steps.composed.TestTypeCategoryComp;
import util.BaseTestClass;

@RunWith(SerenityRunner.class)
public class EditCompletedTestType_2023 extends BaseTestClass {

    @Steps
    TestTypeCategoryComp testTypeCategoryComp;

    @Steps
    TestSteps testSteps;

    @Steps
    TestTypeDetailsSteps testTypeDetailsSteps;

    @Title("CVSB-983 - AC5 - VSA edits the in progress test type")
    @Test
    public void testSEditInProgressTestType() {
        testTypeCategoryComp.completeAddTestType();
        testSteps.selectTestType("Annual test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.setCarriedOutDuringTest(false);
        testTypeDetailsSteps.checkSetCarreidOutDuringTestOption("No");
        testTypeDetailsSteps.inputNumberOfSeatbelt("4");
        testTypeDetailsSteps.checkNumberOfSeatbelts("4");
        testTypeDetailsSteps.pressSave();
        testSteps.selectTestType("Annual test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.setCarriedOutDuringTest(true);
        testTypeDetailsSteps.checkSetCarreidOutDuringTestOption("Yes");
        testTypeDetailsSteps.inputNumberOfSeatbelt("7");
        testTypeDetailsSteps.checkNumberOfSeatbelts("7");
        testTypeDetailsSteps.selectMostRecentInstallationCheck();
        testTypeDetailsSteps.setMostRecentInstallationCheckDateOneUnit();
        testTypeDetailsSteps.checkMostRecentInstallationCheckIsDisplayed();
        testTypeDetailsSteps.pressSave();
        testSteps.checkTestTypeStatus("Annual test", TestPage.TestTypeStatuses.EDIT);
    }
}
