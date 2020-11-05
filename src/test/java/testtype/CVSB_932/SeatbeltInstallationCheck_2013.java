package testtype.CVSB_932;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import pages.TestPage;
import steps.TestSteps;
import steps.TestTypeCategorySteps;
import steps.TestTypeDetailsSteps;
import steps.composed.TestTypeCategoryComp;
import util.BaseTestClass;

@Ignore
@RunWith(SerenityRunner.class)
public class SeatbeltInstallationCheck_2013 extends BaseTestClass {

    @Steps
    TestTypeCategoryComp testTypeCategoryComp;

    @Steps
    TestSteps testSteps;

    @Steps
    TestTypeDetailsSteps testTypeDetailsSteps;

    @Steps
    TestTypeCategorySteps testTypeCategorySteps;

    @Ignore("[CVSB-8289] Removing test to improve overall efficiency of the mobile app Front-end automation test suite.")
    @Title("CVSB-932 - AC - 4A VSA presses 'Done'")
    public void doneMostRecentInstallationCheck() {
        testTypeCategoryComp.goToTestType(preparerService.getPreparerByIndex(0).getPreparerId(), preparerService.getPreparerByIndex(0).getPreparerName(),super.username);
        testTypeCategorySteps.selectFromTestTypeList("Prohibition clearance");
        testTypeCategorySteps.selectFromTestTypeList("Any PSV");
        testTypeCategorySteps.selectFromTestTypeList("PG9 retest");
        testTypeCategorySteps.selectFromTestTypeList("Paid");
        testTypeCategorySteps.selectFromTestTypeList("With certification");
        testSteps.selectTestType("Prohibition clearance", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.selectMostRecentInstallationCheck();
        testTypeDetailsSteps.setMostRecentInstallationCheckDateOneUnit();
        testTypeDetailsSteps.verifyMostRecentInstallationCheckDate();
    }
}
