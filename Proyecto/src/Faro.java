import java.awt.Graphics;
	

/**
 * Clase Faro sirve para generar la imagen del enemigo, aparte de darle atributos tales como su campo de vision, junto con sus puntos
 * @author Roberto Guzmán
 * @author Rodrigo Gutiérrez
 * @version 2.0
 * 
 */

public class Faro extends Personaje{
    private boolean radar;
    private int puntos;
    
    
    
    
    /**
     * constructor de la calse Faro
     */
    public Faro(){
        super();
        radar=false;
        puntos=30;
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
    public Faro(int x, int y, int velocidad, int tamano, int hp,  boolean ataque, boolean colision, String nom_imagen,
    			boolean radar, int puntos) {
    	
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
     * este metodo sirve para revisar sí el presonaje principal esta dentro de un area de vision para perseguirlo y atacarlo
     * @param e, sirve para verificar la existencia del personaje principal
     */
    public boolean existencia_megaman(boolean e){
                                //Se podrán usar la fórmula de la circunferencia x^2+y^2=r^2
                                //para ver el detectar al personaje principal y empezar a
                                //atacarlo
        return true;            //se debe cambiar por la variable
    }
    
    
    /**
     * este metodo se genera una instancia de la bala a disparar
     */
    
    @Override
	public Bala disparar(int x, int y, int perfil) {
		// TODO Auto-generated method stub
		Bala bala = new Bala();
		return bala;
	}
    
    
    /**
     * en este metodo se revisa si los HP se agotaron para eliminar la instancia
     */
    
    public void morir(){        //Al morir te da puntos
        
    }
    
    
    /**
     * en este metodo se imprime la imagen del personaje
     */
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		
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
    	this.setPosX(this.getPosX()-this.getVelocidad());
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