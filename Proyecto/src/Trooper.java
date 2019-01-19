import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;


/**
 * Clase trooper sirve para imprimir el personaje, además de darle atriutos tales como
 *  campo de vision y su valor.
 * @Version 2.0
 */

public class Trooper extends Personaje{
    public boolean radar;
    public int puntos;
    
    private Image image;
    private ImageIcon ico;
    
    /**
     * constructor de la clase trooper
     */
    public Trooper(){
        super();
        radar=false;
        puntos=10;
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
	 * @param radar sirve para saber si megaman está cerca y emepezar a atacarlo
	 * @param puntos sirve para la cantidad de punto que le da al personaje principal el matar a este enemigo
	 * 
	 */
    public Trooper(int x, int y, int velocidad, int tamano, int hp,  boolean ataque, boolean colision, String nom_imagen,
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
    
    
    /**
     * este metodo revisa sí el personaje principal entra dentro de un campo de vision
     * @param e, revisa la existencia del personaje principal dentro de un campo de vista
     */
    public boolean existencia_megaman(boolean e){
                        //Se podrÃ­a usar la fÃ³rmula de la circunferencia x^2+y^2=r^2
                        //para ver el detectar al personaje principal y empezar a
                        //atacarlo    
        return true; //se debe cambiar por la variable
    }
    
    /**
     * Este metodo revisa sí la bala dentro del alcanze maximo antes de destruirse
     * @param e, revisa por la existencia de una bala
     */
    public void distancia_disparo(boolean e){
                        //evalúa una distancia en x
    					//se debe cambiar por la variable
    }
    
    
    /**
     * el metodo disparar genera una instancia de la bala
     * @param x, posición del personaje en eje x del plano
     * @param y, posición del personaje en eje y del plano
     * @param perfil, revisar hacia que lado ve el personaje
     */
    @Override
	public Bala disparar(int x, int y, int perfil) {
		// TODO Auto-generated method stub
		Bala bala = new Bala();
		return bala;
	}
    /**
     * este metodo revisa por colicones
     */
    public void chocar(){
        
    }
    
    /**
     * este metodo revisa sí el personaje se le acabaron los HP para eliminar la instancia
     */
    public void morir(){
        
    }
    
    
    /**
     * este metodo sirve para generar la imagen del personaje
     * @param g, objeto de la clase Graphics
     */
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
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
     * este metodo sirve para marcar la dirreción de desplazamiento del personaje
     */
	@Override
    public void derecha(){
    	this.setPosX(this.getPosX()+this.getVelocidad());
    }
	/**
     * este metodo sirve para marcar la dirreción de desplazamiento del personaje
     */
    @Override
    public void izquierda() {
    	try {
    		this.setPosX(this.getPosX()-this.getVelocidad());
    	}catch(Exception e) {
    		
    	}
    	
    	
    }
    
    /**
     * este metodo sirve para marcar la dirreción de desplazamiento del personaje
     */
    @Override
    public void abajo() {
    	
    }
    
    /**
     * este metodo sirve para marcar la dirreción de desplazamiento del personaje
     */
    @Override
    public void arriba() {
    	
    }
}