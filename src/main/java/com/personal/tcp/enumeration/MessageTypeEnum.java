package com.personal.tcp.enumeration;

public enum MessageTypeEnum {

    A0,
    A1,
    A2,
    A3;


    public static MessageTypeEnum getTypeMessage(String input){
        return MessageTypeEnum.valueOf(input.substring(2, 4));
    }

}
