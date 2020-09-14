package com.personal.tcp.entities.message.type;

import com.personal.tcp.entities.message.Message;

public class UserMessage extends Message {

    private UserInfoMessage userInfoMessage;

    public UserMessage(String input) {
        super(input);
        this.userInfoMessage = new UserInfoMessage(input.substring(6, input.length()-4));
    }

    public UserInfoMessage getData() {
        return userInfoMessage;
    }
    public void setData(UserInfoMessage userInfoMessage) {
        this.userInfoMessage = userInfoMessage;
    }


}
