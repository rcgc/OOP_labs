import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;




/**
 * Clase Faro sirve para generar la imagen del enemigo, aparte de darle atributos tales como su campo de vision, junto con sus puntos
 * @author Roberto Guzmán
 * @author Rodrigo Gutiérrez
 * Clase typhoon sirve para trazar el personaje y darle atributos tales como vida, HP, puntaje, items y movimiento
 * @Version 2.0
 */
public class Typhoon extends Personaje{
	
	
    private int vida;       
    private int puntaje;       //El puntaje acumulado
    private boolean salto;      //Estado de saltando
    private boolean super_mov;  //Estado de super movimiento
    private boolean item;       //Estado de item(s) seleccionado(s)
    
    //private BufferedImage image;
    //private InputStream imgStream;
    
    private Image image;
    private ImageIcon ico;
    
    /**
     * Constructor de la calse Typhoon
     */
    public Typhoon(){
        super();
        vida =5;
        puntaje=0;             //Se puso la "L" para indicar que es tipo long
        salto=false;
        super_mov=false;
        item=false;
    }
    
    
    
    /**
     * constructor de la clase typhoon
     * @param x posicion en X del mapa
     * @param y posicion en Y del mapa
     * @param velocidad, ritmo al que el personaje se va a desplazar en la pantalla
     * @param tamano, tamaño maximo del personaje
     * @param hp, hit points para revisar sí se elimina una vida
     * @param ataque, revisa sí el personaje va a ataquar
     * @param colision, revisa sí el personaje esta colisionando con algun objeto
     * @param imagen, parte grafica del personaje
     * @param visa, limite de veses que puedes morir en el juego
     * @param puntaje, metodo para mantener cuenta de los puntos para obtener nuevas vidas
     * @param salto, revisa sí el personaje va a saltar
     * @param item, revisa la existencai de modificadores en el personaje
     */
    public Typhoon(int x, int y, int velocidad, int tamano, int hp, boolean ataque, boolean colision, String nom_imagen, int vida,
    				int puntaje, boolean salto, boolean super_mov, boolean item) {
    	
    	super(x,y,velocidad,tamano,hp,ataque,colision,nom_imagen);
    	this.vida=vida;
    	this.puntaje=puntaje;
    	this.salto=salto;
    	this.super_mov=super_mov;
    	this.item=item;
    }
    
    public void setVida(int v){
        this.vida=v;
    }
        
    public int getVida(){
        return this.vida;
    }
    
    public void setPuntaje(int p){
        this.puntaje=p;
    }
    
    public int getPuntaje(){
        return this.puntaje;
    }
    
    public void setSalto(boolean s){
        this.salto=s;
    }
    
    public boolean getSalto(){
        return this.salto;
    }
    
    public void setSuper_mov(boolean sm){
        this.super_mov=sm;
    }
    
    public boolean getSuper_mov(){
        return this.super_mov;
    }
    
    public void setItem(boolean i){
        this.item=i;
    }
    
    public boolean getItem(){
        return this.item;
    }
    
    
    /**
     * este metodo se genera una instancia de la bala a disparar
     * @param x, localización del personaje en el eje x del plano
     * @param y, localización del personaje en eje y del plano
     * @param perfil, sirve para revisar hacia que lado ve el personaje
     */
    @Override
	public Bala disparar(int x, int y, int perfil) {
		// TODO Auto-generated method stub
		
    	//int x, int y, int velocidad, int tamano, int hp, boolean ataque, boolean colision, String imagen
    	if(perfil==39) {
    		Bala bala = new Bala(x,y,31,30,0,false,false,"/images/bala_megaman.gif", perfil);
    		return bala;
    	}
    	else {
    		Bala bala = new Bala(x,y,31,30,0,false,false,"/images/bala_megaman2.gif", perfil);
    		return bala;
    	}
    	
	}
    
    /**
     * este metodo no se implemento en la versión final del juego
     */
    public void especial(){
        
    }
    
