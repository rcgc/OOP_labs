import java.awt.Color;
import java.awt.Graphics;


public class MiObjeto{
	protected int x;
	protected int y;
	protected Color color;
	protected int tamano;
	protected int velocidad;
	
	

	public MiObjeto() {
		x=0;
		y=0;
		color=Color.BLUE;
		tamano=20;
		velocidad=5;
		
	}
	
	public MiObjeto(int x, int y, Color c, int tamano, int vel) {
		this.x=x;
		this.y=y;
		this.color=c;
		this.tamano=tamano;
		this.velocidad=vel;
		
	}
	
	
	
	
	public int getX() {
		return x;
	}




	public void setX(int x) {
		this.x = x;
	}




	public int getY() {
		return y;
	}




	public void setY(int y) {
		this.y = y;
	}




	public Color getColor() {
		return color;
	}




	public void setColor(Color color) {
		this.color = color;
	}




	public int getTamano() {
		return tamano;
	}




	public void setTamano(int tamano) {
		this.tamano = tamano;
	}
	
	public int getVelocidad() {
		return this.velocidad;
	}
	
	public void setVelocidad(int vel) {
		this.velocidad=vel;
	}




	public MiObjeto(int x, int y, Color c, int tamano) {
		this.x=x;
		this.y=y;
		this.color=c;
		this.tamano=tamano;
	}
	
	
	public void paint(Graphics g) {
		g.setColor(color);
		g.fillOval(x, y, tamano, tamano);
	}
	
	
	public void arriba() {
		if(y>0) {
			y-=velocidad;
		}
	}
	
	public void abajo(int limite) {
		
		if(y<limite) {
			y+=velocidad;
		}
		
	}
	
	public void derecha(int limite) {
		if(x<limite) {
			x+=velocidad;
		}
		
	}
	
	public void izquierda() {
		
		if(x>0) {
			x-=velocidad;
		}
		
	}
	
	public MiBala disparar() {
		MiBala bala=new MiBala(this.getX()+this.getTamano(),this.getY()+(this.getTamano()/2)-3, Color.BLACK,6,2);
		return bala;
	}
	
	
	public String toString() {
		String msj="";
		
		msj+=this.getX()+", "+this.getY()+"\n";
		
		return msj;
	}
	
	
		
		
	
	
	
	
}
