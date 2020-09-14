package com.personal.tcp.service;

import com.personal.tcp.entities.message.type.TextMessage;
import com.personal.tcp.repository.MessageRepository;

public class TextMessageService implements CoreService {

    private final MessageRepository repository;

    public TextMessageService() {
        this.repository = new MessageRepository();
    }

    @Override
    public String process(String input) {
        System.out.println("TextMessageService.process() - Processing Message... ");
        String response = "Gerar Resposta";

        input = input.replaceAll(" ", "");
        TextMessage message = new TextMessage(input);
        repository.saveTextMessage(message);

        System.out.println("TextMessageService.process() - Message processed. Response: " + response);
        return response;
    }

}
