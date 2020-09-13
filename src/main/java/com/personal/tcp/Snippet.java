package com.personal.tcp;

import com.personal.tcp.entities.messages.UserInfo;
import com.personal.tcp.entities.messages.User;
import com.personal.tcp.server.DataRepository;

public class Snippet {

    public static void main(String[] args) {

        User user = new User("0A 15 A2 20 7A C3 0C 4D 69 63 68 65 6C 20 52 65 69 70 73 16 0D");
        UserInfo userInfo = user.getData();
        DataRepository repository = new DataRepository();

    }

}
