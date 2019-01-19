import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;


/**
 * Clase Faro sirve para generar la imagen del enemigo, aparte de darle atributos tales como su campo de vision, junto con sus puntos
 * @author Roberto Guzmán
 * @author Rodrigo Gutiérrez
 * Clase magnim servira para trazar cualquier persnaje en el canvas, ademas de permitir su movimiento y
 *  sus estadisticas
 * @Version 2.0
 */
public class Magnum extends Personaje{
    private boolean radar;
    private int puntos;
    
    
    private BufferedImage image;
	private InputStream imgStream;
    
    /**
     * constructor de la clase Magnum
     */
    public Magnum(){
        super();
        radar=false;
        puntos=1000;
    }
    
    
    /**
     * constructor de la clase magnum
     * @param x, revisa la pocision en x del plano
     * @param y, revisa la pocision en y del plano
     * @param tamano, limita el tamaño de la imagen
     * @param hp, limita la cantidad de ataques que puede resivir el jefe final
     * @param ataque, revisa si a pasado cierto periodo de tiempo para generar una instancia de bala
     * @param colision, revisa sí el personaje esta chocando contra algun objeto
     * @param imagen, guarga la imagen del personaje
     * @param radar, revisa sí el personaje principal esta dentro de su área de vision
     * @param velocidad, delimita cuan rapido el personaje se desplazara por la pantalla
     * @param puntos, delimita el valor del personaje
     */
    public Magnum(int x, int y, int velocidad, int tamano, int hp, boolean ataque, boolean colision, String nom_imagen, 
    		boolean radar, int puntos) {
    	super(x, y, velocidad, tamano, hp, ataque, colision, nom_imagen);
    	this.radar=radar;
    	this.puntos=puntos;
    }
    
    
    
    public void setRadar(boolean r){
        this.radar=r;
    }
    
    public boolean getRadar(){
        return this.radar;
    }
    
    public void setPuntos(int p){
        this.puntos=p;
    }
    
    public int getPuntos(){
        return this.puntos;
    }
    
    public boolean existencia_megaman(boolean e){
                                //Se podrÃ­a usar la fÃ³rmula de la circunferencia x^2+y^2=r^2
                                //para ver el detectar al personaje principal y empezar a
                                //atacarlo    
        return true;            //se debe cambiar por la variable
    }
    
    /**
     * genera una instancia de bala 
     */
    @Override
	public Bala disparar(int x, int y, int perfil) {
		// TODO Auto-generated method stub
    	Bala bala = new Bala(x,y,22,85,0,false,false,"/images/bala_magnum.png", perfil);
		return bala;
	}
    
   /**
    * metodo no implementado en la versión final
    */
    public void especial(){     //Realiza su habilidad especial que toma tiempo en cargar entre 
                                //un uso y otro
    }
    
    /**
     * revisa si al personaje se la han acabado los hp para eliminar la instancia
     */
    public void morir(){        //Al morir te da puntos (1000= 1 vida extra)
        
    }
    
    /**
     * metodo empleado para mostrar los atributos de la clase
     */
    public String toString() {
		String msj="";
		
		return msj;
	}
    
    
    /**
     * genera la imagen del personaje en el canvas
     */
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		try {

			imgStream= Item.class.getResourceAsStream(this.getNom_Imagen());
			image=ImageIO.read(imgStream);
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		g.drawImage(image, this.getPosX(), this.getPosY(), this.getTamano(), this.getTamano(), null);
	}


	/**
     * este metodo sirve para generar la imagen del personaje
     */
	@Override
    public void derecha(){
    	this.setPosX(this.getPosX()+this.getVelocidad());
    }
	
	/**
     * este metodo sirve para generar la imagen del personaje
     */
    @Override
    public void izquierda() {
    	this.setPosX(this.getPosX()-this.getVelocidad());
    }
    
    /**
     * este metodo sirve para generar la imagen del personaje
     */
    @Override
    public void abajo() {
    	
    }
    
    /**
     * este metodo sirve para generar la imagen del personaje
     */
    @Override
    public void arriba() {
    	
    }
    
}