package Logica ;

import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;
import javax.swing.*;
public class Servidor extends JFrame {
   private char[][] tablero;
   private JTextArea areaSalida;
   private Jugador[] jugadores;
   private ServerSocket servidor;
   private int jugadorActual;
   private final int JUGADOR_X = 0, JUGADOR_Y = 1;
   private final char MARCA_X = 'X', MARCA_Y = 'Y';
   private char ganador = ' ';
   // establecer servidor de tres en raya y GUI para mostrar mensajes
   public Servidor()
   {
      super( "Servidor de conexion Batalla Naval" );
      tablero = new char[ 10 ][ 10 ];
      jugadores = new Jugador[ 2 ];
      jugadorActual = JUGADOR_X;
      // establecer objeto ServerSocket
      try {
         servidor = new ServerSocket( 12345, 2 );
      }
      // procesar los problemas que pueden ocurrir al crear el objeto ServerSocket
      catch( IOException excepcionES ) {
         excepcionES.printStackTrace();
         System.exit( 1 );
      }
      // establecer objeto JTextArea para mostrar mensajes durante la ejecuci�n
      areaSalida = new JTextArea();
      getContentPane().add( areaSalida, BorderLayout.CENTER );
      areaSalida.setText( "Servidor esperando conexiones..\n" );
      setSize( 300, 300 );
      setVisible( true );
   } // fin del constructor de ServidorTresEnRaya
   // esperar dos conexiones para poder jugar
   public void ejecutar()
   {
      // esperar a que se conecte cada cliente
      for ( int i = 0; i < jugadores.length; i++ ) {
         // esperar conexi�n, crear Jugador, iniciar subproceso
         try {
            jugadores[ i ] = new Jugador( servidor.accept(), i );
            jugadores[ i ].start();
         }
         // procesar los problemas que pueden ocurrir al recibir la conexi�n del cliente
         catch( IOException excepcionES ) {
            excepcionES.printStackTrace();
            System.exit( 1 );
         }
      }
      // El Jugador X se suspende hasta que se conecte el Jugador O.
      // Reactivar ahora al jugador X.
      synchronized ( jugadores[ JUGADOR_X ] ) {
         jugadores[ JUGADOR_X ].establecerSuspendido( false );
         jugadores[ JUGADOR_X ].notify();
      }
   }  // fin del m�todo ejecutar
   // m�todo utilitario que es llamado desde otros subprocesos para manipular a
   // areaSalida en el subproceso despachador de eventos
   private void mostrarMensaje( final String mensajeAMostrar )
   {
      // mostrar mensaje del subproceso de ejecuci�n despachador de eventos
      SwingUtilities.invokeLater(
         new Runnable() {  // clase interna para asegurar que la GUI se actualice apropiadamente
            public void run() // actualiza a areaSalida
            {
               areaSalida.append( mensajeAMostrar );
               areaSalida.setCaretPosition(
                  areaSalida.getText().length() );
            }
         }  // fin de la clase interna
      ); // fin de la llamada a SwingUtilities.invokeLater
   }
   // Determinar si un movimiento es v�lido. Este m�todo es sincronizado porque
   // s�lo puede realizarse un movimiento a la vez.
   public synchronized boolean validarYMover( int posicionX,int posicionY, int jugador )
   {
      boolean movimientoRealizado = false;
      // mientras no sea el jugador actual, debe esperar su turno
      while ( jugador != jugadorActual ) {
         // esperar su turno
         try {
            wait();
         }
         // atrapar interrupciones de wait
         catch( InterruptedException excepcionInterrupcion ) {
            excepcionInterrupcion.printStackTrace();
         }
      }
      // si la posici�n no est� ocupada, realizar movimiento
      if ( !estaOcupada( posicionX,posicionY ) ) {
         // establecer movimiento en arreglo del tablero
         tablero[ posicionX ][ posicionY ] = jugadorActual == JUGADOR_X ? MARCA_X : MARCA_Y;
         // cambiar jugador actual
         jugadorActual = ( jugadorActual + 1 ) % 2;
         // hacer saber al nuevo jugador actual que ocurri� un movimiento
         jugadores[ jugadorActual ].elOtroJugadorMovio( posicionX );
         notify(); // indicar al jugador en espera que contin�e
         // indicar al jugador que hizo el movimiento, que �ste fue v�lido
         return true;
      }
      // indicar al jugador que hizo el movimiento, que �ste no fue v�lido
      else
         return false;
   } // fin del m�todo validarYMover
   // determinar si la posici�n est� ocupada
   public boolean estaOcupada( int posicionX , int posicionY )
   {
      if ( tablero[ posicionX ][ posicionY ] == MARCA_X || tablero [ posicionX ][ posicionY ] == MARCA_Y )
          return true;
      else
          return false;
   }
   // colocar c�digo en este m�todo para determinar si termin� el juego
   public boolean terminoElJuego(ObjectOutputStream salida)
   {
	  return false;
   }
   public static void main( String args[] )
   {
	   Servidor aplicacion = new Servidor();
      aplicacion.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
      aplicacion.ejecutar();
   }
  // la clase interna privada Jugador administra a cada Jugador como un subproceso
   private class Jugador extends Thread {
      private Socket conexion;
      private ObjectInputStream entrada;
      private ObjectOutputStream salida;
      private int numeroJugador;
      private char marca;
      protected boolean suspendido = true;
      // establecer subproceso para Jugador
      public Jugador( Socket socket, int numero )
      {
         numeroJugador = numero;
         // especificar la marca del jugador
         marca = ( numeroJugador == JUGADOR_X ? MARCA_X : MARCA_Y );
         conexion = socket;
         // obtener flujos del  objeto Socket
         try {
            entrada = new ObjectInputStream( conexion.getInputStream() );
            salida = new ObjectOutputStream( conexion.getOutputStream() );
         }
         // procesar los problemas que pueden ocurrir al obtener los flujos
         catch( IOException excepcionES ) {
            excepcionES.printStackTrace();
            System.exit( 1 );
         }
      } // fin del constructor de Jugador
      // enviar mensaje indicando que el otro jugador hizo un movimiento
      public void elOtroJugadorMovio( int posicion )
      {
         // enviar mensaje indicando el movimiento
         try {
            salida.writeUTF( "El oponente hizo un movimiento" );
            salida.writeInt( posicion );
         }
         // procesar los problemas que pueden ocurrir al enviar un mensaje
         catch ( IOException excepcionES ) {
            excepcionES.printStackTrace();
         }
      }
      // controlar la ejecuci�n del subproceso
      public void run()
      {
         // enviar mensaje al cliente indicando su marca (X o O),
         // procesar mensajes del cliente
         try {
        	 mostrarMensaje( "Jugador " + ( numeroJugador ==
               JUGADOR_X ? MARCA_X : MARCA_Y ) + " conectado\n" );
            salida.writeChar( marca ); // enviar marca del jugador
            // enviar mensaje indicando que hay conexi�n
            salida.writeUTF( "Jugador " + ( numeroJugador == JUGADOR_X ?
               "X conectado\n" : "O conectado, por favor espere\n" ) );
            // si es jugador X, esperar a que llegue el otro jugador
            if ( marca == MARCA_X ) {
               salida.writeUTF( "Esperando al otro jugador" );
               // esperando al jugador O
               try 
	               {
	                  synchronized( this ) 
	                  	{
	                     while ( suspendido )
	                        wait();
	                  	}
	               }
               // procesar interrupciones mientras est� en espera
               catch ( InterruptedException excepcion ) {
                  excepcion.printStackTrace();
               }
               // enviar mensaje indicando que el otro jugador se conect� y
               // que el jugador X puede realizar un movimiento
               salida.writeUTF( "El otro jugador se conect�. Le toca a usted mover." );
            }
            // mientras el juego no est� terminado
            while ( ! terminoElJuego(salida) ) {
               // obtener del cliente la posici�n del movimiento
               int posicionX = entrada.readInt();
               int posicionY = entrada.readInt();
               // comprobar que sea un movimiento v�lido
               if ( validarYMover( posicionX,posicionY, numeroJugador ) ) {
                  mostrarMensaje( "\nposici�n: " + posicionX );
                  salida.writeUTF( "Movimiento v�lido." );
               }
               else
                  salida.writeUTF( "Movimiento inv�lido, intente otra vez" );
            }
            salida.writeUTF( "Gano el jugador " + ganador);
            conexion.close(); // cerrar conexi�n con el cliente
         } // fin del bloque try
         // procesar los problemas que pueden ocurrir al comunicarse con el cliente
         catch( IOException excepcionES ) {
            excepcionES.printStackTrace();
            System.exit( 1 );
         }
      } // fin del m�todo run
      // establecer si el subproceso est� suspendido o no
      public void establecerSuspendido( boolean estado )
      {
         suspendido = estado;
      }
   } // fin de la clase Jugador
} // fin de la clase ServidorTresEnRaya