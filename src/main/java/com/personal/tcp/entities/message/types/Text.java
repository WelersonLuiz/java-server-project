package com.personal.tcp.entities.message.types;
import com.personal.tcp.entities.message.Message;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "mensagens")
public class Text extends Message {

    @Id
    private String id;

    @Column(name = "mensagem_texto")
    private String text;

    @Column(name = "data_hora")
    private Date data;

    public Text(String input) {
        super(input);
        this.text = input.substring(6, input.length()-4);
        this.data = new Date();
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }

    public Date getData() {
        return data;
    }
    public void setData(Date data) {
        this.data = data;
    }

}
