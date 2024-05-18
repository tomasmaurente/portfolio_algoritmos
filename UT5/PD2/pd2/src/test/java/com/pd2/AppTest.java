package com.pd2;

import org.junit.Test;
import com.pd2.trie.TArbolTrie;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        TArbolTrie arbolPrueba = new TArbolTrie();

        arbolPrueba.insertar("ola");
        arbolPrueba.insertar("olas");
        arbolPrueba.insertar("olla");
        arbolPrueba.insertar("a");

        assert(arbolPrueba.getAltura() == 4);
        assert(arbolPrueba.getTamano() == 7);
    }
}
