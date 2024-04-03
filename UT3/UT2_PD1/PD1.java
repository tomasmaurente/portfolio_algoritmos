import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class PD1 {

    public static int contador = 0;
    public static int tamano = 0;

    public static void miFuncion(int[] nums) {
        int n = nums.length;
         for(int i = 0; i < n; i++ ){
            for (int j = n - 1 ; j > i ; j--){
                contador++;
                if (nums[j] < nums[j-1]){
                    int aux = nums[j];
                    nums[j] = nums[j-1];
                    nums[j-1] = aux;
                }
            }
        }
    }

    public static int[] obtenerNumerosArchivo(String nombreCompletoArchivo) {
        FileReader fr;
        int[] numerosArchivo = new int[0];
        try {
            fr = new FileReader(nombreCompletoArchivo);
            BufferedReader br = new BufferedReader(fr);
            String lineaActual = br.readLine();
            tamano = Integer.parseInt(lineaActual);
            numerosArchivo = new int[tamano];
            int aux = 0;
            lineaActual = br.readLine();
            while (lineaActual != null) {
                numerosArchivo[aux] = Integer.parseInt(lineaActual);
                aux++;
                lineaActual = br.readLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error al leer el archivo " + nombreCompletoArchivo);
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Error al leer el archivo " + nombreCompletoArchivo);
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Error al leer el archivo " + nombreCompletoArchivo);
            e.printStackTrace();
        }
        return numerosArchivo;
    }

    
    public static void main(String[] args) {
        int[] nums = obtenerNumerosArchivo("C:\\Users\\Tomas\\Desktop\\Algoritmos\\portfolio_algoritmos\\UT3\\UT2_PD1\\numeros.txt");
        miFuncion(nums);
        System.out.println("el tamaño de la lista es de: " + tamano);
        System.out.println("el contenido del contador es de: " + contador);
        System.out.println("el primer numero de la lista es: " + nums[0]);
        System.out.println("el ultimo numero de la lista es: " + nums[tamano -1]);
    }
}
