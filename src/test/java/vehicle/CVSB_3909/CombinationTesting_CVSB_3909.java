package vehicle.CVSB_3909;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.*;
import steps.composed.TestTypeCategoryComp;
import utils.BaseTestClass;

@RunWith(SerenityRunner.class)
public class CombinationTesting_CVSB_3909 extends BaseTestClass {

    @Steps
    TestTypeCategoryComp testTypeCategoryComp;

    @Steps
    PreparerSteps preparerSteps;

    @Steps
    TestSteps testSteps;

    @Steps
    IdentifyTrailerSteps identifyTrailerSteps;

    @Steps
    TrailerDetailsSteps trailerDetailsSteps;

    @Title("CVSB-6930 - AC1 – Dynamic ‘Add trailer’ button, with previously added HGV")
    @Test
    public void testAddTrailerForHgv() {
        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("012938",super.username);
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();
        testSteps.checkHgvTestDetails("GH389BH", "P012301012938");
        testSteps.checkAddATrailerButtonVisibility();
        testSteps.clickAddATrailerButton();
        identifyTrailerSteps.searchForTrailer("768594");
        trailerDetailsSteps.selectConfirmButtonTopRight();
        trailerDetailsSteps.selectConfirmFromPopUp();
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();
        testSteps.checkHgvTestDetails("GH389BH", "P012301012938");
        testSteps.checkTrailerTestDetails("0285678", "T12768594");
    }

    @Title("CVSB-6935 - AC5 – Finishes additional vehicle confirmation (TRL)")
    @Test
    public void testTrailerCardWhenAddingToHgv() {
        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("012938",super.username);
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();
        testSteps.checkHgvTestDetails("GH389BH", "P012301012938");
        testSteps.checkPropertyIsDisplayedXTimes("Country of registration", 1);
        testSteps.checkPropertyIsDisplayedXTimes("EU vehicle category", 1);
        testSteps.checkPropertyIsDisplayedXTimes("Odometer reading", 1);
        testSteps.checkAddATrailerButtonVisibility();
        testSteps.clickAddATrailerButton();
        identifyTrailerSteps.searchForTrailer("768594");
        trailerDetailsSteps.selectConfirmButtonTopRight();
        trailerDetailsSteps.selectConfirmFromPopUp();
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();
        testSteps.checkHgvTestDetails("GH389BH", "P012301012938");
        testSteps.checkTrailerTestDetails("0285678", "T12768594");
        testSteps.checkPropertyIsDisplayedXTimes("Country of registration", 2);
        testSteps.checkPropertyIsDisplayedXTimes("EU vehicle category", 2);
        testSteps.checkPropertyIsDisplayedXTimes("Odometer reading", 1);
    }

    @Title("CVSB-6936 - AC5 – Finishes additional vehicle confirmation (vehicle card order)")
    @Test
    public void testCardOrder() {
        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("012938",super.username);
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();
        testSteps.checkHgvTestDetails("GH389BH", "P012301012938");
        testSteps.checkAddATrailerButtonVisibility();
        testSteps.clickAddATrailerButton();
        identifyTrailerSteps.searchForTrailer("768594");
        trailerDetailsSteps.selectConfirmButtonTopRight();
        trailerDetailsSteps.selectConfirmFromPopUp();
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();
        testSteps.checkHgvTestDetails("GH389BH", "P012301012938");
        testSteps.checkTrailerTestDetails("0285678", "T12768594");
        testSteps.checkVehicleCardIsDisplayedAfterVehicle("0285678","GH389BH");
    }

}
