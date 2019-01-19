
public class Musica extends Articulo{
	private String interprete;
	private String formato;
	
	public Musica() {
		super();
		interprete = "";
		formato= "";
	}
	
	public Musica(String c, String t, int a, boolean d, String i, String f) {
		super(c,t,a,d);
		interprete=i;
		formato=f;
	}
	
	public void setInterprete (String i) {
		interprete = i;
	}
	
	public void setFormato(String f) {
		formato=f;
	}
	
	public String getInterprete() {
		return interprete;
	}
	
	public String getFormato() {
		return formato;
	}
	
	public String toString() {
		
		return super.toString()+"\nInterprete: "+interprete+"\nFormato: "+formato;
	}
	
	public boolean equals(Object obj) {
		if(this==obj) {
			return true;
		}
		
		if(obj==null) {
			return false;
		}
		
		if(this.getClass()!=obj.getClass()) {
			return false;
		}
		
		Musica music =(Musica)obj;
		return (this.getInterprete().equals(music.getInterprete())&&(this.getFormato().equals(music.getFormato())));
	}
}
