package com.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        String correcto = "sdfv'{}' erfwe'{}'erfw'{{}} {{{{}}}}'fwerf'{}'";
        String incorrecto = "sonwen'{{{{{}}}}}}}}}'";
        
        System.out.println( "El primer texto es correcto:" + Expresion.expresion(correcto) );

        System.out.println( "El segundo texto es correcto:" + Expresion.expresion(incorrecto) );
    }
}


