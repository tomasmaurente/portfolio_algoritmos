package com.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import com.example.trie.TArbolTrie;

/**
 * Hello world!
 *
 */
public class App 
{
    public static Map<String, String> intercambiarClavesYValores(Map<String, String> mapa) throws IllegalArgumentException {
        Map<String, String> nuevoMapa = new HashMap<>();
        for (Map.Entry<String, String> entry : mapa.entrySet()) {
            if (nuevoMapa.containsValue(entry.getValue())) {
                throw new IllegalArgumentException("El valor '" + entry.getValue() + "' está duplicado en el mapa original.");
            }
            nuevoMapa.put(entry.getValue(), entry.getKey());
        }
        return nuevoMapa;
    }

    public static void main( String[] args )
    {
        /*
         * Escribe, en el menor número de líneas de código posible, una funcionalidad que elimine todas las entradas de un
            Map cuyo valor sea null.
        */

        Map<String, Integer> map = new HashMap<>();
        map.put("a", 1);
        map.put("b", null);
        map.put("c", 3);
        System.out.println(map.size());

        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
            if (entry.getValue() == null) {
                iterator.remove();
            }
        }
        System.out.println(map.size());


        /*
         * Escribe un método que tome como parámetro un Map<String.String> y devuelva un nuevo Map<String.String> en el
            que las claves y los valores estén intercambiados. Genera una excepción si hay valores duplicados en el mapa que se
            pasa como parámetro
         */

        Map<String, String> mapaOriginal = new HashMap<>();
        mapaOriginal.put("uno", "1");
        mapaOriginal.put("dos", "2");
        mapaOriginal.put("tres", "3");

        try {
            Map<String, String> mapaIntercambiado = intercambiarClavesYValores(mapaOriginal);
            System.out.println("Mapa Original: " + mapaOriginal);
            System.out.println("Mapa Intercambiado: " + mapaIntercambiado);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }


        /*
         * Escribe un programa que lea cadenas de caracteres de entrada y las imprima ordenadas según su longitud,
            comenzando por la más corta. Si hay varias cadenas con la misma longitud, éstas deben imprimirse en orden
            lexicográfico.
        */
        TArbolTrie trie = new TArbolTrie();
        String[] palabras = ManejadorArchivosGenerico.leerArchivo("C:\\Users\\Tomas\\Desktop\\Algoritmos\\portfolio_algoritmos\\UT6\\PD3\\pd3\\src\\main\\java\\com\\example\\trie\\palabras.txt");
        for (String p : palabras){
            trie.insertar(p);
        }
        trie.imprimir();





        if (args.length != 2) {
            System.err.println("Uso: java Main archivo.txt lineas_a_imprimir");
            System.exit(1);
        }

        String filename = args[0];
        int numLinesToPrint = Integer.parseInt(args[1]);

        List<String> lines = new ArrayList<>();
        
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
            System.exit(1);
        }

        Random random = new Random();
        Set<Integer> printedIndexes = new HashSet<>();
        int numLinesInFile = lines.size();
        int maxIndex = numLinesInFile - 1;

        if (numLinesToPrint > numLinesInFile) {
            System.out.println("El archivo contiene menos líneas de las que se quieren imprimir.");
            System.exit(1);
        }

        System.out.println("Líneas aleatorias del archivo:");
        for (int i = 0; i < numLinesToPrint; i++) {
            int randomIndex;
            do {
                randomIndex = random.nextInt(maxIndex + 1);
            } while (printedIndexes.contains(randomIndex));
            System.out.println(lines.get(randomIndex));
            printedIndexes.add(randomIndex);
        }

    }
}
