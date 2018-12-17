package vehicle;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import steps.*;
import steps.composed.VehicleComp;

@RunWith(SerenityRunner.class)
public class VehicleTest {

    @Steps
    VehicleComp vehicleComp;

    @Steps
    VehicleDetailsSteps vehicleDetailsSteps;

    @Steps
    SelectPreparerSteps selectPreparerSteps;

    @Managed
    public WebDriver webDriver;


    @Title("CVSB-182 / CVSB-721 - AC1 Vehicle details presented are correct, VSA confirms")
    @Test
    public void testVehicleDetailsConfirmationPopUp() {
        vehicleComp.goToVehicleDetails();
        vehicleDetailsSteps.scrollTheDetailPage();
        vehicleDetailsSteps.checkDetailPageData("ABCDE1234FGHIJ5678","Volvo", "B12M"
                ,"Van Hool","Astrobel","D","2018",
                "1/10/2018","2","100A01" );
        vehicleDetailsSteps.selectConfirmButtonTopRight();
        vehicleDetailsSteps.checkConfirmationPopUp();

    }

    @Title("CVSB-182 / CVSB-722 - AC2 VSA further confirms")
    @Test
    public void testVehicleDetailsFurtherConfirmation() {
        vehicleComp.goToVehicleDetails();
        vehicleDetailsSteps.selectConfirmButtonTopRight();
        vehicleDetailsSteps.checkConfirmationPopUp();
        vehicleDetailsSteps.selectConfirmFromPopUp();
        selectPreparerSteps.checkPageTitle();

    }

    @Title("CVSB-182 / CVSB-723 - AC3 VSA cancels confirmation")
    @Test
    public void testVehicleDetailsCancelConfirmation() {
        vehicleComp.goToVehicleDetails();
        vehicleDetailsSteps.selectConfirmButtonTopRight();
        vehicleDetailsSteps.checkConfirmationPopUp();
        vehicleDetailsSteps.selectCancelFromPopUp();
        vehicleDetailsSteps.checkIfStillInDetailPageByPlate("AA12 BCD");

    }

}
