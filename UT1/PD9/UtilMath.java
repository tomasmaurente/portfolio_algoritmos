package TA2;

import java.util.Scanner;

public class UtilMath {

    public static float factorial(int num) {
        float contador = 1;
        for ( int i = num; i > 0; i--) {
            contador *= i;
        }
        return contador;
    }
    public static boolean isPrimeWhile(long n) {
        boolean prime = true;
        long cont = 3;

        while (cont <= Math.sqrt(n)) {
            if (n % cont == 0) {
                prime = false;
                break;
            }
            cont += 2;
        }
        if ((n % 2 != 0 && prime && n > 2) || n == 2) {
            return true;
        } else {
            return false;
        }
    }

    public static long sumaNum(long n){
        long res = 0;
        if (isPrimeWhile(n)){
            long cont = 0;
            while(cont <= n){
                res += cont; 
                cont += 2;
            }
        } else {
            long cont = 1;
            while(cont <= n){
                res += cont; 
                cont += 2;
            }
        }
        return res;

    }

    public static boolean isPrimeFor(long n) {
        boolean prime = true;
        for (long i = 3; i <= Math.sqrt(n); i += 2)
            if (n % i == 0) {
                prime = false;
                break;
            }
        if ((n % 2 != 0 && prime && n > 2) || n == 2) {
            return true;
        } else {
            return false;
        }
    }
    
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int n;
        System.out.println("Digite un numero: ");
        n = entrada.nextInt();
        factorial(n);
        System.out.println("El factorial es: " + factorial(n));
    }
}
