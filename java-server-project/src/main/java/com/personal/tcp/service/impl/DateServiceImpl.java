package com.personal.tcp.service.impl;

import com.personal.tcp.entities.message.type.DateMessage;
import com.personal.tcp.entities.message.type.DateResponseMessage;
import com.personal.tcp.service.CoreService;
import com.personal.tcp.util.HexConverter;

import java.util.Calendar;
import java.util.TimeZone;

public class DateServiceImpl implements CoreService {

    @Override
    public byte[] process(byte[] input) {
        System.out.println("[SERVER] - Date Message");
        DateResponseMessage response;

        try {
            DateMessage message = new DateMessage(input);
            Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone(message.getTimezone()));
            response = new DateResponseMessage(calendar);
        } catch (Exception e){
            return null;
        }

        return HexConverter.getByteArrayFromString(response.toHexString());
    }

}
