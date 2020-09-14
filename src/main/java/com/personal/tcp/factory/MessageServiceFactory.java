package com.personal.tcp.factory;

import com.personal.tcp.enumeration.MessageTypeEnum;
import com.personal.tcp.service.CoreService;
import com.personal.tcp.service.DateService;
import com.personal.tcp.service.TextMessageService;
import com.personal.tcp.service.UserInfoService;

public class MessageServiceFactory {

    public CoreService criarProcessador(MessageTypeEnum typeMessage){

        if (typeMessage == MessageTypeEnum.A1){
            return new TextMessageService();
        }

        if (typeMessage == MessageTypeEnum.A2){
            return new UserInfoService();
        }

        if (typeMessage == MessageTypeEnum.A3){
            return new DateService();
        }

        return null;
    }

}
