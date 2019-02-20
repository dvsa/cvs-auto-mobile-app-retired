package testtype.CVSB_932;

import com.sun.xml.bind.v2.TODO;
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
public class SeatbeltInstallationCheck_2002 extends BaseTestClass {

    @Steps
    TestTypeCategoryComp testTypeCategoryComp;

    @Steps
    TestSteps testSteps;

    @Steps
    TestTypeDetailsSteps testTypeDetailsSteps;

    @Steps
    TestTypeCategorySteps testTypeCategorySteps;

    @Title("CVSB-932 - AC1 - The behaviour of the seatbelt installation check fields when conducting Category A test types")
    @Test
    //TODO Vary data so that the tests cover all the category A test types from the story after all of them are working properly
    public void testSeatBeltInstallationCheckCategoryATestTypes() {
        testTypeCategoryComp.addTestType();
        testTypeCategorySteps.selectFromTestTypeList("Retest");
        testTypeCategorySteps.selectFromTestTypeList("Paid");
        testTypeCategorySteps.selectFromTestTypeList("Any PSV");
        testSteps.selectNotCompleteTest("Retest");
        testTypeDetailsSteps.checkSetCarriedOutDuringTestOption("No");
    }
}
