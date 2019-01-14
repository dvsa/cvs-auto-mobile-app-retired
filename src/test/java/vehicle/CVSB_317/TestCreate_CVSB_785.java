package vehicle.CVSB_317;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.IdentifyVehicleSteps;
import steps.SiteVisitSteps;
import steps.composed.VehicleComp;
import util.BaseTestClass;

@RunWith(SerenityRunner.class)
public class TestCreate_CVSB_785 extends BaseTestClass {
    @Steps
    VehicleComp vehicleComp;

    @Steps
    SiteVisitSteps siteVisitSteps;

    @Steps
    IdentifyVehicleSteps identifyVehicleSteps;

    @Title("CVSB-317 - AC2 - Go back to site visit overview")
    @Test()
    public void testGoBackToSiteVisit() {
        vehicleComp.goToSiteVisit();
        siteVisitSteps.createNewTest();
        identifyVehicleSteps.clickCancel();
        siteVisitSteps.waitUntilPageIsLoaded();

    }
}
