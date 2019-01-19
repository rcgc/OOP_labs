import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

public class MiCanvas extends Canvas implements MouseListener{
	
	private Figuras figs;
	private Random r;
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public MiCanvas() {
		super();
		figs = new Figuras();
		r= new Random();
		
		this.addMouseListener(this);
		this.inicia();
	}
	
	
	public void inicia() {
		Circulo c = new Circulo(30,30,Color.BLUE, 30);
		figs.agregar(c);
	}
	
	public void paint (Graphics g) {
		figs.paint(g);
	}

	@Override
	public void mouseClicked(MouseEvent mouse) {
		// TODO Auto-generated method stub
		
		
		if(!figs.elegido(mouse.getX(), mouse.getY())) {
			
			if(r.nextInt(2)==1) {
				Figura fig = new Circulo(mouse.getX(), mouse.getY(), 
							 new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256)),r.nextInt(11)+20);
				
				if(mouse.getX()+fig.getTamano()<=295 && mouse.getY()+fig.getTamano()<=270 ) {	//Se le quita 30 porque 
					figs.agregar(fig);															//una figura puede tener
				}																				// un tamaño máximo de 30
				
			}
			else {
				Figura fig=new Cuadrado(mouse.getX(), mouse.getY(),
						   new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256)),r.nextInt(11)+20);
				
				if(mouse.getX()+fig.getTamano()<=295 && mouse.getY()+fig.getTamano()<=270 ) {
					figs.agregar(fig);
				}
				
			}
			
		}
		repaint();
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
