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

        // Метод для получения константы из строки
        public static SpecialFeature fromValue(String value) {
            for (SpecialFeature feature : SpecialFeature.values()) {
                if (feature.getDisplayName().equalsIgnoreCase(value)) {
                    return feature; // Сравниваем с отображаемым значением
                }
            }
            throw new IllegalArgumentException("Unknown value: " + value); // Обработка неизвестного значения
        }
    }
