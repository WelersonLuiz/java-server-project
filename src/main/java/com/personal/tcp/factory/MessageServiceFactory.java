package com.personal.tcp.factory;

import com.personal.tcp.enumeration.MessageTypeEnum;
import com.personal.tcp.service.CoreService;
import com.personal.tcp.service.DateService;
import com.personal.tcp.service.TextMessageService;
import com.personal.tcp.service.UserInfoService;

public class MessageServiceFactory {

    public CoreService createService(MessageTypeEnum typeMessage){
        CoreService service = null;

        if (typeMessage == MessageTypeEnum.A1){
            service = new TextMessageService();
        }

        if (typeMessage == MessageTypeEnum.A2){
            service = new UserInfoService();
        }

        if (typeMessage == MessageTypeEnum.A3){
            service = new DateService();
        }

        return service;
    }

}
