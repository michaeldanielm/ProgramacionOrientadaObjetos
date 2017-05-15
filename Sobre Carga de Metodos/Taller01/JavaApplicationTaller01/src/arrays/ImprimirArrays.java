/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arrays;

/**
 *
 * @author AlonSoftware
 */
public class ImprimirArrays {
    
    public ImprimirArrays(){};
   
    public void imprimirArrays(int mat[][]){
        for (int[] mat1 : mat) {
            for (int col = 0; col < mat[0].length; col++) {
                System.out.print("[" + mat1[col] + "]");
            }
            System.out.println();
        }
    }
    public void imprimirArrays(byte mat[][]){
        for (byte[] mat1 : mat) {
            for (int col = 0; col < mat[0].length; col++) {
                System.out.print("[" + mat1[col] + "]");
            }
            System.out.println();
        }
    }
    public void imprimirArrays(double mat[][]){
        for (double[] mat1 : mat) {
            for (int col = 0; col < mat[0].length; col++) {
                System.out.print("[" + mat1[col] + "]");
            }
            System.out.println();
        }
    }
    public void imprimirArrays(short mat[][]){
        for (short[] mat1 : mat) {
            for (int col = 0; col < mat[0].length; col++) {
                System.out.print("[" + mat1[col] + "]");
            }
            System.out.println();
        }
    }
    
    public void imprimirArrays(int array[]){
        for (int arr : array) {
            System.out.print("[" + arr + "]");
        }
        System.out.println("");
        
    }
    public void imprimirArrays(short array[]){
        for (short arr : array) {
            System.out.print("[" + arr + "]");
        }
        System.out.println("");
        
    }
    public void imprimirArrays(double array[]){
        for (double arr : array) {
            System.out.print("[" + arr + "]");
        }
        System.out.println("");
        
    }
    
}