    /**
     * metodo de la clase Typhoon el cual se encarga de hacer saltar al personaje hasta una maxima altura
     * @param ypiso, posición original de donde salta el personaje
     * @param ancho, ancho del objeto
     * @param perfil, revisar lado al que ve el personaje
     */
    public void saltar(int ypiso, int ancho, int perfil){
                                //FORMULAS DE TIRO PARABOLICO -requiere importar libreria .math de java
                                //Vox=Vo Cos(Theta)
                                //Voy=Vo Sen(Theta)
                                
                                //h-max-= -(Vo)^2/2g
                                
                                //yf=yo+Voy(t)+(g)(t)^2/2
                                //xf=xo+Vox(t)+(g)(t)^2/2
                                
                                // g=-9.8[m/s^2] o g=-32[ft/s^2]
    	
    	int base = this.getPosY();
    	int maxSalto=base;
    	
        while(salto==true) {

            if(this.getPosY()>=290){
                
            	this.setPosY(this.getPosY()-130);    //cambiar por rason de movimiento  	this.getVelocidad()*5        
            	//this.setPosX(this.getPosX()+1); //Con esto se perdería de la pantalla el personaje
            }
            else {
            	this.caer(ypiso, ancho, perfil);
            }
            	
            //this.setPosY(this.getPosY()+this.getVelocidad());
        	
        	salto=false;
                
        }
        //this.setPosY(this.getPosY()+this.getVelocidad());
    	//this.setPosY(this.getPosY()+this.getVelocidad());    //cambiar por rason de movimiento
                    
                //if(colision==true){
                //    this.setY()=this.getY()-this.getVelocidad();    //cambiar por rason de movimiento
                //}    
    }
    
    /**
     * metodo empleado para poder saltar y avanzar simultaneamente
     * @param ypiso, posición previo al salto
     * @param ancho, ancho del objeto
     * @param perfil, dirreción a la que se dirige
     */
    public void salto_parabola(int ypiso, int ancho, int perfil) {
    	
    	if(this.getPosY()>=270){
            
        	this.saltar(ypiso, ancho, perfil);    //cambiar por rason de movimiento		this.getVelocidad()*8        
        
        	if(this.getPosX()<=(360-this.getTamano()/2)) {
        		if(perfil ==39) {
        			this.setPosX(this.getPosX()+this.getVelocidad()*10);
        		}
        		if(perfil==37) {
        			this.setPosX(this.getPosX()-this.getVelocidad()*10);
        		}
        	}
        	//if(this.getPosX()>=4 && perfil == 37) {
        		
        			//this.setPosX(this.getPosX()-this.getVelocidad()*12);
        		
        	//}
        	
        	
        	
        	//this.setPosX(this.getPosX()+this.getVelocidad()); //Con esto se perdería de la pantalla el personaje
        }
        else {
        	this.caer(ypiso, ancho, perfil);
        }
    }
    
    /**
     * este metodo sirve para evitar que los personajes que salten se mantegan en el aire eternamente
     * @param ypiso, pocición original del salto
     * @param ancho, ancho del objeto
     * @param perfil, dirreción a la que se dirige
     */
    public void caer(int ypiso, int ancho, int perfil) {
    	
    	while(this.getPosY()+this.getTamano()<=ypiso) {
    		
    		//if(perfil==37) {//Izq
    			
    			//this.setNom_Imagen("/images/jump2.gif");
    			//this.setPosY(this.getPosY()+2);		//this.getVelocidad()-3
    		//}
    		//if(perfil==39) {//Der
    			
    			//this.setNom_Imagen("/images/jump.gif");
    			this.setPosY(this.getPosY()+2);		//this.getVelocidad()-3
    		//}
    		
    	}
    	
    	//if(perfil==37) {
    		//this.setNom_Imagen("/images/static2.gif");
    	//}
    	
    	//if(perfil==39) {
    		//this.setNom_Imagen("/images/static.gif");
    	//}
    	
    	
    }
    
    /**
     * este metodo sirve para marcar la dirreción de desplazamiento del personaje
     */
    @Override
    public void derecha(){
    	if(this.getPosX()<=(370-this.getTamano()/2)) {
    		this.setPosX(this.getPosX()+this.getVelocidad()/2);
    	}
    	
    }
    
    
    /**
     * este metodo sirve para marcar la dirreción de desplazamiento del personaje
     */
    @Override
    public void izquierda() {
    	if(this.getPosX()>=7) {
    		this.setPosX(this.getPosX()-this.getVelocidad());
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
    
    /**
     * este metodo revisa sí al personaje se le han acabado las vidas y los HP y elimina la instancia
     */
    public void morir(){
        
    }
    
    /**
     * este metodo sirve para generar la imagen del personaje
     * @param g, objeto de la calse Graphics
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
	 * metodo empleado para hacer pruebas
	 * @param g, objeto de la clase Graphics
	 */
	public void paint_ball (Graphics g) {
		g.setColor(Color.WHITE);
		g.fillOval(this.getPosX(), this.getPosY(), this.getTamano(), this.getTamano());
		
	}
	
}