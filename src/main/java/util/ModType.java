package util;

public enum ModType {
    P("P - Particulate Trap"),
    M("M - Modification Or Change Of Engine"),
    G("G - Gas Engine");

    String description;

    ModType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
