package com.personal.tcp.entities.message.type;

import com.personal.tcp.entities.message.Message;

import java.util.Arrays;

public class UserMessage extends Message {

    private UserInfoMessage userInfoMessage;

    public UserMessage(byte[] input) {
        super(input);

        byte[] userInfo = Arrays.copyOfRange(input, 3, input.length-2);
        this.userInfoMessage = new UserInfoMessage(userInfo);
    }

    public UserInfoMessage getData() {
        return userInfoMessage;
    }
    public void setData(UserInfoMessage userInfoMessage) {
        this.userInfoMessage = userInfoMessage;
    }


}
