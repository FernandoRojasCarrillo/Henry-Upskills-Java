package com.example.demo.service;

import com.example.demo.model.Elemento;

import java.util.List;

public interface ElementoService {
    Elemento crearElemento(Elemento elemento);
    List<Elemento> obtenerElemento();
}
