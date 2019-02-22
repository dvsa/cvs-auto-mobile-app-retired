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
public class SeatbeltInstallationCheck_2015 extends BaseTestClass {

    @Steps
    TestTypeCategoryComp testTypeCategoryComp;

    @Steps
    TestSteps testSteps;

    @Steps
    TestTypeDetailsSteps testTypeDetailsSteps;

    @Steps
    TestTypeCategorySteps testTypeCategorySteps;

    @Title("CVSB-932 - AC5 - The behaviour of the seatbelt installation check fields when conducting Category B test types")
    @Test
    public void seatbeltInstallationCheckBehaviourWhenConductingCategoryBTestTypes() {
        testTypeCategoryComp.addTestType();
        testTypeCategorySteps.selectFromTestTypeList("Prohibition clearance");
        testTypeCategorySteps.selectFromTestTypeList("Class 6A (seatbelt Installation check)");
        testTypeCategorySteps.selectFromTestTypeList("PG9 retest");
        testSteps.selectTestType("Retest", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.checkSetCarriedOutDuringTestIsNotDisplayed();
        testTypeDetailsSteps.selectMostRecentInstallationCheck();
        testTypeDetailsSteps.cancelMostRecentInstallationCheckOption();
        testTypeDetailsSteps.selectAndCancelInputNumberOfSeatbelt();
    }
}
