package steps;

public enum Vertical {
    UPPER("Upper"),
    LOWER("Lower"),
    CANCEL("Cancel");
    String option;
    public String getOption() {
        return option;
    }
    Vertical(String option){
        this.option = option;
    }
}
