package testtype.CVSB_3904;

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
public class HgvTrlTestTypes_6175 extends BaseTestClass {

    @Steps
    UtilSteps utilSteps;

    @Steps
    TestTypeCategoryComp testTypeCategoryComp;

    @Steps
    PreparerSteps preparerSteps;

    @Steps
    TestSteps testSteps;

    @Steps
    TestTypeDetailsSteps testTypeDetailsSteps;

    @Steps
    TestTypeCategorySteps testTypeCategorySteps;

    @Steps
    TestTypeSubcategorySteps testTypeSubcategorySteps;

    @Title("CVSB-3904 - AC1 - Test type drilldown (HGV 3 axles)")
    @Test
    public void testTypeDrillDownHgv3Axles() {
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        String[] availableTestTypes = {"Annual test", "First test", "Technical test", "Retest", "Prohibition clearance", "Voluntary test", "Specialist test"};

        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("012938",super.username);
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();
        testSteps.addTestType();
        testTypeCategorySteps.waitUntilPageIsLoaded();
        testTypeCategorySteps.checkTestTypeListOnlyContainsTestTypes(availableTestTypes);
        testTypeCategorySteps.checkTestTypesInListAreSelectable(availableTestTypes);
    }

    @Title("CVSB-3904 - AC1 - Test type drilldown (TRL 2 axles)")
    @Test
    public void testTypeDrillDownTrl2Axles() {
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        String[] availableTestTypes = {"Annual test", "First test", "Technical test", "Retest", "Prohibition clearance", "Voluntary test", "Specialist test"};

        testTypeCategoryComp.goToTestPageBySelectingASpecificTrailer("341234",super.username);
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();
        testSteps.addTestType();
        testTypeCategorySteps.waitUntilPageIsLoaded();
        testTypeCategorySteps.checkTestTypeListOnlyContainsTestTypes(availableTestTypes);
        testTypeCategorySteps.checkTestTypesInListAreSelectable(availableTestTypes);
    }

    @Title("CVSB-3904 - AC2 - Select a test type category that contains other test type categories")
    @Test
    public void testTypeCategoryThatContainsOtherTestTypeCategories() {
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        testTypeCategoryComp.goToTestPageBySelectingASpecificTrailer("111111",super.username);
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();
        testSteps.addTestType();
        testTypeCategorySteps.waitUntilPageIsLoaded();
        testTypeCategorySteps.selectFromTestTypeList("Technical test");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("Technical test");
        testTypeSubcategorySteps.selectFromTestTypeList("TIR");
        testSteps.waitUntilPageIsLoaded();
        testSteps.checkTestTypeStatus("Technical test", TestPage.TestTypeStatuses.IN_PROGRESS);
    }

    @Title("CVSB-3904 - AC3 - Select a test type category that does not contain other test type categories")
    @Test
    public void testTypeCategoryThatDoesNotContainOtherTestTypeCategories() {
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        testTypeCategoryComp.goToTestPageBySelectingASpecificTrailer("111111", super.username);
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();
        testSteps.addTestType();
        testTypeCategorySteps.waitUntilPageIsLoaded();
        testTypeCategorySteps.selectFromTestTypeList("First test");
        testSteps.waitUntilPageIsLoaded();
        testSteps.checkTestTypeStatus("First test", TestPage.TestTypeStatuses.EDIT);
    }

    @Title("CVSB-3904 - AC4 - Add a linked test ")
    // De-scoped due to: CVSB-12952: VTA FE Maintenance - increasing suite efficiency
    public void testTypeDrillDownAddLinkedTest() {
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        testTypeCategoryComp.goToTestPageBySelectingASpecificTrailer("341234",super.username);
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();
        testSteps.addTestType();
        testTypeCategorySteps.waitUntilPageIsLoaded();
        testTypeCategorySteps.selectFromTestTypeList("Annual test");
        testTypeSubcategorySteps.selectFromTestTypeList("Annual test");
        testSteps.addLinkedTestType();
        testTypeCategorySteps.selectFromTestTypeList("Technical test");
        testTypeSubcategorySteps.selectFromTestTypeList("TIR");
        testSteps.checkTestTypeStatus("Annual test", TestPage.TestTypeStatuses.EDIT);
        testSteps.checkTestTypeStatus("Technical test", TestPage.TestTypeStatuses.IN_PROGRESS);
    }

