package util;

public enum FuelType {
    GAS("Gas"),
    DIESEL("Diesel"),
    PETROL("Petrol");

    String name;

    FuelType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
