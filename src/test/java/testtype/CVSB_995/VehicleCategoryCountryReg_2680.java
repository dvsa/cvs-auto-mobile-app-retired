package testtype.CVSB_995;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import steps.EUVehicleCategorySteps;
import steps.TestSteps;
import steps.composed.TestTypeCategoryComp;
import steps.util.UtilSteps;
import utils.BaseTestClass;

@Ignore
@RunWith(SerenityRunner.class)
public class VehicleCategoryCountryReg_2680 extends BaseTestClass {

    @Steps
    UtilSteps utilSteps;

    @Steps
    TestSteps testSteps;

    @Steps
    TestTypeCategoryComp testTypeCategoryComp;

    @Steps
    EUVehicleCategorySteps euVehicleCategorySteps;

    @Ignore("CVSB-12952: VTA FE Maintenance - increasing suite efficiency")
    @Title("CVSB-995 - AC7 - Pressing save without selecting an option for vehicle category")
    public void pressingSaveWithoutSelectingAnOption() {
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        testTypeCategoryComp.goToTestPage(preparerService.getPreparerByIndex(0).getPreparerId(), preparerService.getPreparerByIndex(0).getPreparerName(),super.username);
        testSteps.selectVehicleCategoryOption();
        euVehicleCategorySteps.clickSaveOptionButton();
        testSteps.checkNoEUCategoryIsSelected();
    }
}
