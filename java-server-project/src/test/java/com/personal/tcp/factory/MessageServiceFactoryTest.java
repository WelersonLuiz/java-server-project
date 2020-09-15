package com.personal.tcp.factory;

import com.personal.tcp.enumeration.MessageTypeEnum;
import com.personal.tcp.service.CoreService;
import com.personal.tcp.service.impl.DateServiceImpl;
import com.personal.tcp.service.impl.TextMessageServiceImpl;
import com.personal.tcp.service.impl.UserInfoServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class MessageServiceFactoryTest {

    @InjectMocks
    private MessageServiceFactory factory;

    @Test
    public void createTextService() {
        MessageTypeEnum type = MessageTypeEnum.A1;
        CoreService response = factory.createService(type);
        assertTrue(response instanceof TextMessageServiceImpl);
    }

    @Test
    public void createUserInfoService() {
        MessageTypeEnum type = MessageTypeEnum.A2;
        CoreService response = factory.createService(type);
        assertTrue(response instanceof UserInfoServiceImpl);
    }

    @Test
    public void createDateService() {
        MessageTypeEnum type = MessageTypeEnum.A3;
        CoreService response = factory.createService(type);
        assertTrue(response instanceof DateServiceImpl);
    }

    @Test
    public void createServiceFail() {
        MessageTypeEnum type = MessageTypeEnum.A0;
        CoreService response = factory.createService(type);
        assertNull(response);
    }

}