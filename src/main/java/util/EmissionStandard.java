package util;

public enum EmissionStandard {
    OPTION_1("0.16 g/kWh Euro 3 PM"),
    OPTION_2("0.08 g/kWh Euro 3 PM"),
    OPTION_3("0.03 g/kWh Euro 4 PM");

    String description;
    EmissionStandard(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
