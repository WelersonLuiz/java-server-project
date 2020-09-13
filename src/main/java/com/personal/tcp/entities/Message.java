package com.personal.tcp.entities;

import com.google.gson.GsonBuilder;
import com.personal.tcp.entities.messages.User;

import java.util.ArrayList;
import java.util.List;

public class Message {

    private String init;
    private String bytes;
    private String frame;
    private String crc;
    private String end;

    public Message() {
    }

    public Message(String input) {
        this.setInit(input.substring(0,2));
        this.setBytes(input.substring(2,4));
        this.setFrame(input.substring(4,6));
        this.setCrc(input.substring(input.length()-4,input.length()-2));
        this.setEnd(input.substring(input.length()-2));
    }

    public static List<Message> translateMessages(String input){
        input = input.replaceAll(" ", "");
        List<Message> list = new ArrayList<>();

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

    public String getBytes() {
        return bytes;
    }
    public void setBytes(String bytes) {
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
