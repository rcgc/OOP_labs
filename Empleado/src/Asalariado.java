public class Asalariado extends Empleado { //Asalariado se convierte en una subclase de la clase Empleado
	private double salarioMensual;
	
	public Asalariado() {
		super();//Constructor default de la clase base
		salarioMensual=0;
	}
	
	public Asalariado(String n, int e, String d, long t) {
		super(n,e,d,t);// constructor con parámetros de la clase base (Empleado)
					   //Los parámetros ya deben tener un valor
		
		salarioMensual=0;
	}
	
	public void calculaPago(int dinero) {
		
	}
	
	public void calculaPago(int periodos, int numeroPagos) {
		
	}
	
	public String toString() {
		return super.toString()+"\nSalario: "+salarioMensual;
	}

}
