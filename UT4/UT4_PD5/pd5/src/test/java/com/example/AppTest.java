package com.example;

import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

public class AppTest {
    String[] claves = null;
    TArbolBB<TElementoAB> arbol = null;
    ArrayList<Comparable> etiquetas = null;

    @Before
    public void setUp() {
        ManejadorArchivosGenerico lector = new ManejadorArchivosGenerico();
        claves = lector.leerArchivo(
                "C:\\Users\\Tomas\\Desktop\\Algoritmos\\portfolio_algoritmos\\UT4\\UT4_PD5\\pd5\\src\\main\\java\\com\\example\\claves\\clavesPrueba.txt");

        arbol = new TArbolBB<TElementoAB>();
        etiquetas = new ArrayList<Comparable>(12);
        Comparable etiqueta = null;
        for (String clave : claves) {
            etiqueta = Integer.parseInt(clave);
            etiquetas.add(etiqueta);
            TElementoAB e = new TElementoAB<String>(etiqueta, clave);
            arbol.insertar(e);
        }
    }

    @Test
    public void etiquetaMenorEnArbolComplejo() {
        TElementoAB aux = arbol.menorClave();
        assertTrue(aux.getDatos().toString().equals("1342"));
        arbol.eliminar(aux.getEtiqueta());
        aux = arbol.menorClave();
        assertTrue(aux.getDatos().toString().equals("1383"));
    }

    @Test
    public void etiquetaMenorEnArbolSoloConHijosIzquierdos() {
        arbol.vaciar();
        for (int clave = 10; clave > 0; clave--) {
            Comparable etiqueta = clave;
            etiquetas.add(etiqueta);
            TElementoAB e = new TElementoAB<Integer>(etiqueta, clave);
            arbol.insertar(e);
        }
        TElementoAB aux = arbol.menorClave();
        assertTrue(aux.getDatos().toString().equals("1"));
        arbol.eliminar(aux.getEtiqueta());
        aux = arbol.menorClave();
        assertTrue(aux.getDatos().toString().equals("2"));
    }

    @Test
    public void etiquetaMenorEnArbolSoloConHijosDerechos() {
        arbol.vaciar();
        for (int clave = 0; clave < 10; clave++) {
            Comparable etiqueta = clave;
            etiquetas.add(etiqueta);
            TElementoAB e = new TElementoAB<Integer>(etiqueta, clave);
            arbol.insertar(e);
        }
        TElementoAB aux = arbol.menorClave();
        assertTrue(aux.getDatos().toString().equals("0"));
        arbol.eliminar(aux.getEtiqueta());
        aux = arbol.menorClave();
        assertTrue(aux.getDatos().toString().equals("1"));
    }

    @Test
    public void etiquetaMenorEnArbolVacioDebeDevolverNull() {
        arbol.vaciar();
        TElementoAB aux = arbol.menorClave();
        assertTrue(aux == null);
    }

    /*
     * Mayor clave
     */

    @Test
    public void etiquetaMayorEnArbolComplejo() {
        TElementoAB aux = arbol.mayorClave();
        assertTrue(aux.getDatos().toString().equals("10996"));
        arbol.eliminar(aux.getEtiqueta());
        aux = arbol.mayorClave();
        assertTrue(aux.getDatos().toString().equals("10903"));
    }

    @Test
    public void etiquetaMayorEnArbolSoloConHijosIzquierdos() {
        arbol.vaciar();
        for (int clave = 10; clave > 0; clave--) {
            Comparable etiqueta = clave;
            etiquetas.add(etiqueta);
            TElementoAB e = new TElementoAB<Integer>(etiqueta, clave);
            arbol.insertar(e);
        }
        TElementoAB aux = arbol.mayorClave();
        assertTrue(aux.getDatos().toString().equals("10"));
        arbol.eliminar(aux.getEtiqueta());
        aux = arbol.mayorClave();
        assertTrue(aux.getDatos().toString().equals("9"));
    }

    @Test
    public void etiquetaMayorEnArbolSoloConHijosDerechos() {
        arbol.vaciar();
        for (int clave = 0; clave < 10; clave++) {
            Comparable etiqueta = clave;
            etiquetas.add(etiqueta);
            TElementoAB e = new TElementoAB<Integer>(etiqueta, clave);
            arbol.insertar(e);
        }
        TElementoAB aux = arbol.mayorClave();
        assertTrue(aux.getDatos().toString().equals("9"));
        arbol.eliminar(aux.getEtiqueta());
        aux = arbol.mayorClave();
        assertTrue(aux.getDatos().toString().equals("8"));
    }

    @Test
    public void etiquetaMayorEnArbolVacioDebeDevolverNull() {
        arbol.vaciar();
        TElementoAB aux = arbol.mayorClave();
        assertTrue(aux == null);
    }

    /*
     * Obtener la cantidad de nodos de un nivel dado
     */

