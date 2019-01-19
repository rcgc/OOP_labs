public class Terreno {
	private int noVert;
	private int x[];
	private int y[];
	
	public Terreno() {
		int i;
		noVert=6;
		x=new int [noVert];
		y=new int [noVert];
		for(i=0;i<noVert;i++) {
			x[i]=0;
			y[i]=0;
		}
		
	}
	
	public Terreno(int noVert, int x[], int y[]) {
		int i;
		this.noVert=noVert;
		this.x=new int[this.noVert];  //El orden atributo---paramétro por eso uso this para this.atributo
		this.y=new int [this.noVert];
		for(i=0; i<this.noVert; i++) {
			this.x[i]=x[i];
			this.y[i]=y[i];
		}
	}
	
	public void setNoVert(int noVert) {
		this.noVert=noVert;		
	}
	
	public void setX(int x[]) {
		int i;
									//this.x=x; asigna todo de un sólo golpe
		for(i=0; i<noVert;i++) {
			this.x[i]=x[i];
		}
	}
	
	
	public void setY(int y[]) {
		int i;
		
		for(i=0;i<noVert;i++) {
			this.y[i]=y[i];
		}
	}
	
	
	public int getNoVert() {
		return this.noVert;
	}
	
	public int[] getX() {	//public int[] es lo mismo que []int
		return x;
	}
	
	public int[] getY() {
		return y;
	}
	
	public double area() {
		double t1=0,t2=0;
		int i;
		
		for(i=0;i<noVert-1;i++) {
			t1=t1+(x[i]*y[i+1]);
		}
		t1=t1+(x[noVert-1]*y[0]);
		
		for(i=0;i<noVert-1;i++) {
			t2=t2+(x[i+1]*y[i]);
		}
		t2=t2+(x[0]*y[noVert-1]);
		
		return Math.abs(t1-t2)/2;
	}
	
	
	public String toString() {
		String msg="";
		int i;
		for(i=0; i<noVert; i++) {
			msg=msg+"x["+(i+1)+"]="+x[i]+","+" y["+(i+1)+"]="+y[i]+"\n";
		}
		return "Vértices: "+noVert+"\n"+msg;
	}
	
}
