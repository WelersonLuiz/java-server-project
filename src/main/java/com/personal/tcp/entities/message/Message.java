package com.personal.tcp.entities.message;

import com.google.gson.GsonBuilder;

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
