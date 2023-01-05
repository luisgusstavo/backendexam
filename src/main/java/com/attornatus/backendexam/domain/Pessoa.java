package com.attornatus.backendexam.domain;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class Pessoa {
    @Id
    @GeneratedValue
    private Integer id;
    @Column
    private String nome;
    @Column
    private Date dataNasc;

    //@OneToMany(mappedBy = "pessoa")
    //private List<Endereco> enderecos;



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

    /*
    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

     */
}
