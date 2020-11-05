package testtype.CVSB_995;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import steps.EUVehicleCategorySteps;
import steps.TestSteps;
import steps.composed.TestTypeCategoryComp;
import util.BaseTestClass;

@Ignore
@RunWith(SerenityRunner.class)
public class VehicleCategoryCountryReg_2678 extends BaseTestClass {

    @Steps
    TestSteps testSteps;

    @Steps
    TestTypeCategoryComp testTypeCategoryComp;

    @Steps
    EUVehicleCategorySteps euVehicleCategorySteps;

    @Title("CVSB-995 - AC6 - Saving EU vehicle category")
    // De-scoped due to: CVSB-12952: VTA FE Maintenance - increasing suite efficiency
    public void savingVehicleCategory() {
        testTypeCategoryComp.goToTestPage(preparerService.getPreparerByIndex(0).getPreparerId(), preparerService.getPreparerByIndex(0).getPreparerName(),super.username);
        testSteps.selectVehicleCategoryOption();
        euVehicleCategorySteps.checkTitleIsDisplayed();
        euVehicleCategorySteps.checkOptionsAreDisplayed();
        euVehicleCategorySteps.selectM2Option();
        testSteps.checkEUVehicleCategoryOptionIs("M2");
    }
}
