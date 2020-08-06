package com.nice.demo.data;

import java.util.HashMap;

public abstract class MessageType<T> {

    private static HashMap<String,MessageType> types = new HashMap<>();

    public MessageType(String type) {
        MessageType.register(type, this);
    }

    public static MessageType<?> get(String type) {
        MessageType result = types.get(type);

        if (result == null) {
            throw new InvalidTypeException(type);
        }

        return result;
    }

    public static void register(String name, MessageType type) {
        types.put(name, type);
    }

    public abstract T getValue(String value);

    public abstract double getDoubleValue(String value);

    public abstract void verify(String value);

}
