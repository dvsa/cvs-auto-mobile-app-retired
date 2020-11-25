package defect.CVSB_3228;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import pages.TestPage;
import steps.*;
import steps.composed.TestTypeCategoryComp;
import steps.util.UtilSteps;
import util.BaseTestClass;

@RunWith(SerenityRunner.class)
public class AddsDangerousDefect_CVSB_4436 extends BaseTestClass{

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
    TestTypeCategorySteps testTypeCategorySteps;

    @Steps
    TestTypeSubcategorySteps testTypeSubcategorySteps;

    @Title("[Iteration] CVSB-3228 - AC1 - VSA adds a dangerous defect (Retest)")
    @Test
    public void addsADangerousDefect() {
        testTypeCategoryComp.goToTestPage(preparerService.getPreparerByIndex(0).getPreparerId(),preparerService.getPreparerByIndex(0).getPreparerName(),super.username);
        testSteps.addTestType();
        testTypeCategorySteps.waitUntilPageIsLoaded();
        testTypeCategorySteps.selectFromTestTypeList("Retest");
        testTypeSubcategorySteps.selectFromTestTypeList("Paid retest");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("Paid retest");
        testTypeSubcategorySteps.selectFromTestTypeList("Any PSV retest");
        testSteps.waitUntilPageIsLoaded();
        testSteps.selectTestType("Retest", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.clickAddDefect();
        defectCategorySteps.searchForDefect("59");
        defectCategorySteps.selectDefectFromList("59. Brake Systems and Components");
        defectItemSteps.selectDefectFromList("2. Brake pipes and flexible hoses");
        defectDescriptionSteps.selectDefect("59.2 (b) (iii) DANGEROUS");
        defectDetailsSteps.checkPRSOptionIsNotDisplayed();
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
    }
}
