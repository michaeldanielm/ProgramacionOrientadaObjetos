
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
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.print("Ingrese un numero : ");
        int m= new Scanner(System.in).nextInt();
         int[] feb = new int[m];
         feb[0] = 1;
         feb[1] = 1;
         for(int i=2; i < m; i++){
             feb[i] = feb[i-1] + feb[i-2];
         }
 
         for(int i=0; i<  m; i++){
                 System.out.print(feb[i] + " ");
         }        

    }
    
}
