
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.edu.ucu.aed;

/**
 *
 * @author jechague
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Buscar en la tabla creada anteriormente las claves indicadas en el archivo "claves_buscar.txt"
        String[] busquedas = ManejadorArchivosGenerico.leerArchivo("C:\\Users\\Tomas\\Desktop\\Algoritmos\\portfolio_algoritmos\\UT6\\PD2\\UT6_TA1-main\\UT6_TA1-main\\UT6_TA1-main\\src\\main\\java\\uy\\edu\\ucu\\aed\\claves_buscar.txt");
        
        // Crear una tabla de tipo THash e insertar las claves del archivo "claves_insertar.txt"
        THash tabla = new THash();
        String[] inserciones = ManejadorArchivosGenerico.leerArchivo("C:\\Users\\Tomas\\Desktop\\Algoritmos\\portfolio_algoritmos\\UT6\\PD2\\UT6_TA1-main\\UT6_TA1-main\\UT6_TA1-main\\src\\main\\java\\uy\\edu\\ucu\\aed\\claves_insertar.txt");
        Boolean primero = true;
        Double cIterParaInsertar = 0.0;
        for (String clave : inserciones) {
            cIterParaInsertar += tabla.insertarConTamanoFijo(Integer.parseInt(clave),283, primero);
            primero = false;
        }

        Double intentosFallidos = 0.0;
        Double intenosExitosos  = 0.0;
        int contadorExitosos = 0;
        for (String clave : busquedas) {
            int intentos = tabla.buscar(Integer.parseInt(clave));
            if (intentos < 0) {
                intentosFallidos += intentos;
            } else {
                intenosExitosos += intentos;
                contadorExitosos++;
            }
        }

        Double promedio = cIterParaInsertar / 200;
        Double promedioBusquedaFallida = -intentosFallidos / (200 - contadorExitosos);
        Double promedioBusqiedasExitosas = intenosExitosos / contadorExitosos;
        System.out.println("el promedio de iteraciones en las inserciones ocupando el 70% de espacio es: " + promedio);
        System.out.println("el promedio de busquedas fallidas es: " + promedioBusquedaFallida);
        System.out.println("el promedio de busquedas exitosas es: " + promedioBusqiedasExitosas);
        System.out.println();

        tabla = new THash();
        primero = true;
        cIterParaInsertar = 0.0;
        for (String clave : inserciones) {
            cIterParaInsertar += tabla.insertarConTamanoFijo(Integer.parseInt(clave),266, primero);
            primero = false;
        }
        promedio = cIterParaInsertar / 200;

        intentosFallidos = 0.0;
        intenosExitosos  = 0.0;
        contadorExitosos = 0;
        for (String clave : busquedas) {
            int intentos = tabla.buscar(Integer.parseInt(clave));
            if (intentos < 0) {
                intentosFallidos += intentos;
            } else {
                intenosExitosos += intentos;
                contadorExitosos++;
            }
        }

        promedio = cIterParaInsertar / 200;
        promedioBusquedaFallida = -intentosFallidos / (200 - contadorExitosos);
        promedioBusqiedasExitosas = intenosExitosos / contadorExitosos;
        System.out.println("el promedio de iteraciones en las inserciones ocupando el 75% de espacio es: " + promedio);
        System.out.println("el promedio de busquedas fallidas es: " + promedioBusquedaFallida);
        System.out.println("el promedio de busquedas exitosas es: " + promedioBusqiedasExitosas);
        System.out.println();
        


        tabla = new THash();
        primero = true;
        cIterParaInsertar = 0.0;
        for (String clave : inserciones) {
            cIterParaInsertar += tabla.insertarConTamanoFijo(Integer.parseInt(clave),250, primero);
            primero = false;
        }
        promedio = cIterParaInsertar / 200;
        intentosFallidos = 0.0;
        intenosExitosos  = 0.0;
        contadorExitosos = 0;
        for (String clave : busquedas) {
            int intentos = tabla.buscar(Integer.parseInt(clave));
            if (intentos < 0) {
                intentosFallidos += intentos;
            } else {
                intenosExitosos += intentos;
                contadorExitosos++;
            }
        }

        promedio = cIterParaInsertar / 200;
        promedioBusquedaFallida = -intentosFallidos / (200 - contadorExitosos);
        promedioBusqiedasExitosas = intenosExitosos / contadorExitosos;
        System.out.println("el promedio de iteraciones en las inserciones ocupando el 80% de espacio es: " + promedio);
        System.out.println("el promedio de busquedas fallidas es: " + promedioBusquedaFallida);
        System.out.println("el promedio de busquedas exitosas es: " + promedioBusqiedasExitosas);
        System.out.println();
        

        tabla = new THash();
        primero = true;
        cIterParaInsertar = 0.0;
        for (String clave : inserciones) {
            cIterParaInsertar += tabla.insertarConTamanoFijo(Integer.parseInt(clave),235, primero);
            primero = false;
        }
        promedio = cIterParaInsertar / 200;
        intentosFallidos = 0.0;
        intenosExitosos  = 0.0;
        contadorExitosos = 0;
        for (String clave : busquedas) {
            int intentos = tabla.buscar(Integer.parseInt(clave));
            if (intentos < 0) {
                intentosFallidos += intentos;
            } else {
                intenosExitosos += intentos;
                contadorExitosos++;
            }
        }

        promedio = cIterParaInsertar / 200;
        promedioBusquedaFallida = -intentosFallidos / (200 - contadorExitosos);
        promedioBusqiedasExitosas = intenosExitosos / contadorExitosos;
        System.out.println("el promedio de iteraciones en las inserciones ocupando el 85% de espacio es: " + promedio);
        System.out.println("el promedio de busquedas fallidas es: " + promedioBusquedaFallida);
        System.out.println("el promedio de busquedas exitosas es: " + promedioBusqiedasExitosas);
        System.out.println();
        

        tabla = new THash();
        primero = true;
        cIterParaInsertar = 0.0;
        for (String clave : inserciones) {
            cIterParaInsertar += tabla.insertarConTamanoFijo(Integer.parseInt(clave),222, primero);
            primero = false;
        }
        promedio = cIterParaInsertar / 200;
        intentosFallidos = 0.0;
        intenosExitosos  = 0.0;
        contadorExitosos = 0;
        for (String clave : busquedas) {
            int intentos = tabla.buscar(Integer.parseInt(clave));
            if (intentos < 0) {
                intentosFallidos += intentos;
            } else {
                intenosExitosos += intentos;
                contadorExitosos++;
            }
        }

        promedio = cIterParaInsertar / 200;
        promedioBusquedaFallida = -intentosFallidos / (200 - contadorExitosos);
        promedioBusqiedasExitosas = intenosExitosos / contadorExitosos;
        System.out.println("el promedio de iteraciones en las inserciones ocupando el 90% de espacio es: " + promedio);
        System.out.println("el promedio de busquedas fallidas es: " + promedioBusquedaFallida);
        System.out.println("el promedio de busquedas exitosas es: " + promedioBusqiedasExitosas);
        System.out.println();
        
        
        tabla = new THash();
        primero = true;
        cIterParaInsertar = 0.0;
        for (String clave : inserciones) {
            cIterParaInsertar += tabla.insertarConTamanoFijo(Integer.parseInt(clave),217, primero);
            primero = false;
        }
        promedio = cIterParaInsertar / 200;
        intentosFallidos = 0.0;
        intenosExitosos  = 0.0;
        contadorExitosos = 0;
        for (String clave : busquedas) {
            int intentos = tabla.buscar(Integer.parseInt(clave));
            if (intentos < 0) {
                intentosFallidos += intentos;
            } else {
                intenosExitosos += intentos;
                contadorExitosos++;
            }
        }

        promedio = cIterParaInsertar / 200;
        promedioBusquedaFallida = -intentosFallidos / (200 - contadorExitosos);
        promedioBusqiedasExitosas = intenosExitosos / contadorExitosos;
        System.out.println("el promedio de iteraciones en las inserciones ocupando el 92% de espacio es: " + promedio);
        System.out.println("el promedio de busquedas fallidas es: " + promedioBusquedaFallida);
        System.out.println("el promedio de busquedas exitosas es: " + promedioBusqiedasExitosas);
        System.out.println();
        
        
        tabla = new THash();
        primero = true;
        cIterParaInsertar = 0.0;
        for (String clave : inserciones) {
            cIterParaInsertar += tabla.insertarConTamanoFijo(Integer.parseInt(clave),212, primero);
            primero = false;
        }
        promedio = cIterParaInsertar / 200;
        intentosFallidos = 0.0;
        intenosExitosos  = 0.0;
        contadorExitosos = 0;
        for (String clave : busquedas) {
            int intentos = tabla.buscar(Integer.parseInt(clave));
            if (intentos < 0) {
                intentosFallidos += intentos;
            } else {
                intenosExitosos += intentos;
                contadorExitosos++;
            }
        }

        promedio = cIterParaInsertar / 200;
        promedioBusquedaFallida = -intentosFallidos / (200 - contadorExitosos);
        promedioBusqiedasExitosas = intenosExitosos / contadorExitosos;
        System.out.println("el promedio de iteraciones en las inserciones ocupando el 94% de espacio es: " + promedio);
        System.out.println("el promedio de busquedas fallidas es: " + promedioBusquedaFallida);
        System.out.println("el promedio de busquedas exitosas es: " + promedioBusqiedasExitosas);
        System.out.println();
        
        

        tabla = new THash();
        primero = true;
        cIterParaInsertar = 0.0;
        for (String clave : inserciones) {
            cIterParaInsertar += tabla.insertarConTamanoFijo(Integer.parseInt(clave),208, primero);
            primero = false;
        }
        promedio = cIterParaInsertar / 200;
        intentosFallidos = 0.0;
        intenosExitosos  = 0.0;
        contadorExitosos = 0;
        for (String clave : busquedas) {
            int intentos = tabla.buscar(Integer.parseInt(clave));
            if (intentos < 0) {
                intentosFallidos += intentos;
            } else {
                intenosExitosos += intentos;
                contadorExitosos++;
            }
        }

        promedio = cIterParaInsertar / 200;
        promedioBusquedaFallida = -intentosFallidos / (200 - contadorExitosos);
        promedioBusqiedasExitosas = intenosExitosos / contadorExitosos;
        System.out.println("el promedio de iteraciones en las inserciones ocupando el 96% de espacio es: " + promedio);
        System.out.println("el promedio de busquedas fallidas es: " + promedioBusquedaFallida);
        System.out.println("el promedio de busquedas exitosas es: " + promedioBusqiedasExitosas);
        System.out.println();        
        

        tabla = new THash();
        primero = true;
        cIterParaInsertar = 0.0;
        for (String clave : inserciones) {
            cIterParaInsertar += tabla.insertarConTamanoFijo(Integer.parseInt(clave),204, primero);
            primero = false;
        }
        promedio = cIterParaInsertar / 200;
        intentosFallidos = 0.0;
        intenosExitosos  = 0.0;
        contadorExitosos = 0;
        for (String clave : busquedas) {
            int intentos = tabla.buscar(Integer.parseInt(clave));
            if (intentos < 0) {
                intentosFallidos += intentos;
            } else {
                intenosExitosos += intentos;
                contadorExitosos++;
            }
        }

        promedio = cIterParaInsertar / 200;
        promedioBusquedaFallida = -intentosFallidos / (200 - contadorExitosos);
        promedioBusqiedasExitosas = intenosExitosos / contadorExitosos;
        System.out.println("el promedio de iteraciones en las inserciones ocupando el 98% de espacio es: " + promedio);
        System.out.println("el promedio de busquedas fallidas es: " + promedioBusquedaFallida);
        System.out.println("el promedio de busquedas exitosas es: " + promedioBusqiedasExitosas);
        System.out.println();        
        

        tabla = new THash();
        primero = true;
        cIterParaInsertar = 0.0;
        for (String clave : inserciones) {
            cIterParaInsertar += tabla.insertarConTamanoFijo(Integer.parseInt(clave),202, primero);
            primero = false;
        }
        promedio = cIterParaInsertar / 200;
        intentosFallidos = 0.0;
        intenosExitosos  = 0.0;
        contadorExitosos = 0;
        for (String clave : busquedas) {
            int intentos = tabla.buscar(Integer.parseInt(clave));
            if (intentos < 0) {
                intentosFallidos += intentos;
            } else {
                intenosExitosos += intentos;
                contadorExitosos++;
            }
        }

        promedio = cIterParaInsertar / 200;
        promedioBusquedaFallida = -intentosFallidos / (200 - contadorExitosos);
        promedioBusqiedasExitosas = intenosExitosos / contadorExitosos;
        System.out.println("el promedio de iteraciones en las inserciones ocupando el 99% de espacio es: " + promedio);
        System.out.println("el promedio de busquedas fallidas es: " + promedioBusquedaFallida);
        System.out.println("el promedio de busquedas exitosas es: " + promedioBusqiedasExitosas);
        System.out.println();        
    }
    
}
