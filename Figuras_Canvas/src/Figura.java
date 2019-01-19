import java.awt.Color;

public class Figura {
	protected int x;
	protected int y;
	protected Color color;
	protected int tamano;
	
	public Figura() {
		x=0;
		y=0;
		color=Color.RED;
		tamano=10;
	}
	
	public Figura(int x, int y, Color c, int tamano) {
		this.x=x;
		this.y=y;
		this.color=c;
		this.tamano=tamano;
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
	public int getTamano() {
		return tamano;
	}
	public void setTamano(int tamano) {
		this.tamano = tamano;
	}
	
}
