package testtype.CVSB_932;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import pages.TestPage;
import steps.TestSteps;
import steps.TestTypeCategorySteps;
import steps.TestTypeDetailsSteps;
import steps.composed.TestTypeCategoryComp;
import util.BaseTestClass;

@RunWith(SerenityRunner.class)
public class SeatbeltInstallationCheck_2014 extends BaseTestClass {

    @Steps
    TestTypeCategoryComp testTypeCategoryComp;

    @Steps
    TestSteps testSteps;

    @Steps
    TestTypeDetailsSteps testTypeDetailsSteps;

    @Steps
    TestTypeCategorySteps testTypeCategorySteps;

    @Title("CVSB-932 - AC - 4A VSA presses 'Cancel'")
    @Test
    public void cancelMostRecentInstallationCheck() {
        testTypeCategoryComp.addTestType();
        testTypeCategorySteps.selectFromTestTypeList("Prohibition clearance");
        testTypeCategorySteps.selectFromTestTypeList("Any PSV");
        testTypeCategorySteps.selectFromTestTypeList("PG9 retest");
        testTypeCategorySteps.selectFromTestTypeList("Paid");
        testTypeCategorySteps.selectFromTestTypeList("With certification");
        testSteps.selectTestType("Retest", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.selectMostRecentInstallationCheck();
        testTypeDetailsSteps.setMostRecentInstallationCheckDateOneUnit();
        testTypeDetailsSteps.verifyMostRecentInstallationCheckDate();
        testTypeDetailsSteps.cancelMostRecentInstallationCheckOption();
        testTypeDetailsSteps.verifyMostRecentInstallationCheckDate();
    }
}
