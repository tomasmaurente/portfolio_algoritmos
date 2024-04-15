package com.example;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class AppTest 
{
    @Test
    public void shouldAnswerWithTrue()
    {
        String correcto = "sdfv'{}' erfwe'{}'erfw'{{}} {{{{}}}}'fwerf'{}'";
        
        assertTrue( Expresion.expresion(correcto) );
    }

    @Test
    public void shouldAnswerWithTrueSimpleVersion()
    {
        String correcto = "'{}'";
        
        assertTrue( Expresion.expresion(correcto) );
    }

    @Test
    public void shouldAnswerWithFalse()
    {
        String incorrecto = "sonwen'{{{{{}}}}}}}}}'";
        
        assertFalse( Expresion.expresion(incorrecto) );
        assertFalse( Expresion.expresion(null) );
    }
    
    @Test
    public void shouldAnswerWithFalseSimple()
    {
        String incorrecto = "'}'";
        
        assertFalse( Expresion.expresion(incorrecto) );
    }

    @Test
    public void shouldAnswerWithFalseIfOnlyOpens()
    {
        String incorrecto = "'{'";
        
        assertFalse( Expresion.expresion(incorrecto) );
    }
}
