package division;
import java.util.Scanner;

public class Division_A01702388 {

	public static void main (String args[]) {
		Scanner teclado=new Scanner(System.in);
		
		int dividendo,x,y,acum=0;
		
		System.out.println("Dame el dividendo: ");
		x=teclado.nextInt();
		teclado.nextLine();
		dividendo=x;
		
		System.out.println("Dame el divisor: ");
		y=teclado.nextInt();
		teclado.nextLine();
		
		if(y==0) {
			System.out.println("No puedes ingresar cero en el divisor");
		}
		
		else {
			while(x>=y) {
				x=x-y;
				acum++;
			}
			System.out.println(dividendo+"/"+y+"="+acum);
		}
		
		teclado.close();
	}
}