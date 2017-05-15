/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpackage;

import arrays.*;
import javax.swing.*;
import java.util.Random;
/**
 *
 * @author AlonSoftware
 */
public class arraysMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    Random nr = new Random();

        
        int filas = Integer.parseInt(JOptionPane.showInputDialog(null,"Digite las filas: "));
        int columnas = Integer.parseInt(JOptionPane.showInputDialog(null,"Digite las columnas: "));
        
        short Matriz[][] = new short[filas][columnas];
        int Vector[] = new int[filas];
        
        CargarArrays objetoCargar = new CargarArrays();
        ImprimirArrays objetoImprimir = new  ImprimirArrays();
        ArrayClassOrdBus objetoOrdBus = new ArrayClassOrdBus();
        
        objetoCargar.cargarArrays(Matriz,100,1000);
        objetoCargar.cargarArrays(Vector,30,100);
        filas = Integer.parseInt(JOptionPane.showInputDialog(null,"Digite las filas: "));
        columnas = Integer.parseInt(JOptionPane.showInputDialog(null,"Digite las columnas: "));
        double Matriz1[][]= new double [filas][columnas];
        System.out.println("Impresión de la matriz...");
        objetoImprimir.imprimirArrays(Matriz);
        objetoOrdBus.arrayOrdenarBurbujaMejorada(Matriz);
        System.out.println("Matriz Ordenada");
        objetoImprimir.imprimirArrays(Matriz);
        
        System.out.println("Impresión del vector cargado...");
        objetoImprimir.imprimirArrays(Vector);
        System.out.println("Vector Ordenado");
        objetoOrdBus.arrayOrdenarBurbuja(Vector);
        objetoOrdBus.arrayOrdenarLineal(Vector);
        objetoOrdBus.arrayOrdenarInsercion(Vector);
        objetoOrdBus.arrayOrdenarSeleccion(Vector);
        objetoOrdBus.arrayOrdenarShell(Vector);
        objetoImprimir.imprimirArrays(Vector);
        System.out.println("Impresión de la matriz...");
        objetoImprimir.imprimirArrays(Matriz);
        objetoOrdBus.arrayDiagCua(Matriz);
        System.out.println("Invertir Vector");
        objetoOrdBus.InvertirArray(Vector);
        objetoImprimir.imprimirArrays(Vector);
        filas = Integer.parseInt(JOptionPane.showInputDialog(null,"Digite la fila inicial"));
        columnas = Integer.parseInt(JOptionPane.showInputDialog(null,"Digite la columna inicial"));
        objetoOrdBus.MatrizUnoCero(10, filas, columnas);
        
//        try {
//            System.out.println("El dato se encontro en la posición "+objetoOrdBus.BuscarLinealRec(Vector, 51, Vector.length-1));
//        } catch (Exception e) {
//            System.out.println("No se encontro el dato");
//        }
//        try {
//            System.out.println("El dato se encontro en la posición "+objetoOrdBus.BuscarBinario(Vector, 51));
//        } catch (Exception e) {
//            System.out.println("No se encontro el dato");
//        }
//        try {
//            System.out.println("El dato se encontro en la posición "+objetoOrdBus.BuscarBinarioRec(Vector,0,Vector.length-1, 51));
//        } catch (Exception e) {
//            System.out.println("No se encontro el dato");
//        }
    }
}//Fin class
