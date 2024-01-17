package com.ecrr.fct;

/**
 * @PROJECT IntelliJ IDEA
 * @AUTHOR Bikash Mainali
 * @DATE 1/16/24
 */
public class Test {
    private final MessagePack messagePack;

    public MessagePackRedisSerializer() {
        this.messagePack = new MessagePack();
    }

    @Override
    public byte[] serialize(T object) throws SerializationException {
        try {
            return messagePack.write(object);
        } catch (Exception e) {
            throw new SerializationException("Error serializing object", e);
        }
    }

    @Override
    public T deserialize(byte[] bytes) throws SerializationException {
        try {
            return messagePack.read(bytes, messagePack.lookupTemplateType(YourObjectType.class));
        } catch (Exception e) {
            throw new SerializationException("Error deserializing object", e);
        }
    }
}
