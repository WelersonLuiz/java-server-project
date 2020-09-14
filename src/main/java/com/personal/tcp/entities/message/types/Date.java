package com.personal.tcp.entities.message.types;

import com.personal.tcp.entities.message.Message;

public class Date extends Message {

    private String timezone;

    public Date(String input) {
        super(input);
    }

}
