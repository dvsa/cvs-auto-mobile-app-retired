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
import steps.composed.TestTypeCategoryComp;

@RunWith(SerenityRunner.class)
public class LinkedTestTypeTest {

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


    @Title("CVSB-437 / CVSB-773 - AC1 List of test types for the 'Add a linked test' option")
    @Test
    public void testListFromAddLinkedTestType() {
        testTypeCategoryComp.completeAddTestType();
        testSteps.checkAddALinkedTestButtonVisibility();
        testSteps.addLinkedTestType();
        testTypeCategorySteps.checkTestTypePage();
        testTypeCategorySteps.checkInTestTypeList("ANNUAL TEST", "Class 6A (Seatbelt Installation Check)", "RETEST");

    }


    // TODO create a modular step to go to specific test types from multiple subcategories
    @Title("CVSB-437 / CVSB-774 - Add a linked test")
    @Test
    public void testAddALinkedTestType() {
        testTypeCategoryComp.completeAddTestType();
        testSteps.addLinkedTestType();
        testTypeCategorySteps.checkInTestTypeList("ANNUAL TEST", "Class 6A (Seatbelt Installation Check)", "RETEST");
        testTypeCategorySteps.selectFromTestTypeList("RETEST");
        testTypeSubcategorySteps.seeInTestTypeList("PAID", "PART PAID");
        testTypeSubcategorySteps.selectFromTestTypeList("PAID");
        testTypeSubcategorySteps.seeInTestTypeList("Any PSV", "CLASS 6A (Seatbelt Installation Check)");
        testTypeSubcategorySteps.selectFromTestTypeList("Any PSV");
        testTypeSubcategorySteps.seeInTestTypeList("Public Service Vehicle Annual Testing");
        testTypeSubcategorySteps.selectFromTestTypeList("Public Service Vehicle Annual Testing");
        testSteps.checkSelectedTestTypes("Public Service Vehicle Annual Testing Not complete");

    }

}
