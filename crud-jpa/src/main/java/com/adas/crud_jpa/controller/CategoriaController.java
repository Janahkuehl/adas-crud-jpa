package com.adas.crud_jpa.controller;

import com.adas.crud_jpa.model.Categoria;

public class CategoriaController {

    public Categoria Cadastrar(String id) {
        return categoriaRepository.findById(id).orElse(null);
    }

    public Categoria salvar(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

}
