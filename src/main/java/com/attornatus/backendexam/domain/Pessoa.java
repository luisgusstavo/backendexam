package com.attornatus.backendexam.domain;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Pessoa {
    @Id
    @GeneratedValue
    private Integer id;
    @Column
    private String nome;
    @Column
    private Date dataNasc;

    public Pessoa(String nome, Date dataNasc) {
        this.nome = nome;
        this.dataNasc = dataNasc;
    }
    public Pessoa(){}

    public Integer getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }
}
