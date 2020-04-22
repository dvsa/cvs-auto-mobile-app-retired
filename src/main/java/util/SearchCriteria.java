package util;

public enum SearchCriteria {
    ALL ("Registration number, VIN or trailer ID"),
    REGISTRATION_NUMBER ("Registration number"),
    FULL_VIN ("Full VIN"),
    PARTIAL_VIN ("Partial VIN (last 6 characters)"),
    TRAILER_ID ("Trailer ID");

    private String description;

    SearchCriteria(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
