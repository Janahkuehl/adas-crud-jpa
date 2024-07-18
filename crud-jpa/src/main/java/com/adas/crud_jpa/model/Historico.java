package com.adas.crud_jpa.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor @AllArgsConstructor @Builder @Data
public class Historico {


    @Id
    @GeneratedValue
    private Integer id;

    private Date dataTransacao;

    // Campo que irá receber a chave primária da tabela 'Cliente' como chave estrageira
    // na tabela 'historico'.
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToMany
    @JoinTable(
            name = "registro_venda",
            joinColumns = @JoinColumn(name = "historico_id"),
            inverseJoinColumns = @JoinColumn(name = "produto_id")
    )
    private List<Produto> produtosHistorico;

}
