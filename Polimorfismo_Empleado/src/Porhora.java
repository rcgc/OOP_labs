
public class Porhora extends Empleado{
	private double horasTrabajadas;
	private double pagoHora;
	
	
	public Porhora() {
		super();
		horasTrabajadas=0;
		pagoHora=0;
	}
	
	public Porhora(int ide, String n, double h, double p) {
		super(ide,n);
		horasTrabajadas=h;
		pagoHora=p;
	}
	
	public void setHorasTrabajadas(double h) {
		horasTrabajadas=h;
	}
	
	public void setPagoHora(double p) {
		pagoHora=p;
	}
	
	public double getHorasTrabajadas() {
		return horasTrabajadas;
	}
	
	public double getPagoHora() {
		return pagoHora;
	}
	
	public double pagoMensual() {	
		return horasTrabajadas*pagoHora*4; //Se multiplica por las 4 semanas de trabajo al mes
	}

}
