package com.attornatus.backendexam.repo;

import com.attornatus.backendexam.domain.Pessoa;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;

/**
 * Repositório de Pessoas
 * Algumas operações foram restritas por questões de segurança.
 * Somente as operações de criação, listagem e edição foram mantidas.
 */
public interface PessoaRepository extends CrudRepository<Pessoa,Integer> {
    @Override
    @RestResource(exported = false)
    <S extends Pessoa> Iterable<S> saveAll(Iterable<S> entities);

    @Override
    @RestResource(exported = false)
    boolean existsById(Integer integer);

    @Override
    @RestResource(exported = false)
    Iterable<Pessoa> findAllById(Iterable<Integer> integers);

    @Override
    @RestResource(exported = false)
    void deleteById(Integer integer);

    @Override
    @RestResource(exported = false)
    void delete(Pessoa entity);

    @Override
    @RestResource(exported = false)
    void deleteAllById(Iterable<? extends Integer> integers);

    @Override
    @RestResource(exported = false)
    void deleteAll(Iterable<? extends Pessoa> entities);

    @Override
    @RestResource(exported = false)
    void deleteAll();

}
