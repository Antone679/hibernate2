package entity;

public enum SpecialFeature {
    DELETED_SCENES("Deleted scenes"),
    BEHIND_THE_SCENES("Behind the scenes"),
    TRAILERS("Trailers"),
    COMMENTARIES("Commentaries");


    private final String displayName;

    SpecialFeature(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
    public String getValue() {
        return this.name();
    }

    public static SpecialFeature fromValue(String value) {
        return SpecialFeature.valueOf(value);
    }
}
