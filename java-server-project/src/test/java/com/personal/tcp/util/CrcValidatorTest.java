package com.personal.tcp.util;

import org.junit.Test;

import static org.junit.Assert.*;

public class CrcValidatorTest {

    @Test
    public void crcIsValidTest() {
        byte[] array = HexConverter.getByteArrayFromHex("0A 10 A1 48 65 6C 6C 6F 20 57 6F 72 6C 64 DC 0D");
        assertTrue(CrcValidator.crcIsValid(array));
    }

    @Test
    public void crcIsNotValidTest() {
        byte[] array = HexConverter.getByteArrayFromHex("0A 10 A1 48 65 6C 6C 6F 20 57 6F 72 6C 64 00 0D");
        assertFalse(CrcValidator.crcIsValid(array));
    }

}