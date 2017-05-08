/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Michael Daniel Murillo López
 * ID: 534830
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int result;
        int[] vector = {1, 4, 7, 8, 9, 14, 23, 47, 56, 60, 61, 63, 65, 66, 68, 69, 70, 73, 76, 77, 79, 80, 82};// ingreso de valores enteros  es un algoritmo de búsqueda que encuentra la posición de un valor en un array ordenado
        int valorBuscado = 69;// numero que desea buscar en el vector

        System.out.print("array: ");// imprecion 
        for (int i = 0; i < vector.length; i++) {
            System.out.print(vector[i] + " ");
        }

        System.out.println("\nvalor buscado: " + valorBuscado);// imprecion 

        result = busquedaBinaria(vector, valorBuscado);
        if (result != -1) {
            System.out.println("posicion donde se encuentra: " + result);//imprecion 
        } else {
            System.out.println("valor no se encuentra en el array");// imprecion 
        }
    }

    public static int busquedaBinaria(int vector[], int dato) {/*Compara el valor con el elemento en el medio del array,
                                                               si no son iguales, la mitad en la cual el valor no puede estar es eliminada 
                                                               y la búsqueda continúa en la mitad restante hasta que el valor se encuentre.*/
        int n = vector.length;
        int centro, inf = 0, sup = n - 1;
        while (inf <= sup) {
            centro = (sup + inf) / 2;
            if (vector[centro] == dato) {
                return centro;
            } else if (dato < vector[centro]) {
                sup = centro - 1;
            } else {
                inf = centro + 1;
            }
        }
        return -1;
    }

}
