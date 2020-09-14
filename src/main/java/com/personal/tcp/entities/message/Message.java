package com.personal.tcp.entities.message;

import com.google.gson.GsonBuilder;

import javax.xml.bind.DatatypeConverter;

public class Message {

    private String init;
    private Integer bytes;
    private String frame;
    private String crc;
    private String end;

    public Message() {
    }

    public Message(byte[] input) {
        this.init   = DatatypeConverter.printByte(input[0]);
        this.bytes  = Byte.toUnsignedInt(input[1]);
        this.frame  = DatatypeConverter.printByte(input[2]);
        this.crc    = DatatypeConverter.printByte(input[input.length-2]);
        this.end    = DatatypeConverter.printByte(input[input.length-1]);
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
