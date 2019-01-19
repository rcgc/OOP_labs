public class Articulo {
	private String codigo;
	private String titulo;
	private int anio;
	private boolean disponible;
	
	
	
	public Articulo(){
		codigo="";
		titulo="";
		anio=0;
		disponible=true;
	}
	
	public Articulo(String c, String t, int a, boolean d){
		codigo=c;
		titulo=t;
		anio=a;
		disponible=d;
	}
	
	public String getCodigo() {
		return codigo;
	}
	
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public int getAnio() {
		return anio;
	}
	
	public void setAnio(int anio) {
		this.anio = anio;
	}
	
	public boolean isDisponible() { //getter, todos los booleanos los pone como is(Boolean)
		return disponible;
	}
	
	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}
	
	public String toString() {
		return "Código: "+codigo+"\nTítulo: "+titulo+"\nAño: "+anio+"\nDisponible: "+disponible;
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
		return this.codigo.equals(art.codigo);
	}
}