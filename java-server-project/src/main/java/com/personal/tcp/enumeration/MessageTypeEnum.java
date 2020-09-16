package com.personal.tcp.enumeration;

import org.hibernate.secure.spi.IntegrationException;

public enum MessageTypeEnum {

    A0,
    A1,
    A2,
    A3;

    public static MessageTypeEnum fromByte(byte value) {
        try {
            return MessageTypeEnum.valueOf(String.format("%02X ", value).trim().toUpperCase());
        } catch (Exception e){
            throw new IntegrationException("Byte for type not found.");
        }
    }

}
