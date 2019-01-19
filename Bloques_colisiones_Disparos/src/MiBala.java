import java.awt.Color;
import java.awt.Graphics;

public class MiBala {
	
	private int x;
	private int y;
	private Color color;
	private int tamano;
	private int velocidad;
	
	public MiBala() {
		
		x=0;
		y=0;
		color=Color.BLUE;
		tamano=6;
		velocidad= 1;	
		
	}
	
	
	public MiBala(int x, int y, Color c, int tamano, int vel) {
		
		this.x=x;
		this.y=y;
		this.color=c;
		this.tamano=tamano;
		this.velocidad=vel;
		
	}
	
	public void setX(int x) {
		this.x=x;
	}
	
	public int getX() {
		return this.x;
	}
	
	
	public void setY(int y) {
		this.y=y;
	}
	
	public int getY() {
		return this.y;
	}
	
	
	public Color getColor() {
		return color;
	}


	public void setColor(Color color) {
		this.color = color;
	}


	public int getTamano() {
		return tamano;
	}


	public void setTamano(int tamano) {
		this.tamano = tamano;
	}


	public int getVelocidad() {
		return velocidad;
	}


	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}


	

	public void paint(Graphics g) {
		g.setColor(color);
		g.fillOval(x, y, tamano, tamano);
	}
	
	public String toString() {
		String msj="";
		
		msj+=this.getX()+", "+this.getY()+"\n";
		
		return msj;
	}

}
