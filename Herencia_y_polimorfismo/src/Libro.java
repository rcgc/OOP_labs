public class Libro extends Articulo{
	private String autor;
	private int noPaginas;
	
	public Libro() {
		super();
		autor="";
		noPaginas=0;
	}
	
	public Libro(String c, String t, int a, boolean d,String au, int n) {
		super(c,t,a,d);
		autor =au;
		noPaginas=n;
	}
	
	public void setAutor(String au) {
		autor =au;
	}
	
	public void setNoPaginas(int n) {
		noPaginas=n;
	}
	
	public String getAutor() {
		return autor;
	}
	
	public int getNoPaginas() {
		return noPaginas;
	}
	
	public String toString() {
		return super.toString()+ "\nAutor: "+autor+"\nPaginas: "+noPaginas;
	}
	
	public boolean equals (Object obj) {
		// Mismo objeto: Reflexividad
		if(this==obj) {
			return true;
		}

		// No nulo
		if(obj==null) {
			return false;
		}
		
		// Objetos de diferente clase
		if(this.getClass()!=obj.getClass()) {
			return false;
		}
		
		// Cast a un objeto del mismo tipo
		Libro lib=(Libro)obj;
		return ((this.getTitulo().equals(lib.getTitulo())) && (this.autor.equals(lib.autor)));
	}
	
}
