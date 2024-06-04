package com.example;

import java.util.LinkedList;
import java.util.List;

public class Word {

    private List<Integer> pages = new LinkedList<Integer>();
    private String word;

    public Word ( String word, Integer page){
        if (word != null && page != null) {
            this.word = word;
            pages.add(page);    
        }
    }

    public Word ( String word, List<Integer> page){
        if (word != null && page != null) {
            this.word = word;
            for (Integer p : page){
                pages.add(p);
            }    
        }
    }

    public String getWord(){
        return this.word;
    }

    public LinkedList<Integer> getPages(){
        return (LinkedList<Integer>) this.pages;
    }

    public void updatePages(Integer page ){
        if (page != null){
            pages.add(page);
        } 
    }

}
