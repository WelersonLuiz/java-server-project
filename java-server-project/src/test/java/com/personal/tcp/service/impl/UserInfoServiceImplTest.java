package com.personal.tcp.service.impl;

import com.personal.tcp.entities.message.Message;
import com.personal.tcp.entities.message.type.UserMessage;
import com.personal.tcp.repository.MessageRepository;
import com.personal.tcp.util.HexConverter;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doNothing;

@RunWith(MockitoJUnitRunner.class)
public class UserInfoServiceImplTest {

    @InjectMocks
    private UserInfoServiceImpl service;

    @Mock
    private MessageRepository<UserMessage> repository;

    private final byte[] arrayTest;

    public UserInfoServiceImplTest() {
        String stringTest = "0A 15 A2 20 7A C3 0C 4D 69 63 68 65 6C 20 52 65 69 70 73 16 0D";
        this.arrayTest = HexConverter.getByteArrayFromString(stringTest);
    }

    @Test
    public void userInfoProcessTest() {
        doNothing().when(repository).saveMessage(any());

        byte[] expected = HexConverter.getByteArrayFromString(Message.getAckResponse());
        byte[] response = service.process(arrayTest);

        Assert.assertArrayEquals(expected, response);
    }

    @Test
    public void userInfoProcessFailTest() {
        doNothing().when(repository).saveMessage(any());

        byte[] response = service.process(new byte[1]);

        Assert.assertArrayEquals(null, response);
    }

}