    @Test
    public void devuelveCantidadDeNodosDeUnNivel() {
        arbol.vaciar();
        int clave = 0;
        Comparable etiqueta = 6;
        TElementoAB e = new TElementoAB<Integer>(etiqueta, clave);
        arbol.insertar(e);
        etiqueta = 4;
        e = new TElementoAB<Integer>(etiqueta, clave);
        arbol.insertar(e);
        etiqueta = 8;
        e = new TElementoAB<Integer>(etiqueta, clave);
        arbol.insertar(e);
        etiqueta = 3;
        e = new TElementoAB<Integer>(etiqueta, clave);
        arbol.insertar(e);
        etiqueta = 5;
        e = new TElementoAB<Integer>(etiqueta, clave);
        arbol.insertar(e);
        etiqueta = 7;
        e = new TElementoAB<Integer>(etiqueta, clave);
        arbol.insertar(e);
        etiqueta = 9;
        e = new TElementoAB<Integer>(etiqueta, clave);
        arbol.insertar(e);

        assertTrue(arbol.cantNodosNivel(1) == 1);
        assertTrue(arbol.cantNodosNivel(2) == 2);
        assertTrue(arbol.cantNodosNivel(3) == 4);
    }

    @Test
    public void obtenerNodosNivelDevuelveNuloSiArbolEsVacio() {
        arbol.vaciar();
        Integer aux = arbol.cantNodosNivel(1);
        assertTrue(aux == null);
    }

    /*
     * Listas las hojas del arbol
     */

    @Test
    public void listarHojasDevuelveTodosLosNodos() {
        arbol.vaciar();
        int clave = 0;
        Comparable etiqueta = 6;
        TElementoAB e = new TElementoAB<Integer>(etiqueta, clave);
        arbol.insertar(e);
        etiqueta = 4;
        e = new TElementoAB<Integer>(etiqueta, clave);
        arbol.insertar(e);
        etiqueta = 8;
        e = new TElementoAB<Integer>(etiqueta, clave);
        arbol.insertar(e);
        etiqueta = 3;
        e = new TElementoAB<Integer>(etiqueta, clave);
        arbol.insertar(e);
        etiqueta = 5;
        e = new TElementoAB<Integer>(etiqueta, clave);
        arbol.insertar(e);
        etiqueta = 7;
        e = new TElementoAB<Integer>(etiqueta, clave);
        arbol.insertar(e);
        etiqueta = 9;
        e = new TElementoAB<Integer>(etiqueta, clave);
        arbol.insertar(e);

        ArrayList<TElementoAB<TElementoAB>> lista = arbol.listarHojas();
        assertTrue(lista.size() == 4);
    }

    /*
     * Verificar si el arbol es de busqueda
     */

    @Test
    public void VerificarArbolDeBusqueda() {
        arbol.vaciar();
        int clave = 0;
        Comparable etiqueta = 6;
        TElementoAB e = new TElementoAB<Integer>(etiqueta, clave);
        arbol.insertar(e);
        etiqueta = 4;
        e = new TElementoAB<Integer>(etiqueta, clave);
        arbol.insertar(e);
        etiqueta = 8;
        e = new TElementoAB<Integer>(etiqueta, clave);
        arbol.insertar(e);
        etiqueta = 3;
        e = new TElementoAB<Integer>(etiqueta, clave);
        arbol.insertar(e);
        etiqueta = 5;
        e = new TElementoAB<Integer>(etiqueta, clave);
        arbol.insertar(e);
        etiqueta = 7;
        e = new TElementoAB<Integer>(etiqueta, clave);
        arbol.insertar(e);
        etiqueta = 9;
        e = new TElementoAB<Integer>(etiqueta, clave);
        arbol.insertar(e);

        ArrayList<TElementoAB<TElementoAB>> lista = arbol.listarHojas();
        assertTrue(lista.size() == 4 && arbol.esDeBusqueda());
    }

    @Test
    public void VerificarArbolDeBusquedaDevuelveNullSiArbolVacio() {
        arbol.vaciar();
        assertTrue(arbol.esDeBusqueda() == null);
    }

    /*
     * Clave anterior
     */

    @Test
    public void claveAnteriorDevuelveCorrectamente() {
        TElementoAB aux = arbol.calveAnterior(claves[0]);
        assertTrue(aux.getEtiqueta().toString().equals("4734"));
        arbol.eliminar(aux.getEtiqueta());
        aux = arbol.calveAnterior(aux.getEtiqueta());
        assertTrue(aux.getDatos().toString().equals("4345"));
    }

    @Test
    public void claveAnteriorDevuelveNullSiVacio() {
        arbol.vaciar();
        TElementoAB aux = arbol.calveAnterior(etiquetas.get(0));
        assertTrue(aux == null);
    }

    @Test
    public void claveAnteriorDevuelveNuloSiNoHayClavesMenores() {
        TElementoAB aux = arbol.calveAnterior(etiquetas.get(5));
        assertTrue(aux == null);
    }

    @Test
    public void claveAnteriorDevuelveElMayorNodoSiClaveMayorATodosLosNodos() {
        Comparable e = 10000000;
        TElementoAB aux = arbol.calveAnterior(e);
        assertTrue(aux.getEtiqueta().compareTo(10996) == 0);
    }

}
