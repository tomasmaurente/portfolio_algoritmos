package com.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Conjunto aed = new Conjunto<>();
        Conjunto pf  = new Conjunto<>();

        for (int i = 0 ; i < 5; i++){
            Alumno a = new Alumno<>(i,String.valueOf(i));
            aed.insertar(i, a);
        }

        for (int i = 4 ; i < 9; i++){
            Alumno a = new Alumno<>(i,String.valueOf(i));
            pf.insertar(i, a);
        }

        System.out.println(aed.imprimir(" | "));

        System.out.println(pf.imprimir(" | "));

        System.out.println(aed.union(pf).imprimir(" | "));

        System.out.println(aed.interseccion(pf).imprimir(" | "));
    }
}
