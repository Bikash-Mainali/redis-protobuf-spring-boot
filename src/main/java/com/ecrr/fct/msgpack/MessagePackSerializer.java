package com.ecrr.fct.msgpack;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.msgpack.jackson.dataformat.MessagePackFactory;

/**
 * @PROJECT IntelliJ IDEA
 * @AUTHOR Bikash Mainali
 * @DATE 1/4/24
 */
public class MessagePackSerializer {

    //using MessagePack here
    private final ObjectMapper objectMapper = new ObjectMapper(new MessagePackFactory());

    public byte[] serialize(Object object) {
        try {
            return objectMapper.writeValueAsBytes(object);
        } catch (Exception e) {
            throw new RuntimeException("Error serializing object using MessagePack", e);
        }
    }
}
