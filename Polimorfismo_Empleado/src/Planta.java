
public class Planta extends Empleado{
	private double salario;
	
	
	public Planta() {
		super();
		salario=0;
	}
	
	public Planta(int ide, String n, double s) {
		super(ide,n);
		salario=s;
	}
	
	
	
	public void setSalario(double s) {
		salario=s;
	}
	
	public double getSalario() {
		return salario;
	}
	
	
	public double pagoMensual() {
		return salario;
	}
}
