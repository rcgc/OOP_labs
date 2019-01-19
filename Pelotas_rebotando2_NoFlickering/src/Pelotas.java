import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Random;


public class Pelotas {
	private ArrayList<Pelota>lista;
	private Random r;
	
	
	
	
	public Pelotas() {
		lista=new ArrayList<Pelota>(5);
		r=new Random();
	}
	
	
	public void paint(Graphics g) {
		
		ListIterator<Pelota>apt=lista.listIterator();
		while(apt.hasNext()) {
			
			Pelota bolita = apt.next();
			bolita.paint(g);

			//Si quisieramos imprimir las coordenadas
			//System.out.println(bolita.toString());
		}
	}
	
	
	public void avanzar(int limX, int limY) {
		//Necesitamos iterators
		
		ListIterator<Pelota>apt=lista.listIterator();
		while(apt.hasNext()) {
			Pelota bolita = apt.next();
			
			if(bolita.getDireccionX()==1 && bolita.getDireccionY() ==1) {
				if(bolita.getX()+bolita.getTamano()+1>=297) {
					bolita.setDireccionX(-1);
				}
				
				if(bolita.getY()+bolita.getTamano()+1>=270) {
					bolita.setDireccionY(-1);
				}
				
				else {
					bolita.setX(bolita.getX()+bolita.getDireccionX());
					bolita.setY(bolita.getY()+bolita.getDireccionY());
				}
			}
			
			
			if(bolita.getDireccionX()==1 && bolita.getDireccionY()==-1) {
				if(bolita.getX()+bolita.getTamano()+1>=297) {
					bolita.setDireccionX(-1);
				}
				
				if(bolita.getY()-1<=0) {
					bolita.setDireccionY(1);
				}
				else {
					bolita.setX(bolita.getX()+bolita.getDireccionX());
					bolita.setY(bolita.getY()+bolita.getDireccionY());
				}
			}
			
			
			if(bolita.getDireccionX()==-1 && bolita.getDireccionY()==1) {
				if(bolita.getX()-1<=0) {
					bolita.setDireccionX(1);
				}
				if(bolita.getY()+bolita.getTamano()+1>=270) {
					bolita.setDireccionY(-1);
				}
				
				else {
					bolita.setX(bolita.getX()+bolita.getDireccionX());
					bolita.setY(bolita.getY()+bolita.getDireccionY());
				}
			}
			
			
			if(bolita.getDireccionX()==-1 && bolita.getDireccionY()==-1) {
				if(bolita.getX()-1<=0) {
					bolita.setDireccionX(1);
				}
				
				if(bolita.getY()-1<=0) {
					bolita.setDireccionY(1);
				}
				
				else {
					bolita.setX(bolita.getX()+bolita.getDireccionX());
					bolita.setY(bolita.getY()+bolita.getDireccionY());
				}
			}
			
		}//While
	}
	
	
	public void agregar(int limX, int limY) {
		//Valor absoluto para evitar que me cree una bolita fuera del cuadrante de trabajo
		Pelota p = new Pelota(Math.abs(r.nextInt(limX-23)),Math.abs(r.nextInt(limY-25)),20, new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)),1,1);
		lista.add(p);
		
		
		//Modificar la direccion X and Y en que originalmente viajan
		int a = r.nextInt(2);
		int b = r.nextInt(2);
		
		if(a==0 && b==0) {
			p.setDireccionX(-1);
			p.setDireccionY(-1);
		}
		if(a==0 && b==1) {
			p.setDireccionX(-1);
			p.setDireccionY(1);
		}
		
		if(a==1 && b==1) {
			p.setDireccionX(1);
			p.setDireccionY(1);
		}
		if(a==1 && b==0) {
			p.setDireccionX(1);
			p.setDireccionY(-1);
		}
		
	}
	
	
	
	public String toString() {
		String msj="";
		
		ListIterator<Pelota>apt=lista.listIterator();
		while(apt.hasNext()) {
			Pelota p = apt.next();
			
			msj+=p.toString();
			
		}
		
		return msj;
	}
}
