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
public class SeatBeltInstallationCheck_2002 extends BaseTestClass {

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

    @Title("CVSB-932 - AC1 - The behaviour of the seatbelt installation check fields when conducting Category A test types")
    @Test
    public void testSeatBeltInstallationCheckCategoryATestTypes() {
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        testTypeCategoryComp.goToTestPage(preparerService.getPreparerByIndex(0).getPreparerId(),preparerService.getPreparerByIndex(0).getPreparerName(),super.username);
        testSteps.addTestType();
        testTypeCategorySteps.waitUntilPageIsLoaded();
        testTypeCategorySteps.selectFromTestTypeList("Retest");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("Retest");
        testTypeCategorySteps.selectFromTestTypeList("Paid retest");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("Paid retest");
        testTypeCategorySteps.selectFromTestTypeList("Any PSV retest");
        testSteps.selectTestType("Retest", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.checkSetCarriedOutDuringTestOption("No");
        testTypeDetailsSteps.checkMostRecentInstallationCheckButtonIsDisplayed();
        testTypeDetailsSteps.checkNumberOfSeatbeltsIsDisplayed();
        testTypeDetailsSteps.scrollTestTypeDetailsPage();
        testTypeDetailsSteps.pressTestTypeRemoveButton();
        testTypeDetailsSteps.pressRemoveTestTypeInPopUp();

        testSteps.waitUntilPageIsLoaded();
        testSteps.addTestType();
        testTypeCategorySteps.selectFromTestTypeList("Retest");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("Retest");
        testTypeCategorySteps.selectFromTestTypeList("Part paid retest");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("Part paid retest");
        testTypeCategorySteps.selectFromTestTypeList("Any PSV retest");
        testSteps.selectTestType("Retest", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.checkSetCarriedOutDuringTestOption("No");
        testTypeDetailsSteps.checkMostRecentInstallationCheckButtonIsDisplayed();
        testTypeDetailsSteps.checkNumberOfSeatbeltsIsDisplayed();
        testTypeDetailsSteps.scrollTestTypeDetailsPage();
        testTypeDetailsSteps.pressTestTypeRemoveButton();
        testTypeDetailsSteps.pressRemoveTestTypeInPopUp();

        testSteps.waitUntilPageIsLoaded();
        testSteps.addTestType();
        testTypeCategorySteps.selectFromTestTypeList("Prohibition clearance");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("Prohibition clearance");
        testTypeSubcategorySteps.selectFromTestTypeList("Any PSV");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("Any PSV");
        testTypeSubcategorySteps.selectFromTestTypeList("Full inspection/ full fee");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("Full inspection/ full fee");
        testTypeSubcategorySteps.selectFromTestTypeList(("With certification"));
        testSteps.selectTestType("Prohibition clearance", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.checkSetCarriedOutDuringTestOption("No");
        testTypeDetailsSteps.checkMostRecentInstallationCheckButtonIsDisplayed();
        testTypeDetailsSteps.checkNumberOfSeatbeltsIsDisplayed();
        testTypeDetailsSteps.scrollTestTypeDetailsPage();
        testTypeDetailsSteps.pressTestTypeRemoveButton();
        testTypeDetailsSteps.pressRemoveTestTypeInPopUp();

        testSteps.waitUntilPageIsLoaded();
        testSteps.addTestType();
        testTypeCategorySteps.selectFromTestTypeList("Prohibition clearance");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("Prohibition clearance");
        testTypeSubcategorySteps.selectFromTestTypeList("Any PSV");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("Any PSV");
        testTypeSubcategorySteps.selectFromTestTypeList("Full inspection/ part fee");
        testSteps.waitUntilPageIsLoaded();
        testSteps.selectTestType("Prohibition clearance", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.checkSetCarriedOutDuringTestOption("No");
        testTypeDetailsSteps.checkMostRecentInstallationCheckButtonIsDisplayed();
        testTypeDetailsSteps.checkNumberOfSeatbeltsIsDisplayed();
        testTypeDetailsSteps.scrollTestTypeDetailsPage();
        testTypeDetailsSteps.pressTestTypeRemoveButton();
        testTypeDetailsSteps.pressRemoveTestTypeInPopUp();

        testSteps.waitUntilPageIsLoaded();
        testSteps.addTestType();
        testTypeCategorySteps.selectFromTestTypeList("Prohibition clearance");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("Prohibition clearance");
        testTypeSubcategorySteps.selectFromTestTypeList("Any PSV");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("Any PSV");
        testTypeSubcategorySteps.selectFromTestTypeList("Part inspection/ part fee");
        testSteps.waitUntilPageIsLoaded();
        testSteps.selectTestType("Prohibition clearance", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.checkSetCarriedOutDuringTestOption("No");
        testTypeDetailsSteps.checkMostRecentInstallationCheckButtonIsDisplayed();
        testTypeDetailsSteps.checkNumberOfSeatbeltsIsDisplayed();
        testTypeDetailsSteps.scrollTestTypeDetailsPage();
        testTypeDetailsSteps.pressTestTypeRemoveButton();
        testTypeDetailsSteps.pressRemoveTestTypeInPopUp();


        testSteps.waitUntilPageIsLoaded();
        testSteps.addTestType();
        testTypeCategorySteps.selectFromTestTypeList("Prohibition clearance");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("Prohibition clearance");
        testTypeSubcategorySteps.selectFromTestTypeList("Any PSV");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("Any PSV");
        testTypeSubcategorySteps.selectFromTestTypeList("PG9 retest");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("PG9 retest");
        testTypeSubcategorySteps.selectFromTestTypeList("Paid");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("Paid");
        testTypeSubcategorySteps.selectFromTestTypeList("With certification");
        testSteps.selectTestType("Prohibition clearance", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.checkSetCarriedOutDuringTestOption("No");
        testTypeDetailsSteps.checkMostRecentInstallationCheckButtonIsDisplayed();
        testTypeDetailsSteps.checkNumberOfSeatbeltsIsDisplayed();
        testTypeDetailsSteps.scrollTestTypeDetailsPage();
        testTypeDetailsSteps.pressTestTypeRemoveButton();
        testTypeDetailsSteps.pressRemoveTestTypeInPopUp();

        testSteps.waitUntilPageIsLoaded();
        testSteps.addTestType();
        testTypeCategorySteps.selectFromTestTypeList("Prohibition clearance");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("Prohibition clearance");
        testTypeSubcategorySteps.selectFromTestTypeList("Any PSV");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("Any PSV");
        testTypeSubcategorySteps.selectFromTestTypeList("PG9 retest");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("PG9 retest");
        testTypeCategorySteps.selectFromTestTypeList("Part paid");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("Part paid");
        testTypeCategorySteps.selectFromTestTypeList("With certification");
        testSteps.selectTestType("Prohibition clearance", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.checkSetCarriedOutDuringTestOption("No");
        testTypeDetailsSteps.checkMostRecentInstallationCheckButtonIsDisplayed();
        testTypeDetailsSteps.checkNumberOfSeatbeltsIsDisplayed();
        testTypeDetailsSteps.scrollTestTypeDetailsPage();
        testTypeDetailsSteps.pressTestTypeRemoveButton();
        testTypeDetailsSteps.pressRemoveTestTypeInPopUp();
    }
}
