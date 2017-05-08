package Vista;
import java.awt.* ;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.TitledBorder;


public class TableroJuego extends JPanel 
{	
	private final static int TAMANO_VECTOR = 10 ;

	private EventoAtaque eventoAtaque ;

	private JPanel panelJuego = new JPanel() ;
	private JPanel panelHerramientas = new JPanel();

	private JButton casillas[][] = new JButton[TAMANO_VECTOR][TAMANO_VECTOR] ;
	private GridBagLayout capaGeneral ;
	private GridBagConstraints configuracionCapa = new GridBagConstraints();

	private JLabel etiquetasLetras[] = new JLabel[TAMANO_VECTOR];
	private JLabel etiquetasNumeros[] = new JLabel[TAMANO_VECTOR];
	private TitledBorder tituloTableroJuego,tituloHerramientas ;
	private Icon barco1,barco2,barco3,barco4 ;

	private JLabel botonBarco1,botonBarco2,botonBarco3,botonBarco4 ;
	
	private int posicionX , posicionY ;
	
	private static final String nombreLetras[] = {"A","B","C","D","E","F","G","H","I","J"};
	private static final String nombreNumeros[] = {"1","2","3","4","5","6","7","8","9","10"};

	public TableroJuego()
	{	
		setLayout(new FlowLayout());
		PanelJuego();
		//panelHerramientas();
		setVisible(true);
	}


	public void PanelJuego()
	{
		capaGeneral = new GridBagLayout();
		panelJuego.setLayout(capaGeneral);	
		panelTablero();
		panelLetras();
		panelNumeros();


	
		add(panelJuego);
	}
	/*
	public void panelHerramientas()
	{
		panelHerramientas.setLayout(new GridLayout(4,2,10,10));
		
		tituloHerramientas = BorderFactory.createTitledBorder("-----------Panel de Herramientas-----------");
		tituloHerramientas.setTitleJustification(TitledBorder.CENTER);
		
		barco1 = new ImageIcon("barco1.png");
		barco2 = new ImageIcon("barco2.png");
		barco3 = new ImageIcon("barco3.png");
		barco4 = new ImageIcon("barco4.png");
		
		botonBarco1 = new JLabel("",barco1, JLabel.CENTER);
		botonBarco2 = new JLabel("",barco2, JLabel.CENTER);
		botonBarco3 = new JLabel("",barco3, JLabel.CENTER);
		botonBarco4 = new JLabel("",barco4, JLabel.CENTER);
		

		panelHerramientas.add(botonBarco1) ;
		panelHerramientas.add(botonBarco2) ;
		panelHerramientas.add(botonBarco3) ;
		panelHerramientas.add(botonBarco4) ;

		panelHerramientas.setBorder(tituloHerramientas);
		add(panelHerramientas);
	}
	*/
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
		
		setPosicionX(x) ;
		setPosicionY(y) ;
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
		}
	}
}