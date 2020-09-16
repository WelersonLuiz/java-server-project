package com.personal.tcp.service.impl;

import com.personal.tcp.entities.message.Message;
import com.personal.tcp.entities.message.type.TextMessage;
import com.personal.tcp.repository.MessageRepository;
import com.personal.tcp.service.CoreService;
import com.personal.tcp.util.HexConverter;
import org.hibernate.secure.spi.IntegrationException;

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
            throw new IntegrationException("Falha ao processar. Mensagem inválida.");
        }

        return HexConverter.getByteArrayFromString(Message.getAckResponse());
    }

}
