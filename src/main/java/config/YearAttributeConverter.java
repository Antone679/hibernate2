package config;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.time.Year;

@Converter(autoApply = false)
public class YearAttributeConverter implements AttributeConverter<Year, Integer> {

    @Override
    public Integer convertToDatabaseColumn(Year year) {
        return (year != null) ? year.getValue() : null;
    }

    @Override
    public Year convertToEntityAttribute(Integer yearValue) {
        return (yearValue != null) ? Year.of(yearValue) : null;
    }
}