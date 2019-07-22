package testtype.CVSB_3904;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import pages.BasePage;
import pages.TestPage;
import steps.*;
import steps.composed.TestTypeCategoryComp;
import util.BaseTestClass;

@RunWith(SerenityRunner.class)
public class HgvTrlTestTypes_6175 extends BaseTestClass {

    BasePage basePage;

    @Steps
    TestTypeCategoryComp testTypeCategoryComp;

    @Steps
    PreparerSteps preparerSteps;

    @Steps
    TestPage testPage;

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
        testPage.addTestType();
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
        testPage.addTestType();
        testTypeCategorySteps.checkTestTypeListOnlyContainsTestTypes(availableTestTypes);
        testTypeCategorySteps.checkTestTypesInListAreSelectable(availableTestTypes);
    }

    @Title("CVSB-3904 - AC2 - Select a test type category that contains other test type categories (HGV Technical)")
    @Test
    public void testTypeDrillDownHgvTechnical() {

        String[] availableTestTypesSubcategory = {"TIR", "ADR", "Notifiable alteration"};

        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("957486");
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();
        testPage.addTestType();
        testTypeCategorySteps.selectFromTestTypeList("Technical test");
        testTypeSubcategorySteps.seeInTestTypeList(availableTestTypesSubcategory);
        testTypeSubcategorySteps.checkTestTypesInListAreSelectable(availableTestTypesSubcategory);
    }

    @Title("CVSB-3904 - AC2 - Select a test type category that contains other test type categories (TRL Technical)")
    @Test
    public void testTypeDrillDownTrlTechnical() {

        String[] availableTestTypesSubcategory = {"TIR", "ADR", "Notifiable alteration"};

        testTypeCategoryComp.goToTestPageBySelectingASpecificTrailer("341234");
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();
        testPage.addTestType();
        testTypeCategorySteps.selectFromTestTypeList("Technical test");
        testTypeSubcategorySteps.seeInTestTypeList(availableTestTypesSubcategory);
        testTypeSubcategorySteps.checkTestTypesInListAreSelectable(availableTestTypesSubcategory);

    }

    @Title("CVSB-3904 - AC2 - Select a test type category that contains other test type categories (HGV 2-5 axles Retest)")
    @Test
    public void testTypeDrillDownHgv2to5AxlesRetest() {

        String[] availableTestTypesSubcategory = {"Annual test", "TIR", "ADR", "Roadworthiness", "First test retest"};

        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("957486");
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();
        testPage.addTestType();
        testTypeCategorySteps.selectFromTestTypeList("Retest");
        testTypeSubcategorySteps.seeInTestTypeList(availableTestTypesSubcategory);
        testTypeSubcategorySteps.checkTestTypesInListAreSelectable(availableTestTypesSubcategory);

    }

    @Title("CVSB-3904 - AC2 - Select a test type category that contains other test type categories (HGV not between 2-5 axles Retest)")
    @Test
    public void testTypeDrillDownHgvNot2to5AxlesRetest() {

        String[] availableTestTypesSubcategory = {"ADR C&U", "ADR"};

        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("000000");
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();
        testPage.addTestType();
        testTypeCategorySteps.selectFromTestTypeList("Retest");
        testTypeSubcategorySteps.seeInTestTypeList(availableTestTypesSubcategory);
        testTypeSubcategorySteps.checkTestTypesInListAreSelectable(availableTestTypesSubcategory);

    }

    @Title("CVSB-6556 - AC2 - Select a test type category that contains other test type categories (TRL 1-5 axles Retest)")
    @Test
    public void testTypeDrillDownTrl1to5AxlesRetest() {

        String[] availableTestTypesSubcategory = {"Annual test", "TIR", "ADR", "Roadworthiness", "First test retest"};

        testTypeCategoryComp.goToTestPageBySelectingASpecificTrailer("341234");
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();
        testPage.addTestType();
        testTypeCategorySteps.selectFromTestTypeList("Retest");
        testTypeSubcategorySteps.seeInTestTypeList(availableTestTypesSubcategory);
        testTypeSubcategorySteps.checkTestTypesInListAreSelectable(availableTestTypesSubcategory);

    }

    @Title("CVSB-6556 - AC2 - Select a test type category that contains other test type categories (TRL greater than 5 axles Retest)")
    @Test
    public void testTypeDrillDownTrlGraterThan5AxlesRetest() {

        String[] availableTestTypesSubcategory = {"TIR", "ADR", "Roadworthiness"};

        testTypeCategoryComp.goToTestPageBySelectingASpecificTrailer("111111");
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();
        testPage.addTestType();
        testTypeCategorySteps.selectFromTestTypeList("Retest");
        testTypeSubcategorySteps.seeInTestTypeList(availableTestTypesSubcategory);
        testTypeSubcategorySteps.checkTestTypesInListAreSelectable(availableTestTypesSubcategory);

    }

    @Title("CVSB-3904 - AC2 - Select a test type category that contains other test type categories (HGV 2-5 axles Prohibition clearance)")
    @Test
    public void testTypeDrillDownHgv2to5AxlesProhibition() {

        String[] availableTestTypesSubcategory = {"Full inspection/ Fee", "Full inspection/ Part Fee - Without certification", "Part Inspection/ Fee - Without certification", "Retest", "Prohibition clearance on first test"};

        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("012938");
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();
        testPage.addTestType();
        testTypeCategorySteps.selectFromTestTypeList("Prohibition clearance");
        testTypeSubcategorySteps.seeInTestTypeList(availableTestTypesSubcategory);
        testTypeSubcategorySteps.checkTestTypesInListAreSelectable(availableTestTypesSubcategory);

    }

    @Title("CVSB-3904 - AC2 - Select a test type category that contains other test type categories (HGV not between 2-5 axles Prohibition clearance)")
    @Test
    public void testTypeDrillDownHgvNot2to5AxlesProhibition() {

        String[] availableTestTypes = {"Technical test", "Retest", "Voluntary test"};
        String[] notAvailableTestTypes = {"Prohibition clearance"};

        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("000000");
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();
        testPage.addTestType();
        testTypeCategorySteps.checkNotInTestTypeList(notAvailableTestTypes);
        testTypeCategorySteps.checkTestTypeListOnlyContainsTestTypes(availableTestTypes);
        testTypeSubcategorySteps.seeInTestTypeList(availableTestTypes);

    }

    @Title("CVSB-3904 - AC2 - Select a test type category that contains other test type categories (TRL 1-5 axles Prohibition Clearance)")
    @Test
    public void testTypeDrillDownTrl1to5AxlesProhibition() {

        String[] availableTestTypesSubcategory = {"Full inspection/ Fee", "Full inspection/ Part Fee - Without certification", "Part Inspection/ Fee - Without certification", "Retest", "Prohibition clearance on first test"};

        testTypeCategoryComp.goToTestPageBySelectingASpecificTrailer("341234");
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();
        testPage.addTestType();
        testTypeCategorySteps.selectFromTestTypeList("Prohibition clearance");
        testTypeSubcategorySteps.seeInTestTypeList(availableTestTypesSubcategory);
        testTypeSubcategorySteps.checkTestTypesInListAreSelectable(availableTestTypesSubcategory);

    }

    @Title("CVSB-3904 - AC2 - Select a test type category that contains other test type categories (TRL greater than 5 axles Prohibition Clearance)")
    @Test
    public void testTypeDrillDownTrlGreaterThan5AxlesProhibition() {

        String[] availableTestTypes = {"Technical test", "Retest", "Voluntary test"};
        String[] notAvailableTestTypes = {"Prohibition clearance"};

        testTypeCategoryComp.goToTestPageBySelectingASpecificTrailer("111111");
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();
        testPage.addTestType();
        testTypeCategorySteps.checkNotInTestTypeList(notAvailableTestTypes);
        testTypeCategorySteps.checkTestTypeListOnlyContainsTestTypes(availableTestTypes);
        testTypeSubcategorySteps.seeInTestTypeList(availableTestTypes);

    }

    @Title("CVSB-3904 - AC2 - Select a test type category that contains other test type categories (HGV 2-5 axles Voluntary)")
    @Test
    public void testTypeDrillDownHgv2to5AxlesVoluntary() {

        String[] availableTestTypesSubcategory = {"Brake test", "Multi - check", "Shaker plate check", "Speed limiter check", "Smoke test", "Headlamp aim test", "Roadworthiness test"};

        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("012938");
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();
        testPage.addTestType();
        testTypeCategorySteps.selectFromTestTypeList("Voluntary test");
        testTypeSubcategorySteps.seeInTestTypeList(availableTestTypesSubcategory);
        testTypeSubcategorySteps.checkTestTypesInListAreSelectable(availableTestTypesSubcategory);

    }

    @Title("CVSB-3904 - AC2 - Select a test type category that contains other test type categories (HGV not between 2-5 axles Voluntary)")
    @Test
    public void testTypeDrillDownHgvNot2to5AxlesVoluntary() {

        String[] availableTestTypesSubcategory = {"Multi - check", "Shaker plate check", "Speed limiter check", "Smoke test", "Headlamp aim test"};

        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("000000");
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();
        testPage.addTestType();
        testTypeCategorySteps.selectFromTestTypeList("Voluntary test");
        testTypeSubcategorySteps.seeInTestTypeList(availableTestTypesSubcategory);
        testTypeSubcategorySteps.checkTestTypesInListAreSelectable(availableTestTypesSubcategory);

    }

    @Title("CVSB-3904 - AC2 - Select a test type category that contains other test type categories (TRL 1-5 axles Voluntary)")
    @Test
    public void testTypeDrillDownTrl1to5AxlesVoluntary() {

        String[] availableTestTypesSubcategory = {"Brake test", "Shaker plate check", "Roadworthiness test"};

        testTypeCategoryComp.goToTestPageBySelectingASpecificTrailer("768594");
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();
        testPage.addTestType();
        testTypeCategorySteps.selectFromTestTypeList("Voluntary test");
        testTypeSubcategorySteps.seeInTestTypeList(availableTestTypesSubcategory);
        testTypeSubcategorySteps.checkTestTypesInListAreSelectable(availableTestTypesSubcategory);

    }


}
