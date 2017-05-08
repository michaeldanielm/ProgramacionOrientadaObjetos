package laberinto;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;

/**
 *
 * @author Michael Daniel Murillo
 */
//Ficha es un objeto que será único, consta de su posición actual y de una 
//constante que almacena su posición inicial creada aleatoriamente para el reinicio
//de su posición
public final class Ficha {

    private int fila;
    private int columna;
    private static int filaInicial;
    private static int columnaInicial;

    //un Random entre 0 y el numero de filas y columnas inicia la posicion 
    //inicial de la ficha
    public Ficha() {
        Random rnd = new Random();
        this.fila = rnd.nextInt(Tablero.getFil());
        this.columna = rnd.nextInt(Tablero.getCol());
        Ficha.filaInicial = this.fila;
        Ficha.columnaInicial = this.columna;

        System.out.println("Ficha creada en: [" + this.getFila() + ", " + this.getColumna() + "]");
    }

    //este método reinicia la posicion de la ficha
    public void resetPosicion() {
        this.setFila(this.getFilaInicial());
        this.setColumna(this.getColumnaInicial());

        System.out.println("Reinicio posición ficha.");
    }

    //getters y setters para los atributos privados
    public int getFila() {
        return this.fila;
    }

    public int getColumna() {
        return this.columna;
    }

    public void setFila(int x) {
        this.fila = x;
    }

    public void setColumna(int y) {
        this.columna = y;
    }

    public int getFilaInicial() {
        return Ficha.filaInicial;
    }

    public int getColumnaInicial() {
        return Ficha.columnaInicial;
    }

    //función que pinta la ficha segun su posición actual
    public void paintComponent(Graphics g) {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("ficha.png"));
        } catch (IOException e) {
            System.out.println("¡Error: no se pudo cargar la imagen de ficha!");
        }
        g.drawImage(img, (this.getColumna()) * Casilla.dimension,
                (this.getFila()) * Casilla.dimension, 30, 30, null);

    }

}
