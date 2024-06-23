package pd8;

import java.util.LinkedList;

import pd8.grafoDirigido.TArista;
import pd8.grafoDirigido.TGrafoDirigido;
import pd8.grafoDirigido.UtilGrafos;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        TGrafoDirigido grafo = (TGrafoDirigido) UtilGrafos.cargarGrafo(
                "UT7\\pd8\\src\\main\\java\\pd8\\utils\\aeropuertos_2.txt",
                 "UT7\\pd8\\src\\main\\java\\pd8\\utils\\conexiones_2.txt",
                false, TGrafoDirigido.class);

        LinkedList<TArista> arcosArbol = new LinkedList<>();
        LinkedList<TArista> arcosRetroceso = new LinkedList<>();
        LinkedList<TArista> arcosAvance = new LinkedList<>();
        LinkedList<TArista> arcosCruzados = new LinkedList<>();

        grafo.clasificarArcos("Montevideo", arcosArbol, arcosRetroceso, arcosAvance, arcosCruzados);

        System.out.println("Arcos de Arbol desde Montevideo");
        for (TArista tArista : arcosArbol) {
            System.out.println("vuelo desde: " + tArista.getEtiquetaOrigen() + ", hasta: " + tArista.getEtiquetaDestino());
        }
        System.out.println();

        System.out.println("Arcos de Retroceso desde Montevideo");
        for (TArista tArista : arcosRetroceso) {
            System.out.println("vuelo desde: " + tArista.getEtiquetaOrigen() + ", hasta: " + tArista.getEtiquetaDestino());
        }
        System.out.println();

        System.out.println("Arcos de Avance desde Montevideo");
        for (TArista tArista : arcosAvance) {
            System.out.println("vuelo desde: " + tArista.getEtiquetaOrigen() + ", hasta: " + tArista.getEtiquetaDestino());
        }
        System.out.println();

        System.out.println("Arcos Cruzados desde Montevideo");
        for (TArista tArista : arcosCruzados) {
            System.out.println("vuelo desde: " + tArista.getEtiquetaOrigen() + ", hasta: " + tArista.getEtiquetaDestino());
        }
        System.out.println();
    }
}
