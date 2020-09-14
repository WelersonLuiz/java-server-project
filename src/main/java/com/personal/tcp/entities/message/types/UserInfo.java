package com.personal.tcp.entities.message.types;

import javax.persistence.*;

@Entity
@Table(name = "data")
public class UserInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "idade")
    private Integer idade;

    @Column(name = "peso")
    private Integer peso;

    @Column(name = "altura")
    private Integer altura;

    @Column(name = "tamanhoNome")
    private Integer tamanhoNome;

    @Column(name = "nome")
    private String nome;

    public UserInfo() {
    }

    public UserInfo(String data) {
        this.idade = Integer.parseInt(data.substring(0,2),16);
        this.peso = Integer.parseInt(data.substring(2,4),16);
        this.altura = Integer.parseInt(data.substring(4,6),16);
        this.tamanhoNome = Integer.parseInt(data.substring(6,8),16);
        this.nome = hexToAscii(data.substring(8));
    }

    private static String hexToAscii(String hexStr) {
        StringBuilder output = new StringBuilder("");

        for (int i = 0; i < hexStr.length(); i += 2) {
            String str = hexStr.substring(i, i + 2);
            output.append((char) Integer.parseInt(str, 16));
        }

        return output.toString();
    }

    public Integer getIdade() {
        return idade;
    }
    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public Integer getPeso() {
        return peso;
    }
    public void setPeso(Integer peso) {
        this.peso = peso;
    }

    public Integer getAltura() {
        return altura;
    }
    public void setAltura(Integer altura) {
        this.altura = altura;
    }

    public Integer getTamanhoNome() {
        return tamanhoNome;
    }
    public void setTamanhoNome(Integer tamanhoNome) {
        this.tamanhoNome = tamanhoNome;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

}
