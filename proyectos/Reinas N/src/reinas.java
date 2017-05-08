import java.util.*;
import java.util.Map;
import java.util.HashMap;
import java.io.PrintWriter;
import java.io.IOException;

public class reinas {
    static boolean grafico  = false,                         //opciones de ejecucion
                   traza    = false,
                   archivo  = false;

    static String  file,
                   mensaje      = "\n",
                   mensajeTraza = "\n";                       //cadenas de informacion (archivo, mensajes y traza)

    private static void desplegar(int numero) {               //implementación del algoritmo "Vuelta atrás"
        int[] matriz = new int[numero];                       //matriz de enteros para las posiciones
        desplegar(matriz, 0);
    }

    private static void desplegar(int[] matriz, int numero) {
        if (numero == matriz.length) imprimir(matriz);
        else {
            for (int i = 0; i < matriz.length; i++) {
                matriz[numero] = i;
                if (aSalvo(matriz, numero)) desplegar(matriz, numero+1);
            }
        }
    }

    private static boolean aSalvo(int[] matriz, int numero) { //comprobamos que no hay conflicto entre reinas
        for (int i = 0; i < numero; i++) {
            if (matriz[i] == matriz[numero]) {
                return false;   //coincide columna
            } if ((matriz[i] - matriz[numero]) == (numero - i)) {
                return false;   //coincide diagonal superior
            } if ((matriz[numero] - matriz[i]) == (numero - i)) {
                return false;   //coincide digaonal inferior
            }
        }
        return true;           //ninguna de las anteriores: es imprimible
    }

    private static void imprimir(int[] matriz) {             //método para impresión de los resultados
        final Map <Integer,Character> map = new HashMap<Integer,Character>(); //mapeo de coordenada x - letra
        PrintWriter writer;

        int contador = 1;

        for(char alfabeto = 'a'; alfabeto <= 'z'; alfabeto++) {
            map.put(contador, alfabeto);
            contador++;
        }

        if(!archivo){                                   //si no es salida por archivo
            for (int i = 0; i < matriz.length; i++) {
                for (int j = 0; j < matriz.length; j++) {
                    if (grafico){                       //opcion grafica
                        if (matriz[i] == j) {
                            System.out.printf("R ");
                        } else {
                            System.out.printf("* ");
                        }
                    } else if (traza) {                 //opcion de traza
                        if (matriz[i] == j) {
                          mensajeTraza = mensajeTraza + "Posición " + map.get((matriz.length - i)) + "" + ++j + " aceptada\n---------------------\n";
                          System.out.printf(map.get((matriz.length - i)) + "" + j + " ");
                        }
                    } else if (!archivo) {
                        if (matriz[i] == j) System.out.printf(map.get((matriz.length - i)) + "" + ++j + " ");
                    }
                }
                if (grafico) System.out.println();
            }
            System.out.println();

        } else {                                          //impresion por archivo
            try {
                writer = new PrintWriter(file, "UTF-8");

                for (int i = 0; i < matriz.length; i++) {
                    for (int j = 0; j < matriz.length; j++) {
                        if (grafico){                     //opcion grafica
                            if (matriz[i] == j) mensaje = mensaje + "R ";
                            else                mensaje = mensaje + "* ";
                        } else if (!grafico && !traza) {  //volcado de resultados normales
                            if (matriz[i] == j) mensaje = mensaje + map.get((matriz.length - i)) + "" + ++j + " ";
                        } else if (traza) {               //volcado de la traza
                            if (matriz[i] == j) {
                                mensajeTraza = mensajeTraza + "Posición " + map.get((matriz.length - i)) + "" + ++j + " aceptada\n";

                                mensaje = mensaje + map.get((matriz.length - i)) + "" + ++j + " ";
                            }
                        }
                    }
                    if (grafico && !traza) mensaje = mensaje + "\n";
                }
                mensaje = mensaje + "\n";

                if (traza) mensajeTraza = mensajeTraza + "\n";

                if (grafico)    writer.printf(mensaje);      //directivas para la impresion en el archivo
                else if (traza) writer.printf(mensajeTraza);
                else           {writer.printf(mensaje);}

                writer.close();
            } catch (IOException e) {                        //tratamiento de error de lectura del archivo
                System.out.println("ERROR: lectura del archivo");
            }
        }
    }

    public static void main(String[] args) {   //metodo principal: manejo de opciones pasadas como argumentos
        if (args.length > 1) {
            if      (args[0].equals("-g"))     grafico = true;
            else if (args[0].equals("-t"))     traza   = true;

            if (args.length == 2) {            //impresion con opciones
                if      (args[0].equals("-g")) {grafico = true; archivo = false; desplegar(Integer.parseInt(args[1]));}
                else if (args[0].equals("-t")) {traza   = true; archivo = false; desplegar(Integer.parseInt(args[1]));}
                else                           {archivo = true; file = args[1];  desplegar(Integer.parseInt(args[0]));}

            } else if (args.length == 3){      //impresion con opciones y volcado en archivo
                archivo = true;
                file = args[2];

                if      (args[0].equals("-g")) grafico = true;
                else if (args[0].equals("-t")) traza = true;

                desplegar(Integer.parseInt(args[1]));
            }

        } else if (args.length == 1) {          //opciones simples
            if (args[0].equals("-h")) {         //opcion de ayuda
                System.out.println("SINTAXIS:");
                System.out.println("reinas [-t][-h] N [fichero_salida]");
                System.out.println("-t Traza");
                System.out.println("-g Modo gráfico");
                System.out.println("-h Muestra esta ayuda");
                System.out.println("N Tamaño del tablero y número de reinas. fichero_salida Nombre del fichero de salida");
            } else {                             //invocacion del programa sin opciones
              desplegar(Integer.parseInt(args[0]));
            }
        }
        if (!archivo) System.out.println(mensajeTraza);  //impresion de la traza recopilada
    }
}