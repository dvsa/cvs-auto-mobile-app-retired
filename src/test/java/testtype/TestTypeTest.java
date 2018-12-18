package testtype;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import steps.SelectPreparerSteps;
import steps.TestSteps;
import steps.TestTypeCategorySteps;
import steps.TestTypeSubcategorySteps;
import steps.composed.PreparerComp;
import steps.composed.TestTypeCategoryComp;

@RunWith(SerenityRunner.class)
public class TestTypeTest {

    @Steps
    PreparerComp preparerComp;

    @Steps
    SelectPreparerSteps selectPreparerSteps;

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


    @Title("CVSB-370 / CVSB-765 - AC1 'Add a test type' option")
    @Test
    public void testTestTypeOption() {
        preparerComp.goToSelectPreparer();
        selectPreparerSteps.selectPreparerAndConfirm("AK4434", "Durrell Vehicles Limited");
        testSteps.checkTestDetails();
        testSteps.seeAddATestType();

    }

    @Title("CVSB-370 / CVSB-766 - AC2 Test types list")
    @Test
    public void testTestTypeList() {
        testTypeCategoryComp.goToTestPage();
        testSteps.seeAddATestType();
        testSteps.addTestType();
        testTypeCategorySteps.seeInTestTypeList("ANNUAL TEST", "Class 6A (Seatbelt Installation Check)", "RETEST");
        testTypeCategorySteps.seeTestTypePage();

    }


    @Title("CVSB-370 / CVSB-768 - Add a test type from the test types list")
    @Test
    public void testAddTestTypeFromList() {
        testTypeCategoryComp.goToTestPage();
        testSteps.addTestType();
        testTypeCategorySteps.selectFromTestTypeList("ANNUAL TEST");
        testTypeSubcategorySteps.seeInTestTypeList("Public Service Vehicle Annual Testing");
        testTypeSubcategorySteps.selectFromTestTypeList("Public Service Vehicle Annual Testing");
        testSteps.checkTestDetails();
        testSteps.checkSelectedTestTypes("Public Service Vehicle Annual Testing Not complete");
    }


}
