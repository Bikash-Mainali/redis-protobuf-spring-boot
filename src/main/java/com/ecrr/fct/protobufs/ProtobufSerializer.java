package com.ecrr.fct.protobufs;

import com.google.protobuf.Message;
import com.google.protobuf.Method;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @PROJECT IntelliJ IDEA
 * @AUTHOR Bikash Mainali
 * @DATE 1/7/24
 */
public class ProtobufSerializer<T extends Message> implements RedisSerializer<T> {

    private static final ConcurrentHashMap<Class<?>, Method> methodCache = new ConcurrentHashMap<Class<?>, Method>();


    public ProtobufSerializer() {

    }

    @Override
    public byte[] serialize(T t) throws SerializationException {
        return (t == null) ? null : ((Message) t).toByteArray();
    }

    @Override
    public T deserialize(byte[] bytes) throws SerializationException {
//        try {
//            T message = clazz.getDeclaredConstructor().newInstance();
//            return (T) message.newBuilderForType().mergeFrom(bytes).build();
//        } catch (Exception e) {
//            throw new SerializationException("Error deserializing com.ecrr.fct.protobuf", e);
//        }
        return null;
    }
}
