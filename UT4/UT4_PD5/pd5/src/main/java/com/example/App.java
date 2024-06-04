package com.example;

import java.util.ArrayList;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ManejadorArchivosGenerico lector = new ManejadorArchivosGenerico();
        String[] claves = lector.leerArchivo("C:\\Users\\Tomas\\Desktop\\Algoritmos\\portfolio_algoritmos\\UT4\\UT4_PD5\\pd5\\src\\main\\java\\com\\example\\claves\\clavesPrueba.txt");
        
        TArbolBB<TElementoAB> arbol = new TArbolBB<TElementoAB>();
        ArrayList<Comparable> etiquetas = new ArrayList<Comparable>(12);
        Comparable etiqueta = null;
        for (String clave : claves) {
            etiqueta = Integer.parseInt(clave);
            etiquetas.add(etiqueta);
            TElementoAB e = new TElementoAB<String>(etiqueta, clave);
            arbol.insertar(e);
        }

        System.out.println(arbol.esDeBusqueda());
        System.out.println(arbol.inOrden());
        for (Comparable comparable : etiquetas) {
            System.out.println("La clave a eliminar es: " + comparable.toString());
            arbol.eliminar(comparable);
            System.out.println(arbol.esDeBusqueda());
            System.out.println(arbol.inOrden());
        }

        System.out.println();
        System.out.println();

        for (Comparable comparable : etiquetas) {
            TElementoAB e = new TElementoAB<String>(comparable, comparable.toString());
            arbol.insertar(e);
        }       
    
    }
}
