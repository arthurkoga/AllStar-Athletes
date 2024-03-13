package com.example.SportsJerseyKingdom.Controller;

import com.example.SportsJerseyKingdom.Models.Venda;
import com.example.SportsJerseyKingdom.Repository.VendaRepository;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.OK;

import java.util.List;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/venda")
@Slf4j
public class VendaController {

    @Autowired
    VendaRepository repository;

    //GET
    @GetMapping
    public List<Venda> index(){
        return repository.findAll();
    }

    //POST
    @PostMapping()
    @ResponseStatus(CREATED)
    public Venda create(@RequestBody Venda venda){
        log.info("cadastrando venda: {}", venda);
        return repository.save(venda);
    }

    //GET 
    @GetMapping("/{id}")
    public ResponseEntity<Venda> get (@PathVariable() Long id) {
        log.info("buscando venda com id {}", id);

        return repository
        .findById(id)
        .map((c) -> {return ResponseEntity.ok(c);})
        .orElse(ResponseEntity.notFound().build());

    }

    //PUT 
    @PutMapping("{id}")
    @ResponseStatus(OK)
    public Venda update(@PathVariable long id, @RequestBody Venda venda) {
        log.info("atualizando venda com id {} para {}", id, venda);
        
        verificaSeExisteVenda(id); // Verificação

        venda.setId(id); //Setando a venda com id
        return repository.save(venda); //Salvar no banco de dados 

    }

    //DELETE
    @DeleteMapping("{id}")
    @ResponseStatus()
    public ResponseEntity<Object> destroy(@PathVariable Long id){
        log.info("apagando venda com id: {}", id);
        
        verificaSeExisteVenda(id); // Verificação

        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    //Métodos de Verificação
    private void verificaSeExisteVenda(Long id){
        repository
            .findById(id)
            .orElseThrow(() -> new ResponseStatusException(
                NOT_FOUND,
                 "id da venda não encontrado!"
                 ));
    }
}
