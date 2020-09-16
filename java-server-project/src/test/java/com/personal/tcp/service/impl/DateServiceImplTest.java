package com.personal.tcp.service.impl;

import com.personal.tcp.util.HexConverter;
import org.hibernate.secure.spi.IntegrationException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.fail;

@RunWith(MockitoJUnitRunner.class)
public class DateServiceImplTest {

    @InjectMocks
    private DateServiceImpl service;

    private final byte[] arrayTest;
    private final byte[] timezoneArrayTest;

    public DateServiceImplTest() {
        String stringTest = "0A 16 A3 41 6D 65 72 69 63 61 2F 53 61 6F 5F 50 61 75 6C 6F CD 0D";
        this.arrayTest = HexConverter.getByteArrayFromString(stringTest);
        String timezoneError = "0A 16 A3 41 6D 65 72 69 63 61 2F 53 61 6F 5F 50 61 75 6C 6D C3 0D";
        this.timezoneArrayTest = HexConverter.getByteArrayFromString(timezoneError);
    }

    @Test
    public void dateMessageProcessTest() {
        byte[] response = service.process(arrayTest);
        System.out.println(response.length);

        Assert.assertEquals(11, response.length);
    }

    @Test(expected = IntegrationException.class)
    public void dateMessageProcessFailTest() {
        try {
            service.process(new byte[1]);
        } catch (IntegrationException e){
            Assert.assertEquals("Falha ao processar. Mensagem invalida.", e.getMessage());
            throw e;
        }

        fail();
    }

    @Test(expected = IntegrationException.class)
    public void dateMessageProcessTimezoneErrorTest() {
        try {
            service.process(timezoneArrayTest);
        } catch (IntegrationException e){
            Assert.assertEquals("Timezone invalida.", e.getMessage());
            throw e;
        }

        fail();
    }
}