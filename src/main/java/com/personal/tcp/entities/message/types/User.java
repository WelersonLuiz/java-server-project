package com.personal.tcp.entities.message.types;

import com.personal.tcp.entities.message.Message;

public class User extends Message {

    private UserInfo userInfo;

    public User(String input) {
        super(input);
        this.userInfo = new UserInfo(input.substring(6, input.length()-4));
    }

    public UserInfo getData() {
        return userInfo;
    }
    public void setData(UserInfo userInfo) {
        this.userInfo = userInfo;
    }


}
