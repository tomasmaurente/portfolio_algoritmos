package com.example;

public class Alumno<T> {

    public final Comparable cedula;
    public String nombre;

    public Alumno(Comparable cedula, String nombre ) {
        this.cedula = cedula;
        this.nombre = nombre;
    }


}
