package com.personal.tcp.service.impl;

import com.personal.tcp.entities.message.Message;
import com.personal.tcp.entities.message.type.TextMessage;
import com.personal.tcp.repository.MessageRepository;
import com.personal.tcp.util.HexConverter;
import org.hibernate.secure.spi.IntegrationException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.fail;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doNothing;

@RunWith(MockitoJUnitRunner.class)
public class TextMessageServiceImplTest {

    @InjectMocks
    private TextMessageServiceImpl service;

    @Mock
    private MessageRepository<TextMessage> repository;

    private final byte[] arrayTest;

    public TextMessageServiceImplTest() {
        String stringTest = "0A 10 A1 48 65 6C 6C 6F 20 57 6F 72 6C 64 DC 0D";
        this.arrayTest = HexConverter.getByteArrayFromString(stringTest);
    }

    @Test
    public void textMessageProcessTest() {
        doNothing().when(repository).saveMessage(any());

        byte[] expected = HexConverter.getByteArrayFromString(Message.getAckResponse());
        byte[] response = service.process(arrayTest);

        Assert.assertArrayEquals(expected, response);
    }

    @Test(expected = IntegrationException.class)
    public void textMessageProcessFailTest() {
        doNothing().when(repository).saveMessage(any());

        try {
            service.process(new byte[1]);
        } catch (IntegrationException e){
            Assert.assertEquals("Falha ao processar. Mensagem invalida.", e.getMessage());
            throw e;
        }

        fail();
    }

}