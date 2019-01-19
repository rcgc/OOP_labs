
public abstract class  Empleado extends Nomina {
	private int id;
	private String nombre;
	
	
	public Empleado() {
		id=0;
		nombre="";
	}
	
	public Empleado(int ide, String n) {
		id=ide;
		nombre=n;
	}
	
	public void setId(int ide) {
		id=ide;
	}
	
	public int getId() {
		return id;
	}
	
	public void setNombre(String n) {
		nombre=n;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public abstract double pagoMensual(); //Este método regresa la suma de el salario de todos los empleados.
	
	
	public String toString() {
		return "\nId: "+this.getId()+"\nNombre: "+this.getNombre();
	}
	
	public boolean equals(Object obj) {
		if(this==obj) {
			return true;
		}
		
		if(obj==null) {
			return false;
		}
		
		if(this.getClass()!= obj.getClass()) {
			return false;
		}
		
		Empleado emp = (Empleado)obj;
		return this.id ==emp.id;
	}
	
}
