import java.awt.Color;
import java.awt.Graphics;

public class Pelota {
	private int x;
	private int y;
	private int tamano;
	private Color color;
	private int direccionX;
	private int direccionY;
	
	
	
	
	public Pelota() {
		x=0;
		y=0;
		tamano=20;
		color = Color.BLUE;
		direccionX=1;
		direccionY=1;
	}
	
	
	public Pelota(int x, int y, int tamano, Color color, int direccionX, int direccionY) {
		this.x=x;
		this.y=y;
		this.tamano=tamano;
		this.color=color;
		this.direccionX=direccionX;
		this.direccionY=direccionY;
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


	public int getTamano() {
		return tamano;
	}


	public void setTamano(int tamano) {
		this.tamano = tamano;
	}


	public Color getColor() {
		return color;
	}


	public void setColor(Color color) {
		this.color = color;
	}


	public int getDireccionX() {
		return direccionX;
	}


	public void setDireccionX(int direccionX) {
		this.direccionX = direccionX;
	}


	public int getDireccionY() {
		return direccionY;
	}


	public void setDireccionY(int direccionY) {
		this.direccionY = direccionY;
	}


	public String toString() {
		String msj="";
		
		msj+=this.getX()+", "+this.getY()+"\n";
		
		return msj;
	}
	
	public void paint(Graphics g) {
		g.setColor(color);
		g.fillOval(x, y, tamano, tamano);
	}
}
