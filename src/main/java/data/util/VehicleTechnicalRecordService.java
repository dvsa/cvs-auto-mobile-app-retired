package data.util;

import data.VehicleTechnicalRecordsData;
import model.vehicles.Vehicle;

public class VehicleTechnicalRecordService {

    private Vehicle vehicleData = VehicleTechnicalRecordsData.buildVehicleTechnicalRecordsData();


    public Vehicle getVehicle() {
        return vehicleData;
    }
}
