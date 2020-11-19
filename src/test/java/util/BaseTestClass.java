package util;

import data.util.AtfService;
import data.util.PreparerService;
import data.util.VehicleTechnicalRecordService;

import net.thucydides.core.annotations.ClearCookiesPolicy;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.webdriver.WebDriverFacade;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import static net.serenitybdd.core.Serenity.getDriver;

public class BaseTestClass {

    public static final String URL = "https://" + TypeLoader.getBsUsername() + ":" + TypeLoader.getBsPass() + "@" + TypeLoader.getBsHostname() + "/wd/hub";
    public static final Logger logger = LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);

    protected AtfService atfService = new AtfService();
    protected PreparerService preparerService = new PreparerService();
    protected VehicleTechnicalRecordService vehicleService = new VehicleTechnicalRecordService();
    protected TokenGenerator tokenGenerator = new TokenGenerator();
    protected SessionDetails sessionDetails = new SessionDetails();

    protected String username;
    protected String token;

    @Managed(uniqueSession = true, clearCookies = ClearCookiesPolicy.BeforeEachTest)
    public WebDriver webDriver;

    @Before
    public void initialise() throws Exception{

        WebDriverFacade driverFacade = (WebDriverFacade)getDriver();
        RemoteWebDriver driver = (RemoteWebDriver)driverFacade.getProxiedDriver();
        sessionDetails.setSession(driver.getSessionId().toString());
        sessionDetails.setName(super.getClass().getName());
        MDC.put("id", sessionDetails.getSession());

        logger.info("closing user's activity");
        username = new FileLocking().getUsernameFromQueue();
        token = tokenGenerator.getToken(username);
        new ActivityService().closeCurrentUserActivity(token);
    }

    @After
    public void returnUserToPool(){
        String status = "failed";
        sessionDetails.setStatus(status);

        if(status.equals("failed")){ sessionDetails.setReason("error"); }

        new UpdateBsTestStatus().updateStatus(sessionDetails);
        webDriver.quit();
        logger.info("returning user to the user pool");
        new ActivityService().closeCurrentUserActivity(token);
        new FileLocking().putUsernameInQueue(username);
    }
}
