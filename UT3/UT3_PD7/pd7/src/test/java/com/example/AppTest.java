package com.example;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.example.interfaces.INodo;

public class AppTest 
{

    @Test
    public void uneYintersifica()
    {
        Conjunto aed = new Conjunto<Nodo>();
        Conjunto pf  = new Conjunto<Nodo>();

        for (int i = 0 ; i < 5; i++){
            Alumno a = new Alumno<>(i,String.valueOf(i));
            aed.insertar(i, a);
        }

        for (int i = 4 ; i < 9; i++){
            Alumno a = new Alumno<>(i,String.valueOf(i));
            pf.insertar(i, a);
        }

        Conjunto<Nodo> union = (Conjunto<Nodo>) aed.union(pf);
        int tamano = union.cantElementos();
        assert(tamano == 9);

        Conjunto<Nodo> interseccion = (Conjunto<Nodo>) aed.interseccion(pf);
        tamano = interseccion.cantElementos();
        assert(tamano == 1);
    }

    @Test
    public void lista1esVacia()
    {
        Conjunto aed = new Conjunto<>();
        Conjunto pf  = new Conjunto<>();

        for (int i = 4 ; i < 9; i++){
            Alumno a = new Alumno<>(i,String.valueOf(i));
            pf.insertar(i, a);
        }

        Conjunto<Nodo> union =  (Conjunto<Nodo>) aed.union(pf);
        assert(union.cantElementos() == 5);

        Conjunto<Nodo> interseccion =  (Conjunto<Nodo>) aed.interseccion(pf);
        assert(interseccion.cantElementos() == 0);
    }

    @Test
    public void ambasListasSonVacias()
    {
        Conjunto aed = new Conjunto<>();
        Conjunto pf  = new Conjunto<>();

        Conjunto<Nodo> union = (Conjunto<Nodo>) aed.union(pf);
        assert(union.cantElementos() == 0);

        Conjunto<Nodo> interseccion = (Conjunto<Nodo>) aed.interseccion(pf);
        assert(interseccion.cantElementos() == 0);
    }

    @Test
    public void utilizaBienLosObjetos()
    {
        Conjunto<Alumno> aed = new Conjunto<Alumno>();
        Conjunto<Alumno> pf  = new Conjunto<>();

        for (int i = 0 ; i < 6; i++){
            Alumno a = new Alumno(i,String.valueOf(i));
            aed.insertar(i, a);
        }

        for (int i = 4 ; i < 9; i++){
            Alumno a = new Alumno<>(i,String.valueOf(i));
            pf.insertar(i, a);
        }

        Conjunto<Alumno> union = aed.union(pf);
        union.buscar(8).getDato().nombre = "ola";
        Alumno x = pf.buscar(8).getDato();
        assert(x.nombre.compareTo("ola") == 0);


        Conjunto<Alumno> interseccion = aed.interseccion(pf);
        interseccion.buscar(5).getDato().nombre = "ola";
        Alumno y = aed.buscar(5).getDato();
        assert(y.nombre.compareTo("ola") == 0);

    }
}
