package com.personal.tcp.entities.message;

import com.google.gson.GsonBuilder;
import com.personal.tcp.entities.message.types.User;

import java.util.ArrayList;
import java.util.List;

public class Message {

    private String init;
    private Integer bytes;
    private String frame;
    private String crc;
    private String end;

    public Message() {
    }

    public Message(String input) {
        this.init   = input.substring(0,2);
        this.bytes  = Integer.parseInt(input.substring(2,4), 16);
        this.frame  = input.substring(4,6);
        this.crc    = input.substring(input.length()-4,input.length()-2);
        this.end    = input.substring(input.length()-2);
    }

    public static List<Message> buildMessageList(String input){
        List<Message> list = new ArrayList<>();
        String start = "0A";
        String end = "0D";

        input = input.replaceAll(" ", "");
        String byteString = input.substring(0, 2);

        if (byteString.equals(start)){
            String messageType = input.substring(4, 2);

            switch (messageType){

            }

        }

        int i = 0;
        int initialChar = 0;

        while (i+2 < input.length()){
            String char1 = input.substring(i, i+1);
            String char2 = input.substring(i+1, i+2);

            if (char1.equals("0") && char2.equals("D")){
                list.add(new User(input.substring(initialChar, i+2)));
                initialChar = i+3;
            }

            i++;
        }
        list.add(new User(input.substring(initialChar, i+2)));

        return list;
    }

    public String getInit() {
        return init;
    }
    public void setInit(String init) {
        this.init = init;
    }

    public Integer getBytes() {
        return bytes;
    }
    public void setBytes(Integer bytes) {
        this.bytes = bytes;
    }

    public String getFrame() {
        return frame;
    }
    public void setFrame(String frame) {
        this.frame = frame;
    }

    public String getCrc() {
        return crc;
    }
    public void setCrc(String crc) {
        this.crc = crc;
    }

    public String getEnd() {
        return end;
    }
    public void setEnd(String end) {
        this.end = end;
    }

    public String toJson(){
        return new GsonBuilder().setPrettyPrinting().create().toJson(this);
    }

}
