/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arrays;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author AlonSoftware
 */
public class ArrayClassOrdBus {

    Random r = new Random();

    public ArrayClassOrdBus() {
    }

    public void InvertirArray(int A[]) {
        long B[] = new long[A.length];
        int p = 0;
        for (int i = A.length - 1; i >= 0; i--) {
            B[p] = A[i];
            p++;
        }
        for (int i = 0; i < A.length; i++) {
            A[i] = (int) B[i];
        }
    }

    public void MatrizUnoCero(int D, int Pos1, int Pos2) {
        int Matriz[][] = new int[D][D];
        ArrayList<Integer> Posicion1 = new ArrayList<Integer>();
        ArrayList<Integer> Posicion2 = new ArrayList<Integer>();
        for (int i = 0; i < D; i++) {
            for (int j = 0; j < D; j++) {
                Matriz[i][j] = (int) (r.nextFloat() * 2);
            }
        }
        int Unos = 0;
        int P1 = Pos1-1, P2 = Pos2-1;
        while (P1 >= 0 && P2 >= 0) {
            if (Matriz[P1][P2] == 1) {
                Unos++;
                Posicion1.add(P1);
                Posicion2.add(P2);
            }
            P1--;
            P2--;
        }
        P1 = Pos1+1;
        P2 = Pos2+1;
        while (P1 < Matriz.length && P2 < Matriz.length) {
            if (Matriz[P1][P2] == 1) {
                Unos++;
                Posicion1.add(P1);
                Posicion2.add(P2);
            }
            P1++;
            P2++;
        }
        for (int i = 0; i < Matriz.length; i++) {
            for (int j = 0; j < Matriz.length; j++) {
                if (i == Pos1&&j!=Pos2) {
                    if (Matriz[i][j] == 1) {
                        Unos++;
                        Posicion1.add(i);
                        Posicion2.add(j);
                    }
                }
                if (j == Pos2&&i!=Pos1) {
                    if (Matriz[i][j] == 1) {
                        Unos++;
                        Posicion1.add(i);
                        Posicion2.add(j);
                    }
                }
                if (Pos1 + Pos2 == i + j&&i!=Pos1&&j!=Pos2) {
                    if (Matriz[i][j] == 1) {
                        Unos++;
                        Posicion1.add(i);
                        Posicion2.add(j);
                    }
                }
            }
        }
        System.out.println("Matriz Generada");
        for (int i = 0; i < Matriz.length; i++) {
            for (int j = 0; j < Matriz.length; j++) {
                System.out.print("|"+Matriz[i][j]+"|");
            }
            System.out.println("");
        }
        if(!Posicion1.isEmpty()){
            System.out.println("Lista de Posiciones");
            for (int i = 0; i < Posicion1.size(); i++) {
                System.out.println(Posicion1.get(i)+"    -    "+Posicion2.get(i));
            }
        } else {
            System.out.println("No se encontraron Unos");
        }
    }

    public void arrayDiagCua(int mat[][]) {
        if (mat.length == mat[0].length) {
            int Pri = 0, Tra = 0;
            for (int i = 0; i < mat.length; i++) {
                for (int j = 0; j < mat.length; j++) {
                    if (i == j) {
                        Pri += mat[i][j];
                    }
                    if (i + j == mat.length - 1) {
                        Tra += mat[i][j];
                    }
                }
            }
            System.out.println("La Sumatoria de la diagonal principal es: " + Pri);
            System.out.println("La Sumatoria de la diagonal transversal es: " + Tra);
        } else {
            System.out.println("La matriz no es cuadrada");
        }
    }
    public void arrayDiagCua(short mat[][]) {
        if (mat.length == mat[0].length) {
            short Pri = 0, Tra = 0;
            for (int i = 0; i < mat.length; i++) {
                for (int j = 0; j < mat.length; j++) {
                    if (i == j) {
                        Pri += mat[i][j];
                    }
                    if (i + j == mat.length - 1) {
                        Tra += mat[i][j];
                    }
                }
            }
            System.out.println("La Sumatoria de la diagonal principal es: " + Pri);
            System.out.println("La Sumatoria de la diagonal transversal es: " + Tra);
        } else {
            System.out.println("La matriz no es cuadrada");
        }
    }

    public void arrayOrdenarBurbujaMejorada(int mat[][]) {
        int aux;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                for (int k = 0; k < mat.length; k++) {
                    for (int l = 0; l < mat[0].length; l++) {
                        if (mat[i][j] < mat[k][l]) {
                            aux = mat[i][j];
                            mat[i][j] = mat[k][l];
                            mat[k][l] = aux;
                        }
                    }
                }
            }
        }
    }
    public void arrayOrdenarBurbujaMejorada(short mat[][]) {
        short aux;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                for (int k = 0; k < mat.length; k++) {
                    for (int l = 0; l < mat[0].length; l++) {
                        if (mat[i][j] < mat[k][l]) {
                            aux = mat[i][j];
                            mat[i][j] = mat[k][l];
                            mat[k][l] = aux;
                        }
                    }
                }
            }
        }
    }

