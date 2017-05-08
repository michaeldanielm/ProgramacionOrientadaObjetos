package Vista;
import java.awt.* ;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.TitledBorder;

public class PanelHerramientas extends JPanel
{
	private TitledBorder tituloArea ;
	private JLabel botonBarco1 ;
	private Icon barco ;
	
	private AccionesObjetos accionBarcos = new AccionesObjetos();
	
	public PanelHerramientas()
	{
		tituloArea = BorderFactory.createTitledBorder( " Panel de mensajes ");
		tituloArea.setTitleJustification(TitledBorder.LEFT);
		barco = new ImageIcon("barco.png");
		
		botonBarco1 = new JLabel("",barco, JLabel.CENTER);
		botonBarco1.addMouseMotionListener(accionBarcos);

		add(botonBarco1) ;
	
		setBorder(tituloArea);
		setVisible(true);	
	}
	
	private class AccionesObjetos extends MouseMotionAdapter
		{
			public void mouseDragged(MouseEvent e) 
				{
				Component c = e.getComponent();
				c.setLocation( c.getX()+e.getX(), c.getY()+e.getY() );
				repaint();
				}
		}

}
