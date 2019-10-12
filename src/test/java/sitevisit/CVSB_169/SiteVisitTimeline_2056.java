package sitevisit.CVSB_169;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.SiteVisitSteps;
import steps.composed.SiteVisitComp;
import util.BaseTestClass;

@RunWith(SerenityRunner.class)
public class SiteVisitTimeline_2056 extends BaseTestClass {

    @Steps
    SiteVisitComp siteVisitComp;

    @Steps
    SiteVisitSteps siteVisitSteps;

    @Title("CVSB-169 - AC1 - VSA is presented with the Site Visit timeline after completing an ATF site check")
    @Ignore("CVSB-8749 - maintenance for improving test suite speed")
    @Test
    public void testSiteVisitTimeline() {
        siteVisitComp.goToSiteVisit();
        siteVisitSteps.checkSiteVisitPage();
        siteVisitSteps.checkCreateTestButton();
        siteVisitSteps.checkEndVisitButton();

    }
}
