package defect.CVSB_6211;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.core.annotations.WithTag;
import org.junit.Test;
import org.junit.runner.RunWith;
import pages.TestPage;
import steps.*;
import steps.composed.TestTypeCategoryComp;
import steps.util.UtilSteps;
import utils.BaseTestClass;

@RunWith(SerenityRunner.class)
public class ProhibitionClearance_CVSB_6184 extends BaseTestClass {

    @Steps
    UtilSteps utilSteps;

    @Steps
    TestTypeCategoryComp testTypeCategoryComp;

    @Steps
    TestTypeDetailsSteps testTypeDetailsSteps;

    @Steps
    TestSteps testSteps;

    @Steps
    DefectCategorySteps defectCategorySteps;

    @Steps
    DefectItemSteps defectItemSteps;

    @Steps
    DefectDescriptionSteps defectDescriptionSteps;

    @Steps
    DefectDetailsSteps defectDetailsSteps;

    @Steps
    TestTypeSubcategorySteps testTypeSubcategorySteps;

    @Steps
    TestTypeCategorySteps testTypeCategorySteps;

    @WithTag("In-test")
    @Title("CVSB-6184 - Bypass the prohibition raising for Prohibition Clearance tests")
    @Test
    public void testBypassProhibitionClearance() {
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        testTypeCategoryComp.goToTestPage(preparerService.getPreparerByIndex(0).getPreparerId(),preparerService.getPreparerByIndex(0).getPreparerName(),super.username);
        testSteps.addTestType();
        testTypeCategorySteps.waitUntilPageIsLoaded();
        testTypeCategorySteps.selectFromTestTypeList("Prohibition clearance");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("Prohibition clearance");
        testTypeSubcategorySteps.selectFromTestTypeList("Any PSV");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("Any PSV");
        testTypeSubcategorySteps.selectFromTestTypeList("PG9 retest");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("PG9 retest");
        testTypeSubcategorySteps.selectFromTestTypeList("Paid");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("Paid");
        testTypeSubcategorySteps.selectFromTestTypeList("With certification");
        testSteps.waitUntilPageIsLoaded();
        testSteps.selectTestType("Prohibition clearance", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.selectAddDefect("Paid prohibition clearance (retest with certificate)");
        defectCategorySteps.searchForDefect("59");
        defectCategorySteps.selectDefectFromList("59. Brake Systems and Components");
        defectItemSteps.selectDefectFromList("2. Brake pipes and flexible hoses");
        defectDescriptionSteps.selectDefect("59.2 (b) (iii) DANGEROUS");
        defectDetailsSteps.tapDone();
        testTypeDetailsSteps.checkDefectsArePresentForTest("Paid prohibition clearance (retest with certificate)",
                "59.2 (b) (iii) DANGEROUS", "2. Brake pipes and flexible hoses");

    }
}
