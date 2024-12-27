package config;

import entity.SpecialFeature;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Converter(autoApply = false) // Указываем, что конвертер не будет применяться автоматически
public class SpecialFeatureConverter implements AttributeConverter<Set<SpecialFeature>, String> {

    @Override
    public String convertToDatabaseColumn(Set<SpecialFeature> specialFeatures) {
        if (specialFeatures == null || specialFeatures.isEmpty()) {
            return null;
        }
        return specialFeatures.stream()
                .map(SpecialFeature::getDisplayName) // Используем getDisplayName для получения строкового значения
                .collect(Collectors.joining(",")); // Объединяем значения через запятую
    }

    @Override
    public Set<SpecialFeature> convertToEntityAttribute(String string) {
        if (string == null || string.isEmpty()) {
            return new HashSet<>(); // Возвращаем пустой набор, если строка null или пустая
        }
        return Arrays.stream(string.split(","))
                .map(SpecialFeature::fromValue) // Преобразуем строку в SpecialFeature
                .collect(Collectors.toSet()); // Собираем в Set
    }
}
