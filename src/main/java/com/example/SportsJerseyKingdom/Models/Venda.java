package com.example.SportsJerseyKingdom.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;
import jakarta.persistence.Id;

@Data
@Entity
public class Venda{
    
        //o abs pega só o numero absoluto ignorando o sinal
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        private long id; //esses comportamento do id é o que difere do record
        private String codeRastreio;
        private String nomeCliente ;
        private String produto;
        private String endereco;
        private float valor;
        private String enviado;
}

