package br.com.bellini.cis.repository;

import br.com.bellini.cis.entity.Pessoa;
import org.springframework.data.repository.CrudRepository;

public interface PessoaRepository extends CrudRepository<Pessoa, Long> {}
