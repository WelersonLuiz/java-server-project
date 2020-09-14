package com.personal.tcp.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class Validator {

    public static boolean validateMessage(InputStream in) throws IOException {
        boolean isValid = false;
        System.out.println("Validator.validateMessage() - Validating message recieved... " + in);

        byte[] bytes = getByteArray(in);

        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02X ", b));
        }

        System.out.println(sb.toString());

        System.out.println("Validator.validateMessage() - Validation result: " + isValid);
        return isValid;
    }

    private static byte[] getByteArray(InputStream in) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        byte[] read = new byte[1024];
        int len;

        while((len = in.read(read)) > -1) {
            baos.write(read, 0, len);
        }

        return baos.toByteArray();
    }

}
