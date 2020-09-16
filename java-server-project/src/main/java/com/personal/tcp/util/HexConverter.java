package com.personal.tcp.util;

public class HexConverter {

    public static String getHexFromByteArray(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();

        for (byte b : bytes) {
            hexString.append(String.format("%02X ", b));
        }

        return hexString.toString();
    }

    public static String getAsciiFromHex(String hexStr) {
        StringBuilder ascii = new StringBuilder();
        hexStr = hexStr.replaceAll(" ", "");

        for (int i = 0; i < hexStr.length(); i += 2) {
            String str = hexStr.substring(i, i + 2);
            ascii.append((char) Integer.parseInt(str, 16));
        }

        return ascii.toString();
    }

    public static String getAsciiFromByteArray(byte[] array){
        return getAsciiFromHex(getHexFromByteArray(array));
    }

    public static byte[] getByteArrayFromHex(String s) {
        s = s.replaceAll(" ", "");
        int len = s.length();
        byte[] array = new byte[len / 2];

        for (int i = 0; i < len; i += 2) {
            array[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                    + Character.digit(s.charAt(i+1), 16));
        }

        return array;
    }

}
