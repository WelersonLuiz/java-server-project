package com.personal.tcp.entities.message.type;

import com.personal.tcp.entities.message.Message;

import java.util.Calendar;

public class DateResponseMessage extends Message {

    private DateFields fields;

    public DateResponseMessage(Calendar date) {
        this.setInit("0A");
        this.setBytes(11);
        this.setFrame("A3");
        this.fields = new DateFields(date);
        this.setCrc("9C");
        this.setEnd("0D");
    }

    public DateFields getFields() {
        return fields;
    }
    public void setFields(DateFields fields) {
        this.fields = fields;
    }

    @Override
    public String toHexString() {
        System.out.println("FIELDS - " + fields.toString());
        System.out.println("HEX FIELDS - " + fields.toHexString());
        return getInit() + " " +
                getBytes() + " " +
                getFrame() + " " +
                fields.toHexString() + " " +
                getCrc() + " " +
                getEnd();
    }

}
