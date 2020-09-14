package com.personal.tcp.entities.message.type;

import com.personal.tcp.util.HexConverter;

import javax.persistence.*;

@Entity
@Table(name = "user_data")
public class UserInfoMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "age")
    private Integer age;

    @Column(name = "weigth")
    private Integer weigth;

    @Column(name = "heigth")
    private Integer heigth;

    @Column(name = "nameSize")
    private Integer nameSize;

    @Column(name = "name")
    private String name;

    public UserInfoMessage() {
    }

    public UserInfoMessage(String data) {
        this.age = Integer.parseInt(data.substring(0,2),16);
        this.weigth = Integer.parseInt(data.substring(2,4),16);
        this.heigth = Integer.parseInt(data.substring(4,6),16);
        this.nameSize = Integer.parseInt(data.substring(6,8),16);
        this.name = HexConverter.hexToAscii(data.substring(8));
    }


    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getWeigth() {
        return weigth;
    }
    public void setWeigth(Integer weigth) {
        this.weigth = weigth;
    }

    public Integer getHeigth() {
        return heigth;
    }
    public void setHeigth(Integer heigth) {
        this.heigth = heigth;
    }

    public Integer getNameSize() {
        return nameSize;
    }
    public void setNameSize(Integer nameSize) {
        this.nameSize = nameSize;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

}
