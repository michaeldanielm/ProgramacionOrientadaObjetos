package Vista;
import java.awt.* ;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.TitledBorder;


public class TableroAtaques extends JPanel 
{	
	private final static int TAMANO_VECTOR = 10 ;

	private JPanel panelJuego = new JPanel() ;

	private JButton casillas[][] = new JButton[TAMANO_VECTOR][TAMANO_VECTOR] ;
	private GridBagLayout capaGeneral ;
	private GridBagConstraints configuracionCapa = new GridBagConstraints();

	private JLabel etiquetasLetras[] = new JLabel[TAMANO_VECTOR];
	private JLabel etiquetasNumeros[] = new JLabel[TAMANO_VECTOR];
	private TitledBorder tituloTableroJuego ;


	private static final String nombreLetras[] = {"A","B","C","D","E","F","G","H","I","J"};
	private static final String nombreNumeros[] = {"1","2","3","4","5","6","7","8","9","10"};

	public TableroAtaques()
	{	
		setLayout(new BorderLayout());
		PanelJuego();
		setVisible(true);
	}


	public void PanelJuego()
	{
		capaGeneral = new GridBagLayout();
		panelJuego.setLayout(capaGeneral);	
		panelTablero();
		panelLetras();
		panelNumeros();

		tituloTableroJuego = BorderFactory.createTitledBorder( " Panel de Ataques ");
		tituloTableroJuego.setTitleJustification(TitledBorder.LEFT);

		panelJuego.setBorder(tituloTableroJuego);
		panelJuego.setSize(600,600);
		
		add(panelJuego,BorderLayout.CENTER);
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
			etiquetasNumeros[i] = new JLabel(nombreNumeros[i]) ;
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

}