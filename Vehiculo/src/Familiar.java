public class Familiar extends Vehiculo{
	private boolean dvd;
	
	
	
	public Familiar(){
		super();
		dvd=false;
	}
	
	public Familiar(String m, String f, double c, double r, double p, boolean d) {
		super(m,f,c,r,p);
		dvd=d;
	}
	
	public void setDvd(boolean d) {
		this.dvd=d;
	}
	
	public boolean getDvd() {
		return this.dvd;
	}
	
	public String toString() {
		return super.toString()+
				"\nDvd: "+this.dvd;
	}
}


