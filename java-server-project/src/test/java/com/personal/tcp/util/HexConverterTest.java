package com.personal.tcp.util;

import org.junit.Assert;
import org.junit.Test;

public class HexConverterTest {

    private final String ascii = "Hello World";
    private final String hex = "48 65 6C 6C 6F 20 57 6F 72 6C 64 ";
    private final byte[] array = {
            (byte) 0x48, (byte) 0x65, (byte) 0x6C, (byte) 0x6C, (byte) 0x6F, (byte) 0x20,
            (byte) 0x57, (byte) 0x6F , (byte) 0x72, (byte) 0x6C, (byte) 0x64
    };


    @Test
    public void getHexFromByteArray() {
        String response = HexConverter.getHexFromByteArray(array);
        Assert.assertEquals(hex, response);
    }

    @Test
    public void getAsciiFromHex() {
        String response = HexConverter.getAsciiFromHex(hex);
        Assert.assertEquals(ascii, response);
    }

    @Test
    public void getAsciiFromByteArray() {
        String response = HexConverter.getAsciiFromByteArray(array);
        Assert.assertEquals(ascii, response);
    }

    @Test
    public void getByteArrayFromString() {
        byte[] response = HexConverter.getByteArrayFromHex(hex);
        Assert.assertArrayEquals(array, response);
    }
}