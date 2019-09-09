package steps;

public enum Lateral {
    NEARSIDE ("Nearside"),
    OFFSIDE ("Offside"),
    CENTRE ("Centre"),
    CANCEL ("Cancel");
    String option;
    public String getOption() {
        return option;
    }
    Lateral(String option) {
        this.option=option;
    }
}
