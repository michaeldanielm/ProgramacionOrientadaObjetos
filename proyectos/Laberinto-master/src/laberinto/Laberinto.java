package laberinto;

import java.io.File;
import laberinto.gui.*;

/**
 *
 * @author Michael Daniel Murillo
 */
//inicio de la aplicación, seleccionamos un fichero inicial y lo pasamos por
//parámetro
public class Laberinto {

    public static void main(String[] args) {
        
        File laberinto = new File("maze1.txt");
        PantallaMain inicio = new PantallaMain(laberinto);

    }

}
