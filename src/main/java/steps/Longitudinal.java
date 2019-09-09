package steps;

public enum Longitudinal {
    FRONT ("Front"),
    REAR ("Rear"),
    CANCEL ("Cancel");
    String option;
    public String getOption() {
        return option;
    }
    Longitudinal(String option) {
        this.option=option;
    }
}
