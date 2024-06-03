package com.example;

import java.util.HashMap;

public class Dictionary {

    private HashMap<String, Word> dictionary = new HashMap<String, Word>();

    public void addWord(Word w) {
        dictionary.put(w.getWord(), w);
    }

    public HashMap<String, Word> getDictionary(){
        return this.dictionary;
    }
    
}
