package com.personal.tcp.service.impl;

import com.personal.tcp.entities.message.type.TextMessage;
import com.personal.tcp.repository.MessageRepository;
import com.personal.tcp.service.CoreService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class TextMessageServiceImpl implements CoreService {

    protected static final Logger LOG = LogManager.getLogger(TextMessageServiceImpl.class);
    private final MessageRepository repository;

    public TextMessageServiceImpl() {
        this.repository = new MessageRepository();
    }

    @Override
    public String process(String input) {
        System.out.println("TextMessageService.process() - Processing Message... ");
        String response = "Gerar Resposta";

        LOG.info("Mensagem recebida - " + input);

        input = input.replaceAll(" ", "");
        TextMessage message = new TextMessage(input);
        repository.saveTextMessage(message);

        System.out.println("TextMessageService.process() - Message processed. Response: " + response);
        return response;
    }

}
