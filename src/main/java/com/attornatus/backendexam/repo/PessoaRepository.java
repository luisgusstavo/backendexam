package com.attornatus.backendexam.repo;

import com.attornatus.backendexam.domain.Pessoa;
import org.springframework.data.repository.CrudRepository;

public interface PessoaRepository extends CrudRepository<Pessoa,Integer> {

}
