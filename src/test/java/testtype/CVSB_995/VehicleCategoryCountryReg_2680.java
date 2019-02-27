package testtype.CVSB_995;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.EUVehicleCategorySteps;
import steps.TestSteps;
import steps.composed.TestTypeCategoryComp;
import util.BaseTestClass;

@RunWith(SerenityRunner.class)
public class VehicleCategoryCountryReg_2680 extends BaseTestClass {

    @Steps
    TestSteps testSteps;

    @Steps
    TestTypeCategoryComp testTypeCategoryComp;

    @Steps
    EUVehicleCategorySteps euVehicleCategorySteps;

    @Title("CVSB-995 - AC7 - Pressing save without selecting an option for vehicle category")
    @Test
    public void pressingSaveWithoutSelectingAnOption() {
        testTypeCategoryComp.goToTestPage();
        testSteps.selectVehicleCategoryOption();
        euVehicleCategorySteps.clickSaveOptionButton();
        testSteps.checkNoEUCategoryIsSelected();
    }
}