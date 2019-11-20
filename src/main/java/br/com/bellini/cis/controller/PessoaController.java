package br.com.bellini.cis.controller;

import br.com.bellini.cis.entity.Pessoa;
import br.com.bellini.cis.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("pessoas")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @GetMapping
    private ResponseEntity<List<Pessoa>> list() {
        return ResponseEntity.ok(pessoaService.list());
    }

    @PostMapping
    private ResponseEntity<Pessoa> add(@RequestBody Pessoa pessoa) {
        Pessoa pessoaSaved = pessoaService.save(pessoa);
        return ResponseEntity.ok(pessoaSaved);
    }

    @PutMapping("{id}")
    private ResponseEntity<Pessoa> alter(@PathVariable Long id, @RequestBody Pessoa pessoa) {
        if (pessoaService.existsById(id)){
            Pessoa alter = pessoaService.alter(id, pessoa);
            return ResponseEntity.ok(alter);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("{id}")
    private ResponseEntity delete (@PathVariable Long id, @RequestBody Pessoa pessoa) {
        if(pessoaService.existsById(id)) {
            pessoaService.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
