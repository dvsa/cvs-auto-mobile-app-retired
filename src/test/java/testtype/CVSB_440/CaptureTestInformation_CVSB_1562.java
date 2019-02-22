package testtype.CVSB_440;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.TestHistoryDetailsSteps;
import steps.TestHistorySteps;
import steps.VehicleDetailsSteps;
import steps.composed.VehicleComp;
import util.BaseTestClass;

@RunWith(SerenityRunner.class)
public class CaptureTestInformation_CVSB_1562 extends BaseTestClass {

    @Steps
    VehicleComp vehicleComp;

    @Steps
    VehicleDetailsSteps vehicleDetailsSteps;

    @Steps
    TestHistorySteps testHistorySteps;

    @Steps
    TestHistoryDetailsSteps testHistoryDetailsSteps;


    @Title("CVSB-440 - AC7 -  Going back from a test type")
    @Test
    public void testGoBackFromTestTypeDetails() {
        vehicleComp.goToVehicleDetails();
        vehicleDetailsSteps.selectVehicleTestHistory();
        // TODO refactor after database population with correct data
        testHistorySteps.selectTestTypeRecord("Annual test");
        testHistoryDetailsSteps.pressBackButton();
        testHistorySteps.checkPage();
    }

}
