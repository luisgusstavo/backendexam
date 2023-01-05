package com.attornatus.backendexam.domain;

import jakarta.persistence.*;

@Entity
public class Endereco {
    @Id
    @GeneratedValue
    private Integer id;
    @Column
    private String logradouro;
      @Column
    private String CEP;
    @Column
    private String numero;
    @Column
    private String cidade;
    @ManyToOne
    private Pessoa pessoa;
    @Column
    private boolean principal;



    public Integer getId() {
        return id;
    }

    public Endereco(String logradouro,
                    String CEP,
                    String numero,
                    String cidade, Pessoa pessoa,
                    boolean principal) {
        this.logradouro = logradouro;
        this.CEP = CEP;
        this.numero = numero;
        this.cidade = cidade;
        this.pessoa = pessoa;
        this.principal = principal;
    }
    public Endereco(){}

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public boolean isPrincipal() {
        return principal;
    }

    public void setPrincipal(boolean principal) {
        this.principal = principal;
    }
}
