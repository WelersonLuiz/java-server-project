package com.personal.tcp.service.impl;

import com.personal.tcp.entities.message.type.UserMessage;
import com.personal.tcp.repository.MessageRepository;
import com.personal.tcp.service.CoreService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class UserInfoServiceImpl implements CoreService {

    private final MessageRepository repository;

    public UserInfoServiceImpl() {
        this.repository = new MessageRepository();
    }

    @Override
    public String process(String input) {
        System.out.println("UserInfoServiceImpl.process() - Processing Message... ");
        String response = "Gerar Resposta";

        UserMessage message = new UserMessage(input);
        repository.saveUserInfoMessage(message.getData());

        System.out.println("UserInfoServiceImpl.process() - Response message: " + response);
        return response;
    }

}
