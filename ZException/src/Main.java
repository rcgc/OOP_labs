import java.util.Scanner;

public class Main {
	public static void main (String[] args) {
		
		Scanner teclado = new Scanner (System.in);
		Numero miNumero;
		int n;
		
		System.out.println("Dame un número");
		n = teclado.nextInt();
		teclado.nextLine();
		
		miNumero=new Numero(n);
		
		miNumero.leer();
		
		teclado.close();
	}
}
