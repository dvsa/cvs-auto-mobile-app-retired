package testtype.CVSB_902;
//CD -


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
public class LECTestType_2028 extends BaseTestClass {

    @Steps
    TestTypeCategoryComp testTypeCategoryComp;

    @Steps
    TestSteps testSteps;

    @Steps
    TestTypeCategorySteps testTypeCategorySteps;

    @Steps
    TestTypeDetailsSteps testTypeDetailsSteps;

    @Title("CVSB-902 - AC5 - Enter value for certificate number")
    @Test
    public void enterCertificateNumberValue() {
        testTypeCategoryComp.addTestType();
        testTypeCategorySteps.selectFromTestTypeList("Technical test");
        testTypeCategorySteps.selectFromTestTypeList("LEC");
        testSteps.selectNotCompleteTest("Technical test");
        testTypeDetailsSteps.setTestToOption("Pass");
        testTypeDetailsSteps.checkCertificateSection(true);
        testTypeDetailsSteps.sendCertificateNumber("12345567");
    }
}