//    public void arrayOrdenarBurbujaSimple(int mat[][]) {
//        int aux;
//        for (int i = 0; i < mat.length; i++) {
//            for (int j = 1; j < mat[0].length; j++) {
//                for (int k = 0; k < mat.length; k++) {
//                    for (int l = 0; l < mat[0].length-1; l++) {
//                        if (mat[k][l] > mat[k][l+1]) {
//                            aux = mat[k][l];
//                            mat[k][l] = mat[k][l+1];
//                            mat[k][l+1] = aux;
//                        }
//                    }
//                }
//            }
//        }
//    }
    public void arrayOrdenarBurbuja(int array[]) {
        int aux;
        for (int fil = 1; fil <= array.length - 1; fil++) {
            for (int col = 0; col < array.length - fil; col++) {
                if (array[col] > array[col + 1]) {
                    aux = array[col];
                    array[col] = array[col + 1];
                    array[col + 1] = aux;
                }
            }
        }
    }

    public void arrayOrdenarLineal(int array[]) {
        int aux;
        for (int fil = 0; fil < array.length - 1; fil++) {
            for (int col = fil + 1; col < array.length; col++) {
                if (array[fil] > array[col]) {
                    aux = array[fil];
                    array[fil] = array[col];
                    array[col] = aux;
                }
            }
        }
    }

    public void arrayOrdenarInsercion(int array[]) {
        int temp, j;
        for (int i = 1; i < array.length; i++) {
            temp = array[i];
            j = i - 1;
            while ((j >= 0) && (temp < array[j])) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = temp;
        }
    }

    public void arrayOrdenarSeleccion(int array[]) {
//        int aux,p,k,i;
//        for (k = 0; k < array.length - 1; k++) {
//            p = k;
//            for (i = k + 1; i > array.length - 1; i++) {
//                if (array[i] < array[p]) {
//                    p = i;
//                }
//            }
//            if (p != k) {
//                aux = array[p];
//                array[p] = array[k];
//                array[k] = aux;
//            }
//        }
        int i, j, menor, pos, tmp;
        for (i = 0; i < array.length - 1; i++) { // tomamos como menor el primero
            menor = array[i]; // de los elementos que quedan por ordenar
            pos = i; // y guardamos su posición
            for (j = i + 1; j < array.length; j++) { // buscamos en el resto
                if (array[j] < menor) { // del array algún elemento
                    menor = array[j]; // menor que el actual
                    pos = j;
                }
            }
            if (pos != i) { // si hay alguno menor se intercambia
                tmp = array[i];
                array[i] = array[pos];
                array[pos] = tmp;
            }
        }
    }/* Tomado de http://puntocomnoesunlenguaje.blogspot.com.co/2012/12/java-metodo-ordenacion-seleccion.html*/

    public void arrayOrdenarShell(int array[]) {
//        int k = array.length / 2;
//        System.out.println(k);
//        while (k >= 1) {
//            for (int i = k; i >= array.length; i++) {
//                int v = array[i];
//                int j = i - k;
//                while (j >= 0 && array[j] < v) {
//                    array[j + k] = array[j];
//                    j -= k;
//                }
//                array[j + k] = v;
//            }
//            k /= 2;
//        }
        int salto, aux, i;
        boolean cambios;
        for (salto = array.length / 2; salto != 0; salto /= 2) {
            cambios = true;
            while (cambios) { // Mientras se intercambie algún elemento
                cambios = false;
                for (i = salto; i < array.length; i++) // se da una pasada
                {
                    if (array[i - salto] > array[i]) { // y si están desordenados
                        aux = array[i]; // se reordenan
                        array[i] = array[i - salto];
                        array[i - salto] = aux;
                        cambios = true; // y se marca como cambio.
                    }
                }
            }
        }
    }//Tomado de http://puntocomnoesunlenguaje.blogspot.com.co/2014/09/metodo-shell-de-ordenacion.html

    public int BuscarLineal(int array[], int dato) {
        int n = array.length;
        int pos = -1;
        for (int i = 0; (i < n) && (pos == -1); i++) {
            if (array[i] == dato) {
                pos = i;
            }
        }
        return pos;
    }

    public int BuscarLinealRec(int array[], int dato, int a) {
        if (array[a] == dato) {
            return a;
        } else {
            return BuscarLinealRec(array, dato, --a);
        }
    }

    public int BuscarBinario(int v[], int dato) {
        int izq = 0;
        int der = v.length - 1;
        int centro = (izq + der) / 2;
        while ((izq <= der) && (v[centro] != dato)) {
            if (dato < v[centro]) {
                der = centro - 1;
            } else {
                izq = centro + 1;
            }
            centro = (izq + der) / 2;
        }
        if (izq > der) {
            return -1;
        } else {
            return centro;
        }
    }//Tomado de http://elvex.ugr.es/decsai/java/pdf/6C-Search.pdf

    public int BuscarBinarioRec(int v[], int izq, int der, int dato) {
        int centro = (izq + der) / 2;
        if (izq > der) {
            return -1;
        } else if (dato == v[centro]) {
            return centro;
        } else if (dato < v[centro]) {
            return BuscarBinarioRec(v, izq, centro - 1, dato);
        } else {
            return BuscarBinarioRec(v, centro + 1, der, dato);
        }
    }//Tomado de http://elvex.ugr.es/decsai/java/pdf/6C-Search.pdf
}//Fin Clase
