package uy.edu.ucu.aed;

public class THash implements IHash {

    Integer[] arreglo;
    private int carga;
    public int capacidad;

    public THash(){
        this.arreglo = new Integer[3];
        this.capacidad = 3;
    }

    /*
     * Devuelve la cantidad de comparaciones en negativo si no encuentra la clave y en positivo si sí la encuentra 
     */
    @Override
    public int buscar(int unaClave) {
        int ubicacion = funcionHashing(unaClave);
        int i = 0;
        while (true){
            i ++;
            if(arreglo[ubicacion] == null){
                return i * -1;
            }
            if (arreglo[ubicacion] == unaClave){
                return i;
            }
            ubicacion = (ubicacion + 1)%capacidad;
        }
    }

    @Override
    public int insertar(int unaClave) {
        if (unaClave == 2722){
            System.out.println("hola");
        
        }
        carga++;
        if (carga >= capacidad/2){
            reHash();
        }
        int ubicacion = funcionHashing(unaClave);
        int i = 0;
        while (true){
            i++;
            if (arreglo[ubicacion] == null){
                arreglo[ubicacion] = unaClave;
                return i;
            }
            ubicacion = (ubicacion + 2*i -1)%capacidad;//ubicacion = (ubicacion + 2*i - 1)%capacidad;
        }
    }

    public int insertarConTamanoFijo(int unaClave, int tamano, Boolean primero) {

        if (primero){
            int nuevaCapacidad = tamano;
            Integer[] nuevoArreglo = new Integer[nuevaCapacidad];
            this.capacidad = nuevaCapacidad;
            this.arreglo = nuevoArreglo;
        }

        int ubicacion = funcionHashing(unaClave);
        int i = 0;
        while (true){
            i++;
            if (ubicacion < 0){
                ubicacion = Math.abs(ubicacion);
            }
            if (arreglo[ubicacion] == null){
                arreglo[ubicacion] = unaClave;
                return i;
            }
            ubicacion = (ubicacion + 1)%capacidad;
        }
    }

    @Override
    public int funcionHashing(int unaClave) {
        return ((unaClave%arreglo.length) + arreglo.length ) % arreglo.length;
    }

    private boolean isPrime(int n){
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
            return false;
            }
        }
        return true;
    }

    private int nextPrime(int n){
        n++;
        if (n%2 == 0){
            n++;
        }
        for (; !isPrime(n); n+=2){

        }
        return n;
    }

    private void reHash(){
        int nuevaCapacidad = nextPrime(this.capacidad*2);
        Integer[] nuevoArreglo = new Integer[nuevaCapacidad];
        this.capacidad = nuevaCapacidad;
        Integer[] arreglo = this.arreglo;
        this.arreglo = nuevoArreglo;	
        for (Integer i : arreglo){
            if (i != null){
                insertar(i);
            }
        }
    }
    
}
