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
import steps.TestTypeSubcategorySteps;
import steps.composed.TestTypeCategoryComp;
import steps.util.UtilSteps;
import utils.BaseTestClass;

@RunWith(SerenityRunner.class)
public class SeatbeltInstallationCheck_2005 extends BaseTestClass {

    @Steps
    UtilSteps utilSteps;

    @Steps
    TestTypeCategoryComp testTypeCategoryComp;

    @Steps
    TestSteps testSteps;

    @Steps
    TestTypeDetailsSteps testTypeDetailsSteps;

    @Steps
    TestTypeCategorySteps testTypeCategorySteps;

    @Steps
    TestTypeSubcategorySteps testTypeSubcategorySteps;

    @Title("CVSB-932 - AC - 2A VSA selects No")
    @Test
    public void selectIsNotCarriedOut() {
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        testTypeCategoryComp.goToTestType(preparerService.getPreparerByIndex(0).getPreparerId(), preparerService.getPreparerByIndex(0).getPreparerName(),super.username);
        testTypeCategorySteps.waitUntilPageIsLoaded();
        testTypeCategorySteps.selectFromTestTypeList("Prohibition clearance");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("Prohibition clearance");
        testTypeCategorySteps.selectFromTestTypeList("Any PSV");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("Any PSV");
        testTypeCategorySteps.selectFromTestTypeList("PG9 retest");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("PG9 retest");
        testTypeCategorySteps.selectFromTestTypeList("Paid");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("Paid");
        testTypeCategorySteps.selectFromTestTypeList("With certification");
        testSteps.waitUntilPageIsLoaded();
        testSteps.selectTestType("Prohibition clearance", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.checkSetCarriedOutDuringTestOption("No");
        testTypeDetailsSteps.setCarriedOutDuringTest(false);
        testTypeDetailsSteps.checkSetCarriedOutDuringTestOption("No");
    }
}
