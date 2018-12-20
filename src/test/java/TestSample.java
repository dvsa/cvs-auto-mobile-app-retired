import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import steps.*;
import steps.composed.TestTypeCategoryComp;


@RunWith(SerenityRunner.class)
public class TestSample {


    @Steps
    LaunchSteps launchSteps;

    @Steps
    SearchForAnATFSteps searchForAnATFSteps;

    @Steps
    ATFDetailsSteps atfDetailsSteps;

    @Steps
    SiteVisitSteps siteVisitSteps;

    @Steps
    IdentifyVehicleSteps identifyVehicleSteps;

    @Steps
    VehicleDetailsSteps vehicleDetailsSteps;

    @Steps
    SelectPreparerSteps selectPreparerSteps;

    @Steps
    TestSteps testSteps;

    @Steps
    TestTypeCategoryComp testTypeCategoryComp;

    @Managed
    public WebDriver webDriver;


    @Test
    public void initialBigFlow() {
        launchSteps.clickGetStarted();
        searchForAnATFSteps.waitForPageToLoadAndSelectAnAtf("Abshire-Kub");
        atfDetailsSteps.startVisit();
        siteVisitSteps.createNewTest();
        identifyVehicleSteps.searchForVehicle("aa12bcd");
        vehicleDetailsSteps.selectConfirmButtonTopRight();
        selectPreparerSteps.selectPreparerAndConfirm("AK4434", "Durrell Vehicles Limited");
        testSteps.addTestType();
    }

    @Test
    public void addTestTypeSetupExample() {
        testTypeCategoryComp.goToInitialTestTypeCategoryList();
    }

}
