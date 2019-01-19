
public class Pickup extends Vehiculo{
	private double ancho;
	private double largo;
	private double alto;
	private double maxCap;
	
	public Pickup() {
		super();
		ancho=0;
		largo=0;
		alto=0;
		maxCap=0;
	}
	
	public Pickup(String m, String f, double c, double r, double p, double a, double l, double h, double max) {
		super(m,f,c,r,p);
		ancho=a;
		largo=l;
		alto=h;
		maxCap=max;
	}
	
	
	
	public double getAncho() {
		return ancho;
	}

	public void setAncho(double ancho) {
		this.ancho = ancho;
	}

	public double getLargo() {
		return largo;
	}

	public void setLargo(double largo) {
		this.largo = largo;
	}

	public double getAlto() {
		return alto;
	}

	public void setAlto(double alto) {
		this.alto = alto;
	}

	public double getMaxCap() {
		return maxCap;
	}

	public void setMaxCap(double maxCap) {
		this.maxCap = maxCap;
	}
	
	
	
	public double volumen() {
		return ancho*largo*alto;
	}
	
	public double rendimientoTotal(double peso) {
		
		double perdida=this.rendimientoTotal()*this.getCapacidad()*.3;
		
		if(peso>maxCap) {
			return this.rendimientoTotal()*this.getCapacidad()-perdida;
		}
		return this.rendimientoTotal()*this.getCapacidad();
	}
	
	
	public String toString() {
		return super.toString()+
				"\nAncho: "+ancho+
				"\nLargo: "+largo+
				"\nAlto: "+alto+
				"\nVolumen: "+this.volumen();
	}
}
