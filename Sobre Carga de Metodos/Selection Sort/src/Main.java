import java.util.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Michael Daniel Murillo Lopez 
 *  ID: 534830
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int all= 1000;
    		
    	int[] list = new int[all];// ingresamos enteros 
    	Random rand = new Random();// escogemos datos a lazar 
      	for(int i = 0 ; i<all; i++ ){// agregamos  los parametros de ingreso de datos
    		list[i] = rand.nextInt(50);//Escogemos los datos que vamos a ingresar 
    	}

        System.out.println("orden original: " + Arrays.toString(list));//imprecion de los datos desordenados
        selectionSort(list);
        System.out.println("ordenado: " + Arrays.toString(list));//impresion de los datos ordenados
    

    }
    public static void selectionSort(int[] x) {//

	    for (int i=0; i<x.length-1; i++) {
	        int minIndex = i;      // indice de valor restante más pequeño.
	        for (int j=i+1; j<x.length; j++) {
	            if (x[minIndex] > x[j]) {
	                minIndex = j;  // guardar indice del nuevo mínimo
	            }
	        }
	        if (minIndex != i) { // pregunta si el minimo es igual al indice que tiene I
	            int temp = x[i];
	            x[i] = x[minIndex];
	            x[minIndex] = temp;
	        }
	    }
	}
    
}
//La idea del algoritmo es bastante simple. Matriz se imaginaria divide en dos partes - ordenados uno y uno no clasificados .
//Al principio, parte ordenados es vacía , mientras que uno no clasificados contiene valores enteros  entera .
//A cada paso, algoritmo encuentra elemento mínimo en la parte no seleccionada y la añade a la final del uno ordenada.
// Cuando una parte no seleccionada se convierte en vacío , el algoritmo se detiene