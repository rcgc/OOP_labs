import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.Timer;


	/**
	 * 
	 * @author Roberto Guzmán
	 *
	 */

public class MiCanvas extends Canvas implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Pelotas lista;
	private Timer reloj;
	private int contador;
	private BufferedImage imagen;
	
	public MiCanvas() {
		super();
		lista = new Pelotas();
		reloj = new Timer(5,this);		//Cada cuanto transcurre entre eventos (delay) y quien lo escucha, quien recibe los eventos 
										//(el action listener) a través del actionPerformed
		
		imagen = new BufferedImage(300,300,BufferedImage.TYPE_INT_RGB);
		lista.agregar(280,280);
		reloj.start();
		contador = 0;
	}

		
	
	
	public Pelotas getLista() {
		return lista;
	}


	public void setLista(Pelotas lista) {
		this.lista = lista;
	}


	public Timer getReloj() {
		return reloj;
	}


	public void setReloj(Timer reloj) {
		this.reloj = reloj;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		contador++;
		if(contador%700==0) {
			lista.agregar(280, 280);
		}
		
		lista.avanzar(295, 270);
		repaint();
		
		
		
	}
	
	public void paint(Graphics g) {
		Graphics gra = imagen.createGraphics();
		
		gra.setColor(new Color (255,255,255,255));//Establece el color de fondo del lienzo
		gra.fillRect(0, 0, 300, 300);//Dibuja el fondo del tamaño previamente definido total del lienzo
		
		lista.paint(gra);//Dibuja las pelotas
		
		
		g.drawImage(imagen, 0, 0, null);
	}
	
	public void update (Graphics g) {
		paint(g);
	}
	
}
