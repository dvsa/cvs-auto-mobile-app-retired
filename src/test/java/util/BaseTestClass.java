package util;

import data.util.AtfService;
import data.util.PreparerService;
import data.util.VehicleTechnicalRecordService;
import net.thucydides.core.annotations.ClearCookiesPolicy;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;


public class BaseTestClass {

    protected AtfService atfService = new AtfService();
    protected PreparerService preparerService = new PreparerService();
    protected VehicleTechnicalRecordService vehicleService = new VehicleTechnicalRecordService();


    @Managed(uniqueSession=true, clearCookies = ClearCookiesPolicy.Never)
    public WebDriver webDriver;




}
