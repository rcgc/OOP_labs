import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.ListIterator;

import javax.swing.Timer;


/**
 * Clase Faro sirve para generar la imagen del enemigo, aparte de darle atributos tales como su campo de vision, junto con sus puntos
 * @author Roberto Guzmán
 * @author Rodrigo Gutiérrez
 * esta clase se utiliza para generar el primer nivel del juego
 * @version 1.0
 */

public class MiCanvas_Nivel_1 extends Canvas implements ActionListener, KeyListener{	
	/**
	 * 
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private BufferedImage anti_flickering;
	private Item barra;
	private Item piso;
	private Item piso2;
	private Item nube;
	private Item nube2;
	
	private Timer reloj1;
	
	private Balas cartucho_megaman;
	private Balas cartucho_magnum;
	
	private Typhoon megaman;
	private Trooper trooper1;
	private Magnum magnum;
	
	private int tAnt;
	private int[] perfil;
	private int contador;
	private boolean nivel_superado;
	
	/**
	 * constructor de MiCanvas_nivel_1
	 */

	public MiCanvas_Nivel_1() {
		super();
		anti_flickering = new BufferedImage(760,650,BufferedImage.TYPE_INT_RGB);
		barra			= new Item();
		
		piso 			= new Item(-25, 500, 0, 300,1800, 0, false, false, "/images/floor.png");
		piso2 			= new Item(1725, 500, 0, 300,1800, 0, false, false, "/images/floor.png");
		
		nube 			= new Item(90, -35, 0, 330, 1800, 0, false, false, "/images/nubes.png");
		nube2			= new Item(1980, 8, 0, 330, 1800, 0, false, false, "/images/nubes.png");
		reloj1			= new Timer(250,this);//Cada segundo un evento (1000 ms)
		
		
		cartucho_megaman= new Balas();
		cartucho_magnum = new Balas();
		
		megaman			= new Typhoon(10, 400, 7, 100, 10, true, false, "/images/static.gif", 7, 0, false, false, false);
		trooper1		= new Trooper(519, 444, 9, 60, 40, false, false, "/images/trooper2.gif", false, 100);
		magnum			= new Magnum(590, 340, 0, 160, 20, false, false, "/images/magnum.gif", false, 1000);
		
        tAnt			=0;
        perfil			=new int[1];
        perfil[0]		=39;
        contador 		=0;
        nivel_superado	=false;
        
        addKeyListener(this);
		this.setFocusable(true); //Para que tenga el focus desde el inicio
		reloj1.start();
	}
	
	
	/**
	 * esta metodo funciona para generar el mapa de modo grafico
	 * @param nivel, esto sirve para revisar el nivel en el cual se encuentra el usuario
	 */
	
	public void setNivel_Superado(boolean nivel) {
		this.nivel_superado=nivel;
	}
	
	
	public boolean getNivel_Superado() {
		return this.nivel_superado;
	}
	
	/**
	 * este metodo sirve para generar la imagen del nivel
	 * @param g, objeto de la clase Graphics
	 */
	public void paint(Graphics g) {
		
		Graphics gra = anti_flickering.createGraphics();
		
		gra.setColor(new Color(82,130,242));//Establece el color de fondo del lienzo
		gra.fillRect(0, 0, 760, 650);//Dibuja el fondo del tamaño previamente definido total del lienzo
		
		
		//gra.fillRect(0, 0, 40, 20);
		//gra.setColor(Color.blue);
		
		//Todos los objetos que se manden a pintar deberán ser con el parámetro gra
		if(magnum==null) {
			barra.paint_Letrero(gra);
		}
		
		try {
			barra.paint_Barra(gra, megaman.getVida(), megaman.getPuntaje());
			piso.paint(gra);
			piso2.paint(gra);
			nube.paint(gra);
			nube2.paint(gra);
			megaman.paint(gra);
			
			
			cartucho_megaman.paint(gra);
			cartucho_magnum.paint(gra);
			trooper1.paint(gra);
			magnum.paint(gra);
			
			
			
			
			
		}catch(Exception e) {
			//barra.paint_Barra(gra, megaman.getVida(), megaman.getPuntaje());
			//piso.paint(gra);
			//piso2.paint(gra);
			//megaman.paint(gra);
			
		}
		
		
		//Pintar los personajes
		
		g.drawImage(anti_flickering, 0, 0, null);
	}
	
