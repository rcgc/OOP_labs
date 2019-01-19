
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.ListIterator;

public class Balas {
	private ArrayList<MiBala> lista;
	private boolean bandera;
	
	
	public Balas() {
		lista= new ArrayList<MiBala>(10);
		bandera=false;
	}
	
	
	public void setBandera(boolean b) {
		this.bandera=b;
	}
	
	public boolean getBandera() {
		return this.bandera;
	}
	
	
	public void paint(Graphics g) {
		ListIterator <MiBala>apt= lista.listIterator();		
		
		while(apt.hasNext()) {
			MiBala bala = apt.next();
			bala.paint(g);
			
		}
	}
	
	
	public void agregar(MiBala b) {
		try {
			lista.add(b);
		}catch(Exception e) {
			lista.clear();
		}
		
		
	}
	
	public void avanzar(int x, int y, int alto, int ancho) {
		
		ListIterator <MiBala>apt= lista.listIterator();
		
		try {
			while(apt.hasNext()) {
				MiBala bala = apt.next();
				
				//Si quisieramos imprimir la coordenada de cada bala
				//System.out.println("Bala "+bala.toString());
				
				if(bala.getX()+bala.getTamano()+1>=394-bala.getTamano()) {
					lista.remove(bala);
					bandera=false;
					
				}
				
				else if(bala.getX()+bala.getTamano()+1>=x &&bala.getX()-1<=x+ancho && bala.getY()+bala.getTamano()+1>=y+1 && bala.getY()-1<=y+alto+1) {
					lista.remove(bala);
					bandera=true;
					
				}
				
				else {
					bala.setX(bala.getX()+bala.getVelocidad());
					bandera=false;
					
				}
				
			}
		}catch(Exception e) {
			//Para evitar overflow
			//lista.clear();
			
		}
	}
	
	
	
	
	
	public void avanzar() {
		
		ListIterator <MiBala>apt= lista.listIterator();		
		
		while(apt.hasNext()) {
			MiBala bala = apt.next();
			
			//Si quisieramos imprimir la coordenada de cada bala
			//System.out.println("Bala "+bala.toString());
			
			if(bala.getX()+bala.getTamano()+1>=394-bala.getTamano()) {
				lista.remove(bala);
			}
			
			
			
			else {
				bala.setX(bala.getX()+bala.getVelocidad());
			}
			
		}
	}
	
	public String toString() {
		String msj="";
		ListIterator<MiBala>apt=lista.listIterator();
		
		while(apt.hasNext()) {
			MiBala bala = apt.next();
			
			msj+=bala.toString();
			
			
		}
		
		return msj;
	}
}
