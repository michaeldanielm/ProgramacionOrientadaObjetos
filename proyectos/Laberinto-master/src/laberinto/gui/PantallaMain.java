package laberinto.gui;

import static java.awt.Color.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import javax.swing.*;
import laberinto.*;

/**
 *
 * @author Michael Daniel Murillo
 */
//clase que crea la ventana inicial, el menú, y gestiona la funcionalidad de
//las opciones, además de llamar al constructor del PanelLaberinto
public class PantallaMain extends JFrame {

    public static int height;
    public static int width;

    //el constructor recibe el fichero por parametro para definir el tamaño de la ventana
    public PantallaMain(File fileLab){

        FicheroIn fichero = null;
        try {
            fichero = new FicheroIn(fileLab.getAbsolutePath());
        } catch (FileNotFoundException ex) {
            System.out.println("¡Error: no se encuentra el fichero!");
        }
        //leemos del fichero el numero de filas y columnas para especificar el tamaño
        int[] filCol = fichero.getFilasColumnas();
        PantallaMain.height = filCol[0] * 30 + 60;
        PantallaMain.width = filCol[1] * 30 + 7;

        this.setSize(width, height);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setResizable(false);

        //creamos la estructura de datos de tablero y llenamos
        Tablero tab = new Tablero(fileLab);

        //creamos la barra del menu
        JMenuBar barraMenu = new JMenuBar();
        barraMenu.setBounds(0, 0, width, 30);
        barraMenu.setBackground(DARK_GRAY);
        barraMenu.setVisible(true);
        this.setVisible(true);
        this.add(barraMenu);

        //creamos el panel donde se dibujara el laberinto
        PanelLaberinto panLab = new PanelLaberinto(fileLab);
        panLab.setBounds(0, 30, width, height - 30);
        panLab.setVisible(true);
        this.add(panLab);
        panLab.requestFocus();  //pedimos el focus del Listener para el correcto
        //funcionamiento del KeyListener

        //creamos el menú
        JMenu menu = new JMenu("Fichero");
        menu.setForeground(WHITE);
        menu.setVisible(true);
        barraMenu.add(menu);

        //selecciones
        //1era selección, seleccionar fichero laberinto
        JMenuItem abrir = new JMenuItem("Abrir Laberinto");
        JFileChooser select = new JFileChooser();
        abrir.addActionListener((new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int returnVal = select.showOpenDialog(select);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    //guardamos el fichero laberinto seleccionado en labFile
                    File labFile = (select.getSelectedFile());

                    //cerramos el actual laberinto
                    cerrarVentana();
                    PantallaMain nueva = new PantallaMain(labFile);
                }
            }
        }));
        menu.add(abrir);

        //2a selección, reinicio de posición de la ficha
        JMenuItem reinit = new JMenuItem("Reiniciar Posición");
        reinit.addActionListener(((ActionEvent ae) -> {
            panLab.getFicha().resetPosicion();
            panLab.repaint();
        }));
        menu.add(reinit);

        //3a selección, salida del programa
        JMenuItem salir = new JMenuItem("Salir");
        salir.addActionListener((ActionEvent ae) -> {
            System.exit(0);
        });
        menu.add(salir);

        this.setVisible(true);

        System.out.println("Interfaz gráfica creada, fichero: " + fileLab.getName());
    }

    //método que cierra el PantallaMain actual sin salir del programa
    public void cerrarVentana() {
        this.dispose();
    }

}
