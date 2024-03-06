    package com.example.SportsJerseyKingdom.Controller;

    import com.example.SportsJerseyKingdom.Models.Camisa;

    import java.util.ArrayList;
    import java.util.List;

    import org.slf4j.Logger;
    import org.slf4j.LoggerFactory;
    import org.springframework.http.ResponseEntity;
    import org.springframework.stereotype.Controller;
    import org.springframework.web.bind.annotation.GetMapping;
    import org.springframework.web.bind.annotation.PathVariable;
    import org.springframework.web.bind.annotation.PostMapping;
    import org.springframework.web.bind.annotation.RequestBody;
    import org.springframework.web.bind.annotation.RequestMapping;
    import org.springframework.web.bind.annotation.RequestMethod;
    import org.springframework.web.bind.annotation.ResponseBody;
    import org.springframework.web.bind.annotation.RestController;

    @RestController
    @RequestMapping("/camisa")

    public class CamisaController {
        
        
        Logger log = LoggerFactory.getLogger(getClass());

        List<Camisa> repository = new ArrayList<>();

        //GET
        @GetMapping()
        public List<Camisa> index(){
            return repository;
        }

        //POST
        @PostMapping()
        public ResponseEntity<Camisa> create(@RequestBody Camisa camisa){
            log.info("cadastrando camisa: {}", camisa);
            repository.add(camisa);
            return ResponseEntity.status(201).body(camisa);
        }

        @GetMapping("/{id}")
        public ResponseEntity<Camisa> get (@PathVariable() Long id) {
            log.info("buscando camisa com id {}", id);
            var camisa = repository
                .stream()
                .filter(c -> c.id().equals(id)) // filtra por id
                .findFirst(); //pega o primeiro item 
            
            if (camisa.isEmpty()){
                    return ResponseEntity.notFound().build();
                }
                    return ResponseEntity.ok(camisa.get());
        }
        @DeleteMapping("/{id}")
        public ResponseEntity<Camisa> destroy(@PathVariable long id){
            log.info("Apagando acamisa" + id);
            var camisa = repository
                .stream()
                .filter(c -> c.id().equals(id)) // filtra por id
                .findFirst(); //pega o primeiro item 
            
            if (camisa.isEmpty()){
                    return ResponseEntity.notFound().build();
                }
                    return ResponseEntity.ok(camisa.get());
        }
    }
