/**
 * 
 */
package com.farkalit.webdemo.filter;

import com.fasterxml.jackson.databind.*;

import java.io.IOException;
/**
 * @author farkalitusman
 *
 */
public class CommonUtil {

	private CommonUtil(){}

    public static <T> T getObject(String jsonText, Class<T> clazz) {
        try {
            JsonNode json = getJson(jsonText);
            return getObject(json, clazz);
        } catch (Exception e) {
            throw new InvalidDataException();
        }
    }

    public static JsonNode getJson(String jsonText) throws IOException {
        return jsonText == null ? null : getObjectMapper().readTree(jsonText);
    }

    public static JsonNode getJson(Object object) {
        return object == null ? null : getObjectMapper().convertValue(object, JsonNode.class);
    }

    public static <T> T getObject(JsonNode json, Class<T> clazz)  {
        try {
            return getObjectMapper().readValue(json.toString(), clazz);
        } catch (Exception e) {
            throw new InvalidDataException();
        }
    }

    public static ObjectMapper getObjectMapper() {
        return Inner.objectMapper;
    }

    public static String getJsonString(Object o) {
        try {
            return getObjectMapper().writeValueAsString(o);
        } catch (Exception e) {
            throw new InvalidDataException();
        }
    }

    private static class Inner {
        private static ObjectMapper objectMapper;
        static {
            objectMapper = new ObjectMapper();
            objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            objectMapper.configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true);
            objectMapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
        }
    }
}
