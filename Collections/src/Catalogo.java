import java.util.ArrayList;
import java.util.ListIterator;
public class Catalogo {
	
	private ArrayList<Articulo>articulos;
	
	public Catalogo() {//Por lo general en listas se crea el catálogo con un constructor default
		articulos = new ArrayList<Articulo>(10);
		
	}
	
	public ArrayList<Articulo> getArticulos(){
		return articulos;
	}
	
	public void setArticulos(ArrayList<Articulo> articulos) {
		this.articulos=articulos;
	}
	
	public void agrega(Articulo art) {
		articulos.add(art);
	}
	
	public void borrar(Articulo art) {
		boolean bandera=false;
		ListIterator<Articulo> apt=articulos.listIterator();
		
		while(apt.hasNext()) {
			Articulo v= apt.next();
			if(v.getId()==art.getId()) {
				apt.remove();
				System.out.println("Eliminado: "+v.getNombre());
				bandera=true;
			}
			if(!bandera) {
				System.out.println("No encontrado");
			}
		}
	}
	
	public int numeroArticulos() {
		return articulos.size();
	}
	
	public double costoTotal() {
		double acum=0;
		ListIterator<Articulo> apt=articulos.listIterator(); //El iterador debe crearse localmente en el método
		
		while(apt.hasNext()) {//El apuntador va cambiando, hasta que apunte a un nulo (nil)
			Articulo art=apt.next();
			acum+=art.getPrecio();
		}	
		return acum;
	}
	
	public String toString() {
		String msj="";
		
		ListIterator<Articulo> itrt=articulos.listIterator();
		
		while(itrt.hasNext()) {
			Articulo art=itrt.next();
			msj+=art.toString()+"\n";
		}
		return msj;
	}
}
