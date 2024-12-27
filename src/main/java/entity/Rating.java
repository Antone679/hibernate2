package entity;

public enum Rating {
    G("G"),
    PG("PG"),
    PG_13("PG-13"),
    R("R"),
    NC_17("NC-17");

    private final String displayName;

    Rating(String displayName) {
        this.displayName = displayName;
    }

    public String getValue() {
        return displayName; // Возвращаем строковое представление
    }

    public static Rating fromValue(String value) {
        for (Rating rating : Rating.values()) {
            if (rating.getValue().equals(value)) {
                return rating;
            }
        }
        throw new IllegalArgumentException("Unknown value: " + value); // Обработка неизвестного значения
    }
}
