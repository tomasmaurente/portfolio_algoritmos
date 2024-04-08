package com.example.pd8;

import com.example.pd8.interfaces.ISucursal;

public class Sucursal implements ISucursal {

    private Comparable ciudad;

    public Sucursal(
        Comparable ciudad
    ) {
        this.ciudad = ciudad;
    }

    public Comparable getSucursal(){
        return this.ciudad;
    }

    public void setSucursal(Comparable ciudad){
        this.ciudad = ciudad;
    }

    public String toString(){
        return "La ciudad se encuentra en: " + this.ciudad;
    }

}
