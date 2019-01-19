public class Radio {
	
	private boolean encendido;
	private String color;
	private double tamano;
	private double frecuencia;
	private int volumen; //min 0, max 30
	private int amfm; //1 am, 2 fm
	
	
	public Radio() { //Constructor default -public,la clase-
		
		encendido=false;
		color= "";
		tamano=0;
		frecuencia=0;
		volumen=0;
		amfm=1;
		
	}
	
	public Radio(boolean e, String c, double t, double f, int v, int a) { //Constructor no default
		encendido=e;
		color =c;
		tamano=t;
		frecuencia=f;
		volumen=v;
		amfm=a;
	}

	//Setters
	public void setEncendido(boolean e) { //en los metodos public es la visibilidad con tipo de valor que regresa
			encendido=e;
		}
	
	public void setColor(String c) {
			color=c;
	}
	
	public void setTamano(double t) {
			tamano=t;
	}
	
	public void setAmfm(int a) {
			if (a==1 || a==2) {
				amfm=a;
			}
	}
	
	public void setFrecuencia(int a, double f) {
		if(encendido) { 
			if(amfm==1)  
				if(amfm==1 && f>=540 &&f<=1600) 
					frecuencia=f;
				
				if(amfm==2 && f>88 && f<=108) 
					frecuencia=f;
				
		}
	}
	
	public void setVolumen(int v) {
		if(volumen>=0 && volumen<=30) {
			volumen =v;
		}
	}
	
		
	//Getters
	public boolean getEncendido() {
		return encendido;
	}
	
	public String getColor() {
		return color;
	}
	
	public double getTamano() {
		return tamano;
	}
	
	public int getAmfm() {
		return amfm;
	}
	public double getFrecuencia() {
		return frecuencia;
	}
	
	public int getVolumen() {
		return volumen;
	}
	
	
	public void cambiarEstado() {
		encendido=!encendido;
	}
	
	public void cambiarBanda() {
		if (encendido) {
			if(amfm==1) 
				amfm=2;
			
			else
				amfm=1;
			
		}
	}
	
	public void incrementarFrecuencia() {
		if (encendido) {
			if(amfm==1)
				if (frecuencia+10 <=1600) {
					frecuencia+=10;
				}
			if (amfm==2) {
				if(frecuencia+0.2<=108) {
					frecuencia+=0.2;
				}
			}
		}
	}
	
	public void decrementarFrecuencia() {
		if(encendido) {
			if(amfm==1)
				if(frecuencia-10>=540) {
					frecuencia-=10;
				}
			if (amfm==2) {
				if(frecuencia-0.2>=88) {
					frecuencia-=0.2;
				}
			}
		}
	}
	
	public void incrementarVolumen() {
		if(encendido) {
			if(volumen+1<=30) {
				volumen++;
			}
		}
	}
	
	public void decrementarVolumen() {
		if(encendido) {
			if(volumen-1>=0) {
				volumen--;
			}
		}
	}
}