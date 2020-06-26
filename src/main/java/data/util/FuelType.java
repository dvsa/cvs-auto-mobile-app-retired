package data.util;

public enum FuelType {
    DIESEL("Diesel"),
    GAS_CNG("Gas-CNG"),
    GAS_LNG("Gas-LNG"),
    GAS_LPG("Gas-LPG"),
    FUEL_CELL("Fuel Cell"),
    PETROL("Petrol"),
    FULL_ELECTRIC("Full Electric");

    String name;

    FuelType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
