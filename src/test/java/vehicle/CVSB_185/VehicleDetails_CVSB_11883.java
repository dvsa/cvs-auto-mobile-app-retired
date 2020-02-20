package vehicle.CVSB_185;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import pages.TestHistoryPage;
import steps.*;
import steps.composed.VehicleComp;
import util.BaseTestClass;

@RunWith(SerenityRunner.class)
public class VehicleDetails_CVSB_11883 extends BaseTestClass {

    @Steps
    VehicleComp vehicleComp;

    @Steps
    TestHistorySteps testHistorySteps;

    @Steps
    VehicleDetailsSteps vehicleDetailsSteps;

    @Steps
    AdditionalVehicleDetailsSteps additionalVehicleDetailsSteps;

    @Steps
    PreparerSteps preparerSteps;

    @Steps
    TestSteps testSteps;

    private void checkVehicleDetails_Car() {

        vehicleDetailsSteps.checkDetailPageNoNullData();
        vehicleDetailsSteps.checkIfInDetailPageByPlate("QW12 3RT");

        // CVSB-11883 - AC2 - Vehicle details screen (car)
        vehicleDetailsSteps.checkDetailPageData("P0123010911250", "", "", "", "","","","","","");
        vehicleDetailsSteps.checkFieldIsPresent("Year of manufacture");
        vehicleDetailsSteps.checkFieldIsPresent("Date of first registration");

        // CVSB-11884 - AC3 - Tech records fields
        vehicleDetailsSteps.verifySectionHeadingIsDisplayed("VEHICLE SUMMARY");
        vehicleDetailsSteps.verifySectionHeadingIsDisplayed("VIEW MORE INFORMATION");

        // CVSB-11885 - AC4 - Action fields navigate to the correct pages.
        // View "Vehicle Test History" screen / come back again.
        vehicleDetailsSteps.selectVehicleTestHistory();
        testHistorySteps.checkPage();
        testHistorySteps.pressBackButton();

        // View "Additional Vehicle Details" screen / come back again.
        vehicleDetailsSteps.selectAdditionalVehicleDetails();
        additionalVehicleDetailsSteps.checkNotesIsDisplayed();

        // CVSB-11886 - AC5 - Empty fields / variables.
        additionalVehicleDetailsSteps.checkNotesIsEmpty();
        additionalVehicleDetailsSteps.pressBackButton();
    }

    @Title("CVSB-11883 - AC2 - Vehicle details screen (car)")
    @Test
    public void testFieldsDisplayedInApp_Car() {

        vehicleComp.goToVehicleDetails("P0123010911250"); // Car QW123RT

        // Check all ACs against the Vehicle Details screen (in the "look up vehicle" context).
        checkVehicleDetails_Car();

        // CVSB-11887 - AC6 - Consult tech record
        // Confirm the vehicle, and view the vehicle details from the Test screen.
        vehicleDetailsSteps.selectConfirmButtonTopRight();
        vehicleDetailsSteps.selectConfirmFromPopUp();

        // Start a test, but skip the preparer.
        preparerSteps.startTest();
        preparerSteps.advanceWithoutPreaprer();
        preparerSteps.confirmInPopUp();
        testSteps.checkPageTitleDisplayed();

        // Navigate to the Vehicle Details screen.
        testSteps.checkCarTestDetails("QW123RT", "P0123010911250");
        testSteps.selectVehicleDetails();

        // Check all ACs against the Vehicle Details screen (in the "test-in-progress" context).
        checkVehicleDetails_Car();
    }

    private void checkVehicleDetails_LGV() {

        vehicleDetailsSteps.checkDetailPageNoNullData();
        vehicleDetailsSteps.checkIfInDetailPageByPlate("AS23 4TY");

        // CVSB-11883 - AC2 - Vehicle details screen (LGV)
        vehicleDetailsSteps.checkDetailPageData("P0123010951264", "", "", "", "", "", "", "", "", "");
        vehicleDetailsSteps.checkFieldIsPresent("Year of manufacture");
        vehicleDetailsSteps.checkFieldIsPresent("Date of first registration");
        // CVSB-11884 - AC3 - Tech records fields
        vehicleDetailsSteps.verifySectionHeadingIsDisplayed("VEHICLE SUMMARY");
        vehicleDetailsSteps.verifySectionHeadingIsDisplayed("VIEW MORE INFORMATION");

        // CVSB-11885 - AC4 - Action fields navigate to the correct pages.
        // View "Vehicle Test History" screen / come back again.
        vehicleDetailsSteps.selectVehicleTestHistory();
        testHistorySteps.checkPage();
        testHistorySteps.pressBackButton();

        // View "Additional Vehicle Details" screen / come back again.
        vehicleDetailsSteps.selectAdditionalVehicleDetails();
        additionalVehicleDetailsSteps.checkNotesIsDisplayed();

        // CVSB-11886 - AC5 - Empty fields / variables.
        additionalVehicleDetailsSteps.checkNotesIsEmpty();
        additionalVehicleDetailsSteps.pressBackButton();
    }


