import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Random;

public class Figuras {
	private ArrayList<Figura>lista;
	private Random r;
	
	public Figuras() {
		lista = new ArrayList<Figura>(10);
		r= new Random();
	}
	
		
	public void agregar (Figura fig) {
		lista.add(fig);
	}
	
	public boolean elegido(int x, int y) {
		boolean enc=false;
		
		ListIterator<Figura>apt=lista.listIterator();
		while(!enc && apt.hasNext()) {
			Figura fig= apt.next();		// Trae un cuadrado o circulo
			
			if(x>=fig.getX() && x<= fig.getX()+ fig.getTamano() &&
			   y>=fig.getY() && y<= fig.getY()+ fig.getTamano()) {
				
				enc=true;
				fig.setColor(new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256)));
				
			}
		}
		
		return enc;
	}
	
	public void paint(Graphics g) {
		ListIterator<Figura>apt=lista.listIterator();
		
		while(apt.hasNext()) {
			Figura fig = apt.next();
			
			if(fig instanceof Cuadrado) {
				Cuadrado aux = (Cuadrado) fig;
				aux.paint(g);
			}
			
			if(fig instanceof Circulo) {
				Circulo aux = (Circulo)fig;
				aux.paint(g);
			}
			
		}//While
	}
	
}
