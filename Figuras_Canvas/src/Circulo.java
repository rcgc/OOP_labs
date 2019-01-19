import java.awt.Color;
import java.awt.Graphics;

public class Circulo extends Figura{
	
	public Circulo() {
		super();
	}
	
	public Circulo(int x, int y, Color c, int tamano) {
		super(x,y,c,tamano);
	}
	
	public void paint(Graphics g){
		g.setColor(color);	
		g.fillOval(x, y, tamano, tamano);
		
	}

}

