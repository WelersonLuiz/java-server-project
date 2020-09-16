package com.personal.tcp.service.impl;

import com.personal.tcp.entities.message.type.DateMessage;
import com.personal.tcp.entities.message.type.DateResponseMessage;
import com.personal.tcp.service.CoreService;
import com.personal.tcp.util.HexConverter;
import org.hibernate.secure.spi.IntegrationException;

import java.util.Calendar;
import java.util.TimeZone;

public class DateServiceImpl implements CoreService {

    @Override
    public byte[] process(byte[] input) {
        System.out.println("[SERVER] - Date Message");
        DateResponseMessage response;

        DateMessage message = new DateMessage(input);
        Calendar calendar = getCalendar(message.getTimezone());
        response = new DateResponseMessage(calendar);

        return HexConverter.getByteArrayFromString(response.toHexString());
    }

    private Calendar getCalendar(String timezone){

        String[] validIDs = TimeZone.getAvailableIDs();
        for (String str : validIDs) {
            if (str != null && str.equals(timezone)) {
                return Calendar.getInstance(TimeZone.getTimeZone(timezone));
            }
        }

        throw new IntegrationException("Timezone inválida.");
    }

}
