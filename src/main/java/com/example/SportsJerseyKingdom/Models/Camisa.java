package com.example.SportsJerseyKingdom.Models;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
public class Camisa {
        //o abs pega só o numero absoluto ignorando o sinal
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        private long id; //esses comportamento do id é o que difere do record
        
        @NotBlank
        @Size(min = 1, max = 255)
        private String nome;

        @Size(min = 1, max = 255)
        @NotBlank
        private String marca;

        @Size(min = 1, max = 3)
        @NotBlank
        private String tamanho;

        @Positive
        private BigDecimal preco;
        
        @NotBlank
        private String foto; 
    }

