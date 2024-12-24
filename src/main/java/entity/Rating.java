package entity;

public enum Rating {
    PG("PG"),
    G("G"),
    NC_17("NC-17"),
    PG_13("PG-13"),
    R("R");

    private final String displayName;

    Rating(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
