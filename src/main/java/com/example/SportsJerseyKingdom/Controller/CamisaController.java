package com.example.SportsJerseyKingdom.Controller;
import com.example.SportsJerseyKingdom.Models.Camisa;
import com.example.SportsJerseyKingdom.Repository.CamisaRepository;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.OK;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
    
@RequestMapping("/camisa")
@RestController
@Slf4j
public class CamisaController {

    @Autowired
    CamisaRepository repository;

    //GET
    @GetMapping()
    public List<Camisa> index(){
        return repository.findAll();
    }
    
    //POST
    @PostMapping()
    @ResponseStatus(CREATED)
    public Camisa create(@RequestBody Camisa camisa){
        log.info("cadastrando camisa: {}", camisa);
        return repository.save(camisa);
    }

    //GET 
    @GetMapping("/{id}")
    public ResponseEntity<Camisa> get (@PathVariable() Long id) {
        log.info("buscando camisa com id {}", id);

        return repository
        .findById(id)
        .map((c) -> {return ResponseEntity.ok(c);})
        .orElse(ResponseEntity.notFound().build());
    }

    //DELETE
    @DeleteMapping("{id}")
    @ResponseStatus()
    public ResponseEntity<Object> destroy(@PathVariable Long id){
        log.info("apagando camisa com id: {}", id);
        
        verificaSeExisteCamisa(id); // Verificação

        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    //PUT
    @PutMapping("{id}")
    @ResponseStatus(OK)
    public Camisa update(@PathVariable long id, @RequestBody Camisa camisa) {
        log.info("atualizando camisa com id {} para {}", id, camisa);
        
        verificaSeExisteCamisa(id); // Verificação

        camisa.setId(id); //Setando a camisa com id
        return repository.save(camisa); //Salvar no banco de dados 

    }

    //Métodos de Verificação
    private void verificaSeExisteCamisa(Long id){
        repository
            .findById(id)
            .orElseThrow(() -> new ResponseStatusException(
                NOT_FOUND,
                 "id da venda não encontrado!"
                 ));
    }
}
