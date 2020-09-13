package com.personal.tcp.entities.messages;

import com.personal.tcp.entities.Message;

public class CurrentDate extends Message {

    private String timezone;


    public CurrentDate(String input) {
        super(input);

    }
}
