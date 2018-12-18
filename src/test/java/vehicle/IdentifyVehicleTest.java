package vehicle;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import steps.IdentifyVehicleSteps;
import steps.SelectPreparerSteps;
import steps.SiteVisitSteps;
import steps.VehicleDetailsSteps;
import steps.composed.VehicleComp;

@RunWith(SerenityRunner.class)
public class IdentifyVehicleTest {
    @Steps
    VehicleComp vehicleComp;

    @Steps
    SiteVisitSteps siteVisitSteps;

    @Steps
    VehicleDetailsSteps vehicleDetailsSteps;

    @Steps
    IdentifyVehicleSteps identifyVehicleSteps;

    @Steps
    SelectPreparerSteps selectPreparerSteps;

    @Managed
    public WebDriver webDriver;

    @Title("CVSB-317 / CVSB-784 - AC1 - Create a test")
    @Test()
    public void createATest() {
        vehicleComp.goToSiteVisit();
        siteVisitSteps.createNewTest();
        identifyVehicleSteps.searchForVehicle("aa12bcd");
        vehicleDetailsSteps.selectConfirmButtonTopRight();
        vehicleDetailsSteps.selectConfirmFromPopUp();
        selectPreparerSteps.checkPageTitle();
    }


    @Title("CVSB-317 / CVSB-785 - AC2 - Go back to site visit overview")
    @Test()
    public void testGoBackToSiteVisit() {
        vehicleComp.goToSiteVisit();
        siteVisitSteps.createNewTest();
        identifyVehicleSteps.clickClose();
        siteVisitSteps.waitUntillPageIsLoaded();

    }

}
