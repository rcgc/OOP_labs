import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;


/**
 * la clase bala genera la existencia de una bala en cuanto un personaje lo requiere
 * @author Roberto Guzmán
 * @author Rodrigo Gutiérrez
 * @version 2.0
 * 
 */

public class Bala extends Personaje {

	private Image image;
    private ImageIcon ico;
    private int perfil;
	/**
	 * constructor default de Bala
	 */
	
	public Bala() {
		super();
		perfil=39;
	}
	
	
	/**
	 * constructor no default de Bala
	 * @param x sirve para la posicion en x del personaje
	 * @param y sirve para la posicion en y del personaje
	 * @param velocidad sirve para establecer la cantidad de pixeles que se mueve el personaje
	 * @param tamano sirve para establecer el tamano del personaje
	 * @param hp sirve para establecer la cantidad de golpes que puede recibir antes de perder una vida o morir
	 * @param ataque sirve para establecer el estado en que se halla el personaje
	 * @param colision sirve para establecer el estado en que se halla el personaje
	 * @param imagen sirve para que dicha cadena cadena de texto mande a llamar a la imagen pos us nombre
	 * 
	 */
	
	public Bala(int x, int y, int velocidad, int tamano, int hp, boolean ataque, boolean colision, String imagen, int perfil) {
    	super(x, y, velocidad, tamano, hp, ataque, colision, imagen);
		this.perfil=perfil;
	}
	
	
	/**
	 * este metodo se encarga de revisar sí se requiere generar una bala
	 */
	
	public void setPerfil(int perfil) {
		this.perfil=perfil;
	}
	
	public int getPerfil() {
		return this.perfil;
	}
	
	/**
	 * este emtodo genera uan nueva instancia en el arreglo de balas
	 * @param x, sirve para tener la locaclización dentro del plano en el eje x
	 * @param y, sirve para tener la posición en el plano dentro del eje y
	 * @param perfil, sirve para tener referencia del lado al que ve la imagen
	 */
	@Override
	public Bala disparar(int x, int y, int perfil) {
		// TODO Auto-generated method stub
		Bala bala = new Bala();
		return bala;
	}

	/**
	 * este metodo se encarga de eliminar la instancia de la bala en cuanto colisiona o sale de cierto rango
	 */

	@Override
	public void morir() {
		// TODO Auto-generated method stub
		
	}
	
	
	/**
	 * este metodo se encarga de generar la imagen de la bala dependiendo del personaje
	 */
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		//try {

		ico = new ImageIcon(getClass().getResource(this.getNom_Imagen()));
		image = ico.getImage();
	//}catch(IOException e) {
		//e.printStackTrace();
	//}
	
		g.drawImage(image,this.getPosX(),this.getPosY(), this.getTamano(), this.getTamano(), null);

	}

	/**
     * este metodo sirve para marcar la dirreción de desplazamiento del objeto
     */
	@Override
    public void derecha(){
    	this.setPosX(this.getPosX()+this.getVelocidad());
    }
	
	/**
     * este metodo sirve para marcar la dirreción de desplazamiento del objeto
     */
    @Override
    public void izquierda() {
    	this.setPosX(this.getPosX()-this.getVelocidad());
    }
    
    /**
     * este metodo sirve para marcar la dirreción de desplazamiento del objeto
     */
    @Override
    public void abajo() {
    	
    }
    
    /**
     * este metodo sirve para marcar la dirreción de desplazamiento del objeto
     */
    @Override
    public void arriba() {
    	
    }

}
