package laberinto.gui;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import laberinto.*;

/**
 *
 * @author Michael Daniel Murillo
 */
//ésta clase crea el JPanel donde se dibuja nuestro juego, tanto el tablero
//como la ficha. Además implementa KeyListener y por tanto gestiona la 
//interacción del teclado con nuestro juego
public class PanelLaberinto extends JPanel implements KeyListener {

    //contiene un objeto tablero y otro objeto ficha
    private final Tablero tablero;
    private final Ficha ficha;

    //constructor despues de haber seleccionado un fichero, crea un tablero 
    //y una ficha, ademas de añadir el Listener del teclado
    public PanelLaberinto(File fileLab){
        this.setLayout(null);
        this.tablero = new Tablero(fileLab);
        System.out.println("Tablero creado.");
        this.ficha = new Ficha();
        
        //añadimos el teclado
        addKeyListener(this);
        //setFocusable es necesario para que el KeyListener se fije en el JPanel
        //y responda al teclado
        this.setFocusable(true);

    }

    public Tablero getTablero() {
        return this.tablero;
    }

    public Ficha getFicha() {
        return this.ficha;
    }

    //método que dibujará tanto el tablero como la ficha, llamando a sus
    //respectivos métodos
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        tablero.paintComponent(g);
        ficha.paintComponent(g);

    }

    //gestión del teclado
    @Override
    public void keyTyped(KeyEvent ke) {
    }

    @Override
    public void keyReleased(KeyEvent ke) {
    }

    //únicamente hacemos uso de pulsar una tecla. Este método modificará la 
    //posición de la ficha si obtiene false de su booleano get (no hay pared),
    //y repintará tras la modificación.
    //En caso de haber pared reproducirá un sonido de choque, y un sonido de
    //victoria una vez la ficha llegue al exit del juego.
    @Override
    public void keyPressed(KeyEvent ke) {
        System.out.println("Tecla pulsada: " + KeyEvent.getKeyText(ke.getKeyCode()));
        File bump = new File("smb_bump.wav");
        File win = new File("win.wav");
        //mediante un switch modificamos la posición segun la tecla pulsada, si
        //la tecla no es WASD no hará nada.
        switch (KeyEvent.getKeyText(ke.getKeyCode())) {
            case "W":
                //comprobamos si intenta cruzar una pared
                if (tablero.tab[ficha.getFila()][ficha.getColumna()].getNorth()) {
                    //y si es así reproducimos sonido
                    sonido(bump);
                    break;
                }
                ficha.setFila(ficha.getFila() - 1);
                repaint();
                break;

            case "D":
                if (tablero.tab[ficha.getFila()][ficha.getColumna()].getEast()) {
                    sonido(bump);
                    break;
                }
                ficha.setColumna(ficha.getColumna() + 1);
                repaint();
                break;

            case "S":
                if (tablero.tab[ficha.getFila()][ficha.getColumna()].getSouth()) {
                    sonido(bump);
                    break;
                }
                ficha.setFila(ficha.getFila() + 1);
                repaint();
                break;

            case "A":
                if (tablero.tab[ficha.getFila()][ficha.getColumna()].getWest()) {
                    sonido(bump);
                    break;
                }
                ficha.setColumna(ficha.getColumna() - 1);
                repaint();
                break;

        }
        System.out.println("Ficha en: [" + ficha.getFila() + ", " + ficha.getColumna() + "]");
        System.out.println("Exit en: " + Arrays.toString(tablero.posFin) + "\n");

        //comprobamos si la ficha ha llegado a exit
        if (ficha.getFila() == tablero.posFin[0] && ficha.getColumna() == tablero.posFin[1]) {
            sonido(win);    //sonido victoria
            System.out.println("Ficha en exit.");
            //creamos un dialogo de victoria, ademas reiniciamos la posición de la ficha
            JOptionPane optionPane = new JOptionPane(new JLabel("¡Has ganado!", JLabel.CENTER));
            JDialog dialog = optionPane.createDialog("");
            dialog.setModal(true);
            dialog.setVisible(true);

            ficha.resetPosicion();

            repaint();
        }
    }

    //método que reproduce el sonido pasado por parámetro
    private void sonido(File audio) {
        AudioInputStream audioInputStream = null;
        try {
            audioInputStream = AudioSystem.getAudioInputStream(audio);
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            System.out.println("¡Error en la reproducción de sonido!");
        } finally {
            try {
                audioInputStream.close();
            } catch (IOException ex) {
                System.out.println("¡Error al cerrar archivo de sonido!");
            }
        }
    }

}
