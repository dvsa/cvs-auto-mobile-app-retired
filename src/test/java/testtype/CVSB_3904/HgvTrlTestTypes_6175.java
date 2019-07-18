package testtype.CVSB_3904;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
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
    TestPage testPage;

    @Steps
    TestTypeCategorySteps testTypeCategorySteps;

    @Steps
    TestTypeSubcategorySteps testTypeSubcategorySteps;

    @Title("CVSB-3904 - AC1 - Test type drilldown (HGV 3 axles)")
    @Test
    public void testTypeDrilldownHgv3Axles() {
        String[] availableTestTypes = {"Annual test", "First test", "Technical test", "Retest", "Prohibition clearance", "Voluntary test"};

        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("012938");
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();
        testPage.addTestType();
        testTypeCategorySteps.checkTestTypeListOnlyContainsTestTypes(availableTestTypes);
        testTypeCategorySteps.checkTestTypesInListAreSelectable(availableTestTypes);
    }

    @Title("CVSB-3904 - AC1 - Test type drilldown (TRL  axles)")
    @Test
    public void testTypeDrilldownTrl2Axles() {
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
    public void testTypeDrilldownHgvTechnical() {

        String[] availableTestTypesSubcategory = {"TIR", "ADR", "Notifiable alteration"};

        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("341234");
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();
        testPage.addTestType();
        testTypeCategorySteps.selectFromTestTypeList("Technical test");
        testTypeSubcategorySteps.seeInTestTypeList(availableTestTypesSubcategory);
        testTypeSubcategorySteps.checkTestTypesInListAreSelectable(availableTestTypesSubcategory);
    }


}