	/**
	 * esta metodo funciona para actualizar cada "x" tiempo el mapa de modo grafico
	 */
	
	public void update (Graphics g) { //Update para evitar el flickering
		paint(g);
	}
	
	/**
	 * este metodo funciona para revisar sí se debe refrescar la pantalla en caso de que el personaje avanze
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		contador++;
		
		
		
		
		try {
			megaman.caer(piso.getPosY(), piso.getPosX()+piso.getTamano(), perfil[0]);//debe que caer siempre para dar a ver que lo afecta la gravedad
			
			
			if(magnum==null) {
				cartucho_megaman.avanzar();
				cartucho_magnum.avanzar(megaman.getPosX(), megaman.getPosY(), megaman.getTamano());
				if(cartucho_magnum.getBandera3()) {
					megaman.setVida(megaman.getVida()-1);
					
					if(perfil[0]==37) {
						megaman.setNom_Imagen("/images/dano2.gif");
					}
					if(perfil[0]==39) {
						megaman.setNom_Imagen("/images/dano.gif");
					}
					
					cartucho_magnum.setBandera3(false);
				}
			}
			
			if(trooper1!=null) {
				cartucho_megaman.avanzar(trooper1.getPosX(), trooper1.getPosY(), trooper1.getTamano(),
						magnum.getPosX(),magnum.getPosY(),magnum.getTamano());
				
				trooper1.izquierda();
				
				
				
				if(megaman.getPosX()+megaman.getTamano()-12>=trooper1.getPosX() 
						&&megaman.getPosX()<=trooper1.getPosX()+trooper1.getTamano()-10 
						&& megaman.getPosY()+megaman.getTamano()>=trooper1.getPosY() && megaman.getAtaque()) {
					
					//Usando el atributo ataque (boolean), podremos controlar cuando tiempo está inmune el personaje
					//aunado a ello hay que usar el timer (restart) para que cada n segundos vuelva a poder estar 
					//apto para ser atacado
					
					if(perfil[0]==37) {
						
						megaman.setNom_Imagen("/images/dano2.gif");
						megaman.setVida(megaman.getVida()-1);
						megaman.setAtaque(false);
						
					}
					
					if(perfil[0]==39) {
						megaman.setNom_Imagen("/images/dano.gif");
						megaman.setVida(megaman.getVida()-1);
						megaman.setAtaque(false);
					}
					//reloj2.start();
					
					
					
					
					
					
					
					
					//if(perfil[0]==37) {
						//megaman.setNom_Imagen("/images/static2.gif");
					//}
					
					//if(perfil[0]==39) {
						//megaman.setNom_Imagen("/images/static.gif");
					//}
				}
				
				
			}
			
			if(contador%25==0) {
				cartucho_magnum.agregar(magnum.disparar(magnum.getPosX(), magnum.getPosY()+magnum.getTamano()/2, 37));
			}
			
			
			if(contador==10|| contador==120 || contador==200 || contador ==450) {
				magnum.setPosY(magnum.getPosY()-100);
			}
			
			
			if(contador==50 ||contador==150 ||contador==400 || contador ==550) {
				magnum.setPosY(magnum.getPosY()+100);
			}
			
			if(contador%50==0) {//Cada determinado tiempo está inmune
				megaman.setAtaque(true);
				//megaman.setAtaque(true);
				//megaman.setPuntaje(megaman.getPuntaje()+1);//Para calar el puntaje	
			}
			
			cartucho_magnum.avanzar(megaman.getPosX(), megaman.getPosY(), megaman.getTamano());
			
			if(cartucho_magnum.getBandera3()) {
				megaman.setVida(megaman.getVida()-1);
				if(perfil[0]==37) {
					megaman.setNom_Imagen("/images/dano2.gif");
				}
				if(perfil[0]==39) {
					megaman.setNom_Imagen("/images/dano.gif");
				}
				
				cartucho_magnum.setBandera3(false);
			}
			
			
			if(trooper1 !=null && cartucho_megaman.getBandera1()) {
				megaman.setPuntaje(megaman.getPuntaje()+trooper1.getPuntos());
				trooper1.setPosX(-5000);
				
				cartucho_megaman.setBandera1(false);

			}
			
			if(trooper1 !=null && trooper1.getPosX()+trooper1.getTamano()<20) {
				trooper1.setPosX(-5000);
				
			}
			
			if(trooper1==null ) {
				cartucho_megaman.avanzar();
				megaman.caer(piso.getPosY(), piso.getPosX()+piso.getTamano(), perfil[0]);//debe que caer siempre para  
																		//dar a ver que lo afecta la gravedad	
			}
			
			if(cartucho_megaman.getBandera2()) {
				megaman.setPuntaje(megaman.getPuntaje()+100);
				magnum.setHp(magnum.getHp()-1);
				cartucho_megaman.setBandera2(false);
			}
			
			if(magnum.getHp()<=0) {
				megaman.setPuntaje(megaman.getPuntaje()+magnum.getPuntos());
				magnum=null;
			
			}
			
			
			
			//if(megaman.getPosX()>=22) {
				//this.setNivel_Superado(true);
			//}
			if(megaman.getVida()<=0) {
				System.exit(0);
			}
			
		}catch(Exception ex) {
			
		}
		//this.getNivel_Superado();
		repaint();
	}
	
	
	/**
	 * este metodo sirve para revisar que tecla se pulsa para mover al personaje
	 * @param e, sirve para la lectura de teclas
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
		int oprimido;
		oprimido=e.getKeyCode();
		
	
	

		if(oprimido==37) { //Izquierda
			perfil[0]=37;
			megaman.setNom_Imagen("/images/move_b.gif");
			
			
			if(piso.getPosX()>=(megaman.getTamano())*-1) {
				megaman.izquierda();
			}
			//megaman.getPosX()+megaman.getTamano()>=360 && 
			if(piso.getPosX()<=-6) {
				try {
					
					if(trooper1!=null) {
						piso.setPosX(piso.getPosX()+megaman.getVelocidad());
						piso2.setPosX(piso2.getPosX()+megaman.getVelocidad());
						nube.setPosX(nube.getPosX()+megaman.getVelocidad());
						nube2.setPosX(nube2.getPosX()+megaman.getVelocidad());
						trooper1.setPosX(trooper1.getPosX()+megaman.getVelocidad());
					}
					if(trooper1==null) {
						piso.setPosX(piso.getPosX()+megaman.getVelocidad());
						piso2.setPosX(piso2.getPosX()+megaman.getVelocidad());
						nube.setPosX(nube.getPosX()+megaman.getVelocidad());
						nube2.setPosX(nube2.getPosX()+megaman.getVelocidad());
					}
					
					
				}catch(Exception ex) {
					
					
					
						
				}
			}	
		}
		
		if(oprimido==38) { //Arriba
			
		}
		
		
		if(oprimido==39) { //Derecha
			perfil[0]=39;
			
			megaman.setNom_Imagen("/images/move_f.gif");
			megaman.derecha();
			
			
				
			
			if(megaman.getPosX()+megaman.getTamano()>=360 && piso2.getPosX()+piso2.getAncho()>=764) {
				try{
					
					
					
					if(trooper1!=null) {
						piso.setPosX(piso.getPosX()-megaman.getVelocidad());
						piso2.setPosX(piso2.getPosX()-megaman.getVelocidad());
						nube.setPosX(nube.getPosX()-megaman.getVelocidad());
						nube2.setPosX(nube2.getPosX()-megaman.getVelocidad());
						trooper1.setPosX(trooper1.getPosX()-megaman.getVelocidad());
					
					}
					
					if(trooper1!=null) {
						piso.setPosX(piso.getPosX()-megaman.getVelocidad());
						piso2.setPosX(piso2.getPosX()-megaman.getVelocidad());
						nube.setPosX(nube.getPosX()-megaman.getVelocidad());
						nube2.setPosX(nube2.getPosX()-megaman.getVelocidad());
						trooper1.setPosX(trooper1.getPosX()-megaman.getVelocidad());
					}
					if(trooper1==null) {
						piso.setPosX(piso.getPosX()-megaman.getVelocidad());
						piso2.setPosX(piso2.getPosX()-megaman.getVelocidad());
						nube.setPosX(nube.getPosX()-megaman.getVelocidad());
						nube2.setPosX(nube2.getPosX()-megaman.getVelocidad());
						
					}
					
					
					
				}catch(Exception ex) {
					
					
					
				}
			}
			
			
		
			
		}
		
		if(oprimido==40) { //Abajo
			
		}
		
		
		if(oprimido==88) { //Presionar x para saltar
			megaman.setSalto(true);
			if(perfil[0]==39) {
				megaman.setNom_Imagen("/images/jump.gif");
			}
			
			else if(perfil[0]==37) {
				megaman.setNom_Imagen("/images/jump2.gif");
			}
			
			megaman.saltar(piso.getPosY(),piso.getPosX()+piso.getTamano(), perfil[0]);
			megaman.setSalto(false);
			
		}
		
		if(oprimido==90) { //Presionar z para disparar
			if(perfil[0]==39) {
				cartucho_megaman.agregar(megaman.disparar(
						megaman.getPosX()+megaman.getTamano()+1, 
						megaman.getPosY()+megaman.getTamano()/2, 
						perfil[0]));
				megaman.setNom_Imagen("/images/dispara.png");
			}
			else {
				cartucho_megaman.agregar(megaman.disparar(
						megaman.getPosX(), 
						megaman.getPosY()+megaman.getTamano()/2, 
						perfil[0]));
				megaman.setNom_Imagen("/images/dispara2.png");
			}
		}
		
		
		
		if(oprimido==88 && tAnt==39) {	//oprimido==39 && tAnt==88 || 
			megaman.salto_parabola(piso.getPosY(), piso.getAncho(),perfil[0]);
			if(megaman.getPosX()+megaman.getTamano()>=360 && piso2.getPosX()+piso2.getAncho()>=764) {
				piso.setPosX(piso.getPosX()-megaman.getVelocidad());
				piso2.setPosX(piso2.getPosX()-megaman.getVelocidad());
				nube.setPosX(nube.getPosX()-megaman.getVelocidad());
				nube2.setPosX(nube2.getPosX()-megaman.getVelocidad());
			}
		}
		
		if(oprimido==88 && tAnt==37) {	//oprimido==39 && tAnt==88 || 
			
			if(megaman.getPosX()>=7 && piso.getPosX()<-3 ) {
				megaman.salto_parabola(piso.getPosY(), piso.getAncho(),perfil[0]);
				piso.setPosX(piso.getPosX()+megaman.getVelocidad());
				piso2.setPosX(piso2.getPosX()+megaman.getVelocidad());
				nube.setPosX(nube.getPosX()+megaman.getVelocidad());
				nube2.setPosX(nube2.getPosX()+megaman.getVelocidad());
			}
			else {
				megaman.saltar(piso.getPosY(), piso.getAncho(), perfil[0]);
			}
		}
		
		
		
				
		tAnt=oprimido;
		repaint();
	}

	
	/**
	 * esta funcion sirve para revisar si alguna tecla dejo de ser oprimida
	 * @param arg0, sirve para revisar sí se esta oprimiendo una tecla o no
	 */
	
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		int desoprimido;
		desoprimido=e.getKeyCode();
		
		
		if(desoprimido==37) {
			megaman.setNom_Imagen("/images/static2.gif");
		}
		
		if(desoprimido==39) { //Derecha
			
			megaman.setSalto(false);
			megaman.setNom_Imagen("/images/static.gif");
		}
		
		
		if(desoprimido==88) {
			megaman.caer(piso.getPosY()-megaman.getTamano()-10, piso.getPosX()+piso.getTamano(), perfil[0]);
			if(perfil[0]==37) {
				megaman.setNom_Imagen("/images/static2.gif");
			}
			if(perfil[0]==39) {
				megaman.setNom_Imagen("/images/static.gif");
			}
			
		}
		
		if(desoprimido==90) {
			
			if(perfil[0]==37) {
				megaman.setNom_Imagen("/images/static2.gif");
			}
			
			if(perfil[0]==39) {
				megaman.setNom_Imagen("/images/static.gif");
			}
		}
		
		
		repaint();
	}
	
	/**
	 * este metodo no se utiliza, aunque se tiene que sobreescribir debido a que es requerimiento del metodo
	 * abstracto de la interfas KeyListener
	 */
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
