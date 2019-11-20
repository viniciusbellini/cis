package br.com.bellini.cis.service;

import br.com.bellini.cis.entity.Pessoa;
import br.com.bellini.cis.repository.PessoaRepository;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public List<Pessoa> list() {
        return Lists.newArrayList(pessoaRepository.findAll());
    }

    public Pessoa save(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    public boolean existsById(Long id) {
        return pessoaRepository.existsById(id);
    }

    public Pessoa alter(Long id, Pessoa pessoa) {
        Pessoa alteredPessoa = new Pessoa(id, pessoa.getNome());
        return pessoaRepository.save(alteredPessoa);
    }

    public void deleteById(Long id) {
        pessoaRepository.deleteById(id);
    }
}
