
public class Cuenta_Bancaria {
	private long id_cuenta;
	private int pin;
	private String nombre;
	private double saldo;
	private String banco;

	
	public Cuenta_Bancaria() {
		id_cuenta=0;
		pin=0;
		nombre="";
		saldo=0.0;
		banco="";
	}
	
	public Cuenta_Bancaria(long id, int p, String n, double s, String b) {
		id_cuenta=id;
		pin=p;
		nombre=n;
		saldo=s;
		banco=b;
	}

	//Setters
	
	public void setId(long id) {
		id_cuenta=id;
	}
	
	public void setPin(int p) {
		pin=p;
	}
	
	public void setNombre(String n) {
		nombre=n;
	}
	
	public void setBanco(String b) {
		banco=b;
	}
	
	//Getters
	
	public long getId() {
		return id_cuenta;
	}
	
	public int getPin() {
		return pin;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public double getSaldo() {
		return saldo;
	}
	
	
	//Metodos 
	
	public boolean login(long id, int pwd, long id_cuenta, int pin) {
		if(id== id_cuenta && pwd== pin) {
			return true;	
		}
		return false;
	}
	
	public void depositar(double dep) {//Variable y/o parámetro de la función
		saldo+=dep;
		System.out.println("Depósito exitoso de:" +dep);
	}
	
	public void retirar(double ret) {//Variable y/o parámetro de la función
		saldo-=ret;
		System.out.println("Retiro exitoso de:" +ret);
	}
	
	public String toString() {
		return "\nId: "+id_cuenta+"\nCliente: "+nombre+"\nSaldo: "+saldo+"\nInstitución: "+banco;
	}
}
