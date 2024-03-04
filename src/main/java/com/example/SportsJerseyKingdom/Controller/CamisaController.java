package com.example.SportsJerseyKingdom.Controller;

import com.example.SportsJerseyKingdom.Models.Camisa;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CamisaController {
    
    
    Logger log = LoggerFactory.getLogger(getClass());

    List<Camisa> repository = new ArrayList<>();

    //GET
    @RequestMapping(method=RequestMethod.GET , path="/camisa")
    @ResponseBody
    public List<Camisa> index(){
        return repository;
    }

    //POST
    @RequestMapping(method=RequestMethod.POST ,path="/camisa")
    @ResponseBody
    public ResponseEntity<Camisa> create(@RequestBody Camisa camisa){
        log.info("cadastrando camisa: {}", camisa);
        repository.add(camisa);
        return ResponseEntity.status(201).body(camisa);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/camisa/{id}")
    @ResponseBody
    public ResponseEntity<Camisa> get (@PathVariable() Long id) {
        log.info("buscando camisa com id {}", id);
        var camisa = repository
            .stream()
            .filter(c -> c.id().equals(id)) // filtra por id
            .findFirst(); //pega o primeiro item 
        
        if (camisa.isEmpty()){
                return ResponseEntity.status(404).build();
            }
                return ResponseEntity.status(200).body(camisa.get());
    }

}
