package com.example;

/**
 * Ejercicio 1
 *      ¿Cuál es la salida? Sé preciso acerca de dónde hay espacios y dónde hay nuevas líneas.
 *      Indicar cuál es la respuesta más correcta: (\n denota nueva línea)
 * 
 * Respuesta:
 *      No, yo pac.
 *      Vos zacata pac.
 *      Yo pac.
 * 
 *      Los saltos de linea se deben al metodo ping() el cual define el print como println 
 * 
 *      System.out.println (".");
 * 
 * Ejercicio 1
 *      ¿Cuál es la primera sentencia que se ejecuta?
 * 
 * Respuesta:
 *  a)
 *      System.out.println ("ik")
 *  b)  
 *      public static void desconcertar (String dirigible) {
            System.out.println (dirigible);    2 
            sipo ("ping", -5);
        }
        public static void sipo (String membrillo, int flag) {
            if (flag < 0) {
                System.out.println (membrillo + " sup");    3 
            } else {
                System.out.println ("ik");    1 
                desconcertar (membrillo);
                System.out.println ("muaa-ja-ja-ja");    4 
            }
        }
        public static void main (String[] args) {
            sipo ("traqueteo", 13);
        }
 *      
 *
 */
public class MultSuma 
{
    public static double multsuma (double a, double b, double c) {
        return a * b + c;
    }

    public static String convStr(double num){
        return String.valueOf(num);
    }
    
    public static void main (String[] args) {
        double result = multsuma(1.0, 2.0, 3.0);
        System.out.println("Should be 5.0 and is: " + convStr(result));

        result = multsuma(-1.0, 3.0, 3.0);
        System.out.println("Should be 0.0 and is: " + convStr(result));

        result = multsuma(-1.0, 4.0, 3.0);
        System.out.println("Should be -1.0 and is: " + convStr(result));

        result = multsuma(0.0, 2.0, 3.0);
        System.out.println("Should be 3.0 and is: " + convStr(result));

        result = multsuma(1.0, 45.0, 3.0);
        System.out.println("Should be 48.0 and is: " + convStr(result));

        result = multsuma(1.5, 2.0, 3.0);
        System.out.println("Should be 6.0 and is: " + convStr(result));

        result = multsuma(1.654235, 8.0, 3.65326984);
        System.out.println("Should be 16.88714984 and is: " + convStr(result));

    }
    

}
