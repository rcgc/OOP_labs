import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Timer;



public class MiCanvas extends Canvas implements KeyListener, ActionListener{
	
	private MiObjeto objeto;
	private Bloque bloque;
	private Balas cartucho;
	
	private Timer reloj;
	
	
	
	
	public MiCanvas() {
		super();
		
		
		objeto=new MiObjeto(0,0,Color.ORANGE,20,6);
		
		bloque=new Bloque(260,160,Color.BLUE,80,160);
		
		cartucho = new Balas();
		
		reloj = new Timer(5,this);
		reloj.start();
		
		addKeyListener(this);
		this.setFocusable(true); //Para que tenga el focus desde el inicio
		
		
	}
	
	
	public void paint(Graphics g) {
		
		try {
			bloque.paint(g);
			objeto.paint(g);
			cartucho.paint(g);
			
			//Si quisieramos imprimir las coordenadas
			//System.out.println("Obj "+objeto.toString());
			
			
		}catch(Exception e) {
			objeto.paint(g);
			cartucho.paint(g);
			
			//Si quisieramos imprimir las coordenadas
			//System.out.println("Obj "+objeto.toString());
		}
		
			
		
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

		
		if(oprimido==32) {
			
			//MiBala bala=new MiBala(objeto.getX()+objeto.getTamano(),objeto.getY()+(objeto.getTamano()/2)-3, Color.BLACK,6,2);
		    cartucho.agregar(objeto.disparar());
		    
		    
		}
		
		
		try {
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
			
			

		}catch(Exception ex) {
			if(oprimido==37) {
				objeto.izquierda();
			}
			if(oprimido==38) {
				objeto.arriba();
			}
			if(oprimido==39) {
				objeto.derecha(392-objeto.getTamano());
			}
			if(oprimido==40) {
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


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		try {
			
			if(bloque!=null) {
				cartucho.avanzar(bloque.getX(),bloque.getY(), bloque.getAlto(), bloque.getAncho());
				if(cartucho.getBandera()) {
	
					bloque=null;
				}
				
			}
			else {
				cartucho.avanzar();
			}
			
		}catch(Exception ex) {
			
			
				cartucho.avanzar();
			
		}
		
		repaint();
		
	}


	
}
