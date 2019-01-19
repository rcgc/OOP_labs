public class Vehiculo {
	private String modelo;
	private String fabricante;
	private double capacidad;
	private double rendimiento;
	private double precio;
	
	public Vehiculo() {
		modelo="";
		fabricante="";
		capacidad=0;
		rendimiento=0;
		precio=0;
	}
	
	public Vehiculo(String m, String f, double c, double r, double p) {
		modelo=m;
		fabricante=f;
		capacidad=c;
		rendimiento=r;
		precio=p;
	}
	
	
	
	public void setModelo(String m) {
		this.modelo=m;
	}
	
	public void setFabricante(String f) {
		this.fabricante=f;
	}
	
	public void setCapacidad(double c) {
		this.capacidad=c;
	}
	
	public void setRendimiento(double r) {
		this.rendimiento=r;
	}
	
	public void setPrecio(double p) {
		this.precio=p;
	}
	
	
	
	public String getModelo() {
		return this.modelo;
	}
	
	public String getFabricante() {
		return this.fabricante;
	}
	
	public double getCapacidad() {
		return this.capacidad;
	}
	
	public double getRendimiento() {
		return this.rendimiento;
	}
	
	public double getPrecio() {
		return this.precio;
	}
	
	
	
	public double rendimientoTotal() {
		return rendimiento*capacidad;
	}
	
	public boolean equals(Object obj) {
		
		
		if(this==obj) {
			return true;
		}
		
		
		if(obj==null) {
			return false;
		}
		
		
		if(obj.getClass()!=this.getClass()) {
			return false;
		}
		
		
		Vehiculo v = (Vehiculo)obj;
		return this.modelo.equalsIgnoreCase(v.modelo);
	}
	
	public String toString() {
		return "\nModelo: "+modelo+
				"\nFabricante: "+fabricante+
				"\nCapacidad: "+capacidad+
				"\nRendimiento: "+rendimiento+
				"\nRendimiento total: "+this.rendimientoTotal()+
				"\nPrecio: $"+precio;
	}
}
