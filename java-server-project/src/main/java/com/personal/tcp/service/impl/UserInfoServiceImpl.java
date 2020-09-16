package com.personal.tcp.service.impl;

import com.personal.tcp.entities.message.Message;
import com.personal.tcp.entities.message.type.UserInfoMessage;
import com.personal.tcp.entities.message.type.UserMessage;
import com.personal.tcp.repository.MessageRepository;
import com.personal.tcp.service.CoreService;
import com.personal.tcp.util.HexConverter;
import org.hibernate.secure.spi.IntegrationException;

public class UserInfoServiceImpl implements CoreService {

    private final MessageRepository<UserInfoMessage> repository;

    public UserInfoServiceImpl() {
        this.repository = new MessageRepository<>();
    }

    @Override
    public byte[] process(byte[] input) {
        System.out.println("[SERVER] - UserInfo Message");

        try {
            UserMessage message = new UserMessage(input);
            repository.saveMessage(message.getData());
        } catch (Exception e) {
            throw new IntegrationException("Falha ao processar. Mensagem invalida.");
        }

        return HexConverter.getByteArrayFromHex(Message.getAckResponse());
    }

}
