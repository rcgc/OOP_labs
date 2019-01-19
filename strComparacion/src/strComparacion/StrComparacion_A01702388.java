package strComparacion;

import java.util.Scanner;

public class StrComparacion_A01702388 {
	public static void main(String arg[]) {
		Scanner teclado= new Scanner (System.in);

		String s1,s2;
		int n;
		
		System.out.println("Ingresa primera palabra: ");
		s1=teclado.next();
		teclado.nextLine();
		
		System.out.println("Ingresa segunda palabra: ");
		s2=teclado.next();
		teclado.nextLine();
		
		n=s1.compareTo(s2);
		
		if(n==0) {
			System.out.println(s1+" es igual que "+s2);
		}

		else {
				if(n<0) {
				System.out.println(s1+" es menor que "+s2);
				}
			
			else {
				System.out.println(s1+" es mayor que "+s2);
			}
		}
		teclado.close();
	}
}
