package com.personal.tcp.repository;

import com.personal.tcp.entities.message.type.TextMessage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MessageRepositoryTest {

    @InjectMocks
    private MessageRepository<TextMessage> repository;

    @Test
    public void saveTextMessage() {
    }

    @Test
    public void saveUserInfoMessage() {
    }

}