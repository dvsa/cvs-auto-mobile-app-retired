package sitevisit.CVSB_169;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.core.annotations.WithTag;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.SiteVisitSteps;
import steps.composed.SiteVisitComp;
import steps.util.UtilSteps;
import util.BaseTestClass;

@Ignore
@RunWith(SerenityRunner.class)
public class SiteVisitTimeline_2057 extends BaseTestClass {

    @Steps
    UtilSteps utilSteps;

    @Steps
    SiteVisitComp siteVisitComp;

    @Steps
    SiteVisitSteps siteVisitSteps;

    @Title("CVSB-169 - AC1 - Site Visit timeline details")
    @Test
    public void testSiteVisitTimelineDetails() {
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        siteVisitComp.goToSiteVisit(super.username);
        siteVisitSteps.checkSiteVisitPage();
        siteVisitSteps.checkATFRow(atfService.getAtfByIndex(0).getAtfName(), atfService.getAtfByIndex(0).getAtfNumber());
        siteVisitSteps.checkDate();
        siteVisitSteps.checkTime();
    }
}
