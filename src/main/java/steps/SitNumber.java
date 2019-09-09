package steps;

public enum SitNumber {
    ONE("1"),
    TWO("2"),
    THREE("3"),
    FOUR("4"),
    FIVE("5"),
    SIX("6");
    String option;
    public String getOption() {
        return option;
    }
    SitNumber(String option) {
        this.option=option;
    }
}
