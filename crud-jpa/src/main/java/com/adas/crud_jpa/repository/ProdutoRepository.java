package com.adas.crud_jpa.repository;

import com.adas.crud_jpa.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

    @Query("SELECT p FROM Produto p WHERE p.nome = :NOME")
    List<Produto> buscarPeloNomeExato(@Param("NOME") String nome);

    @Query("SELECT p FROM Produto p WHERE p.nome LIKE %:NOME%")
    List<Produto> buscarPorNomeSimilar(@Param("NOME") String nome);

    @Query("SELECT p FROM Produto p WHERE p.preco >= :PRECO")
    List<Produto> buscarPorPrecoMaiorQue(@Param("PRECO") Double preco);

}
