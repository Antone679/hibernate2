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
            return null;
        }
        try {
            return Rating.fromValue(value);
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }
}
