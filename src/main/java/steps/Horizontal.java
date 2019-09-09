package steps;

public enum Horizontal {
    INNER ("Inner"),
    OUTER ("Outer"),
    CANCEL ("Cancel");
    String option;
    public String getOption() {
        return option;
    }
    Horizontal(String option) {
        this.option=option;
    }
}
