import java.util.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Michael Daniel Murillo López 
 * Id :534830
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int all = 1000;

        int[] list = new int[all];
        Random rand = new Random();//ingresa en un arreglo datos al lazar 
        for (int i = 0; i < all; i++) {
            list[i] = rand.nextInt(100);
        }

        System.out.println("orden original: " + Arrays.toString(list));//impresion de datos
        insertionSort(list);
        System.out.println("ordenado: " + Arrays.toString(list));//impresio  de datos
    }

    public static void insertionSort(int[] arr) {//todos los elementos mayores han sido desplazados una posición a la derecha o cuando ya no se encuentran elementos se detiene
        int i, j, newValue;
        for (i = 1; i < arr.length; i++) {
            newValue = arr[i];
            j = i;
            while (j > 0 && arr[j - 1] > newValue) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = newValue;
        }

    }
}