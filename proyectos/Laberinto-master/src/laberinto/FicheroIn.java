package laberinto;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Michael Daniel Murillo
 */
//clase para la lectura del fichero seleccionado
public class FicheroIn {

    public BufferedReader br;
    private final FileReader fr;

    //constructor, gestión de posible error al no encontrar el fichero
    public FicheroIn(String lab) throws FileNotFoundException {
        this.fr = new FileReader(lab);
        this.br = new BufferedReader(fr);
        
    }

    //mediante la funcion readLine leemos las 2 primeras lineas del fichero y 
    //las guardamos en un array de 2 enteros, uno para fila y otro para columna
    public int[] getFilasColumnas() {
        int[] filCol = new int[2];
        try {
            try {
                filCol[0] = Integer.parseInt(br.readLine());
            } catch (IOException ex) {
                System.out.println("¡Error en la lectura del número de filas!");
            }
            filCol[1] = Integer.parseInt(br.readLine());

        } catch (IOException ex) {
            System.out.println("¡Error en la lectura del número de columnas!");
        }
        return filCol;
    }

    //método para la lectura de cada uno de los bits que definen cada Casilla
    public int getBit() {
        int bit = 0;
        try {
            bit = br.read() - 48; //convertimos a entero
        } catch (IOException ex) {
            System.out.println("¡Error en la lectura de bits!");
        }
        return bit;

    }

}
