
public class Empleado {
	protected String nombre;
	protected int edad;
	protected String direccion;
	protected long telefono;
	
	public Empleado() {
		nombre = "";
		edad= 18;
		direccion="";
		telefono=1000000000;
	}
	
	
	//Setters
	public Empleado(String n, int e, String d, long t) {
		nombre =n;
		edad = e;
		direccion=d;
		telefono=t;
	}
	
	public void setNombre(String n) {
		nombre=n;
	}
	
	public void setEdad(int e) {
		edad=e;
	}
	
	public void setDireccion(String d) {
		direccion=d;
	}
	
	public void setTelefono(long t) {
		telefono=t;
	}
	
	//Getters
	
	public String getNombre() {
		return nombre;
	}
	
	public int getEdad() {
		return edad;
	}
	
	public String getDireccion() {
		return direccion;
	}
	
	public long getTelefono() {
		return telefono;
	}
	
	public String toString() {
		return "Nombre: "+nombre+"\nEdad: "+edad+"\nDireccion: "+direccion+"\nTelefono: "+telefono;
	}
}
