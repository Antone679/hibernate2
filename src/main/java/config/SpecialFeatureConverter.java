package config;

import entity.SpecialFeature;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Converter
public class SpecialFeatureConverter implements AttributeConverter<Set<SpecialFeature>, String> {
    @Override
    public String convertToDatabaseColumn(Set<SpecialFeature> specialFeatures) {
        if (specialFeatures == null || specialFeatures.isEmpty()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (SpecialFeature feature : specialFeatures) {
            sb.append(feature.getValue()).append(",");
        }
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }

    @Override
    public Set<SpecialFeature> convertToEntityAttribute(String string) {
        if (string == null || string.isEmpty()) {
            return new HashSet<>();
        }
        return Arrays.stream(string.split(","))
                .map(SpecialFeature::fromValue)
                .collect(Collectors.toSet());
    }
}
