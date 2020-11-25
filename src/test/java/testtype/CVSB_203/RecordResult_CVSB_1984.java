package testtype.CVSB_203;

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
import util.BaseTestClass;

@RunWith(SerenityRunner.class)
public class RecordResult_CVSB_1984 extends BaseTestClass {
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

    @Steps
    SeatbeltInstallationCheckSteps seatbeltInstallationCheckSteps;


    @Title("CVSB-203 - AC2 - Fields automatically populated - other test types / current test (seatbelt installation check)")
    @WithTag("Smoke_2")
    @Test
    public void testFieldsAutomaticPopulation() {
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
//        testTypeCategoryComp.goToTestType(preparerService.getPreparerByIndex(0).getPreparerId(), preparerService.getPreparerByIndex(0).getPreparerName(),super.username);        testTypeCategorySteps.selectFromTestTypeList("Class 6A");
        testTypeCategoryComp.goToTestPage(preparerService.getPreparerByIndex(0).getPreparerId(),preparerService.getPreparerByIndex(0).getPreparerName(),super.username);
        testSteps.addTestType();
        testTypeCategorySteps.waitUntilPageIsLoaded();
        testTypeCategorySteps.selectFromTestTypeList("Class 6A");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("Class 6A");
        testTypeSubcategorySteps.selectFromTestTypeList("Annual test");
        testSteps.checkTestTypeStatus("Class 6A", TestPage.TestTypeStatuses.IN_PROGRESS);
        testSteps.selectTestType("Class 6A", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.selectNumberOfSeatbeltsFitted();
        seatbeltInstallationCheckSteps.inputNumberOfSeatbelts("3");
        testTypeDetailsSteps.pressSave();
        testSteps.addLinkedTestType();
        testTypeCategorySteps.waitUntilPageIsLoaded();
        testTypeCategorySteps.selectFromTestTypeList("Technical test");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("Technical test");
        testTypeSubcategorySteps.selectFromTestTypeList("LEC");
//        testSteps.waitUntilPageIsLoaded();
        testSteps.checkTestTypeStatus("Technical test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testSteps.selectTestType("Technical test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.checkResultIsNotSet();
        testTypeDetailsSteps.pressSave();
    }
}
