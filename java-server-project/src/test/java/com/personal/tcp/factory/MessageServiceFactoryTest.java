package com.personal.tcp.factory;

import com.personal.tcp.enumeration.MessageTypeEnum;
import com.personal.tcp.service.CoreService;
import com.personal.tcp.service.impl.DateServiceImpl;
import com.personal.tcp.service.impl.TextMessageServiceImpl;
import com.personal.tcp.service.impl.UserInfoServiceImpl;
import org.hibernate.secure.spi.IntegrationException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.exceptions.base.MockitoException;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

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

    @Test (expected = IntegrationException.class)
    public void createServiceFail() {
        MessageTypeEnum type = MessageTypeEnum.A0;

        try {
            factory.createService(type);
        } catch (IntegrationException e){
            Assert.assertEquals("Message type invalid.", e.getMessage());
            throw e;
        }
    }

}