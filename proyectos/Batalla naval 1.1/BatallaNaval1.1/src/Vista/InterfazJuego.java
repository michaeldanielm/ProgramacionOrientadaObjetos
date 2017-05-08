package Vista;

import java.net.*;
import java.io.*;
import java.awt.* ;

import javax.swing.* ;
import javax.swing.border.TitledBorder;

import java.awt.event.* ;

public class InterfazJuego extends JFrame
	{
	private final static int TAMANO_VECTOR = 10 ;
	
	private TableroAtaques tableroAtaques = new TableroAtaques();
	
	private EventoAtaque eventoAtaque ;

	private JPanel panelJuego = new JPanel() ;
	private JPanel panelEstado = new JPanel();
	private JTextArea areaMensajes = new JTextArea(10,50);
	private JScrollPane barraDesplazadora = new JScrollPane(areaMensajes);
	
	private JButton casillas[][] = new JButton[TAMANO_VECTOR][TAMANO_VECTOR] ;
	private GridBagLayout capaGeneral ;
	private GridBagConstraints configuracionCapa = new GridBagConstraints();

	private JLabel etiquetasLetras[] = new JLabel[TAMANO_VECTOR];
	private JLabel etiquetasNumeros[] = new JLabel[TAMANO_VECTOR];
	
	private JMenu menuArchivo ;
	private JMenuBar barra ;
	private JMenuItem itemConectar;
	
	private ObjectOutputStream salida;
	private ObjectInputStream entrada;
	private String mensaje = "";
	private String servidorJuego;
	private Socket cliente;

	private String host ;
	private EventoConexion eventoConexion = new EventoConexion() ;
	
	private TitledBorder tituloTableroJuego ;

	private static final String nombreLetras[] = {"A","B","C","D","E","F","G","H","I","J"};
	private static final String nombreNumeros[] = {"1","2","3","4","5","6","7","8","9","10"};
	
	private int posicionX, posicionY ;
	
	//static GraphicsDevice grafica = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
	
	public InterfazJuego()
		{
		super(" Panel Principal ") ;
		Container contenedor = getContentPane();
		GridLayout areaInterfaz = new GridLayout(2,2,1,1);
		contenedor.setLayout(areaInterfaz);
		
		PanelJuego();
		contenedor.add(tableroAtaques);	
		
		menuArchivo = new JMenu( "Archivo" );
		menuArchivo.setMnemonic( 'A' );
  
		barra = new JMenuBar();
		setJMenuBar( barra );
		barra.add( menuArchivo ); 
		
		itemConectar= new JMenuItem( "Conectar con servidor");
		itemConectar.setMnemonic( 'C' );
		itemConectar.addActionListener(eventoConexion);
		
		areaMensajes.setEnabled(false);
	    menuArchivo.add( itemConectar );
	    
	    areaMensajes.setDisabledTextColor(Color.RED);
	    areaMensajes.setText("Pendiente establecer la conexion con el servidor");
	    
	    panelEstado.add(barraDesplazadora);
	    contenedor.add(panelEstado);
	    
		//grafica.setFullScreenWindow(this);
		setVisible(true);
		//setUndecorated(true);
		setSize(900,900);

		}
	

	public int getPosicionX() {
		return posicionX;
	}


	public void setPosicionX(int posicionX) {
		this.posicionX = posicionX;
	}


	public int getPosicionY() {
		return posicionY;
	}


	public void setPosicionY(int posicionY) {
		this.posicionY = posicionY;
	}


	public void PanelJuego()
		{
		capaGeneral = new GridBagLayout();
		panelJuego.setLayout(capaGeneral);	
		panelTablero();
		panelLetras();
		panelNumeros();	
		
		tituloTableroJuego = BorderFactory.createTitledBorder( " Panel de Juego ");
		tituloTableroJuego.setTitleJustification(TitledBorder.LEFT);

		panelJuego.setBorder(tituloTableroJuego);

		panelJuego.setBorder(tituloTableroJuego);
		add(panelJuego);
		}
	
	public void panelLetras()
		{
			for (int i = 0; i < TAMANO_VECTOR; i++) 
			{
				etiquetasLetras[i] = new JLabel(nombreLetras[i]) ;
				agregarComponente(etiquetasLetras[i],0,(i+1),1,1);
			}
		}

	public void panelNumeros()
	{
		for (int i = 0; i < TAMANO_VECTOR; i++) 
		{
			etiquetasNumeros[i] = new JLabel(nombreNumeros[i]);
			agregarComponente(etiquetasNumeros[i],(i+1),0,1,1);
		}
	}

	public void panelTablero()
	{
		for (int i = 0; i < TAMANO_VECTOR; i++) 
		{	
			for (int j = 0; j < TAMANO_VECTOR; j++) 
			{
				casillas[i][j] = new JButton(" ") ;
				casillas[i][j].setFocusPainted(false);
				casillas[i][j].setContentAreaFilled(false);


				eventoAtaque = new EventoAtaque(i,j) ;
				casillas[i][j].addActionListener(eventoAtaque);

				agregarComponente(casillas[i][j],(i+1),(j+1),1,1);
			}
		}

	}
	public void agregarComponente(Component componente,int x, int y, int ancho, int alto)
	{
		configuracionCapa.gridx = x ;
		configuracionCapa.gridy = y ;
		configuracionCapa.gridwidth = ancho ;
		configuracionCapa.gridheight = alto ;
		configuracionCapa.anchor = GridBagConstraints.LINE_START;  
		capaGeneral.setConstraints(componente, configuracionCapa);
		panelJuego.add(componente);
	}


	public void inactivarBoton(int x, int y)
	{
		this.casillas[x][y].setBackground(Color.BLACK) ;
		casillas[x][y].setContentAreaFilled(true);
		casillas[x][y].setEnabled(false);

	}
	
	private class EventoAtaque implements ActionListener
	{
		private int x , y ;

		public EventoAtaque(int x , int y)
		{
			this.x = x ;
			this.y = y ;
		}

		public void actionPerformed(ActionEvent evento) 
		{
			inactivarBoton(x,y);
			enviarDatos(x,y);			
		}
	}	
	
	public void establecerHost(String host)
		{
		this.host = host ;
		}
	public void ejecutarCliente()
		{
		servidorJuego = host; // establecer el servidor al que se va a conectar este cliente
		try 
			{
			conectarAServidor();
			obtenerFlujos();
			procesarConexion();
			}
		catch ( EOFException excepcionEOF ) {
			areaMensajes.append( "El cliente termino la conexión" );
	      }
	 
	      // procesar los problemas que pueden ocurrir al comunicarse con el servidor
	      catch ( IOException excepcionES ) {
	         excepcionES.printStackTrace();
	      }
	 
	      finally {
	      //   cerrarConexion(); // Paso 4: cerrar la conexión
	      }
		}
	
	private void conectarAServidor() throws IOException
	   {
		areaMensajes.append( "Intentando realizar conexión\n" );
	 
	      // crear Socket para realizar la conexión con el servidor
	    cliente = new Socket( InetAddress.getByName( servidorJuego ), 12345 );
	      
	    areaMensajes.setDisabledTextColor(Color.black);
       	areaMensajes.setText("Conexion realizada con el servidor");
        areaMensajes.append( "\nConectado a: " + cliente.getInetAddress().getHostName());
	   }
	 
	   // obtener flujos para enviar y recibir datos
	   private void obtenerFlujos() throws IOException
	   {
	      salida = new ObjectOutputStream( cliente.getOutputStream() );
	      salida.flush(); // vacíar búfer de salida para enviar información de encabezado
	 
	      // establecer flujo de entrada para los objetos
	      entrada = new ObjectInputStream( cliente.getInputStream() );
	 
	      System.out.println( "\nSe recibieron los flujos de E/S\n" );
	      try {
			System.out.println(entrada.readObject());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   }
	 
	   // procesar la conexión con el servidor
	   private void procesarConexion() throws IOException
	   {
	 
	   } // fin del método procesarConexion
	
	   private void enviarDatos(int x, int y)
	   {		     
	    try 
	    	{
	    	salida.writeObject(x+","+y) ;
	    	salida.flush();
	    	}
	    catch (IOException e) 
	    	{
			e.printStackTrace();
	    	}
	   }
	   
	private class EventoConexion implements ActionListener
		{
			public void actionPerformed(ActionEvent arg0) 
			{
			host = JOptionPane.showInputDialog("Ingrese el numero de la direccion ip a la cual desea conectarse","127.0.0.1") ;	
			
			establecerHost(host);
			ejecutarCliente();			
			}		
		}
	
	public static void main(String args[])
		{
		InterfazJuego interfaz = new InterfazJuego() ;
		interfaz.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
	}