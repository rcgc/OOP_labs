
public class Alumnos {
	private String nombre;
	private String matricula;
	private String carrera;
	private int semestre;
	private int promedio;
	private String domicilio;
	private char genero;
	private long telefono;
	
	public Alumnos(){
		nombre =" ";
		matricula =" ";
		carrera=" ";
		semestre=0;
		promedio=0;
		domicilio=" ";
		genero=' ';
		telefono= 0;
	}
	
	public Alumnos(String n,String m, String c, int s, int p, String d, char g, long t){
		nombre =n;
		matricula =m;
		carrera=c;
		semestre=s;
		promedio=p;
		domicilio=d;
		genero=g;
		telefono=t;
	}
	
	//Setters
	public void setNombre(String n) {
		nombre=n;
	}
	
	public void setMatricula(String m) {
		matricula=m;
	}
	
	public void setCarrera(String c) {
		carrera=c;
	}
	
	public void setSemestre(int s) {
		semestre=s;
	}
	
	public void setPromedio(int p) {
		promedio =p;
	}
	
	public void setDomicilio(String d) {
		domicilio=d;
	}
	
	public void setGenero(char g) {
		genero=g;
	}
	
	public void setTelefono(long t) {
		telefono=t;
	}
	
	//Getters
	public String getNombre() {
		return nombre;
	}
	
	public String getMatricula() {
		return matricula;
	}
	
	public String getCarrera() {
		return carrera;
	}
	
	public int getSemestre() {
		return semestre;
	}
	
	public int getPromedio() {
		return promedio;
	}
	
	public String getDomicilio() {
		return domicilio;
	}
	
	public char getGenero() {
		return genero;
	}
	
	public long getTelefono() {
		return telefono;
	}
	
	public void incrementarSemestre() {
		semestre++;
	}
	
	public String toString() {
		return "\nNombre: "+nombre+"\nMatricula: "+matricula+"Carrera: "+carrera+
				"\nSemestre:"+semestre+"\nPromedio: "+promedio+"\nDomicilio: "+domicilio+
				"\nGenero: "+genero+"\nTelefono: "+telefono+"\n";
	}
}
