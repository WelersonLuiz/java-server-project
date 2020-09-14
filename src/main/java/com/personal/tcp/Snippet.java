package com.personal.tcp;

import com.personal.tcp.entities.message.types.UserInfo;
import com.personal.tcp.entities.message.types.User;
import com.personal.tcp.repository.DataRepository;

public class Snippet {

    public static void main(String[] args) {

        User user = new User("" +
                "0A 15 A1 20 7A C3 0C 4D 69 63 68 65 6C 20 52 65 69 70 73 16 0D " +
                "0A 15 A2 4D 69 63 68 65 6C 20 52 65 69 70 73 16 0D");
        UserInfo userInfo = user.getData();
        DataRepository repository = new DataRepository();

    }

}
