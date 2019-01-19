import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.IOException;
import java.io.InputStream;
import java.awt.Image;


import javax.imageio.ImageIO;
import javax.swing.*;


/**
 * Clase Faro sirve para generar la imagen del enemigo, aparte de darle atributos tales como su campo de vision, junto con sus puntos
 * @author Roberto Guzmán
 * @author Rodrigo Gutiérrez
 * la calse item sirve para validar la existencia de algun bono para el personaje principal
 * @version 1.0
 */

public class Item extends Personaje{
    
	
	
	private Random r;
	private BufferedImage image;
	private InputStream imgStream;
	
	private int ancho;
	
    
    
	/**
	 * constructor de item
	 */
    public Item(){
        super();
        r= new Random();
        ancho=0;
        //String nomImagen= this.getImagen();
		
		//File archImagen= new File(nomImagen);
		//try {
			//image=ImageIO.read(archImagen);
		//}catch(IOException e) {
			//e.printStackTrace();
		//}
    }
    
    
    /**
     * cosntructor de item
     * @param x, sirve para encontrar su posicion en x dentro del plano
     * @param y, sirve para encontrar su posicion en y dentro del palno
     * @param velocidad, sirve para detectar a que velocidad se esta moviendo el objeto
     * @param hp, sirve para delimitar la cantidad de daño que puede rescibir antes de destruirse
     * @param colision, sirve para determinar si algun objeto se encuentra sobre este objeto o no
     * @param imagen, sirve para generar una interface grafica del objeto
     */
    
    public Item(int x, int y, int velocidad, int tamano, int ancho, int hp, boolean ataque, boolean colision, String imagen) {
    	super(x, y, velocidad, tamano, hp, ataque, colision, imagen);
    	r= new Random();
    	this.ancho=ancho;
    	
    	
    }
    
    
    /**
     * el metodo dispara genera una nueva instancia para el arreglo de bala
     * @param x, sirve para indicar la posición en x del plano
     * @param y, sirve para indicar la posición en y del plano
     * @param perfil, revisa hacia que dirreción debe ser mandada la bala en caso de ser llamada
     */
    @Override
	public Bala disparar(int x, int y, int perfil) {
		// TODO Auto-generated method stub
		Bala bala = new Bala();
		return bala;
	}
    
    
    
    /**
     * no se utilizo durante la implementación del proyecto
     */
    public void morir(){            //Null porque no realiza dicha accion}
        
    }
    
    /**
     * sirve para desplegar mensaje acerca de los datos del objeto
     */
    public String toString() {
		String msj="";
		
		return msj;
	}
    
    /**
     * este metodo sirve para generar una imagen del objeto
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
		
		g.drawImage(image, this.getPosX(), this.getPosY(), this.getAncho(), this.getTamano(), null);
	}
	
	/**
	 * este metodo sirve para poder generar una imagen de un corazon indicando las vidas
	 */

	
	/**
	 * este metodo sirve para poder generar una imagen de la barra de estado
	 */
	
	public void paint_Letrero(Graphics g) {
		g.setColor(new Color(r.nextInt(255),r.nextInt(255),r.nextInt(255)));
		
		g.setFont(new Font("Comic Sans",Font.BOLD,52));
		
		g.drawString("Congratulations!!!", 180, 180);
	}
	
