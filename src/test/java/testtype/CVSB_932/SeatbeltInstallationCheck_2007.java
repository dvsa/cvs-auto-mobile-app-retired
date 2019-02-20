package testtype.CVSB_932;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.TestSteps;
import steps.TestTypeCategorySteps;
import steps.TestTypeDetailsSteps;
import steps.composed.TestTypeCategoryComp;
import util.BaseTestClass;

@RunWith(SerenityRunner.class)
public class SeatbeltInstallationCheck_2007 extends BaseTestClass {

    @Steps
    TestTypeCategoryComp testTypeCategoryComp;

    @Steps
    TestSteps testSteps;

    @Steps
    TestTypeDetailsSteps testTypeDetailsSteps;

    @Steps
    TestTypeCategorySteps testTypeCategorySteps;

    @Title("CVSB-932 - AC - 3 Editing 'Number of seatbelts' fitted")
    @Test
    public void editingNumberOfSeatbeltsFitted() {
        testTypeCategoryComp.addTestType();
        testTypeCategorySteps.selectFromTestTypeList("Prohibition clearance");
        testTypeCategorySteps.selectFromTestTypeList("Any PSV");
        testTypeCategorySteps.selectFromTestTypeList("PG9 retest");
        testTypeCategorySteps.selectFromTestTypeList("Paid");
        testTypeCategorySteps.selectFromTestTypeList("With certification");
        testSteps.selectNotCompleteTest("Prohibition clearance");
        testTypeDetailsSteps.checkDoneAndCancelOptionForSeatbeltNumber();
        testTypeDetailsSteps.inputNumberOfSeatbelt("12345");
        testTypeDetailsSteps.checkNumberOfSeatbelts("123");
        testTypeDetailsSteps.inputNumberOfSeatbelt("qewqeqw");
        testTypeDetailsSteps.checkNumberOfSeatbelts("123");
        testTypeDetailsSteps.inputNumberOfSeatbelt("@#$32432");
        testTypeDetailsSteps.checkNumberOfSeatbelts("123");
    }
}
