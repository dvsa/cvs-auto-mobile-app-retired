package testtype.CVSB_932;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import pages.TestPage;
import steps.*;
import steps.composed.TestTypeCategoryComp;
import steps.util.UtilSteps;
import utils.BaseTestClass;

@RunWith(SerenityRunner.class)
public class SeatbeltInstallationCheck_2007 extends BaseTestClass {

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
    SeatbeltInstallationCheckSteps seatbeltInstallationCheckSteps;

    @Steps
    TestTypeSubcategorySteps testTypeSubcategorySteps;

    @Title("CVSB-932 - AC - 3 Editing 'Number of seatbelts' fitted")
    @Test
    public void editingNumberOfSeatbeltsFitted() {
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
        testTypeDetailsSteps.selectNumberOfSeatbeltsFitted();
        seatbeltInstallationCheckSteps.checkDoneAndCancelOptionsForSeatbeltNumber();
        seatbeltInstallationCheckSteps.inputNumberOfSeatbelts("12345");
        testTypeDetailsSteps.waitUntilPageIsLoaded();
        testTypeDetailsSteps.checkNumberOfSeatbelts("123");
        testTypeDetailsSteps.selectNumberOfSeatbeltsFitted();
        seatbeltInstallationCheckSteps.inputNumberOfSeatbelts("qewqeqw");
        testTypeDetailsSteps.waitUntilPageIsLoaded();
        testTypeDetailsSteps.checkNumberOfSeatbelts("123");
        testTypeDetailsSteps.selectNumberOfSeatbeltsFitted();
        seatbeltInstallationCheckSteps.inputNumberOfSeatbelts("@#$32432");
        testTypeDetailsSteps.waitUntilPageIsLoaded();
        testTypeDetailsSteps.checkNumberOfSeatbelts("123");
    }
}
