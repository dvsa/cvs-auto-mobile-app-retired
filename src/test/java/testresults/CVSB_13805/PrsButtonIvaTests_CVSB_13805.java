package testresults.CVSB_13805;

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
public class PrsButtonIvaTests_CVSB_13805 extends BaseTestClass {

    @Steps
    TestTypeCategoryComp testTypeCategoryComp;

    @Steps
    TestSteps testSteps;

    @Steps
    PreparerSteps preparerSteps;

    @Steps
    TestTypeCategorySteps testTypeCategorySteps;

    @Steps
    TestTypeDetailsSteps testTypeDetailsSteps;


    @Title("CVSB-13805 - PRS button not appearing for Voluntary IVA tests/retests for hgv")
    @Test
    public void testPrsButtonIvaTestsHgv() {

        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("230123");
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();

        // Add a test type.
        testSteps.addTestType();
        testTypeCategorySteps.selectFromTestTypeList("Specialist test");
        testTypeCategorySteps.selectFromTestTypeList("Voluntary IVA");
        testTypeCategorySteps.selectFromTestTypeList("Normal inspection");
        testSteps.selectTestType("Specialist test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.setTestToOption("PRS");
        testTypeDetailsSteps.pressTestTypeRemoveButton();
        testTypeDetailsSteps.pressRemoveTestTypeInPopUp();
        testSteps.waitUntilPageIsLoaded();
        testSteps.addTestType();
        testTypeCategorySteps.selectFromTestTypeList("Specialist test");
        testTypeCategorySteps.selectFromTestTypeList("Retest");
        testTypeCategorySteps.selectFromTestTypeList("Voluntary IVA");
        testTypeCategorySteps.selectFromTestTypeList("Normal inspection");
        testTypeCategorySteps.selectFromTestTypeList("Paid");
        testSteps.selectTestType("Specialist test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.setTestToOption("PRS");
    }

    @Title("CVSB-13805 - PRS button not appearing for Voluntary IVA tests/retests for trl")
    @Test
    public void testPrsButtonIvaTestsTrl() {

        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("111111");
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();

        // Add a test type.
        testSteps.addTestType();
        testTypeCategorySteps.selectFromTestTypeList("Specialist test");
        testTypeCategorySteps.selectFromTestTypeList("Voluntary IVA");
        testTypeCategorySteps.selectFromTestTypeList("Normal inspection");
        testSteps.selectTestType("Specialist test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.setTestToOption("PRS");
        testTypeDetailsSteps.pressTestTypeRemoveButton();
        testTypeDetailsSteps.pressRemoveTestTypeInPopUp();
        testSteps.waitUntilPageIsLoaded();
        testSteps.addTestType();
        testTypeCategorySteps.selectFromTestTypeList("Specialist test");
        testTypeCategorySteps.selectFromTestTypeList("Retest");
        testTypeCategorySteps.selectFromTestTypeList("Voluntary IVA");
        testTypeCategorySteps.selectFromTestTypeList("Normal inspection");
        testTypeCategorySteps.selectFromTestTypeList("Paid");
        testSteps.selectTestType("Specialist test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.setTestToOption("PRS");
    }
}
