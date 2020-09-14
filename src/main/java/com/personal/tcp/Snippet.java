package com.personal.tcp;

import com.personal.tcp.entities.message.type.UserInfoMessage;
import com.personal.tcp.entities.message.type.UserMessage;
import com.personal.tcp.repository.MessageRepository;

public class Snippet {

    public static void main(String[] args) {

        UserMessage userMessage = new UserMessage("" +
                "0A 15 A1 20 7A C3 0C 4D 69 63 68 65 6C 20 52 65 69 70 73 16 0D " +
                "0A 15 A2 4D 69 63 68 65 6C 20 52 65 69 70 73 16 0D");
        UserInfoMessage userInfoMessage = userMessage.getData();
        MessageRepository repository = new MessageRepository();

    }

}
