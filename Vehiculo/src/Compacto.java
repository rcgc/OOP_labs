public class Compacto extends Vehiculo{
	private int tipoCombustible;
	
	public Compacto() {
		super();
		tipoCombustible=1; //1 Gasolina
						   //2 Electrico
	}
	
	public Compacto(String m, String f, double c, double r, double p, int t) {
		super(m,f,c,r,p);
		tipoCombustible=t;
	}
	
	public void setTipoCombustible(int t) {
		tipoCombustible=t;
	}
	
	public int getTipoCombustible() {
		return tipoCombustible;
	}
	
	public double rendimientoTotal() {
		return this.getRendimiento()*this.getCapacidad();
	}
	
	public String toString() {
		
		if(this.tipoCombustible==1) {
			return super.toString()+
					"\nTipo de combustible: Gasolina";
		}
		
		else if(this.tipoCombustible==2) {
			return super.toString()+
					"\nTipo de combustible: Electricidad";
		}
		
		else {
			return super.toString()+
					"\nTipo de combustible: No se sabe";
		}
		
	}
}
