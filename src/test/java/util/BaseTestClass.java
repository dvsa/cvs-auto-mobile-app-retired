package util;

import data.util.AtfService;
import data.util.PreparerService;
import data.util.VehicleTechnicalRecordService;

import net.thucydides.core.annotations.ClearCookiesPolicy;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.webdriver.WebDriverFacade;
import org.junit.After;
import org.junit.Before;

import org.junit.Rule;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import java.io.PrintWriter;
import java.io.StringWriter;

import static net.serenitybdd.core.Serenity.getDriver;


public class BaseTestClass {

    public static final Logger logger = LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);

    protected AtfService atfService = new AtfService();
    protected PreparerService preparerService = new PreparerService();
    protected VehicleTechnicalRecordService vehicleService = new VehicleTechnicalRecordService();
    protected TokenGenerator tokenGenerator = new TokenGenerator();
    protected SessionDetails sessionDetails = new SessionDetails();
    protected UpdateBsTestStatus updateBsTestStatus = new UpdateBsTestStatus();

    protected String username;
    protected String token;


    @Managed(uniqueSession = true, clearCookies = ClearCookiesPolicy.BeforeEachTest)
    public WebDriver webDriver;


    @Rule
    public final TestRule watchman = new TestWatcher() {
        @Override
        public Statement apply(Statement base, Description description) {
            return super.apply(base, description);
        }

        @Override
        protected void failed(Throwable e, Description description) {

            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            sessionDetails.setStatus("failed");
            sessionDetails.setReason(e.getCause() == null ? "Unknown" : sw.toString() );
            updateBsTestStatus.updateStatus(sessionDetails);
        }

        @Override
        protected void succeeded(Description description) {
            sessionDetails.setStatus("passed");
            sessionDetails.setReason("no issues found");
            updateBsTestStatus.updateStatus(sessionDetails);
        }

        @Override
        protected void starting(Description description) {
            username = new FileLocking().getUsernameFromQueue();
            logger.info("creating BS session");

            WebDriverFacade driverFacade = (WebDriverFacade)getDriver();
            RemoteWebDriver driver = (RemoteWebDriver)driverFacade.getProxiedDriver();
            sessionDetails.setSession(driver.getSessionId().toString());
            sessionDetails.setName(description.getMethodName());
            MDC.put("id", sessionDetails.getSession());

            logger.info("closing user's activity");
            token = tokenGenerator.getToken(username);
            new ActivityService().closeCurrentUserActivity(token);

            super.starting(description);
        }

        @Override
        protected void finished(Description description) {
            logger.info("finished");
            webDriver.quit();
            logger.info("returning user to the user pool");
            new ActivityService().closeCurrentUserActivity(token);
            new FileLocking().putUsernameInQueue(username);
            super.finished(description);
        }
    };
}
