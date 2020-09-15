package com.personal.tcp.entities.message.type;
import com.personal.tcp.entities.message.Message;
import com.personal.tcp.util.HexConverter;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Date;

@Entity
@Table(name = "messages")
public class TextMessage extends Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "text_message")
    private String textMessage;

    @Column(name = "date_time")
    private Date dateTime;

    public TextMessage(byte[] input) {
        super(input);

        byte[] message = Arrays.copyOfRange(input, 3, input.length-2);
        this.textMessage = HexConverter.getAsciiFromByteArray(message);
        this.dateTime = new Date();
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getTextMessage() {
        return textMessage;
    }
    public void setTextMessage(String textMessage) {
        this.textMessage = textMessage;
    }

    public Date getDateTime() {
        return dateTime;
    }
    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

}
