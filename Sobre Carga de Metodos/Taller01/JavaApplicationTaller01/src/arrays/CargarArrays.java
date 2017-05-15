package arrays;

import java.util.Random;
import java.util.Scanner;

public class CargarArrays {
    Scanner leer = new Scanner(System.in);
    Random nr = new Random();

    public CargarArrays() {
    }//Constructor
    public void cargarArrays(int mat[][]){
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.print("Digite un numero para la posición "+i+"-"+j+" :");
                mat[i][j]=leer.nextInt();
            }
        }
    }
    public void cargarArrays(short mat[][]){
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.print("Digite un numero para la posición "+i+"-"+j+" :");
                mat[i][j]=leer.nextShort();
            }
        }
    }
    public void cargarArrays(long mat[][]){
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.print("Digite un numero para la posición "+i+"-"+j+" :");
                mat[i][j]=leer.nextLong();
            }
        }
    }
    public void cargarArrays(byte mat[][]){
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.print("Digite un numero para la posición "+i+"-"+j+" :");
                mat[i][j]=(byte)leer.nextInt();
            }
        }
    }
    public void cargarArrays(char mat[][]){
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.print("Digite un numero para la posición "+i+"-"+j+" :");
                mat[i][j]=(char)leer.nextInt();
            }
        }
    }
    public void cargarArrays(double mat[][]){
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.print("Digite un numero para la posición "+i+"-"+j+" :");
                mat[i][j]=leer.nextDouble();
            }
        }
    }
    public void cargarArrays(float mat[][]){
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.print("Digite un numero para la posición "+i+"-"+j+" :");
                mat[i][j]=leer.nextFloat();
            }
        }
    }
    public void cargarArrays(int mat[][], int minRandom, int maxRandom) {
        for (int fil = 0; fil < mat.length; fil++) {
            for (int col = 0; col < mat[0].length; col++) {
                mat[fil][col] = minRandom - ((int) Math.round((Math.random()) * (minRandom - maxRandom)));
            }
        }
    }

    public void cargarArrays(short mat[][], int minRandom, int maxRandom) {
        for (int fil = 0; fil < mat.length; fil++) {
            for (int col = 0; col < mat[0].length; col++) {
                mat[fil][col] = (short) (minRandom - ((int) Math.round((Math.random()) * (minRandom - maxRandom))));
            }
        }
    }

    public void cargarArrays(long mat[][], int minRandom, int maxRandom) {
        for (int fil = 0; fil < mat.length; fil++) {
            for (int col = 0; col < mat[0].length; col++) {
                mat[fil][col] = (long) (minRandom - ((int) Math.round((Math.random()) * (minRandom - maxRandom))));
            }
        }
    }

    public void cargarArrays(char mat[][], int minRandom, int maxRandom) {
        for (int fil = 0; fil < mat.length; fil++) {
            for (int col = 0; col < mat[0].length; col++) {
                mat[fil][col] = (char) (minRandom - ((int) Math.round((Math.random()) * (minRandom - maxRandom))));
            }
        }
    }

    public void cargarArrays(double mat[][], int minRandom, int maxRandom) {
        for (int fil = 0; fil < mat.length; fil++) {
            for (int col = 0; col < mat[0].length; col++) {
                mat[fil][col] = (double) (minRandom - ((int) Math.round((Math.random()) * (minRandom - maxRandom))));
            }
        }
    }

    public void cargarArrays(float mat[][], int minRandom, int maxRandom) {
        for (int fil = 0; fil < mat.length; fil++) {
            for (int col = 0; col < mat[0].length; col++) {
                mat[fil][col] = (float) (minRandom - ((int) Math.round((Math.random()) * (minRandom - maxRandom))));
            }
        }
    }

    public void cargarArrays(byte mat[][], int minRandom, int maxRandom) {
        for (int fil = 0; fil < mat.length; fil++) {
            for (int col = 0; col < mat[0].length; col++) {
                mat[fil][col] = (byte) (minRandom - ((int) Math.round((Math.random()) * (minRandom - maxRandom))));
            }
        }
    }

    public void cargarArrays(int array[], int minRandom, int maxRandom) {
        for (int fil = 0; fil < array.length; fil++) {
            array[fil] = Math.abs(nr.nextInt() % 9 + 1);
            array[fil] = minRandom - ((int) Math.round((Math.random()) * (minRandom - maxRandom)));
        }
    }

    public void cargarArrays(char array[], int minRandom, int maxRandom) {
        for (int fil = 0; fil < array.length; fil++) {
            array[fil] = (char) (Math.abs(nr.nextInt() % 9 + 1));
            array[fil] = (char) (minRandom - ((int) Math.round((Math.random()) * (minRandom - maxRandom))));
        }
    }

    public void cargarArrays(double array[], int minRandom, int maxRandom) {
        for (int fil = 0; fil < array.length; fil++) {
            array[fil] = Math.abs(nr.nextInt() % 9 + 1);
            array[fil] = minRandom - ((int) Math.round((Math.random()) * (minRandom - maxRandom)));
        }
    }

    public void cargarArrays(byte array[], int minRandom, int maxRandom) {
        for (int fil = 0; fil < array.length; fil++) {
            array[fil] = (byte) (Math.abs(nr.nextInt() % 9 + 1));
            array[fil] = (byte) (minRandom - ((int) Math.round((Math.random()) * (minRandom - maxRandom))));
        }
    }

    public void cargarArrays(short array[], int minRandom, int maxRandom) {
        for (int fil = 0; fil < array.length; fil++) {
            array[fil] = (short) (Math.abs(nr.nextInt() % 9 + 1));
            array[fil] = (short) (minRandom - ((int) Math.round((Math.random()) * (minRandom - maxRandom))));
        }
    }

    public void cargarArrays(long array[], int minRandom, int maxRandom) {
        for (int fil = 0; fil < array.length; fil++) {
            array[fil] = (long) (Math.abs(nr.nextInt() % 9 + 1));
            array[fil] = (long) (minRandom - ((int) Math.round((Math.random()) * (minRandom - maxRandom))));
        }
    }
} //fin clase
