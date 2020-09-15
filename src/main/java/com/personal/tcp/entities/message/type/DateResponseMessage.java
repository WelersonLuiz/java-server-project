package com.personal.tcp.entities.message.type;

import com.personal.tcp.entities.message.Message;

import java.util.Calendar;

public class DateResponseMessage extends Message {

    private DateFields fields;

    public DateResponseMessage(Calendar date) {
        this.setInit("0A");
        this.setBytes(11);
        this.setFrame("A3");
        this.setCrc("9C");
        this.setEnd("0D");
        this.fields = new DateFields(date);
    }

    public DateFields getFields() {
        return fields;
    }
    public void setFields(DateFields fields) {
        this.fields = fields;
    }


    @Override
    public String toString() {
        return getInit() + " ";
    }

}
