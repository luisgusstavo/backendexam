package com.attornatus.backendexam.service;

import com.attornatus.backendexam.domain.Pessoa;
import com.attornatus.backendexam.repo.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PessoaService {
    private final PessoaRepository pessoaRepository;

    @Autowired
    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    /**
     * Cria uma nova pessoa e salva no banco de dados
     * @param nome nome
     * @param dataNasc data de nascimento
     * @return Pessoa Entity
     */
    public Pessoa createPessoa(String nome, Date dataNasc){

        return pessoaRepository.save(new Pessoa(nome, dataNasc ));

    }
    public Iterable<Pessoa> lookup(){
        return pessoaRepository.findAll();
    }

}
