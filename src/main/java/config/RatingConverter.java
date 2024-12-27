package config;

import entity.Rating;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = false)
public class RatingConverter implements AttributeConverter<Rating, String> {

    @Override
    public String convertToDatabaseColumn(Rating rating) {
        return (rating != null) ? rating.getValue() : null; // Преобразуем Rating в строку
    }

    @Override
    public Rating convertToEntityAttribute(String value) {
        if (value == null) {
            return null; // Если значение null, возвращаем null
        }
        // Используем метод fromValue для получения соответствующего значения
        try {
            return Rating.fromValue(value); // Преобразуем строку в Rating
        } catch (IllegalArgumentException e) {
            // Логируем ошибку, если значение не соответствует перечислению
            System.err.println("Unknown rating value: " + value);
            throw e; // Можно выбросить исключение или вернуть значение по умолчанию
        }
    }
}
