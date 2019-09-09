package steps;

public enum AxleNumber {
    ONE("1"),
    TWO("2"),
    THREE("3"),
    FOUR("4"),
    FIVE("5"),
    SIX("6"),
    SEVEN("7"),
    EIGHT("8"),
    NINE("9"),
    TEN("10");
    String option;
    public String getOption() {
        return option;
    }
    AxleNumber(String option) {
        this.option=option;
    }
}
