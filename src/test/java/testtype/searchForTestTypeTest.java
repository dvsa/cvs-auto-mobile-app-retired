package testtype;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import steps.TestSteps;
import steps.TestTypeCategorySteps;
import steps.TestTypeSubcategorySteps;
import steps.composed.PreparerComp;
import steps.composed.TestTypeCategoryComp;
import steps.composed.TestTypeSubategoryComp;

@RunWith(SerenityRunner.class)
public class searchForTestTypeTest {

    @Steps
    PreparerComp preparerComp;

    @Steps
    TestTypeSubategoryComp testTypeSubategoryComp;

    @Steps
    TestSteps testSteps;

    @Steps
    TestTypeCategorySteps testTypeCategorySteps;

    @Steps
    TestTypeSubcategorySteps testTypeSubcategorySteps;

    @Steps
    TestTypeCategoryComp testTypeCategoryComp;

    @Managed
    public WebDriver webDriver;


    @Title("CVSB-178 / CVSB-711 - AC1 Test test type drilldown")
    @Test
    public void testTestTypeDrillDown() {
        testTypeCategoryComp.goToTestPage();
        testSteps.seeAddATestType();
        testSteps.addTestType();
        testTypeCategorySteps.seeInTestTypeList("ANNUAL TEST", "Class 6A (Seatbelt Installation Check)", "RETEST");
        testTypeCategorySteps.seeTestTypePage();

    }

    @Title("CVSB-178 / CVSB-818 - AC1/AC2 - Select a test type category that contains other test type categories")
    @Test
    public void testTestTypeCategoryContainingOtherCategories() {
        testTypeCategoryComp.goToInitialTestTypeCategoryList();
        testTypeCategorySteps.seeTestTypePage();
        testTypeCategorySteps.seeInTestTypeList("ANNUAL TEST", "Class 6A (Seatbelt Installation Check)", "RETEST");
        testTypeCategorySteps.selectFromTestTypeList("Class 6A (Seatbelt Installation Check)");
        testTypeSubcategorySteps.seeInTestTypeList("ANNUAL");

    }


    // TODO finish after bug is fixed
    @Title("CVSB-178 / CVSB-819 - Return back to the Test overview screen")
    @Test
    public void testReturnToTestOverviewScreen() {
        testTypeSubategoryComp.goToTestTypeSubcategoryFromCategory("Class 6A (Seatbelt Installation Check)");
        testTypeSubcategorySteps.goBackToCategory();


    }

    // TODO revise after bugfix
    @Title("CVSB-178 / CVSB-820 - Add test type from the latest level of test type drilldown")
    @Test
    public void testAddTestTypeFromLatestLevel() {
        testTypeSubategoryComp.goToTestTypeSubcategoryFromCategory("Class 6A (Seatbelt Installation Check)");
        testTypeSubcategorySteps.selectFromTestTypeList("ANNUAL");
        testTypeSubcategorySteps.seeInTestTypeList("Public Service Vehicle Annual Testing");
        testTypeSubcategorySteps.selectFromTestTypeList("Public Service Vehicle Annual Testing");
        testSteps.checkTestDetails();
        testSteps.checkSelectedTestTypes("Public Service Vehicle Annual Testing Not complete");

    }

    @Title("CVSB-178 / CVSB-821 - Select a test type category that does not contain other test type categories")
    @Test
    public void testSelectTestTypeCategoryWithNoSubcategories() {
        testTypeCategoryComp.goToInitialTestTypeCategoryList();
        testTypeCategorySteps.selectFromTestTypeList("ANNUAL TEST");
        testTypeSubcategorySteps.selectFromTestTypeList("Public Service Vehicle Annual Testing");
        testSteps.checkTestDetails();
        testSteps.checkSelectedTestTypes("Public Service Vehicle Annual Testing Not complete");

    }


}
