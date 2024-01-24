package com.ecrr.fct.serializer.protobufs;

import com.google.protobuf.Message;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @PROJECT IntelliJ IDEA
 * @AUTHOR Bikash Mainali
 * @DATE 1/7/24
 */
public class ProtobufsSerializer<T extends Message> implements RedisSerializer<T> {
    private static final ConcurrentHashMap<Class<?>, java.lang.reflect.Method> methodCache = new ConcurrentHashMap<Class<?>, java.lang.reflect.Method>();

    private  Class<?> messageType;

    private static ProtobufsSerializer protobufsSerializer;

    public static ProtobufsSerializer setMessageType(Class<?> messageType){
        if(protobufsSerializer == null){
            protobufsSerializer = new ProtobufsSerializer<>();
        }
        protobufsSerializer.messageType = messageType;
        return protobufsSerializer;
    }

    @Override
    public byte[] serialize(T t) throws SerializationException {
        return (t == null) ? null : ((Message) t).toByteArray();
    }

    @Override
    public T deserialize(byte[] bytes) throws SerializationException {
        T t = null;
        if (bytes != null) {
            try {
                t = (T) parseFrom(protobufsSerializer.messageType, bytes);
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println(String.format("deserilization exception", e));
            }
        }
        return t;
    }

    /**
     * Create a new {@code Message.Builder} instance for the given class.
     * <p>This method uses a ConcurrentHashMap for caching method lookups.
     */
    private T parseFrom(Class<? extends Message> messageType, byte[] bytes) throws Exception {
        Method method = methodCache.get(messageType);
        if (method == null) {
            method = messageType.getMethod("parseFrom", byte[].class);
            methodCache.put(messageType, method);
        }
        return (T) method.invoke(messageType, bytes);
    }
}
