package util;

import data.util.AtfService;
import data.util.PreparerService;
import data.util.VehicleTechnicalRecordService;
import net.thucydides.core.annotations.ClearCookiesPolicy;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.openqa.selenium.WebDriver;
import steps.util.UtilSteps;
import util.backend.activity.ActivityService;

import java.time.LocalDateTime;


public class BaseTestClass extends BaseUtils {

    private static LocalDateTime currentStartTimeTime = LocalDateTime.now();

    protected AtfService atfService = new AtfService();
    protected PreparerService preparerService = new PreparerService();
    protected VehicleTechnicalRecordService vehicleService = new VehicleTechnicalRecordService();
    private ActivityService activityService = new ActivityService();

    @Steps
    UtilSteps utilSteps;

    @Managed(uniqueSession = true, clearCookies = ClearCookiesPolicy.Never)
    public WebDriver webDriver;


    @Before
    public void closeActivity() {
        System.out.println("\nDEBUG: inside BaseTestClass @Before - closing user's activity");
        if (currentStartTimeTime.plusHours(1).plusMinutes(52).isBefore(LocalDateTime.now())) {
            utilSteps.resetAndQuitDriver();
            currentStartTimeTime = LocalDateTime.now();
        }
        activityService.closeCurrentUserActivity();
    }

    @After
    public void returnUserToPool(){
        System.out.println("\nDEBUG: Inside BaseTestClass @After - adding users back in the pool file");
        BaseUtils.addCurrentUserBackToUserPool();
    }

}
