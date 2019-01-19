public class Articulo {
	private int id;
	private String nombre;
	private double precio;
	
	
	
	public Articulo(){
		id=0;
		nombre="";
		precio=0;
	}
	
	public Articulo(int c, String n, double p){
		id=c;
		nombre=n;
		precio=p;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int ide) {
		this.id = ide;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String titulo) {
		this.nombre = titulo;
	}
	
	public double getPrecio() {
		return precio;
	}
	
	public void setPrecio(double p) {
		precio=p;
	}
	
	public String toString() {
		return "\nId: "+id+"\nNombre: "+nombre+"\nPrecio: $"+precio;
	}
	
	public boolean equals(Object obj) {
		// Mismo objeto : Reflexividad
		if(this==obj) {
			return true;
		}
		
		// no Nulo
		if(obj==null) {
			return false;
		}
		
		// objetos de diferente clase
		if(this.getClass()!=obj.getClass()) {
			return false;
		}
		
		// Cast a un objeto del mismo tipo
		Articulo art=(Articulo) obj;
		return this.id==art.id;
	}
}