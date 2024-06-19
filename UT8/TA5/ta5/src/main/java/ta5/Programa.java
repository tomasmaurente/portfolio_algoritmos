package ta5;

import ta5.grafos.TGrafoNoDirigido;

public class Programa {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // cargar grafo con actores y relaciones
        String actores    = "C:\\Users\\tomma\\OneDrive\\Escritorio\\Algoritmos\\portfolio_algoritmos\\UT8\\TA5\\ta5\\src\\main\\java\\ta5\\contenido\\actores.csv";
        String relaciones = "C:\\Users\\tomma\\OneDrive\\Escritorio\\Algoritmos\\portfolio_algoritmos\\UT8\\TA5\\ta5\\src\\main\\java\\ta5\\contenido\\en_pelicula.csv";
        
        TGrafoNoDirigido ola = UtilGrafos.cargarGrafo(actores, relaciones, false, TGrafoNoDirigido.class);

        // invocar a numBacon como indica la letra y mostrar en consola el resultado

        

    }

}
