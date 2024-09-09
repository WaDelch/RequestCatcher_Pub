package de.WaDelch.RequestCatcher.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.AttributeConverter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class HashMapConverter implements AttributeConverter<Map<String, Object>, String>{
    @Override
    public String convertToDatabaseColumn(Map<String, Object> whData) {
        String whDataJSON = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            whDataJSON = mapper.writeValueAsString(whData);
        } catch (final JsonProcessingException e) {
            System.out.println("JSON writing error.");
        }
        return whDataJSON;
    }

    @Override
    public Map<String, Object> convertToEntityAttribute(String whDataJSON) {
        Map<String, Object>  whData = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            whData = mapper.readValue(whDataJSON, new TypeReference<HashMap<String, Object>>() {});
        } catch (final IOException e) {
            System.out.println("JSON reading error.");
        }
        return whData;
    }
}
