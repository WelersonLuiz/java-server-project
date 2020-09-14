package com.personal.tcp.factory;

import com.personal.tcp.enumeration.MessageTypeEnum;
import com.personal.tcp.service.CoreService;
import com.personal.tcp.service.impl.DateServiceImpl;
import com.personal.tcp.service.impl.TextMessageServiceImpl;
import com.personal.tcp.service.impl.UserInfoServiceImpl;

public class MessageServiceFactory {

    public CoreService createService(MessageTypeEnum typeMessage){
        CoreService service = null;

        if (typeMessage == MessageTypeEnum.A1){
            service = new TextMessageServiceImpl();
        }

        if (typeMessage == MessageTypeEnum.A2){
            service = new UserInfoServiceImpl();
        }

        if (typeMessage == MessageTypeEnum.A3){
            service = new DateServiceImpl();
        }

        return service;
    }

}
