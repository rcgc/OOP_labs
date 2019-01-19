import java.awt.Color;
import java.awt.Graphics;



public class Bloque {
	private int x;
	private int y;
	private Color color;
	private int ancho;
	private int alto;

	
	
	public Bloque() {
		x=100;
		y=100;
		color=Color.RED;
		ancho= 60;
		alto=90;
		
	}
	
	
	public Bloque(int x, int y, Color c, int an, int al) {
		this.x=x;
		this.y=y;
		this.color=c;
		this.ancho=an;
		this.alto=al;
		
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
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public int getAncho() {
		return ancho;
	}
	public void setAncho(int ancho) {
		this.ancho = ancho;
	}
	public int getAlto() {
		return alto;
	}
	public void setAlto(int alto) {
		this.alto = alto;
	}
	
	
	public void paint(Graphics g) {
		g.setColor(color);
		g.fillRect(x, y, ancho, alto);
	}
	
	public String toString() {
		return "";
	}
	
	
	public boolean colisionF(int x1, int y1, int tamano) {
		//NOTA: lo comentado es por si por cada colisión quisieramos que cambiara de color el bloque
		
		
		if((x1+tamano)>=x-6 && x1<=x+ancho+1 && (y1+tamano>=y && y1<=y+alto)) {
			//this.setColor(new Color(r.nextInt(256),r.nextInt(256),r.nextInt(256)));
			return false;
		}
		return true;
	}
	
	public boolean colisionT(int x1, int y1, int tamano) {
		if(x1+tamano>=x && x1<=x+ancho+6 && (y1+tamano>=y && y1<=y+alto)) {
	//		this.setColor(new Color(r.nextInt(256),r.nextInt(256),r.nextInt(256)));
			return false;
		}
		return true;
	}
	
	public boolean colisionS(int x1, int y1, int tamano) {
		if(y1+tamano<=y-4 ||y1>=y+alto || x1+tamano<x ||x1>x+ancho) {
			
			return false;
		}
		//this.setColor(new Color(r.nextInt(256),r.nextInt(256),r.nextInt(256)));
		return true;
	}
	
	public boolean colisionI(int x1, int y1, int tamano) {
		
		if(y1>=y+alto+6 || y1+tamano<=y || x1+tamano<x || x1>x+ancho) {
			
			return false;
		}
		//this.setColor(new Color(r.nextInt(256),r.nextInt(256),r.nextInt(256)));
		return true;
	}
	
}
