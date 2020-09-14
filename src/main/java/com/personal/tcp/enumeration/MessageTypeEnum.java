package com.personal.tcp.enumeration;

public enum MessageTypeEnum {

    A0,
    A1,
    A2,
    A3;

    public static MessageTypeEnum fromString(String name) {
        return MessageTypeEnum.valueOf(name.trim().toUpperCase());
    }

}
