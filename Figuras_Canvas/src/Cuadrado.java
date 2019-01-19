import java.awt.Color;
import java.awt.Graphics;

public class Cuadrado extends Figura{
	
	public Cuadrado() {
		super();
	}
	
	public Cuadrado(int x, int y, Color c, int tamano ) {
		super(x,y,c,tamano);
	}
	public void paint(Graphics g){
		g.setColor(color);
		g.fillRect(x, y, tamano, tamano);
	}
}

