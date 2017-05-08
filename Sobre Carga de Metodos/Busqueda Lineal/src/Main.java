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
        int[] vector = {1, 4, 7, 8, 9, 14, 23, 47, 56, 60, 61, 63, 65, 66, 68, 69, 70, 73, 76, 77, 79, 80, 82};// ingresamos los enteros que se encuentra un vector
        int valorBuscado = 68;// ingresamos el numero que deseamos encontrar en el vector 

        System.out.print("array: ");//IMPRESION
        for (int i = 0; i < vector.length; i++) {
            System.out.print(vector[i] + " ");
        }

        System.out.println("\nvalor buscado: " + valorBuscado);//IMPRESION

        result = busquedaLineal_Secuencial(vector, valorBuscado);
        if (result != -1) {
            System.out.println("posicion donde se encuentra: " + result);//IMPRESION
        } else {
            System.out.println("valor no se encuentra en el array");//IMPRESION
        }
    }

    public static int busquedaLineal_Secuencial(int[] arreglo, int dato) {
        int posicion = -1;
        for (int i = 0; i < arreglo.length; i++) {//recorremos todo el arreglo
            if (arreglo[i] == dato) {//comparamos el elemento en el arreglo con el buscado
                posicion = i;//Si es verdadero guardamos la posicion
                break;//Para el ciclo
            }
        }
        return posicion;// RETORNA A LA POSICION INICIAL
    }

}
/* buscando en todas las casillas lo debemos encontrar. 
Para hacerlo de una manera organizada, empezamos por el primer dato y continuamos hasta llegar al dato que buscamos o hasta que lleguemos al fin del arreglo.*/