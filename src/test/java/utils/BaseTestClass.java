package utils;

import data.util.AtfService;
import data.util.PreparerService;
import data.util.VehicleTechnicalRecordService;

import net.thucydides.core.annotations.ClearCookiesPolicy;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.webdriver.WebDriverFacade;

import org.junit.Rule;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import util.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static net.serenitybdd.core.Serenity.getDriver;


public class BaseTestClass {

    public static final Logger logger = LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);

    protected AtfService atfService = new AtfService();
    protected PreparerService preparerService = new PreparerService();
    protected VehicleTechnicalRecordService vehicleService = new VehicleTechnicalRecordService();
    protected TokenGenerator tokenGenerator = new TokenGenerator();
    protected SessionDetails sessionDetails = new SessionDetails();
    protected BSUpdateTestStatus BSUpdateTestStatus = new BSUpdateTestStatus();
    protected BSCreateSessionUrl bsCreateSessionUrl = new BSCreateSessionUrl();

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
        protected void starting(Description description) {
            username = new FileLocking().getUsernameFromQueue();
            logger.info("creating BS session");

            WebDriverFacade driverFacade = (WebDriverFacade)getDriver();
            RemoteWebDriver driver = (RemoteWebDriver)driverFacade.getProxiedDriver();
            String session = driver.getSessionId().toString();
            MDC.put("id", session);

            bsCreateSessionUrl.createUrl(session);
            logger.info(bsCreateSessionUrl.getBsUrl());

            sessionDetails.setSession(session);
            sessionDetails.setName(description.getMethodName());
            sessionDetails.setBsSessionUrl(bsCreateSessionUrl.getBsUrl());

            token = tokenGenerator.getToken(username);
            new ActivityService().closeCurrentUserActivity(token,username);
            super.starting(description);
        }

        @Override
        protected void finished(Description description) {
            logger.info("quitting bs session");
            logger.info(bsCreateSessionUrl.getBsUrl());
            webDriver.quit();
            logger.info("returning user to the user pool");
            new ActivityService().closeCurrentUserActivity(token,username);
            new FileLocking().putUsernameInQueue(username);
            super.finished(description);
        }

        @Override
        protected void failed(Throwable e, Description description) {
            sessionDetails.setStatus("failed");
            sessionDetails.setReason("check stacktrace in jenkins");
            BSUpdateTestStatus.updateStatus(sessionDetails);
        }

        @Override
        protected void succeeded(Description description) {
            sessionDetails.setStatus("passed");
            sessionDetails.setReason("no issues found");
            BSUpdateTestStatus.updateStatus(sessionDetails);
        }
    };
}
