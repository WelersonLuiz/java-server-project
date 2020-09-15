package com.personal.tcp.service.impl;

import com.personal.tcp.entities.message.Message;
import com.personal.tcp.entities.message.type.TextMessage;
import com.personal.tcp.repository.MessageRepository;
import com.personal.tcp.service.CoreService;
import com.personal.tcp.util.HexConverter;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class TextMessageServiceImpl implements CoreService {

    private final MessageRepository repository;

    public TextMessageServiceImpl() {
        this.repository = new MessageRepository();
    }

    @Override
    public byte[] process(byte[] input) {
        System.out.println("[SERVER] - Text Message");

        TextMessage message = new TextMessage(input);
        repository.saveTextMessage(message);

        return HexConverter.getByteArrayFromString(Message.getAckResponse());
    }

}
