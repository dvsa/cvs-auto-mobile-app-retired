package sitevisit.CVSB_169;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.IdentifyVehicleSteps;
import steps.SiteVisitSteps;
import steps.composed.SiteVisitComp;
import util.BaseTestClass;

@RunWith(SerenityRunner.class)
public class SiteVisitTimeline_2061 extends BaseTestClass {

    @Steps
    SiteVisitComp siteVisitComp;

    @Steps
    SiteVisitSteps siteVisitSteps;

    @Steps
    IdentifyVehicleSteps identifyVehicleSteps;

    @Title("CVSB-169 - AC4 - VSA creates a test for a new vehicle from the site visit timeline")
    @Test
    public void testSiteVisitTimelineForNewVehicle() {
        siteVisitComp.goToSiteVisit();
        siteVisitSteps.checkSiteVisitPage();
        siteVisitSteps.createNewTest();
        identifyVehicleSteps.checkIdentitfyVehicleTitleIsDisplayed();
        identifyVehicleSteps.typeInSearchField(vehicleService.getVehicle().getVim());
        identifyVehicleSteps.checkSearchBoxAndText(vehicleService.getVehicle().getVim());

    }
}
