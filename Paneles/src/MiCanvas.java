import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

public class MiCanvas extends Canvas{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int estado; 	//1, 2 ó 3
	private String txt;
	private Circulo miCirculo;
	
	public MiCanvas() {
		super();
		miCirculo=new Circulo(20,20,30, new Color (255,0,0));
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public String getTxt() {
		return txt;
	}

	public void setTxt(String txt) {
		this.txt = txt;
	}

	
	public void paint(Graphics g) {
		if(estado==1) {
			miCirculo.paint(g);
		}
		
		if(estado==2) {
			g.drawLine(25, 25, 40, 40);
			
		}
		
		if(estado==3) {
			g.drawString(txt, 20, 20);
		}
	}
}
