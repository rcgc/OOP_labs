import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MiVentana extends JFrame implements ActionListener{	//Me marca error porque cuando se emplean interfaces
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton boton1, boton2;									//se usan todos los metodos abstractos de la interfaz
	private JPanel panel;
	private Canvas pintado;
	
	public MiVentana() {
		super();
		setLayout(new BorderLayout());
		boton1  = new JButton("Azul");
		boton2  = new JButton("Rojo");
		panel   = new JPanel();
		pintado = new Canvas();
		
		//Escuchar mis componentes
		boton1.addActionListener(this);
		boton2.addActionListener(this);
		panel.setLayout(new FlowLayout());
		panel.add(boton1);
		panel.add(boton2);
		//this.add(pintado);
		//this.add(panel);
		
		add(pintado, BorderLayout.CENTER);
		add(panel, BorderLayout.SOUTH);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource()==boton1) {
			pintado.setBackground(new Color(0,0,255));
		}
		
		if(e.getSource()==boton2) {
			pintado.setBackground(new Color(255,0,0));
			JOptionPane.showMessageDialog(null, "Hola", "Hola", JOptionPane.INFORMATION_MESSAGE);
		}
	}
}
