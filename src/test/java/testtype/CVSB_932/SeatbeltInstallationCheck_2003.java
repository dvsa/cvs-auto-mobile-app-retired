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
public class SeatbeltInstallationCheck_2003 extends BaseTestClass {

    @Steps
    TestTypeCategoryComp testTypeCategoryComp;

    @Steps
    TestSteps testSteps;

    @Steps
    TestTypeDetailsSteps testTypeDetailsSteps;

    @Steps
    TestTypeCategorySteps testTypeCategorySteps;

    @Title("CVSB-932 - AC - 2 Editing 'Carried out during this test'")
    @Test
    public void editingCarriedOutDuringTest() {
        testTypeCategoryComp.goToTestType(preparerService.getPreparerByIndex(0).getPreparerId(), preparerService.getPreparerByIndex(0).getPreparerName(),super.username);
        testTypeCategorySteps.waitUntilPageIsLoaded();
        testTypeCategorySteps.selectFromTestTypeList("Retest");
        testTypeCategorySteps.waitUntilPageIsLoaded("Retest");
        testTypeCategorySteps.waitUntilPageIsLoadedByXPath("Part Paid retest");
        testTypeCategorySteps.selectFromTestTypeList("Part Paid retest");
        testTypeCategorySteps.selectFromTestTypeList("Any PSV retest");
        testSteps.selectTestType("Retest", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.checkSetCarriedOutDuringTestOption("No");
        testTypeDetailsSteps.checkOptionsForCarriedOutSeatbeltCheckAreDisplayed();
        testTypeDetailsSteps.checkSetCarriedOutDuringTestOption("No");
    }
}
