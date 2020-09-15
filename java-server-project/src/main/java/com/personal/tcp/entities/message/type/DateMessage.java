package com.personal.tcp.entities.message.type;

import com.personal.tcp.entities.message.Message;
import com.personal.tcp.util.HexConverter;

import javax.xml.bind.DatatypeConverter;
import java.lang.reflect.Field;
import java.util.Arrays;

public class DateMessage extends Message {

    private String timezone;

    public DateMessage(byte[] input) {
        super(input);

        byte[] message = Arrays.copyOfRange(input, 3, input.length-2);
        this.timezone = HexConverter.getAsciiFromByteArray(message);
    }

    public String getTimezone() {
        return timezone;
    }
    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

}
