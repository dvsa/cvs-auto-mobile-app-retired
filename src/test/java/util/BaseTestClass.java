package util;

import data.util.AtfService;
import data.util.PreparerService;
import data.util.VehicleTechnicalRecordService;
import net.thucydides.core.annotations.ClearCookiesPolicy;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import steps.util.UtilSteps;
import util.backend.activity.ActivityService;

public class BaseTestClass {

    private static Logger logger = LoggerFactory.getLogger(BaseTestClass.class);
    protected AtfService atfService = new AtfService();
    protected PreparerService preparerService = new PreparerService();
    protected VehicleTechnicalRecordService vehicleService = new VehicleTechnicalRecordService();
    protected String username;
    protected String token;
    @Steps
    UtilSteps utilSteps;

    @Managed(uniqueSession = true, clearCookies = ClearCookiesPolicy.Never)
    public WebDriver webDriver;

    @Before
    public void initialise() {
        utilSteps.resetAndQuitDriver();
        logger.info("closing user's activity");
        username = new FileLocking().getUsernameFromQueue();
        token = new WriterReader(username).getToken();
        new ActivityService.closeCurrentUserActivity(token);
    }

    @After
    public void returnUserToPool(){
        logger.info("returning user to the user pool");
        new FileLocking().putUsernameInQueue(username);
    }
}
