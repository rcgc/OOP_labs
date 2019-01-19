

public class Numero {
	private int numero;
	
	public Numero() {
		numero =0;
	}
	
	public Numero(int n) {
		this.numero=n;
	}
	
	
	public void leer() {
		try {
			if(this.numero%2==0) {
				throw new ParException("Numero par");
			}
			
			else {
				throw new ParException("Numero impar");
			}
		}catch(ParException e) {
			System.out.println(e.getMessage());
		}
	}
}
