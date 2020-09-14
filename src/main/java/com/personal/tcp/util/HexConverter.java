package com.personal.tcp.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class HexConverter {

    public static String hexToAscii(String hexStr) {
        StringBuilder output = new StringBuilder("");

        for (int i = 0; i < hexStr.length(); i += 2) {
            String str = hexStr.substring(i, i + 2);
            output.append((char) Integer.parseInt(str, 16));
        }

        return output.toString();
    }

    public static String getHexMessage(InputStream in) throws IOException {
        System.out.println("Validator.validateMessage() - Validating message recieved... ");

        byte[] bytes = getByteArray(in);

        StringBuilder hexString = new StringBuilder();
        for (byte b : bytes) {
            hexString.append(String.format("%02X ", b));
        }

        System.out.println("Validator.validateMessage() - Hex text received: " + hexString);
        return hexString.toString();
    }

    public static byte[] getByteArray(InputStream in) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        byte[] read = new byte[1];
        int len;

        while((len = in.read(read)) > -1) {
            baos.write(read, 0, len);
        }

        return baos.toByteArray();
    }

}
