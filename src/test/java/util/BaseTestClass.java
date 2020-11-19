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
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;


import java.net.URL;

import static net.serenitybdd.core.Serenity.getDriver;


public class BaseTestClass {

    public static final String URL = "https://" + TypeLoader.getBsUsername() + ":" + TypeLoader.getBsPass() + "@" + TypeLoader.getBsHostname() + "/wd/hub";
    public static final Logger logger = LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);

    protected AtfService atfService = new AtfService();
    protected PreparerService preparerService = new PreparerService();
    protected VehicleTechnicalRecordService vehicleService = new VehicleTechnicalRecordService();
    protected TokenGenerator tokenGenerator = new TokenGenerator();
    protected String username;
    protected String token;


    @Managed(uniqueSession = true, clearCookies = ClearCookiesPolicy.Never)
    public WebDriver webDriver;

    @Before
    public void initialise() throws Exception{

        DesiredCapabilities caps = loadCapabilities(super.getClass().getName());
        webDriver = new RemoteWebDriver(new URL(URL), caps);

        WebDriverFacade driverFacade = (WebDriverFacade)getDriver();
        RemoteWebDriver driver = (RemoteWebDriver)driverFacade.getProxiedDriver();
        String sessionId = driver.getSessionId().toString();
        MDC.put("id", sessionId);

        logger.info("closing user's activity");
        username = new FileLocking().getUsernameFromQueue();
        token = tokenGenerator.getToken(username);
        new ActivityService().closeCurrentUserActivity(token);
    }

    @After
    public void returnUserToPool(){
        webDriver.quit();
        logger.info("returning user to the user pool");
        new ActivityService().closeCurrentUserActivity(token);
        new FileLocking().putUsernameInQueue(username);
    }

    public DesiredCapabilities loadCapabilities(String testName) {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("os_version", TypeLoader.getBsOSVersion());
        caps.setCapability("device", TypeLoader.getBsDevice());
        caps.setCapability("name", testName);
        caps.setCapability("real_mobile", TypeLoader.getRealMobile());
        caps.setCapability("browserstack.local", TypeLoader.getBsLocal());
        caps.setCapability("browserstack.appium_version", TypeLoader.getBsAppiumVersion());
        caps.setCapability("browserstack.video", TypeLoader.getBsVideoEnabled());
        caps.setCapability("waitForQuiescence", TypeLoader.getWaitForQuiescence());
        caps.setCapability("browserstack.timezone", TypeLoader.getBsTimeZone());
        caps.setCapability("browserstack.idleTimeout", TypeLoader.getBsIdleTimeout());
        caps.setCapability("browserstack.networkLogs", TypeLoader.getBsNetworkLogsEnabled());
        caps.setCapability("app", TypeLoader.getBsAppId());
        caps.setCapability("automationName", TypeLoader.getAutomationName());
        caps.setCapability("project", TypeLoader.getBsProjectName());
        caps.setCapability("build", TypeLoader.getBsBuildName());

        return caps;
    }
}
