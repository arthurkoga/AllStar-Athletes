package com.example.SportsJerseyKingdom.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Camisa {
        //o abs pega só o numero absoluto ignorando o sinal
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        private long id; //esses comportamento do id é o que difere do record
        private String nome;
        private String marca;
        private String tamanho;
        private float preco;
        private String foto; 
    }

