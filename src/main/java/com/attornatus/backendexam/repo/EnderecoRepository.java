package com.attornatus.backendexam.repo;

import com.attornatus.backendexam.domain.Endereco;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;
import java.util.Optional;

/**
 * Repositório de Endereços
 * Algumas operações foram restritas por questões de segurança.
 * Somente as operações de criação, consulta e listagem foram mantidas.
 */
@RepositoryRestResource(collectionResourceRel = "enderecos",path = "enderecos")
public interface EnderecoRepository extends CrudRepository<Endereco,Integer> {
    /**
     * Lista os endereços associados a uma pessoa
     * @param id Id da Pessoa
     * @return List&lt;Endereco&gt; Lista de Endereços
     */
    List<Endereco> findByPessoaId(@Param("id")Integer id);

    /**
     * Informa o endereço principal de uma pessoa
     * @param id
     * @return Entity Endereco
     */
    @Query("select e from Endereco e where e.pessoa.id = ?1 and e.principal = true")
    Optional<Endereco> findEnderecoPrincipal(Integer id);

    @Override
    @RestResource(exported = false)
    <S extends Endereco> Iterable<S> saveAll(Iterable<S> entities);

    @Override
    @RestResource(exported = false)
    boolean existsById(Integer integer);

    @Override
    @RestResource(exported = false)
    Iterable<Endereco> findAllById(Iterable<Integer> integers);

    @Override
    @RestResource(exported = false)
    void deleteById(Integer integer);

    @Override
    @RestResource(exported = false)
    void delete(Endereco entity);

    @Override
    @RestResource(exported = false)
    void deleteAllById(Iterable<? extends Integer> integers);

    @Override
    @RestResource(exported = false)
    void deleteAll(Iterable<? extends Endereco> entities);

    @Override
    @RestResource(exported = false)
    void deleteAll();


}
