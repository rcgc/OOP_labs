import java.awt.Color;
import java.awt.Graphics;

public class Circulo {
	private int x,y,tamanio;
	private Color c;
	
	public Circulo() {
		x=0;
		y=0;
		c=Color.RED;
		tamanio=0;
	}
	
	public Circulo(int x, int y, int tamanio, Color c) {
		this.x=x;
		this.y=y;
		this.tamanio=tamanio;
		this.c=c;
	}
	
	
	
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getTamanio() {
		return tamanio;
	}

	public void setTamanio(int tamanio) {
		this.tamanio = tamanio;
	}

	public Color getC() {
		return c;
	}

	public void setC(Color c) {
		this.c = c;
	}

	public void paint(Graphics g) {
		g.setColor(c);
		g.fillOval(x, y, tamanio, tamanio);
	}
}
