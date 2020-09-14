package com.personal.tcp.entities.message.type;

import com.personal.tcp.util.HexConverter;

import javax.persistence.*;
import java.util.Arrays;

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

    public UserInfoMessage(byte[] userInfo) {
        this.age        = Byte.toUnsignedInt(userInfo[0]);
        this.weigth     = Byte.toUnsignedInt(userInfo[1]);
        this.heigth     = Byte.toUnsignedInt(userInfo[2]);
        this.nameSize   = Byte.toUnsignedInt(userInfo[3]);

        byte[] name = Arrays.copyOfRange(userInfo, 4, userInfo.length-1);
        this.name       = HexConverter.getAsciiFromByteArray(name);
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
