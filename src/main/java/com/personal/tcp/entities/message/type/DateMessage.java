package com.personal.tcp.entities.message.type;

import com.personal.tcp.entities.message.Message;

public class DateMessage extends Message {

    private String timezone;

    public DateMessage(byte[] input) {
        super(input);


    }

}
