package testtype.CVSB_902;

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
public class LECTestType_2030 extends BaseTestClass {

    @Steps
    TestTypeCategoryComp testTypeCategoryComp;

    @Steps
    TestSteps testSteps;

    @Steps
    TestTypeCategorySteps testTypeCategorySteps;

    @Steps
    TestTypeDetailsSteps testTypeDetailsSteps;

    @Title("CVSB-902 - AC6 - Edit certificate number")
    @Test
    public void editCertificateNumber() {
        testTypeCategoryComp.addTestType();
        testTypeCategorySteps.selectFromTestTypeList("Technical test");
        testTypeCategorySteps.selectFromTestTypeList("LEC");
        testSteps.selectNotCompleteTest("Technical test");
        testTypeDetailsSteps.setTestToOption("Pass");
        testTypeDetailsSteps.checkCertificateSection(true);
        testTypeDetailsSteps.sendCertificateNumber("12345567");
        testTypeDetailsSteps.checkCertificateNumber("12345567");
        testTypeDetailsSteps.sendCertificateNumber("1234");
        testTypeDetailsSteps.checkCertificateNumber("1234");
    }
}
