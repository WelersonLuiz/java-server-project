package com.personal.tcp.service.impl;

import com.personal.tcp.service.CoreService;

public class DateServiceImpl implements CoreService {

    @Override
    public byte[] process(byte[] input) {
        System.out.println("DateServiceImpl.process() - Processing Message... ");
        return input;
    }

}
