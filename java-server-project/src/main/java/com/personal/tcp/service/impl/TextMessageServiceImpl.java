package com.personal.tcp.service.impl;

import com.personal.tcp.entities.message.Message;
import com.personal.tcp.entities.message.type.TextMessage;
import com.personal.tcp.repository.MessageRepository;
import com.personal.tcp.service.CoreService;
import com.personal.tcp.util.HexConverter;

public class TextMessageServiceImpl implements CoreService {

    private final MessageRepository<TextMessage> repository;

    public TextMessageServiceImpl() {
        this.repository = new MessageRepository<>();
    }

    @Override
    public byte[] process(byte[] input) {
        System.out.println("[SERVER] - Text Message");

        try {
            TextMessage message = new TextMessage(input);
            repository.saveMessage(message);
        } catch (Exception e){
          return null;
        }

        return HexConverter.getByteArrayFromString(Message.getAckResponse());
    }

}
