
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Michael
 */
/*Escriba una definición recursiva de una función que tiene un parámetro n de tipo entero y 
que devuelve el n-ésimo número de Fibonacci.
Los números de Fibonacci se definen de la siguiente manera:

F0 = 1

F1 = 1

Fi+2 = Fi + Fi+1
*/
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int n = 0;
        int r = 0;
        Scanner valor = new Scanner(System.in);
        System.out.print("----FIBONACCI----\n");
        System.out.print("Ingrese Numero:\n");
        n = valor.nextInt();
        r = Fibonacii(n);
        System.out.print("\nRESULTADO:" + r);

    }

    public static int Fibonacii(int N) {

        int a1 = 0, a2 = 1, actual = 1, i;// ingreso de valores enteros y sucecion de numeros naturales
        if (N == 0 || N == 1) {
            actual = 1;
        } else {
            for (i = 2; i <= N; i++) {// se empleará cuando conocemos el número de veces que se ejecutará una sentencia o un bloque de sentencias, tal como se indica
                actual = a1 + a2; // suma de a1 y a2
                a1 = a2;// pregunta si son iguales
                a2 = actual; // pregunta si son iguales a2 a 1
                System.out.print("\n" + a2);//salto de linea al imprimir
            }
        }
        return (actual);// retornar 
    }

}

