package com.ecrr.fct.serializer.msgpack;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.msgpack.jackson.dataformat.MessagePackFactory;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

import java.io.IOException;

/**
 * @PROJECT IntelliJ IDEA
 * @AUTHOR Bikash Mainali
 * @DATE 1/4/24
 */
public class MessagePackSerializer<T> implements RedisSerializer<T> {

    //using MessagePack here
    private final ObjectMapper objectMapper = new ObjectMapper(new MessagePackFactory());

    public byte[] serialize(Object object) {
        try {
            return objectMapper.writeValueAsBytes(object);
        } catch (Exception e) {
            throw new RuntimeException("Error serializing object using MessagePack", e);
        }
    }

    @Override
    public T deserialize(byte[] bytes) throws SerializationException {
        try {
            return objectMapper.readValue(bytes, objectMapper.constructType(Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
