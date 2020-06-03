package data.util;

public enum EmissionStandard {
    OPTION_1("0.10 g/kWh Euro 3 PM"),
    OPTION_2("0.03 g/kWh Euro IV PM"),
    OPTION_3("Euro 3"),
    OPTION_4("Euro 4"),
    OPTION_5("Euro 6"),
    OPTION_6("Euro VI"),
    OPTION_7("Full Electric");

    String description;
    EmissionStandard(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
