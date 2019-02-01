package util;

import data.AtfData;
import data.util.AtfService;
import data.util.PreparerService;
import data.util.VehicleTechnicalRecordService;
import model.Atf;
import net.thucydides.core.annotations.ClearCookiesPolicy;
import net.thucydides.core.annotations.Managed;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

import java.util.List;


public class BaseTestClass {

    protected AtfService atfService = new AtfService();
    protected PreparerService preparerService = new PreparerService();
    protected VehicleTechnicalRecordService vehicleService = new VehicleTechnicalRecordService();


    @Managed()
    public WebDriver webDriver;




}
