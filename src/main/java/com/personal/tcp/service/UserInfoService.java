package com.personal.tcp.service;

import com.personal.tcp.entities.message.type.UserMessage;
import com.personal.tcp.repository.MessageRepository;

public class UserInfoService implements CoreService {

    private final MessageRepository repository;

    public UserInfoService() {
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
