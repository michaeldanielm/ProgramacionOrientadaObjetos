package Main;

import logica.*;
import java.io.*;
import java.util.Scanner;

/**
 *
 * @author Michael Daniel Murillo Lopez
 */
public class Programacion{

    public static void main(String[] args) throws IOException {
        double inicio, fin;

        int m;
        String dir = "C:\\Users\\Michael\\Downloads\\Programacion Orientada Objetos trabajofinal\\src\\documento\\archivo\\numeros10millones.txt";
        Scanner tec = new Scanner(System.in);
        Main.archivo arc = new Main.archivo();

        ;
        System.out.println("El archivo tiene 10000000 números\n" // pregunta cuantos numeros 
                + "¿Qué cantidad de números desea ordenar?");
        int tam = tec.nextInt();
        do {

            int[] V = new int[tam];
            arc.leerArchivo(dir, V, tam);

//            //hacemos un menu para un mejor manejo
            System.out.println("Menu:");
            System.out.println("1.ordenar de Menor A Mayor \n"
                    + "2. ordenar de Mayor A Menor \n"
                    + "3. Numero mayor y numero menor \n"
                    + "4. Buscar \n"
                    + "5. Suma \n"
                    + "6. Salir");

            System.out.println("¿Qué operacion desea?: ");
            m = tec.nextInt();
            shell sh = new shell();
            switch (m) {
                case 1:
                    System.out.println("ordenar de Menor A Mayor");

                    sh.shellMenor_Mayor(V);
                    sh.mostrar(V, tam);
                    break;
                case 2:
                    System.out.println("ordenar de Mayor A Menor");

                    sh.shellMayor_Menor(V);
                    sh.mostrar(V, tam);
                    break;
                case 3:
                    System.out.println("Numero mayor y numero menor ");
                    Mayor_y_Menor Mm = new Mayor_y_Menor();
                    Mm.Mm(V, tam);
                    break;
                case 4:
                    System.out.println("Buscar");
                    System.out.println("ingrese numero a buscar");
                    int x = tec.nextInt();

                    Busqueda bs = new Busqueda();
                    sh.shellMenor_Mayor(V);
                    int inf = 0;
                    int sup = V.length - 1;
                    System.out.println(" el numero buscado esta en la posicicion: " + bs.busqueda(V, tam, x, inf, sup));

                    break;
                case 5:
                    System.out.println("suma");
                    suma sm = new suma();

                    System.out.println(sm.suma(V, tam));
                    break;

            }
        } while (m != 6);

    }

}
