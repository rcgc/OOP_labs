package residuo;
import java.util.Scanner;
public class Residuo_A01702388 {
	public static void main (String args[]) {
		
		Scanner teclado= new Scanner (System.in);
		int x,y;
		
		System.out.print("Dame el dividendo: ");
		x=teclado.nextInt();
		teclado.nextLine();
		
		System.out.print("Dame el divisor: ");
		y=teclado.nextInt();
		teclado.nextLine();
		
		System.out.println("Al dividir "+x+"/"+y);
		
		while(x>=y) {
			x=x-y;
		}
		
		System.out.println("El residuo es: "+x);
		
		teclado.close();
	}

}
