
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.applet.*;
import java.awt.*;

class Convertidor extends Applet {

    private static final long serialVersionUID = 1L;

    public static void main(String[] args) {
        Michael window = new Michael();
        window.setVisible(true);
    }
}

class Michael extends JFrame {

    private static final long serialVersionUID = 1L;
    // Inicializar cosas.
    private final JLabel lab1;
    private final JLabel lab2;
    private final JTextArea input;
    private final JTextArea output;
    private final JButton toDec;
    private final JButton toAsc;

    public Michael() {
         // Crear las especificaciones de interfaz gráfica de usuario
        setTitle("Convertidor de Dicimal A Ascii");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(new FlowLayout());

        // Etiqueta materia
        lab1 = new JLabel("Enter ASCII de entrada / decimal aquí:");
        lab2 = new JLabel("Salida:");

         // herramientas de texto
        input = new JTextArea(5, 23);
        input.setLineWrap(true);
        input.setWrapStyleWord(true);
        JScrollPane scrollin = new JScrollPane(input);

        output = new JTextArea(5, 23);
        output.setEditable(false);
        output.setLineWrap(true);
        output.setWrapStyleWord(true);
        JScrollPane scrollout = new JScrollPane(output);

        // Cosas Botón
        toDec = new JButton("¡Quiero decimal!");
        toDec.addActionListener(new Action());
        toAsc = new JButton("Quiero ASCII!");
        toAsc.addActionListener(new Action());

        // Añadir a la interfaz gráfica de usuario real.
        add(lab1);
        add(scrollin);
        add(lab2);
        add(scrollout);
        add(toDec);
        add(toAsc);

    }

    public class Action implements ActionListener {
        //Un método de instancia en una subclase con la misma firma
        @Override
        public void actionPerformed(ActionEvent e) {
            // Se asegura de texto está en blanco antes de escribir en él.
            output.setText(null);

            // Si se hace clic en el botón TODEC.
            if (e.getSource() == toDec) {

                // crear una cola de números enteros.
                Queue<Integer> intStack = new Queue<>();
                // lee la entrada y almacenar en 'in'
                String in = input.getText();

                // cadena Iterar; empujar cada elemento en la cola.
                for (char x : in.toCharArray()) {
                    intStack.push((int) x);
                }

                // Iterar a través de la pila e imprime cada elemento.
                while (!intStack.isEmpty()) {
                    output.append(intStack.pop() + " ");
                }
            }
            // Si se hace clic en el botón toAsc.
            if (e.getSource() == toAsc) {
                //Create a Queue of Characters.
                Queue<Character> intStack = new Queue<>();

                // lee la entrada y almacenar en 'in'
                String in = input.getText();

               // separada por espacios en blanco.
                String[] inn = in.split(" ");

                //Crear una a nueva array para ingresar un entero
                int[] result = new int[inn.length];

                // Convertir la matriz de cadenas a int array
                for (int i = 0; i < inn.length; i++) {
                    try {
                        result[i] = Integer.parseInt(inn[i]);
                    } catch (NumberFormatException err) {
                        output.setText("Excepción de formato de número");
                    }
                }

                // cadena Iterar; empujar cada elemento en la cola
                for (int x : result) {
                    intStack.push((char) x);
                }

               // Iterar a través de la pila e imprime cada elemento.
                while (!intStack.isEmpty()) {
                    output.append(intStack.pop() + " ");
                }

            }
        }
    }
}

// Una clase genérica de cola.
class Queue<Item> {

    private Node first = null;
    private Node last = null;

    private class Node {
/*Un nodo de entrada se utiliza para recibir un mensaje en un flujo de mensajes,
normalmente de un origen no soportado por los nodos de entrada incorporados.
  */     
        Item item;
        Node link;
    }

    public boolean isEmpty() {
        // Devuelve verdadero / falso si la parte superior está vacía.
        return first == null;
    }

     // Añade un 'artículo' hasta el final de la cola.
    public void push(Item item) {
         // Crear un nuevo nodo.
        Node newNode = new Node();
        // elemento de Nodo es el artículo
        newNode.item = item;
        // puntos nodo en NULL;
        newNode.link = null;
        // asigna el primer elemento a ser el newNode
        if (first == null) {
            first = newNode;
        } // Si el primer elemento no está vacío, por último enlace apunta a newNode
        else {
            last.link = newNode;
        }
        // El newNode es ahora el último elemento.
        last = newNode;
    }

    // Devuelve un 'tema' de la cola.
    public Item pop() {
        // Crear una copia del elemento del nodo superior.
        Item tmp = first.item;
        // Establecer el primer elemento a null para GC
        first.item = null;
        // En primer lugar es que es enlace.
        first = first.link;
        // devolver .
        return tmp;
    }
}
