import java.awt.Graphics;



/**
 * Clase Faro sirve para generar la imagen del enemigo, aparte de darle atributos tales como su campo de vision, junto con sus puntos
 * @author Roberto Guzmán
 * @author Rodrigo Gutiérrez
 * Clase personaje servira para trazar cualquier persnaje en el canvas, ademas de permitir su movimiento y
 *  sus estadisticas
 * @Version 2.0
 */
public abstract class Personaje{
    
    protected int posX;
    private int posY;
    private int velocidad;
    private int    hp; //Hit Points
    private int tamano;
    
    private boolean ataque;
    private boolean colision;
    private String nom_imagen;
    
    /**
     * constructor de la clase personaje
     * 
     */
    public Personaje(){
        posX=0;
        posY=0;
        velocidad=5;
        tamano = 15;
        hp=10;
        
        ataque = false;
        colision=false;
        nom_imagen="";
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
	 * @param imagen sirve para que dicha cadena cadena de texto mande a llamar a la imagen por su nombre
	 * 
	 */
    
    public Personaje(int x, int y, int velocidad, int tamano, int hp,  boolean ataque, boolean colision, String nom_imagen) {
    	this.posX=x;
    	this.posY=y;
    	this.velocidad=velocidad;
    	this.tamano=tamano;
    	this.hp=hp;
    	this.ataque=ataque;
    	this.colision=colision;
    	this.nom_imagen=nom_imagen;
    }
    
    
    
    
    
    public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public int getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}
	
	public int getTamano() {
		return tamano;
	}

	public void setTamano(int tamano) {
		this.tamano = tamano;
	}
	

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public boolean getAtaque() {
		return ataque;
	}

	public void setAtaque(boolean ataque) {
		this.ataque = ataque;
	}

	public boolean getColision() {
		return colision;
	}

	public void setColision(boolean colision) {
		this.colision = colision;
	}

	public String getNom_Imagen() {
		return this.nom_imagen;
	}

	public void setNom_Imagen(String nom_imagen) {
		this.nom_imagen = nom_imagen;
	}

	/**
     * metodo de la clase persnoaje, sirve para generar e imprimir proyectiles
     * @param x, posición en el eje x del plano
     * @param y, posición en el eje y del plano
     * @param perfil, revisa la dirreción hacia la que ve el persoaje
     */
	
	public abstract Bala disparar(int x, int y, int perfil);    //Todos tienen balas ilimitadas por lo que no serÃ¡ necesario 
                                        //implementar colecciones, listas o arreglos
                                        
    
	/**
     * metodo de la clase persnoaje, sirve para mover los personajes hacia la derecha
     */
	public abstract void derecha();     //Todos los personajes avanzan diferente
    
	
	/**
     * metodo de la clase persnoaje, sirve para mover los personajes hacia la derecha
     */
    public abstract void izquierda();     //Todos los personajes avanzan diferente
    
    /**
     * metodo de la clase persnoaje, sirve para mover los personajes hacia la derecha
     */
    public abstract void arriba();
    
    /**
     * metodo de la clase persnoaje, sirve para mover los personajes hacia la derecha
     */
    public abstract void abajo();
    
    /**
     * metodo de la clase persnoaje, sirve para tener conteo de las vidas y en cuanto se acaben, se eleimine el personaje
     */
    public abstract void morir();       //Todos los personajes mueren de forma diferente
    
    
    /**
     * metodo de la clase persnoaje, sirve para pintar a los personajes en el canvas
     * @param g, objeto de la clase Graphics
     */
    public abstract void paint(Graphics g);
}
