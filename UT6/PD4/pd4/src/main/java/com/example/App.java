package com.example;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * Las 10 palabras con más ocurrencias son:

        banana: 7 páginas (2, 45, 67, 89, 101, 120, 134)
        fresa: 6 páginas (6, 18, 30, 42, 54, 66)
        papaya: 7 páginas (6, 19, 31, 43, 55, 67, 79)
        piña: 7 páginas (12, 24, 36, 48, 60, 72, 84)
        uva_pasa: 6 páginas (3, 13, 23, 33, 43, 53, 63)
        aguacate: 6 páginas (8, 18, 28, 38, 48, 58)
        mirabel: 7 páginas (9, 21, 33, 45, 57, 69, 81)
        manzanilla: 5 páginas (12, 24, 36, 48, 60)
        fruta_del_dragon: 4 páginas (6, 18, 30, 42)
        kiwi: 3 páginas (1, 13, 25)
 
 */
public class App 
{
    public static void main( String[] args )
    {
        String[] words = ManejadorArchivosGenerico.leerArchivo("C:\\Users\\tomma\\OneDrive\\Escritorio\\Algoritmos\\portfolio_algoritmos\\UT6\\PD4\\pd4\\src\\main\\java\\com\\example\\palabras.txt");
        Dictionary dictionary = new Dictionary(); 
        String[] splitString = null;

        for (String s : words){
            splitString = s.split(",");
            String w = splitString[0];
            Integer p = Integer.parseInt(splitString[1]);
            Word word = new Word(w,p);
            if (splitString.length > 1){
                for(int i = 2 ; i < splitString.length ; i++){
                    p = Integer.parseInt(splitString[i]);
                    word.updatePages(p);
                }
            }
            dictionary.addWord(word);
        }

        Collection<Word> ola = dictionary.getDictionary().values(); 
        for (Word word : ola) {
            System.out.print(word.getWord());
            for (Integer page : word.getPages()) {
                System.out.print(", " + page);
            }
            System.out.println();
        }


        List<Word> wordList = new ArrayList<>(ola);

        Collections.sort(wordList, new Comparator<Word>() {
            public int compare(Word w1, Word w2) {
                return Integer.compare(w2.getPages().size(), w1.getPages().size());
            }
        });

        // Crear una LinkedList para almacenar las top 10 palabras
        LinkedList<Word> top10Words = new LinkedList<Word>();

        // Añadir las primeras 10 palabras o todas si hay menos de 10
        for (int i = 0; i < Math.min(10, wordList.size()); i++) {
            top10Words.add(wordList.get(i));
        }


        System.out.println();
        System.out.println();
        for (Word word : top10Words) {
            System.out.print(word.getWord());
            for (Integer page : word.getPages()) {
                System.out.print(", " + page);
            }
            System.out.println();
        }


    }
}
