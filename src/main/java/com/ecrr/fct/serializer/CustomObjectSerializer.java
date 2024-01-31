package com.ecrr.fct.serializer;

/**
 * @PROJECT IntelliJ IDEA
 * @AUTHOR Bikash Mainali
 * @DATE 1/30/24
 */
import com.ecrr.fct.model.People;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

public class CustomObjectSerializer<T> implements RedisSerializer<T> {

    private final ObjectMapper objectMapper;

    public CustomObjectSerializer(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public byte[] serialize(T object) throws SerializationException {
        try {
            return objectMapper.writeValueAsBytes(object);
        } catch (Exception e) {
            throw new SerializationException("Error serializing object", e);
        }
    }

    @Override
    public T deserialize(byte[] bytes) throws SerializationException {
        if (bytes == null || bytes.length == 0) {
            return null;
        }
        try {
            return objectMapper.readValue(bytes, objectMapper.constructType(Object.class));
        } catch (Exception e) {
            throw new SerializationException("Error deserializing object", e);
        }
    }
}
