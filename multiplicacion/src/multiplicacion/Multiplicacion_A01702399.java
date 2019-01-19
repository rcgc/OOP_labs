package multiplicacion;
import java.util.Scanner;
public class Multiplicacion_A01702399 {

	public static void main(String args[]) {
		Scanner teclado= new Scanner (System.in);
		int i, acum=0, x, y;
		
		
		System.out.println("Dame el multiplicando: ");
		x=teclado.nextInt();
		teclado.nextLine();
		
		System.out.println("Dame el multiplicador: ");
		y=teclado.nextInt();
		teclado.nextLine();
		
		for(i=1;i<=y;i++) {
			acum=acum+x;
		}
		
		System.out.println(x+"x"+y+"="+acum);
		teclado.close();
	}
}
