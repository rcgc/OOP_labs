import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MiCanvas extends Canvas implements KeyListener{
	
	private MiObjeto objeto;
	private Bloque bloque;
	
	
	public MiCanvas() {
		super();
		objeto=new MiObjeto(0,0,Color.ORANGE,20,6);
		
		bloque=new Bloque(260,160,Color.BLUE,80,160);
		
		addKeyListener(this);
		this.setFocusable(true); //Para que tenga el focus desde el inicio
		
	}
	
	
	public void paint(Graphics g) {
		bloque.paint(g);
		objeto.paint(g);

		//Si quisieramos imprimir las coordenadas
		//System.out.println(objeto.toString());
		
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
		int oprimido;
		
		oprimido=e.getKeyCode();

		
		
		
		if(oprimido==37) {
			if(bloque.colisionT(objeto.getX(), objeto.getY(), objeto.getTamano())) {
				objeto.izquierda();
			}
		}
		
		if(oprimido==38) {
			if(!bloque.colisionI(objeto.getX(), objeto.getY(), objeto.getTamano())) {
				objeto.arriba();
			}	
		
		}
		if(oprimido==39) {
			if(bloque.colisionF(objeto.getX(), objeto.getY(), objeto.getTamano())) {
				objeto.derecha(392-objeto.getTamano());
			}
		
		}
		
		if(oprimido==40) {
			if(!bloque.colisionS(objeto.getX(), objeto.getY(), objeto.getTamano())) {
				objeto.abajo(368-objeto.getTamano());
			}
		}
		
		repaint();
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
