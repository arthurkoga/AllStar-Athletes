package com.example.SportsJerseyKingdom.Repository;

import com.example.SportsJerseyKingdom.Models.Camisa;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CamisaRepository extends JpaRepository<Camisa, Long> {
    
   
}
