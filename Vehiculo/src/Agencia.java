import java.util.ArrayList;
import java.util.ListIterator;

public class Agencia {
	private ArrayList<Vehiculo>lista;
	
	
	public Agencia() {
		lista=new ArrayList<Vehiculo>(10);
	}
	
	public void agregarAuto(Vehiculo aut) {
		lista.add(aut);
	}
	
	public void borrarAuto(Vehiculo aut) {
		boolean bandera=false;
		ListIterator<Vehiculo>apt=lista.listIterator();
		
		while(apt.hasNext()) {
			Vehiculo v=apt.next();
			if(v.getModelo().equalsIgnoreCase(aut.getModelo())) {
				apt.remove();
				System.out.println("Eliminado: "+v.getModelo()+"\n");
				bandera=true;
			}
		}
		if(!bandera) {
			System.out.println("No existe: "+aut.getModelo()+"\n");
		}
		
		
	}
	
	public void existencia(String m) {
		int contador=0;
		ListIterator<Vehiculo>apt=lista.listIterator();
		
		while(apt.hasNext()) {
			Vehiculo v=apt.next();
			if(v.getModelo().equalsIgnoreCase(m)) {
				System.out.println(v.toString()+"\n");
				contador++;
			}
		}
		System.out.println("Coincidencias: " +contador+"\n");
	}
	
	public void carrosAdquiribles(double presupuesto) {
		int contador=0;
		ListIterator<Vehiculo>apt=lista.listIterator();	//Deben que crearse localmente
		
		while(apt.hasNext()) {
			Vehiculo aux=apt.next();
			if(aux.getPrecio()<=presupuesto) {
				System.out.println(aux.toString());
				contador++;
			}
		}
		System.out.println("\nOpciones: "+contador+"\n");
		if(contador==0) {
			System.out.println("No hay opciones disponibles para: $"+presupuesto+"\n");
		}
	}
	
	public void mejorRendimiento() {
		int i=0, m=0;
		ListIterator<Vehiculo>apt=lista.listIterator();
		double maxR=0;
		
		Vehiculo aux1=lista.get(0);
		maxR=aux1.rendimientoTotal();
		
		while(apt.hasNext()) {
			Vehiculo aux2=apt.next();
			double rend=aux2.rendimientoTotal();
			if(rend>maxR) {
				m=i;
				maxR=rend;
			}
			i++;
		}
		
		//Obtengo el vehiculo con mayor rendimiento
		Vehiculo mv = lista.get(m);
		System.out.println(mv.toString()+"\n");
	}
	
	public void muestraPickup(double carga) {
		int contador=0;
		int i=1;
		ListIterator<Vehiculo>apt=lista.listIterator();
		double rendT;
		
		while(apt.hasNext()) {
			Vehiculo v=apt.next();
			if(v instanceof Pickup) {
				Pickup t=(Pickup)v;
				rendT=t.rendimientoTotal(carga);
				System.out.println(i+")"+v.toString()+"\nRendimiento con carga: "+rendT+"\n");
				contador++;
				i++;
			}
		}
		System.out.println("\nCoincidencias: " +contador+"\n");
	}
	
	public String toString() {
		int i=1;
		String msj="";
		ListIterator<Vehiculo>apt=lista.listIterator();
		
		while(apt.hasNext()) {
			
			Vehiculo v= apt.next();
			if(v==null) {
				return "Inventario vacío";
			}
			msj+="\n"+i+") "+v.toString()+"\n";
			i++;
		}
		
		return msj;
	}
	
}
