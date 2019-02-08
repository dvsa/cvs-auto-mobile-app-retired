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
public class CaptureTestInformation_CVSB_1560 extends BaseTestClass {

    @Steps
    VehicleComp vehicleComp;

    @Steps
    VehicleDetailsSteps vehicleDetailsSteps;

    @Steps
    TestHistorySteps testHistorySteps;

    @Steps
    TestHistoryDetailsSteps testHistoryDetailsSteps;


    @Title("CVSB-440 - AC5B - Fields displayed in the app (e.g Defect details) are contextually sensitive," +
            " based on the data received for each test type from the database")
    @Test
    public void testFieldsDisplayed() {
        vehicleComp.goToVehicleDetails();
        vehicleDetailsSteps.selectVehicleTestHistory();
        // TODO refactor after database population with correct data
        testHistorySteps.selectTestTypeRecord("string");
        testHistoryDetailsSteps.checkPageTitle();
        testHistoryDetailsSteps.checkDetails("DEFECTS", "", "REFERENCELOL",
                "ADVISORY", "PRS", "0. string", "(a M) oops it doesn't work", "Upper", "Nearside", "Rear",
                "Row 2", "Seat 1", "Axle 1", "string", "7 Kilometers", "Yes", "Not Entered", "14 Jan 2019",
                "Station Name", "12345", "George", "1", "NOTES", "String");
    }

}
