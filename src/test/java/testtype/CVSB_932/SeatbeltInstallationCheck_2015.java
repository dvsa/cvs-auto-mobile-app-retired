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
public class SeatbeltInstallationCheck_2015 extends BaseTestClass {

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

    @Title("CVSB-932 - AC5 - The behaviour of the seatbelt installation check fields when conducting Category B test types")
    @Test
    public void seatbeltInstallationCheckBehaviourWhenConductingCategoryBTestTypes() {
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        // Class 6A (Seatbelt Installation Check)-Annual
        testTypeCategoryComp.goToTestPage(preparerService.getPreparerByIndex(0).getPreparerId(),preparerService.getPreparerByIndex(0).getPreparerName(),super.username);
        testSteps.addTestType();
        testTypeCategorySteps.waitUntilPageIsLoaded();
        testTypeCategorySteps.selectFromTestTypeList("Class 6A");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("Class 6A");
        testTypeCategorySteps.selectFromTestTypeList("Annual test");
        testSteps.selectTestType("Class 6A", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.checkSetCarriedOutDuringTestIsNotDisplayed();
        testTypeDetailsSteps.selectNumberOfSeatbeltsFitted();
        seatbeltInstallationCheckSteps.pressCancel();
        testTypeDetailsSteps.checkMostRecentInstallationCheckIsNotDisplayed();
        testTypeDetailsSteps.pressTestTypeRemoveButton();
        testTypeDetailsSteps.pressRemoveTestTypeInPopUp();

        //Prohibition Clearance Class 6A (Seatbelt Installation Check) Full Inspection & Fee
        testSteps.addTestType();
        testTypeCategorySteps.waitUntilPageIsLoaded();
        testTypeCategorySteps.selectFromTestTypeList("Prohibition clearance");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("Prohibition clearance");
        testTypeCategorySteps.selectFromTestTypeList("Class 6A (seatbelt installation check)");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("Class 6A (seatbelt installation check)");
        testTypeCategorySteps.selectFromTestTypeList("Full inspection / full fee");
        testSteps.selectTestType("Prohibition clearance", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.checkSetCarriedOutDuringTestIsNotDisplayed();
        testTypeDetailsSteps.selectNumberOfSeatbeltsFitted();
        seatbeltInstallationCheckSteps.pressCancel();
        testTypeDetailsSteps.checkMostRecentInstallationCheckIsNotDisplayed();
        testTypeDetailsSteps.pressTestTypeRemoveButton();
        testTypeDetailsSteps.pressRemoveTestTypeInPopUp();

       // Prohibition Clearance Class 6A (No Seatbelt Installation Check) PG9 Retest
        testSteps.addTestType();
        testTypeCategorySteps.waitUntilPageIsLoaded();
        testTypeCategorySteps.selectFromTestTypeList("Prohibition clearance");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("Prohibition clearance");
        testTypeCategorySteps.selectFromTestTypeList("Class 6A (seatbelt installation check)");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("Class 6A (seatbelt installation check)");
        testTypeCategorySteps.selectFromTestTypeList("PG9 retest");
        testSteps.selectTestType("Prohibition clearance", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.checkSetCarriedOutDuringTestIsNotDisplayed();
        testTypeDetailsSteps.selectNumberOfSeatbeltsFitted();
        seatbeltInstallationCheckSteps.pressCancel();
        testTypeDetailsSteps.checkMostRecentInstallationCheckIsNotDisplayed();
        testTypeDetailsSteps.pressTestTypeRemoveButton();
        testTypeDetailsSteps.pressRemoveTestTypeInPopUp();

        //Retest Paid Class 6A (Seatbelt Installation Check)
        testSteps.addTestType();
        testTypeCategorySteps.waitUntilPageIsLoaded();
        testTypeCategorySteps.selectFromTestTypeList("Retest");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("Retest");
        testTypeCategorySteps.selectFromTestTypeList("Paid retest");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("Paid retest");
        testTypeCategorySteps.selectFromTestTypeList("Class 6A retest (seatbelt installation check)");
        testSteps.selectTestType("Retest", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.checkSetCarriedOutDuringTestIsNotDisplayed();
        testTypeDetailsSteps.selectNumberOfSeatbeltsFitted();
        seatbeltInstallationCheckSteps.pressCancel();
        testTypeDetailsSteps.checkMostRecentInstallationCheckIsNotDisplayed();
        testTypeDetailsSteps.pressTestTypeRemoveButton();
        testTypeDetailsSteps.pressRemoveTestTypeInPopUp();
    }
}
