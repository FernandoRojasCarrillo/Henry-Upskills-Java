package com.example.demo.service.impl;

import com.example.demo.model.Elemento;
import com.example.demo.service.ElementoService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ElementoServiceImpl implements ElementoService {

    private List<Elemento> elementos = new ArrayList<>();

    @Override
    public Elemento crearElemento(Elemento elemento) {
        elementos.add(elemento);
        return elemento;
    }

    @Override
    public List<Elemento> obtenerElemento() {
        return elementos;
    }
}
