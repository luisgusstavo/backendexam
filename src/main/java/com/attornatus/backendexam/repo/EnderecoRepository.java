package com.attornatus.backendexam.repo;

import com.attornatus.backendexam.domain.Endereco;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface EnderecoRepository extends CrudRepository<Endereco,Integer> {
    /**
     * Lista os endereços associados a uma pessoa
     * @param id Id da Pessoa
     * @return List&lt;Endereco&gt; Lista de Endereços
     */
    List<Endereco> findByPessoaId(Integer id);

    /**
     * Informa o endereço principal de uma pessoa
     * @param id
     * @return Entity Endereco
     */
    @Query("select e from Endereco e where e.pessoa.id = ?1 and e.principal = true")
    Optional<Endereco> findEnderecoPrincipal(Integer id);
}
