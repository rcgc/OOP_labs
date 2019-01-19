import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.ListIterator;

/**
 * la clase balas se encarga de generar una lsita de balas conforme se van pidiendo
 * @author Roberto Guzmán
 * @author Rodrigo Gutiérrez
 * @version 2.0
 * 
 */

public class Balas implements ActionListener{
	private ArrayList<Bala>cartucho;
	private boolean bandera1;
	private boolean bandera2;
	private boolean bandera3;
	
	/**
	 * cosntructor de Balas
	 */
	
	public Balas() {
		cartucho =new ArrayList<Bala>(30);
		bandera1=false;
		bandera2=false;
	}
	
	public void setBandera1(boolean b) {
		this.bandera1=b;
	}
	
	public boolean getBandera1() {
		return this.bandera1;
	}
	
	public void setBandera2(boolean b) {
		this.bandera2=b;
	}
	
	public boolean getBandera2() {
		return this.bandera2;
	}
	
	public void setBandera3(boolean b) {
		this.bandera3=b;
	}
	
	public boolean getBandera3() {
		return this.bandera3;
	}
	
	/**
	 * este metodo agrega una instancia de Bala a la lista
	 * @param bala, este objeto de la clase Bala sirve para determinar que tipo de municion sera
	 */
	public void agregar(Bala bala) {
		
		try {
			if(cartucho.size()<=7) {//Con esto lo estamos limitando a que sean máximo n balas +1
				cartucho.add(bala);
				
			}
			
		}catch(Exception e) {
			//System.out.println("Lleno");
		}
		
	}
	
	
	/**
	 * la clase paint se encarga de dibujar el tipo de bala correspondiente
	 */
	
	public void paint(Graphics g) {
		
		ListIterator<Bala>apt=cartucho.listIterator();
		
		while(apt.hasNext()) {
			Bala bala = apt.next();
			bala.paint(g);
		}
	}
	
	/**
     * este metodo sirve para marcar la dirreción de desplazamiento del objeto
     */
	public void avanzar() {
		ListIterator<Bala>apt=cartucho.listIterator();
		try {
			while(apt.hasNext()) {
				Bala bala = apt.next();
				
				if(bala.getPerfil()==39) {
					bala.setPosX(bala.getPosX()+bala.getVelocidad());
				}
				else {
					bala.setPosX(bala.getPosX()-bala.getVelocidad());
				}
				
				
				if(bala.getPosX()>=750-bala.getTamano()+12 || bala.getPosX()<=0) {
					cartucho.remove(bala);	
				}
				
				
				
			}
		}catch(Exception ex) {
			//Si quisiera limpiar
			//cartucho.clear();
		}
	}
	
	/**
     * este metodo sirve para marcar la dirreción de desplazamiento del objeto
     * @param x, sirve para encontrar la posicion x en el plano
     * @param y, sirve para encontrar la posicion y en el plano
     * @param alto, sirve para ver determinar las dimenciones de la bala
     * @param ancho, sirve para delimitar las dimenciones de la bala
     */
	
	public void avanzar(int megamanx, int megamany, int megaman_tam) {
		ListIterator<Bala>apt=cartucho.listIterator();
		try {
			while(apt.hasNext()) {
				Bala bala = apt.next();
				if(bala.getPerfil()==37) {
					bala.setPosX(bala.getPosX()-bala.getVelocidad());
					if(bala.getPosX()>megamanx && 
							bala.getPosX()<megamanx+megaman_tam &&
							bala.getPosY()+bala.getTamano()>megamany+3
							&& bala.getPosY()<megamany+megaman_tam
							) {
						
						
						
						this.bandera3=true;
						cartucho.remove(bala);
						
					
					}
					
				}
			}
		}catch(Exception e) {
			
		}
	}
	
	/**
	 * este metodo sirve para revisar por colisión contra las balas de Typhoon
	 * @param trooper1x, posición del trooper en x
	 * @param trooper1y, posición del trooper en y
	 * @param trooper1_tam, tamaño de la imagen
	 * @param magnumx, posición de magnum en x
	 * @param magnumy, posición de magnum en y
	 * @param magnum_tam, tamaño de la imagen
	 */
	public void avanzar(int trooper1x, int trooper1y, int trooper1_tam, 
			int magnumx, int magnumy, int magnum_tam) {
		
		ListIterator<Bala>apt=cartucho.listIterator();
		try {
			while(apt.hasNext()) {
				Bala bala = apt.next();
				
				if(bala.getPerfil()==39) {
					bala.setPosX(bala.getPosX()+bala.getVelocidad());
					
					if(bala.getPosX()+bala.getTamano()>trooper1x+19 &&
							bala.getPosX()+bala.getTamano()<trooper1x+trooper1_tam &&
							bala.getPosY()+bala.getTamano()>trooper1y+18 
							&& bala.getPosY()<trooper1y+trooper1_tam
							) {
						
						this.bandera1=true;
						cartucho.remove(bala);
					}
					
					
					if(bala.getPosX()+bala.getTamano()>magnumx+19 &&
							bala.getPosX()+bala.getTamano()<magnumx+magnum_tam &&
							bala.getPosY()+bala.getTamano()>magnumy+18 
							&& bala.getPosY()<magnumy+magnum_tam
							) {
						
						this.bandera2=true;
						cartucho.remove(bala);
					}
					
					
				}
				else {
					bala.setPosX(bala.getPosX()-bala.getVelocidad());
					
					if(bala.getPosX()+bala.getTamano()>trooper1x+19 &&
							bala.getPosX()+bala.getTamano()<trooper1x+trooper1_tam &&
							bala.getPosY()+bala.getTamano()>trooper1y+18 
							&& bala.getPosY()<trooper1y+trooper1_tam
							) {
						
						this.bandera1=true;
						cartucho.remove(bala);
					}
					
					
					
					
				}
				
				
				
				
				
				if(bala.getPosX()>=750-bala.getTamano()+12 || bala.getPosX()<=0) {
					cartucho.remove(bala);	
				}
				
				
				
			}
		}catch(Exception ex) {
			//Si quisiera limpiar
			//cartucho.clear();
		}
	}

	/**
	 * metodo autogenerado por la clase abstracta de actionListener
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
}
