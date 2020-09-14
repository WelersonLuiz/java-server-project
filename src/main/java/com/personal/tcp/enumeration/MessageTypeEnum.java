package com.personal.tcp.enumeration;

public enum MessageTypeEnum {

    A0,
    A1,
    A2,
    A3;

    public static MessageTypeEnum getTypeMessage(String input){
        System.out.println("MessageTypeEnum.getTypeMessage() - Analysing type of message...");
        MessageTypeEnum type = MessageTypeEnum.valueOf(input.substring(2, 4));
        System.out.println("MessageTypeEnum.getTypeMessage() - Type of message received: " + type);
        return type;
    }

}