    @Title("CVSB-11883 - AC2 - Vehicle details screen (LGV)")
    @Test
    public void testFieldsDisplayedInApp_LGV() {

        vehicleComp.goToVehicleDetails("P0123010951264");

        // Check all ACs against the Vehicle Details screen (in the "look up vehicle" context).
        checkVehicleDetails_LGV();

        // CVSB-11887 - AC6 - Consult tech record
        // Confirm the vehicle, and view the vehicle details from the Test screen.
        vehicleDetailsSteps.selectConfirmButtonTopRight();
        vehicleDetailsSteps.selectConfirmFromPopUp();

        // Start a test, but skip the preparer.
        preparerSteps.startTest();
        preparerSteps.advanceWithoutPreaprer();
        preparerSteps.confirmInPopUp();
        testSteps.checkPageTitleDisplayed();

        // Navigate to the Vehicle Details screen.
        testSteps.checkLGVTestDetails("AS234TY", "P0123010951264");
        testSteps.selectVehicleDetails();

        // Check all ACs against the Vehicle Details screen (in the "test-in-progress" context).
        checkVehicleDetails_LGV();
    }

    private void checkVehicleDetails_Motorcycle() {

        vehicleDetailsSteps.checkDetailPageNoNullData();
        vehicleDetailsSteps.checkIfInDetailPageByPlate("ZX34 5CV");

        // CVSB-11883 - AC2 - Vehicle details screen (motorcycle)
        // Note: Following step may fail once date formats are changed.
        vehicleDetailsSteps.checkDetailPageData("P0123010956789", "", "", "", "","","","","","");
        vehicleDetailsSteps.checkFieldIsPresent("Year of manufacture");
        vehicleDetailsSteps.checkFieldIsPresent("Date of first registration");

        // CVSB-11884 - AC3 - Tech records fields
        vehicleDetailsSteps.verifySectionHeadingIsDisplayed("VEHICLE SUMMARY");
        vehicleDetailsSteps.verifySectionHeadingIsDisplayed("VIEW MORE INFORMATION");

        // CVSB-11885 - AC4 - Action fields navigate to the correct pages.
        // View "Vehicle Test History" screen / come back again.
        vehicleDetailsSteps.selectVehicleTestHistory();
        testHistorySteps.checkPage();
        testHistorySteps.pressBackButton();

        // View "Additional Vehicle Details" screen / come back again.
        vehicleDetailsSteps.selectAdditionalVehicleDetails();
        additionalVehicleDetailsSteps.checkNotesIsDisplayed();

        // CVSB-11886 - AC5 - Empty fields / variables.
        additionalVehicleDetailsSteps.checkNotesIsEmpty();
        additionalVehicleDetailsSteps.pressBackButton();
    }

    @Title("CVSB-11883 - AC2 - Vehicle details screen (motorcycle)")
    @Test
    public void testFieldsDisplayedInApp_Motorcycle() {

        vehicleComp.goToVehicleDetails("P0123010956789");

        // Check all ACs against the Vehicle Details screen (in the "look up vehicle" context).
        checkVehicleDetails_Motorcycle();

        // CVSB-11887 - AC6 - Consult tech record
        // Confirm the vehicle, and view the vehicle details from the Test screen.
        vehicleDetailsSteps.selectConfirmButtonTopRight();
        vehicleDetailsSteps.selectConfirmFromPopUp();

        // Start a test, but skip the preparer.
        preparerSteps.startTest();
        preparerSteps.advanceWithoutPreaprer();
        preparerSteps.confirmInPopUp();
        testSteps.checkPageTitleDisplayed();

        // Navigate to the Vehicle Details screen.
        testSteps.checkMotorcycleTestDetails("ZX345CV", "P0123010956789");
        testSteps.selectVehicleDetails();

        // Check all ACs against the Vehicle Details screen (in the "test-in-progress" context).
        checkVehicleDetails_Motorcycle();
    }
}

