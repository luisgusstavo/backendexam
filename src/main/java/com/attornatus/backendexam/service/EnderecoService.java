package com.attornatus.backendexam.service;

import com.attornatus.backendexam.domain.Endereco;
import com.attornatus.backendexam.domain.Pessoa;
import com.attornatus.backendexam.repo.EnderecoRepository;
import com.attornatus.backendexam.repo.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {
    private final EnderecoRepository enderecoRepository;
    private final PessoaRepository pessoaRepository;

    @Autowired
    public EnderecoService(EnderecoRepository enderecoRepository,
                           PessoaRepository pessoaRepository) {
        this.enderecoRepository = enderecoRepository;
        this.pessoaRepository = pessoaRepository;
    }

    /**
     * Cria um novo endereço associado a uma pessoa e salva na base
     * @param logradouro Logradouro
     * @param CEP CEP
     * @param numero Número
     * @param cidade Cidade
     * @param pessoaId Id da Pessoa
     * @return Endereco Entity
     */
    public Endereco createEndereco(String logradouro,
                                   String CEP,
                                   String numero,
                                   String cidade,
                                   Integer pessoaId){
        Pessoa pessoa = pessoaRepository.findById(pessoaId).
                orElseThrow(()->new RuntimeException("Pessoa não existe"));

        List<Endereco> enderecos = enderecoRepository.findByPessoaId(pessoaId);

        boolean isPrincipal = (enderecos.size()>0)?false:true;

        return enderecoRepository.save(
                new Endereco(logradouro, CEP,numero, cidade, pessoa,isPrincipal));


    }



}
