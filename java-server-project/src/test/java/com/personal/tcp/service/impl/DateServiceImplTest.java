package com.personal.tcp.service.impl;

import com.personal.tcp.util.HexConverter;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class DateServiceImplTest {

    @InjectMocks
    private DateServiceImpl service;

    private final byte[] arrayTest;

    public DateServiceImplTest() {
        String stringTest = "0A 16 A3 41 6D 65 72 69 63 61 2F 53 61 6F 5F 50 61 75 6C 6F CD 0D";
        this.arrayTest = HexConverter.getByteArrayFromString(stringTest);
    }

    @Test
    public void dateMessageProcessTest() {
        byte[] response = service.process(arrayTest);
        System.out.println(response.length);

        Assert.assertEquals(11, response.length);
    }

    @Test
    public void dateMessageProcessFailTest() {
        byte[] response = service.process(new byte[1]);
        Assert.assertArrayEquals(null, response);
    }
}