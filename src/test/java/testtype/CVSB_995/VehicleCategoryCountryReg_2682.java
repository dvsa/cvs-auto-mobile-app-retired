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
public class VehicleCategoryCountryReg_2682 extends BaseTestClass {

    @Steps
    TestSteps testSteps;

    @Steps
    TestTypeCategoryComp testTypeCategoryComp;

    @Steps
    EUVehicleCategorySteps euVehicleCategorySteps;

    @Title("CVSB-995 - AC8 - Editing 'EU Vehicle category' field")
    @Test
    public void editingVehicleCategory() {
        testTypeCategoryComp.goToTestPage(preparerService.getPreparerByIndex(0).getPreparerId(), preparerService.getPreparerByIndex(0).getPreparerName());
        testSteps.selectVehicleCategoryOption();
        euVehicleCategorySteps.selectM1Option();
        testSteps.checkIfCorrectOptionIsDisplayed("M1");
        testSteps.selectVehicleCategoryOption();
        euVehicleCategorySteps.selectM2Option();
        testSteps.checkIfCorrectOptionIsDisplayed("M2");
        testSteps.selectVehicleCategoryOption();
        euVehicleCategorySteps.selectM3Option();
        testSteps.checkIfCorrectOptionIsDisplayed("M3");
    }
}
