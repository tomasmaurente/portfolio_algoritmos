package com.example.pd4;

import com.example.pd4.interfaces.*;

public class Producto implements IProducto {

    private Comparable etiqueta;
    private Integer precio;
    private Integer stock;
    private String nombre;

    public Producto(
        Comparable etiqueta,
        String nombre,
        Integer precio,
        Integer stock

    ) {
        this.etiqueta = etiqueta;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    @Override
    public Comparable getEtiqueta() {
        return this.etiqueta;
    }

    @Override
    public Integer getPrecio() {
        return this.precio;
    }

    @Override
    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    @Override
    public Integer getStock() {
        return this.stock;
    }

    @Override
    public void setStock(Integer stock) {
        this.stock = stock;
    }

    @Override
    public String getNombre() {
        return this.nombre;
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String toString(){
        return "Etiqueta: " + this.etiqueta + " | Nombre: " + this.nombre + " | Precio: " + this.precio + " | Stock: " + this.stock;
    }
}
