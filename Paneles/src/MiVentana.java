import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MiVentana  extends JFrame implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	JTextField texto;
	JButton boton1, boton2;
	JPanel panel;
	MiCanvas canvas;
	
	
	public MiVentana() {
		super();			//Es necesario esto para que corra porque extiende de JFrame
		texto=new JTextField(10);
		boton1=new JButton("Click 1");
		boton2= new JButton("Click 2");
		panel=new JPanel();
		canvas=new MiCanvas();
		
		this.setLayout(new BorderLayout());
		
		boton1.addActionListener(this);
		boton2.addActionListener(this);
		texto.addActionListener(this);
		
		panel.setLayout(new FlowLayout());
		
		panel.add(boton1);
		panel.add(boton2);
		
		this.add(texto, BorderLayout.NORTH);
		this.add(canvas, BorderLayout.CENTER);
		this.add(panel, BorderLayout.SOUTH);	
	}
	
	public void actionPerformed(ActionEvent event) {
		
		if(event.getSource()==boton1) {
			canvas.setEstado(1);
			canvas.repaint();
			texto.setText("");
		}
		
		if(event.getSource()==boton2) {
			canvas.setEstado(2);
			canvas.repaint();
			texto.setText("");
		}
		
		if(event.getSource()==texto) {
			canvas.setEstado(3);
			canvas.setTxt(texto.getText());
			canvas.repaint();
		}
	}
}