    @Title("CVSB-3904 - TCD - AC5 - Display test types' short/ long name when appropriate (annual test)")
    @Test
    public void testTypeDrillDownShortLongAnnual() {
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("957486", super.username);
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();
        testSteps.addTestType();
        testTypeCategorySteps.waitUntilPageIsLoaded();
        testTypeCategorySteps.selectFromTestTypeList("Annual test");
        testSteps.checkTestTypeStatus("Annual test", TestPage.TestTypeStatuses.EDIT);
        testSteps.selectTestType("Annual test", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.checkTestTypeName("Annual test");
    }

    @Title("CVSB-3904 - AC5 - Display test types' short/ long name when appropriate (first test)")
    @Test
    public void testTypeDrillDownShortLongFirst() {
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("957486", super.username);
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();
        testSteps.addTestType();
        testTypeCategorySteps.waitUntilPageIsLoaded();
        testTypeCategorySteps.selectFromTestTypeList("First test");
        testSteps.waitUntilPageIsLoaded();
        testSteps.checkTestTypeStatus("First test", TestPage.TestTypeStatuses.EDIT);
        testSteps.selectTestType("First test", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.checkTestTypeName("First test");
    }

    @Title("CVSB-3904 - AC5 - Display test types' short/ long name when appropriate (technical test)")
    @Test
    public void testTypeDrillDownShortLongTechnical() {
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("957486", super.username);
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();
        testSteps.addTestType();
        testTypeCategorySteps.waitUntilPageIsLoaded();
        testTypeCategorySteps.selectFromTestTypeList("Technical test");
        testTypeSubcategorySteps.selectFromTestTypeList("Notifiable alteration");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("Notifiable alteration");
        testTypeSubcategorySteps.selectFromTestTypeList("Paid");
        testSteps.waitUntilPageIsLoaded();
        testSteps.checkTestTypeStatus("Technical test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testSteps.selectTestType("Technical test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.checkTestTypeName("Paid notifiable alteration");
    }

    @Title("CVSB-3904 - AC5 - Display test types' short/ long name when appropriate (retest)")
    @Test
    public void testTypeDrillDownShortLongRetest() {
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("957486", super.username);
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();
        testSteps.addTestType();
        testTypeCategorySteps.waitUntilPageIsLoaded();
        testTypeCategorySteps.selectFromTestTypeList("Retest");
        testTypeSubcategorySteps.selectFromTestTypeList("ADR retest");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("ADR retest");
        testTypeSubcategorySteps.selectFromTestTypeList("Paid retest");
        testSteps.waitUntilPageIsLoaded();
        testSteps.checkTestTypeStatus("Retest", TestPage.TestTypeStatuses.IN_PROGRESS);
        testSteps.selectTestType("Retest", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.checkTestTypeName("Paid ADR retest");
    }

    @Title("CVSB-3904 - AC5 - Display test types' short/ long name when appropriate (prohibition clearance)")
    @Test
    public void testTypeDrillDownShortLongProhibition() {
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("957486", super.username);
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();
        testSteps.addTestType();
        testTypeCategorySteps.waitUntilPageIsLoaded();
        testTypeCategorySteps.selectFromTestTypeList("Prohibition clearance");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("Prohibition clearance");
        testTypeSubcategorySteps.selectFromTestTypeList("Full inspection/ Fee");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("Full inspection/ Fee");
        testTypeSubcategorySteps.selectFromTestTypeList("With certification");
        testSteps.waitUntilPageIsLoaded();
        testSteps.checkTestTypeStatus("Prohibition clearance", TestPage.TestTypeStatuses.EDIT);
        testSteps.selectTestType("Prohibition clearance", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.checkTestTypeName("Paid prohibition clearance (full inspection with certification)");
    }

    @Title("CVSB-3904 - AC5 - Display test types' short/ long name when appropriate (voluntary test)")
    @Test
    public void testTypeDrillDownShortLongVoluntary() {
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("957486", super.username);
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();
        testSteps.addTestType();
        testTypeCategorySteps.waitUntilPageIsLoaded();
        testTypeCategorySteps.selectFromTestTypeList("Voluntary test");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("Voluntary test");
        testTypeSubcategorySteps.selectFromTestTypeList("Brake test");
        testSteps.waitUntilPageIsLoaded();
        testSteps.checkTestTypeStatus("Voluntary test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testSteps.selectTestType("Voluntary test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.checkTestTypeName("Voluntary brake test");
    }
}
