
public class Perros {

	private String raza;
	private int edad;
	private String nombre;
	
	//Constructores (lo que da vida al objeto)
	
	public Perros() {//Debe empezar con mayusculas, este es el constructor default o por omision
					 //Si yo no creo un constructor java lo crea
		
		raza ="";	 //Lo normal es crear un constructor con valores nulos
		edad=0;
		nombre="";
		
	}
	public Perros(String r, int e, String n) {
		raza=r;
		edad=e;
		nombre=n;
	}
	
	//Setter
	public void setRaza(String r) {
		raza=r;
	}
	
	public void setEdad(int e) {
		edad=e;
	}
	
	public void setNombre(String n) {
		nombre=n;
	}
	
	//Getters
	public String getRaza() {
		return raza;
	}
	
	public int getEdad() {
		return edad;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	//Métodos
	public void ladra() {
		System.out.println("Guau guau "+nombre);
	}
	
	public void muevelaCola() {
		System.out.println("Moviendo");
	}
}
