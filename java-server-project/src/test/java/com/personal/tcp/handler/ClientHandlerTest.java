package com.personal.tcp.handler;

import com.personal.tcp.entities.message.Message;
import com.personal.tcp.factory.MessageServiceFactory;
import com.personal.tcp.service.impl.TextMessageServiceImpl;
import com.personal.tcp.util.HexConverter;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.hibernate.secure.spi.IntegrationException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ClientHandlerTest {

    @InjectMocks
    private ClientHandler handler;

    @Mock
    private MessageServiceFactory factory;

    @Mock
    private TextMessageServiceImpl service;

    @Test
    public void clientHandlerMessageTest() {
        Logger.getLogger("com.personal").setLevel(Level.OFF);
        byte[] array = HexConverter.getByteArrayFromHex(Message.getAckResponse());

        when(factory.createService(any())).thenReturn(service);
        when(service.process(any())).thenReturn(array);

        String response = handler.handleMessage("0A 10 A1 48 65 6C 6C 6F 20 57 6F 72 6C 64 DC 0D");

        Assert.assertEquals("0A 05 A0 28 0D ", response);
    }

    @Test (expected = IntegrationException.class)
    public void clientHandlerMessageInvalidTest() {
        try {
            handler.handleMessage("test");
        } catch (IntegrationException e){
            Assert.assertEquals("Message format invalid.", e.getMessage());
            throw e;
        }
    }

    @Test (expected = IntegrationException.class)
    public void clientHandlerCrcFailTest() {
        try {
            handler.handleMessage("0A 10 A1 48 65 6C 6C 6F 20 57 6F 72 6C 64 00 0D");
        } catch (IntegrationException e){
            Assert.assertEquals("CRC invalid", e.getMessage());
            throw e;
        }
    }

}