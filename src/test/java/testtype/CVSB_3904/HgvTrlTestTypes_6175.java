package testtype.CVSB_3904;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.core.annotations.WithTag;
import org.junit.Test;
import org.junit.runner.RunWith;
import pages.TestPage;
import steps.*;
import steps.composed.TestTypeCategoryComp;
import util.BaseTestClass;

@RunWith(SerenityRunner.class)
public class HgvTrlTestTypes_6175 extends BaseTestClass {

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
        String[] availableTestTypes = {"Annual test", "First test", "Technical test", "Retest", "Prohibition clearance", "Voluntary test"};

        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("012938");
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();
        testSteps.addTestType();
        testTypeCategorySteps.checkTestTypeListOnlyContainsTestTypes(availableTestTypes);
        testTypeCategorySteps.checkTestTypesInListAreSelectable(availableTestTypes);
    }

    @Title("CVSB-3904 - AC1 - Test type drilldown (TRL 2 axles)")
    @Test
    public void testTypeDrillDownTrl2Axles() {
        String[] availableTestTypes = {"Annual test", "First test", "Technical test", "Retest", "Prohibition clearance", "Voluntary test"};

        testTypeCategoryComp.goToTestPageBySelectingASpecificTrailer("341234");
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();
        testSteps.addTestType();
        testTypeCategorySteps.checkTestTypeListOnlyContainsTestTypes(availableTestTypes);
        testTypeCategorySteps.checkTestTypesInListAreSelectable(availableTestTypes);
    }

    @Title("CVSB-3904 - AC2 - Select a test type category that contains other test type categories")
    @Test
    public void testTypeCategoryThatContainsOtherTestTypeCategories() {
        testTypeCategoryComp.goToTestPageBySelectingASpecificTrailer("111111");
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();
        testSteps.addTestType();
        testTypeCategorySteps.selectFromTestTypeList("Technical test");
        testTypeSubcategorySteps.selectFromTestTypeList("TIR");
        testSteps.checkTestTypeStatus("Technical test", TestPage.TestTypeStatuses.IN_PROGRESS);

    }


    @Title("CVSB-3904 - AC3 - Select a test type category that does not contain other test type categories")
    @Test
    public void testTypeCategoryThatDoesNotContainOtherTestTypeCategories() {

        testTypeCategoryComp.goToTestPageBySelectingASpecificTrailer("111111");
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();
        testSteps.addTestType();
        testTypeCategorySteps.selectFromTestTypeList("First test");
        testSteps.checkTestTypeStatus("First test", TestPage.TestTypeStatuses.EDIT);
    }

    @Title("CVSB-3904 - AC4 - Add a linked test ")
    @Test
//    @Ignore("Ignored until adding linked test for trailers issue will be fixed")
    public void testTypeDrillDownAddLinkedTest() {

        testTypeCategoryComp.goToTestPageBySelectingASpecificTrailer("341234");
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();
        testSteps.addTestType();
        testTypeCategorySteps.selectFromTestTypeList("Annual test");
        testTypeSubcategorySteps.selectFromTestTypeList("Annual test");
        testSteps.addLinkedTestType();
        testTypeCategorySteps.selectFromTestTypeList("Technical test");
        testTypeSubcategorySteps.selectFromTestTypeList("TIR");
        testSteps.checkTestTypeStatus("Annual test", TestPage.TestTypeStatuses.EDIT);
        testSteps.checkTestTypeStatus("Technical test", TestPage.TestTypeStatuses.EDIT);

    }

//    @Ignore("ignored until figure what to test")
    @Title("CVSB-3904 - TCD - AC5 - Display test types' short/ long name when appropriate (annual test)")
    @Test
    public void testTypeDrillDownShortLongAnnual() {

        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("957486");
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();
        testSteps.addTestType();
        testTypeCategorySteps.selectFromTestTypeList("Annual test");
        testSteps.checkTestTypeStatus("Annual test", TestPage.TestTypeStatuses.EDIT);
        testSteps.selectTestType("Annual test", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.checkTestTypeName("Annual test");
    }

    @Title("CVSB-3904 - AC5 - Display test types' short/ long name when appropriate (first test)")
    @Test
    public void testTypeDrillDownShortLongFirst() {

        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("957486");
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();
        testSteps.addTestType();
        testTypeCategorySteps.selectFromTestTypeList("First test");
        testSteps.checkTestTypeStatus("First test", TestPage.TestTypeStatuses.EDIT);
        testSteps.selectTestType("First test", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.checkTestTypeName("First test");
    }

    @Title("CVSB-3904 - AC5 - Display test types' short/ long name when appropriate (technical test)")
    @Test
    public void testTypeDrillDownShortLongTechnical() {

        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("957486");
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();
        testSteps.addTestType();
        testTypeCategorySteps.selectFromTestTypeList("Technical test");
        testTypeSubcategorySteps.selectFromTestTypeList("Notifiable alteration");
        testTypeSubcategorySteps.selectFromTestTypeList("Paid");
        testSteps.checkTestTypeStatus("Technical test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testSteps.selectTestType("Technical test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.checkTestTypeName("Paid notifiable alteration");
    }

    @WithTag("In_test")
    @Title("CVSB-3904 - AC5 - Display test types' short/ long name when appropriate (retest)")
    @Test
    public void testTypeDrillDownShortLongRetest() {

        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("957486");
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();
        testSteps.addTestType();
        testTypeCategorySteps.selectFromTestTypeList("Retest");
        testTypeSubcategorySteps.selectFromTestTypeList("ADR");
        testTypeSubcategorySteps.selectFromTestTypeList("Paid");
        testSteps.checkTestTypeStatus("Retest", TestPage.TestTypeStatuses.IN_PROGRESS);
        testSteps.selectTestType("Retest", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.checkTestTypeName("Paid ADR retest");
    }

    @Title("CVSB-3904 - AC5 - Display test types' short/ long name when appropriate (prohibition clearance)")
    @Test
    public void testTypeDrillDownShortLongProhibition() {

        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("957486");
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();
        testSteps.addTestType();
        testTypeCategorySteps.selectFromTestTypeList("Prohibition clearance");
        testTypeSubcategorySteps.selectFromTestTypeList("Full inspection/ Fee");
        testTypeSubcategorySteps.selectFromTestTypeList("With certification");
        testSteps.checkTestTypeStatus("Prohibition clearance", TestPage.TestTypeStatuses.EDIT);
        testSteps.selectTestType("Prohibition clearance", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.checkTestTypeName("Paid prohibition clearance (full inspection with certification)");
    }

    @Title("CVSB-3904 - AC5 - Display test types' short/ long name when appropriate (voluntary test)")
    @Test
    public void testTypeDrillDownShortLongVoluntary() {

        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("957486");
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();
        testSteps.addTestType();
        testTypeCategorySteps.selectFromTestTypeList("Voluntary test");
        testTypeSubcategorySteps.selectFromTestTypeList("Brake test");
        testSteps.checkTestTypeStatus("Voluntary test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testSteps.selectTestType("Voluntary test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.checkTestTypeName("Voluntary brake test");
    }

}
