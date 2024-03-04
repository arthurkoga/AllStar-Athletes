package com.example.SportsJerseyKingdom.Models;

import java.util.Random;

public record Camisa(Long id, String nome, String marca, String tamanho, float preco,String foto) {
    public Camisa(Long id, String nome, String marca, String tamanho, float preco, String foto){
        //o abs pega só o numero absoluto ignorando o sinal
        var key = (id!= null) ? id : Math.abs(new Random().nextLong() );// se já tem id, n é preciso passar um aleatorio pois pega o que já tem
        this.id = key; //esses comportamento do id é o que difere do record
        this.nome = nome;
        this.marca = marca;
        this.tamanho = tamanho;
        this.preco = preco;
        this.foto = foto;
    }
}
