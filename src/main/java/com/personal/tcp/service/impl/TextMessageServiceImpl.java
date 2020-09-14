package com.personal.tcp.service.impl;

import com.personal.tcp.entities.message.type.TextMessage;
import com.personal.tcp.repository.MessageRepository;
import com.personal.tcp.service.CoreService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class TextMessageServiceImpl implements CoreService {

    private final MessageRepository repository;

    public TextMessageServiceImpl() {
        this.repository = new MessageRepository();
    }

    @Override
    public String process(String input) {
        System.out.println("TextMessageServiceImpl.process() - Processing Message... ");
        String response = "Gerar Resposta";

        TextMessage message = new TextMessage(input);
        repository.saveTextMessage(message);

        System.out.println("TextMessageServiceImpl.process() - Message processed. Response: " + response);
        return response;
    }

}
