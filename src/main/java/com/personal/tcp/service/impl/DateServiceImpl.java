package com.personal.tcp.service.impl;

import com.personal.tcp.entities.message.Message;
import com.personal.tcp.entities.message.type.DateFields;
import com.personal.tcp.entities.message.type.DateMessage;
import com.personal.tcp.entities.message.type.DateResponseMessage;
import com.personal.tcp.service.CoreService;
import com.personal.tcp.util.HexConverter;

import java.util.Calendar;
import java.util.TimeZone;

public class DateServiceImpl implements CoreService {

    @Override
    public byte[] process(byte[] input) {
        System.out.println("DateServiceImpl.process() - Processing Message");
        DateMessage message = new DateMessage(input);

        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone(message.getTimezone()));

        DateResponseMessage response = new DateResponseMessage(calendar);

        return HexConverter.getByteArrayFromString(Message.getAckResponse());
    }

    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("America/Sao_Paulo"));
        DateFields fields = new DateFields(calendar);

        System.out.println(fields.toString());
    }

}
