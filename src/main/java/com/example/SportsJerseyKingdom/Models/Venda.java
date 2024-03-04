package com.example.SportsJerseyKingdom.Models;

import java.util.Random;

public record Venda(Long id,long codeRastreio, String nomeCliente, String produto, String endereco, float valor, String enviado) {
    public Venda(Long id,long codeRastreio, String nomeCliente, String produto, String endereco, float valor, String enviado){
        //o abs pega só o numero absoluto ignorando o sinal
        var key = (id!= null) ? id : Math.abs(new Random().nextLong() );// se já tem id, n é preciso passar um aleatorio pois pega o que já tem
        var key2 = (id!= null) ? id : Math.abs(new Random().nextLong() );
        this.id = key; //esses comportamento do id é o que difere do record
        this.codeRastreio = key2;
        this.nomeCliente = nomeCliente;
        this.produto = produto;
        this.endereco = endereco;
        this.valor = valor;
        this.enviado = enviado;
}
}
