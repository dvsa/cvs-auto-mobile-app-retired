package sitevisit.CVSB_169;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.SiteVisitSteps;
import steps.composed.SiteVisitComp;
import util.BaseTestClass;

@RunWith(SerenityRunner.class)
public class SiteVisitTimeline_2057 extends BaseTestClass {

    @Steps
    SiteVisitComp siteVisitComp;

    @Steps
    SiteVisitSteps siteVisitSteps;

    @Title("CVSB-169 - AC1 - Site Visit timeline details")
    @Test
    public void testSiteVisitTimelineDetails() {
        siteVisitComp.goToSiteVisit();
        siteVisitSteps.checkSiteVisitPage();
        siteVisitSteps.checkATFRow(atfService.getAtfByIndex(0).getAtfName());
        siteVisitSteps.checkDate();
        siteVisitSteps.checkTime();
    }
}