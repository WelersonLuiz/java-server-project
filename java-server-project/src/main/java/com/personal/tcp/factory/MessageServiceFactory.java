package com.personal.tcp.factory;

import com.personal.tcp.enumeration.MessageTypeEnum;
import com.personal.tcp.service.CoreService;
import com.personal.tcp.service.impl.DateServiceImpl;
import com.personal.tcp.service.impl.TextMessageServiceImpl;
import com.personal.tcp.service.impl.UserInfoServiceImpl;
import org.hibernate.secure.spi.IntegrationException;

public class MessageServiceFactory {

    public CoreService createService(MessageTypeEnum typeMessage){

        if (typeMessage == MessageTypeEnum.A1){
            return new TextMessageServiceImpl();
        }

        if (typeMessage == MessageTypeEnum.A2){
            return new UserInfoServiceImpl();
        }

        if (typeMessage == MessageTypeEnum.A3){
            return new DateServiceImpl();
        }

        throw new IntegrationException("Message type invalid.");
    }

}
