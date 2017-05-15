import java.util.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Michael Daniel Murillo López
 * id:534830
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[] arr = { 6, 8, 1, 4, 7, 0, 2, 5};
        shellSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        
    }
    }   
    public static void shellSort(int[] a) {
        int size = a.length;
        int step = size / 2;
        while (step > 0)
        {
            for (int i = 0; i < (size - step); i++)
            {
                int j = i;
                while (j >= 0 && a[j] > a[j + step])
                {
                    int temp = a[j];
                    a[j] = a[j + step];
                    a[j + step] = temp;
                    j--;
                }
            }
            step = step / 2;
        }
    }
}
