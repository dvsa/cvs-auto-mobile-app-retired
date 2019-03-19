package util;

import data.util.AtfService;
import data.util.PreparerService;
import data.util.VehicleTechnicalRecordService;
import net.thucydides.core.annotations.ClearCookiesPolicy;
import net.thucydides.core.annotations.Managed;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import util.backend.activity.ActvityService;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;


public class BaseTestClass extends BaseUtils {

    protected AtfService atfService = new AtfService();
    protected PreparerService preparerService = new PreparerService();
    protected VehicleTechnicalRecordService vehicleService = new VehicleTechnicalRecordService();
    private ActvityService actvityService = new ActvityService();


    @Managed(uniqueSession = true, clearCookies = ClearCookiesPolicy.Never)
    public WebDriver webDriver;


    @Before()
    public void closeActivity() {
        actvityService.closeUserActivity();
    }

}
