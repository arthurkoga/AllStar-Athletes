package com.example.SportsJerseyKingdom.Models;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

@Data
@Entity
public class Venda{
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        private long id; 
        
        private String codeRastreio;
        
        @Size(min = 3, max = 550)
        @NotBlank
        private String nomeCliente;

        @Size(min = 3, max = 450)
        @NotBlank
        private String produto;

        @Size(min = 3, max = 255)
        @NotBlank
        private String endereco;

        @Positive
        private BigDecimal valor;
        
        private boolean enviado;
}

