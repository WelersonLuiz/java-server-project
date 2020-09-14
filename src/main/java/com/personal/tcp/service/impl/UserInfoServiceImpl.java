package com.personal.tcp.service.impl;

import com.personal.tcp.entities.message.type.UserMessage;
import com.personal.tcp.repository.MessageRepository;
import com.personal.tcp.service.CoreService;

public class UserInfoServiceImpl implements CoreService {

    private final MessageRepository repository;

    public UserInfoServiceImpl() {
        this.repository = new MessageRepository();
    }

    @Override
    public String process(String input) {
        System.out.println("UserInfoService.process() - Processing Text Message.");
        String response = "";

        UserMessage message = new UserMessage(input);
        repository.saveUserInfoMessage(message.getData());

        System.out.println("UserInfoService.process() - Response message: " + response);
        return response;
    }

}
