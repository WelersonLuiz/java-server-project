package com.personal.tcp.util;

public class CalcCRC {

    public static String calcCRC(byte[] data) {
        int tmp;
        int res = 0;

        for (byte datum : data) {
            tmp = res << 1;
            tmp += 0xff & datum;
            res = ((tmp & 0xff) + (tmp >> 8)) & 0xff;
        }

        return String.format("%02X", res);
    }

    public static void main(String[] args) {
        String hexString = "09 01 31 32 33 34";
        byte[] array = HexConverter.getByteArrayFromString(hexString);

        System.out.println(calcCRC(array));
    }

}