	/**
	 * este metodo sirve para generar el mensaje de indicadores del personaje, tales como vida, puntaje, etc.
	 * @param g, objeto de la clase Graphics
	 * @param vidas, indica la cantidad de vidas que le quedan al personaje principal
	 * @param puntos, indica el marcador actual del personaje
	 */
	public void paint_Barra(Graphics g, int vidas, int puntos) {
		
		
		
		g.setColor( Color.WHITE);
		
		g.setFont(new Font("Times New Roman",Font.BOLD,18));
		
		g.drawString("Nivel :  1", 15, 18);
		g.drawString(""+vidas, 720, 18);
		if(puntos<10) {
			g.drawString("00000000"+puntos, 335, 18);
		}
		if(puntos>=10 && puntos<100) {
			g.drawString("0000000"+puntos, 335, 18);
		}
		if(puntos>=100 &&puntos<1000) {
			g.drawString("000000"+puntos, 335, 18);
		}
		if(puntos>=1000 &&puntos<10000) {
			g.drawString("00000"+puntos, 335, 18);
		}
		if(puntos>=10000 &&puntos<100000) {
			g.drawString("0000"+puntos, 335, 18);
		}
		if(puntos>=100000 &&puntos<1000000) {
			g.drawString("000"+puntos, 335, 18);
		}
		if(puntos>=1000000 &&puntos<10000000) {
			g.drawString("00"+puntos, 335, 18);
		}
		if(puntos>=10000000 &&puntos<100000000) {
			g.drawString("0"+puntos, 335, 18);
		}
		if(puntos>=100000000 &&puntos<1000000000) {
			g.drawString(""+puntos, 335, 18);
		}
				
		try {

			imgStream= Item.class.getResourceAsStream("images/heart.png");
			image=ImageIO.read(imgStream);
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		g.drawImage(image,695,2, 18, 18, null);
	}
	
	public void setAncho(int ancho) {
		this.ancho=ancho;
	}
	
	public int getAncho() {
		return this.ancho;
	}
	
	/**
	 * revisa sí el usario se desplaza hacia la derecha
	 */
	@Override
    public void derecha(){
    	this.setPosX(this.getPosX()+this.getVelocidad());
    }
	
	/**
	 * revisa sí el usario se desplaza hacia la izquierda
	 */
    @Override
    public void izquierda() {
    	this.setPosX(this.getPosX()-this.getVelocidad());
    }
    
    /**
     * revisa sí el usario se agacha
     */
    @Override
    public void abajo() {
    	
    }
    
    /**
     * revisa sí el usario salta
     */
    @Override
    public void arriba() {
    	
    }
	
    /**
     * esta funcion sirve para generar de modo aleatorio que clase de item aparecera despues de destruir la instancia de la caja
     */
    
    public void random_loot(){           //Número que dependiendo de su rango te desplegará un ítem
    									 //de un poder determinado u otro


		if((r.nextInt(100)+1)%2==0 || (r.nextInt(100)+1)%3==0 || (r.nextInt(100)+1)%5==0 || (r.nextInt(100)+1)%7==0 ) {
		
		}
		
		
		
		else if((r.nextInt(100)+1)%11==0 || (r.nextInt(100)+1)%13==0 || (r.nextInt(100)+1)%17==0 || (r.nextInt(100)+1)%19==0) {
		
		}
		
		
		
		else if((r.nextInt(100)+1)%23==0 || (r.nextInt(100)+1)%29==0 || (r.nextInt(100)+1)%31==0 || (r.nextInt(100)+1)%37==0) {
		
		}
		
		
		
		else if((r.nextInt(100)+1)%41==0 || (r.nextInt(100)+1)%43==0 || (r.nextInt(100)+1)%47==0 || (r.nextInt(100)+1)%53==0) {
		
		}
		
		
		
		else if((r.nextInt(100)+1)%59==0 || (r.nextInt(100)+1)%61==0 || (r.nextInt(100)+1)%67==0 || (r.nextInt(100)+1)%71==0) {
		
		}
		
		
		
		else if((r.nextInt(100)+1)%73==0 || (r.nextInt(100)+1)%79==0 || (r.nextInt(100)+1)%83==0 || (r.nextInt(100)+1)%89==0) {
		
		}
		
		
		
		else if((r.nextInt(100)+1)%97==0) {
		
		}
		
		//Primos menos que 100
		//2, 3, 5, 7, 
		//11,13, 17, 19, 
		//23, 29, 31, 37, 
		//41, 43, 47, 53,
		//59, 61, 67, 71, 
		//73, 79, 83, 89 y 97
		}
	
}