package com.example.SportsJerseyKingdom.Models;

import java.util.Random;

import jakarta.persistence.Entity;
import lombok.Data;
import jakarta.persistence.Id;

@Data
@Entity
public class Venda{
    
        //o abs pega só o numero absoluto ignorando o sinal
        @Id
        private long id; //esses comportamento do id é o que difere do record
        private String codeRastreio;
        private String nomeCliente ;
        private String produto;
        private String endereco;
        private float valor;
        private String enviado;
}

