package com.cpifppiramide.ddd.frutas.domain;

import com.cpifppiramide.ddd.supermercados.domain.Supermercado;

public class Fruta {

    private final String nombre;
    private final Supermercado supermercado;
    private final Float precio;

    public Fruta(String nombre, Supermercado supermercado, Float precio) {
        this.nombre = nombre;
        this.supermercado = supermercado;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public Supermercado getSupermercado() {
        return supermercado;
    }

    public Float getPrecio() {
        return precio;
    }
}
