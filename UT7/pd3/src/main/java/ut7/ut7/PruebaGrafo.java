package ut7.ut7;

import java.util.Collection;

import ut7.ut7.grafoDirigido.TGrafoDirigido;
import ut7.ut7.grafoDirigido.UtilGrafos;
import ut7.ut7.utils.TCaminos;

public class PruebaGrafo {

    public static void main(String[] args) {
        TGrafoDirigido gd = (TGrafoDirigido) UtilGrafos.cargarGrafo(
            "pd3\\src\\main\\java\\ut7\\ut7\\utils\\aeropuertos.txt",
            "pd3\\src\\main\\java\\ut7\\ut7\\utils\\conexiones.txt",
                false, TGrafoDirigido.class);

        Object[] etiquetasarray = gd.getEtiquetasOrdenado();

        Double[][] matriz = UtilGrafos.obtenerMatrizCostos(gd.getVertices());
        UtilGrafos.imprimirMatrizMejorado(matriz, gd.getVertices(), "Grafo aerolineas");
        
        Double[][] mfloyd = gd.floyd();
        UtilGrafos.imprimirMatrizMejorado(mfloyd, gd.getVertices(), "Grafo de conexiones de menor costo");

        /*
        1. El costo de volar de Montevideo a Rio de Janeiro es: 
                a. 1980. 
                b. 3780.    Respuesta correcta
                c. 1000. 
                d. 980. 
        2. El costo de volar de Montevideo a Curitiba es: 
                a. 2580     Respuesta correcta
                b. 3780. 
                c. 1980. 
                d. Ninguna de las anteriores. 
        3. Los servicios de mantenimiento se instalan en:  No entedi la pregunta
                a. Montevideo 
                b. Punta del Este 
                c. Curitiba 
                d. Porto Alegre 
        
        
        1. Utiliza  el  algoritmo  de  búsqueda  en  profundidad  para implementar un método en el TDA grafo (“bpf”), que 
                realice  el  recorrido  exhaustivo  del  grafo  del  Ejercicio  1,  mostrando  en  consola  las  etiquetas  de  los  vértices 
                visitados, en el orden en que se visitan.  

        2. ¿Cuál es el orden del tiempo de ejecución de este algoritmo? 
                Lineal

        3. Ejecutando el algoritmo a partir del vértice “Montevideo”, muestra por consola todos los vértices visitados. ¿Se 
            han  visitado  todos  los  vértices  del  grafo?  Si  no  es  así,  ¿cómo  harías  para  que,  usando  el  mismo  método,  se 
            complete la visita de los vértices que aún no han sido visitados? 

            chequearia que todos los vertices que estan en la lista de vertices de la clase Grafo esten en la lista de la busueda BPF
*/
        Collection<Comparable> verticesVisitadosDesdeMtvd = gd.bpf("Montevideo");
        for (Comparable vertice : verticesVisitadosDesdeMtvd) {
            System.out.println(vertice);
        }


/*
        4. ¿Cómo  harías  para,  dado  un  cierto  vértice  origen,  obtener  todos  posibles  desde  ese  vértice  hasta  un  cierto 
            vértice  destino?  Procura  desarrollar  un  algoritmo  que  haga  esto.    Usando  este  algoritmo  sobre  el  grafo  del 
            Ejercicio 1, ¿cuáles serían todos los itinerarios posibles para ir desde Montevideo hasta Rio de Janeiro? 
 */
        TCaminos caminosDeMtvdARio = gd.todosLosCaminos("Montevideo", "Rio_de_Janeiro");
        System.out.println(caminosDeMtvdARio.imprimirCaminos());
    }
}
