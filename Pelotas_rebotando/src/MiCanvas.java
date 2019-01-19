import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;


public class MiCanvas extends Canvas implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Pelotas lista;
	private Timer reloj;
	private int contador;
	
	public MiCanvas() {
		super();
		lista = new Pelotas();
		reloj = new Timer(5,this);		//Cada cuanto transcurre entre eventos (delay) y quien lo escucha, quien recibe los eventos 
										//(el action listener) a través del actionPerformed
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
		lista.paint(g);
	}
	
}
