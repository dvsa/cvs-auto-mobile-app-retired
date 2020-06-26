package data.util;

public enum ModType {
    P("P - Particulate trap"),
    M("M - Modification or change of engine"),
    G("G - Gas engine");

    String description;

    ModType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
