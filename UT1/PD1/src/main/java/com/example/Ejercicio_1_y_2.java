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