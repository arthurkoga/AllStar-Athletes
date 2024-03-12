package com.example.SportsJerseyKingdom.Controller;

import com.example.SportsJerseyKingdom.Models.Venda;
import com.example.SportsJerseyKingdom.Repository.CamisaRepository;
import com.example.SportsJerseyKingdom.Repository.VendaRepository;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;

@RequestMapping("/venda")
@RestController
public class VendaController {
    Logger log = LoggerFactory.getLogger(getClass());

    //List<Venda> repository = new ArrayList<>();

    @Autowired
    VendaRepository repository;

    //GET
    @GetMapping
    public List<Venda> index(){
        return repository.findAll();
    }
/* 
    //POST
    @RequestMapping(method=RequestMethod.POST ,path="/venda")
    @ResponseBody
    public ResponseEntity<Venda> create(@RequestBody Venda venda){
        log.info("cadastrando venda: {}", venda);
        repository.add(venda);
        return ResponseEntity.status(201).body(venda);
    }

    //GET 
    @RequestMapping(method = RequestMethod.GET, path = "/venda/{id}")
    @ResponseBody
    public ResponseEntity<Venda> get (@PathVariable() Long id) {
        log.info("buscando venda com id {}", id);
        var venda = repository
            .stream()
            .filter(c -> c.id().equals(id)) // filtra por id
            .findFirst(); //pega o primeiro item 
        
        if (venda.isEmpty()){
                return ResponseEntity.status(404).build();
            }
                return ResponseEntity.status(200).body(venda.get());
    }
*/
}
